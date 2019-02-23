package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/5/5 0005.
 */
public class DataReportResponse extends RBResponse{

    /**
     * rundataUpDailyList : {"rows":[{"assuUnit":"CZWS0820","dataDate":"2016-08-30","extId":"b23445b86f3a11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"b22e7abe6f3a11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-31 05:20:56","reviewManName":"第二污水处理厂一分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZZS4027","dataDate":"2016-08-29","extId":"809373696e6311e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"8091f94a6e6311e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:40:31","reviewManCode":"root","reviewManName":"第一污水处理厂三分厂二区","reviewTime":"2016-08-31 05:36:43","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-31 05:36:43"},{"assuUnit":"CZWS0825","dataDate":"2016-08-29","extId":"935c9ad36e6111e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"935ae03d6e6111e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:26:44","reviewManName":"第二污水处理厂二分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0620","dataDate":"2016-08-29","extId":"a369de406e6411e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"dcd7ae806e5c11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:48:39","reviewManName":"第一污水处理厂一分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0620","dataDate":"2016-08-29","extId":"dcdb87726e5c11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"dcd7ae806e5c11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 02:53:00","reviewManCode":"root","reviewManName":"第一污水处理厂一分厂","reviewTime":"2016-08-30 02:54:02","upStat":"填报","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-30 02:54:02"},{"assuUnit":"CZWS0825","dataDate":"2016-08-28","extId":"1fa1d3cf6d9511e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"1fa03b8c6d9511e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-29 03:03:12","reviewManCode":"root","reviewManName":"第二污水处理厂二分厂","reviewTime":"2016-08-29 03:03:43","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 03:03:43"},{"assuUnit":"CZWN0830","dataDate":"2016-08-28","extId":"cb151c2f6d8f11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"cb07da096d8f11e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-29 02:25:03","reviewManCode":"root","reviewManName":"第二污水处理厂三分厂","reviewTime":"2016-08-29 03:17:04","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 03:17:04"},{"assuUnit":"CZWS0820","dataDate":"2016-08-26","extId":"93d0f7616a8b11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"93cf76af6a8b11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-25 06:17:19","review1ManCode":"root","review1ManName":"后台管理员","review1Time":"2016-08-25 14:14:35","reviewManCode":"root","reviewManName":"第二污水处理厂一分厂","reviewTime":"2016-08-25 08:20:45","upStat":"审核退回","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-25 08:20:45"},{"assuUnit":"CZWS0801","dataDate":"2016-08-25","extId":"46b602066b5711e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"46b461c56b5711e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-26 06:35:27","reviewManName":"第二污水处理厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0820","dataDate":"2016-08-25","extId":"739ac1c16b6511e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"7398716a6b6511e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-26 08:16:55","reviewManCode":"root","reviewManName":"第二污水处理厂一分厂","reviewTime":"2016-08-29 05:19:46","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 05:19:46"}],"total":13240}
     */

