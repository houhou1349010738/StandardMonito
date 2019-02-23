package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class RainCityResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"ylMap":[{"id":"Y17","unitCode":"Y17","unitName":"北中轴","value":"7894.8"},{"id":"Y96","unitCode":"Y96","unitName":"东四","value":"956.3"},{"id":"Y47","unitCode":"Y47","unitName":"东北旺","value":"902"},{"id":"Y95","unitCode":"Y95","unitName":"芳草地","value":"883.2"},{"id":"Y22","unitCode":"Y22","unitName":"大屯路西","value":"877.1"},{"id":"Y26","unitCode":"Y26","unitName":"红军营","value":"841"},{"id":"Y94","unitCode":"Y94","unitName":"白塔寺","value":"836"},{"id":"W10","unitCode":"W10","unitName":"车道沟","value":"836"},{"id":"W11","unitCode":"W11","unitName":"定福庄","value":"787"},{"id":"Y32","unitCode":"Y32","unitName":"龙爪树","value":"610.1"},{"id":"Y25","unitCode":"Y25","unitName":"和平里","value":"583.6"},{"id":"Y12","unitCode":"Y12","unitName":"永定门","value":"563"},{"id":"Y82","unitCode":"Y82","unitName":"红领巾","value":"557.1"},{"id":"Y11","unitCode":"Y11","unitName":"西蒲","value":"530"},{"id":"Y9","unitCode":"Y9","unitName":"景泰","value":"530"},{"id":"Y74","unitCode":"Y74","unitName":"西南三环","value":"323"},{"id":"Y61","unitCode":"Y61","unitName":"丽泽","value":"320"},{"id":"Y27","unitCode":"Y27","unitName":"湖光中街","value":"231.6"},{"id":"Y73","unitCode":"Y73","unitName":"西客站西","value":"201"},{"id":"Y1","unitCode":"Y1","unitName":"安定门","value":"180.1"},{"id":"Y19","unitCode":"Y19","unitName":"朝北五环","value":"156"},{"id":"Y86","unitCode":"Y86","unitName":"中古路新","value":"156"},{"id":"Y40","unitCode":"Y40","unitName":"姚家园","value":"130"},{"id":"Y6","unitCode":"Y6","unitName":"东蒲","value":"129"},{"id":"Y54","unitCode":"Y54","unitName":"园西","value":"126"},{"id":"Y31","unitCode":"Y31","unitName":"来广营","value":"123.4"},{"id":"Y33","unitCode":"Y33","unitName":"农展馆","value":"123.1"},{"id":"Y42","unitCode":"Y42","unitName":"左安东路","value":"123"},{"id":"Y65","unitCode":"Y65","unitName":"马家堡西","value":"123"},{"id":"Y46","unitCode":"Y46","unitName":"大钟寺","value":"123"},{"id":"Y7","unitCode":"Y7","unitName":"东直门","value":"120.1"},{"id":"Y79","unitCode":"Y79","unitName":"排水集团","value":"102"},{"id":"Y66","unitCode":"Y66","unitName":"木樨园","value":"102"},{"id":"Y14","unitCode":"Y14","unitName":"马家堡","value":"93"},{"id":"Y83","unitCode":"Y83","unitName":"大屯路东","value":"89.6"},{"id":"Y53","unitCode":"Y53","unitName":"西二旗","value":"89.4"},{"id":"Y18","unitCode":"Y18","unitName":"编组站","value":"87.2"},{"id":"Y20","unitCode":"Y20","unitName":"成府路东","value":"86.1"},{"id":"Y10","unitCode":"Y10","unitName":"夕照寺","value":"85.9"},{"id":"Y87","unitCode":"Y87","unitName":"双营新","value":"85"},{"id":"Y48","unitCode":"Y48","unitName":"黄平东路","value":"82"},{"id":"Y70","unitCode":"Y70","unitName":"太平街南延","value":"82"},{"id":"Y51","unitCode":"Y51","unitName":"万寿路","value":"81.1"},{"id":"Y52","unitCode":"Y52","unitName":"五路居","value":"81"},{"id":"Y56","unitCode":"Y56","unitName":"北蜂窝","value":"80"},{"id":"Y81","unitCode":"Y81","unitName":"巨山","value":"79.9"},{"id":"Y23","unitCode":"Y23","unitName":"西直门","value":"78.5"},{"id":"Y15","unitCode":"Y15","unitName":"安华桥","value":"78.2"},{"id":"Y24","unitCode":"Y24","unitName":"高热","value":"78"},{"id":"Y84","unitCode":"Y84","unitName":"麻峪新","value":"78"},{"id":"Y80","unitCode":"Y80","unitName":"天安门","value":"59"},{"id":"Y28","unitCode":"Y28","unitName":"京沈","value":"52.6"},{"id":"Y37","unitCode":"Y37","unitName":"四惠东","value":"52.1"},{"id":"Y71","unitCode":"Y71","unitName":"太五","value":"52"},{"id":"Y67","unitCode":"Y67","unitName":"潘家庙","value":"52"},{"id":"Y59","unitCode":"Y59","unitName":"丰台大桥","value":"52"},{"id":"Y77","unitCode":"Y77","unitName":"成寿寺","value":"45.4"},{"id":"Y29","unitCode":"Y29","unitName":"酒仙桥","value":"45.4"},{"id":"Y55","unitCode":"Y55","unitName":"知春里","value":"45"},{"id":"Y69","unitCode":"Y69","unitName":"四开","value":"45"},{"id":"Y60","unitCode":"Y60","unitName":"京九","value":"45"},{"id":"Y64","unitCode":"Y64","unitName":"卢沟桥","value":"42"},{"id":"Y4","unitCode":"Y4","unitName":"东便门","value":"33"},{"id":"Y39","unitCode":"Y39","unitName":"辛店","value":"24.7"},{"id":"Y38","unitCode":"Y38","unitName":"土城北","value":"9.6"},{"id":"Y36","unitCode":"Y36","unitName":"四惠","value":"9.2"},{"id":"Y62","unitCode":"Y62","unitName":"莲花池","value":"9"},{"id":"Y45","unitCode":"Y45","unitName":"北二街","value":"8.1"},{"id":"Y75","unitCode":"Y75","unitName":"永南立交","value":"7"},{"id":"Y49","unitCode":"Y49","unitName":"京包","value":"5"},{"id":"Y43","unitCode":"Y43","unitName":"中滩","value":"4.3"},{"id":"Y50","unitCode":"Y50","unitName":"上地南","value":"4"},{"id":"Y34","unitCode":"Y34","unitName":"石佛营","value":"4"},{"id":"Y57","unitCode":"Y57","unitName":"杜家坎","value":"4"},{"id":"Y30","unitCode":"Y30","unitName":"来广营西","value":"0.5"}]}
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
         * id : Y17
         * unitCode : Y17
         * unitName : 北中轴
         * value : 7894.8
         */

        private List<YlMapEntity> ylMap;

        public void setYlMap(List<YlMapEntity> ylMap) {
            this.ylMap = ylMap;
        }

        public List<YlMapEntity> getYlMap() {
            return ylMap;
        }

        public static class YlMapEntity {
            private String id;
            private String unitCode;
            private String unitName;
            private String value;

            public void setId(String id) {
                this.id = id;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getId() {
                return id;
            }

            public String getUnitCode() {
                return unitCode;
            }

            public String getUnitName() {
                return unitName;
            }

            public String getValue() {
                return value;
            }
        }
    }
}
