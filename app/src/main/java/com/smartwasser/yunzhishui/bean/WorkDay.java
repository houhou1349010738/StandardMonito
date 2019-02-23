package com.smartwasser.yunzhishui.bean;
/**
 * Created by huangmengjie on 2016/5/5 0005.
 */
public class WorkDay extends RBResponse{
    /**
     * addNode : {"creatNodeCode":"yx_sc","creatNodeName":"","creatNodeTime":"2012-06-04 18:26:58","flowCode":"YWLC0001","flowName":"水厂业务填报审核全流程","flowPage":"fill_daily","id":"4028811237b6a9930137b708860b0005","nodeCode":"1","nodeId":"fill_daily","nodePath":"fill_daily.do","node_Name":"填报","updateNodeCode":"root","updateNodeName":"后台管理员","updateNodeTime":"2016-04-27 11:16:05","usegroup":"0FE97C19E5794546B28900E073CDD16B","usegroupname":"日常养护日报复核组"}
     */
    private DataEntity data;
    /**
     * data : {"addNode":{"creatNodeCode":"yx_sc","creatNodeName":"","creatNodeTime":"2012-06-04 18:26:58","flowCode":"YWLC0001","flowName":"水厂业务填报审核全流程","flowPage":"fill_daily","id":"4028811237b6a9930137b708860b0005","nodeCode":"1","nodeId":"fill_daily","nodePath":"fill_daily.do","node_Name":"填报","updateNodeCode":"root","updateNodeName":"后台管理员","updateNodeTime":"2016-04-27 11:16:05","usegroup":"0FE97C19E5794546B28900E073CDD16B","usegroupname":"日常养护日报复核组"}}
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
         * creatNodeCode : yx_sc
         * creatNodeName :
         * creatNodeTime : 2012-06-04 18:26:58
         * flowCode: YWLC0001
         * flowName : 水厂业务填报审核全流程
         * flowPage : fill_daily
         * id : 4028811237b6a9930137b708860b0005
         * nodeCode : 1
         * nodeId : fill_daily
         * nodePath : fill_daily.do
         * node_Name : 填报
         * updateNodeCode : root
         * updateNodeName : 后台管理员
         * updateNodeTime : 2016-04-27 11:16:05
         * usegroup : 0FE97C19E5794546B28900E073CDD16B
         * usegroupname : 日常养护日报复核组
         */
        private AddNodeEntity addNode;
        public void setAddNode(AddNodeEntity addNode) {
            this.addNode = addNode;
        }

        public AddNodeEntity getAddNode() {
            return addNode;
        }

        public static class AddNodeEntity {
            private String creatNodeCode;
            private String creatNodeName;
            private String creatNodeTime;
            private String flowCode;
            private String flowName;
            private String flowPage;
            private String id;
            private String nodeCode;
            private String nodeId;
            private String nodePath;
            private String node_Name;
            private String updateNodeCode;
            private String updateNodeName;
            private String updateNodeTime;
            private String usegroup;
            private String usegroupname;

            public void setCreatNodeCode(String creatNodeCode) {
                this.creatNodeCode = creatNodeCode;
            }

            public void setCreatNodeName(String creatNodeName) {
                this.creatNodeName = creatNodeName;
            }

            public void setCreatNodeTime(String creatNodeTime) {
                this.creatNodeTime = creatNodeTime;
            }

            public void setFlowCode(String flowCode) {
                this.flowCode = flowCode;
            }

            public void setFlowName(String flowName) {
                this.flowName = flowName;
            }

            public void setFlowPage(String flowPage) {
                this.flowPage = flowPage;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setNodeCode(String nodeCode) {
                this.nodeCode = nodeCode;
            }

            public void setNodeId(String nodeId) {
                this.nodeId = nodeId;
            }

            public void setNodePath(String nodePath) {
                this.nodePath = nodePath;
            }

            public void setNode_Name(String node_Name) {
                this.node_Name = node_Name;
            }

            public void setUpdateNodeCode(String updateNodeCode) {
                this.updateNodeCode = updateNodeCode;
            }

            public void setUpdateNodeName(String updateNodeName) {
                this.updateNodeName = updateNodeName;
            }

            public void setUpdateNodeTime(String updateNodeTime) {
                this.updateNodeTime = updateNodeTime;
            }

            public void setUsegroup(String usegroup) {
                this.usegroup = usegroup;
            }

            public void setUsegroupname(String usegroupname) {
                this.usegroupname = usegroupname;
            }

            public String getCreatNodeCode() {
                return creatNodeCode;
            }

            public String getCreatNodeName() {
                return creatNodeName;
            }

            public String getCreatNodeTime() {
                return creatNodeTime;
            }

            public String getFlowCode() {
                return flowCode;
            }

            public String getFlowName() {
                return flowName;
            }

            public String getFlowPage() {
                return flowPage;
            }

            public String getId() {
                return id;
            }

            public String getNodeCode() {
                return nodeCode;
            }

            public String getNodeId() {
                return nodeId;
            }

            public String getNodePath() {
                return nodePath;
            }

            public String getNode_Name() {
                return node_Name;
            }

            public String getUpdateNodeCode() {
                return updateNodeCode;
            }

            public String getUpdateNodeName() {
                return updateNodeName;
            }

            public String getUpdateNodeTime() {
                return updateNodeTime;
            }

            public String getUsegroup() {
                return usegroup;
            }

            public String getUsegroupname() {
                return usegroupname;
            }
        }
    }
}
