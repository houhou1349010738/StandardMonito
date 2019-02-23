package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class QrobotResponse extends RBResponse {

    /**
     * supplierInfo : {"account":"14554444444411001","address":"宿迁市","addressCity":"宿迁","addressCountry":"中国","addressFactory":"宿迁市","addressFactoryCity":"宿迁","addressFactoryCountry":"中国","addressFactoryProvince":"江苏","addressProvince":"江苏","addressReg":"jiangsusheng","addressRegCity":"宿迁","addressRegCountry":"中国","addressRegProvince":"江苏","approvingOrgan":"dd","bank":"农行","bankLineNumber":"141440011144","business":"HW,","businessLicenseNum":"qwer01","email":"qwer@163.com","fileNum":"qwer01","id":"64","inspectionRecord":"2016-07-28 00:00:00","introduction":"为他，为自己","issuedUnit":"国家政府","issuingTime":"2016-07-27 00:00:00","legal":"gg","legalContact":"yu","legalZuzhi":"gh","licenseNumber":"33333641323","name":"农行","operatingPeriodEnd":"2016-07-29 00:00:00","operatingPeriodStart":"2016-07-27 00:00:00","organizationCode":"qwer01","organizationType":"QYFR","paidCapital":12000,"periodValidityEnd":"2016-07-27 00:00:00","periodValidityStart":"2016-07-27 00:00:00","permitApprovalNumber":"001254865332543.2233","personNum":"200","regCapital":120000,"registrationAuthority":"农行","registrationNum":"qwer01","registrationTime":"2016-07-27 00:00:00","registrationType":"wu","scale":"XX","scopeBusiness":"无","sell":"dd","sellPhone":"01231456","sellPhoneCode":"010","state":"0","supplierContact":"136254521254","taxRegistrationNum":"01","type":"GTGSH","upTime":"2016-07-27 00:00:00","username":"qwer1","zipCode":"000011"}
     */

    private DataEntity data;
    /**
     * data : {"supplierInfo":{"account":"14554444444411001","address":"宿迁市","addressCity":"宿迁","addressCountry":"中国","addressFactory":"宿迁市","addressFactoryCity":"宿迁","addressFactoryCountry":"中国","addressFactoryProvince":"江苏","addressProvince":"江苏","addressReg":"jiangsusheng","addressRegCity":"宿迁","addressRegCountry":"中国","addressRegProvince":"江苏","approvingOrgan":"dd","bank":"农行","bankLineNumber":"141440011144","business":"HW,","businessLicenseNum":"qwer01","email":"qwer@163.com","fileNum":"qwer01","id":"64","inspectionRecord":"2016-07-28 00:00:00","introduction":"为他，为自己","issuedUnit":"国家政府","issuingTime":"2016-07-27 00:00:00","legal":"gg","legalContact":"yu","legalZuzhi":"gh","licenseNumber":"33333641323","name":"农行","operatingPeriodEnd":"2016-07-29 00:00:00","operatingPeriodStart":"2016-07-27 00:00:00","organizationCode":"qwer01","organizationType":"QYFR","paidCapital":12000,"periodValidityEnd":"2016-07-27 00:00:00","periodValidityStart":"2016-07-27 00:00:00","permitApprovalNumber":"001254865332543.2233","personNum":"200","regCapital":120000,"registrationAuthority":"农行","registrationNum":"qwer01","registrationTime":"2016-07-27 00:00:00","registrationType":"wu","scale":"XX","scopeBusiness":"无","sell":"dd","sellPhone":"01231456","sellPhoneCode":"010","state":"0","supplierContact":"136254521254","taxRegistrationNum":"01","type":"GTGSH","upTime":"2016-07-27 00:00:00","username":"qwer1","zipCode":"000011"}}
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
         * account : 14554444444411001
         * address : 宿迁市
         * addressCity : 宿迁
         * addressCountry : 中国
         * addressFactory : 宿迁市
         * addressFactoryCity : 宿迁
         * addressFactoryCountry : 中国
         * addressFactoryProvince : 江苏
         * addressProvince : 江苏
         * addressReg : jiangsusheng
         * addressRegCity : 宿迁
         * addressRegCountry : 中国
         * addressRegProvince : 江苏
         * approvingOrgan : dd
         * bank : 农行
         * bankLineNumber : 141440011144
         * business : HW,
         * businessLicenseNum : qwer01
         * email : qwer@163.com
         * fileNum : qwer01
         * id : 64
         * inspectionRecord : 2016-07-28 00:00:00
         * introduction : 为他，为自己
         * issuedUnit : 国家政府
         * issuingTime : 2016-07-27 00:00:00
         * legal : gg
         * legalContact : yu
         * legalZuzhi : gh
         * licenseNumber : 33333641323
         * name : 农行
         * operatingPeriodEnd : 2016-07-29 00:00:00
         * operatingPeriodStart : 2016-07-27 00:00:00
         * organizationCode : qwer01
         * organizationType : QYFR
         * paidCapital : 12000.0
         * periodValidityEnd : 2016-07-27 00:00:00
         * periodValidityStart : 2016-07-27 00:00:00
         * permitApprovalNumber : 001254865332543.2233
         * personNum : 200
         * regCapital : 120000.0
         * registrationAuthority : 农行
         * registrationNum : qwer01
         * registrationTime : 2016-07-27 00:00:00
         * registrationType : wu
         * scale : XX
         * scopeBusiness : 无
         * sell : dd
         * sellPhone : 01231456
         * sellPhoneCode : 010
         * state : 0
         * supplierContact : 136254521254
         * taxRegistrationNum : 01
         * type : GTGSH
         * upTime : 2016-07-27 00:00:00
         * username : qwer1
         * zipCode : 000011
         */

        private SupplierInfoEntity supplierInfo;

        public void setSupplierInfo(SupplierInfoEntity supplierInfo) {
            this.supplierInfo = supplierInfo;
        }

        public SupplierInfoEntity getSupplierInfo() {
            return supplierInfo;
        }

        public static class SupplierInfoEntity {
            private String account;
            private String address;
            private String addressCity;
            private String addressCountry;
            private String addressFactory;
            private String addressFactoryCity;
            private String addressFactoryCountry;
            private String addressFactoryProvince;
            private String addressProvince;
            private String addressReg;
            private String addressRegCity;
            private String addressRegCountry;
            private String addressRegProvince;
            private String approvingOrgan;
            private String bank;
            private String bankLineNumber;
            private String business;
            private String businessLicenseNum;
            private String email;
            private String fileNum;
            private String id;
            private String inspectionRecord;
            private String introduction;
            private String issuedUnit;
            private String issuingTime;
            private String legal;
            private String legalContact;
            private String legalZuzhi;
            private String licenseNumber;
            private String name;
            private String operatingPeriodEnd;
            private String operatingPeriodStart;
            private String organizationCode;
            private String organizationType;
            private double paidCapital;
            private String periodValidityEnd;
            private String periodValidityStart;
            private String permitApprovalNumber;
            private String personNum;
            private double regCapital;
            private String registrationAuthority;
            private String registrationNum;
            private String registrationTime;
            private String registrationType;
            private String scale;
            private String scopeBusiness;
            private String sell;
            private String sellPhone;
            private String sellPhoneCode;
            private String state;
            private String supplierContact;
            private String taxRegistrationNum;
            private String type;
            private String upTime;
            private String username;
            private String zipCode;

            public void setAccount(String account) {
                this.account = account;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setAddressCity(String addressCity) {
                this.addressCity = addressCity;
            }

            public void setAddressCountry(String addressCountry) {
                this.addressCountry = addressCountry;
            }

            public void setAddressFactory(String addressFactory) {
                this.addressFactory = addressFactory;
            }

            public void setAddressFactoryCity(String addressFactoryCity) {
                this.addressFactoryCity = addressFactoryCity;
            }

            public void setAddressFactoryCountry(String addressFactoryCountry) {
                this.addressFactoryCountry = addressFactoryCountry;
            }

            public void setAddressFactoryProvince(String addressFactoryProvince) {
                this.addressFactoryProvince = addressFactoryProvince;
            }

            public void setAddressProvince(String addressProvince) {
                this.addressProvince = addressProvince;
            }

            public void setAddressReg(String addressReg) {
                this.addressReg = addressReg;
            }

            public void setAddressRegCity(String addressRegCity) {
                this.addressRegCity = addressRegCity;
            }

            public void setAddressRegCountry(String addressRegCountry) {
                this.addressRegCountry = addressRegCountry;
            }

            public void setAddressRegProvince(String addressRegProvince) {
                this.addressRegProvince = addressRegProvince;
            }

            public void setApprovingOrgan(String approvingOrgan) {
                this.approvingOrgan = approvingOrgan;
            }

            public void setBank(String bank) {
                this.bank = bank;
            }

            public void setBankLineNumber(String bankLineNumber) {
                this.bankLineNumber = bankLineNumber;
            }

            public void setBusiness(String business) {
                this.business = business;
            }

            public void setBusinessLicenseNum(String businessLicenseNum) {
                this.businessLicenseNum = businessLicenseNum;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setFileNum(String fileNum) {
                this.fileNum = fileNum;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setInspectionRecord(String inspectionRecord) {
                this.inspectionRecord = inspectionRecord;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public void setIssuedUnit(String issuedUnit) {
                this.issuedUnit = issuedUnit;
            }

            public void setIssuingTime(String issuingTime) {
                this.issuingTime = issuingTime;
            }

            public void setLegal(String legal) {
                this.legal = legal;
            }

            public void setLegalContact(String legalContact) {
                this.legalContact = legalContact;
            }

            public void setLegalZuzhi(String legalZuzhi) {
                this.legalZuzhi = legalZuzhi;
            }

            public void setLicenseNumber(String licenseNumber) {
                this.licenseNumber = licenseNumber;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setOperatingPeriodEnd(String operatingPeriodEnd) {
                this.operatingPeriodEnd = operatingPeriodEnd;
            }

            public void setOperatingPeriodStart(String operatingPeriodStart) {
                this.operatingPeriodStart = operatingPeriodStart;
            }

            public void setOrganizationCode(String organizationCode) {
                this.organizationCode = organizationCode;
            }

            public void setOrganizationType(String organizationType) {
                this.organizationType = organizationType;
            }

            public void setPaidCapital(double paidCapital) {
                this.paidCapital = paidCapital;
            }

            public void setPeriodValidityEnd(String periodValidityEnd) {
                this.periodValidityEnd = periodValidityEnd;
            }

            public void setPeriodValidityStart(String periodValidityStart) {
                this.periodValidityStart = periodValidityStart;
            }

            public void setPermitApprovalNumber(String permitApprovalNumber) {
                this.permitApprovalNumber = permitApprovalNumber;
            }

            public void setPersonNum(String personNum) {
                this.personNum = personNum;
            }

            public void setRegCapital(double regCapital) {
                this.regCapital = regCapital;
            }

            public void setRegistrationAuthority(String registrationAuthority) {
                this.registrationAuthority = registrationAuthority;
            }

            public void setRegistrationNum(String registrationNum) {
                this.registrationNum = registrationNum;
            }

            public void setRegistrationTime(String registrationTime) {
                this.registrationTime = registrationTime;
            }

            public void setRegistrationType(String registrationType) {
                this.registrationType = registrationType;
            }

            public void setScale(String scale) {
                this.scale = scale;
            }

            public void setScopeBusiness(String scopeBusiness) {
                this.scopeBusiness = scopeBusiness;
            }

            public void setSell(String sell) {
                this.sell = sell;
            }

            public void setSellPhone(String sellPhone) {
                this.sellPhone = sellPhone;
            }

            public void setSellPhoneCode(String sellPhoneCode) {
                this.sellPhoneCode = sellPhoneCode;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setSupplierContact(String supplierContact) {
                this.supplierContact = supplierContact;
            }

            public void setTaxRegistrationNum(String taxRegistrationNum) {
                this.taxRegistrationNum = taxRegistrationNum;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setUpTime(String upTime) {
                this.upTime = upTime;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
            }

            public String getAccount() {
                return account;
            }

            public String getAddress() {
                return address;
            }

            public String getAddressCity() {
                return addressCity;
            }

            public String getAddressCountry() {
                return addressCountry;
            }

            public String getAddressFactory() {
                return addressFactory;
            }

            public String getAddressFactoryCity() {
                return addressFactoryCity;
            }

            public String getAddressFactoryCountry() {
                return addressFactoryCountry;
            }

            public String getAddressFactoryProvince() {
                return addressFactoryProvince;
            }

            public String getAddressProvince() {
                return addressProvince;
            }

            public String getAddressReg() {
                return addressReg;
            }

            public String getAddressRegCity() {
                return addressRegCity;
            }

            public String getAddressRegCountry() {
                return addressRegCountry;
            }

            public String getAddressRegProvince() {
                return addressRegProvince;
            }

            public String getApprovingOrgan() {
                return approvingOrgan;
            }

            public String getBank() {
                return bank;
            }

            public String getBankLineNumber() {
                return bankLineNumber;
            }

            public String getBusiness() {
                return business;
            }

            public String getBusinessLicenseNum() {
                return businessLicenseNum;
            }

            public String getEmail() {
                return email;
            }

            public String getFileNum() {
                return fileNum;
            }

            public String getId() {
                return id;
            }

            public String getInspectionRecord() {
                return inspectionRecord;
            }

            public String getIntroduction() {
                return introduction;
            }

            public String getIssuedUnit() {
                return issuedUnit;
            }

            public String getIssuingTime() {
                return issuingTime;
            }

            public String getLegal() {
                return legal;
            }

            public String getLegalContact() {
                return legalContact;
            }

            public String getLegalZuzhi() {
                return legalZuzhi;
            }

            public String getLicenseNumber() {
                return licenseNumber;
            }

            public String getName() {
                return name;
            }

            public String getOperatingPeriodEnd() {
                return operatingPeriodEnd;
            }

            public String getOperatingPeriodStart() {
                return operatingPeriodStart;
            }

            public String getOrganizationCode() {
                return organizationCode;
            }

            public String getOrganizationType() {
                return organizationType;
            }

            public double getPaidCapital() {
                return paidCapital;
            }

            public String getPeriodValidityEnd() {
                return periodValidityEnd;
            }

            public String getPeriodValidityStart() {
                return periodValidityStart;
            }

            public String getPermitApprovalNumber() {
                return permitApprovalNumber;
            }

            public String getPersonNum() {
                return personNum;
            }

            public double getRegCapital() {
                return regCapital;
            }

            public String getRegistrationAuthority() {
                return registrationAuthority;
            }

            public String getRegistrationNum() {
                return registrationNum;
            }

            public String getRegistrationTime() {
                return registrationTime;
            }

            public String getRegistrationType() {
                return registrationType;
            }

            public String getScale() {
                return scale;
            }

            public String getScopeBusiness() {
                return scopeBusiness;
            }

            public String getSell() {
                return sell;
            }

            public String getSellPhone() {
                return sellPhone;
            }

            public String getSellPhoneCode() {
                return sellPhoneCode;
            }

            public String getState() {
                return state;
            }

            public String getSupplierContact() {
                return supplierContact;
            }

            public String getTaxRegistrationNum() {
                return taxRegistrationNum;
            }

            public String getType() {
                return type;
            }

            public String getUpTime() {
                return upTime;
            }

            public String getUsername() {
                return username;
            }

            public String getZipCode() {
                return zipCode;
            }
        }
    }
}
