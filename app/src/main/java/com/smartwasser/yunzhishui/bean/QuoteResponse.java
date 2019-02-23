package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class QuoteResponse extends RBResponse {

    /**
     * quoteList : {"rows":[{"dsh":0,"dshbj":0,"dshwbj":1,"dshwxbj":0,"dshyxbj":0,"id":"a72a420b585511e6aa18000c29030dc2","noticeEndTime":"2016-08-09 00:00:00","noticeStartTime":"2016-08-02 00:00:00","projCode":"shenshan","projName":"幻雪神山","purchaseUnit":"采购部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"cc9e2a4357cf11e6aa18000c29030dc2","noticeEndTime":"2016-08-08 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"fei","projName":"我要飞","purchaseUnit":"人力资源部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":2,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"60af5aeb57b311e6aa18000c29030dc2","noticeEndTime":"2016-10-14 00:00:00","noticeStartTime":"2016-08-30 00:00:00","projCode":"ni","projName":"你跑吧","purchaseUnit":"项目管理部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":1,"dshwxbj":0,"dshyxbj":1,"id":"99d96033578b11e6aa18000c29030dc2","noticeEndTime":"2016-09-20 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"ceshixiang","projName":"开始测试啦","purchaseUnit":"办公室","wbj":0,"wxbj":0,"yxbj":2},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":1,"dshyxbj":2,"id":"56b76532556411e6aa18000c29030dc2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"wbdsk","projName":"这是一个无比大深坑","purchaseUnit":"采购部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"58e09aa64e4d11e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"234","projName":"阿斯蒂芬rrrrrrrrrrr","purchaseUnit":"技术部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"71aaeb674e4c11e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"fsdfdsf","projName":"阿斯顿发顺丰","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"84b40a3b4e4211e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"123123123","projName":"去前面吧，少年","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"4028ef81537970dd01537978e1d50003","noticeEndTime":"2016-07-29 00:00:00","noticeStartTime":"2016-07-22 00:00:00","projCode":"2016-ZC-24-0014-0875","projName":"测试项目33333","purchaseUnit":"客户服务中心","wbj":0,"wxbj":0,"yxbj":0}],"total":9}
     */

    private DataEntity data;
    /**
     * data : {"quoteList":{"rows":[{"dsh":0,"dshbj":0,"dshwbj":1,"dshwxbj":0,"dshyxbj":0,"id":"a72a420b585511e6aa18000c29030dc2","noticeEndTime":"2016-08-09 00:00:00","noticeStartTime":"2016-08-02 00:00:00","projCode":"shenshan","projName":"幻雪神山","purchaseUnit":"采购部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"cc9e2a4357cf11e6aa18000c29030dc2","noticeEndTime":"2016-08-08 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"fei","projName":"我要飞","purchaseUnit":"人力资源部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":2,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"60af5aeb57b311e6aa18000c29030dc2","noticeEndTime":"2016-10-14 00:00:00","noticeStartTime":"2016-08-30 00:00:00","projCode":"ni","projName":"你跑吧","purchaseUnit":"项目管理部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":1,"dshwxbj":0,"dshyxbj":1,"id":"99d96033578b11e6aa18000c29030dc2","noticeEndTime":"2016-09-20 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"ceshixiang","projName":"开始测试啦","purchaseUnit":"办公室","wbj":0,"wxbj":0,"yxbj":2},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":1,"dshyxbj":2,"id":"56b76532556411e6aa18000c29030dc2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"wbdsk","projName":"这是一个无比大深坑","purchaseUnit":"采购部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"58e09aa64e4d11e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"234","projName":"阿斯蒂芬rrrrrrrrrrr","purchaseUnit":"技术部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"71aaeb674e4c11e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"fsdfdsf","projName":"阿斯顿发顺丰","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"84b40a3b4e4211e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"123123123","projName":"去前面吧，少年","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"4028ef81537970dd01537978e1d50003","noticeEndTime":"2016-07-29 00:00:00","noticeStartTime":"2016-07-22 00:00:00","projCode":"2016-ZC-24-0014-0875","projName":"测试项目33333","purchaseUnit":"客户服务中心","wbj":0,"wxbj":0,"yxbj":0}],"total":9}}
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
         * rows : [{"dsh":0,"dshbj":0,"dshwbj":1,"dshwxbj":0,"dshyxbj":0,"id":"a72a420b585511e6aa18000c29030dc2","noticeEndTime":"2016-08-09 00:00:00","noticeStartTime":"2016-08-02 00:00:00","projCode":"shenshan","projName":"幻雪神山","purchaseUnit":"采购部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"cc9e2a4357cf11e6aa18000c29030dc2","noticeEndTime":"2016-08-08 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"fei","projName":"我要飞","purchaseUnit":"人力资源部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":2,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"60af5aeb57b311e6aa18000c29030dc2","noticeEndTime":"2016-10-14 00:00:00","noticeStartTime":"2016-08-30 00:00:00","projCode":"ni","projName":"你跑吧","purchaseUnit":"项目管理部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":1,"dshwxbj":0,"dshyxbj":1,"id":"99d96033578b11e6aa18000c29030dc2","noticeEndTime":"2016-09-20 00:00:00","noticeStartTime":"2016-08-01 00:00:00","projCode":"ceshixiang","projName":"开始测试啦","purchaseUnit":"办公室","wbj":0,"wxbj":0,"yxbj":2},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":1,"dshyxbj":2,"id":"56b76532556411e6aa18000c29030dc2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"wbdsk","projName":"这是一个无比大深坑","purchaseUnit":"采购部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"58e09aa64e4d11e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"234","projName":"阿斯蒂芬rrrrrrrrrrr","purchaseUnit":"技术部","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"71aaeb674e4c11e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"fsdfdsf","projName":"阿斯顿发顺丰","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"84b40a3b4e4211e6ae160f65cbcda2c2","noticeEndTime":"2016-08-05 00:00:00","noticeStartTime":"2016-07-29 00:00:00","projCode":"123123123","projName":"去前面吧，少年","wbj":0,"wxbj":0,"yxbj":0},{"dsh":0,"dshbj":0,"dshwbj":0,"dshwxbj":0,"dshyxbj":0,"id":"4028ef81537970dd01537978e1d50003","noticeEndTime":"2016-07-29 00:00:00","noticeStartTime":"2016-07-22 00:00:00","projCode":"2016-ZC-24-0014-0875","projName":"测试项目33333","purchaseUnit":"客户服务中心","wbj":0,"wxbj":0,"yxbj":0}]
         * total : 9
         */

        private QuoteListEntity quoteList;

        public void setQuoteList(QuoteListEntity quoteList) {
            this.quoteList = quoteList;
        }

        public QuoteListEntity getQuoteList() {
            return quoteList;
        }

        public static class QuoteListEntity {
            private int total;
            /**
             * dsh : 0
             * dshbj : 0
             * dshwbj : 1
             * dshwxbj : 0
             * dshyxbj : 0
             * id : a72a420b585511e6aa18000c29030dc2
             * noticeEndTime : 2016-08-09 00:00:00
             * noticeStartTime : 2016-08-02 00:00:00
             * projCode : shenshan
             * projName : 幻雪神山
             * purchaseUnit : 采购部
             * wbj : 0
             * wxbj : 0
             * yxbj : 0
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
                private String dshbj;
                private String dshwbj;
                private String dshwxbj;
                private String dshyxbj;
                private String id;
                private String noticeEndTime;
                private String noticeStartTime;
                private String projCode;
                private String projName;
                private String purchaseUnit;
                private String wbj;
                private String wxbj;
                private String yxbj;

                public void setDsh(String dsh) {
                    this.dsh = dsh;
                }

                public void setDshbj(String dshbj) {
                    this.dshbj = dshbj;
                }

                public void setDshwbj(String dshwbj) {
                    this.dshwbj = dshwbj;
                }

                public void setDshwxbj(String dshwxbj) {
                    this.dshwxbj = dshwxbj;
                }

                public void setDshyxbj(String dshyxbj) {
                    this.dshyxbj = dshyxbj;
                }

                public void setId(String id) {
                    this.id = id;
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

                public void setWbj(String wbj) {
                    this.wbj = wbj;
                }

                public void setWxbj(String wxbj) {
                    this.wxbj = wxbj;
                }

                public void setYxbj(String yxbj) {
                    this.yxbj = yxbj;
                }

                public String getDsh() {
                    return dsh;
                }

                public String getDshbj() {
                    return dshbj;
                }

                public String getDshwbj() {
                    return dshwbj;
                }

                public String getDshwxbj() {
                    return dshwxbj;
                }

                public String getDshyxbj() {
                    return dshyxbj;
                }

                public String getId() {
                    return id;
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

                public String getWbj() {
                    return wbj;
                }

                public String getWxbj() {
                    return wxbj;
                }

                public String getYxbj() {
                    return yxbj;
                }
            }
        }
    }
}
