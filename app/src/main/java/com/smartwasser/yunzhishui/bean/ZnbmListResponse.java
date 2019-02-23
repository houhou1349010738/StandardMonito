package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/28 0028.
 */
public class ZnbmListResponse extends RBResponse{
    /**
     * PayCostClaim : {"rows":[{"CHECK_STATUS":"同意","CLAIMTYPE_ID":"人工费用","CLAIM_DESC":"刘新专用测试_002","CLAIM_ID":"cefebba74bec11e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":204,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"通过","FGLD":"否","FGLDID":"","ID2":"4bda76544bed11e6aa18000c29030dc2","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":"","ZNID2":"163440B45B9847298578F215653B496C"}],"total":6}
     */
    private DataEntity data;
    /**
     * data : {"PayCostClaim":{"rows":[{"CHECK_STATUS":"同意","CLAIMTYPE_ID":"人工费用","CLAIM_DESC":"刘新专用测试_002","CLAIM_ID":"cefebba74bec11e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":204,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"通过","FGLD":"否","FGLDID":"","ID2":"4bda76544bed11e6aa18000c29030dc2","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":"","ZNID2":"163440B45B9847298578F215653B496C"}],"total":6}}
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
         * rows : [{"CHECK_STATUS":"同意","CLAIMTYPE_ID":"人工费用","CLAIM_DESC":"刘新专用测试_002","CLAIM_ID":"cefebba74bec11e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":204,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"通过","FGLD":"否","FGLDID":"","ID2":"4bda76544bed11e6aa18000c29030dc2","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":"","ZNID2":"163440B45B9847298578F215653B496C"}]
         * total : 6
         */

        private PayCostClaimEntity PayCostClaim;

        public void setPayCostClaim(PayCostClaimEntity PayCostClaim) {
            this.PayCostClaim = PayCostClaim;
        }

        public PayCostClaimEntity getPayCostClaim() {
            return PayCostClaim;
        }

        public static class PayCostClaimEntity {
            private int total;
            /**
             * CHECK_STATUS : 同意
             * CLAIMTYPE_ID : 人工费用
             * CLAIM_DESC : 刘新专用测试_002
             * CLAIM_ID : cefebba74bec11e6aa18000c29030dc2
             * CLAIM_REALUSER : 测试用户
             * CLAIM_SUM : 204.0
             * CLAIM_TIME : 2016-06-15
             * CLAIM_USER : root
             * EXAMINE_STATE : 通过
             * FGLD : 否
             * FGLDID :
             * ID2 : 4bda76544bed11e6aa18000c29030dc2
             * IS_CONTRACT : 否
             * SCOPETYPE_ID : ZCBXD
             * UNIT_NAME : 电影城频道项目
             * ZJL : 是
             * ZN : 是
             * ZNID :
             * ZNID2 : 163440B45B9847298578F215653B496C
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
                private String CHECK_STATUS;
                private String CLAIMTYPE_ID;
                private String CLAIM_DESC;
                private String CLAIM_ID;
                private String CLAIM_REALUSER;
                private double CLAIM_SUM;
                private String CLAIM_TIME;
                private String CLAIM_USER;
                private String EXAMINE_STATE;
                private String FGLD;
                private String FGLDID;
                private String ID2;
                private String IS_CONTRACT;
                private String SCOPETYPE_ID;
                private String UNIT_NAME;
                private String ZJL;
                private String ZN;
                private String ZNID;
                private String ZNID2;

                public void setCHECK_STATUS(String CHECK_STATUS) {
                    this.CHECK_STATUS = CHECK_STATUS;
                }

                public void setCLAIMTYPE_ID(String CLAIMTYPE_ID) {
                    this.CLAIMTYPE_ID = CLAIMTYPE_ID;
                }

                public void setCLAIM_DESC(String CLAIM_DESC) {
                    this.CLAIM_DESC = CLAIM_DESC;
                }

                public void setCLAIM_ID(String CLAIM_ID) {
                    this.CLAIM_ID = CLAIM_ID;
                }

                public void setCLAIM_REALUSER(String CLAIM_REALUSER) {
                    this.CLAIM_REALUSER = CLAIM_REALUSER;
                }

                public void setCLAIM_SUM(double CLAIM_SUM) {
                    this.CLAIM_SUM = CLAIM_SUM;
                }

                public void setCLAIM_TIME(String CLAIM_TIME) {
                    this.CLAIM_TIME = CLAIM_TIME;
                }

                public void setCLAIM_USER(String CLAIM_USER) {
                    this.CLAIM_USER = CLAIM_USER;
                }

                public void setEXAMINE_STATE(String EXAMINE_STATE) {
                    this.EXAMINE_STATE = EXAMINE_STATE;
                }

                public void setFGLD(String FGLD) {
                    this.FGLD = FGLD;
                }

                public void setFGLDID(String FGLDID) {
                    this.FGLDID = FGLDID;
                }

                public void setID2(String ID2) {
                    this.ID2 = ID2;
                }

                public void setIS_CONTRACT(String IS_CONTRACT) {
                    this.IS_CONTRACT = IS_CONTRACT;
                }

                public void setSCOPETYPE_ID(String SCOPETYPE_ID) {
                    this.SCOPETYPE_ID = SCOPETYPE_ID;
                }

                public void setUNIT_NAME(String UNIT_NAME) {
                    this.UNIT_NAME = UNIT_NAME;
                }

                public void setZJL(String ZJL) {
                    this.ZJL = ZJL;
                }

                public void setZN(String ZN) {
                    this.ZN = ZN;
                }

                public void setZNID(String ZNID) {
                    this.ZNID = ZNID;
                }

                public void setZNID2(String ZNID2) {
                    this.ZNID2 = ZNID2;
                }

                public String getCHECK_STATUS() {
                    return CHECK_STATUS;
                }

                public String getCLAIMTYPE_ID() {
                    return CLAIMTYPE_ID;
                }

                public String getCLAIM_DESC() {
                    return CLAIM_DESC;
                }

                public String getCLAIM_ID() {
                    return CLAIM_ID;
                }

                public String getCLAIM_REALUSER() {
                    return CLAIM_REALUSER;
                }

                public double getCLAIM_SUM() {
                    return CLAIM_SUM;
                }

                public String getCLAIM_TIME() {
                    return CLAIM_TIME;
                }

                public String getCLAIM_USER() {
                    return CLAIM_USER;
                }

                public String getEXAMINE_STATE() {
                    return EXAMINE_STATE;
                }

                public String getFGLD() {
                    return FGLD;
                }

                public String getFGLDID() {
                    return FGLDID;
                }

                public String getID2() {
                    return ID2;
                }

                public String getIS_CONTRACT() {
                    return IS_CONTRACT;
                }

                public String getSCOPETYPE_ID() {
                    return SCOPETYPE_ID;
                }

                public String getUNIT_NAME() {
                    return UNIT_NAME;
                }

                public String getZJL() {
                    return ZJL;
                }

                public String getZN() {
                    return ZN;
                }

                public String getZNID() {
                    return ZNID;
                }

                public String getZNID2() {
                    return ZNID2;
                }
            }
        }
    }
}
