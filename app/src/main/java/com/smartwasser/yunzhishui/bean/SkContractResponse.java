package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/23 0023.
 */
public class SkContractResponse extends RBResponse {
    /**
     * ContrBasic : {"rows":[{"auditTime":"2016-07-21 22:49:48","auditUser":"root","beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":23000,"contrCode":"dianying","contrFirstParty":"甲","contrName":"电影","contrSecondParty":"乙","contrSummary":"www","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-29 00:00:00","financialAuditOpinion":"aaa","fundsType":"收款","id":"cb7801ea4fcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":10000,"professionSubject":"13000","signTime":"2016-07-22 00:00:00","status":"复核退回","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-22 00:00:00","buCode":"DZJY0001","contrAmount":999,"contrCode":"QT-2016-合同类型(收款)-null-003","contrFirstParty":"b","contrName":"机关","contrSecondParty":"c","contrSummary":"aa","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-30 00:00:00","fundsType":"收款","id":"465057144fcd11e6aa18000c29030dc2","incomeSource":"","initialAmount":999,"professionSubject":"999","signTime":"2016-07-22 00:00:00","status":"登记","type":"2","unitName":"机关食堂"},{"auditTime":"2016-07-20 21:08:27","auditUser":"root","beginTime":"2016-06-14 00:00:00","buCode":"DSWY0015","contrAmount":400,"contrCode":"423423423","contrFirstParty":"电影城频道项目","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目","contrSummary":"电影城频道项目","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-23 00:00:00","financialAuditOpinion":"ty","fundsType":"收款","id":"9ce4fc074e7811e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"0","signTime":"2016-07-05 00:00:00","status":"复核完成","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-14 00:00:00","buCode":"DSWY0015","contrAmount":200,"contrCode":"QT-2016-合同类型(收款)-DSWY0015-002","contrFirstParty":"电影城频道项目_shixiang","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目_shixiang","contrSummary":"电影城频道项目_shixiang","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-15 00:00:00","fundsType":"收款","id":"cb2fd7e84e7a11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-07 00:00:00","status":"复核","type":"2","unitName":"电影城频道项目"},{"beginTime":"2016-07-14 00:00:00","buCode":"DSWY0015","contrAmount":2200,"contrCode":"324234234234","contrFirstParty":"电影城频道项目","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目","contrSummary":"电影城频道项目","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-16 00:00:00","fundsType":"收款","id":"fa5fb2354e4d11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"2000","signTime":"2016-07-21 00:00:00","status":"复核完成","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-12 00:00:00","buCode":"DZJY0001","contrAmount":200,"contrCode":"QT-2016-合同类型(收款)-null-001","contrFirstParty":"123123","contrName":"事项基本信息等级_刘新","contrSecondParty":"事项基本信息等级_刘新","contrSummary":"事项基本信息等级_刘新","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-21 00:00:00","fundsType":"收款","id":"076dd0d94dcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-11 00:00:00","status":"复核","type":"2","unitName":"机关食堂"},{"auditTime":"2016-07-20 00:14:09","auditUser":"root","beginTime":"2016-07-20 00:00:00","buCode":"DZJY0001","contrAmount":200,"contrCode":"123423-234-234","contrFirstParty":"合同类型(收款)","contrName":"刘新测试_222","contrSecondParty":"合同类型(收款)","contrSummary":"合同类型(收款)","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-21 00:00:00","financialAuditOpinion":"TG","fundsType":"收款","id":"4ecd9e7d4dc611e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-20 00:00:00","status":"复核完成","type":"1","unitName":"机关食堂"}],"total":7}
     * userName : root
     */
    private DataEntity data;
    /**
     * data : {"ContrBasic":{"rows":[{"auditTime":"2016-07-21 22:49:48","auditUser":"root","beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":23000,"contrCode":"dianying","contrFirstParty":"甲","contrName":"电影","contrSecondParty":"乙","contrSummary":"www","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-29 00:00:00","financialAuditOpinion":"aaa","fundsType":"收款","id":"cb7801ea4fcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":10000,"professionSubject":"13000","signTime":"2016-07-22 00:00:00","status":"复核退回","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-22 00:00:00","buCode":"DZJY0001","contrAmount":999,"contrCode":"QT-2016-合同类型(收款)-null-003","contrFirstParty":"b","contrName":"机关","contrSecondParty":"c","contrSummary":"aa","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-30 00:00:00","fundsType":"收款","id":"465057144fcd11e6aa18000c29030dc2","incomeSource":"","initialAmount":999,"professionSubject":"999","signTime":"2016-07-22 00:00:00","status":"登记","type":"2","unitName":"机关食堂"},{"auditTime":"2016-07-20 21:08:27","auditUser":"root","beginTime":"2016-06-14 00:00:00","buCode":"DSWY0015","contrAmount":400,"contrCode":"423423423","contrFirstParty":"电影城频道项目","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目","contrSummary":"电影城频道项目","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-23 00:00:00","financialAuditOpinion":"ty","fundsType":"收款","id":"9ce4fc074e7811e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"0","signTime":"2016-07-05 00:00:00","status":"复核完成","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-14 00:00:00","buCode":"DSWY0015","contrAmount":200,"contrCode":"QT-2016-合同类型(收款)-DSWY0015-002","contrFirstParty":"电影城频道项目_shixiang","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目_shixiang","contrSummary":"电影城频道项目_shixiang","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-15 00:00:00","fundsType":"收款","id":"cb2fd7e84e7a11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-07 00:00:00","status":"复核","type":"2","unitName":"电影城频道项目"},{"beginTime":"2016-07-14 00:00:00","buCode":"DSWY0015","contrAmount":2200,"contrCode":"324234234234","contrFirstParty":"电影城频道项目","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目","contrSummary":"电影城频道项目","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-16 00:00:00","fundsType":"收款","id":"fa5fb2354e4d11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"2000","signTime":"2016-07-21 00:00:00","status":"复核完成","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-12 00:00:00","buCode":"DZJY0001","contrAmount":200,"contrCode":"QT-2016-合同类型(收款)-null-001","contrFirstParty":"123123","contrName":"事项基本信息等级_刘新","contrSecondParty":"事项基本信息等级_刘新","contrSummary":"事项基本信息等级_刘新","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-21 00:00:00","fundsType":"收款","id":"076dd0d94dcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-11 00:00:00","status":"复核","type":"2","unitName":"机关食堂"},{"auditTime":"2016-07-20 00:14:09","auditUser":"root","beginTime":"2016-07-20 00:00:00","buCode":"DZJY0001","contrAmount":200,"contrCode":"123423-234-234","contrFirstParty":"合同类型(收款)","contrName":"刘新测试_222","contrSecondParty":"合同类型(收款)","contrSummary":"合同类型(收款)","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-21 00:00:00","financialAuditOpinion":"TG","fundsType":"收款","id":"4ecd9e7d4dc611e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-20 00:00:00","status":"复核完成","type":"1","unitName":"机关食堂"}],"total":7},"userName":"root"}
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
         * rows : [{"auditTime":"2016-07-21 22:49:48","auditUser":"root","beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":23000,"contrCode":"dianying","contrFirstParty":"甲","contrName":"电影","contrSecondParty":"乙","contrSummary":"www","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-29 00:00:00","financialAuditOpinion":"aaa","fundsType":"收款","id":"cb7801ea4fcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":10000,"professionSubject":"13000","signTime":"2016-07-22 00:00:00","status":"复核退回","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-22 00:00:00","buCode":"DZJY0001","contrAmount":999,"contrCode":"QT-2016-合同类型(收款)-null-003","contrFirstParty":"b","contrName":"机关","contrSecondParty":"c","contrSummary":"aa","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-30 00:00:00","fundsType":"收款","id":"465057144fcd11e6aa18000c29030dc2","incomeSource":"","initialAmount":999,"professionSubject":"999","signTime":"2016-07-22 00:00:00","status":"登记","type":"2","unitName":"机关食堂"},{"auditTime":"2016-07-20 21:08:27","auditUser":"root","beginTime":"2016-06-14 00:00:00","buCode":"DSWY0015","contrAmount":400,"contrCode":"423423423","contrFirstParty":"电影城频道项目","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目","contrSummary":"电影城频道项目","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-23 00:00:00","financialAuditOpinion":"ty","fundsType":"收款","id":"9ce4fc074e7811e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"0","signTime":"2016-07-05 00:00:00","status":"复核完成","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-14 00:00:00","buCode":"DSWY0015","contrAmount":200,"contrCode":"QT-2016-合同类型(收款)-DSWY0015-002","contrFirstParty":"电影城频道项目_shixiang","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目_shixiang","contrSummary":"电影城频道项目_shixiang","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-15 00:00:00","fundsType":"收款","id":"cb2fd7e84e7a11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-07 00:00:00","status":"复核","type":"2","unitName":"电影城频道项目"},{"beginTime":"2016-07-14 00:00:00","buCode":"DSWY0015","contrAmount":2200,"contrCode":"324234234234","contrFirstParty":"电影城频道项目","contrName":"电影城频道项目","contrSecondParty":"电影城频道项目","contrSummary":"电影城频道项目","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-16 00:00:00","fundsType":"收款","id":"fa5fb2354e4d11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"2000","signTime":"2016-07-21 00:00:00","status":"复核完成","type":"1","unitName":"电影城频道项目"},{"beginTime":"2016-07-12 00:00:00","buCode":"DZJY0001","contrAmount":200,"contrCode":"QT-2016-合同类型(收款)-null-001","contrFirstParty":"123123","contrName":"事项基本信息等级_刘新","contrSecondParty":"事项基本信息等级_刘新","contrSummary":"事项基本信息等级_刘新","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-21 00:00:00","fundsType":"收款","id":"076dd0d94dcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-11 00:00:00","status":"复核","type":"2","unitName":"机关食堂"},{"auditTime":"2016-07-20 00:14:09","auditUser":"root","beginTime":"2016-07-20 00:00:00","buCode":"DZJY0001","contrAmount":200,"contrCode":"123423-234-234","contrFirstParty":"合同类型(收款)","contrName":"刘新测试_222","contrSecondParty":"合同类型(收款)","contrSummary":"合同类型(收款)","contrType":"合同类型(收款)","crtime":"2016-07-20 00:00:00","cruser":"root","endTime":"2016-07-21 00:00:00","financialAuditOpinion":"TG","fundsType":"收款","id":"4ecd9e7d4dc611e6aa18000c29030dc2","incomeSource":"","initialAmount":200,"professionSubject":"200","signTime":"2016-07-20 00:00:00","status":"复核完成","type":"1","unitName":"机关食堂"}]
         * total : 7
         */

