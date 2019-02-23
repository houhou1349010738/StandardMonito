package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/6 0006.
 */
public class QualificationResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"supplierFileList":[{"createTime":"2016-07-26 20:33:23","filePath":"upload/supplier/64_1469590403064.pdf","fileTitle":"营业执照副本","id":"ff80808156252aa201562a69f7fa004e","state":1,"supplierInfoId":"64"}]}
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
         * createTime : 2016-07-26 20:33:23
         * filePath : upload/supplier/64_1469590403064.pdf
         * fileTitle : 营业执照副本
         * id : ff80808156252aa201562a69f7fa004e
         * state : 1
         * supplierInfoId : 64
         */

        private List<SupplierFileListEntity> supplierFileList;

        public void setSupplierFileList(List<SupplierFileListEntity> supplierFileList) {
            this.supplierFileList = supplierFileList;
        }

        public List<SupplierFileListEntity> getSupplierFileList() {
            return supplierFileList;
        }

        public static class SupplierFileListEntity {
            private String createTime;
            private String filePath;
            private String fileTitle;
            private String id;
            private int state;
            private String remark;
            private String supplierInfoId;

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
            }

            public void setFileTitle(String fileTitle) {
                this.fileTitle = fileTitle;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setState(int state) {
                this.state = state;
            }

            public void setSupplierInfoId(String supplierInfoId) {
                this.supplierInfoId = supplierInfoId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public String getFilePath() {
                return filePath;
            }

            public String getFileTitle() {
                return fileTitle;
            }

            public String getId() {
                return id;
            }

            public int getState() {
                return state;
            }

            public String getSupplierInfoId() {
                return supplierInfoId;
            }
        }
    }
}
