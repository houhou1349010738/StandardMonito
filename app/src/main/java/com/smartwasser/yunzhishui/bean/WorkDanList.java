package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/5 0005.
 */
public class WorkDanList extends RBResponse{

    /**
     * EqMaintain : {"rows":[{"maintainCharge":"4","maintainEdate":"2016-07-06 00:00:00","maintainId":"344974d6427711e69bf5000c29b2d655","maintainImpDept":"4","maintainMonth":"05","maintainName":"1","maintainSdate":"2016-07-07 00:00:00","maintainStatus":1},{"maintainCharge":"1","maintainEdate":"2016-06-08 00:00:00","maintainId":"4270818d286f11e69ffe000c29b2d655","maintainImpDept":"1","maintainMonth":"04","maintainName":"1","maintainSdate":"2016-06-08 00:00:00","maintainStatus":3},{"maintainCharge":"11111","maintainEdate":"2016-06-14 00:00:00","maintainId":"44f35edb289c11e69ffe000c29b2d655","maintainImpDept":"1111","maintainMonth":"05","maintainName":"111","maintainSdate":"2016-06-13 00:00:00","maintainStatus":3},{"maintainCharge":"7","maintainEdate":"2016-07-06 00:00:00","maintainId":"7909035a427311e69bf5000c29b2d655","maintainImpDept":"7","maintainMonth":"06","maintainName":"758","maintainSdate":"2016-07-05 00:00:00","maintainStatus":3},{"maintainCharge":"7","maintainEdate":"2016-07-08 00:00:00","maintainId":"800671b9427311e69bf5000c29b2d655","maintainImpDept":"7","maintainMonth":"06","maintainName":"87","maintainSdate":"2016-07-01 00:00:00","maintainStatus":4},{"maintainCharge":"111","maintainEdate":"2016-06-17 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainImpDept":"1111","maintainMonth":"6","maintainName":"保养保养","maintainSdate":"2016-06-10 00:00:00","maintainStatus":3},{"maintainCharge":"8","maintainEdate":"2016-07-05 00:00:00","maintainId":"90a50444427211e69bf5000c29b2d655","maintainImpDept":"8","maintainMonth":"06","maintainName":"89","maintainSdate":"2016-07-05 00:00:00","maintainStatus":3},{"maintainCharge":"yang","maintainEdate":"2016-05-31 00:00:00","maintainId":"940e4daa263311e69ffe000c29b2d655","maintainImpDept":"待定","maintainMonth":"05","maintainName":"水泵维修","maintainSdate":"2016-05-31 00:00:00","maintainStatus":3},{"maintainCharge":"90","maintainEdate":"2016-07-06 00:00:00","maintainId":"96cf62f7425e11e69bf5000c29b2d655","maintainImpDept":"90","maintainMonth":"07","maintainName":"98","maintainSdate":"2016-07-06 00:00:00","maintainStatus":3},{"maintainCharge":"8","maintainEdate":"2016-07-06 00:00:00","maintainId":"96fe3834427211e69bf5000c29b2d655","maintainImpDept":"8","maintainMonth":"06","maintainName":"8","maintainSdate":"2016-07-06 00:00:00","maintainStatus":3}],"total":13}
     */
    private DataEntity data;
    /**
     * data : {"EqMaintain":{"rows":[{"maintainCharge":"4","maintainEdate":"2016-07-06 00:00:00","maintainId":"344974d6427711e69bf5000c29b2d655","maintainImpDept":"4","maintainMonth":"05","maintainName":"1","maintainSdate":"2016-07-07 00:00:00","maintainStatus":1},{"maintainCharge":"1","maintainEdate":"2016-06-08 00:00:00","maintainId":"4270818d286f11e69ffe000c29b2d655","maintainImpDept":"1","maintainMonth":"04","maintainName":"1","maintainSdate":"2016-06-08 00:00:00","maintainStatus":3},{"maintainCharge":"11111","maintainEdate":"2016-06-14 00:00:00","maintainId":"44f35edb289c11e69ffe000c29b2d655","maintainImpDept":"1111","maintainMonth":"05","maintainName":"111","maintainSdate":"2016-06-13 00:00:00","maintainStatus":3},{"maintainCharge":"7","maintainEdate":"2016-07-06 00:00:00","maintainId":"7909035a427311e69bf5000c29b2d655","maintainImpDept":"7","maintainMonth":"06","maintainName":"758","maintainSdate":"2016-07-05 00:00:00","maintainStatus":3},{"maintainCharge":"7","maintainEdate":"2016-07-08 00:00:00","maintainId":"800671b9427311e69bf5000c29b2d655","maintainImpDept":"7","maintainMonth":"06","maintainName":"87","maintainSdate":"2016-07-01 00:00:00","maintainStatus":4},{"maintainCharge":"111","maintainEdate":"2016-06-17 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainImpDept":"1111","maintainMonth":"6","maintainName":"保养保养","maintainSdate":"2016-06-10 00:00:00","maintainStatus":3},{"maintainCharge":"8","maintainEdate":"2016-07-05 00:00:00","maintainId":"90a50444427211e69bf5000c29b2d655","maintainImpDept":"8","maintainMonth":"06","maintainName":"89","maintainSdate":"2016-07-05 00:00:00","maintainStatus":3},{"maintainCharge":"yang","maintainEdate":"2016-05-31 00:00:00","maintainId":"940e4daa263311e69ffe000c29b2d655","maintainImpDept":"待定","maintainMonth":"05","maintainName":"水泵维修","maintainSdate":"2016-05-31 00:00:00","maintainStatus":3},{"maintainCharge":"90","maintainEdate":"2016-07-06 00:00:00","maintainId":"96cf62f7425e11e69bf5000c29b2d655","maintainImpDept":"90","maintainMonth":"07","maintainName":"98","maintainSdate":"2016-07-06 00:00:00","maintainStatus":3},{"maintainCharge":"8","maintainEdate":"2016-07-06 00:00:00","maintainId":"96fe3834427211e69bf5000c29b2d655","maintainImpDept":"8","maintainMonth":"06","maintainName":"8","maintainSdate":"2016-07-06 00:00:00","maintainStatus":3}],"total":13}}
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
         * rows : [{"maintainCharge":"4","maintainEdate":"2016-07-06 00:00:00","maintainId":"344974d6427711e69bf5000c29b2d655","maintainImpDept":"4","maintainMonth":"05","maintainName":"1","maintainSdate":"2016-07-07 00:00:00","maintainStatus":1},{"maintainCharge":"1","maintainEdate":"2016-06-08 00:00:00","maintainId":"4270818d286f11e69ffe000c29b2d655","maintainImpDept":"1","maintainMonth":"04","maintainName":"1","maintainSdate":"2016-06-08 00:00:00","maintainStatus":3},{"maintainCharge":"11111","maintainEdate":"2016-06-14 00:00:00","maintainId":"44f35edb289c11e69ffe000c29b2d655","maintainImpDept":"1111","maintainMonth":"05","maintainName":"111","maintainSdate":"2016-06-13 00:00:00","maintainStatus":3},{"maintainCharge":"7","maintainEdate":"2016-07-06 00:00:00","maintainId":"7909035a427311e69bf5000c29b2d655","maintainImpDept":"7","maintainMonth":"06","maintainName":"758","maintainSdate":"2016-07-05 00:00:00","maintainStatus":3},{"maintainCharge":"7","maintainEdate":"2016-07-08 00:00:00","maintainId":"800671b9427311e69bf5000c29b2d655","maintainImpDept":"7","maintainMonth":"06","maintainName":"87","maintainSdate":"2016-07-01 00:00:00","maintainStatus":4},{"maintainCharge":"111","maintainEdate":"2016-06-17 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainImpDept":"1111","maintainMonth":"6","maintainName":"保养保养","maintainSdate":"2016-06-10 00:00:00","maintainStatus":3},{"maintainCharge":"8","maintainEdate":"2016-07-05 00:00:00","maintainId":"90a50444427211e69bf5000c29b2d655","maintainImpDept":"8","maintainMonth":"06","maintainName":"89","maintainSdate":"2016-07-05 00:00:00","maintainStatus":3},{"maintainCharge":"yang","maintainEdate":"2016-05-31 00:00:00","maintainId":"940e4daa263311e69ffe000c29b2d655","maintainImpDept":"待定","maintainMonth":"05","maintainName":"水泵维修","maintainSdate":"2016-05-31 00:00:00","maintainStatus":3},{"maintainCharge":"90","maintainEdate":"2016-07-06 00:00:00","maintainId":"96cf62f7425e11e69bf5000c29b2d655","maintainImpDept":"90","maintainMonth":"07","maintainName":"98","maintainSdate":"2016-07-06 00:00:00","maintainStatus":3},{"maintainCharge":"8","maintainEdate":"2016-07-06 00:00:00","maintainId":"96fe3834427211e69bf5000c29b2d655","maintainImpDept":"8","maintainMonth":"06","maintainName":"8","maintainSdate":"2016-07-06 00:00:00","maintainStatus":3}]
         * total : 13
         */

