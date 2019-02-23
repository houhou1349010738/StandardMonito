package com.smartwasser.yunzhishui.bean;
import java.util.List;
/**
 * Created by huangmengjie on 2016/4/29 0029.
 */
public class SiteResponse extends RBResponse{
    /**
     * data : [{"appid":"1415245533015010434641","chfuncmid":9,"funccode":"0:07:01","funcdesc":"","funcnamech":"日报上报","funcnameen":"rbsb","funcurl":"","id":"142933219070868803212","isapp":"1","ismenu":1,"parentid":"1415245533015010434641","priority":1},{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:01","funcdesc":"","funcnamech":"水厂日报","funcnameen":"scrb","funcurl":"/rundata/daily/indeFill/list?tableName=DAILY_WATER&flowCode=YWLC0001","id":"142933221065480207173","isapp":"1","ismenu":1,"parentid":"142933219070868803212","priority":1},{"appid":"1415245533015010434641","chfuncmid":11,"funccode":"0","funcdesc":"","funcnamech":"数据上报","funcnameen":"sjsb","funcurl":"","icon":"iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTExIDc5LjE1ODMyNSwgMjAxNS8wOS8xMC0wMToxMDoyMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkU0MjAzODA3MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkU0MjAzODA4MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RTQyMDM4MDUxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RTQyMDM4MDYxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4DiV6yAAACw0lEQVR42nSTSWgUURCGvzfT091Oz5LJTIxLMsYFRVARJIKCouBBVDSnoHhxCd5FcY0XEaOBoEcXxEs8JCdBBT0oaPDgVRBRwTXRbI5JZk3P8qz0hCQqVlPUe13bX8tTWkgd7sO/sAa/dnErIfwVl7JVAieC+auEG/oIv5KQ+4m+uRUhxTQpDr7Uunszf1JROCCcF573h0YdeIa9yJkJYMTmD9E9BN+Gi55f2SzDpI+olWfEMEhk5HdshEDKIZAMEo641NuB2YD1Jz/qoVfPwVoAdh1kvgj0BBS+gt+RYLboTNDjYm4SX7dGvCqzCJrVMx68ODoH5HphP/+jfafusrIxNnM3RnSjd+g/prBE1t3StJ64hO0kSVgOhaLF6MA7em+fEG2ZQH4VvkJoNkAk+8M7hKX07GT1Z29X+19590BFhM/P4IBL2PBV6zcrGLli2rsE72ii0+a7j3cQdZqol5GGIxPkUhsYa1mNMwo7OiXrlHNQ8LyemoKx3HP60KZoFE3xhubRtbP/1H6oFy60QsfTWuIxg8m3w1TKDsZA+ZtnsELKUgNSipx3nmqnMdjMyoa1qO81hOxa7I3VrbCHowzxibilqOQEga9Q9AKY13U1VQEed16qdrxbUbdFZpKSPXkTwb9tgvf5T0hV2pB+BS0fRn1+zDNu7VOoLPTs1LScvsJa9hPfBJe3N0jv+5mQb0Qydh2pDtlEc7EnjVEyl3oBAgJkzKiCuH/1jCdXX4a9n/sJC3Z/2eBhe4KWDsmy2KA2nyYWDktDMynP+N5W7T2RbGZqj1yyRo635/RME5PnFWkGycvTWLYorkITGlUsSw9K6emNqArH2xETR3guLZZrTDLEpAzf+58EmixKglq1nX6iP3y+L0NN4ivK5rkuEdthPJBjXqZGnrKLk1lCvmUXDakEhYWjU7lUwZUSa6L8FmAAEiPquBOcPIoAAAAASUVORK5CYII=","id":"1415245533015010434641","isapp":"1","ismenu":1,"parentid":"-1","priority":1},{"appid":"84BD90F981B142BBBBFB0ED2E25489C6","chfuncmid":0,"funccode":"1:01","funcdesc":"该页面通过折线图的形式统计展示多个厂站之间相同指标的趋势，并可根据条件统计出相应的数据报表","funcnamech":"多厂站（单）指标趋势对比","funcnameen":"multiFactory(Single)IndeTrendContrast","funcurl":"syntheticalquery/multiFacSingleIndeQuery/multiFacSingleIndeList?type=mian","id":"41C1133D770840F1A71950CD32CCD239","isapp":"1","ismenu":1,"parentid":"8F61A8EBFBE1492F8A1CCF50F129D180","priority":1},{"appid":"84BD90F981B142BBBBFB0ED2E25489C6","chfuncmid":12,"funccode":"1","funcdesc":"","funcnamech":"综合查询","funcnameen":"zhcx","funcurl":"","icon":"iVBORw0KGgoAAAANSUhEUgAAABsAAAAUCAYAAAB8gkaAAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTExIDc5LjE1ODMyNSwgMjAxNS8wOS8xMC0wMToxMDoyMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkUzRTI1NDQwMTRCRTExRTY5Q0RBQzBGNjUxOTM2RjE4IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkUzRTI1NDQxMTRCRTExRTY5Q0RBQzBGNjUxOTM2RjE4Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RTNFMjU0M0UxNEJFMTFFNjlDREFDMEY2NTE5MzZGMTgiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RTNFMjU0M0YxNEJFMTFFNjlDREFDMEY2NTE5MzZGMTgiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5htC6uAAAFdklEQVR42pxVa0xTZxh+zmlPb/QKLbfSC4UWhHBRxOGoMp3ZDyMhW7YlTuJcJhrQRPdDp/5aYrLEvy4L2c8tbpmC7hJx021yG07GSkGwCE6EcSsgbemNXk7P2VfN3Mx0MN/k63dOz/u9z/t8743q6+uDyWSCVCoFz/M4deokKjZUYt87b6Oj6zq+udqLN3e+hM3Vm7ESZREOLGJ80Alr2WaotRr8JTPO9jO/91w8npa/rhYJ9jKeIkI8h1BksRSFOHh4F5cwdX+swjvYuT9Hb/i28EV7O8Lhfx/i2ecDSwqHJBjg8S6t67018klaXDxeYcr7IOFxhxIJ7h+eEde4OLgU49rABAI6uRUyNJVB03TnQ0fJlUtB5QYW3Z/KJNKKF7a/sU+spJ08CQfFP2JPEZ14LEbOk2exdnUwRihAMBA888MNx3ZDcZmSiVG3eFlaQK5VeyZ8AatrYr5ya2XFV2ZL/pVHjIkjZMXJD5MktRKDUCwClVjtGnl+xx8P/O+13HTtrCoxw6wClNP9NmboO4wM29AnqkZh6RZYCrIcRHsxiZS8gwSi4FgOvEBC0FiyyL8893QwgUCgJtvZFJncvremNDe+PIHKYD+U7dfAeYaRttSF6S5yOKsGEsshTPvq9uaoRSkE6UMCGPw7jf4jG5Nx8Pl877rn3ftDEbaqvKwETNQFOC4hESFpr1CA9TsQltHI2aSHRnYHAcdh3BxqsSmtje9XbtpWo1HhLInV+aeSOHDgANRqdZJNuUKh+MJsttR3dXbZun/pga2kFKkGK9Fi4BvuQ/iGA0IVj1ieGerMdKTnUEjNAzKzPQgstlJL7hmDWFm1hZGl6GmK66EhiCVYFgIS9yQRQUNDgykjI6NZqVQeJawqLJZc2UokgnPnPsPk+ATkxkLottZCUliO+IwT0bEp0KooFCoWtGABVBagKtoNnbYMt2c43JlXyhXgNsqkzC6RRLLExuOux2BNTU35IyMjH8nl8lSdTge/34+CggJUbqxEf28furt/xHJgBdkbXobulVcBmxHsYBtiHh9SivMQTNuNuw7yfDuA5dlchNMyYS0y0FIKmdFYoobjOCvDMF0ELCpobGz0TU5OXiasDOFwON9oNIJ8hF6vR2lZGULBIH66ehXjrmGI9QXQV+2CpqgaD0im9UZfxxi1F4szY8DCKNSGIpRuqYZMpcPUxCxIecpVGmWZUMjsIWB2amBgAC6XC0KhMMvr9dbabLaPUzUaYRIoKUF/ALf6nbj28/e4f/c+auy1eG3fWxBzAbT/Okt2FsXrdKSWElDI1Ij6g/it3wV1hhbrS4pIA6EwOzvbS8C+fgyWZDM3N8cYTSYrIxKdEjHMnmq7HVKxmJQIB5/fh57uTnzd2ooMkw0NBw/BkK0FTXoeRQux4PFjZGgA8243ysrXw1Zgxdz01Ojg0PBxjSa1NydHH3gCzE0UzWYzqUxaNX7v3haFXN5qsVjENTU1D1nG43GMjt3FxdYWqBVylJZXIMZG4fd5SZ/lUVxSjHxbAbweL4aGho9QFP9lMBha1KWn82az6ZkdZJkE9ko0Eim8Nz5+lDhzJFkiSYeKi4qQeagJTqcD8wtuGI1mrC8vh0atITW6jI6OjvMkJEfjbNxDgY+RXrqmEcMRxQkBTZ8cHR1tOXHiRJvdblfV1dVBq9Vh27YdIA5BJBIhQDK4ra3NSQLUJJFIhsgNhB6C8NwTBulVZxdFrZDg3iAr3+FwnD527BgZV+FkQiEUCqG5uTly4cKFw+R9KwHpJSChZ9la6zzjiZEHxOBpUpPX6+vrL5Fk0lRVVX1OavOgTquNkO+J1Yz83+FJxlOsk9RiTnZ2NrO8vBwiYGwyvdcifwowAEVeWKgHiE7EAAAAAElFTkSuQmCC","id":"8F61A8EBFBE1492F8A1CCF50F129D180","isapp":"1","ismenu":1,"parentid":"-1","priority":1},{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:02","funcdesc":"","funcnamech":"再生水输配日报","funcnameen":"zssrb","funcurl":"/rundata/daily/indeFill/list?tableName=WATERSP_DAILY&flowCode=YWLC00021","id":"37CFF53929BE4BB9A8F7F5AEC137299F","isapp":"1","ismenu":1,"parentid":"142933219070868803212","priority":2},{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:03","funcdesc":"","funcnamech":"污泥运输日报","funcnameen":"wnys","funcurl":"/rundata/daily/indeFill/list?tableName=WNYS_DAILY&flowCode=YWLC002","id":"0EFDA623E85A4872950892382F85B9DD","isapp":"1","ismenu":1,"parentid":"142933219070868803212","priority":3},{"appid":"84BD90F981B142BBBBFB0ED2E25489C6","chfuncmid":0,"funccode":"1:03","funcdesc":"","funcnamech":"厂站（单）指标历史同期趋势对比","funcnameen":"singleFacSingleIndeQuery","funcurl":"syntheticalquery/singleFacSingleIndeQuery/singleFacSingleIndeList?type=main&tableName=VIEW_REPORT","id":"21BBF13959D30787E050007F01000F7C","isapp":"1","ismenu":1,"parentid":"8F61A8EBFBE1492F8A1CCF50F129D180","priority":3},{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:04","funcdesc":"","funcnamech":"污泥处置日报","funcnameen":"wncz","funcurl":"/rundata/daily/indeFill/list?tableName=WNRB_DAILY&flowCode=YWLC0006","id":"957309E459B54B3EBDC6B8DCC72ABB97","isapp":"1","ismenu":1,"parentid":"142933219070868803212","priority":4},{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:05","funcdesc":"","funcnamech":"水厂运行日报月度重点指标审核","funcnameen":"scyxydsh","funcurl":"/rundata/daily/indeFill/list?tableName=DAILY_WATER&flowCode=YWLC0111","id":"654B2D192ADA44BD90D08E8BE980C285","isapp":"1","ismenu":1,"parentid":"142933219070868803212","priority":5},{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:07","funcdesc":"","funcnamech":"再生水输配重点指标月度审核","funcnameen":"spydsh","funcurl":"/rundata/daily/indeFill/list?tableName=WATERSP_DAILY&flowCode=YWLC0113","id":"229A22488C995145E050007F01006B4D","isapp":"1","ismenu":1,"parentid":"142933219070868803212","priority":7},{"appid":"141524548287927574821","chfuncmid":0,"funccode":"0:07:01:08","funcdesc":"","funcnamech":"污泥处置日报月度重点指标审核","funcnameen":"wnczzdsh","funcurl":"/rundata/daily/indeFill/list?tableName=WNRB_DAILY&flowCode=YWLC0114","id":"23273CE868BBBA26E050007F010058A3","isapp":"1","ismenu":1,"parentid":"142933219070868803212","priority":8},{"appid":"84BD90F981B142BBBBFB0ED2E25489C6","chfuncmid":0,"funccode":"1:08","funcdesc":"按指标查询","funcnamech":"按指标查询","funcnameen":"zbcx","funcurl":"syntheticalquery/indeQuery/list?flag=1","id":"BB99D6497B264551B14363D2ADDB911D","isapp":"1","ismenu":1,"parentid":"8F61A8EBFBE1492F8A1CCF50F129D180","priority":8},{"appid":"84BD90F981B142BBBBFB0ED2E25489C6","chfuncmid":0,"funccode":"1:09","funcdesc":"按指标组查询","funcnamech":"按指标组查询","funcnameen":"zbzcx","funcurl":"syntheticalquery/indegrpQuery/list?flag=1","id":"E58D7C14CFE74B74B34F0AE150C57D55","isapp":"1","ismenu":1,"parentid":"8F61A8EBFBE1492F8A1CCF50F129D180","priority":9},{"appid":"84BD90F981B142BBBBFB0ED2E25489C6","chfuncmid":0,"funccode":"1:10","funcdesc":"","funcnamech":"各分厂指标日数据对比","funcnameen":"allFacallFacDailyListDaily","funcurl":"syntheticalquery/allFacDaily/allFacDailyList?type=main","id":"21D218793A4B911DE050007F010076FC","isapp":"1","ismenu":1,"parentid":"8F61A8EBFBE1492F8A1CCF50F129D180","priority":10},{"appid":"7967FEA6C0F34F61885C85B6499350C3","chfuncmid":0,"funccode":"4:13","funcdesc":"污水处理厂流量计显示值及日处理水量","funcnamech":"污水处理厂流量计显示值及日处理水量","funcnameen":"lljxszjrclsl","funcurl":"/report/report/lljxsz","id":"21BCA4CB705C045AE050007F01001A6B","isapp":"1","ismenu":1,"parentid":"21F72FDA90EEBEF1E050007F01004730","priority":13}]
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;
    /**
     * appid : 1415245533015010434641
     * chfuncmid : 9
     * funccode : 0:07:01
     * funcdesc :
     * funcnamech : 日报上报
     * funcnameen : rbsb
     * funcurl :
     * id : 142933219070868803212
     * isapp : 1
     * ismenu : 1
     * parentid : 1415245533015010434641
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
