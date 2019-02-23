package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class ReimbursementResponse extends RBResponse {
    /**
     * PayCostClaim : {"rows":[{"CLAIMTYPE_ID":"收入预算","CLAIM_DESC":"刘新专用测试_001","CLAIM_ID":"10866b504be111e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":200,"CLAIM_TIME":"2016-06-14","CLAIM_USER":"root","EXAMINE_STATE":"分管领导审核","FGLD":"是","FGLDID":"136973231857805076053","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":"F7EE859577AD478FABD326FA76779E0C"},{"CLAIMTYPE_ID":"人工费用","CLAIM_DESC":"刘新专用测试_002","CLAIM_ID":"cefebba74bec11e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":204,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"通过","FGLD":"否","FGLDID":"","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":""},{"CLAIMTYPE_ID":"收入预算","CLAIM_DESC":"223","CLAIM_ID":"e43cec454ce211e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":23.46,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"项目经理审核","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目"}],"total":3}
     */
    private DataEntity data;
    /**
     * data : {"PayCostClaim":{"rows":[{"CLAIMTYPE_ID":"收入预算","CLAIM_DESC":"刘新专用测试_001","CLAIM_ID":"10866b504be111e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":200,"CLAIM_TIME":"2016-06-14","CLAIM_USER":"root","EXAMINE_STATE":"分管领导审核","FGLD":"是","FGLDID":"136973231857805076053","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":"F7EE859577AD478FABD326FA76779E0C"},{"CLAIMTYPE_ID":"人工费用","CLAIM_DESC":"刘新专用测试_002","CLAIM_ID":"cefebba74bec11e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":204,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"通过","FGLD":"否","FGLDID":"","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":""},{"CLAIMTYPE_ID":"收入预算","CLAIM_DESC":"223","CLAIM_ID":"e43cec454ce211e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":23.46,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"项目经理审核","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目"}],"total":3}}
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
         * rows : [{"CLAIMTYPE_ID":"收入预算","CLAIM_DESC":"刘新专用测试_001","CLAIM_ID":"10866b504be111e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":200,"CLAIM_TIME":"2016-06-14","CLAIM_USER":"root","EXAMINE_STATE":"分管领导审核","FGLD":"是","FGLDID":"136973231857805076053","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":"F7EE859577AD478FABD326FA76779E0C"},{"CLAIMTYPE_ID":"人工费用","CLAIM_DESC":"刘新专用测试_002","CLAIM_ID":"cefebba74bec11e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":204,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"通过","FGLD":"否","FGLDID":"","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目","ZJL":"是","ZN":"是","ZNID":""},{"CLAIMTYPE_ID":"收入预算","CLAIM_DESC":"223","CLAIM_ID":"e43cec454ce211e6aa18000c29030dc2","CLAIM_REALUSER":"测试用户","CLAIM_SUM":23.46,"CLAIM_TIME":"2016-06-15","CLAIM_USER":"root","EXAMINE_STATE":"项目经理审核","IS_CONTRACT":"否","SCOPETYPE_ID":"ZCBXD","UNIT_NAME":"电影城频道项目"}]
         * total : 3
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
             * CLAIMTYPE_ID : 收入预算
             * CLAIM_DESC : 刘新专用测试_001
             * CLAIM_ID : 10866b504be111e6aa18000c29030dc2
             * CLAIM_REALUSER : 测试用户
             * CLAIM_SUM : 200.0
             * CLAIM_TIME : 2016-06-14
             * CLAIM_USER : root
             * EXAMINE_STATE : 分管领导审核
             * FGLD : 是
             * FGLDID : 136973231857805076053
             * IS_CONTRACT : 否
             * SCOPETYPE_ID : ZCBXD
             * UNIT_NAME : 电影城频道项目
             * ZJL : 是
             * ZN : 是
             * ZNID : F7EE859577AD478FABD326FA76779E0C
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
                private String CLAIMTYPE_ID;
                private String CLAIM_DESC;
                private String CLAIM_ID;
                private String CLAIM_REALUSER;
                private String CLAIM_SUM;
                private String CLAIM_TIME;
                private String CLAIM_USER;
                private String EXAMINE_STATE;
                private String FGLD;
                private String FGLDID;
                private String IS_CONTRACT;
                private String SCOPETYPE_ID;
                private String UNIT_NAME;
                private String ZJL;
                private String ZN;
                private String ZNID;

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

                public void setCLAIM_SUM(String CLAIM_SUM) {
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

                public String getCLAIM_SUM() {
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
            }
        }
    }
}