        private EqMaintainEntity EqMaintain;

        public void setEqMaintain(EqMaintainEntity EqMaintain) {
            this.EqMaintain = EqMaintain;
        }

        public EqMaintainEntity getEqMaintain() {
            return EqMaintain;
        }

        public static class EqMaintainEntity {
            private int total;
            /**
             * maintainCharge : 4
             * maintainEdate : 2016-07-06 00:00:00
             * maintainId : 344974d6427711e69bf5000c29b2d655
             * maintainImpDept : 4
             * maintainMonth : 05
             * maintainName : 1
             * maintainSdate : 2016-07-07 00:00:00
             * maintainStatus : 1
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
                private String maintainCharge;
                private String maintainEdate;
                private String maintainId;
                private String maintainImpDept;
                private String maintainMonth;
                private String maintainName;
                private String maintainSdate;
                private String maintainStatus;

                public void setMaintainCharge(String maintainCharge) {
                    this.maintainCharge = maintainCharge;
                }

                public void setMaintainEdate(String maintainEdate) {
                    this.maintainEdate = maintainEdate;
                }

                public void setMaintainId(String maintainId) {
                    this.maintainId = maintainId;
                }

                public void setMaintainImpDept(String maintainImpDept) {
                    this.maintainImpDept = maintainImpDept;
                }

                public void setMaintainMonth(String maintainMonth) {
                    this.maintainMonth = maintainMonth;
                }

                public void setMaintainName(String maintainName) {
                    this.maintainName = maintainName;
                }

                public void setMaintainSdate(String maintainSdate) {
                    this.maintainSdate = maintainSdate;
                }

                public void setMaintainStatus(String maintainStatus) {
                    this.maintainStatus = maintainStatus;
                }

                public String getMaintainCharge() {
                    return maintainCharge;
                }

                public String getMaintainEdate() {
                    return maintainEdate;
                }

                public String getMaintainId() {
                    return maintainId;
                }

                public String getMaintainImpDept() {
                    return maintainImpDept;
                }

                public String getMaintainMonth() {
                    return maintainMonth;
                }

                public String getMaintainName() {
                    return maintainName;
                }

                public String getMaintainSdate() {
                    return maintainSdate;
                }

                public String getMaintainStatus() {
                    return maintainStatus;
                }
            }
        }
    }
}
