package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/6 0006.
 */
public class LegerListResponse extends RBResponse {

    /**
     * EqEquipInfo : {"rows":[{"abcType":1,"asCode":"3301080051","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000269","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c796010f10027","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"15＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080050","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000270","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c79615e610028","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"14＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080048","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000272","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c7964c3c3002a","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"12＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080046","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000274","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c796793fa002c","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"10＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080045","asDept":"CZWN0830","asValue":66023,"equipCharge":"","equipCode":"00000275","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c7968c3a0002d","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-09-21 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"9＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301080018","asDept":"CZWS0820","asValue":90761,"equipCharge":"","equipCode":"00000295","equipEnabledDate":"2002-01-01 00:00:00","equipEntryDate":"2003-07-15 00:00:00","equipId":"402881e44c797e4b014c79917980000a","equipLocCode":"402836814c72eddf014c7312ddb1000a","equipLocCodeName":"高碑店一分厂","equipMakeCode":"","equipMakeCountry":"瑞典","equipMaker":"飞力","equipModel":"CP3201","equipName":"一期剩余污泥泵","equipOwnDept":"CZWS0820","equipOwnDeptName":"高碑店一分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"180MT630","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":13140,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301080002","asDept":"CZWS0820","asValue":1632,"equipCharge":"","equipCode":"00000301","equipEnabledDate":"1993-12-01 00:00:00","equipEntryDate":"2003-07-15 00:00:00","equipId":"402881e44c797e4b014c7999c6fd0010","equipLocCode":"402836814c72eddf014c7312ddb1000a","equipLocCodeName":"高碑店一分厂","equipMakeCode":"","equipMakeCountry":"","equipMaker":"","equipModel":"AS75-2CB","equipName":"2#潜污泵","equipOwnDept":"CZWS0820","equipOwnDeptName":"高碑店一分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301050015","asDept":"CZWN0830","asValue":15400,"equipCharge":"","equipCode":"00000311","equipEnabledDate":"2007-06-08 00:00:00","equipEntryDate":"2007-06-08 00:00:00","equipId":"402881e44c797e4b014c79af6172001a","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"丹麦","equipMaker":"格兰富","equipModel":"CRN1-17 Q=1~2m3/h","equipName":"1#加湿泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080024","asValue":49364,"equipCharge":"","equipCode":"1428049573000","equipEnabledDate":"1999-08-31 00:00:00","equipEntryDate":"2003-07-14 00:00:00","equipId":"402881e44c7e36a2014c7e64ab38000c","equipLocCode":"402836814c72eddf014c731316b1000b","equipLocCodeName":"高碑店二分厂","equipMakeCode":"","equipMakeCountry":"瑞典","equipMaker":"瑞典","equipModel":"CP3127","equipName":"07#二期剩余污泥泵","equipOwnDept":"CZWS0825","equipOwnDeptName":"高碑店二分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"180MT","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","filingDate":"2015-04-03 16:27:48","isFiling":1,"overhaulCycle":13140,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"equipCode":"00000362","equipId":"402881e6414a68e301414b17067b0001","equipMakeCountry":"中国","equipMaker":"上海熊猫","equipModel":"FLGR80-200","equipName":"3#采暖循环泵","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"}],"total":136}
     */

