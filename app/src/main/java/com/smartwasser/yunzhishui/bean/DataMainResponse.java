package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/4/29 0029.
 */
public class DataMainResponse extends RBResponse{
    private DataEntity data;
    /**
     * data : {"BcCmsInfo":[{"author":"90","channelid":"139926143660501154135","content":"","crtime":"2016-03-25","cruser":"后台管理员","docquote":"90-","id":"3438444f43b3103488cd6c38d172c78f","indextitle":"90","status":1,"title":"-9090","writetime":"2016-03-02"}]}
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
         * author : 90  管理员姓名
         * channelid : 139926143660501154135
         * content :
         * crtime : 2016-03-25
         * cruser : 后台管理员
         * docquote : 90-
         * id : 3438444f43b3103488cd6c38d172c78f
         * indextitle : 90
         * status : 1
         * title : -9090  内容
         * writetime : 2016-03-02  时间
         */
        private List<BcCmsInfoEntity> BcCmsInfo;
        public void setBcCmsInfo(List<BcCmsInfoEntity> BcCmsInfo) {
            this.BcCmsInfo = BcCmsInfo;
        }
        public List<BcCmsInfoEntity> getBcCmsInfo() {
            return BcCmsInfo;
        }
        public static class BcCmsInfoEntity {
            private String author;
            private String channelid;
            private String content;
            private String crtime;
            private String cruser;
            private String docquote;
            private String id;
            private String indextitle;
            private int status;
            private String title;
            private String writetime;

            public void setAuthor(String author) {
                this.author = author;
            }

            public void setChannelid(String channelid) {
                this.channelid = channelid;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setCrtime(String crtime) {
                this.crtime = crtime;
            }

            public void setCruser(String cruser) {
                this.cruser = cruser;
            }

            public void setDocquote(String docquote) {
                this.docquote = docquote;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIndextitle(String indextitle) {
                this.indextitle = indextitle;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setWritetime(String writetime) {
                this.writetime = writetime;
            }

            public String getAuthor() {
                return author;
            }

            public String getChannelid() {
                return channelid;
            }

            public String getContent() {
                return content;
            }

            public String getCrtime() {
                return crtime;
            }

            public String getCruser() {
                return cruser;
            }

            public String getDocquote() {
                return docquote;
            }

            public String getId() {
                return id;
            }

            public String getIndextitle() {
                return indextitle;
            }

            public int getStatus() {
                return status;
            }

            public String getTitle() {
                return title;
            }

            public String getWritetime() {
                return writetime;
            }
        }
    }
}
