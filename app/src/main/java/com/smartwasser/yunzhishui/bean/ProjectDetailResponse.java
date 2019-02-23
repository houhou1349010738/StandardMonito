package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class ProjectDetailResponse extends RBResponse{

    /**
     * projectBaseInfo : {"acceptDept":"BU32","acceptManager":"44","budgetControl":4444,"budgetSum":5555,"checkingWay":"44","contrCycle":"44","contrType":"可调总价","id":"a72a420b585511e6aa18000c29030dc2","manager":"4","noticeEndTime":"2016-08-09 00:00:00","noticePeriod":"7","noticeStage":"GGZ","noticeStartTime":"2016-08-02 00:00:00","operDept":"BU33","phurchaseManager":"4","productType":"工程","projCode":"shenshan","projName":"幻雪神山","projectType":"WJH","publicityResult":"WGS","purchaseKind":"JZCG","purchaseType":"现金采购","purchaseUnit":"BU32","recordTime":"2016-08-01 19:05:58","selected":"WDB","stageInfo":"LXWC","transactionPrinciple":"44","upDept":"BU33","updateTime":"2016-08-01 19:05:58"}
     */

    private DataEntity data;
    /**
     * data : {"projectBaseInfo":{"acceptDept":"BU32","acceptManager":"44","budgetControl":4444,"budgetSum":5555,"checkingWay":"44","contrCycle":"44","contrType":"可调总价","id":"a72a420b585511e6aa18000c29030dc2","manager":"4","noticeEndTime":"2016-08-09 00:00:00","noticePeriod":"7","noticeStage":"GGZ","noticeStartTime":"2016-08-02 00:00:00","operDept":"BU33","phurchaseManager":"4","productType":"工程","projCode":"shenshan","projName":"幻雪神山","projectType":"WJH","publicityResult":"WGS","purchaseKind":"JZCG","purchaseType":"现金采购","purchaseUnit":"BU32","recordTime":"2016-08-01 19:05:58","selected":"WDB","stageInfo":"LXWC","transactionPrinciple":"44","upDept":"BU33","updateTime":"2016-08-01 19:05:58"}}
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
         * acceptDept : BU32
         * acceptManager : 44
         * budgetControl : 4444.0
         * budgetSum : 5555.0
         * checkingWay : 44
         * contrCycle : 44
         * contrType : 可调总价
         * id : a72a420b585511e6aa18000c29030dc2
         * manager : 4
         * noticeEndTime : 2016-08-09 00:00:00
         * noticePeriod : 7
         * noticeStage : GGZ
         * noticeStartTime : 2016-08-02 00:00:00
         * operDept : BU33
         * phurchaseManager : 4
         * productType : 工程
         * projCode : shenshan
         * projName : 幻雪神山
         * projectType : WJH
         * publicityResult : WGS
         * purchaseKind : JZCG
         * purchaseType : 现金采购
         * purchaseUnit : BU32
         * recordTime : 2016-08-01 19:05:58
         * selected : WDB
         * stageInfo : LXWC
         * transactionPrinciple : 44
         * upDept : BU33
         * updateTime : 2016-08-01 19:05:58
         */

        private ProjectBaseInfoEntity projectBaseInfo;

        public void setProjectBaseInfo(ProjectBaseInfoEntity projectBaseInfo) {
            this.projectBaseInfo = projectBaseInfo;
        }

        public ProjectBaseInfoEntity getProjectBaseInfo() {
            return projectBaseInfo;
        }

        public static class ProjectBaseInfoEntity {
            private String acceptDept;
            private String acceptManager;
            private double budgetControl;
            private double budgetSum;
            private String checkingWay;
            private String contrCycle;
            private String contrType;
            private String id;
            private String manager;
            private String noticeEndTime;
            private String noticePeriod;
            private String noticeStage;
            private String noticeStartTime;
            private String operDept;
            private String phurchaseManager;
            private String productType;
            private String projCode;
            private String projName;
            private String projectType;
            private String publicityResult;
            private String purchaseKind;
            private String purchaseType;
            private String purchaseUnit;
            private String recordTime;
            private String selected;
            private String stageInfo;
            private String transactionPrinciple;
            private String upDept;
            private String updateTime;

            public void setAcceptDept(String acceptDept) {
                this.acceptDept = acceptDept;
            }

            public void setAcceptManager(String acceptManager) {
                this.acceptManager = acceptManager;
            }

            public void setBudgetControl(double budgetControl) {
                this.budgetControl = budgetControl;
            }

            public void setBudgetSum(double budgetSum) {
                this.budgetSum = budgetSum;
            }

            public void setCheckingWay(String checkingWay) {
                this.checkingWay = checkingWay;
            }

            public void setContrCycle(String contrCycle) {
                this.contrCycle = contrCycle;
            }

            public void setContrType(String contrType) {
                this.contrType = contrType;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setManager(String manager) {
                this.manager = manager;
            }

            public void setNoticeEndTime(String noticeEndTime) {
                this.noticeEndTime = noticeEndTime;
            }

            public void setNoticePeriod(String noticePeriod) {
                this.noticePeriod = noticePeriod;
            }

            public void setNoticeStage(String noticeStage) {
                this.noticeStage = noticeStage;
            }

            public void setNoticeStartTime(String noticeStartTime) {
                this.noticeStartTime = noticeStartTime;
            }

            public void setOperDept(String operDept) {
                this.operDept = operDept;
            }

            public void setPhurchaseManager(String phurchaseManager) {
                this.phurchaseManager = phurchaseManager;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public void setProjCode(String projCode) {
                this.projCode = projCode;
            }

            public void setProjName(String projName) {
                this.projName = projName;
            }

            public void setProjectType(String projectType) {
                this.projectType = projectType;
            }

            public void setPublicityResult(String publicityResult) {
                this.publicityResult = publicityResult;
            }

            public void setPurchaseKind(String purchaseKind) {
                this.purchaseKind = purchaseKind;
            }

            public void setPurchaseType(String purchaseType) {
                this.purchaseType = purchaseType;
            }

            public void setPurchaseUnit(String purchaseUnit) {
                this.purchaseUnit = purchaseUnit;
            }

            public void setRecordTime(String recordTime) {
                this.recordTime = recordTime;
            }

            public void setSelected(String selected) {
                this.selected = selected;
            }

            public void setStageInfo(String stageInfo) {
                this.stageInfo = stageInfo;
            }

            public void setTransactionPrinciple(String transactionPrinciple) {
                this.transactionPrinciple = transactionPrinciple;
            }

            public void setUpDept(String upDept) {
                this.upDept = upDept;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getAcceptDept() {
                return acceptDept;
            }

            public String getAcceptManager() {
                return acceptManager;
            }

            public double getBudgetControl() {
                return budgetControl;
            }

            public double getBudgetSum() {
                return budgetSum;
            }

            public String getCheckingWay() {
                return checkingWay;
            }

            public String getContrCycle() {
                return contrCycle;
            }

            public String getContrType() {
                return contrType;
            }

            public String getId() {
                return id;
            }

            public String getManager() {
                return manager;
            }

            public String getNoticeEndTime() {
                return noticeEndTime;
            }

            public String getNoticePeriod() {
                return noticePeriod;
            }

            public String getNoticeStage() {
                return noticeStage;
            }

            public String getNoticeStartTime() {
                return noticeStartTime;
            }

            public String getOperDept() {
                return operDept;
            }

            public String getPhurchaseManager() {
                return phurchaseManager;
            }

            public String getProductType() {
                return productType;
            }

            public String getProjCode() {
                return projCode;
            }

            public String getProjName() {
                return projName;
            }

            public String getProjectType() {
                return projectType;
            }

            public String getPublicityResult() {
                return publicityResult;
            }

            public String getPurchaseKind() {
                return purchaseKind;
            }

            public String getPurchaseType() {
                return purchaseType;
            }

            public String getPurchaseUnit() {
                return purchaseUnit;
            }

            public String getRecordTime() {
                return recordTime;
            }

            public String getSelected() {
                return selected;
            }

            public String getStageInfo() {
                return stageInfo;
            }

            public String getTransactionPrinciple() {
                return transactionPrinciple;
            }

            public String getUpDept() {
                return upDept;
            }

            public String getUpdateTime() {
                return updateTime;
            }
        }
    }
}
