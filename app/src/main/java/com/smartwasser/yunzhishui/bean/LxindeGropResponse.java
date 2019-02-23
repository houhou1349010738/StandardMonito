package com.smartwasser.yunzhishui.bean;

import java.util.List;
/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class LxindeGropResponse extends RBResponse {
    private DataEntity data;
    /**
     * data : {"indeList":[{"endTime":"2016-05-18 00:00:00","id":"df86bd1815ce11e69477000c29b2d655","indegrpCode":"GR6111462788958609","indegrpName":"41","indegrpStat":"有效","indegrpType":"个人定制","startTime":"2016-05-03 00:00:00"}]}
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
         * endTime : 2016-05-18 00:00:00
         * id : df86bd1815ce11e69477000c29b2d655
         * indegrpCode : GR6111462788958609
         * indegrpName : 41
         * indegrpStat : 有效
         * indegrpType : 个人定制
         * startTime : 2016-05-03 00:00:00
         */

        private List<IndeListEntity> indeList;

        public void setIndeList(List<IndeListEntity> indeList) {
            this.indeList = indeList;
        }

        public List<IndeListEntity> getIndeList() {
            return indeList;
        }

        public static class IndeListEntity {
            private String endTime;
            private String id;
            private String indegrpCode;
            private String indegrpName;
            private String indegrpStat;
            private String indegrpType;
            private String startTime;

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIndegrpCode(String indegrpCode) {
                this.indegrpCode = indegrpCode;
            }

            public void setIndegrpName(String indegrpName) {
                this.indegrpName = indegrpName;
            }

            public void setIndegrpStat(String indegrpStat) {
                this.indegrpStat = indegrpStat;
            }

            public void setIndegrpType(String indegrpType) {
                this.indegrpType = indegrpType;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public String getId() {
                return id;
            }

            public String getIndegrpCode() {
                return indegrpCode;
            }

            public String getIndegrpName() {
                return indegrpName;
            }

            public String getIndegrpStat() {
                return indegrpStat;
            }

            public String getIndegrpType() {
                return indegrpType;
            }

            public String getStartTime() {
                return startTime;
            }
        }
    }
}
