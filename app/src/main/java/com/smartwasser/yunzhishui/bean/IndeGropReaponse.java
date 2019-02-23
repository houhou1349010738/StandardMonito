package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class IndeGropReaponse extends RBResponse {
    private DataEntity data;
    /**
     * data : {"dailyIndeGrpList":[{"assu_unit":"CZWS0835","business_unit_name":"康庄污水处理厂","data_date":"2016-05-02","data_unit":"mg","inde_code":"asss","inde_have_name":"","inde_name":"aaaa","inde_nice_name":"","inde_value":"44","record_man_name":"后台管理员","record_time":"2016-05-10 18:46:41","review1_man_name":"后台管理员","review1_time":"2016-05-11 14:20:38","review2_man_name":"后台管理员","review2_time":"2016-05-11 14:20:42","review_man_name":"后台管理员","review_time":"2016-05-11 14:20:29","up_stat":"集团审核通过"},{"assu_unit":"CZWS0835","business_unit_name":"康庄污水处理厂","data_date":"2016-05-02","data_unit":"mg","inde_code":"fsdf","inde_have_name":"","inde_name":"月报指标1","inde_nice_name":"","inde_value":"-","record_man_name":"后台管理员","record_time":"2016-05-10 18:46:41","review1_man_name":"后台管理员","review1_time":"2016-05-11 14:20:38","review2_man_name":"后台管理员","review2_time":"2016-05-11 14:20:42","review_man_name":"后台管理员","review_time":"2016-05-11 14:20:29","up_stat":"集团审核通过"},{"assu_unit":"CZWS0835","business_unit_name":"康庄污水处理厂","data_date":"2016-04-12","data_unit":"mg","inde_code":"asss","inde_have_name":"","inde_name":"aaaa","inde_nice_name":"","inde_value":"5435435","record_man_name":"后台管理员","record_time":"2016-05-12 19:10:07","review1_man_name":"后台管理员","review1_time":"2016-05-16 11:56:37","review2_man_name":"后台管理员","review2_time":"2016-05-16 11:56:45","review_man_name":"后台管理员","review_time":"2016-05-16 11:56:30","up_stat":"集团审核退回"},{"assu_unit":"CZWS0835","business_unit_name":"康庄污水处理厂","data_date":"2016-04-12","data_unit":"mg","inde_code":"fsdf","inde_have_name":"","inde_name":"月报指标1","inde_nice_name":"","inde_value":"1232131","record_man_name":"后台管理员","record_time":"2016-05-12 19:10:07","review1_man_name":"后台管理员","review1_time":"2016-05-16 11:56:37","review2_man_name":"后台管理员","review2_time":"2016-05-16 11:56:45","review_man_name":"后台管理员","review_time":"2016-05-16 11:56:30","up_stat":"集团审核通过"},{"assu_unit":"CZWS0835","business_unit_name":"康庄污水处理厂","data_date":"2016-01-19","data_unit":"mg","inde_code":"asss","inde_have_name":"","inde_name":"aaaa","inde_nice_name":"","inde_value":"22222","record_man_name":"后台管理员","record_time":"2016-05-19 15:25:36","up_stat":"填报"},{"assu_unit":"CZWS0835","business_unit_name":"康庄污水处理厂","data_date":"2016-01-19","data_unit":"mg","inde_code":"fsdf","inde_have_name":"","inde_name":"月报指标1","inde_nice_name":"","inde_value":"月报指标1 22222","record_man_name":"后台管理员","record_time":"2016-05-19 15:25:36","up_stat":"填报"}]}
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
         * assu_unit : CZWS0835
         * business_unit_name : 康庄污水处理厂
         * data_date : 2016-05-02
         * data_unit : mg
         * inde_code : asss
         * inde_have_name :
         * inde_name : aaaa
         * inde_nice_name :
         * inde_value : 44
         * record_man_name : 后台管理员
         * record_time : 2016-05-10 18:46:41
         * review1_man_name : 后台管理员
         * review1_time : 2016-05-11 14:20:38
         * review2_man_name : 后台管理员
         * review2_time : 2016-05-11 14:20:42
         * review_man_name : 后台管理员
         * review_time : 2016-05-11 14:20:29
         * up_stat : 集团审核通过
         */

        private List<DailyIndeGrpListEntity> dailyIndeGrpList;

        public void setDailyIndeGrpList(List<DailyIndeGrpListEntity> dailyIndeGrpList) {
            this.dailyIndeGrpList = dailyIndeGrpList;
        }

        public List<DailyIndeGrpListEntity> getDailyIndeGrpList() {
            return dailyIndeGrpList;
        }

        public static class DailyIndeGrpListEntity {
            private String assu_unit;
            private String business_unit_name;
            private String data_date;
            private String data_unit;
            private String inde_code;
            private String inde_have_name;
            private String inde_name;
            private String inde_nice_name;
            private String inde_value;
            private String record_man_name;
            private String record_time;
            private String review1_man_name;
            private String review1_time;
            private String review2_man_name;
            private String review2_time;
            private String review_man_name;
            private String review_time;
            private String up_stat;

            public void setAssu_unit(String assu_unit) {
                this.assu_unit = assu_unit;
            }

            public void setBusiness_unit_name(String business_unit_name) {
                this.business_unit_name = business_unit_name;
            }

            public void setData_date(String data_date) {
                this.data_date = data_date;
            }

            public void setData_unit(String data_unit) {
                this.data_unit = data_unit;
            }

            public void setInde_code(String inde_code) {
                this.inde_code = inde_code;
            }

            public void setInde_have_name(String inde_have_name) {
                this.inde_have_name = inde_have_name;
            }

            public void setInde_name(String inde_name) {
                this.inde_name = inde_name;
            }

            public void setInde_nice_name(String inde_nice_name) {
                this.inde_nice_name = inde_nice_name;
            }

            public void setInde_value(String inde_value) {
                this.inde_value = inde_value;
            }

            public void setRecord_man_name(String record_man_name) {
                this.record_man_name = record_man_name;
            }

            public void setRecord_time(String record_time) {
                this.record_time = record_time;
            }

            public void setReview1_man_name(String review1_man_name) {
                this.review1_man_name = review1_man_name;
            }

            public void setReview1_time(String review1_time) {
                this.review1_time = review1_time;
            }

            public void setReview2_man_name(String review2_man_name) {
                this.review2_man_name = review2_man_name;
            }

            public void setReview2_time(String review2_time) {
                this.review2_time = review2_time;
            }

            public void setReview_man_name(String review_man_name) {
                this.review_man_name = review_man_name;
            }

            public void setReview_time(String review_time) {
                this.review_time = review_time;
            }

            public void setUp_stat(String up_stat) {
                this.up_stat = up_stat;
            }

            public String getAssu_unit() {
                return assu_unit;
            }

            public String getBusiness_unit_name() {
                return business_unit_name;
            }

            public String getData_date() {
                return data_date;
            }

            public String getData_unit() {
                return data_unit;
            }

            public String getInde_code() {
                return inde_code;
            }

            public String getInde_have_name() {
                return inde_have_name;
            }

            public String getInde_name() {
                return inde_name;
            }

            public String getInde_nice_name() {
                return inde_nice_name;
            }

            public String getInde_value() {
                return inde_value;
            }

            public String getRecord_man_name() {
                return record_man_name;
            }

            public String getRecord_time() {
                return record_time;
            }

            public String getReview1_man_name() {
                return review1_man_name;
            }

            public String getReview1_time() {
                return review1_time;
            }

            public String getReview2_man_name() {
                return review2_man_name;
            }

            public String getReview2_time() {
                return review2_time;
            }

            public String getReview_man_name() {
                return review_man_name;
            }

            public String getReview_time() {
                return review_time;
            }

            public String getUp_stat() {
                return up_stat;
            }
        }
    }
}
