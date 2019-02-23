package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/6 0006.
 */
public class SubordinateResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"listTree":[{"businessUnitCode":"0","businessUnitName":"业务单元","id":"0","parentUnitCode":"-1","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 18:54:51"},{"businessUnitCode":"xx","businessUnitName":"aaa","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-25 00:14:21","id":"3ad35b44224811e69ffe000c29b2d655","orderBy":1,"parentUnitCode":"CZWS3844","properites":"WN","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-25 00:14:21"},{"businessUnitCode":"CZWS0820","businessUnitName":"高碑店一分厂","id":"402836814c0c2e1d014c0c3543ff0000","parentUnitCode":"CZWS0801","status":1},{"businessUnitCode":"CZWS0825","businessUnitName":"高碑店二分厂","id":"402836814c6da5b0014c6dc0442e0000","parentUnitCode":"CZWS0801","status":1},{"businessUnitCode":"CZWN0830","businessUnitName":"高碑店污泥","id":"402836914c6da5b0014c6dc0442e0000","parentUnitCode":"CZWS0801","status":1},{"businessUnitCode":"CZWS3844","businessUnitName":"酒仙桥再生水厂","id":"4028812d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"ZS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-25 00:14:02"},{"businessUnitCode":"CZZS3845","businessUnitName":"酒仙桥6万吨再生水","id":"4028814d40c8de2e0140c915c81f0000","orderBy":21,"parentUnitCode":"CZWS3844","properites":"GW","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-24 11:33:54"},{"businessUnitCode":"CZZS3846","businessUnitName":"酒仙桥14万吨再生水","id":"4028815d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3844","properites":"CS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-18 20:00:58"},{"businessUnitCode":"CZWS3843","businessUnitName":"清河再生水厂","id":"4028816d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 18:05:21"},{"businessUnitCode":"CZWS0620","businessUnitName":"清河40万吨污水","id":"4028817d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3843","status":1},{"businessUnitCode":"CZZS0621","businessUnitName":"清河15万吨再生水","id":"4028818d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3843","properites":"CS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-18 19:51:25"},{"businessUnitCode":"CZZS0623","businessUnitName":"清河32万吨再生水","id":"4028819d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3843","status":1},{"businessUnitCode":"CZWS0801","businessUnitName":"高碑店污水处理厂","id":"402881ed40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 19:04:03"},{"businessUnitCode":"CZZS0625","businessUnitName":"清河8万吨再生水","id":"4028820d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3843","status":1},{"businessUnitCode":"CZWS0631","businessUnitName":"北小河再生水厂","id":"4028821d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 19:04:14"},{"businessUnitCode":"CZZS3848","businessUnitName":"北小河6万吨再生水","id":"4028822d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS0631","status":1},{"businessUnitCode":"CZZS3847","businessUnitName":"北小河4万吨再生水","id":"4028823d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS0631","status":1},{"businessUnitCode":"CZWS1020","businessUnitName":"小红门污水处理厂","id":"4028824d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 19:04:21"},{"businessUnitCode":"CZWS1025","businessUnitName":"小红门运行分厂","id":"4028825d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS1020","status":1},{"businessUnitCode":"CZWN1030","businessUnitName":"小红门污泥分厂","id":"4028826d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS1020","status":1},{"businessUnitCode":"CZWS3849","businessUnitName":"吴家村再生水厂","id":"4028827d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 19:12:30"},{"businessUnitCode":"CZWS1040","businessUnitName":"吴家村8万吨污水","id":"4028828d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3849","status":1},{"businessUnitCode":"CZZS3850","businessUnitName":"吴家村再生水一期","id":"4028829d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3849","status":1},{"businessUnitCode":"CZZS3851","businessUnitName":"吴家村再生水二期","id":"4028830d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3849","status":1},{"businessUnitCode":"CZWS3852","businessUnitName":"方庄再生水厂","id":"4028831d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 19:12:21"},{"businessUnitCode":"CZWS1220","businessUnitName":"方庄4万吨污水","id":"4028832d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3852","status":1},{"businessUnitCode":"CZZS3842","businessUnitName":"方庄0.5万吨再生水","id":"4028833d40c8de2e0140c915c81f0000","parentUnitCode":"CZWS3852","status":1},{"businessUnitCode":"CZWS3020","businessUnitName":"房山城关污水处理厂","id":"4028834d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 17:40:29"},{"businessUnitCode":"CZWS3200","businessUnitName":"大兴黄村污水处理厂","id":"4028835d40c8de2e0140c915c81f0000","parentUnitCode":"0","status":1},{"businessUnitCode":"CZWS3600","businessUnitName":"西郎污水处理厂","id":"4028836d40c8de2e0140c915c81f0000","parentUnitCode":"0","status":1},{"businessUnitCode":"CZWS3800","businessUnitName":"卢沟桥污水处理厂","id":"4028837d40c8de2e0140c915c81f0000","parentUnitCode":"0","status":1},{"businessUnitCode":"CZWS3807","businessUnitName":"庞各庄污水处理厂","id":"4028838d40c8de2e0140c915c81f0000","parentUnitCode":"0","status":1},{"businessUnitCode":"CZWS3839","businessUnitName":"西二旗再生水厂","id":"4028839d40c8de2e0140c915c81f0000","parentUnitCode":"0","status":1},{"businessUnitCode":"CZWS3838","businessUnitName":"卢沟桥再生水厂","id":"4028840d40c8de2e0140c915c81f0000","parentUnitCode":"0","status":1},{"businessUnitCode":"CZWN1600","businessUnitName":"污泥分公司","id":"4028841d40c8de2e0140c915c81f0000","parentUnitCode":"0","properites":"","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 19:12:03"},{"businessUnitCode":"CZWN0645","businessUnitName":"清河污泥干化","id":"4028842d40c8de2e0140c915c81f0000","parentUnitCode":"CZWN1600","status":1},{"businessUnitCode":"CZWN1625","businessUnitName":"小红门污泥干化","id":"4028843d40c8de2e0140c915c81f0000","parentUnitCode":"CZWN1600","status":1},{"businessUnitCode":"CZWN1620","businessUnitName":"庞各庄污泥处置","id":"4028844d40c8de2e0140c915c81f0000","parentUnitCode":"CZWN1600","status":1},{"businessUnitCode":"123","businessUnitName":"测试","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-18 19:42:42","id":"577179231d6b11e69ffe000c29b2d655","orderBy":1,"parentUnitCode":"CZWS3843","properites":"CS","status":2,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-18 20:01:21"},{"businessUnitCode":"1","businessUnitName":"测试2","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-18 19:52:56","id":"c4db01cf1d6c11e69ffe000c29b2d655","orderBy":344,"parentUnitCode":"CZZS0621","properites":"GW","status":2,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-18 19:52:56"}]}
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
         * businessUnitCode : 0
         * businessUnitName : 业务单元
         * id : 0
         * parentUnitCode : -1
         * properites :
         * status : 1
         * updateManCode : root
         * updateManName : 后台管理员
         * updateTime : 2016-04-11 18:54:51
         */

        private List<ListTreeEntity> listTree;

        public void setListTree(List<ListTreeEntity> listTree) {
            this.listTree = listTree;
        }

        public List<ListTreeEntity> getListTree() {
            return listTree;
        }

        public static class ListTreeEntity {
            private String businessUnitCode;
            private String businessUnitName;
            private String id;
            private String parentUnitCode;
            private String properites;
            private int status;
            private String updateManCode;
            private String updateManName;
            private String updateTime;

            public void setBusinessUnitCode(String businessUnitCode) {
                this.businessUnitCode = businessUnitCode;
            }

            public void setBusinessUnitName(String businessUnitName) {
                this.businessUnitName = businessUnitName;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setParentUnitCode(String parentUnitCode) {
                this.parentUnitCode = parentUnitCode;
            }

            public void setProperites(String properites) {
                this.properites = properites;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setUpdateManCode(String updateManCode) {
                this.updateManCode = updateManCode;
            }

            public void setUpdateManName(String updateManName) {
                this.updateManName = updateManName;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getBusinessUnitCode() {
                return businessUnitCode;
            }

            public String getBusinessUnitName() {
                return businessUnitName;
            }

            public String getId() {
                return id;
            }

            public String getParentUnitCode() {
                return parentUnitCode;
            }

            public String getProperites() {
                return properites;
            }

            public int getStatus() {
                return status;
            }

            public String getUpdateManCode() {
                return updateManCode;
            }

            public String getUpdateManName() {
                return updateManName;
            }

            public String getUpdateTime() {
                return updateTime;
            }
        }
    }
}
