package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/4/6 0006.
 */


import com.smartwasser.yunzhishui.annotation.TreeNodeId;
import com.smartwasser.yunzhishui.annotation.TreeNodeLabel;
import com.smartwasser.yunzhishui.annotation.TreeNodePid;

/**系统类*/
public class FileBean {
       // (type= String.class)
       @TreeNodeId
       private String id;
       @TreeNodePid
       private String pid;
       @TreeNodeLabel
       private String lable;

       private String desc;

       public FileBean(String id,String pId, String label)
       {
           this.id = id;
           this.pid = pId;
           this.lable = label;
       }

       public String getId() {
           return id;
       }
       public void setId(String id) {
           this.id = id;
       }
       public String getPid() {
           return pid;
       }
       public void setPid(String pid) {
           this.pid = pid;
       }
       public String getLable() {
           return lable;
       }
       public void setLable(String lable) {
           this.lable = lable;
       }
       public String getDesc() {
           return desc;
       }
       public void setDesc(String desc) {
           this.desc = desc;
       }
   }
