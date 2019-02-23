package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class ReimburseListResponse extends RBResponse{

    /**
     * examineState : 费用报销申请
     * roleId : [{"id":"143920797168047821875","parentid":"0","roledesc":"测试","rolelevel":"0:1","rolename":"测试","roletype":"function"},{"id":"143980435601023046001","parentid":"143980427971326216437","roledesc":"月度实际成本填报权限","rolelevel":"0:2","rolename":"月度实际成本填报","roletype":"function"},{"id":"143980456408882030246","parentid":"143980454455755368610","roledesc":"合同基本信息登记","rolelevel":"0:2","rolename":"合同基本信息登记","roletype":"function"},{"id":"143980458090143807565","parentid":"143980454455755368610","roledesc":"合同复核","rolelevel":"0:2","rolename":"合同复核","roletype":"function"},{"id":"143980459454122238566","parentid":"143980454455755368610","roledesc":"支付通知","rolelevel":"0:2","rolename":"支付通知","roletype":"function"},{"id":"143980461804166658040","parentid":"143980454455755368610","roledesc":"合同情况查询","rolelevel":"0:2","rolename":"合同情况查询","roletype":"function"},{"id":"143980465777678745826","parentid":"143980454455755368610","roledesc":"合同管理","rolelevel":"0:2","rolename":"合同管理模块","roletype":"function"},{"id":"143980470002640775337","parentid":"143980431286911831408","roledesc":"品控填报权限","rolelevel":"0:3","rolename":"品控填报","roletype":"function"},{"id":"143980473252601604658","parentid":"143980431286911831408","roledesc":"工程填报权限","rolelevel":"0:3","rolename":"工程填报","roletype":"function"},{"id":"143980476411987648106","parentid":"143980431286911831408","roledesc":"人事填报权限","rolelevel":"0:3","rolename":"人事填报","roletype":"function"},{"id":"143980478561948405256","parentid":"143980431286911831408","roledesc":"综合填报权限","rolelevel":"0:3","rolename":"综合填报","roletype":"function"},{"id":"143980480469873820100","parentid":"143980431286911831408","roledesc":"财务填报权限","rolelevel":"0:3","rolename":"财务填报","roletype":"function"},{"id":"143980483688565135344","parentid":"143980431286911831408","roledesc":"预算计划分厂审核权限","rolelevel":"0:3","rolename":"预算计划分厂审核","roletype":"function"},{"id":"143980496536941371568","parentid":"143980491771385025323","roledesc":"工程费用复核权限","rolelevel":"0:3","rolename":"工程费用复核","roletype":"function"},{"id":"143980501304168461873","parentid":"143980491771385025323","roledesc":"综合费用复核权限","rolelevel":"0:3","rolename":"综合费用复核","roletype":"function"},{"id":"143980504346337387068","parentid":"143980491771385025323","roledesc":"品控费用复核权限","rolelevel":"0:3","rolename":"品控费用复核","roletype":"function"},{"id":"143980506277605166118","parentid":"143980491771385025323","roledesc":"人事费用复核权限","rolelevel":"0:3","rolename":"人事费用复核","roletype":"function"},{"id":"143980509213501655776","parentid":"143980491771385025323","roledesc":"财务费用复核权限","rolelevel":"0:3","rolename":"财务费用复核","roletype":"function"},{"id":"143980521474461187127","parentid":"143980518408825878668","roledesc":"品控费用审核权限","rolelevel":"0:3","rolename":"品控费用审核","roletype":"function"},{"id":"143980525058885575437","parentid":"143980518408825878668","roledesc":"工程费用审核权限","rolelevel":"0:3","rolename":"工程费用审核","roletype":"function"},{"id":"143980528790130042674","parentid":"143980518408825878668","roledesc":"人事费用审核权限","rolelevel":"0:3","rolename":"人事费用审核","roletype":"function"},{"id":"143980531521321825466","parentid":"143980518408825878668","roledesc":"综合费用审核权限","rolelevel":"0:3","rolename":"综合费用审核","roletype":"function"},{"id":"143980533197966452278","parentid":"143980518408825878668","roledesc":"财务费用审核权限","rolelevel":"0:3","rolename":"财务费用审核","roletype":"function"},{"id":"143980543591627184434","parentid":"143980540579106771527","roledesc":"公司汇总审核权限","rolelevel":"0:3","rolename":"公司汇总审核","roletype":"function"},{"id":"143980559590104340615","parentid":"143980556582332201835","roledesc":"预算计划发布","rolelevel":"0:3","rolename":"预算计划发布","roletype":"function"},{"id":"144350842585220455333","parentid":"143980431286911831408","roledesc":"多种经营填报权限","rolelevel":"0:3","rolename":"多种经营填报","roletype":"function"},{"id":"144350846103984852355","parentid":"143980518408825878668","roledesc":"多种经营审核权限","rolelevel":"0:3","rolename":"多种经营审核","roletype":"function"},{"id":"144386379675876545205","parentid":"143980431286911831408","roledesc":"收入填报权限","rolelevel":"0:3","rolename":"收入填报","roletype":"function"},{"id":"144386384810281455501","parentid":"143980518408825878668","roledesc":"收入预算审核权限","rolelevel":"0:3","rolename":"收入预算审核","roletype":"function"},{"id":"144387216641415355605","parentid":"144387215296127127328","roledesc":"年度预算财务部门审核","rolelevel":"0:2","rolename":"年度预算财务部门审核","roletype":"function"},{"id":"144387282236727475501","parentid":"0","roledesc":"数据审核","rolelevel":"0:1","rolename":"数据审核模块","roletype":"function"},{"id":"163440B45B9847298578F215653B496C","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"经营采购部","rolelevel":"0:02:02","rolename":"经营采购部","roletype":"function"},{"id":"4FB651486C4C4B5094069209A5701790","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"财务资产部","rolelevel":"0:02:06","rolename":"财务资产部","roletype":"function"},{"id":"5702C10B1DD84A80BF28809EFDF167E1","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"安全品控部","rolelevel":"0:02:03","rolename":"安全品控部","roletype":"function"},{"id":"65C68F4349084EB0831EEA2232E0EFB4","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"人力资源部","rolelevel":"0:02:05","rolename":"人力资源部","roletype":"function"},{"id":"6B2171036AC84F0FBA62F2AC8F607417","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"开发研究部","rolelevel":"0:02:04","rolename":"开发研究部","roletype":"function"},{"id":"6D58F4CE91544229B9651F99C4874A5D","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"行政综合部","rolelevel":"0:02:07","rolename":"行政综合部","roletype":"function"},{"id":"C8E190761A0E4DEEBCF9D8F6D2FCE8A7","parentid":"0","roledesc":"人事费用职能部门审核","rolelevel":"0:02","rolename":"人事费用职能部门审核","roletype":"function"},{"id":"F7EE859577AD478FABD326FA76779E0C","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"工程技术部","rolelevel":"0:02:01","rolename":"工程技术部","roletype":"function"}]
     * userId : 143920777043963135464
     * userName : root
     */
    private DataEntity data;
    /**
     * data : {"examineState":"费用报销申请","roleId":[{"id":"143920797168047821875","parentid":"0","roledesc":"测试","rolelevel":"0:1","rolename":"测试","roletype":"function"},{"id":"143980435601023046001","parentid":"143980427971326216437","roledesc":"月度实际成本填报权限","rolelevel":"0:2","rolename":"月度实际成本填报","roletype":"function"},{"id":"143980456408882030246","parentid":"143980454455755368610","roledesc":"合同基本信息登记","rolelevel":"0:2","rolename":"合同基本信息登记","roletype":"function"},{"id":"143980458090143807565","parentid":"143980454455755368610","roledesc":"合同复核","rolelevel":"0:2","rolename":"合同复核","roletype":"function"},{"id":"143980459454122238566","parentid":"143980454455755368610","roledesc":"支付通知","rolelevel":"0:2","rolename":"支付通知","roletype":"function"},{"id":"143980461804166658040","parentid":"143980454455755368610","roledesc":"合同情况查询","rolelevel":"0:2","rolename":"合同情况查询","roletype":"function"},{"id":"143980465777678745826","parentid":"143980454455755368610","roledesc":"合同管理","rolelevel":"0:2","rolename":"合同管理模块","roletype":"function"},{"id":"143980470002640775337","parentid":"143980431286911831408","roledesc":"品控填报权限","rolelevel":"0:3","rolename":"品控填报","roletype":"function"},{"id":"143980473252601604658","parentid":"143980431286911831408","roledesc":"工程填报权限","rolelevel":"0:3","rolename":"工程填报","roletype":"function"},{"id":"143980476411987648106","parentid":"143980431286911831408","roledesc":"人事填报权限","rolelevel":"0:3","rolename":"人事填报","roletype":"function"},{"id":"143980478561948405256","parentid":"143980431286911831408","roledesc":"综合填报权限","rolelevel":"0:3","rolename":"综合填报","roletype":"function"},{"id":"143980480469873820100","parentid":"143980431286911831408","roledesc":"财务填报权限","rolelevel":"0:3","rolename":"财务填报","roletype":"function"},{"id":"143980483688565135344","parentid":"143980431286911831408","roledesc":"预算计划分厂审核权限","rolelevel":"0:3","rolename":"预算计划分厂审核","roletype":"function"},{"id":"143980496536941371568","parentid":"143980491771385025323","roledesc":"工程费用复核权限","rolelevel":"0:3","rolename":"工程费用复核","roletype":"function"},{"id":"143980501304168461873","parentid":"143980491771385025323","roledesc":"综合费用复核权限","rolelevel":"0:3","rolename":"综合费用复核","roletype":"function"},{"id":"143980504346337387068","parentid":"143980491771385025323","roledesc":"品控费用复核权限","rolelevel":"0:3","rolename":"品控费用复核","roletype":"function"},{"id":"143980506277605166118","parentid":"143980491771385025323","roledesc":"人事费用复核权限","rolelevel":"0:3","rolename":"人事费用复核","roletype":"function"},{"id":"143980509213501655776","parentid":"143980491771385025323","roledesc":"财务费用复核权限","rolelevel":"0:3","rolename":"财务费用复核","roletype":"function"},{"id":"143980521474461187127","parentid":"143980518408825878668","roledesc":"品控费用审核权限","rolelevel":"0:3","rolename":"品控费用审核","roletype":"function"},{"id":"143980525058885575437","parentid":"143980518408825878668","roledesc":"工程费用审核权限","rolelevel":"0:3","rolename":"工程费用审核","roletype":"function"},{"id":"143980528790130042674","parentid":"143980518408825878668","roledesc":"人事费用审核权限","rolelevel":"0:3","rolename":"人事费用审核","roletype":"function"},{"id":"143980531521321825466","parentid":"143980518408825878668","roledesc":"综合费用审核权限","rolelevel":"0:3","rolename":"综合费用审核","roletype":"function"},{"id":"143980533197966452278","parentid":"143980518408825878668","roledesc":"财务费用审核权限","rolelevel":"0:3","rolename":"财务费用审核","roletype":"function"},{"id":"143980543591627184434","parentid":"143980540579106771527","roledesc":"公司汇总审核权限","rolelevel":"0:3","rolename":"公司汇总审核","roletype":"function"},{"id":"143980559590104340615","parentid":"143980556582332201835","roledesc":"预算计划发布","rolelevel":"0:3","rolename":"预算计划发布","roletype":"function"},{"id":"144350842585220455333","parentid":"143980431286911831408","roledesc":"多种经营填报权限","rolelevel":"0:3","rolename":"多种经营填报","roletype":"function"},{"id":"144350846103984852355","parentid":"143980518408825878668","roledesc":"多种经营审核权限","rolelevel":"0:3","rolename":"多种经营审核","roletype":"function"},{"id":"144386379675876545205","parentid":"143980431286911831408","roledesc":"收入填报权限","rolelevel":"0:3","rolename":"收入填报","roletype":"function"},{"id":"144386384810281455501","parentid":"143980518408825878668","roledesc":"收入预算审核权限","rolelevel":"0:3","rolename":"收入预算审核","roletype":"function"},{"id":"144387216641415355605","parentid":"144387215296127127328","roledesc":"年度预算财务部门审核","rolelevel":"0:2","rolename":"年度预算财务部门审核","roletype":"function"},{"id":"144387282236727475501","parentid":"0","roledesc":"数据审核","rolelevel":"0:1","rolename":"数据审核模块","roletype":"function"},{"id":"163440B45B9847298578F215653B496C","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"经营采购部","rolelevel":"0:02:02","rolename":"经营采购部","roletype":"function"},{"id":"4FB651486C4C4B5094069209A5701790","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"财务资产部","rolelevel":"0:02:06","rolename":"财务资产部","roletype":"function"},{"id":"5702C10B1DD84A80BF28809EFDF167E1","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"安全品控部","rolelevel":"0:02:03","rolename":"安全品控部","roletype":"function"},{"id":"65C68F4349084EB0831EEA2232E0EFB4","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"人力资源部","rolelevel":"0:02:05","rolename":"人力资源部","roletype":"function"},{"id":"6B2171036AC84F0FBA62F2AC8F607417","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"开发研究部","rolelevel":"0:02:04","rolename":"开发研究部","roletype":"function"},{"id":"6D58F4CE91544229B9651F99C4874A5D","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"行政综合部","rolelevel":"0:02:07","rolename":"行政综合部","roletype":"function"},{"id":"C8E190761A0E4DEEBCF9D8F6D2FCE8A7","parentid":"0","roledesc":"人事费用职能部门审核","rolelevel":"0:02","rolename":"人事费用职能部门审核","roletype":"function"},{"id":"F7EE859577AD478FABD326FA76779E0C","parentid":"FC37B2B6C5C3494E92DA31FB0BD37DD7","roledesc":"工程技术部","rolelevel":"0:02:01","rolename":"工程技术部","roletype":"function"}],"userId":"143920777043963135464","userName":"root"}
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
        private String examineState;
        private String userId;
        private String userName;
        /**
         * id : 143920797168047821875
         * parentid : 0
         * roledesc : 测试
         * rolelevel : 0:1
         * rolename : 测试
         * roletype : function
         */

        private List<RoleIdEntity> roleId;

        public void setExamineState(String examineState) {
            this.examineState = examineState;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setRoleId(List<RoleIdEntity> roleId) {
            this.roleId = roleId;
        }

        public String getExamineState() {
            return examineState;
        }

        public String getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public List<RoleIdEntity> getRoleId() {
            return roleId;
        }

        public static class RoleIdEntity {
            private String id;
            private String parentid;
            private String roledesc;
            private String rolelevel;
            private String rolename;
            private String roletype;

            public void setId(String id) {
                this.id = id;
            }

            public void setParentid(String parentid) {
                this.parentid = parentid;
            }

            public void setRoledesc(String roledesc) {
                this.roledesc = roledesc;
            }

            public void setRolelevel(String rolelevel) {
                this.rolelevel = rolelevel;
            }

            public void setRolename(String rolename) {
                this.rolename = rolename;
            }

            public void setRoletype(String roletype) {
                this.roletype = roletype;
            }

            public String getId() {
                return id;
            }

            public String getParentid() {
                return parentid;
            }

            public String getRoledesc() {
                return roledesc;
            }

            public String getRolelevel() {
                return rolelevel;
            }

            public String getRolename() {
                return rolename;
            }

            public String getRoletype() {
                return roletype;
            }
        }
    }
}