    private DataEntity data;
    /**
     * data : {"rundataUpDailyList":{"rows":[{"assuUnit":"CZWS0820","dataDate":"2016-08-30","extId":"b23445b86f3a11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"b22e7abe6f3a11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-31 05:20:56","reviewManName":"第二污水处理厂一分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZZS4027","dataDate":"2016-08-29","extId":"809373696e6311e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"8091f94a6e6311e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:40:31","reviewManCode":"root","reviewManName":"第一污水处理厂三分厂二区","reviewTime":"2016-08-31 05:36:43","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-31 05:36:43"},{"assuUnit":"CZWS0825","dataDate":"2016-08-29","extId":"935c9ad36e6111e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"935ae03d6e6111e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:26:44","reviewManName":"第二污水处理厂二分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0620","dataDate":"2016-08-29","extId":"a369de406e6411e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"dcd7ae806e5c11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:48:39","reviewManName":"第一污水处理厂一分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0620","dataDate":"2016-08-29","extId":"dcdb87726e5c11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"dcd7ae806e5c11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 02:53:00","reviewManCode":"root","reviewManName":"第一污水处理厂一分厂","reviewTime":"2016-08-30 02:54:02","upStat":"填报","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-30 02:54:02"},{"assuUnit":"CZWS0825","dataDate":"2016-08-28","extId":"1fa1d3cf6d9511e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"1fa03b8c6d9511e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-29 03:03:12","reviewManCode":"root","reviewManName":"第二污水处理厂二分厂","reviewTime":"2016-08-29 03:03:43","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 03:03:43"},{"assuUnit":"CZWN0830","dataDate":"2016-08-28","extId":"cb151c2f6d8f11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"cb07da096d8f11e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-29 02:25:03","reviewManCode":"root","reviewManName":"第二污水处理厂三分厂","reviewTime":"2016-08-29 03:17:04","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 03:17:04"},{"assuUnit":"CZWS0820","dataDate":"2016-08-26","extId":"93d0f7616a8b11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"93cf76af6a8b11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-25 06:17:19","review1ManCode":"root","review1ManName":"后台管理员","review1Time":"2016-08-25 14:14:35","reviewManCode":"root","reviewManName":"第二污水处理厂一分厂","reviewTime":"2016-08-25 08:20:45","upStat":"审核退回","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-25 08:20:45"},{"assuUnit":"CZWS0801","dataDate":"2016-08-25","extId":"46b602066b5711e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"46b461c56b5711e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-26 06:35:27","reviewManName":"第二污水处理厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0820","dataDate":"2016-08-25","extId":"739ac1c16b6511e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"7398716a6b6511e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-26 08:16:55","reviewManCode":"root","reviewManName":"第二污水处理厂一分厂","reviewTime":"2016-08-29 05:19:46","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 05:19:46"}],"total":13240}}
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
         * rows : [{"assuUnit":"CZWS0820","dataDate":"2016-08-30","extId":"b23445b86f3a11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"b22e7abe6f3a11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-31 05:20:56","reviewManName":"第二污水处理厂一分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZZS4027","dataDate":"2016-08-29","extId":"809373696e6311e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"8091f94a6e6311e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:40:31","reviewManCode":"root","reviewManName":"第一污水处理厂三分厂二区","reviewTime":"2016-08-31 05:36:43","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-31 05:36:43"},{"assuUnit":"CZWS0825","dataDate":"2016-08-29","extId":"935c9ad36e6111e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"935ae03d6e6111e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:26:44","reviewManName":"第二污水处理厂二分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0620","dataDate":"2016-08-29","extId":"a369de406e6411e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"dcd7ae806e5c11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 03:48:39","reviewManName":"第一污水处理厂一分厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0620","dataDate":"2016-08-29","extId":"dcdb87726e5c11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"dcd7ae806e5c11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-30 02:53:00","reviewManCode":"root","reviewManName":"第一污水处理厂一分厂","reviewTime":"2016-08-30 02:54:02","upStat":"填报","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-30 02:54:02"},{"assuUnit":"CZWS0825","dataDate":"2016-08-28","extId":"1fa1d3cf6d9511e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"1fa03b8c6d9511e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-29 03:03:12","reviewManCode":"root","reviewManName":"第二污水处理厂二分厂","reviewTime":"2016-08-29 03:03:43","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 03:03:43"},{"assuUnit":"CZWN0830","dataDate":"2016-08-28","extId":"cb151c2f6d8f11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"cb07da096d8f11e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-29 02:25:03","reviewManCode":"root","reviewManName":"第二污水处理厂三分厂","reviewTime":"2016-08-29 03:17:04","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 03:17:04"},{"assuUnit":"CZWS0820","dataDate":"2016-08-26","extId":"93d0f7616a8b11e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"93cf76af6a8b11e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-25 06:17:19","review1ManCode":"root","review1ManName":"后台管理员","review1Time":"2016-08-25 14:14:35","reviewManCode":"root","reviewManName":"第二污水处理厂一分厂","reviewTime":"2016-08-25 08:20:45","upStat":"审核退回","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-25 08:20:45"},{"assuUnit":"CZWS0801","dataDate":"2016-08-25","extId":"46b602066b5711e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"fill_daily","id":"46b461c56b5711e6b2b70242c0a80006","nodeIndex":"1","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-26 06:35:27","reviewManName":"第二污水处理厂","upStat":"填报","upType":"日报"},{"assuUnit":"CZWS0820","dataDate":"2016-08-25","extId":"739ac1c16b6511e6b2b70242c0a80006","flowCode":"YWLC0001","flowNodeCode":"check_daily","id":"7398716a6b6511e6b2b70242c0a80006","nodeIndex":"2","recordManCode":"root","recordManName":"后台管理员","recordTime":"2016-08-26 08:16:55","reviewManCode":"root","reviewManName":"第二污水处理厂一分厂","reviewTime":"2016-08-29 05:19:46","upStat":"复核通过","upType":"日报","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-08-29 05:19:46"}]
         * total : 13240
         */

        private RundataUpDailyListEntity rundataUpDailyList;

        public void setRundataUpDailyList(RundataUpDailyListEntity rundataUpDailyList) {
            this.rundataUpDailyList = rundataUpDailyList;
        }

        public RundataUpDailyListEntity getRundataUpDailyList() {
            return rundataUpDailyList;
        }

        public static class RundataUpDailyListEntity {
            private int total;
            /**
             * assuUnit : CZWS0820
             * dataDate : 2016-08-30
             * extId : b23445b86f3a11e6b2b70242c0a80006
             * flowCode : YWLC0001
             * flowNodeCode : fill_daily
             * id : b22e7abe6f3a11e6b2b70242c0a80006
             * nodeIndex : 1
             * recordManCode : root
             * recordManName : 后台管理员
             * recordTime : 2016-08-31 05:20:56
             * reviewManName : 第二污水处理厂一分厂
             * upStat : 填报
             * upType : 日报
             */

            private List<RowsEntity> rows;

            public void setTotal(int total) {
                this.total = total;
            }

            public void setRows(List<RowsEntity> rows) {
                this.rows = rows;
            }

            public int getTotal() {
                return total;
            }

            public List<RowsEntity> getRows() {
                return rows;
            }

            public static class RowsEntity {
                private String assuUnit;
                private String dataDate;
                private String extId;
                private String flowCode;
                private String flowNodeCode;
                private String id;
                private String nodeIndex;
                private String recordManCode;
                private String recordManName;
                private String recordTime;
                private String reviewManName;
                private String upStat;
                private String upType;

                public void setAssuUnit(String assuUnit) {
                    this.assuUnit = assuUnit;
                }

                public void setDataDate(String dataDate) {
                    this.dataDate = dataDate;
                }

                public void setExtId(String extId) {
                    this.extId = extId;
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

                public void setReviewManName(String reviewManName) {
                    this.reviewManName = reviewManName;
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

                public String getExtId() {
                    return extId;
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

                public String getReviewManName() {
                    return reviewManName;
                }

                public String getUpStat() {
                    return upStat;
                }

                public String getUpType() {
                    return upType;
                }
            }
        }
    }
}
