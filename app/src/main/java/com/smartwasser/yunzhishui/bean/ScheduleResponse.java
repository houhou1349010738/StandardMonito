package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/20 0020.
 */
public class ScheduleResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"fill_fybxsq","selected":false,"text":"费用报销申请"},{"id":"review_xmjlsh","selected":false,"text":"项目经理审核"},{"id":"review_fzgsglcsh","selected":false,"text":"分子公司/管理处审核"},{"id":"review_kjsh","selected":false,"text":"会计审核"},{"id":"review_znbmsh","selected":false,"text":"职能部门审核"},{"id":"review_cwjlsh","selected":false,"text":"财务经理审核"},{"id":"review_fgldsh","selected":false,"text":"分管领导审核"},{"id":"review_zjlsh","selected":false,"text":"总经理审核"},{"id":"review_cnjkjhz","selected":false,"text":"出纳及会计核准"}]}
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
