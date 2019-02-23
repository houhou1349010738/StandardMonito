package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class RainCityJsonResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"ylMap":[{"id":"1213123123213","level":"2","point":"116.335796:39.941336","unitCode":"Y23","unitName":"西直门","value":"78.5"},{"id":"402881ee38f714670138f96345970592","level":"3","point":"116.41355918921:39.955944953915","unitCode":"Y1","unitName":"安定门","value":"180.1"},{"id":"402881ee38f714670141f96345970595","level":"1","point":"116.44772497721:39.904797055315","unitCode":"Y4","unitName":"东便门","value":"33.0"},{"id":"402881ee38f714670143f96345970597","level":"3","point":"116.43076614421:39.880357192415","unitCode":"Y6","unitName":"东蒲","value":"129.0"},{"id":"402881ee38f714670144f96345970598","level":"3","point":"116.44085022221:39.946648025815","unitCode":"Y7","unitName":"东直门","value":"120.1"},{"id":"402881ee38f714670145f96345970599","level":"0","point":"116.35573845621:39.894967790915","unitCode":"Y8","unitName":"广安门","value":"0.0"},{"id":"402881ee38f714670146f96345970600","level":"4","point":"116.42034182621:39.877795298515","unitCode":"Y9","unitName":"景泰","value":"530.0"},{"id":"402881ee38f714670147f96345970601","level":"2","point":"116.44574996421:39.899563479015","unitCode":"Y10","unitName":"夕照寺","value":"85.9"},{"id":"402881ee38f714670148f96345970602","level":"4","point":"116.42415699821:39.878498944315","unitCode":"Y11","unitName":"西蒲","value":"530.0"},{"id":"402881ee38f714670149f96345970603","level":"4","point":"116.41043735421:39.877863548215","unitCode":"Y12","unitName":"永定门","value":"563.0"},{"id":"402881ee38f714670150f96345970604","level":"0","point":"116.44709532621:39.877758199315","unitCode":"Y13","unitName":"左安门","value":"0.0"},{"id":"402881ee38f714670151f96345970605","level":"2","point":"116.39509502521:39.874601025015","unitCode":"Y14","unitName":"马家堡","value":"93.0"},{"id":"402881ee38f714670152f96345970606","level":"2","point":"116.40151034721:39.975754990115","unitCode":"Y15","unitName":"安华桥","value":"78.2"},{"id":"402881ee38f714670154f96345970608","level":"4","point":"116.39841531121:39.993598362115","unitCode":"Y17","unitName":"北中轴","value":"7894.8"},{"id":"402881ee38f714670155f96345970609","level":"2","point":"116.49728043521:39.910900770415","unitCode":"Y18","unitName":"编组站","value":"87.2"},{"id":"402881ee38f714670156f96345970610","level":"3","point":"116.54898492321:39.930585742015","unitCode":"Y19","unitName":"朝北五环","value":"156.0"},{"id":"402881ee38f714670157f96345970611","level":"2","point":"116.40585316121:40.000469503215","unitCode":"Y20","unitName":"成府路东","value":"86.1"},{"id":"402881ee38f714670158f96345970612","level":"0","point":"116.39579470321:40.001314024015","unitCode":"Y21","unitName":"成府路西","value":"0.0"},{"id":"402881ee38f714670159f96345970613","level":"4","point":"116.39223536321:40.007853802115","unitCode":"Y22","unitName":"大屯路西","value":"877.1"},{"id":"402881ee38f714670160f96345970614","level":"0","point":"116.48467900021:39.908132602015","unitCode":"Y230","unitName":"大望路","value":"0.0"},{"id":"402881ee38f714670161f96345970615","level":"2","point":"116.53433991521:39.898014196315","unitCode":"Y24","unitName":"高热","value":"78.0"},{"id":"402881ee38f714670162f96345970616","level":"4","point":"116.43658448021:39.976915828515","unitCode":"Y25","unitName":"和平里","value":"583.6"},{"id":"402881ee38f714670163f96345970617","level":"4","point":"116.43831211821:40.050558576615","unitCode":"Y26","unitName":"红军营","value":"841.0"},{"id":"402881ee38f714670164f96345970618","level":"4","point":"116.46523144721:40.009479540315","unitCode":"Y27","unitName":"湖光中街","value":"231.6"},{"id":"402881ee38f714670165f96345970619","level":"2","point":"116.52488723121:39.876204596815","unitCode":"Y28","unitName":"京沈","value":"52.6"},{"id":"402881ee38f714670166f96345970620","level":"1","point":"116.51620615721:39.996447165915","unitCode":"Y29","unitName":"酒仙桥","value":"45.4"},{"id":"402881ee38f714670167f96345970621","level":"1","point":"116.46251097821:40.027736227715","unitCode":"Y30","unitName":"来广营西","value":"0.5"},{"id":"402881ee38f714670168f96345970622","level":"3","point":"116.45008189221:39.994506061815","unitCode":"Y31","unitName":"来广营","value":"123.4"},{"id":"402881ee38f714670169f96345970623","level":"4","point":"116.46520018521:39.838494934815","unitCode":"Y32","unitName":"龙爪树","value":"610.1"},{"id":"402881ee38f714670170f96345970624","level":"3","point":"116.46879880621:39.950103148115","unitCode":"Y33","unitName":"农展馆","value":"123.1"},{"id":"402881ee38f714670171f96345970625","level":"1","point":"116.51724387921:39.929243510815","unitCode":"Y34","unitName":"石佛营","value":"4.0"},{"id":"402881ee38f714670172f96345970626","level":"0","point":"116.58433138721:39.906560745715","unitCode":"Y35","unitName":"双桥","value":"0.0"},{"id":"402881ee38f714670173f96345970627","level":"1","point":"116.49905468421:39.914413080115","unitCode":"Y36","unitName":"四惠","value":"9.2"},{"id":"402881ee38f714670174f96345970628","level":"2","point":"116.52068058521:39.914936877415","unitCode":"Y37","unitName":"四惠东","value":"52.1"},{"id":"402881ee38f714670175f96345970629","level":"1","point":"116.44296698421:39.982581630815","unitCode":"Y38","unitName":"土城北","value":"9.6"},{"id":"402881ee38f714670176f96345970630","level":"1","point":"116.46074266521:40.014969592015","unitCode":"Y39","unitName":"辛店","value":"24.7"},{"id":"402881ee38f714670177f96345970631","level":"3","point":"116.51468308521:39.944937263215","unitCode":"Y40","unitName":"姚家园","value":"130.0"},{"id":"402881ee38f714670179f96345970633","level":"3","point":"116.47051386221:39.877348452015","unitCode":"Y42","unitName":"左安东路","value":"123.0"},{"id":"402881ee38f714670180f96345970634","level":"1","point":"116.40541062421:40.064943528015","unitCode":"Y43","unitName":"中滩","value":"4.3"},{"id":"402881ee38f714670182f96345970636","level":"1","point":"116.33391134821:39.992713113915","unitCode":"Y45","unitName":"北二街","value":"8.1"},{"id":"402881ee38f714670183f96345970637","level":"3","point":"116.35229178921:39.974517078415","unitCode":"Y46","unitName":"大钟寺","value":"123.0"},{"id":"402881ee38f714670184f96345970638","level":"4","point":"116.31187364721:40.062797010415","unitCode":"Y47","unitName":"东北旺","value":"902.0"},{"id":"402881ee38f714670185f96345970639","level":"2","point":"116.36379850121:40.077547945515","unitCode":"Y48","unitName":"黄平东路","value":"82.0"},{"id":"402881ee38f714670186f96345970640","level":"1","point":"116.34610428521:39.993277473915","unitCode":"Y49","unitName":"京包","value":"5.0"},{"id":"402881ee38f714670187f96345970641","level":"1","point":"116.32700888621:40.036324336315","unitCode":"Y50","unitName":"上地南","value":"4.0"},{"id":"402881ee38f714670188f96345970642","level":"2","point":"116.30235437221:39.901700705815","unitCode":"Y51","unitName":"万寿路","value":"81.1"},{"id":"402881ee38f714670189f96345970643","level":"2","point":"116.28058222621:39.940595083915","unitCode":"Y52","unitName":"五路居","value":"81.0"},{"id":"402881ee38f714670190f96345970644","level":"2","point":"116.31437840021:40.058042200115","unitCode":"Y53","unitName":"西二旗","value":"89.4"},{"id":"402881ee38f714670191f96345970645","level":"3","point":"116.29318042621:40.019384995815","unitCode":"Y54","unitName":"园西","value":"126.0"},{"id":"402881ee38f714670192f96345970646","level":"1","point":"116.34627332721:39.982398970415","unitCode":"Y55","unitName":"知春里","value":"45.0"},{"id":"402881ee38f714670193f96345970647","level":"2","point":"116.33530117221:39.903088049115","unitCode":"Y56","unitName":"北蜂窝","value":"80.0"},{"id":"402881ee38f714670194f96345970648","level":"1","point":"116.21260785521:39.848496242315","unitCode":"Y57","unitName":"杜家坎","value":"4.0"},{"id":"402881ee38f714670196f96345970650","level":"2","point":"116.28997882721:39.852770182915","unitCode":"Y59","unitName":"丰台大桥","value":"52.0"},{"id":"402881ee38f714670197f96345970651","level":"1","point":"116.32320461421:39.786256374215","unitCode":"Y60","unitName":"京九","value":"45.0"},{"id":"402881ee38f714670198f96345970652","level":"4","point":"116.35137866221:39.873967262915","unitCode":"Y61","unitName":"丽泽","value":"320.0"},{"id":"402881ee38f714670199f96345970653","level":"1","point":"116.31792280921:39.902279887015","unitCode":"Y62","unitName":"莲花池","value":"9.0"},{"id":"402881ee38f714670200f96345970654","level":"0","point":"116.31606885721:39.889773559515","unitCode":"Y63","unitName":"六里桥","value":"0.0"},{"id":"402881ee38f714670201f96345970655","level":"1","point":"116.23131116121:39.853627783215","unitCode":"Y64","unitName":"卢沟桥","value":"42.0"},{"id":"402881ee38f714670202f96345970656","level":"3","point":"116.37899919621:39.865545847015","unitCode":"Y65","unitName":"马家堡西","value":"123.0"},{"id":"402881ee38f714670203f96345970657","level":"3","point":"116.40788741121:39.860783399215","unitCode":"Y66","unitName":"木樨园","value":"102.0"},{"id":"402881ee38f714670204f96345970658","level":"2","point":"116.35209812721:39.824551899715","unitCode":"Y67","unitName":"潘家庙","value":"52.0"},{"id":"402881ee38f714670206f96345970660","level":"1","point":"116.35791688521:39.838371873215","unitCode":"Y69","unitName":"四开","value":"45.0"},{"id":"402881ee38f714670208f96345970662","level":"2","point":"116.39549627021:39.837439668015","unitCode":"Y70","unitName":"太平街南延","value":"82.0"},{"id":"402881ee38f714670209f96345970663","level":"2","point":"116.38951501421:39.763952213715","unitCode":"Y71","unitName":"太五","value":"52.0"},{"id":"402881ee38f714670211f96345970665","level":"4","point":"116.32809409921:39.902312070015","unitCode":"Y73","unitName":"西客站西","value":"201.0"},{"id":"402881ee38f714670212f96345970666","level":"4","point":"116.32535821621:39.864351919515","unitCode":"Y74","unitName":"西南三环","value":"323.0"},{"id":"402881ee38f714670213f96345970667","level":"1","point":"116.40893842521:39.837618199715","unitCode":"Y75","unitName":"永南立交","value":"7.0"},{"id":"402881ee38f714670215f96345970669","level":"1","point":"116.45405284621:39.834782722815","unitCode":"Y77","unitName":"成寿寺","value":"45.4"},{"id":"402881ee38f714670216f96345970671","level":"3","point":"116.354825:39.940150","unitCode":"Y79","unitName":"排水集团","value":"102.0"},{"id":"402881ee38f714670216f96345970672","level":"2","point":"116.413616:39.908531","unitCode":"Y80","unitName":"天安门","value":"59.0"},{"id":"8a82e7823fbc32a5013fbcfadd610015","level":"2","point":"116.23293072872:39.939330619844","unitCode":"Y81","unitName":"巨山","value":"79.9"},{"id":"8a82e78240865a960140a4b3c0df01d6","level":"4","point":"116.49827923172:39.927333850244","unitCode":"Y82","unitName":"红领巾","value":"557.1"},{"id":"8a82e7824ce91b3a014d084bce8f008e","level":"2","point":"116.13824143921:39.943520876115","unitCode":"Y84","unitName":"麻峪新","value":"78.0"},{"id":"8a82e7824d09b2a0014d3824f38800a1","level":"3","point":"116.61458527821:39.903996388615","unitCode":"Y86","unitName":"中古路新","value":"156.0"},{"id":"8a82e7824ddc033b014dfb482218020f","level":"4","point":"116.372568:39.92962","unitCode":"Y94","unitName":"白塔寺","value":"836.0"},{"id":"8a82e7824e046e00014e0af5e37e0080","level":"4","point":"116.30373265321:39.951909725715","unitCode":"W10","unitName":"车道沟","value":"836.0"},{"id":"8a82e7824e046e00014e0afc390a008e","level":"0","point":"116.28190142121:39.881520775515","unitCode":"W2","unitName":"岳各庄","value":"0.0"},{"id":"8a82e7824e248089014e24be3d3d0097","level":"4","point":"116.59560174021:39.880658651315","unitCode":"W11","unitName":"定福庄","value":"787.0"},{"id":"8a82e7824eafb8f9014eba8b41f400c1","level":"4","point":"116.447:39.931","unitCode":"Y95","unitName":"芳草地","value":"883.2"},{"id":"8a82e7824ed7d5b0014ed89701a2000a","level":"2","point":"116.35398254021:39.860785369015","unitCode":"Y87","unitName":"双营新","value":"85.0"},{"id":"8a82e7824f7358cd014f780d0338005c","level":"4","point":"116.413933:39.929456","unitCode":"Y96","unitName":"东四","value":"956.3"},{"id":"8a82e794458e659801458e7711260007","level":"2","point":"116.40844579072:40.007931888144","unitCode":"Y83","unitName":"大屯路东","value":"89.6"}]}
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
         * id : 1213123123213
         * level : 2
         * point : 116.335796:39.941336
         * unitCode : Y23
         * unitName : 西直门
         * value : 78.5
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
            private String level;
            private String point;
            private String unitCode;
            private String unitName;
            private String value;

            public void setId(String id) {
                this.id = id;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public void setPoint(String point) {
                this.point = point;
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

            public String getLevel() {
                return level;
            }

            public String getPoint() {
                return point;
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
