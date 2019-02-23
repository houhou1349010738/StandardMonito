package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/20 0020.
 */
public class ProjectNameResponse extends RBResponse{

    private DataEntity data;
    /**
     * data : {"listTree":[{"attributes":{"unCheck":"true"},"children":[],"id":"JGWY","pid":"1","state":"open","text":"机构物业"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC03","pid":"JGWY","state":"open","text":"第三物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0015","pid":"GLC03","text":"电影城频道项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GZFGS","pid":"JGWY","state":"open","text":"广州分公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"GZWY0002","pid":"GZFGS","text":"广州分院项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC01","pid":"JGWY","state":"open","text":"第一物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0002","pid":"GLC01","text":"电子所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0003","pid":"GLC01","text":"网络中心怀柔园区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0004","pid":"GLC01","text":"力学所怀柔园区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0005","pid":"GLC01","text":"电子所怀柔园区项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC02","pid":"JGWY","state":"open","text":"第二物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0001","pid":"GLC02","text":"图书馆项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0002","pid":"GLC02","text":"理论物理所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0003","pid":"GLC02","text":"自然科学史所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0004","pid":"GLC02","text":"电站小楼项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0005","pid":"GLC02","text":"工程热物理所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0006","pid":"GLC02","text":"过程所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0007","pid":"GLC02","text":"科行大厦项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0008","pid":"GLC02","text":"中关村体育中心项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0009","pid":"GLC02","text":"北京银行项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0010","pid":"GLC02","text":"计生委药具中心项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0011","pid":"GLC02","text":"基因组项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0012","pid":"GLC02","text":"遥感所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0013","pid":"GLC02","text":"心理所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0002","pid":"GLC03","text":"西南多样性实验室项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0003","pid":"GLC03","text":"新技术基地项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0004","pid":"GLC03","text":"光电研究院项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0005","pid":"GLC03","text":"对地观测项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0006","pid":"GLC03","text":"声学所实验楼项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0007","pid":"GLC03","text":"空间应用与技术中心项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0010","pid":"GLC03","text":"中国科学技术大学项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0012","pid":"GLC03","text":"贵阳地化所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0013","pid":"GLC03","text":"海西研究院项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC04","pid":"JGWY","state":"open","text":"第四物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSIWY0001","pid":"GLC04","text":"苏州医工所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSIWY0002","pid":"GLC04","text":"上海微系统所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSIWY0003","pid":"GLC04","text":"动物所项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC05","pid":"JGWY","state":"open","text":"第五物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0001","pid":"GLC05","text":"北方微电子项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0002","pid":"GLC05","text":"大兴元陆项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0003","pid":"GLC05","text":"边防局亦庄项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0004","pid":"GLC05","text":"天津工业生物所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0005","pid":"GLC05","text":"天津华大基因项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0006","pid":"GLC05","text":"天津空港学校项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0007","pid":"GLC05","text":"工程热物理所廊坊园区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0008","pid":"GLC05","text":"行管局廊坊园区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0009","pid":"GLC05","text":"中科紫峰项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC06","pid":"JGWY","state":"open","text":"第六物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DLWY0001","pid":"GLC06","text":"计算所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DLWY0002","pid":"GLC06","text":"上地实验学校项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DLWY0003","pid":"GLC06","text":"农科院加工所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DLWY0005","pid":"GLC06","text":"广泰小区项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC07","pid":"JGWY","state":"open","text":"第七物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DQWY0001","pid":"GLC07","text":"物理所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DQWY0002","pid":"GLC07","text":"数学院项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DQWY0003","pid":"GLC07","text":"科学时报项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DQWY0004","pid":"GLC07","text":"电工所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DQWY0005","pid":"GLC07","text":"理化所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DQWY0006","pid":"GLC07","text":"中科资源大厦项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DQWY0007","pid":"GLC07","text":"边防局项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC08","pid":"JGWY","state":"open","text":"第八物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0001","pid":"GLC08","text":"科技馆项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0002","pid":"GLC08","text":"信息所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0003","pid":"GLC08","text":"院机关项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0004","pid":"GLC08","text":"青年公寓项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0005","pid":"GLC01","text":"网络中心项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0007","pid":"GLC08","text":"青岛生物能源与过程所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0008","pid":"GLC08","text":"烟台海岸带所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0009","pid":"GLC08","text":"东北地理所项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC09","pid":"JGWY","state":"open","text":"第九物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DJWY0001","pid":"GLC09","text":"微电子所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DJWY0002","pid":"GLC09","text":"古脊椎动物所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DJWY0003","pid":"GLC09","text":"半导体所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DJWY0004","pid":"GLC09","text":"高能所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DJWY0005","pid":"GLC09","text":"疾控中心"},{"attributes":{"unCheck":"false"},"children":[],"id":"DJWY0007","pid":"GLC09","text":"保障房项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GLC10","pid":"JGWY","state":"open","text":"第十物业管理处"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0001","pid":"GLC10","text":"学术会堂项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0002","pid":"GLC10","text":"化学所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0003","pid":"GLC10","text":"武汉植物园项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0004","pid":"GLC10","text":"中关村一小项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0005","pid":"GLC10","text":"中关村三小项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0006","pid":"GLC10","text":"人大附中实验小学项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0007","pid":"GLC10","text":"中科院附属实验学校项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"GZWY0001","pid":"GZFGS","text":"广州南海海洋所项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"ZZWY","pid":"1","state":"open","text":"住宅物业事业部"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0009","pid":"ZZWY","text":"声学所住宅区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0010","pid":"ZZWY","text":"东小区项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"ZYFGS","pid":"1","state":"open","text":"专业分公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"GCZY0001","pid":"ZYFGS","text":"绿化保洁分公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"GCZY0002","pid":"ZYFGS","text":"供电分公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"GCZY0003","pid":"ZYFGS","text":"电梯分公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"GCZY0004","pid":"ZYFGS","text":"弱电分公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"GCZY0005","pid":"ZYFGS","text":"供热分公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"GCZY0006","pid":"ZYFGS","text":"安保分公司"},{"attributes":{"unCheck":"true"},"children":[],"id":"DZJY","pid":"1","state":"open","text":"多种经营事业部"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0002","pid":"DZJY","text":"青岛项目部食堂"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0003","pid":"DZJY","text":"长春项目部食堂"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0004","pid":"DZJY","text":"贵阳项目部食堂"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0005","pid":"DZJY","text":"上海项目部食堂"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0006","pid":"DZJY","text":"福州项目部食堂"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0007","pid":"DZJY","text":"车辆租赁部"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0008","pid":"DZJY","text":"净水部"},{"attributes":{"unCheck":"true"},"children":[],"id":"ZGS","pid":"1","state":"open","text":"子公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0009","pid":"ZGS","text":"中科助研科技公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0011","pid":"DZJY","text":"房屋租赁部"},{"attributes":{"unCheck":"false"},"children":[],"id":"GCZY0007","pid":"ZYFGS","text":"装甲兵项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0000","pid":"DZJY","text":"餐饮总部"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0011","pid":"GLC08","text":"益园园区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0012","pid":"GLC08","text":"青岛平度基地项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DEWY0014","pid":"GLC02","text":"国科大怀柔园区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0003","pid":"ZZWY","text":"住宅机关项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0004","pid":"ZZWY","text":"黄庄小区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0005","pid":"ZZWY","text":"住宅第二项目部"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0006","pid":"ZZWY","text":"住宅第三项目部"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0007","pid":"ZZWY","text":"住宅第四项目部"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0008","pid":"ZZWY","text":"住宅第五项目部"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0013","pid":"GLC08","text":"北大生科院项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0014","pid":"GLC08","text":"海洋研究所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DWWY0010","pid":"GLC05","text":"理化所廊坊园区项目"},{"attributes":{"unCheck":"true"},"children":[],"id":"GSJG","pid":"1","state":"open","text":"公司机关"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0001","pid":"GSJG","text":"行政综合部"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0002","pid":"GSJG","text":"人力资源部"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0003","pid":"GSJG","text":"财务资产部"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0004","pid":"GSJG","text":"开发研究部"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0005","pid":"GSJG","text":"经营采购部"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0006","pid":"GSJG","text":"安全品控部"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0007","pid":"GSJG","text":"工程技术部"},{"attributes":{"unCheck":"false"},"children":[],"id":"DBWY0015","pid":"GLC08","text":"北大燕京学堂项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0008","pid":"GLC10","text":"人大附中项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0009","pid":"GLC10","text":"中国扶贫基金会"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0014","pid":"DZJY","text":"多种经营本部"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0015","pid":"ZGS","text":"建筑工程公司"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0006","pid":"GLC01","text":"声学所项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0007","pid":"GLC01","text":"农行石景山支行项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0008","pid":"GLC01","text":"中关村力学配电室"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0010","pid":"GLC10","text":"化学所天津武清基地项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0017","pid":"DZJY","text":"石油化工项目部食堂"},{"attributes":{"unCheck":"false"},"children":[],"id":"DZJY0016","pid":"DZJY","text":"贵阳科学城项目部食堂"},{"attributes":{"unCheck":"false"},"children":[],"id":"DYWY0009","pid":"GLC01","text":"中关村海关楼项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSWY0016","pid":"GLC03","text":"三亚深海项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSIWY0005","pid":"GLC04","text":"嘉定人才公寓项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0011","pid":"GLC10","text":"石油化工管理干部学院"},{"attributes":{"unCheck":"false"},"children":[],"id":"GSJG0008","pid":"GSJG","text":"机关公共部"},{"attributes":{"unCheck":"false"},"children":[],"id":"ZZWY0011","pid":"ZZWY","text":"东南小区项目"},{"attributes":{"unCheck":"false"},"children":[],"id":"DSHWY0012","pid":"GLC10","text":"知春里中学项目"}]}
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
         * attributes : {"unCheck":"true"}
         * children : []
         * id : JGWY
         * pid : 1
         * state : open
         * text : 机构物业
         */

        private List<ListTreeEntity> listTree;

        public void setListTree(List<ListTreeEntity> listTree) {
            this.listTree = listTree;
        }

        public List<ListTreeEntity> getListTree() {
            return listTree;
        }

        public static class ListTreeEntity {
            /**
             * unCheck : true
             */

            private AttributesEntity attributes;
            private String id;
            private String pid;
            private String state;
            private String text;
            private List<?> children;

            public void setAttributes(AttributesEntity attributes) {
                this.attributes = attributes;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setText(String text) {
                this.text = text;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }

            public AttributesEntity getAttributes() {
                return attributes;
            }

            public String getId() {
                return id;
            }

            public String getPid() {
                return pid;
            }

            public String getState() {
                return state;
            }

            public String getText() {
                return text;
            }

            public List<?> getChildren() {
                return children;
            }

            public static class AttributesEntity {
                private String unCheck;

                public void setUnCheck(String unCheck) {
                    this.unCheck = unCheck;
                }

                public String getUnCheck() {
                    return unCheck;
                }
            }
        }
    }
}