    private DataEntity data;
    /**
     * data : {"EqEquipInfo":{"rows":[{"abcType":1,"asCode":"3301080051","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000269","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c796010f10027","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"15＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080050","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000270","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c79615e610028","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"14＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080048","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000272","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c7964c3c3002a","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"12＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080046","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000274","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c796793fa002c","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"10＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080045","asDept":"CZWN0830","asValue":66023,"equipCharge":"","equipCode":"00000275","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c7968c3a0002d","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-09-21 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"9＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301080018","asDept":"CZWS0820","asValue":90761,"equipCharge":"","equipCode":"00000295","equipEnabledDate":"2002-01-01 00:00:00","equipEntryDate":"2003-07-15 00:00:00","equipId":"402881e44c797e4b014c79917980000a","equipLocCode":"402836814c72eddf014c7312ddb1000a","equipLocCodeName":"高碑店一分厂","equipMakeCode":"","equipMakeCountry":"瑞典","equipMaker":"飞力","equipModel":"CP3201","equipName":"一期剩余污泥泵","equipOwnDept":"CZWS0820","equipOwnDeptName":"高碑店一分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"180MT630","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":13140,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301080002","asDept":"CZWS0820","asValue":1632,"equipCharge":"","equipCode":"00000301","equipEnabledDate":"1993-12-01 00:00:00","equipEntryDate":"2003-07-15 00:00:00","equipId":"402881e44c797e4b014c7999c6fd0010","equipLocCode":"402836814c72eddf014c7312ddb1000a","equipLocCodeName":"高碑店一分厂","equipMakeCode":"","equipMakeCountry":"","equipMaker":"","equipModel":"AS75-2CB","equipName":"2#潜污泵","equipOwnDept":"CZWS0820","equipOwnDeptName":"高碑店一分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301050015","asDept":"CZWN0830","asValue":15400,"equipCharge":"","equipCode":"00000311","equipEnabledDate":"2007-06-08 00:00:00","equipEntryDate":"2007-06-08 00:00:00","equipId":"402881e44c797e4b014c79af6172001a","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"丹麦","equipMaker":"格兰富","equipModel":"CRN1-17 Q=1~2m3/h","equipName":"1#加湿泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080024","asValue":49364,"equipCharge":"","equipCode":"1428049573000","equipEnabledDate":"1999-08-31 00:00:00","equipEntryDate":"2003-07-14 00:00:00","equipId":"402881e44c7e36a2014c7e64ab38000c","equipLocCode":"402836814c72eddf014c731316b1000b","equipLocCodeName":"高碑店二分厂","equipMakeCode":"","equipMakeCountry":"瑞典","equipMaker":"瑞典","equipModel":"CP3127","equipName":"07#二期剩余污泥泵","equipOwnDept":"CZWS0825","equipOwnDeptName":"高碑店二分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"180MT","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","filingDate":"2015-04-03 16:27:48","isFiling":1,"overhaulCycle":13140,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"equipCode":"00000362","equipId":"402881e6414a68e301414b17067b0001","equipMakeCountry":"中国","equipMaker":"上海熊猫","equipModel":"FLGR80-200","equipName":"3#采暖循环泵","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"}],"total":136}}
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
         * rows : [{"abcType":1,"asCode":"3301080051","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000269","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c796010f10027","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"15＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080050","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000270","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c79615e610028","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"14＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080048","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000272","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c7964c3c3002a","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"12＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080046","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000274","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c796793fa002c","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"10＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080045","asDept":"CZWN0830","asValue":66023,"equipCharge":"","equipCode":"00000275","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c7968c3a0002d","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-09-21 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"9＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301080018","asDept":"CZWS0820","asValue":90761,"equipCharge":"","equipCode":"00000295","equipEnabledDate":"2002-01-01 00:00:00","equipEntryDate":"2003-07-15 00:00:00","equipId":"402881e44c797e4b014c79917980000a","equipLocCode":"402836814c72eddf014c7312ddb1000a","equipLocCodeName":"高碑店一分厂","equipMakeCode":"","equipMakeCountry":"瑞典","equipMaker":"飞力","equipModel":"CP3201","equipName":"一期剩余污泥泵","equipOwnDept":"CZWS0820","equipOwnDeptName":"高碑店一分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"180MT630","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":13140,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301080002","asDept":"CZWS0820","asValue":1632,"equipCharge":"","equipCode":"00000301","equipEnabledDate":"1993-12-01 00:00:00","equipEntryDate":"2003-07-15 00:00:00","equipId":"402881e44c797e4b014c7999c6fd0010","equipLocCode":"402836814c72eddf014c7312ddb1000a","equipLocCodeName":"高碑店一分厂","equipMakeCode":"","equipMakeCountry":"","equipMaker":"","equipModel":"AS75-2CB","equipName":"2#潜污泵","equipOwnDept":"CZWS0820","equipOwnDeptName":"高碑店一分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":1,"asCode":"3301050015","asDept":"CZWN0830","asValue":15400,"equipCharge":"","equipCode":"00000311","equipEnabledDate":"2007-06-08 00:00:00","equipEntryDate":"2007-06-08 00:00:00","equipId":"402881e44c797e4b014c79af6172001a","equipLocCode":"402836814c72eddf014c73139362000c","equipLocCodeName":"高碑店污泥","equipMakeCode":"","equipMakeCountry":"丹麦","equipMaker":"格兰富","equipModel":"CRN1-17 Q=1~2m3/h","equipName":"1#加湿泵","equipOwnDept":"CZWN0830","equipOwnDeptName":"高碑店污泥","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"abcType":3,"asCode":"3301080024","asValue":49364,"equipCharge":"","equipCode":"1428049573000","equipEnabledDate":"1999-08-31 00:00:00","equipEntryDate":"2003-07-14 00:00:00","equipId":"402881e44c7e36a2014c7e64ab38000c","equipLocCode":"402836814c72eddf014c731316b1000b","equipLocCodeName":"高碑店二分厂","equipMakeCode":"","equipMakeCountry":"瑞典","equipMaker":"瑞典","equipModel":"CP3127","equipName":"07#二期剩余污泥泵","equipOwnDept":"CZWS0825","equipOwnDeptName":"高碑店二分厂","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"180MT","equipTecStatus":1,"equipTecStatusName":"完好运行","equipUseStatus":1,"equipUseStatusName":"运行","filingDate":"2015-04-03 16:27:48","isFiling":1,"overhaulCycle":13140,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"},{"equipCode":"00000362","equipId":"402881e6414a68e301414b17067b0001","equipMakeCountry":"中国","equipMaker":"上海熊猫","equipModel":"FLGR80-200","equipName":"3#采暖循环泵","typeCode":"402836814c6e7f2a014c6eb199260014","typeName":"水泵"}]
         * total : 136
         */

