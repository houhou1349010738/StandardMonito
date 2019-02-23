package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/6 0006.
 */
public class HitchBuweiResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"1","selected":false,"text":"驱动"},{"id":"10","selected":false,"text":"监测"},{"id":"11","selected":false,"text":"输送"},{"id":"12","selected":false,"text":"存储"},{"id":"13","selected":false,"text":"密封"},{"id":"14","selected":false,"text":"其它"},{"id":"2","selected":false,"text":"传动"},{"id":"3","selected":false,"text":"结构"},{"id":"4","selected":false,"text":"机构"},{"id":"5","selected":false,"text":"旋转"},{"id":"6","selected":false,"text":"转动"},{"id":"7","selected":false,"text":"电气"},{"id":"8","selected":false,"text":"控制"},{"id":"9","selected":false,"text":"显示"}]}
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
         * id :
         * selected : true
         * text : 请选择
         */

        private List<ComboboxListEntity> comboboxList;

        public void setComboboxList(List<ComboboxListEntity> comboboxList) {
            this.comboboxList = comboboxList;
        }

        public List<ComboboxListEntity> getComboboxList() {
            return comboboxList;
        }

        public static class ComboboxListEntity {
            private String id;
            private boolean selected;
            private String text;

            public void setId(String id) {
                this.id = id;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getId() {
                return id;
            }

            public boolean isSelected() {
                return selected;
            }

            public String getText() {
                return text;
            }
        }
    }
}
