package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/6 0006.
 */
public class EquipTypeResponse extends RBResponse{
    private DataEntity data;
    /**
     * data : {"listTree":[{"typeCode":"1","typeFlag":1,"typeName":"设备类别","typeParentCode":"-1"},{"typeCode":"11","typeFlag":0,"typeLeaf":0,"typeMeterUnit":"平方","typeName":"房屋","typeOrder":1,"typeParentCode":"1"},{"typeCode":"402836814c6da5b0014c6dc8e0f90001","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"","typeName":"电气设备","typeParentCode":"1"},{"typeCode":"402836814c6da5b0014c6dc95f9c0002","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"","typeName":"机械设备","typeParentCode":"1"},{"typeCode":"402836814c6da5b0014c6dc99c600003","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"","typeName":"仪表设备","typeParentCode":"1"},{"typeCode":"402836814c6e7f2a014c6e809d470000","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"进水泵房","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6e80d2340001","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"格栅间","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6e820ffb0002","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"曝气沉沙池","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6e82455c0003","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"aaa","typeName":"初沉池","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6e827e7d0004","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"二沉池","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6e82e2260005","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"曝气池","typeOrder":1,"typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6e830f100006","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"氧化沟","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6ea2ac200007","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"生物池","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6ea3186a0008","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"鼓风机房","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6ea3a0b50009","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"回流泵房","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6ea3c90e000a","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"脱水机房","typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"402836814c6e7f2a014c6eabb750000b","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"变电室","typeParentCode":"402836814c6da5b0014c6dc8e0f90001"},{"typeCode":"402836814c6e7f2a014c6eabee9d000c","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"配电室","typeParentCode":"402836814c6da5b0014c6dc8e0f90001"},{"typeCode":"402836814c6e7f2a014c6eac47ba000d","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"电器柜","typeParentCode":"402836814c6da5b0014c6dc8e0f90001"},{"typeCode":"402836814c6e7f2a014c6eac9f1c000e","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"自控系统","typeParentCode":"402836814c6da5b0014c6dc8e0f90001"},{"typeCode":"402836814c6e7f2a014c6eadab63000f","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"监控系统","typeParentCode":"402836814c6da5b0014c6dc8e0f90001"},{"typeCode":"402836814c6e7f2a014c6eadccce0010","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"配电附件","typeParentCode":"402836814c6da5b0014c6dc8e0f90001"},{"typeCode":"402836814c6e7f2a014c6eaeab050011","typeFlag":0,"typeMeterUnit":"台","typeName":"水泵","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c6e7f2a014c6eaf24b40012","typeFlag":0,"typeMeterUnit":"台","typeName":"泥泵","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c6e7f2a014c6eb00e290013","typeFlag":0,"typeLeaf":1,"typeMeterUnit":"","typeName":"药泵","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c6e7f2a014c6eb199260014","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"台","typeName":"水泵","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c6e7f2a014c6eb1ef890015","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"台","typeName":"泥泵","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c6e7f2a014c6eb21ced0016","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"台","typeName":"药泵","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72c6a55d0000","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"台","typeName":"搅拌器","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72d5f4d80001","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"台","typeName":"水处理设备","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72d675b60002","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"架","typeName":"起重升降机","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72d77e220003","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"台","typeName":"风机","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72d7f88f0004","typeFlag":0,"typeMeterUnit":"套","typeName":"闸阀","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72d9b98b0005","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"套","typeName":"闸阀","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72da41ef0006","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"套","typeName":"辅助设备","typeParentCode":"402836814c6da5b0014c6dc95f9c0002"},{"typeCode":"402836814c72c0d8014c72dd472d0007","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"个","typeName":"水质仪表","typeParentCode":"402836814c6da5b0014c6dc99c600003"},{"typeCode":"402836814c72c0d8014c72dd8f080008","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"个","typeName":"流量仪表","typeParentCode":"402836814c6da5b0014c6dc99c600003"},{"typeCode":"402836814c72c0d8014c72ddb2cd0009","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"","typeName":"压力仪表","typeParentCode":"402836814c6da5b0014c6dc99c600003"},{"typeCode":"402836814c72c0d8014c72dde8f1000a","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"个","typeName":"液位仪表","typeParentCode":"402836814c6da5b0014c6dc99c600003"},{"typeCode":"402836814c72c0d8014c72de1ae4000b","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"个","typeName":"温度仪表","typeParentCode":"402836814c6da5b0014c6dc99c600003"},{"typeCode":"402836814c72c0d8014c72ded9c5000c","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"个","typeName":"光学仪表","typeParentCode":"402836814c6da5b0014c6dc99c600003"},{"typeCode":"402836814c72c0d8014c72df04ed000d","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"个","typeName":"其余仪表","typeOrder":0,"typeParentCode":"402836814c6da5b0014c6dc99c600003"},{"typeCode":"402881883fb6dbb4013fb84c31f70002","typeFlag":1,"typeLeaf":1,"typeMeterUnit":"12323","typeName":"123","typeParentCode":"402881883fb6dbb4013fb84338d90001"},{"typeCode":"402881883fb6dbb4013fb84f07900003","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"安抚","typeName":"23123","typeParentCode":"402881883fb6dbb4013fb84338d90001"},{"typeCode":"402881883fb6dbb4013fb84f994b0004","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"123","typeName":"123","typeParentCode":"402881883fb6dbb4013fb84338d90001"},{"typeCode":"402881883fb6dbb4013fb859aa8e000b","typeFlag":0,"typeLeaf":0,"typeMeterUnit":"112312311","typeName":"飞凤飞飞反复","typeParentCode":"11"},{"typeCode":"402881883fb6dbb4013fb86329b0000c","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"算得上是","typeName":"啊啊啊","typeParentCode":"402881883fb6dbb4013fb84338d90001"},{"typeCode":"402881883fb6dbb4013fb863a2ed000d","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"按时","typeName":"保存","typeParentCode":"402881883fb6dbb4013fb84338d90001"},{"typeCode":"402881883fb6dbb4013fb86535a0000e","typeFlag":1,"typeLeaf":0,"typeMeterUnit":"abc","typeName":"abc","typeParentCode":"402881883fb6dbb4013fb84338d90001"},{"typeCode":"402881e442d6511d0142d66408770000","typeFlag":1,"typeMeterUnit":"","typeName":"设施构筑物","typeParentCode":"1"},{"typeCode":"738866081d7511e69ffe000c29b2d655","typeFlag":1,"typeMeterUnit":"m","typeName":"测试","typeOrder":1,"typeParentCode":"402881e442d6511d0142d66408770000"},{"typeCode":"a7e03c571d7711e69ffe000c29b2d655","typeFlag":1,"typeMeterUnit":"q","typeName":"q","typeOrder":1,"typeParentCode":"ad1fcb651d7511e69ffe000c29b2d655"},{"typeCode":"ad1fcb651d7511e69ffe000c29b2d655","typeFlag":1,"typeMeterUnit":"m","typeName":"测试1","typeOrder":1,"typeParentCode":"1"},{"typeCode":"b295026d1d7711e69ffe000c29b2d655","typeFlag":1,"typeMeterUnit":"d","typeName":"d","typeOrder":3,"typeParentCode":"ad1fcb651d7511e69ffe000c29b2d655"},{"typeCode":"b850044b1d7711e69ffe000c29b2d655","typeFlag":1,"typeMeterUnit":"g","typeName":"g","typeOrder":2,"typeParentCode":"ad1fcb651d7511e69ffe000c29b2d655"},{"typeCode":"d91434091d7711e69ffe000c29b2d655","typeFlag":1,"typeMeterUnit":"c","typeName":"c","typeOrder":7,"typeParentCode":"ad1fcb651d7511e69ffe000c29b2d655"}]}
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;

    public void setData(DataEntity data) {
        this.data = data;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static class DataEntity {
        /**
         * typeCode : 1
         * typeFlag : 1
         * typeName : 设备类别
         * typeParentCode : -1
         */

        private List<ListTreeEntity> listTree;

        public void setListTree(List<ListTreeEntity> listTree) {
            this.listTree = listTree;
        }

        public List<ListTreeEntity> getListTree() {
            return listTree;
        }

        public static class ListTreeEntity {
            private String typeCode;
            private int typeFlag;
            private String typeName;
            private String typeParentCode;

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }

            public void setTypeFlag(int typeFlag) {
                this.typeFlag = typeFlag;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public void setTypeParentCode(String typeParentCode) {
                this.typeParentCode = typeParentCode;
            }

            public String getTypeCode() {
                return typeCode;
            }

            public int getTypeFlag() {
                return typeFlag;
            }

            public String getTypeName() {
                return typeName;
            }

            public String getTypeParentCode() {
                return typeParentCode;
            }
        }
    }
}
