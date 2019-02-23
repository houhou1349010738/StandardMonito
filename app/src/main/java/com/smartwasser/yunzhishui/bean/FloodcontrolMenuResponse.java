package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class FloodcontrolMenuResponse extends RBResponse{
    /**
     * data : [{"attributes":{"target":"","url":"/fxxt/systemmanager/rain/mainForKdb"},"children":[],"iconCls":"leafIcon","id":"136359791741054044251","pid":"3aef85db128711e6aaf8000c29b2d655","text":"雨量监测"},{"attributes":{"target":"","url":"/fxxt/systemmanager/rain/city"},"children":[],"iconCls":"leafIcon","id":"136645640032534076486","pid":"3aef85db128711e6aaf8000c29b2d655","text":"场降雨累计雨量"},{"attributes":{"target":"","url":"/fxxt/systemmanager/pumpbseinfo/main2"},"children":[],"iconCls":"leafIcon","id":"136567362010426638241","pid":"3aef85db128711e6aaf8000c29b2d655","text":"泵站运行状态监测"},{"attributes":{"target":"","url":"/fxxt/systemmanager/bridgeBaseInfo/mainForKdb"},"children":[],"iconCls":"leafIcon","id":"136359800695563006104","pid":"3aef85db128711e6aaf8000c29b2d655","text":"桥区液位监测"},{"attributes":{"target":"","url":"/fxxt/systemmanage/weibo/jtlist"},"children":[],"iconCls":"leafIcon","id":"136567409302213803615","pid":"3aef85db128711e6aaf8000c29b2d655","text":"交通信息"},{"attributes":{"target":"","url":"/fxxt/cma/cma/main"},"children":[],"iconCls":"leafIcon","id":"136765700187148873733","pid":"3aef85db128711e6aaf8000c29b2d655","text":"小时雨量(气象局)"}]
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;
    /**
     * attributes : {"target":"","url":"/fxxt/systemmanager/rain/mainForKdb"}
     * children : []
     * iconCls : leafIcon
     * id : 136359791741054044251
     * pid : 3aef85db128711e6aaf8000c29b2d655
     * text : 雨量监测
     */

    private List<DataEntity> data;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * target :
         * url : /fxxt/systemmanager/rain/mainForKdb
         */

        private AttributesEntity attributes;
        private String iconCls;
        private String id;
        private String pid;
        private String text;
        private List<?> children;

        public void setAttributes(AttributesEntity attributes) {
            this.attributes = attributes;
        }

        public void setIconCls(String iconCls) {
            this.iconCls = iconCls;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setChildren(List<?> children) {
            this.children = children;
        }

        public AttributesEntity getAttributes() {
            return attributes;
        }

        public String getIconCls() {
            return iconCls;
        }

        public String getId() {
            return id;
        }

        public String getPid() {
            return pid;
        }

        public String getText() {
            return text;
        }

        public List<?> getChildren() {
            return children;
        }

        public static class AttributesEntity {
            private String target;
            private String url;

            public void setTarget(String target) {
                this.target = target;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTarget() {
                return target;
            }

            public String getUrl() {
                return url;
            }
        }
    }
}
