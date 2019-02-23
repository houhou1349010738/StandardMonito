package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/9 0009.
 */
public class DaBinkResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"comboboxList":[{"id":"","selected":true,"text":"请选择"},{"id":"ZGGSYHDTLZH","selected":false,"text":"中国工商银行大屯路支行"},{"id":"NHBJNDNLZH","selected":false,"text":"农行北京农大南路支行"},{"id":"NHBJKYNLZH","selected":false,"text":"农行北京科院南路支行"},{"id":"NHBJJDZH","selected":false,"text":"农行北京建德支行"},{"id":"BJYHZHCZH","selected":false,"text":"北京银行中关村支行"},{"id":"NHBJDSBZH","selected":false,"text":"农行北京东四北支行"},{"id":"GSYHBJHDZH","selected":false,"text":"工商银行北京海淀支行"},{"id":"ZGNYYHSZHBZH","selected":false,"text":"中国农业银行苏州湖滨支行"},{"id":"ZGJSYHJLSFHJXZH","selected":false,"text":"中国建设银行吉林省分行吉新支行"},{"id":"ZGGSYHJQZH","selected":false,"text":"中国工商银行津青支行"},{"id":"NYYHYTZH","selected":false,"text":"农业银行烟台支行"},{"id":"ZGNYYHQDSLLFLC","selected":false,"text":"中国农业银行青岛松岭路分理处"},{"id":"ZGGSYHCBFLC","selected":false,"text":"中国工商银行茨坝分理处"},{"id":"FCYHKMLNZH","selected":false,"text":"富滇银行昆明老年支行"},{"id":"NHACQZHXDJFLC","selected":false,"text":"农行安次区支行西大街分理处"},{"id":"NHBJKYNLZH","selected":false,"text":"农行北京科院南路支行"},{"id":"ZGYHGZHZZHYYB","selected":false,"text":"中国银行广州海珠支行营业部"},{"id":"JTYHSHSFHJDZH","selected":false,"text":"交通银行上海市分行嘉定支行"},{"id":"JHGYJXZH","selected":false,"text":"建行贵阳甲秀支行"},{"id":"JHWUSKXYZH","selected":false,"text":"建行武汉市科学院支行"},{"id":"ZGYHHFCJXLZH","selected":false,"text":"中国银行合肥长江西路支行"},{"id":"ZZGJSYHGFYXGSFZSJCFLC","selected":false,"text":"中国建设银行股份有限公司福州上江城分理处"}]}
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
