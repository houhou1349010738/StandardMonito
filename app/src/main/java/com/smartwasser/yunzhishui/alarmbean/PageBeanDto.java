package com.smartwasser.yunzhishui.alarmbean;

import com.smartwasser.yunzhishui.bean.RBResponse;

import java.util.List;

/**
 * Created by 15810 on 2019/3/22.
 */

public class PageBeanDto  extends RBResponse {

    /**
     * data : [{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":18,"funccode":"0:1","funcdesc":"","funcnamech":"实时监测","funcnameen":"ssjc","funcurl":"","id":"136272096970931770620","isapp":"1","ismenu":1,"parentid":"-1","priority":1},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:10","funcdesc":"","funcnamech":"水厂监测","funcnameen":"fac_monitor","funcurl":"","id":"7c85e08b43c811e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"136272096970931770620","priority":10},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:10:1","funcdesc":"","funcnamech":"第一水厂","funcnameen":"water_fac1","funcurl":"/monitor/f?bu=CZWS0642","id":"7c0ef19243ca11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"7c85e08b43c811e9ae82089e01f500fd","priority":11},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:10:1","funcdesc":"","funcnamech":"第二水厂","funcnameen":"water_fac2","funcurl":"/monitor/f?bu=CZWS0642","id":"8994e00943ca11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"7c85e08b43c811e9ae82089e01f500fd","priority":12},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:13","funcdesc":"","funcnamech":"泵站监测","funcnameen":"pump_monitor","funcurl":"","id":"a4ca042e43ca11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"136272096970931770620","priority":13},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:13:1","funcdesc":"","funcnamech":"泵站一","funcnameen":"pump1","funcurl":"/monitor/f?bu=CZWS0642","id":"b6ef005a43ca11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"a4ca042e43ca11e9ae82089e01f500fd","priority":14},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:13:1","funcdesc":"","funcnamech":"泵站二","funcnameen":"pump2","funcurl":"/monitor/f?bu=CZWS0642","id":"c2178fbf43ca11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"a4ca042e43ca11e9ae82089e01f500fd","priority":15},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:16","funcdesc":"","funcnamech":"点位监测","funcnameen":"point_monitor","funcurl":"/monitor/f?bu=CZWS0642","id":"e85b0d3a43ca11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"136272096970931770620","priority":16},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:17","funcdesc":"","funcnamech":"能源监测","funcnameen":"energy_monitor","funcurl":"","id":"f5520f7643ca11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"136272096970931770620","priority":17},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":7,"funccode":"0:1:17:1","funcdesc":"","funcnamech":"第一电厂","funcnameen":"qh","funcurl":"/monitor/f?bu=CZWS0620","id":"138372609457828586382","isapp":"1","ismenu":1,"parentid":"f5520f7643ca11e9ae82089e01f500fd","priority":1},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:1:17:2","funcdesc":"","funcnamech":"第二电厂","funcnameen":"energy2","funcurl":"/monitor/f?bu=CZWS0620","id":"0d5f47d943cb11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"f5520f7643ca11e9ae82089e01f500fd","priority":18},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":18,"funccode":"0:2","funcdesc":"","funcnamech":"历史查询","funcnameen":"lscx","funcurl":"","id":"138372614509302817214","isapp":"1","ismenu":1,"parentid":"-1","priority":2},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:2:01","funcdesc":"","funcnamech":"运行数据查询","funcnameen":"yxsjcx","funcurl":"historySearch/runningDataPage","id":"139962732492125113615","isapp":"1","ismenu":1,"parentid":"138372614509302817214","priority":1},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:2:02","funcdesc":"","funcnamech":"设备运行状态查询","funcnameen":"sbyxztcx","funcurl":"historySearch/equipRunningStatePage","id":"139962732492125113616","isapp":"1","ismenu":1,"parentid":"138372614509302817214","priority":2},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:2:16","funcdesc":"","funcnamech":"泵站运行状态查询","funcnameen":"pump_state_search","funcurl":"","id":"5de8821d43cc11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"138372614509302817214","priority":16},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:2:17","funcdesc":"","funcnamech":"处理水量查询","funcnameen":"flow_search","funcurl":"","id":"70c8029543cc11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"138372614509302817214","priority":17},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:2:18","funcdesc":"","funcnamech":"用电量查询","funcnameen":"energy_search","funcurl":"","id":"81dcc9bc43cc11e9ae82089e01f500fd","isapp":"1","ismenu":1,"parentid":"138372614509302817214","priority":18},{"appid":"bd23e0e1016011e687ec000c29b2d655","chfuncmid":5,"funccode":"0:5","funcdesc":"","funcnamech":"预警报警","funcnameen":"alarm","funcurl":"","id":"138372619389084886281","isapp":"1","ismenu":1,"parentid":"-1","priority":5},{"appid":"bd23e0e1016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:5:03","funcdesc":"","funcnamech":"实时报警信息","funcnameen":"ssbjxx","funcurl":"alarm/realDataAlarm/list","id":"138372711256257822123","isapp":"1","ismenu":1,"parentid":"138372619389084886281","priority":3},{"appid":"bd23e0e1016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:5:04","funcdesc":"","funcnamech":"历史报警信息","funcnameen":"lsbjxx","funcurl":"alarm/hisDataAlarm/list","id":"140679995170301120124","isapp":"1","ismenu":1,"parentid":"138372619389084886281","priority":4}]
     * errorCode : 00000
     * errorMsg : success
     */

