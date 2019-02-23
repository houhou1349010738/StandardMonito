package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class AddTypResponse extends RBResponse {
    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"ZPLYD","selected":false,"text":"支票领用单"},{"id":"ZCBXD","selected":false,"text":"支出报销单"},{"id":"WGCCBXD","selected":false,"text":"外埠出差报销单"},{"id":"QTYSZCBXD","selected":false,"text":"其他预算支出报销单"},{"id":"JKD","selected":false,"text":"借款单"},{"id":"XJZCBXD","selected":false,"text":"现金支出报销单"}]}
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
