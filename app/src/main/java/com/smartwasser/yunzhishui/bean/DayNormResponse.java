package com.smartwasser.yunzhishui.bean;

import java.util.List;
/**
 * Created by huangmengjie on 2016/5/20 0020.
 */
public class DayNormResponse extends RBResponse{
    /**
     * indeList : [{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"2016-05-02","ID":"5470c43d169c11e69477000c29b2d655","INDE_CODE":"fsdf","INDE_NAME":"月报指标1","INDE_VALUE":"-"},{"ASSU_UNIT":"CZWS2202","BUSINESS_UNIT_NAME":"wesdsd","DATA_DATE":"2016-05-02","ID":"0fe406321da611e69ffe000c29b2d655","INDE_CODE":"fsdf","INDE_NAME":"月报指标1","INDE_VALUE":"85"},{"ASSU_UNIT":"CZWS3453","BUSINESS_UNIT_NAME":"3453","DATA_DATE":"2016-05-02","ID":"0c5cf4351da511e69ffe000c29b2d655","INDE_CODE":"fsdf","INDE_NAME":"月报指标1","INDE_VALUE":"213"}]
     * indeValueMax :
     * indeValueMin :
     */
    private DataEntity data;
    /**
     * data : {"indeList":[{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"2016-05-02","ID":"5470c43d169c11e69477000c29b2d655","INDE_CODE":"fsdf","INDE_NAME":"月报指标1","INDE_VALUE":"-"},{"ASSU_UNIT":"CZWS2202","BUSINESS_UNIT_NAME":"wesdsd","DATA_DATE":"2016-05-02","ID":"0fe406321da611e69ffe000c29b2d655","INDE_CODE":"fsdf","INDE_NAME":"月报指标1","INDE_VALUE":"85"},{"ASSU_UNIT":"CZWS3453","BUSINESS_UNIT_NAME":"3453","DATA_DATE":"2016-05-02","ID":"0c5cf4351da511e69ffe000c29b2d655","INDE_CODE":"fsdf","INDE_NAME":"月报指标1","INDE_VALUE":"213"}],"indeValueMax":"","indeValueMin":""}
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
        private String indeValueMax;
        private String indeValueMin;
        /**
         * ASSU_UNIT : CZWS0835
         * BUSINESS_UNIT_NAME : 康庄污水处理厂
         * DATA_DATE : 2016-05-02
         * ID : 5470c43d169c11e69477000c29b2d655
         * INDE_CODE : fsdf
         * INDE_NAME : 月报指标1
         * INDE_VALUE : -
         */
        private List<IndeListEntity> indeList;
        public void setIndeValueMax(String indeValueMax) {
            this.indeValueMax = indeValueMax;
        }

        public void setIndeValueMin(String indeValueMin) {
            this.indeValueMin = indeValueMin;
        }

        public void setIndeList(List<IndeListEntity> indeList) {
            this.indeList = indeList;
        }

        public String getIndeValueMax() {
            return indeValueMax;
        }

        public String getIndeValueMin() {
            return indeValueMin;
        }

        public List<IndeListEntity> getIndeList() {
            return indeList;
        }

        public static class IndeListEntity {
            private String ASSU_UNIT;
            private String BUSINESS_UNIT_NAME;
            private String DATA_DATE;
            private String ID;
            private String INDE_CODE;
            private String INDE_NAME;
            private String INDE_VALUE;

            public void setASSU_UNIT(String ASSU_UNIT) {
                this.ASSU_UNIT = ASSU_UNIT;
            }

            public void setBUSINESS_UNIT_NAME(String BUSINESS_UNIT_NAME) {
                this.BUSINESS_UNIT_NAME = BUSINESS_UNIT_NAME;
            }

            public void setDATA_DATE(String DATA_DATE) {
                this.DATA_DATE = DATA_DATE;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public void setINDE_CODE(String INDE_CODE) {
                this.INDE_CODE = INDE_CODE;
            }

            public void setINDE_NAME(String INDE_NAME) {
                this.INDE_NAME = INDE_NAME;
            }

            public void setINDE_VALUE(String INDE_VALUE) {
                this.INDE_VALUE = INDE_VALUE;
            }

            public String getASSU_UNIT() {
                return ASSU_UNIT;
            }

            public String getBUSINESS_UNIT_NAME() {
                return BUSINESS_UNIT_NAME;
            }

            public String getDATA_DATE() {
                return DATA_DATE;
            }

            public String getID() {
                return ID;
            }

            public String getINDE_CODE() {
                return INDE_CODE;
            }

            public String getINDE_NAME() {
                return INDE_NAME;
            }

            public String getINDE_VALUE() {
                return INDE_VALUE;
            }
        }
    }
}
