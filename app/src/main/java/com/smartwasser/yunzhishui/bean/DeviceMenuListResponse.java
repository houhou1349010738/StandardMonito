package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/15 0015.
 */
public class DeviceMenuListResponse extends RBResponse {

    /**
     * data : [{"appid":"badcb2dffd4811e5b9fd000c29b2d655","chfuncmid":0,"funccode":"0:01:01","funcdesc":"","funcnamech":"设备台账","funcnameen":"sbtz","funcurl":"sbtz/equipInfo/list","id":"137480905179275576837","isapp":"1","ismenu":1,"parentid":"bae1456afd4811e5b9fd000c29b2d655","priority":1},{"appid":"dd2ed0a0fd4811e5b9fd000c29b2d655","chfuncmid":0,"funccode":"0:05:01","funcdesc":"","funcnamech":"保养工单派发","funcnameen":"bygdpf","funcurl":"workmanage/eqMaintain/list","id":"137482215078957405566","isapp":"1","ismenu":1,"parentid":"dd33c544fd4811e5b9fd000c29b2d655","priority":1},{"appid":"e55df795fd4811e5b9fd000c29b2d655","chfuncmid":0,"funccode":"0:06:01","funcdesc":"","funcnamech":"故障信息生成","funcnameen":"gzxxsc","funcurl":"malfunction/eqFailure/list","id":"137482220069050344437","isapp":"1","ismenu":1,"parentid":"e566cefdfd4811e5b9fd000c29b2d655","priority":1},{"appid":"badcb2dffd4811e5b9fd000c29b2d655","chfuncmid":1,"funccode":"0","funcdesc":"","funcnamech":"设备台账管理","funcnameen":"sbtzgl","funcurl":"","icon":"iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTExIDc5LjE1ODMyNSwgMjAxNS8wOS8xMC0wMToxMDoyMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkU0MjAzODA3MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkU0MjAzODA4MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RTQyMDM4MDUxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RTQyMDM4MDYxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4DiV6yAAACw0lEQVR42nSTSWgUURCGvzfT091Oz5LJTIxLMsYFRVARJIKCouBBVDSnoHhxCd5FcY0XEaOBoEcXxEs8JCdBBT0oaPDgVRBRwTXRbI5JZk3P8qz0hCQqVlPUe13bX8tTWkgd7sO/sAa/dnErIfwVl7JVAieC+auEG/oIv5KQ+4m+uRUhxTQpDr7Uunszf1JROCCcF573h0YdeIa9yJkJYMTmD9E9BN+Gi55f2SzDpI+olWfEMEhk5HdshEDKIZAMEo641NuB2YD1Jz/qoVfPwVoAdh1kvgj0BBS+gt+RYLboTNDjYm4SX7dGvCqzCJrVMx68ODoH5HphP/+jfafusrIxNnM3RnSjd+g/prBE1t3StJ64hO0kSVgOhaLF6MA7em+fEG2ZQH4VvkJoNkAk+8M7hKX07GT1Z29X+19590BFhM/P4IBL2PBV6zcrGLli2rsE72ii0+a7j3cQdZqol5GGIxPkUhsYa1mNMwo7OiXrlHNQ8LyemoKx3HP60KZoFE3xhubRtbP/1H6oFy60QsfTWuIxg8m3w1TKDsZA+ZtnsELKUgNSipx3nmqnMdjMyoa1qO81hOxa7I3VrbCHowzxibilqOQEga9Q9AKY13U1VQEed16qdrxbUbdFZpKSPXkTwb9tgvf5T0hV2pB+BS0fRn1+zDNu7VOoLPTs1LScvsJa9hPfBJe3N0jv+5mQb0Qydh2pDtlEc7EnjVEyl3oBAgJkzKiCuH/1jCdXX4a9n/sJC3Z/2eBhe4KWDsmy2KA2nyYWDktDMynP+N5W7T2RbGZqj1yyRo635/RME5PnFWkGycvTWLYorkITGlUsSw9K6emNqArH2xETR3guLZZrTDLEpAzf+58EmixKglq1nX6iP3y+L0NN4ivK5rkuEdthPJBjXqZGnrKLk1lCvmUXDakEhYWjU7lUwZUSa6L8FmAAEiPquBOcPIoAAAAASUVORK5CYII=","id":"bae1456afd4811e5b9fd000c29b2d655","isapp":"1","ismenu":1,"parentid":"-1","priority":1},{"appid":"dd2ed0a0fd4811e5b9fd000c29b2d655","chfuncmid":0,"funccode":"0:05:02","funcdesc":"","funcnamech":"保养工单反馈","funcnameen":"bygdfk","funcurl":"workmanage/eqMaintain/fklist","id":"137482215078957405116","isapp":"1","ismenu":1,"parentid":"dd33c544fd4811e5b9fd000c29b2d655","priority":2}]
     * errorCode : 00000
     * errorMsg : success
     */

    private String errorCode;
    private String errorMsg;
    /**
     * appid : badcb2dffd4811e5b9fd000c29b2d655
     * chfuncmid : 0
     * funccode : 0:01:01
     * funcdesc :
     * funcnamech : 设备台账
     * funcnameen : sbtz
     * funcurl : sbtz/equipInfo/list
     * id : 137480905179275576837
     * isapp : 1
     * ismenu : 1
     * parentid : bae1456afd4811e5b9fd000c29b2d655
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
        private String funcdesc;
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

        public void setFuncdesc(String funcdesc) {
            this.funcdesc = funcdesc;
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

        public String getFuncdesc() {
            return funcdesc;
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
