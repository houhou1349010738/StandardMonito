package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/5/9 0009.
 */
public class AmendToEditResponse extends RBResponse{
    /**
     * RundataUpDaily : {"assuUnit":"CZWS0835","dataDate":"2016-05-16","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"3c667e3c1bce11e68b93000c29b2d655","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-05-17 09:25:26","upStat":"填报","upType":"日报"}
     * addNode : {"creatNodeCode":"yx_sc","creatNodeName":"","creatNodeTime":"2012-06-04 18:26:58","flowCode":"YWLC0001","flowName":"水厂业务填报审核全流程","flowPage":"fill_daily","id":"4028811237b6a9930137b708860b0005","nodeCode":"1","nodeId":"fill_daily","nodePath":"fill_daily.do","node_Name":"填报","updateNodeCode":"root","updateNodeName":"后台管理员","updateNodeTime":"2016-04-05 15:38:34","usegroup":"E41A0130A1074640BD3C0A20DF4D2644","usegroupname":"系统管理"}
     * bu : {"businessUnitCode":"CZWS0835","businessUnitName":"康庄污水处理厂","id":"13","orderBy":113,"parentUnitCode":"0","properites":"WS","stUnitCode":"1102560000","stUnitName":"高碑店厂康庄厂","status":1,"updateManCode":"root","updateManName":"后台管理员","usergroupCode":"100130130","usergroupName":"高碑店康庄厂"}
     * close : close
     * closeTime : 09:57:00
     * nextNode : {"creatNodeCode":"yx_sc","creatNodeName":"生产系统测试","creatNodeTime":"2012-06-04 18:28:00","flowCode":"YWLC0001","flowName":"水厂业务填报审核全流程","flowPage":"check_daily","id":"4028811237b6a9930137b7097afc0006","nodeCode":"2","nodeId":"check_daily","nodePath":"check_daily.do","node_Name":"复核","updateNodeCode":"root","updateNodeName":"后台管理员","updateNodeTime":"2015-08-19 16:15:37","usegroup":"2E1AC4CE9EEC4E5F9ECA5B8A4951EDCB","usegroupname":"水厂业务日报复核组"}
     * submit : true
     */

    private DataEntity data;
    /**
     * data : {"RundataUpDaily":{"assuUnit":"CZWS0835","dataDate":"2016-05-16","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"3c667e3c1bce11e68b93000c29b2d655","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-05-17 09:25:26","upStat":"填报","upType":"日报"},"addNode":{"creatNodeCode":"yx_sc","creatNodeName":"","creatNodeTime":"2012-06-04 18:26:58","flowCode":"YWLC0001","flowName":"水厂业务填报审核全流程","flowPage":"fill_daily","id":"4028811237b6a9930137b708860b0005","nodeCode":"1","nodeId":"fill_daily","nodePath":"fill_daily.do","node_Name":"填报","updateNodeCode":"root","updateNodeName":"后台管理员","updateNodeTime":"2016-04-05 15:38:34","usegroup":"E41A0130A1074640BD3C0A20DF4D2644","usegroupname":"系统管理"},"bu":{"businessUnitCode":"CZWS0835","businessUnitName":"康庄污水处理厂","id":"13","orderBy":113,"parentUnitCode":"0","properites":"WS","stUnitCode":"1102560000","stUnitName":"高碑店厂康庄厂","status":1,"updateManCode":"root","updateManName":"后台管理员","usergroupCode":"100130130","usergroupName":"高碑店康庄厂"},"close":"close","closeTime":"09:57:00","nextNode":{"creatNodeCode":"yx_sc","creatNodeName":"生产系统测试","creatNodeTime":"2012-06-04 18:28:00","flowCode":"YWLC0001","flowName":"水厂业务填报审核全流程","flowPage":"check_daily","id":"4028811237b6a9930137b7097afc0006","nodeCode":"2","nodeId":"check_daily","nodePath":"check_daily.do","node_Name":"复核","updateNodeCode":"root","updateNodeName":"后台管理员","updateNodeTime":"2015-08-19 16:15:37","usegroup":"2E1AC4CE9EEC4E5F9ECA5B8A4951EDCB","usegroupname":"水厂业务日报复核组"},"submit":"true"}
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
         * assuUnit : CZWS0835
         * dataDate : 2016-05-16
         * flowCode : YWLC0001
         * flowNodeCode : fill_daily
         * id : 3c667e3c1bce11e68b93000c29b2d655
         * nodeIndex : 1
         * recordManCode : root
         * recordManName : 后台管理员
         * recordTime : 2016-05-17 09:25:26
         * upStat : 填报
         * upType : 日报
         */

