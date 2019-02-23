package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/9/6 0006.
 */
public class PopupPumpstion extends RBResponse {

    private DataEntity data;
    /**
     * data : {"PumpRunInfo":[{"createtime":"2016-07-15 18:00:03","dataTime":"2016-07-15 17:42:04","flag":"3","id":"8a82e94a55e48a690155edffaa90087e","indeCode":"D0004","pumpNum":"Y23_PPU_01","stat":0,"unitCode":"Y23"},{"createtime":"2016-07-15 18:00:32","dataTime":"2016-07-15 17:42:04","flag":"3","id":"8a82e94a55e48a690155ee001b5b0a2f","indeCode":"D0004","pumpNum":"Y23_PPU_01","stat":0,"unitCode":"Y23"},{"createtime":"2016-07-15 18:00:03","dataTime":"2016-07-15 17:42:04","flag":"3","id":"8a82e94a55e48a690155edffaabf087f","indeCode":"D0004","pumpNum":"Y23_PPU_02","stat":0,"unitCode":"Y23"},{"createtime":"2016-07-15 18:00:32","dataTime":"2016-07-15 17:42:04","flag":"3","id":"8a82e94a55e48a690155ee001b6b0a30","indeCode":"D0004","pumpNum":"Y23_PPU_02","stat":0,"unitCode":"Y23"}]}
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
         * createtime : 2016-07-15 18:00:03
         * dataTime : 2016-07-15 17:42:04
         * flag : 3
         * id : 8a82e94a55e48a690155edffaa90087e
         * indeCode : D0004
         * pumpNum : Y23_PPU_01
         * stat : 0
         * unitCode : Y23
         */

        private List<PumpRunInfoEntity> PumpRunInfo;

        public void setPumpRunInfo(List<PumpRunInfoEntity> PumpRunInfo) {
            this.PumpRunInfo = PumpRunInfo;
        }

        public List<PumpRunInfoEntity> getPumpRunInfo() {
            return PumpRunInfo;
        }

        public static class PumpRunInfoEntity {
            private String createtime;
            private String dataTime;
            private String flag;
            private String id;
            private String indeCode;
            private String pumpNum;
            private int stat;
            private String unitCode;

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public void setDataTime(String dataTime) {
                this.dataTime = dataTime;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIndeCode(String indeCode) {
                this.indeCode = indeCode;
            }

            public void setPumpNum(String pumpNum) {
                this.pumpNum = pumpNum;
            }

            public void setStat(int stat) {
                this.stat = stat;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }

            public String getCreatetime() {
                return createtime;
            }

            public String getDataTime() {
                return dataTime;
            }

            public String getFlag() {
                return flag;
            }

            public String getId() {
                return id;
            }

            public String getIndeCode() {
                return indeCode;
            }

            public String getPumpNum() {
                return pumpNum;
            }

            public int getStat() {
                return stat;
            }

            public String getUnitCode() {
                return unitCode;
            }
        }
    }
}