        private EqEquipInfoEntity EqEquipInfo;

        public void setEqEquipInfo(EqEquipInfoEntity EqEquipInfo) {
            this.EqEquipInfo = EqEquipInfo;
        }

        public EqEquipInfoEntity getEqEquipInfo() {
            return EqEquipInfo;
        }

        public static class EqEquipInfoEntity {
            private int total;
            /**
             * abcType : 1
             * asCode : 3301080051
             * asDept : CZWN0830
             * asValue : 61581
             * equipCharge :
             * equipCode : 00000269
             * equipEnabledDate : 2004-12-30 00:00:00
             * equipEntryDate : 2004-12-30 00:00:00
             * equipId : 402881e44c790cb8014c796010f10027
             * equipLocCode : 402836814c72eddf014c73139362000c
             * equipLocCodeName : 高碑店污泥
             * equipMakeCode :
             * equipMakeCountry : 中国
             * equipMakedate : 2004-11-15 00:00:00
             * equipMaker : 飞力
             * equipModel :
             * equipName : 15＃消化池排泥泵
             * equipOwnDept : CZWN0830
             * equipOwnDeptName : 高碑店污泥
             * equipOwnStruct : 402881ed4090aa2e014090bbab810002
             * equipOwnStructName : 进水泵房
             * equipStandard :
             * equipTecStatus : 1
             * equipTecStatusName : 完好运行
             * equipUseStatus : 1
             * equipUseStatusName : 运行
             * isFiling : 0
             * overhaulCycle : 0
             * pdCode :
             * remark :
             * sbxzCode : 1
             * typeCode : 402836814c6e7f2a014c6eb199260014
             * typeName : 水泵
             */

            private List<RowsEntity> rows;

            public void setTotal(int total) {
                this.total = total;
            }

            public void setRows(List<RowsEntity> rows) {
                this.rows = rows;
            }

            public int getTotal() {
                return total;
            }

            public List<RowsEntity> getRows() {
                return rows;
            }

            public static class RowsEntity {
                private int abcType;
                private String asCode;
                private String asDept;
                private int asValue;
                private String equipCharge;
                private String equipCode;
                private String equipEnabledDate;
                private String equipEntryDate;
                private String equipId;
                private String equipLocCode;
                private String equipLocCodeName;
                private String equipMakeCode;
                private String equipMakeCountry;
                private String equipMakedate;
                private String equipMaker;
                private String equipModel;
                private String equipName;
                private String equipOwnDept;
                private String equipOwnDeptName;
                private String equipOwnStruct;
                private String equipOwnStructName;
                private String equipStandard;
                private int equipTecStatus;
                private String equipTecStatusName;
                private int equipUseStatus;
                private String equipUseStatusName;
                private String isFiling;
                private int overhaulCycle;
                private String pdCode;
                private String remark;
                private String sbxzCode;
                private String typeCode;
                private String typeName;

                public void setAbcType(int abcType) {
                    this.abcType = abcType;
                }

                public void setAsCode(String asCode) {
                    this.asCode = asCode;
                }

                public void setAsDept(String asDept) {
                    this.asDept = asDept;
                }

                public void setAsValue(int asValue) {
                    this.asValue = asValue;
                }

                public void setEquipCharge(String equipCharge) {
                    this.equipCharge = equipCharge;
                }

                public void setEquipCode(String equipCode) {
                    this.equipCode = equipCode;
                }

                public void setEquipEnabledDate(String equipEnabledDate) {
                    this.equipEnabledDate = equipEnabledDate;
                }

                public void setEquipEntryDate(String equipEntryDate) {
                    this.equipEntryDate = equipEntryDate;
                }

                public void setEquipId(String equipId) {
                    this.equipId = equipId;
                }

                public void setEquipLocCode(String equipLocCode) {
                    this.equipLocCode = equipLocCode;
                }

