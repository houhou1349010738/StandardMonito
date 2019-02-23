package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/4 0004.
 */
public class EnlistListResponse extends RBResponse{

    /**
     * applyList : {"rows":[{"dsh":1,"id":"a72a420b585511e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-09 00:00:00","noticeStartTime":"2016-08-02 00:00:00","projCode":"shenshan","projName":"幻雪神山","purchaseUnit":"采购部","shtg":0,"shth":0},{"dsh":0,"id":"cc9e2a4357cf11e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-08 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"fei","projName":"我要飞","purchaseUnit":"人力资源部","shtg":0,"shth":0},{"dsh":0,"id":"60af5aeb57b311e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-10-14 00:00:00","noticeStartTime":"2016-08-30 00:00:00","projCode":"ni","projName":"你跑吧","purchaseUnit":"项目管理部","shtg":2,"shth":0},{"dsh":2,"id":"99d96033578b11e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-09-20 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"ceshixiang","projName":"开始测试啦","purchaseUnit":"办公室","shtg":2,"shth":0},{"dsh":3,"id":"56b76532556411e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"wbdsk","projName":"这是一个无比大深坑","purchaseUnit":"采购部","shtg":0,"shth":0},{"dsh":0,"id":"58e09aa64e4d11e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"234","projName":"阿斯蒂芬rrrrrrrrrrr","purchaseUnit":"技术部","shtg":0,"shth":0},{"dsh":0,"id":"71aaeb674e4c11e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"fsdfdsf","projName":"阿斯顿发顺丰","shtg":0,"shth":0},{"dsh":0,"id":"84b40a3b4e4211e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"123123123","projName":"去前面吧，少年","shtg":0,"shth":0},{"dsh":0,"id":"4028ef81537970dd01537978e1d50003","jjbj":0,"noticeEndTime":"2016-07-29 00:00:00","noticeStartTime":"2016-07-22 00:00:00","projCode":"2016-ZC-24-0014-0875","projName":"测试项目33333","purchaseUnit":"客户服务中心","shtg":0,"shth":0}],"total":9}
     */
    private DataEntity data;
    /**
     * data : {"applyList":{"rows":[{"dsh":1,"id":"a72a420b585511e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-09 00:00:00","noticeStartTime":"2016-08-02 00:00:00","projCode":"shenshan","projName":"幻雪神山","purchaseUnit":"采购部","shtg":0,"shth":0},{"dsh":0,"id":"cc9e2a4357cf11e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-08 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"fei","projName":"我要飞","purchaseUnit":"人力资源部","shtg":0,"shth":0},{"dsh":0,"id":"60af5aeb57b311e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-10-14 00:00:00","noticeStartTime":"2016-08-30 00:00:00","projCode":"ni","projName":"你跑吧","purchaseUnit":"项目管理部","shtg":2,"shth":0},{"dsh":2,"id":"99d96033578b11e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-09-20 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"ceshixiang","projName":"开始测试啦","purchaseUnit":"办公室","shtg":2,"shth":0},{"dsh":3,"id":"56b76532556411e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"wbdsk","projName":"这是一个无比大深坑","purchaseUnit":"采购部","shtg":0,"shth":0},{"dsh":0,"id":"58e09aa64e4d11e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"234","projName":"阿斯蒂芬rrrrrrrrrrr","purchaseUnit":"技术部","shtg":0,"shth":0},{"dsh":0,"id":"71aaeb674e4c11e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"fsdfdsf","projName":"阿斯顿发顺丰","shtg":0,"shth":0},{"dsh":0,"id":"84b40a3b4e4211e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"123123123","projName":"去前面吧，少年","shtg":0,"shth":0},{"dsh":0,"id":"4028ef81537970dd01537978e1d50003","jjbj":0,"noticeEndTime":"2016-07-29 00:00:00","noticeStartTime":"2016-07-22 00:00:00","projCode":"2016-ZC-24-0014-0875","projName":"测试项目33333","purchaseUnit":"客户服务中心","shtg":0,"shth":0}],"total":9}}
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
         * rows : [{"dsh":1,"id":"a72a420b585511e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-09 00:00:00","noticeStartTime":"2016-08-02 00:00:00","projCode":"shenshan","projName":"幻雪神山","purchaseUnit":"采购部","shtg":0,"shth":0},{"dsh":0,"id":"cc9e2a4357cf11e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-08 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"fei","projName":"我要飞","purchaseUnit":"人力资源部","shtg":0,"shth":0},{"dsh":0,"id":"60af5aeb57b311e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-10-14 00:00:00","noticeStartTime":"2016-08-30 00:00:00","projCode":"ni","projName":"你跑吧","purchaseUnit":"项目管理部","shtg":2,"shth":0},{"dsh":2,"id":"99d96033578b11e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-09-20 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"ceshixiang","projName":"开始测试啦","purchaseUnit":"办公室","shtg":2,"shth":0},{"dsh":3,"id":"56b76532556411e6aa18000c29030dc2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"wbdsk","projName":"这是一个无比大深坑","purchaseUnit":"采购部","shtg":0,"shth":0},{"dsh":0,"id":"58e09aa64e4d11e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"234","projName":"阿斯蒂芬rrrrrrrrrrr","purchaseUnit":"技术部","shtg":0,"shth":0},{"dsh":0,"id":"71aaeb674e4c11e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"fsdfdsf","projName":"阿斯顿发顺丰","shtg":0,"shth":0},{"dsh":0,"id":"84b40a3b4e4211e6ae160f65cbcda2c2","jjbj":0,"noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"123123123","projName":"去前面吧，少年","shtg":0,"shth":0},{"dsh":0,"id":"4028ef81537970dd01537978e1d50003","jjbj":0,"noticeEndTime":"2016-07-29 00:00:00","noticeStartTime":"2016-07-22 00:00:00","projCode":"2016-ZC-24-0014-0875","projName":"测试项目33333","purchaseUnit":"客户服务中心","shtg":0,"shth":0}]
         * total : 9
         */

