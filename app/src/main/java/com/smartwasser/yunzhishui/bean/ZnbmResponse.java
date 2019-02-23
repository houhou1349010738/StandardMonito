package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/28 0028.
 */
public class ZnbmResponse extends RBResponse{
    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"F7EE859577AD478FABD326FA76779E0C","selected":false,"text":"工程技术部"},{"id":"163440B45B9847298578F215653B496C","selected":false,"text":"经营采购部"},{"id":"5702C10B1DD84A80BF28809EFDF167E1","selected":false,"text":"安全品控部"},{"id":"6B2171036AC84F0FBA62F2AC8F607417","selected":false,"text":"开发研究部"},{"id":"65C68F4349084EB0831EEA2232E0EFB4","selected":false,"text":"人力资源部"},{"id":"4FB651486C4C4B5094069209A5701790","selected":false,"text":"财务资产部"},{"id":"6D58F4CE91544229B9651F99C4874A5D","selected":false,"text":"行政综合部"}]}
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
