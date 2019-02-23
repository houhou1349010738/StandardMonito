package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/6 0006.
 */
public class HitchPhenomenaResponse extends RBResponse {
    /**
     * EqTroubleAppear : {"rows":[{"appearCode":"0ae2f89920c611e69ffe000c29b2d655","appearContent":"测试bug","appearFlag":1,"appearOrder":1,"appearPartCode":"驱动","typeCode":"裂纹"},{"appearCode":"402881e44c797e4b014c7dfc8d69005f","appearContent":"齿轮磨损","appearFlag":1,"appearOrder":0,"appearPartCode":"驱动","typeCode":"磨损"},{"appearCode":"402881e44c797e4b014c7dfdd55a0060","appearContent":"轴承磨损","appearFlag":1,"appearOrder":0,"appearPartCode":"驱动","typeCode":"磨损"},{"appearCode":"402881e44c7e36a2014c7e3c161f0002","appearContent":"震动大 声音异常","appearFlag":1,"appearOrder":0,"appearPartCode":"机构","typeCode":"磨损"},{"appearCode":"402881e44c7e36a2014c7e3d01b70004","appearContent":"裂纹","appearFlag":1,"appearOrder":0,"appearPartCode":"结构","typeCode":"裂纹"},{"appearCode":"402881e44c7e36a2014c7e560bc00006","appearContent":"震动大 声音异常","appearFlag":1,"appearOrder":0,"appearPartCode":"其它","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e5675280007","appearContent":"春节前巡视 发现热元件跳闸，恢复后继续跳闸","appearFlag":1,"appearOrder":0,"appearPartCode":"其它","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e56ca3d0008","appearContent":"断裂，无法传动；","appearFlag":1,"appearOrder":0,"appearPartCode":"传动","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e57379d0009","appearContent":"出水闸阀脱落，无法控制；","appearFlag":1,"appearOrder":0,"appearPartCode":"结构","typeCode":"其他"}],"total":9}
     */
    private DataEntity data;
    /**
     * data : {"EqTroubleAppear":{"rows":[{"appearCode":"0ae2f89920c611e69ffe000c29b2d655","appearContent":"测试bug","appearFlag":1,"appearOrder":1,"appearPartCode":"驱动","typeCode":"裂纹"},{"appearCode":"402881e44c797e4b014c7dfc8d69005f","appearContent":"齿轮磨损","appearFlag":1,"appearOrder":0,"appearPartCode":"驱动","typeCode":"磨损"},{"appearCode":"402881e44c797e4b014c7dfdd55a0060","appearContent":"轴承磨损","appearFlag":1,"appearOrder":0,"appearPartCode":"驱动","typeCode":"磨损"},{"appearCode":"402881e44c7e36a2014c7e3c161f0002","appearContent":"震动大 声音异常","appearFlag":1,"appearOrder":0,"appearPartCode":"机构","typeCode":"磨损"},{"appearCode":"402881e44c7e36a2014c7e3d01b70004","appearContent":"裂纹","appearFlag":1,"appearOrder":0,"appearPartCode":"结构","typeCode":"裂纹"},{"appearCode":"402881e44c7e36a2014c7e560bc00006","appearContent":"震动大 声音异常","appearFlag":1,"appearOrder":0,"appearPartCode":"其它","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e5675280007","appearContent":"春节前巡视 发现热元件跳闸，恢复后继续跳闸","appearFlag":1,"appearOrder":0,"appearPartCode":"其它","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e56ca3d0008","appearContent":"断裂，无法传动；","appearFlag":1,"appearOrder":0,"appearPartCode":"传动","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e57379d0009","appearContent":"出水闸阀脱落，无法控制；","appearFlag":1,"appearOrder":0,"appearPartCode":"结构","typeCode":"其他"}],"total":9}}
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
         * rows : [{"appearCode":"0ae2f89920c611e69ffe000c29b2d655","appearContent":"测试bug","appearFlag":1,"appearOrder":1,"appearPartCode":"驱动","typeCode":"裂纹"},{"appearCode":"402881e44c797e4b014c7dfc8d69005f","appearContent":"齿轮磨损","appearFlag":1,"appearOrder":0,"appearPartCode":"驱动","typeCode":"磨损"},{"appearCode":"402881e44c797e4b014c7dfdd55a0060","appearContent":"轴承磨损","appearFlag":1,"appearOrder":0,"appearPartCode":"驱动","typeCode":"磨损"},{"appearCode":"402881e44c7e36a2014c7e3c161f0002","appearContent":"震动大 声音异常","appearFlag":1,"appearOrder":0,"appearPartCode":"机构","typeCode":"磨损"},{"appearCode":"402881e44c7e36a2014c7e3d01b70004","appearContent":"裂纹","appearFlag":1,"appearOrder":0,"appearPartCode":"结构","typeCode":"裂纹"},{"appearCode":"402881e44c7e36a2014c7e560bc00006","appearContent":"震动大 声音异常","appearFlag":1,"appearOrder":0,"appearPartCode":"其它","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e5675280007","appearContent":"春节前巡视 发现热元件跳闸，恢复后继续跳闸","appearFlag":1,"appearOrder":0,"appearPartCode":"其它","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e56ca3d0008","appearContent":"断裂，无法传动；","appearFlag":1,"appearOrder":0,"appearPartCode":"传动","typeCode":"其他"},{"appearCode":"402881e44c7e36a2014c7e57379d0009","appearContent":"出水闸阀脱落，无法控制；","appearFlag":1,"appearOrder":0,"appearPartCode":"结构","typeCode":"其他"}]
         * total : 9
         */

        private EqTroubleAppearEntity EqTroubleAppear;

        public void setEqTroubleAppear(EqTroubleAppearEntity EqTroubleAppear) {
            this.EqTroubleAppear = EqTroubleAppear;
        }

        public EqTroubleAppearEntity getEqTroubleAppear() {
            return EqTroubleAppear;
        }

        public static class EqTroubleAppearEntity {
            private int total;
            /**
             * appearCode : 0ae2f89920c611e69ffe000c29b2d655
             * appearContent : 测试bug
             * appearFlag : 1
             * appearOrder : 1
             * appearPartCode : 驱动
             * typeCode : 裂纹
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
                private String appearCode;
                private String appearContent;
                private int appearFlag;
                private int appearOrder;
                private String appearPartCode;
                private String typeCode;

                public void setAppearCode(String appearCode) {
                    this.appearCode = appearCode;
                }

                public void setAppearContent(String appearContent) {
                    this.appearContent = appearContent;
                }

                public void setAppearFlag(int appearFlag) {
                    this.appearFlag = appearFlag;
                }

                public void setAppearOrder(int appearOrder) {
                    this.appearOrder = appearOrder;
                }

                public void setAppearPartCode(String appearPartCode) {
                    this.appearPartCode = appearPartCode;
                }

                public void setTypeCode(String typeCode) {
                    this.typeCode = typeCode;
                }

                public String getAppearCode() {
                    return appearCode;
                }

                public String getAppearContent() {
                    return appearContent;
                }

                public int getAppearFlag() {
                    return appearFlag;
                }

                public int getAppearOrder() {
                    return appearOrder;
                }

                public String getAppearPartCode() {
                    return appearPartCode;
                }

                public String getTypeCode() {
                    return typeCode;
                }
            }
        }
    }
}