    private String errorCode;
    private String errorMsg;
    private List<DataBean> data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appid : 9eee2c1c016011e687ec000c29b2d655
         * chfuncmid : 18
         * funccode : 0:1
         * funcdesc :
         * funcnamech : 实时监测
         * funcnameen : ssjc
         * funcurl :
         * id : 136272096970931770620
         * isapp : 1
         * ismenu : 1
         * parentid : -1
         * priority : 1
         */

        private String appid;
        private int chfuncmid;
        private String funccode;
        private String funcdesc;
        private String funcnamech;
        private String funcnameen;
        private String funcurl;
        private String id;
        private String isapp;
        private int ismenu;
        private String parentid;
        private int priority;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public int getChfuncmid() {
            return chfuncmid;
        }

        public void setChfuncmid(int chfuncmid) {
            this.chfuncmid = chfuncmid;
        }

        public String getFunccode() {
            return funccode;
        }

        public void setFunccode(String funccode) {
            this.funccode = funccode;
        }

        public String getFuncdesc() {
            return funcdesc;
        }

        public void setFuncdesc(String funcdesc) {
            this.funcdesc = funcdesc;
        }

        public String getFuncnamech() {
            return funcnamech;
        }

        public void setFuncnamech(String funcnamech) {
            this.funcnamech = funcnamech;
        }

        public String getFuncnameen() {
            return funcnameen;
        }

        public void setFuncnameen(String funcnameen) {
            this.funcnameen = funcnameen;
        }

        public String getFuncurl() {
            return funcurl;
        }

        public void setFuncurl(String funcurl) {
            this.funcurl = funcurl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsapp() {
            return isapp;
        }

        public void setIsapp(String isapp) {
            this.isapp = isapp;
        }

        public int getIsmenu() {
            return ismenu;
        }

        public void setIsmenu(int ismenu) {
            this.ismenu = ismenu;
        }

        public String getParentid() {
            return parentid;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "appid='" + appid + '\'' +
                    ", chfuncmid=" + chfuncmid +
                    ", funccode='" + funccode + '\'' +
                    ", funcdesc='" + funcdesc + '\'' +
                    ", funcnamech='" + funcnamech + '\'' +
                    ", funcnameen='" + funcnameen + '\'' +
                    ", funcurl='" + funcurl + '\'' +
                    ", id='" + id + '\'' +
                    ", isapp='" + isapp + '\'' +
                    ", ismenu=" + ismenu +
                    ", parentid='" + parentid + '\'' +
                    ", priority=" + priority +
                    '}';
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
    }
}
