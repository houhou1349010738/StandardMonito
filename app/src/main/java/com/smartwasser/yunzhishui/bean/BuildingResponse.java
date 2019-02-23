package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/29 0029.
 */
public class BuildingResponse extends RBResponse{
    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"BBI00433","selected":false,"text":"1#V型滤池"},{"id":"BBI00434","selected":false,"text":"2#V型滤池"},{"id":"BBI00435","selected":false,"text":"DN生物滤池"},{"id":"BBI00436","selected":false,"text":"V型滤池反冲洗"},{"id":"BBI00437","selected":false,"text":"臭氧接触池"},{"id":"BBI00438","selected":false,"text":"反冲洗废水池"},{"id":"BBI00439","selected":false,"text":"甲醇加药间"},{"id":"BBI00440","selected":false,"text":"进水泵房"},{"id":"BBI00441","selected":false,"text":"清水池"},{"id":"BBI00442","selected":false,"text":"热泵机房"},{"id":"BBI00443","selected":false,"text":"生物滤池反冲洗"},{"id":"BBI00444","selected":false,"text":"输配水泵房"},{"id":"BBI00505","selected":false,"text":"出水监测站"},{"id":"BBI00513","selected":false,"text":"进水监测站"},{"id":"BBI00528","selected":false,"text":"1#CN生物滤池"},{"id":"BBI00529","selected":false,"text":"2#CN生物滤池"},{"id":"BBI00530","selected":false,"text":"中间及回流泵房"},{"id":"BBI00531","selected":false,"text":"反冲洗泵房"},{"id":"BBI00532","selected":false,"text":"鼓风机房"},{"id":"BBI00533","selected":false,"text":"PAC加药间"},{"id":"BBI00534","selected":false,"text":"PAM加药间"},{"id":"BBI00535","selected":false,"text":"加氯间"},{"id":"BBI00536","selected":false,"text":"臭氧间"},{"id":"BBI01221","selected":false,"text":"V型滤池"},{"id":"BBI01222","selected":false,"text":"CN生物滤池"}]}
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
