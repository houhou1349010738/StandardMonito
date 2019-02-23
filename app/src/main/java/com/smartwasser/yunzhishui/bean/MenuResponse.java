package com.smartwasser.yunzhishui.bean;

import java.util.List;
/**
 * Created by huangmengjie on 2016/4/29 0029.
 */
public class MenuResponse extends RBResponse{

    /**
     * data : [{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:01","funcnamech":"水厂日报","funcnameen":"scrb","funcurl":"/rundata/daily/indeFill/list?tableName=DAILY_WATER&flowCode=YWLC0001","id":"142933221065480207173","ismenu":0,"parentid":"142933219070868803212","priority":1}]
     * errorCode : 00000
     * errorMsg : success
     */

    private String errorCode;
    private String errorMsg;
    /**
     * appid : 141524548287927574821
     * chfuncmid : 0
     * funccode : 0:07:01:01
     * funcnamech : 水厂日报
     * funcnameen : scrb
     * funcurl : /rundata/daily/indeFill/list?tableName=DAILY_WATER&flowCode=YWLC0001
     * id : 142933221065480207173
     * ismenu : 0
     * parentid : 142933219070868803212
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
