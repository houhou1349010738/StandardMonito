package com.smartwasser.yunzhishui.utils;

import com.smartwasser.yunzhishui.bean.RBResponse;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/6 0006.
 */
public class CatalogueResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"supplierPurTypeList":[{"id":"ff80808156252aa201562a681d7a0034","supplierId":"64","typeCode":"2","typeDanwei":"t","typeName":"工程","typeNum":300}]}
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
         * id : ff80808156252aa201562a681d7a0034
         * supplierId : 64
         * typeCode : 2
         * typeDanwei : t
         * typeName : 工程
         * typeNum : 300
         */

        private List<SupplierPurTypeListEntity> supplierPurTypeList;

        public void setSupplierPurTypeList(List<SupplierPurTypeListEntity> supplierPurTypeList) {
            this.supplierPurTypeList = supplierPurTypeList;
        }

        public List<SupplierPurTypeListEntity> getSupplierPurTypeList() {
            return supplierPurTypeList;
        }

        public static class SupplierPurTypeListEntity {
            private String id;
            private String supplierId;
            private String typeCode;
            private String typeDanwei;
            private String typeName;
            private String typeNum;

            public void setId(String id) {
                this.id = id;
            }

            public void setSupplierId(String supplierId) {
                this.supplierId = supplierId;
            }

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }

            public void setTypeDanwei(String typeDanwei) {
                this.typeDanwei = typeDanwei;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public void setTypeNum(String typeNum) {
                this.typeNum = typeNum;
            }

            public String getId() {
                return id;
            }

            public String getSupplierId() {
                return supplierId;
            }

            public String getTypeCode() {
                return typeCode;
            }

            public String getTypeDanwei() {
                return typeDanwei;
            }

            public String getTypeName() {
                return typeName;
            }

            public String getTypeNum() {
                return typeNum;
            }
        }
    }
}