        private RundataUpDailyEntity RundataUpDaily;
        /**
         * creatNodeCode : yx_sc
         * creatNodeName :
         * creatNodeTime : 2012-06-04 18:26:58
         * flowCode : YWLC0001
         * flowName : 水厂业务填报审核全流程
         * flowPage : fill_daily
         * id : 4028811237b6a9930137b708860b0005
         * nodeCode : 1
         * nodeId : fill_daily
         * nodePath : fill_daily.do
         * node_Name : 填报
         * updateNodeCode : root
         * updateNodeName : 后台管理员
         * updateNodeTime : 2016-04-05 15:38:34
         * usegroup : E41A0130A1074640BD3C0A20DF4D2644
         * usegroupname : 系统管理
         */

        private AddNodeEntity addNode;
        /**
         * businessUnitCode : CZWS0835
         * businessUnitName : 康庄污水处理厂
         * id : 13
         * orderBy : 113
         * parentUnitCode : 0
         * properites : WS
         * stUnitCode : 1102560000
         * stUnitName : 高碑店厂康庄厂
         * status : 1
         * updateManCode : root
         * updateManName : 后台管理员
         * usergroupCode : 100130130
         * usergroupName : 高碑店康庄厂
         */

        private BuEntity bu;
        private String close;
        private String closeTime;
        /**
         * creatNodeCode : yx_sc
         * creatNodeName : 生产系统测试
         * creatNodeTime : 2012-06-04 18:28:00
         * flowCode : YWLC0001
         * flowName : 水厂业务填报审核全流程
         * flowPage : check_daily
         * id : 4028811237b6a9930137b7097afc0006
         * nodeCode : 2
         * nodeId : check_daily
         * nodePath : check_daily.do
         * node_Name : 复核
         * updateNodeCode : root
         * updateNodeName : 后台管理员
         * updateNodeTime : 2015-08-19 16:15:37
         * usegroup : 2E1AC4CE9EEC4E5F9ECA5B8A4951EDCB
         * usegroupname : 水厂业务日报复核组
         */

        private NextNodeEntity nextNode;
        private String submit;

        public void setRundataUpDaily(RundataUpDailyEntity RundataUpDaily) {
            this.RundataUpDaily = RundataUpDaily;
        }

        public void setAddNode(AddNodeEntity addNode) {
            this.addNode = addNode;
        }

        public void setBu(BuEntity bu) {
            this.bu = bu;
        }

        public void setClose(String close) {
            this.close = close;
        }

        public void setCloseTime(String closeTime) {
            this.closeTime = closeTime;
        }

        public void setNextNode(NextNodeEntity nextNode) {
            this.nextNode = nextNode;
        }

        public void setSubmit(String submit) {
            this.submit = submit;
        }

        public RundataUpDailyEntity getRundataUpDaily() {
            return RundataUpDaily;
        }

        public AddNodeEntity getAddNode() {
            return addNode;
        }

        public BuEntity getBu() {
            return bu;
        }

        public String getClose() {
            return close;
        }

        public String getCloseTime() {
            return closeTime;
        }

        public NextNodeEntity getNextNode() {
            return nextNode;
        }

        public String getSubmit() {
            return submit;
        }

