package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/5/6 0006.
 */
public class AddUnitResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"pageBuList":[{"businessUnitCode":"CZWS4026","businessUnitName":"酒仙桥20万吨再生水","creatManCode":"root","creatManName":"后台管理员","id":"CA7E7E3B45A44ABFB77A3B72FCA3DD96","orderBy":7,"parentUnitCode":"CZWS3844","properites":"WS","status":1,"updateManCode":"root","updateManName":"后台管理员"},{"businessUnitCode":"CZWS0835","businessUnitName":"康庄污水处理厂","id":"13","orderBy":113,"parentUnitCode":"0","properites":"WS","stUnitCode":"1102560000","stUnitName":"高碑店厂康庄厂","status":1,"updateManCode":"root","updateManName":"后台管理员","usergroupCode":"100130130","usergroupName":"高碑店康庄厂"}]}
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
         * businessUnitCode : CZWS4026
         * businessUnitName : 酒仙桥20万吨再生水
         * creatManCode : root
         * creatManName : 后台管理员
         * id : CA7E7E3B45A44ABFB77A3B72FCA3DD96
         * orderBy : 7
         * parentUnitCode : CZWS3844
         * properites : WS
         * status : 1
         * updateManCode : root
         * updateManName : 后台管理员
         */

        private List<PageBuListEntity> pageBuList;

        public void setPageBuList(List<PageBuListEntity> pageBuList) {
            this.pageBuList = pageBuList;
        }

        public List<PageBuListEntity> getPageBuList() {
            return pageBuList;
        }

        public static class PageBuListEntity {
            private String businessUnitCode;
            private String businessUnitName;
            private String creatManCode;
            private String creatManName;
            private String id;
            private int orderBy;
            private String parentUnitCode;
            private String properites;
            private int status;
            private String updateManCode;
            private String updateManName;

            public void setBusinessUnitCode(String businessUnitCode) {
                this.businessUnitCode = businessUnitCode;
            }

            public void setBusinessUnitName(String businessUnitName) {
                this.businessUnitName = businessUnitName;
            }

            public void setCreatManCode(String creatManCode) {
                this.creatManCode = creatManCode;
            }

            public void setCreatManName(String creatManName) {
                this.creatManName = creatManName;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setOrderBy(int orderBy) {
                this.orderBy = orderBy;
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

            public String getBusinessUnitCode() {
                return businessUnitCode;
            }

            public String getBusinessUnitName() {
                return businessUnitName;
            }

            public String getCreatManCode() {
                return creatManCode;
            }

            public String getCreatManName() {
                return creatManName;
            }

            public String getId() {
                return id;
            }

            public int getOrderBy() {
                return orderBy;
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
        }
    }
}
