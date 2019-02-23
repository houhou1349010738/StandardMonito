package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/14 0014.
 */
public class MudResponse extends RBResponse {
    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"MudInfo":[{"id":"","text":"全部","selected":true,"desc":null},{"id":"40288082550f3d6601550fbf6042001e","text":"安次区码头镇（朱官屯）","selected":false,"desc":null},{"id":"40288082551020b7015511b1f615002d","text":"葛渔城下官村","selected":false,"desc":null},{"id":"402880e4552ee91101552ef9141b0002","text":"1","selected":false,"desc":null},{"id":"402880e455498cdc015549a536df0000","text":"4 54他","selected":false,"desc":null},{"id":"402884f055a036380155a078584f0003","text":"QQQ","selected":false,"desc":null},{"id":"8a92e481533fb5d701537d51e32900b6","text":"永清县别古庄镇刘庄村（朱官屯西）","selected":false,"desc":null},{"id":"ff808081559a046f0155a0433ab60011","text":"ss","selected":false,"desc":null},{"id":"ff808081559a046f0155a07505030018","text":"123","selected":false,"desc":null},{"id":"ff808081559a046f0155a07c9a120019","text":"zz","selected":false,"desc":null}]}
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

        private List<MudInfoEntity> MudInfo;

        public void setMudInfo(List<MudInfoEntity> MudInfo) {
            this.MudInfo = MudInfo;
        }

        public List<MudInfoEntity> getMudInfo() {
            return MudInfo;
        }

        public static class MudInfoEntity {
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