        public static class RundataUpDailyEntity {
            private String assuUnit;
            private String dataDate;
            private String flowCode;
            private String flowNodeCode;
            private String id;
            private String nodeIndex;
            private String recordManCode;
            private String recordManName;
            private String recordTime;
            private String upStat;
            private String upType;

            public void setAssuUnit(String assuUnit) {
                this.assuUnit = assuUnit;
            }

            public void setDataDate(String dataDate) {
                this.dataDate = dataDate;
            }

            public void setFlowCode(String flowCode) {
                this.flowCode = flowCode;
            }

            public void setFlowNodeCode(String flowNodeCode) {
                this.flowNodeCode = flowNodeCode;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setNodeIndex(String nodeIndex) {
                this.nodeIndex = nodeIndex;
            }

            public void setRecordManCode(String recordManCode) {
                this.recordManCode = recordManCode;
            }

            public void setRecordManName(String recordManName) {
                this.recordManName = recordManName;
            }

            public void setRecordTime(String recordTime) {
                this.recordTime = recordTime;
            }

            public void setUpStat(String upStat) {
                this.upStat = upStat;
            }

            public void setUpType(String upType) {
                this.upType = upType;
            }

            public String getAssuUnit() {
                return assuUnit;
            }

            public String getDataDate() {
                return dataDate;
            }

            public String getFlowCode() {
                return flowCode;
            }

            public String getFlowNodeCode() {
                return flowNodeCode;
            }

            public String getId() {
                return id;
            }

            public String getNodeIndex() {
                return nodeIndex;
            }

            public String getRecordManCode() {
                return recordManCode;
            }

            public String getRecordManName() {
                return recordManName;
            }

            public String getRecordTime() {
                return recordTime;
            }

            public String getUpStat() {
                return upStat;
            }

            public String getUpType() {
                return upType;
            }
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

        public static class BuEntity {
            private String businessUnitCode;
            private String businessUnitName;
            private String id;
            private int orderBy;
            private String parentUnitCode;
            private String properites;
            private String stUnitCode;
            private String stUnitName;
            private int status;
            private String updateManCode;
            private String updateManName;
            private String usergroupCode;
            private String usergroupName;

            public void setBusinessUnitCode(String businessUnitCode) {
                this.businessUnitCode = businessUnitCode;
            }

            public void setBusinessUnitName(String businessUnitName) {
                this.businessUnitName = businessUnitName;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setOrderBy(int orderBy) {
                this.orderBy = orderBy;
            }

            public void setParentUnitCode(String parentUnitCode) {
                this.parentUnitCode = parentUnitCode;
            }

            public void setProperites(String properites) {
                this.properites = properites;
            }

            public void setStUnitCode(String stUnitCode) {
                this.stUnitCode = stUnitCode;
            }

            public void setStUnitName(String stUnitName) {
                this.stUnitName = stUnitName;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setUpdateManCode(String updateManCode) {
                this.updateManCode = updateManCode;
            }

            public void setUpdateManName(String updateManName) {
                this.updateManName = updateManName;
            }

            public void setUsergroupCode(String usergroupCode) {
                this.usergroupCode = usergroupCode;
            }

            public void setUsergroupName(String usergroupName) {
                this.usergroupName = usergroupName;
            }

            public String getBusinessUnitCode() {
                return businessUnitCode;
            }

            public String getBusinessUnitName() {
                return businessUnitName;
            }

            public String getId() {
                return id;
            }

            public int getOrderBy() {
                return orderBy;
            }

            public String getParentUnitCode() {
                return parentUnitCode;
            }

            public String getProperites() {
                return properites;
            }

            public String getStUnitCode() {
                return stUnitCode;
            }

            public String getStUnitName() {
                return stUnitName;
            }

            public int getStatus() {
                return status;
            }

            public String getUpdateManCode() {
                return updateManCode;
            }

            public String getUpdateManName() {
                return updateManName;
            }

            public String getUsergroupCode() {
                return usergroupCode;
            }

            public String getUsergroupName() {
                return usergroupName;
            }
        }

        public static class NextNodeEntity {
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
