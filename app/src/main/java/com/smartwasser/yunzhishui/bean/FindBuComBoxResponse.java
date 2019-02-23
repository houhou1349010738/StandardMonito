package com.smartwasser.yunzhishui.bean;
import java.util.List;
/**
 * Created by huangmengjie on 2016/5/11 0011.
 */
public class FindBuComBoxResponse extends RBResponse{

    private DataEntity data;
    /**
     * data : {"listTree":[{"businessUnitCode":"0","businessUnitName":"业务单元","creatManCode":"1101070000","creatManName":"生产系统测试","id":"0","orderBy":0,"parentUnitCode":"-1","status":1,"updateManCode":"root","updateManName":"后台管理员"},{"businessUnitCode":"CZWS3802","businessUnitName":"北排建设","creatManCode":"1101070000","creatManName":"生产系统测试","id":"0f44ff51a12345f693ceb28eb19b707f","orderBy":109,"parentUnitCode":"0","properites":"QT","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-11 18:30:12","usergroupCode":"100130900","usergroupName":"北排建设"},{"businessUnitCode":"CZWS0835","businessUnitName":"康庄污水处理厂","id":"13","orderBy":113,"parentUnitCode":"0","properites":"WS","stUnitCode":"1102560000","stUnitName":"高碑店厂康庄厂","status":1,"updateManCode":"root","updateManName":"后台管理员","usergroupCode":"100130130","usergroupName":"高碑店康庄厂"},{"businessUnitCode":"CZWS1020","businessUnitName":"小红门污水处理厂","id":"14","orderBy":20,"parentUnitCode":"0","properites":"WS","stUnitCode":"1104000000","stUnitName":"小红门厂","status":1,"updateManCode":"root","updateManName":"后台管理员","usergroupCode":"100130230","usergroupName":"小红门厂"},{"businessUnitCode":"CZWS1025","businessUnitName":"小红门60万吨污水","id":"15","orderBy":21,"parentUnitCode":"CZWS1020","properites":"WS","stUnitCode":"1104520000","stUnitName":"小红门厂运行分厂","status":1,"updateManCode":"root","updateManName":"后台管理员","usergroupCode":"100130240","usergroupName":"小红门运行分厂"},{"businessUnitCode":"CZWN1030","businessUnitName":"小红门污泥","id":"16","orderBy":22,"parentUnitCode":"CZWS1020","properites":"WS","stUnitCode":"1104530000","stUnitName":"小红门厂污泥分厂","status":1,"updateManCode":"root","updateManName":"后台管理员","usergroupCode":"100130250","usergroupName":"小红门污泥分厂"},{"businessUnitCode":"CZWS2202","businessUnitName":"wesdsd","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-12 10:50:55","id":"3240049517ec11e69477000c29b2d655","orderBy":4,"parentUnitCode":"CZWS1025","properites":"WS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-12 10:50:55"},{"businessUnitCode":"CZWS42343","businessUnitName":"werfef","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-12 10:51:25","id":"4458c7a617ec11e69477000c29b2d655","orderBy":34,"parentUnitCode":"CZWS3802","properites":"WS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-12 11:10:58"},{"businessUnitCode":"CZWS32453453","businessUnitName":"3453453","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-12 10:52:13","id":"60e4e2b117ec11e69477000c29b2d655","orderBy":43,"parentUnitCode":"CZWS42343","properites":"WS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-12 11:10:35"},{"businessUnitCode":"CZWS3434","businessUnitName":"343","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-12 10:52:40","id":"712ef61017ec11e69477000c29b2d655","orderBy":34,"parentUnitCode":"CZWS32453453","properites":"WS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-12 10:52:40"},{"businessUnitCode":"CZWS3453","businessUnitName":"3453","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-05-12 10:53:06","id":"80d9b26f17ec11e69477000c29b2d655","orderBy":23,"parentUnitCode":"CZWS3434","properites":"WS","status":1,"updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-12 10:53:06"}]}
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
         * businessUnitCode : 0
         * businessUnitName : 业务单元
         * creatManCode : 1101070000
         * creatManName : 生产系统测试
         * id : 0
         * orderBy : 0
         * parentUnitCode : -1
         * status : 1
         * updateManCode : root
         * updateManName : 后台管理员
         */

        private List<ListTreeEntity> listTree;

        public void setListTree(List<ListTreeEntity> listTree) {
            this.listTree = listTree;
        }

        public List<ListTreeEntity> getListTree() {
            return listTree;
        }

        public static class ListTreeEntity {
            private String businessUnitCode;
            private String businessUnitName;
            private String creatManCode;
            private String creatManName;
            private String id;
            private int orderBy;
            private String parentUnitCode;
            private int status;
            private String updateManCode;
            private String updateManName;

            public void setBusinessUnitCode(String businessUnitCode) {
                this.businessUnitCode = businessUnitCode;
            }

            public void setBusinessUnitName(String businessUnitName) {
                this.businessUnitName = businessUnitName;
            }

            public void setCreatManCode(String creatManCode) {
                this.creatManCode = creatManCode;
            }

            public void setCreatManName(String creatManName) {
                this.creatManName = creatManName;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setOrderBy(int orderBy) {
                this.orderBy = orderBy;
            }

            public void setParentUnitCode(String parentUnitCode) {
                this.parentUnitCode = parentUnitCode;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setUpdateManCode(String updateManCode) {
                this.updateManCode = updateManCode;
            }

            public void setUpdateManName(String updateManName) {
                this.updateManName = updateManName;
            }

            public String getBusinessUnitCode() {
                return businessUnitCode;
            }

            public String getBusinessUnitName() {
                return businessUnitName;
            }

            public String getCreatManCode() {
                return creatManCode;
            }

            public String getCreatManName() {
                return creatManName;
            }

            public String getId() {
                return id;
            }

            public int getOrderBy() {
                return orderBy;
            }

            public String getParentUnitCode() {
                return parentUnitCode;
            }

            public int getStatus() {
                return status;
            }

            public String getUpdateManCode() {
                return updateManCode;
            }

            public String getUpdateManName() {
                return updateManName;
            }
        }
    }
}
