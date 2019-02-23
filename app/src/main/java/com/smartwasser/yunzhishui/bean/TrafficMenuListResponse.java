package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/12 0012.
 */
public class TrafficMenuListResponse extends RBResponse{
    /**
     * errorCode : 00000
     * errorMsg : success
     * data : [{"id":"20130227001","isapp":"1","appid":"135415712788748462078","parentid":"135415712788748462078","funcnamech":"车辆监控","funcnameen":"monitor","funcurl":"main","funcdesc":null,"funccode":"0:1:1","priority":2,"ismenu":1,"icon":null},{"id":"20130227002","isapp":"1","appid":"135415712788748462078","parentid":"135415712788748462078","funcnamech":"轨迹重现","funcnameen":"lineplayback","funcurl":"lineplayback/list","funcdesc":null,"funccode":"0:1:2","priority":3,"ismenu":1,"icon":null},{"id":"20130227003","isapp":"1","appid":"135415712788748462078","parentid":"135415712788748462078","funcnamech":"运输任务管理","funcnameen":"task","funcurl":"transporttask/manage/list","funcdesc":null,"funccode":"0:1:3","priority":4,"ismenu":1,"icon":null},{"id":"20130227018","isapp":"1","appid":"135415714301176560702","parentid":"135415714301176560702","funcnamech":"称重数据监控","funcnameen":null,"funcurl":"transportInfo/carWeighManage/list","funcdesc":null,"funccode":null,"priority":null,"ismenu":1,"icon":null}]
     */
    private String errorCode;
    private String errorMsg;
    /**
     * id : 20130227001
     * isapp : 1
     * appid : 135415712788748462078
     * parentid : 135415712788748462078
     * funcnamech : 车辆监控
     * funcnameen : monitor
     * funcurl : main
     * funcdesc : null
     * funccode : 0:1:1
     * priority : 2
     * ismenu : 1
     * icon : null
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
        private String id;
        private String isapp;
        private String appid;
        private String parentid;
        private String funcnamech;
        private String funcnameen;
        private String funcurl;
        private Object funcdesc;
        private String funccode;
        private int priority;
        private int ismenu;
        private Object icon;

        public void setId(String id) {
            this.id = id;
        }

        public void setIsapp(String isapp) {
            this.isapp = isapp;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
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

        public void setFuncdesc(Object funcdesc) {
            this.funcdesc = funcdesc;
        }

        public void setFunccode(String funccode) {
            this.funccode = funccode;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public void setIsmenu(int ismenu) {
            this.ismenu = ismenu;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public String getIsapp() {
            return isapp;
        }

        public String getAppid() {
            return appid;
        }

        public String getParentid() {
            return parentid;
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

        public Object getFuncdesc() {
            return funcdesc;
        }

        public String getFunccode() {
            return funccode;
        }

        public int getPriority() {
            return priority;
        }

        public int getIsmenu() {
            return ismenu;
        }

        public Object getIcon() {
            return icon;
        }
    }
}
