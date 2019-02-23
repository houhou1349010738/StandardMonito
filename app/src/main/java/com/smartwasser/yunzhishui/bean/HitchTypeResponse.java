package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/6 0006.
 */
public class HitchTypeResponse extends RBResponse{

    private DataEntity data;
    /**
     * data : {"listTree":[{"eqTypeCode":"01","id":"1","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"故障类别","tbTypeParentCode":"-1"},{"eqTypeCode":"01","id":"402881e44c797e4b014c7df2fccd004f","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"振动","tbTypeParentCode":"1"},{"eqTypeCode":"02","id":"402881e44c797e4b014c7df5126f0050","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"磨损","tbTypeParentCode":"1"},{"eqTypeCode":"03","id":"402881e44c797e4b014c7df543810051","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"异常声响","tbTypeParentCode":"1"},{"eqTypeCode":"04","id":"402881e44c797e4b014c7df574840052","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"腐蚀","tbTypeParentCode":"1"},{"eqTypeCode":"05","id":"402881e44c797e4b014c7df5cae10053","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"渗漏","tbTypeParentCode":"1"},{"eqTypeCode":"06","id":"402881e44c797e4b014c7df6001a0054","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"裂纹","tbTypeParentCode":"1"},{"eqTypeCode":"07","id":"402881e44c797e4b014c7df62e7d0055","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"疲劳","tbTypeParentCode":"1"},{"eqTypeCode":"09","id":"402881e44c797e4b014c7df6917d0057","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"油质劣化","tbTypeParentCode":"1"},{"eqTypeCode":"10","id":"402881e44c797e4b014c7df6ce760058","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"材质劣化","tbTypeParentCode":"1"},{"eqTypeCode":"11","id":"402881e44c797e4b014c7df712c30059","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"松驰","tbTypeParentCode":"1","typeName":"房屋"},{"eqTypeCode":"12","id":"402881e44c797e4b014c7df78e4c005a","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"异常温度","tbTypeParentCode":"1"},{"eqTypeCode":"13","id":"402881e44c797e4b014c7df85bcd005b","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"堵塞","tbTypeParentCode":"1"},{"eqTypeCode":"14","id":"402881e44c797e4b014c7df892db005c","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"剥离","tbTypeOrder":2,"tbTypeParentCode":"1"},{"eqTypeCode":"16","id":"402881e44c797e4b014c7df8db8c005d","tbTypeFlag":2,"tbTypeLeaf":1,"tbTypeName":"电气故障11","tbTypeParentCode":"1"},{"eqTypeCode":"15","id":"402881e44c7e36a2014c7e4a232a0005","tbTypeFlag":1,"tbTypeLeaf":1,"tbTypeName":"其他","tbTypeParentCode":"1"},{"eqTypeCode":"122","id":"98520f042c5511e69ffe000c29b2d655","tbTypeFlag":2,"tbTypeName":"测试2","tbTypeOrder":1,"tbTypeParentCode":"1"},{"eqTypeCode":"123","id":"c598fd311da711e69ffe000c29b2d655","tbTypeFlag":1,"tbTypeName":"测试","tbTypeOrder":1,"tbTypeParentCode":"1"},{"eqTypeCode":"112","id":"d722d9851da711e69ffe000c29b2d655","tbTypeFlag":1,"tbTypeName":"测试","tbTypeOrder":2,"tbTypeParentCode":"1"}]}
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
         * eqTypeCode : 01
         * id : 1
         * tbTypeFlag : 1
         * tbTypeLeaf : 1
         * tbTypeName : 故障类别
         * tbTypeParentCode : -1
         */

        private List<ListTreeEntity> listTree;

        public void setListTree(List<ListTreeEntity> listTree) {
            this.listTree = listTree;
        }

        public List<ListTreeEntity> getListTree() {
            return listTree;
        }

        public static class ListTreeEntity {
            private String eqTypeCode;
            private String id;
            private int tbTypeFlag;
            private int tbTypeLeaf;
            private String tbTypeName;
            private String tbTypeParentCode;

            public void setEqTypeCode(String eqTypeCode) {
                this.eqTypeCode = eqTypeCode;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setTbTypeFlag(int tbTypeFlag) {
                this.tbTypeFlag = tbTypeFlag;
            }

            public void setTbTypeLeaf(int tbTypeLeaf) {
                this.tbTypeLeaf = tbTypeLeaf;
            }

            public void setTbTypeName(String tbTypeName) {
                this.tbTypeName = tbTypeName;
            }

            public void setTbTypeParentCode(String tbTypeParentCode) {
                this.tbTypeParentCode = tbTypeParentCode;
            }

            public String getEqTypeCode() {
                return eqTypeCode;
            }

            public String getId() {
                return id;
            }

            public int getTbTypeFlag() {
                return tbTypeFlag;
            }

            public int getTbTypeLeaf() {
                return tbTypeLeaf;
            }

            public String getTbTypeName() {
                return tbTypeName;
            }

            public String getTbTypeParentCode() {
                return tbTypeParentCode;
            }
        }
    }
}
