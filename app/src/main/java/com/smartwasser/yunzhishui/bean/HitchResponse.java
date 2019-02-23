package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/5 0005.
 */
public class HitchResponse extends RBResponse{

    /**
     * EqFailure : {"rows":[{"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"aaaaa","failureEdate":"2016-05-24 00:00:00","failureId":"2325622e20ad11e69ffe000c29b2d655","failurePart":"监测","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-06-01 12:00:00\u2014\u20142016-05-24 12:00:00"},{"checkMethod":"5555","equipAscode":"3301010022","equipCode":"00000356","equipLocCodeName":"高碑店污泥","equipName":"7＃二期脱水机冲洗水泵","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"55555","failureEdate":"2016-06-24 00:00:00","failureId":"262c753239ad11e6a45c000c29b2d655","failurePart":"传动","failureReason":"55555","failureRemark":"5555555","failureSdate":"2016-06-21 00:00:00","failureState":0,"failureTbType":"振动","startend":"2016-06-21 12:00:00\u2014\u20142016-06-24 12:00:00"},{"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"aaaa","failureEdate":"2016-05-31 00:00:00","failureId":"37cdef961da311e69ffe000c29b2d655","failureReason":"aaa","failureRemark":"","failureSdate":"2016-05-19 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-05-19 12:00:00\u2014\u20142016-05-31 12:00:00"},{"checkMethod":"12223","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"131233","failureEdate":"2016-06-08 00:00:00","failureId":"3a9a5fc72c5211e69ffe000c29b2d655","failureReason":"13123","failureRemark":"13213","failureSdate":"2016-06-16 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-06-16 12:00:00\u2014\u20142016-06-08 12:00:00"},{"checkMethod":"zzz","equipAscode":"3301090006","equipCode":"00000249","equipLocCodeName":"高碑店污泥","equipName":"管道泵","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"zzzz","failureEdate":"2016-05-23 00:00:00","failureId":"40c44b0c20ad11e69ffe000c29b2d655","failurePart":"输送","failureReason":"zzzz","failureRemark":"","failureSdate":"2016-05-24 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-05-24 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"aaa","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"aaaa","failureEdate":"2016-05-23 00:00:00","failureId":"57bb347a20ad11e69ffe000c29b2d655","failurePart":"输送","failureReason":"llll","failureRemark":"aaaaaa","failureSdate":"2016-05-24 00:00:00","failureState":1,"failureTbType":"腐蚀","startend":"2016-05-24 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"123321","equipAscode":"3301080053","equipCode":"00000267qqqqq","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"123321","failureEdate":"2016-06-03 00:00:00","failureId":"747916a42c5211e69ffe000c29b2d655","failurePart":"其它","failureReason":"123321","failureRemark":"123321","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"振动","startend":"2016-06-01 12:00:00\u2014\u20142016-06-03 12:00:00"},{"checkMethod":"aa","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"aaa","failureEdate":"2016-05-27 00:00:00","failureId":"77c519c3223c11e69ffe000c29b2d655","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-05-25 00:00:00","failureState":0,"failureTbType":"异常声响","startend":"2016-05-25 12:00:00\u2014\u20142016-05-27 12:00:00"},{"checkMethod":"zz","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"zzz","failureEdate":"2016-05-23 00:00:00","failureId":"8c08d40320ae11e69ffe000c29b2d655","failureReason":"zzz","failureRemark":"","failureSdate":"2016-05-19 00:00:00","failureState":1,"failureTbType":"磨损","startend":"2016-05-19 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"测bug","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"测bug","failureEdate":"2016-05-05 00:00:00","failureId":"af51f44e20c511e69ffe000c29b2d655","failurePart":"监测","failureReason":"测bug","failureRemark":"测bug","failureSdate":"2016-05-04 00:00:00","failureState":0,"failureTbType":"磨损","startend":"2016-05-04 12:00:00\u2014\u20142016-05-05 12:00:00"}],"total":14}
     */

