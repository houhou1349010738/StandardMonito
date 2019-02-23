package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/29 0029.
 */
public class BusinessUnitResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"CZZS3800","selected":false,"text":"卢沟桥再生水厂"},{"id":"CZWS1222","selected":false,"text":"方庄污水厂"},{"id":"CZZS1044","selected":false,"text":"吴家村再生水二期"},{"id":"CZZS1042","selected":false,"text":"吴家村再生水一期"},{"id":"CZWN1030","selected":false,"text":"小红门污泥分厂"},{"id":"CZWS1025","selected":false,"text":"小红门运行分厂"},{"id":"CZWS0801","selected":false,"text":"高碑店污水处理厂"},{"id":"CZZS0642","selected":false,"text":"酒仙桥14万吨"},{"id":"CZWS0642","selected":false,"text":"酒仙桥20万吨"},{"id":"CZZS0632","selected":false,"text":"北小河6万吨"},{"id":"CZWS0622","selected":false,"text":"清河40万吨"},{"id":"CZZS0622","selected":false,"text":"清河32万吨"},{"id":"CZWS3800","selected":false,"text":"卢沟桥污水"},{"id":"CZZS0624","selected":false,"text":"清河8万吨"},{"id":"CZZS1222","selected":false,"text":"方庄再生水"},{"id":"CZWS1220","selected":false,"text":"方庄厂"},{"id":"CZZS0621","selected":false,"text":"清河15万吨"},{"id":"CZZS0634","selected":false,"text":"北小河4万吨"},{"id":"CZWS0101","selected":false,"text":"集团"},{"id":"CZWS1040","selected":false,"text":"吴家村再生水厂"},{"id":"CZWS0820","selected":false,"text":"高碑店一分厂"},{"id":"CZWS0640","selected":false,"text":"酒仙桥再生水厂"},{"id":"CZZS0644","selected":false,"text":"酒仙桥6万吨"},{"id":"CZWS1042","selected":false,"text":"吴家村8万吨"},{"id":"CZWS0825","selected":false,"text":"高碑店二分厂"},{"id":"CZWS1020","selected":false,"text":"小红门厂"},{"id":"CZWS0620","selected":false,"text":"清河再生水厂"},{"id":"CZWS1208","selected":false,"text":"中水系统"},{"id":"CZWS0631","selected":false,"text":"北小河再生水厂"}]}
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
