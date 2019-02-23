package com.smartwasser.yunzhishui.bean;
import java.util.List;
/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class TreadResponse extends RBResponse{
    /**
     * data : [{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"03月","INDE_CODE":"asss","INDE_NAME":"aaaa","INDE_VALUE":"5435435","YEARS":"2016年"},{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"04月","INDE_CODE":"asss","INDE_NAME":"aaaa","INDE_VALUE":"44","YEARS":"2016年"},{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"05月","INDE_CODE":"asss","INDE_NAME":"aaaa","INDE_VALUE":"","YEARS":"2016年"},{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"03月","INDE_CODE":"asss","INDE_NAME":"aaaa","INDE_VALUE":"","YEARS":"2015年"},{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"04月","INDE_CODE":"asss","INDE_NAME":"aaaa","INDE_VALUE":"","YEARS":"2015年"},{"ASSU_UNIT":"CZWS0835","BUSINESS_UNIT_NAME":"康庄污水处理厂","DATA_DATE":"05月","INDE_CODE":"asss","INDE_NAME":"aaaa","INDE_VALUE":"","YEARS":"2015年"}]
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;
    /**
     * ASSU_UNIT : CZWS0835
     * BUSINESS_UNIT_NAME : 康庄污水处理厂
     * DATA_DATE : 03月
     * INDE_CODE : asss
     * INDE_NAME : aaaa
     * INDE_VALUE : 5435435
     * YEARS : 2016年
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
        private String ASSU_UNIT;
        private String BUSINESS_UNIT_NAME;
        private String DATA_DATE;
        private String INDE_CODE;
        private String INDE_NAME;
        private String INDE_VALUE;
        private String YEARS;

        public void setASSU_UNIT(String ASSU_UNIT) {
            this.ASSU_UNIT = ASSU_UNIT;
        }

        public void setBUSINESS_UNIT_NAME(String BUSINESS_UNIT_NAME) {
            this.BUSINESS_UNIT_NAME = BUSINESS_UNIT_NAME;
        }

        public void setDATA_DATE(String DATA_DATE) {
            this.DATA_DATE = DATA_DATE;
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

        public void setYEARS(String YEARS) {
            this.YEARS = YEARS;
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

        public String getINDE_CODE() {
            return INDE_CODE;
        }

        public String getINDE_NAME() {
            return INDE_NAME;
        }

        public String getINDE_VALUE() {
            return INDE_VALUE;
        }

        public String getYEARS() {
            return YEARS;
        }
    }
}