                public void setEquipLocCodeName(String equipLocCodeName) {
                    this.equipLocCodeName = equipLocCodeName;
                }

                public void setEquipMakeCode(String equipMakeCode) {
                    this.equipMakeCode = equipMakeCode;
                }

                public void setEquipMakeCountry(String equipMakeCountry) {
                    this.equipMakeCountry = equipMakeCountry;
                }

                public void setEquipMakedate(String equipMakedate) {
                    this.equipMakedate = equipMakedate;
                }

                public void setEquipMaker(String equipMaker) {
                    this.equipMaker = equipMaker;
                }

                public void setEquipModel(String equipModel) {
                    this.equipModel = equipModel;
                }

                public void setEquipName(String equipName) {
                    this.equipName = equipName;
                }

                public void setEquipOwnDept(String equipOwnDept) {
                    this.equipOwnDept = equipOwnDept;
                }

                public void setEquipOwnDeptName(String equipOwnDeptName) {
                    this.equipOwnDeptName = equipOwnDeptName;
                }

                public void setEquipOwnStruct(String equipOwnStruct) {
                    this.equipOwnStruct = equipOwnStruct;
                }

                public void setEquipOwnStructName(String equipOwnStructName) {
                    this.equipOwnStructName = equipOwnStructName;
                }

                public void setEquipStandard(String equipStandard) {
                    this.equipStandard = equipStandard;
                }

                public void setEquipTecStatus(int equipTecStatus) {
                    this.equipTecStatus = equipTecStatus;
                }

                public void setEquipTecStatusName(String equipTecStatusName) {
                    this.equipTecStatusName = equipTecStatusName;
                }

                public void setEquipUseStatus(int equipUseStatus) {
                    this.equipUseStatus = equipUseStatus;
                }

                public void setEquipUseStatusName(String equipUseStatusName) {
                    this.equipUseStatusName = equipUseStatusName;
                }

                public void setIsFiling(String isFiling) {
                    this.isFiling = isFiling;
                }

                public void setOverhaulCycle(int overhaulCycle) {
                    this.overhaulCycle = overhaulCycle;
                }

                public void setPdCode(String pdCode) {
                    this.pdCode = pdCode;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public void setSbxzCode(String sbxzCode) {
                    this.sbxzCode = sbxzCode;
                }

                public void setTypeCode(String typeCode) {
                    this.typeCode = typeCode;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public int getAbcType() {
                    return abcType;
                }

                public String getAsCode() {
                    return asCode;
                }

                public String getAsDept() {
                    return asDept;
                }

                public int getAsValue() {
                    return asValue;
                }

                public String getEquipCharge() {
                    return equipCharge;
                }

                public String getEquipCode() {
                    return equipCode;
                }

                public String getEquipEnabledDate() {
                    return equipEnabledDate;
                }

                public String getEquipEntryDate() {
                    return equipEntryDate;
                }

                public String getEquipId() {
                    return equipId;
                }

                public String getEquipLocCode() {
                    return equipLocCode;
                }

                public String getEquipLocCodeName() {
                    return equipLocCodeName;
                }

                public String getEquipMakeCode() {
                    return equipMakeCode;
                }

                public String getEquipMakeCountry() {
                    return equipMakeCountry;
                }

                public String getEquipMakedate() {
                    return equipMakedate;
                }

                public String getEquipMaker() {
                    return equipMaker;
                }

                public String getEquipModel() {
                    return equipModel;
                }

                public String getEquipName() {
                    return equipName;
                }

                public String getEquipOwnDept() {
                    return equipOwnDept;
                }

                public String getEquipOwnDeptName() {
                    return equipOwnDeptName;
                }

                public String getEquipOwnStruct() {
                    return equipOwnStruct;
                }

                public String getEquipOwnStructName() {
                    return equipOwnStructName;
                }

                public String getEquipStandard() {
                    return equipStandard;
                }

                public int getEquipTecStatus() {
                    return equipTecStatus;
                }

                public String getEquipTecStatusName() {
                    return equipTecStatusName;
                }

                public int getEquipUseStatus() {
                    return equipUseStatus;
                }

                public String getEquipUseStatusName() {
                    return equipUseStatusName;
                }

                public String getIsFiling() {
                    return isFiling;
                }

                public int getOverhaulCycle() {
                    return overhaulCycle;
                }

                public String getPdCode() {
                    return pdCode;
                }

                public String getRemark() {
                    return remark;
                }

                public String getSbxzCode() {
                    return sbxzCode;
                }

                public String getTypeCode() {
                    return typeCode;
                }

                public String getTypeName() {
                    return typeName;
                }
            }
        }
    }
}