    private DataEntity data;
    /**
     * data : {"EqFailure":{"rows":[{"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"aaaaa","failureEdate":"2016-05-24 00:00:00","failureId":"2325622e20ad11e69ffe000c29b2d655","failurePart":"监测","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-06-01 12:00:00\u2014\u20142016-05-24 12:00:00"},{"checkMethod":"5555","equipAscode":"3301010022","equipCode":"00000356","equipLocCodeName":"高碑店污泥","equipName":"7＃二期脱水机冲洗水泵","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"55555","failureEdate":"2016-06-24 00:00:00","failureId":"262c753239ad11e6a45c000c29b2d655","failurePart":"传动","failureReason":"55555","failureRemark":"5555555","failureSdate":"2016-06-21 00:00:00","failureState":0,"failureTbType":"振动","startend":"2016-06-21 12:00:00\u2014\u20142016-06-24 12:00:00"},{"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"aaaa","failureEdate":"2016-05-31 00:00:00","failureId":"37cdef961da311e69ffe000c29b2d655","failureReason":"aaa","failureRemark":"","failureSdate":"2016-05-19 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-05-19 12:00:00\u2014\u20142016-05-31 12:00:00"},{"checkMethod":"12223","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"131233","failureEdate":"2016-06-08 00:00:00","failureId":"3a9a5fc72c5211e69ffe000c29b2d655","failureReason":"13123","failureRemark":"13213","failureSdate":"2016-06-16 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-06-16 12:00:00\u2014\u20142016-06-08 12:00:00"},{"checkMethod":"zzz","equipAscode":"3301090006","equipCode":"00000249","equipLocCodeName":"高碑店污泥","equipName":"管道泵","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"zzzz","failureEdate":"2016-05-23 00:00:00","failureId":"40c44b0c20ad11e69ffe000c29b2d655","failurePart":"输送","failureReason":"zzzz","failureRemark":"","failureSdate":"2016-05-24 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-05-24 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"aaa","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"aaaa","failureEdate":"2016-05-23 00:00:00","failureId":"57bb347a20ad11e69ffe000c29b2d655","failurePart":"输送","failureReason":"llll","failureRemark":"aaaaaa","failureSdate":"2016-05-24 00:00:00","failureState":1,"failureTbType":"腐蚀","startend":"2016-05-24 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"123321","equipAscode":"3301080053","equipCode":"00000267qqqqq","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"123321","failureEdate":"2016-06-03 00:00:00","failureId":"747916a42c5211e69ffe000c29b2d655","failurePart":"其它","failureReason":"123321","failureRemark":"123321","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"振动","startend":"2016-06-01 12:00:00\u2014\u20142016-06-03 12:00:00"},{"checkMethod":"aa","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"aaa","failureEdate":"2016-05-27 00:00:00","failureId":"77c519c3223c11e69ffe000c29b2d655","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-05-25 00:00:00","failureState":0,"failureTbType":"异常声响","startend":"2016-05-25 12:00:00\u2014\u20142016-05-27 12:00:00"},{"checkMethod":"zz","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"zzz","failureEdate":"2016-05-23 00:00:00","failureId":"8c08d40320ae11e69ffe000c29b2d655","failureReason":"zzz","failureRemark":"","failureSdate":"2016-05-19 00:00:00","failureState":1,"failureTbType":"磨损","startend":"2016-05-19 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"测bug","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"测bug","failureEdate":"2016-05-05 00:00:00","failureId":"af51f44e20c511e69ffe000c29b2d655","failurePart":"监测","failureReason":"测bug","failureRemark":"测bug","failureSdate":"2016-05-04 00:00:00","failureState":0,"failureTbType":"磨损","startend":"2016-05-04 12:00:00\u2014\u20142016-05-05 12:00:00"}],"total":14}}
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
         * rows : [{"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"aaaaa","failureEdate":"2016-05-24 00:00:00","failureId":"2325622e20ad11e69ffe000c29b2d655","failurePart":"监测","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-06-01 12:00:00\u2014\u20142016-05-24 12:00:00"},{"checkMethod":"5555","equipAscode":"3301010022","equipCode":"00000356","equipLocCodeName":"高碑店污泥","equipName":"7＃二期脱水机冲洗水泵","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"55555","failureEdate":"2016-06-24 00:00:00","failureId":"262c753239ad11e6a45c000c29b2d655","failurePart":"传动","failureReason":"55555","failureRemark":"5555555","failureSdate":"2016-06-21 00:00:00","failureState":0,"failureTbType":"振动","startend":"2016-06-21 12:00:00\u2014\u20142016-06-24 12:00:00"},{"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"aaaa","failureEdate":"2016-05-31 00:00:00","failureId":"37cdef961da311e69ffe000c29b2d655","failureReason":"aaa","failureRemark":"","failureSdate":"2016-05-19 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-05-19 12:00:00\u2014\u20142016-05-31 12:00:00"},{"checkMethod":"12223","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"131233","failureEdate":"2016-06-08 00:00:00","failureId":"3a9a5fc72c5211e69ffe000c29b2d655","failureReason":"13123","failureRemark":"13213","failureSdate":"2016-06-16 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-06-16 12:00:00\u2014\u20142016-06-08 12:00:00"},{"checkMethod":"zzz","equipAscode":"3301090006","equipCode":"00000249","equipLocCodeName":"高碑店污泥","equipName":"管道泵","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"zzzz","failureEdate":"2016-05-23 00:00:00","failureId":"40c44b0c20ad11e69ffe000c29b2d655","failurePart":"输送","failureReason":"zzzz","failureRemark":"","failureSdate":"2016-05-24 00:00:00","failureState":1,"failureTbType":"渗漏","startend":"2016-05-24 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"aaa","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"aaaa","failureEdate":"2016-05-23 00:00:00","failureId":"57bb347a20ad11e69ffe000c29b2d655","failurePart":"输送","failureReason":"llll","failureRemark":"aaaaaa","failureSdate":"2016-05-24 00:00:00","failureState":1,"failureTbType":"腐蚀","startend":"2016-05-24 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"123321","equipAscode":"3301080053","equipCode":"00000267qqqqq","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"123321","failureEdate":"2016-06-03 00:00:00","failureId":"747916a42c5211e69ffe000c29b2d655","failurePart":"其它","failureReason":"123321","failureRemark":"123321","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"振动","startend":"2016-06-01 12:00:00\u2014\u20142016-06-03 12:00:00"},{"checkMethod":"aa","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"测试bug","failureDeal":"aaa","failureEdate":"2016-05-27 00:00:00","failureId":"77c519c3223c11e69ffe000c29b2d655","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-05-25 00:00:00","failureState":0,"failureTbType":"异常声响","startend":"2016-05-25 12:00:00\u2014\u20142016-05-27 12:00:00"},{"checkMethod":"zz","equipAscode":"3301080054","equipCode":"00000266","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"zzz","failureEdate":"2016-05-23 00:00:00","failureId":"8c08d40320ae11e69ffe000c29b2d655","failureReason":"zzz","failureRemark":"","failureSdate":"2016-05-19 00:00:00","failureState":1,"failureTbType":"磨损","startend":"2016-05-19 12:00:00\u2014\u20142016-05-23 12:00:00"},{"checkMethod":"测bug","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipOwnDept":"高碑店污泥","failureAppear":"齿轮磨损","failureDeal":"测bug","failureEdate":"2016-05-05 00:00:00","failureId":"af51f44e20c511e69ffe000c29b2d655","failurePart":"监测","failureReason":"测bug","failureRemark":"测bug","failureSdate":"2016-05-04 00:00:00","failureState":0,"failureTbType":"磨损","startend":"2016-05-04 12:00:00\u2014\u20142016-05-05 12:00:00"}]
         * total : 14
         */

