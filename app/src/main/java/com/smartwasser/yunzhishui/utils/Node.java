package com.smartwasser.yunzhishui.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by huangmengjie on 2016/4/6 0006.
 */
public class Node {
    private String id;
    /**根节点的初始值为0*/
    private  String pid="0";
    /**树的层级*/
    private  int level;
    private String name;
       /**是否展开*/
    private boolean isExpand;
       /**父节点*/
    private Node parent;
    private int icon;
    private List<Node> childre=new ArrayList<Node>();
    public Node()
    {
    }

    public Node(String id,String pId, String name)
    {
        this.id = id;
        this.pid = pId;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getChildre() {
        return childre;
    }

    public void setChildre(List<Node> childre) {
        this.childre = childre;
    }

    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setIsExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if(!isExpand){
          for(Node node:childre){
              node.setIsExpand(false);
          }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return parent==null?0:parent.getLevel()+1;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
       /**是否是根节点*/
    public boolean isRoot(){
        return parent==null;
    }
      /**判断当前节点是否是展开状态*/
    public boolean isParentExpand(){
        if(parent==null){
            return false;
        }
        return parent.isExpand();
    }
    public boolean isleaf(){
        return childre.size()==0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", pid=" + pid +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", isExpand=" + isExpand +
                ", parent=" + parent +
                ", icon=" + icon +
                ", childre=" + childre +
                '}';
    }
}
