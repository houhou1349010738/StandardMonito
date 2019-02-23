package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class PurchesaMenuResponse extends RBResponse {

    /**
     * data : [{"appid":"ef037ef3297111e6bc63599f0f6ffeae","chfuncmid":6,"funccode":"8","funcnamech":"在线竞价采购管理","id":"ef06260e297111e6bc63599f0f6ffeae","isapp":"1","ismenu":1,"parentid":"-1","priority":1}]
     * errorCode : 00000
     * errorMsg : success
     */

    private String errorCode;
    private String errorMsg;
    /**
     * appid : ef037ef3297111e6bc63599f0f6ffeae
     * chfuncmid : 6
     * funccode : 8
     * funcnamech : 在线竞价采购管理
     * id : ef06260e297111e6bc63599f0f6ffeae
     * isapp : 1
     * ismenu : 1
     * parentid : -1
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