        private ApplyListEntity applyList;

        public void setApplyList(ApplyListEntity applyList) {
            this.applyList = applyList;
        }

        public ApplyListEntity getApplyList() {
            return applyList;
        }

        public static class ApplyListEntity {
            private int total;
            /**
             * dsh : 1
             * id : a72a420b585511e6aa18000c29030dc2
             * jjbj : 0
             * noticeEndTime : 2016-08-09 00:00:00
             * noticeStartTime : 2016-08-02 00:00:00
             * projCode : shenshan
             * projName : 幻雪神山
             * purchaseUnit : 采购部
             * shtg : 0
             * shth : 0
             */

            private List<RowsEntity> rows;

            public void setTotal(int total) {
                this.total = total;
            }

            public void setRows(List<RowsEntity> rows) {
                this.rows = rows;
            }

            public int getTotal() {
                return total;
            }

            public List<RowsEntity> getRows() {
                return rows;
            }

            public static class RowsEntity {
                private String dsh;
                private String id;
                private String jjbj;
                private String noticeEndTime;
                private String noticeStartTime;
                private String projCode;
                private String projName;
                private String purchaseUnit;
                private String shtg;
                private String shth;

                public void setDsh(String dsh) {
                    this.dsh = dsh;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public void setJjbj(String jjbj) {
                    this.jjbj = jjbj;
                }

                public void setNoticeEndTime(String noticeEndTime) {
                    this.noticeEndTime = noticeEndTime;
                }

                public void setNoticeStartTime(String noticeStartTime) {
                    this.noticeStartTime = noticeStartTime;
                }

                public void setProjCode(String projCode) {
                    this.projCode = projCode;
                }

                public void setProjName(String projName) {
                    this.projName = projName;
                }

                public void setPurchaseUnit(String purchaseUnit) {
                    this.purchaseUnit = purchaseUnit;
                }

                public void setShtg(String shtg) {
                    this.shtg = shtg;
                }

                public void setShth(String shth) {
                    this.shth = shth;
                }

                public String getDsh() {
                    return dsh;
                }

                public String getId() {
                    return id;
                }

                public String getJjbj() {
                    return jjbj;
                }

                public String getNoticeEndTime() {
                    return noticeEndTime;
                }

                public String getNoticeStartTime() {
                    return noticeStartTime;
                }

                public String getProjCode() {
                    return projCode;
                }

                public String getProjName() {
                    return projName;
                }

                public String getPurchaseUnit() {
                    return purchaseUnit;
                }

                public String getShtg() {
                    return shtg;
                }

                public String getShth() {
                    return shth;
                }
            }
        }
    }
}
