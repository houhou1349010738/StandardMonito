package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/21 0021.
 */
public class BusinessResponse extends RBResponse {
    /**
     * CostIndeMaster : {"rows":[{"costType":"收入预算","dataUnit":"元","indeCode":"JB0244","indeName":"房屋管理","maxValue":"0.00","minValue":"0.00","professionSubject":"房屋管理"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0245","indeName":"电梯运行","maxValue":"0.00","minValue":"0.00","professionSubject":"电梯运行"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0246","indeName":"保洁绿化","maxValue":"0.00","minValue":"0.00","professionSubject":"保洁绿化"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0247","indeName":"供电运行","maxValue":"0.00","minValue":"0.00","professionSubject":"供电运行"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0332","indeName":"大中修拨款","maxValue":"0.00","minValue":"0.00","professionSubject":"大中修拨款"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0248","indeName":"专款收入","maxValue":"0.00","minValue":"0.00","professionSubject":"专款收入"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0250","indeName":"绿化费","maxValue":"0.00","minValue":"0.00","professionSubject":"绿化费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0251","indeName":"管理费","maxValue":"0.00","minValue":"0.00","professionSubject":"管理费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0252","indeName":"房屋维修","maxValue":"0.00","minValue":"0.00","professionSubject":"房屋维修"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0333","indeName":"高压水泵费","maxValue":"0.00","minValue":"0.00","professionSubject":"高压水泵费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0253","indeName":"电梯费","maxValue":"0.00","minValue":"0.00","professionSubject":"电梯费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0254","indeName":"垃圾卫生费","maxValue":"0.00","minValue":"0.00","professionSubject":"垃圾卫生费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0255","indeName":"垃圾清运","maxValue":"0.00","minValue":"0.00","professionSubject":"垃圾清运"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0256","indeName":"治安费","maxValue":"0.00","minValue":"0.00","professionSubject":"治安费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0257","indeName":"车辆管理","maxValue":"0.00","minValue":"0.00","professionSubject":"车辆管理"}],"total":37}
     */
    private DataEntity data;
    /**
     * data : {"CostIndeMaster":{"rows":[{"costType":"收入预算","dataUnit":"元","indeCode":"JB0244","indeName":"房屋管理","maxValue":"0.00","minValue":"0.00","professionSubject":"房屋管理"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0245","indeName":"电梯运行","maxValue":"0.00","minValue":"0.00","professionSubject":"电梯运行"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0246","indeName":"保洁绿化","maxValue":"0.00","minValue":"0.00","professionSubject":"保洁绿化"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0247","indeName":"供电运行","maxValue":"0.00","minValue":"0.00","professionSubject":"供电运行"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0332","indeName":"大中修拨款","maxValue":"0.00","minValue":"0.00","professionSubject":"大中修拨款"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0248","indeName":"专款收入","maxValue":"0.00","minValue":"0.00","professionSubject":"专款收入"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0250","indeName":"绿化费","maxValue":"0.00","minValue":"0.00","professionSubject":"绿化费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0251","indeName":"管理费","maxValue":"0.00","minValue":"0.00","professionSubject":"管理费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0252","indeName":"房屋维修","maxValue":"0.00","minValue":"0.00","professionSubject":"房屋维修"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0333","indeName":"高压水泵费","maxValue":"0.00","minValue":"0.00","professionSubject":"高压水泵费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0253","indeName":"电梯费","maxValue":"0.00","minValue":"0.00","professionSubject":"电梯费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0254","indeName":"垃圾卫生费","maxValue":"0.00","minValue":"0.00","professionSubject":"垃圾卫生费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0255","indeName":"垃圾清运","maxValue":"0.00","minValue":"0.00","professionSubject":"垃圾清运"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0256","indeName":"治安费","maxValue":"0.00","minValue":"0.00","professionSubject":"治安费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0257","indeName":"车辆管理","maxValue":"0.00","minValue":"0.00","professionSubject":"车辆管理"}],"total":37}}
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
         * rows : [{"costType":"收入预算","dataUnit":"元","indeCode":"JB0244","indeName":"房屋管理","maxValue":"0.00","minValue":"0.00","professionSubject":"房屋管理"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0245","indeName":"电梯运行","maxValue":"0.00","minValue":"0.00","professionSubject":"电梯运行"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0246","indeName":"保洁绿化","maxValue":"0.00","minValue":"0.00","professionSubject":"保洁绿化"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0247","indeName":"供电运行","maxValue":"0.00","minValue":"0.00","professionSubject":"供电运行"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0332","indeName":"大中修拨款","maxValue":"0.00","minValue":"0.00","professionSubject":"大中修拨款"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0248","indeName":"专款收入","maxValue":"0.00","minValue":"0.00","professionSubject":"专款收入"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0250","indeName":"绿化费","maxValue":"0.00","minValue":"0.00","professionSubject":"绿化费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0251","indeName":"管理费","maxValue":"0.00","minValue":"0.00","professionSubject":"管理费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0252","indeName":"房屋维修","maxValue":"0.00","minValue":"0.00","professionSubject":"房屋维修"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0333","indeName":"高压水泵费","maxValue":"0.00","minValue":"0.00","professionSubject":"高压水泵费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0253","indeName":"电梯费","maxValue":"0.00","minValue":"0.00","professionSubject":"电梯费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0254","indeName":"垃圾卫生费","maxValue":"0.00","minValue":"0.00","professionSubject":"垃圾卫生费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0255","indeName":"垃圾清运","maxValue":"0.00","minValue":"0.00","professionSubject":"垃圾清运"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0256","indeName":"治安费","maxValue":"0.00","minValue":"0.00","professionSubject":"治安费"},{"costType":"收入预算","dataUnit":"元","indeCode":"JB0257","indeName":"车辆管理","maxValue":"0.00","minValue":"0.00","professionSubject":"车辆管理"}]
         * total : 37
         */

        private CostIndeMasterEntity CostIndeMaster;

        public void setCostIndeMaster(CostIndeMasterEntity CostIndeMaster) {
            this.CostIndeMaster = CostIndeMaster;
        }

        public CostIndeMasterEntity getCostIndeMaster() {
            return CostIndeMaster;
        }

        public static class CostIndeMasterEntity {
            private int total;
            /**
             * costType : 收入预算
             * dataUnit : 元
             * indeCode : JB0244
             * indeName : 房屋管理
             * maxValue : 0.00
             * minValue : 0.00
             * professionSubject : 房屋管理
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
                private String costType;
                private String dataUnit;
                private String indeCode;
                private String indeName;
                private String maxValue;
                private String minValue;
                private String professionSubject;

                public void setCostType(String costType) {
                    this.costType = costType;
                }

                public void setDataUnit(String dataUnit) {
                    this.dataUnit = dataUnit;
                }

                public void setIndeCode(String indeCode) {
                    this.indeCode = indeCode;
                }

                public void setIndeName(String indeName) {
                    this.indeName = indeName;
                }

                public void setMaxValue(String maxValue) {
                    this.maxValue = maxValue;
                }

                public void setMinValue(String minValue) {
                    this.minValue = minValue;
                }

                public void setProfessionSubject(String professionSubject) {
                    this.professionSubject = professionSubject;
                }

                public String getCostType() {
                    return costType;
                }

                public String getDataUnit() {
                    return dataUnit;
                }

                public String getIndeCode() {
                    return indeCode;
                }

                public String getIndeName() {
                    return indeName;
                }

                public String getMaxValue() {
                    return maxValue;
                }

                public String getMinValue() {
                    return minValue;
                }

                public String getProfessionSubject() {
                    return professionSubject;
                }
            }
        }
    }
}