        private EqFailureEntity EqFailure;

        public void setEqFailure(EqFailureEntity EqFailure) {
            this.EqFailure = EqFailure;
        }

        public EqFailureEntity getEqFailure() {
            return EqFailure;
        }

        public static class EqFailureEntity {
            private int total;
            /**
             * checkMethod : aa
             * equipAscode : 3301080016
             * equipCode : 00000297
             * equipLocCodeName : 高碑店污泥
             * equipOwnDept : 高碑店污泥
             * failureAppear : 轴承磨损
             * failureDeal : aaaaa
             * failureEdate : 2016-05-24 00:00:00
             * failureId : 2325622e20ad11e69ffe000c29b2d655
             * failurePart : 监测
             * failureReason : aaaa
             * failureRemark :
             * failureSdate : 2016-06-01 00:00:00
             * failureState : 1
             * failureTbType : 渗漏
             * startend : 2016-06-01 12:00:00——2016-05-24 12:00:00
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
                private String checkMethod;
                private String equipAscode;
                private String equipCode;
                private String equipLocCodeName;
                private String equipOwnDept;
                private String failureAppear;
                private String failureDeal;
                private String failureEdate;
                private String failureId;
                private String failurePart;
                private String failureReason;
                private String failureRemark;
                private String failureSdate;
                private String failureState;
                private String failureTbType;
                private String startend;
                private String equipName;

                public String getEquipName() {
                    return equipName;
                }

                public void setEquipName(String equipName) {
                    this.equipName = equipName;
                }

                public void setCheckMethod(String checkMethod) {
                    this.checkMethod = checkMethod;
                }

                public void setEquipAscode(String equipAscode) {
                    this.equipAscode = equipAscode;
                }

                public void setEquipCode(String equipCode) {
                    this.equipCode = equipCode;
                }

                public void setEquipLocCodeName(String equipLocCodeName) {
                    this.equipLocCodeName = equipLocCodeName;
                }

                public void setEquipOwnDept(String equipOwnDept) {
                    this.equipOwnDept = equipOwnDept;
                }

                public void setFailureAppear(String failureAppear) {
                    this.failureAppear = failureAppear;
                }

                public void setFailureDeal(String failureDeal) {
                    this.failureDeal = failureDeal;
                }

                public void setFailureEdate(String failureEdate) {
                    this.failureEdate = failureEdate;
                }

                public void setFailureId(String failureId) {
                    this.failureId = failureId;
                }

                public void setFailurePart(String failurePart) {
                    this.failurePart = failurePart;
                }

                public void setFailureReason(String failureReason) {
                    this.failureReason = failureReason;
                }

                public void setFailureRemark(String failureRemark) {
                    this.failureRemark = failureRemark;
                }

                public void setFailureSdate(String failureSdate) {
                    this.failureSdate = failureSdate;
                }

                public void setFailureState(String failureState) {
                    this.failureState = failureState;
                }

                public void setFailureTbType(String failureTbType) {
                    this.failureTbType = failureTbType;
                }

                public void setStartend(String startend) {
                    this.startend = startend;
                }

                public String getCheckMethod() {
                    return checkMethod;
                }

                public String getEquipAscode() {
                    return equipAscode;
                }

                public String getEquipCode() {
                    return equipCode;
                }

                public String getEquipLocCodeName() {
                    return equipLocCodeName;
                }

                public String getEquipOwnDept() {
                    return equipOwnDept;
                }

                public String getFailureAppear() {
                    return failureAppear;
                }

                public String getFailureDeal() {
                    return failureDeal;
                }

                public String getFailureEdate() {
                    return failureEdate;
                }

                public String getFailureId() {
                    return failureId;
                }

                public String getFailurePart() {
                    return failurePart;
                }

                public String getFailureReason() {
                    return failureReason;
                }

                public String getFailureRemark() {
                    return failureRemark;
                }

                public String getFailureSdate() {
                    return failureSdate;
                }

                public String getFailureState() {
                    return failureState;
                }

                public String getFailureTbType() {
                    return failureTbType;
                }

                public String getStartend() {
                    return startend;
                }
            }
        }
    }
}
