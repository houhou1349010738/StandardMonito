package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/6 0006.
 */
public class AchievementResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"supplierScoreList":[{"contractEndDate":"2016-08-01 00:00:00","contractFilePath":"upload/supplier/64_contract_1470022620606.pdf","contractName":"测试","contractSort":"HW","contractStartDate":"2016-08-10 00:00:00","contractType":"固定总价合同","id":"ff8080815643f2a30156442d15bf007a","purchaserAddress":"北京市西城区","purchaserAddressCity":"密云","purchaserAddressCountry":"中国","purchaserAddressProvince":"北京","purchaserCharger":"yu","purchaserChargerPhone":"13623541245","purchaserName":"北京","purchaserSignDate":"2016-08-01 00:00:00","purchaserSigner":"y nnn","qualityLimit":"5","signPlace":"北京市西城区","supplierAddress":"北京","supplierCharger":"yu","supplierChargerPhone":"010-1452452","supplierInfoId":"64","supplierName":"北京","supplierSignDate":"2016-08-10 00:00:00","supplierSigner":"y nn","totalAmount":1000,"updateDate":"2016-07-31 20:37:00"},{"contractEndDate":"2016-08-16 00:00:00","contractFilePath":"upload/supplier/64_contract_1470477872026.pdf","contractName":"最多输入100个字符。fasd","contractSort":"HW","contractStartDate":"2016-08-17 00:00:00","contractType":"可调总价合同","id":"ff808081565e8a8201565f4fab9c0007","purchaserAddress":"1234","purchaserAddressCity":"河西","purchaserAddressCountry":"中国","purchaserAddressProvince":"天津","purchaserCharger":"123421","purchaserChargerPhone":"固话或手机号码34123","purchaserName":"2134123","purchaserSignDate":"2016-08-18 00:00:00","purchaserSigner":"123412","qualityLimit":"1234","signPlace":"fasd","supplierAddress":"1234234","supplierCharger":"341234","supplierChargerPhone":"1234","supplierInfoId":"64","supplierName":"4213412","supplierSignDate":"2016-08-09 00:00:00","supplierSigner":"1234","totalAmount":1321,"updateDate":"2016-08-06 03:04:32"},{"contractEndDate":"2016-08-09 00:00:00","contractFilePath":"upload/supplier/64_contract_1470477940550.pdf","contractName":"sfdgdf","contractSort":"HW","contractStartDate":"2016-08-23 00:00:00","contractType":"可调总价合同","id":"ff808081565e8a8201565f50b746000b","purchaserAddress":"24","purchaserAddressCity":"长宁","purchaserAddressCountry":"中国","purchaserAddressProvince":"上海","purchaserCharger":"234","purchaserChargerPhone":"234","purchaserName":"234","purchaserSignDate":"2016-08-11 00:00:00","purchaserSigner":"2342","qualityLimit":"234","signPlace":"gsdf","supplierAddress":"234","supplierCharger":"2342","supplierChargerPhone":"23423","supplierInfoId":"64","supplierName":"234","supplierSignDate":"2016-08-17 00:00:00","supplierSigner":"2342","totalAmount":234,"updateDate":"2016-08-06 03:05:40"}]}
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
         * contractEndDate : 2016-08-01 00:00:00
         * contractFilePath : upload/supplier/64_contract_1470022620606.pdf
         * contractName : 测试
         * contractSort : HW
         * contractStartDate : 2016-08-10 00:00:00
         * contractType : 固定总价合同
         * id : ff8080815643f2a30156442d15bf007a
         * purchaserAddress : 北京市西城区
         * purchaserAddressCity : 密云
         * purchaserAddressCountry : 中国
         * purchaserAddressProvince : 北京
         * purchaserCharger : yu
         * purchaserChargerPhone : 13623541245
         * purchaserName : 北京
         * purchaserSignDate : 2016-08-01 00:00:00
         * purchaserSigner : y nnn
         * qualityLimit : 5
         * signPlace : 北京市西城区
         * supplierAddress : 北京
         * supplierCharger : yu
         * supplierChargerPhone : 010-1452452
         * supplierInfoId : 64
         * supplierName : 北京
         * supplierSignDate : 2016-08-10 00:00:00
         * supplierSigner : y nn
         * totalAmount : 1000.0
         * updateDate : 2016-07-31 20:37:00
         */

        private List<SupplierScoreListEntity> supplierScoreList;

        public void setSupplierScoreList(List<SupplierScoreListEntity> supplierScoreList) {
            this.supplierScoreList = supplierScoreList;
        }

        public List<SupplierScoreListEntity> getSupplierScoreList() {
            return supplierScoreList;
        }

        public static class SupplierScoreListEntity {
            private String contractEndDate;
            private String contractFilePath;
            private String contractName;
            private String contractSort;
            private String contractStartDate;
            private String contractType;
            private String id;
            private String purchaserAddress;
            private String purchaserAddressCity;
            private String purchaserAddressCountry;
            private String purchaserAddressProvince;
            private String purchaserCharger;
            private String purchaserChargerPhone;
            private String purchaserName;
            private String purchaserSignDate;
            private String purchaserSigner;
            private String qualityLimit;
            private String signPlace;
            private String supplierAddress;
            private String supplierCharger;
            private String supplierChargerPhone;
            private String supplierInfoId;
            private String supplierName;
            private String supplierSignDate;
            private String supplierSigner;
            private double totalAmount;
            private String updateDate;

            public void setContractEndDate(String contractEndDate) {
                this.contractEndDate = contractEndDate;
            }

            public void setContractFilePath(String contractFilePath) {
                this.contractFilePath = contractFilePath;
            }

            public void setContractName(String contractName) {
                this.contractName = contractName;
            }

            public void setContractSort(String contractSort) {
                this.contractSort = contractSort;
            }

            public void setContractStartDate(String contractStartDate) {
                this.contractStartDate = contractStartDate;
            }

            public void setContractType(String contractType) {
                this.contractType = contractType;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setPurchaserAddress(String purchaserAddress) {
                this.purchaserAddress = purchaserAddress;
            }

            public void setPurchaserAddressCity(String purchaserAddressCity) {
                this.purchaserAddressCity = purchaserAddressCity;
            }

            public void setPurchaserAddressCountry(String purchaserAddressCountry) {
                this.purchaserAddressCountry = purchaserAddressCountry;
            }

            public void setPurchaserAddressProvince(String purchaserAddressProvince) {
                this.purchaserAddressProvince = purchaserAddressProvince;
            }

            public void setPurchaserCharger(String purchaserCharger) {
                this.purchaserCharger = purchaserCharger;
            }

            public void setPurchaserChargerPhone(String purchaserChargerPhone) {
                this.purchaserChargerPhone = purchaserChargerPhone;
            }

            public void setPurchaserName(String purchaserName) {
                this.purchaserName = purchaserName;
            }

            public void setPurchaserSignDate(String purchaserSignDate) {
                this.purchaserSignDate = purchaserSignDate;
            }

            public void setPurchaserSigner(String purchaserSigner) {
                this.purchaserSigner = purchaserSigner;
            }

            public void setQualityLimit(String qualityLimit) {
                this.qualityLimit = qualityLimit;
            }

            public void setSignPlace(String signPlace) {
                this.signPlace = signPlace;
            }

            public void setSupplierAddress(String supplierAddress) {
                this.supplierAddress = supplierAddress;
            }

            public void setSupplierCharger(String supplierCharger) {
                this.supplierCharger = supplierCharger;
            }

            public void setSupplierChargerPhone(String supplierChargerPhone) {
                this.supplierChargerPhone = supplierChargerPhone;
            }

            public void setSupplierInfoId(String supplierInfoId) {
                this.supplierInfoId = supplierInfoId;
            }

            public void setSupplierName(String supplierName) {
                this.supplierName = supplierName;
            }

            public void setSupplierSignDate(String supplierSignDate) {
                this.supplierSignDate = supplierSignDate;
            }

            public void setSupplierSigner(String supplierSigner) {
                this.supplierSigner = supplierSigner;
            }

            public void setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getContractEndDate() {
                return contractEndDate;
            }

            public String getContractFilePath() {
                return contractFilePath;
            }

            public String getContractName() {
                return contractName;
            }

            public String getContractSort() {
                return contractSort;
            }

            public String getContractStartDate() {
                return contractStartDate;
            }

            public String getContractType() {
                return contractType;
            }

            public String getId() {
                return id;
            }

            public String getPurchaserAddress() {
                return purchaserAddress;
            }

            public String getPurchaserAddressCity() {
                return purchaserAddressCity;
            }

            public String getPurchaserAddressCountry() {
                return purchaserAddressCountry;
            }

            public String getPurchaserAddressProvince() {
                return purchaserAddressProvince;
            }

            public String getPurchaserCharger() {
                return purchaserCharger;
            }

            public String getPurchaserChargerPhone() {
                return purchaserChargerPhone;
            }

            public String getPurchaserName() {
                return purchaserName;
            }

            public String getPurchaserSignDate() {
                return purchaserSignDate;
            }

            public String getPurchaserSigner() {
                return purchaserSigner;
            }

            public String getQualityLimit() {
                return qualityLimit;
            }

            public String getSignPlace() {
                return signPlace;
            }

            public String getSupplierAddress() {
                return supplierAddress;
            }

            public String getSupplierCharger() {
                return supplierCharger;
            }

            public String getSupplierChargerPhone() {
                return supplierChargerPhone;
            }

            public String getSupplierInfoId() {
                return supplierInfoId;
            }

            public String getSupplierName() {
                return supplierName;
            }

            public String getSupplierSignDate() {
                return supplierSignDate;
            }

            public String getSupplierSigner() {
                return supplierSigner;
            }

            public double getTotalAmount() {
                return totalAmount;
            }

            public String getUpdateDate() {
                return updateDate;
            }
        }
    }
}