        private ContrBasicEntity ContrBasic;
        private String userName;

        public void setContrBasic(ContrBasicEntity ContrBasic) {
            this.ContrBasic = ContrBasic;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public ContrBasicEntity getContrBasic() {
            return ContrBasic;
        }

        public String getUserName() {
            return userName;
        }

        public static class ContrBasicEntity {
            private int total;
            /**
             * auditTime : 2016-07-21 22:49:48
             * auditUser : root
             * beginTime : 2016-07-22 00:00:00
             * buCode : DSWY0015
             * contrAmount : 23000.0
             * contrCode : dianying
             * contrFirstParty : 甲
             * contrName : 电影
             * contrSecondParty : 乙
             * contrSummary : www
             * contrType : 合同类型(收款)
             * crtime : 2016-07-21 00:00:00
             * cruser : root
             * endTime : 2016-07-29 00:00:00
             * financialAuditOpinion : aaa
             * fundsType : 收款
             * id : cb7801ea4fcb11e6aa18000c29030dc2
             * incomeSource :
             * initialAmount : 10000.0
             * professionSubject : 13000
             * signTime : 2016-07-22 00:00:00
             * status : 复核退回
             * type : 1
             * unitName : 电影城频道项目
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
                private String auditTime;
                private String auditUser;
                private String beginTime;
                private String buCode;
                private double contrAmount;
                private String contrCode;
                private String contrFirstParty;
                private String contrName;
                private String contrSecondParty;
                private String contrSummary;
                private String contrType;
                private String crtime;
                private String cruser;
                private String endTime;
                private String financialAuditOpinion;
                private String fundsType;
                private String id;
                private String incomeSource;
                private double initialAmount;
                private String professionSubject;
                private String signTime;
                private String status;
                private String type;
                private String unitName;

                public void setAuditTime(String auditTime) {
                    this.auditTime = auditTime;
                }

                public void setAuditUser(String auditUser) {
                    this.auditUser = auditUser;
                }

                public void setBeginTime(String beginTime) {
                    this.beginTime = beginTime;
                }

                public void setBuCode(String buCode) {
                    this.buCode = buCode;
                }

                public void setContrAmount(double contrAmount) {
                    this.contrAmount = contrAmount;
                }

                public void setContrCode(String contrCode) {
                    this.contrCode = contrCode;
                }

                public void setContrFirstParty(String contrFirstParty) {
                    this.contrFirstParty = contrFirstParty;
                }

                public void setContrName(String contrName) {
                    this.contrName = contrName;
                }

                public void setContrSecondParty(String contrSecondParty) {
                    this.contrSecondParty = contrSecondParty;
                }

                public void setContrSummary(String contrSummary) {
                    this.contrSummary = contrSummary;
                }

                public void setContrType(String contrType) {
                    this.contrType = contrType;
                }

                public void setCrtime(String crtime) {
                    this.crtime = crtime;
                }

                public void setCruser(String cruser) {
                    this.cruser = cruser;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public void setFinancialAuditOpinion(String financialAuditOpinion) {
                    this.financialAuditOpinion = financialAuditOpinion;
                }

                public void setFundsType(String fundsType) {
                    this.fundsType = fundsType;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public void setIncomeSource(String incomeSource) {
                    this.incomeSource = incomeSource;
                }

                public void setInitialAmount(double initialAmount) {
                    this.initialAmount = initialAmount;
                }

                public void setProfessionSubject(String professionSubject) {
                    this.professionSubject = professionSubject;
                }

                public void setSignTime(String signTime) {
                    this.signTime = signTime;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setUnitName(String unitName) {
                    this.unitName = unitName;
                }

                public String getAuditTime() {
                    return auditTime;
                }

                public String getAuditUser() {
                    return auditUser;
                }

                public String getBeginTime() {
                    return beginTime;
                }

                public String getBuCode() {
                    return buCode;
                }

                public double getContrAmount() {
                    return contrAmount;
                }

                public String getContrCode() {
                    return contrCode;
                }

                public String getContrFirstParty() {
                    return contrFirstParty;
                }

                public String getContrName() {
                    return contrName;
                }

                public String getContrSecondParty() {
                    return contrSecondParty;
                }

                public String getContrSummary() {
                    return contrSummary;
                }

                public String getContrType() {
                    return contrType;
                }

                public String getCrtime() {
                    return crtime;
                }

                public String getCruser() {
                    return cruser;
                }

                public String getEndTime() {
                    return endTime;
                }

                public String getFinancialAuditOpinion() {
                    return financialAuditOpinion;
                }

                public String getFundsType() {
                    return fundsType;
                }

                public String getId() {
                    return id;
                }

                public String getIncomeSource() {
                    return incomeSource;
                }

                public double getInitialAmount() {
                    return initialAmount;
                }

                public String getProfessionSubject() {
                    return professionSubject;
                }

                public String getSignTime() {
                    return signTime;
                }

                public String getStatus() {
                    return status;
                }

                public String getType() {
                    return type;
                }

                public String getUnitName() {
                    return unitName;
                }
            }
        }
    }
}
