package com.smartwasser.yunzhishui.bean;

import java.util.List;
/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class ProductMenuResponse extends RBResponse {
    /**
     * data : [{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:01","funcnamech":"费用报销申请","funcnameen":"fybxsq","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=fill_fybxsq&tableName=SELECT_FACTORY","id":"136766030183844734511","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":1},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:02","funcnamech":"项目经理审核","funcnameen":"xmjlsh","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_xmjlsh&tableName=SELECT_FACTORY","id":"136766030181122734511","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":2},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:03","funcnamech":"分子公司/管理处审核","funcnameen":"fzgsglcsh","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_fzgsglcsh&tableName=SELECT_FACTORY","id":"136766030181122734321","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":3},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:04","funcnamech":"会计审核","funcnameen":"kjsh","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_kjsh&tableName=SELECT_FACTORY","id":"136766030341122734321","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":4},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:05","funcnamech":"职能部门审核","funcnameen":"znbmsh","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_znbmsh&tableName=SELECT_FACTORY","id":"136766030341121234321","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":5},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:06","funcnamech":"财务经理审核","funcnameen":"cwjlsh","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_cwjlsh&tableName=SELECT_FACTORY","id":"136766030341121798321","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":6},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:07","funcnamech":"分管领导审核","funcnameen":"fgldsh","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_fgldsh&tableName=SELECT_FACTORY","id":"136766030312121798321","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":7},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:08","funcdesc":"总经理审核","funcnamech":"总经理审核","funcnameen":"总经理审核","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_zjlsh&tableName=SELECT_FACTORY","id":"7C7264752890437B824899E7B25987E2","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":8},{"appid":"136766030183867734511","chfuncmid":0,"funccode":"0:07:09","funcnamech":"出纳及会计核准","funcnameen":"cnjkjhz","funcurl":"pay/costClaim/list.do?flowCode=YWLC10005&nodeId=review_cnjkjhz&tableName=SELECT_FACTORY","id":"136766030314321798321","isapp":"1","ismenu":0,"parentid":"136766030183867734511","priority":9}]
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;
    /**
     * appid : 136766030183867734511
     * chfuncmid : 0
     * funccode : 0:07:01
     * funcnamech : 费用报销申请
     * funcnameen : fybxsq
     * funcurl : pay/costClaim/list.do?flowCode=YWLC10005&nodeId=fill_fybxsq&tableName=SELECT_FACTORY
     * id : 136766030183844734511
     * isapp : 1
     * ismenu : 0
     * parentid : 136766030183867734511
     * priority : 1
     */

    private List<DataEntity> data;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String appid;
        private int chfuncmid;
        private String funccode;
        private String funcnamech;
        private String funcnameen;
        private String funcurl;
        private String id;
        private String isapp;
        private int ismenu;
        private String parentid;
        private int priority;

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public void setChfuncmid(int chfuncmid) {
            this.chfuncmid = chfuncmid;
        }

        public void setFunccode(String funccode) {
            this.funccode = funccode;
        }

        public void setFuncnamech(String funcnamech) {
            this.funcnamech = funcnamech;
        }

        public void setFuncnameen(String funcnameen) {
            this.funcnameen = funcnameen;
        }

        public void setFuncurl(String funcurl) {
            this.funcurl = funcurl;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setIsapp(String isapp) {
            this.isapp = isapp;
        }

        public void setIsmenu(int ismenu) {
            this.ismenu = ismenu;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getAppid() {
            return appid;
        }

        public int getChfuncmid() {
            return chfuncmid;
        }

        public String getFunccode() {
            return funccode;
        }

        public String getFuncnamech() {
            return funcnamech;
        }

        public String getFuncnameen() {
            return funcnameen;
        }

        public String getFuncurl() {
            return funcurl;
        }

        public String getId() {
            return id;
        }

        public String getIsapp() {
            return isapp;
        }

        public int getIsmenu() {
            return ismenu;
        }

        public String getParentid() {
            return parentid;
        }

        public int getPriority() {
            return priority;
        }
    }
}
