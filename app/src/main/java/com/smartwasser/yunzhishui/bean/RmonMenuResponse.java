package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/29 0029.
 */
public class RmonMenuResponse extends RBResponse{
    /**
     * data : [{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":7,"funccode":"0:1:1","funcnamech":"清河","funcnameen":"qh","funcurl":"/monitor/f?bu=CZWS0620","id":"138372609457828586382","isapp":"1","ismenu":1,"parentid":"136272096970931770620","priority":1},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:2:01","funcnamech":"运行数据查询","funcnameen":"yxsjcx","funcurl":"historySearch/runningDataPage","id":"139962732492125113615","isapp":"1","ismenu":0,"parentid":"138372614509302817214","priority":1},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"0:2:02","funcnamech":"设备运行状态查询","funcnameen":"sbyxztcx","funcurl":"historySearch/equipRunningStatePage","id":"139962732492125113616","isapp":"1","ismenu":0,"parentid":"138372614509302817214","priority":2},{"appid":"9eee2c1c016011e687ec000c29b2d655","chfuncmid":0,"funccode":"1","funcnamech":"实时监测","icon":"iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTExIDc5LjE1ODMyNSwgMjAxNS8wOS8xMC0wMToxMDoyMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkU0MjAzODA3MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkU0MjAzODA4MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RTQyMDM4MDUxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RTQyMDM4MDYxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4DiV6yAAACw0lEQVR42nSTSWgUURCGvzfT091Oz5LJTIxLMsYFRVARJIKCouBBVDSnoHhxCd5FcY0XEaOBoEcXxEs8JCdBBT0oaPDgVRBRwTXRbI5JZk3P8qz0hCQqVlPUe13bX8tTWkgd7sO/sAa/dnErIfwVl7JVAieC+auEG/oIv5KQ+4m+uRUhxTQpDr7Uunszf1JROCCcF573h0YdeIa9yJkJYMTmD9E9BN+Gi55f2SzDpI+olWfEMEhk5HdshEDKIZAMEo641NuB2YD1Jz/qoVfPwVoAdh1kvgj0BBS+gt+RYLboTNDjYm4SX7dGvCqzCJrVMx68ODoH5HphP/+jfafusrIxNnM3RnSjd+g/prBE1t3StJ64hO0kSVgOhaLF6MA7em+fEG2ZQH4VvkJoNkAk+8M7hKX07GT1Z29X+19590BFhM/P4IBL2PBV6zcrGLli2rsE72ii0+a7j3cQdZqol5GGIxPkUhsYa1mNMwo7OiXrlHNQ8LyemoKx3HP60KZoFE3xhubRtbP/1H6oFy60QsfTWuIxg8m3w1TKDsZA+ZtnsELKUgNSipx3nmqnMdjMyoa1qO81hOxa7I3VrbCHowzxibilqOQEga9Q9AKY13U1VQEed16qdrxbUbdFZpKSPXkTwb9tgvf5T0hV2pB+BS0fRn1+zDNu7VOoLPTs1LScvsJa9hPfBJe3N0jv+5mQb0Qydh2pDtlEc7EnjVEyl3oBAgJkzKiCuH/1jCdXX4a9n/sJC3Z/2eBhe4KWDsmy2KA2nyYWDktDMynP+N5W7T2RbGZqj1yyRo635/RME5PnFWkGycvTWLYorkITGlUsSw9K6emNqArH2xETR3guLZZrTDLEpAzf+58EmixKglq1nX6iP3y+L0NN4ivK5rkuEdthPJBjXqZGnrKLk1lCvmUXDakEhYWjU7lUwZUSa6L8FmAAEiPquBOcPIoAAAAASUVORK5CYII=","id":"136272096970931770620","isapp":"1","ismenu":0,"parentid":"-1","priority":1},{"appid":"a563f7df016011e687ec000c29b2d655","chfuncmid":0,"funccode":"2","funcnamech":"历史查询","icon":"iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyFpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1MTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo3QkY3NzJFMkU0OEExMUUzQjBEOUM2RUUzNDkxNzBGRiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDo3QkY3NzJFM0U0OEExMUUzQjBEOUM2RUUzNDkxNzBGRiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjdCRjc3MkUwRTQ4QTExRTNCMEQ5QzZFRTM0OTE3MEZGIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjdCRjc3MkUxRTQ4QTExRTNCMEQ5QzZFRTM0OTE3MEZGIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+PGwutwAAAOxJREFUeNrEU0tqQkEQrJ5pcfEIgkkuIIjkCNlmJ7lB7iHkKLlGduYCnsCNG6+gEN/kvfm1PavsFOctbCiKmZ4uugqGRARDymBgDRbgl/V+c8BoZnCbFSFCE7stH47twkKmtyZBZNB5J9x8fTo9T2vWtwTP/u3D1gwXCzZ0YD9/pToBA+5PYLRtXfwqgN6BxWfUbaAIuQik/0tF1A6TXOVQQgwJpqgUJN1koo3lU0Ij6Sq/PyfEPqpAojGy+lHkCLhfh6zy7vR3mfWdZDumx9X3TxSzIMlG1ETUSNiQslzkoFYewnFHd/+NZwEGAOYtoXC3bkxhAAAAAElFTkSuQmCC","id":"138372614509302817214","isapp":"1","ismenu":0,"parentid":"-1","priority":1}]
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;
    /**
     * appid : 9eee2c1c016011e687ec000c29b2d655
     * chfuncmid : 7
     * funccode : 0:1:1
     * funcnamech : 清河
     * funcnameen : qh
     * funcurl : /monitor/f?bu=CZWS0620
     * id : 138372609457828586382
     * isapp : 1
     * ismenu : 1
     * parentid : 136272096970931770620
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
