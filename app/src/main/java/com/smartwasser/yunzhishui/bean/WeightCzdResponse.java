package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/13 0013.
 */
public class WeightCzdResponse extends RBResponse {

    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"WeightPointManagement":[{"id":"","text":"全部","selected":true,"desc":null},{"id":"热","text":"人","selected":false,"desc":null},{"id":"CZD11","text":"通州北堤寺处置场","selected":false,"desc":null}]}
     */

    private String errorCode;
    private String errorMsg;
    private DataEntity data;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * id :
         * text : 全部
         * selected : true
         * desc : null
         */

        private List<WeightPointManagementEntity> WeightPointManagement;

        public void setWeightPointManagement(List<WeightPointManagementEntity> WeightPointManagement) {
            this.WeightPointManagement = WeightPointManagement;
        }

        public List<WeightPointManagementEntity> getWeightPointManagement() {
            return WeightPointManagement;
        }

        public static class WeightPointManagementEntity {
            private String id;
            private String text;
            private boolean selected;
            private Object desc;

            public void setId(String id) {
                this.id = id;
            }

            public void setText(String text) {
                this.text = text;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public void setDesc(Object desc) {
                this.desc = desc;
            }

            public String getId() {
                return id;
            }

            public String getText() {
                return text;
            }

            public boolean isSelected() {
                return selected;
            }

            public Object getDesc() {
                return desc;
            }
        }
    }
}
