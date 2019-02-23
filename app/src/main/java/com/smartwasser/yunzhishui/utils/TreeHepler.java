package com.smartwasser.yunzhishui.utils;
import android.util.Log;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.annotation.TreeNodeId;
import com.smartwasser.yunzhishui.annotation.TreeNodeLabel;
import com.smartwasser.yunzhishui.annotation.TreeNodePid;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by huangmengjie on 2016/4/6 0006.
 */
   /**将用户数据转换成树形数据*/
public class TreeHepler {
    public static<T>List<Node> convertDatas2Nodes(List<T> datas)
        throws IllegalArgumentException, IllegalAccessException
        {
            List<Node> nodes = new ArrayList<Node>();
            Node node =null;
            for (T t : datas) {
                String id = null;
                String pid =null;
                String label = null;
                node = new Node();
                Class clazz = t.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.getAnnotation(TreeNodeId.class) != null) {
                        field.setAccessible(true);
                        id =(String)field.get(t);
                    }
                    if (field.getAnnotation(TreeNodePid.class) != null) {
                        field.setAccessible(true);
                        pid =(String)field.get(t);
                    }
                    if (field.getAnnotation(TreeNodeLabel.class) != null) {
                        field.setAccessible(true);
                        label = (String) field.get(t);
                    }
                }
                node = new Node(id, pid, label);
                nodes.add(node);
            }// for end

            Log.e("TAG", nodes + "");

            /**
             * 设置Node间的节点关系
             */
            for (int i = 0; i < nodes.size(); i++) {
                Node n = nodes.get(i);

                for (int j = i + 1; j < nodes.size(); j++) {
                    Node m = nodes.get(j);
                    if (m.getPid().equals(n.getId())) {
                        n.getChildre().add(m);
                        m.setParent(n);
                    } else if (m.getId().equals(n.getPid())) {
                        m.getChildre().add(n);
                        n.setParent(m);
                    }
                }
            }
            for (Node n : nodes) {
                setNodeIcon(n);
            }
            return nodes;
        }
        public static <T> List<Node> getSortedNodes (List < T > datas,
        int defaultExpandLevel)throws IllegalArgumentException,
                IllegalAccessException
        {
            List<Node> result = new ArrayList<Node>();
            List<Node> nodes = convertDatas2Nodes(datas);
            // 获得树的根结点
            List<Node> rootNodes = getRootNodes(nodes);
            for (Node node : rootNodes) {
                addNode(result, node, defaultExpandLevel, 1);
            }
            Log.e("TAG", result.size() + "");
            return result;
        }

        /**
         * 把一个节点的所有孩子节点都放入result
         *
         * @param result
         * @param node
         * @param defaultExpandLevel
         * @param
         */
       private static void addNode(List<Node> result, Node node,
                                   int defaultExpandLevel, int currentLevel) {
           result.add(node);
           if (defaultExpandLevel >= currentLevel) {
               node.setIsExpand(true);
           }
           if (node.isleaf())
               return;
           for (int i = 0; i < node.getChildre().size(); i++) {
               addNode(result, node.getChildre().get(i), defaultExpandLevel,
                       currentLevel + 1);
           }

       }

       /**
        * 过滤出可见的节点
        *
        * @param nodes
        * @return
        */
       public static List<Node> filterVisibleNodes(List<Node> nodes) {
           List<Node> result = new ArrayList<Node>();

           for (Node node : nodes) {
               if (node.isRoot() || node.isParentExpand()) {
                   setNodeIcon(node);
                   result.add(node);
               }
           }
           return result;
       }

       /**
        * 从所有节点中过滤出根节点
        *
        * @param nodes
        * @return
        */
       private static List<Node> getRootNodes(List<Node> nodes) {
           List<Node> root = new ArrayList<Node>();
           for (Node node : nodes) {
               if (node.isRoot()) {
                   root.add(node);
               }
           }
           return root;
       }

       /**
        * 为Node设置图标
        *
        * @param n
        */
       private static void setNodeIcon(Node n) {
           if(n.getChildre().size() >0&&!n.isExpand()) {
               n.setIcon(R.drawable.menu_next);
           }else if (n.getChildre().size() > 0&&n.isExpand()) {
               n.setIcon(R.drawable.xiang);
           } else {
               n.setIcon(-1);
           }
       }
   }

