package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/17 0017.
 */
public class TrajectoryResponse extends RBResponse {
    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"groupInfos":[{"groupId":"40288acf554eabda01554ec192b20000","unitId":"临时运输单位","groupName":"132","groupIntro":"123","groupBak":"123","groupGrade":"1","groupBlock":"西城区","updateDate":1465959156000,"opperUser":null,"delFlag":null},{"groupId":"8a92e48152a143140152a4aa0e200027","unitId":"临时运输单位","groupName":"临时运输车组","groupIntro":null,"groupBak":null,"groupGrade":"1","groupBlock":"丰台区","updateDate":1464881032000,"opperUser":null,"delFlag":"0"}],"lngOffset":"0.01277149072","vehicleInfosMap":[{"vehicleId":"40288082551020b701551029ef6c0003","vehicleGpsId":"0","vehicleNo":"冀R90620","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":" ","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102a219d0004","vehicleGpsId":null,"vehicleNo":"冀FF6682","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"30950","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":null,"cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102a5bda0005","vehicleGpsId":"EN656577","vehicleNo":"冀R72371","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201313466","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102b96720007","vehicleGpsId":"EN656591","vehicleNo":"冀R79399","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"30120","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201318345","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102cde8e0008","vehicleGpsId":"DN647643","vehicleNo":"京AS8568","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324851","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102d09510009","vehicleGpsId":"DN647651","vehicleNo":"京AS8561","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324754","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102d3e16000a","vehicleGpsId":"DN647642","vehicleNo":"冀HK6630","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314458","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102d800a000b","vehicleGpsId":"DN647647","vehicleNo":"冀R57908","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201312954","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551031bbe4000d","vehicleGpsId":"DN647644","vehicleNo":"冀FC4612","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314431","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155103238c5000f","vehicleGpsId":"DN647654","vehicleNo":"冀FH6462","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"38300","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314546","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551032677e0010","vehicleGpsId":"DN647648","vehicleNo":"冀FG8319","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"38300","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314560","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551032bd930012","vehicleGpsId":"DN647649","vehicleNo":"冀BQ6957","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"38300","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311425","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551032e7080013","vehicleGpsId":"DN647645","vehicleNo":"冀HM3020","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"40000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311214","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510331ba40014","vehicleGpsId":"EN656573","vehicleNo":"冀HG2112","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324920","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155103365a40015","vehicleGpsId":"EN656582","vehicleNo":"京G50574","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201309274","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155103391cf0016","vehicleGpsId":"EN656584","vehicleNo":"京AN8515","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314397","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551033ec150018","vehicleGpsId":"EN656585","vehicleNo":"冀DZ6303","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18291324912","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551055696c0019","vehicleGpsId":"DN647661","vehicleNo":"京AW3692","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201309490","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155105bd84e001a","vehicleGpsId":"DN647638","vehicleNo":"冀AU1519","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311349","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155107eb6cd001b","vehicleGpsId":"DN647659","vehicleNo":"京AJ7508","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311940","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155107f6107001c","vehicleGpsId":"DN647653","vehicleNo":"京AAH792","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201309742","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155109d778f001d","vehicleGpsId":"EN656559","vehicleNo":"冀HM5587","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311349","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510fa5947001e","vehicleGpsId":"DN647660","vehicleNo":"京AG1680","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324527","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510fb6267001f","vehicleGpsId":"EN656576","vehicleNo":"京AG1132","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324571","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510fe46c00020","vehicleGpsId":"DN647665","vehicleNo":"京AH9896","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201313488","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510ff2ace0021","vehicleGpsId":"EN656583","vehicleNo":"京AG1009","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314173","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511323c330022","vehicleGpsId":"EN656574","vehicleNo":"冀EJ6802","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314217","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551132b66d0023","vehicleGpsId":"DN647639","vehicleNo":"京G83179","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314146","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511331a730024","vehicleGpsId":"DN647658","vehicleNo":"京AG1137","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201327423","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551133b3d40025","vehicleGpsId":"DN647656","vehicleNo":"冀HK4461","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201327420","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511346bff0026","vehicleGpsId":"DN647650","vehicleNo":"京AG1135","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201326004","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551134d54f0027","vehicleGpsId":"DN647640","vehicleNo":"京AL2876","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325849","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511354bf10028","vehicleGpsId":"EN656578","vehicleNo":"京G77319","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325848","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551177594f0029","vehicleGpsId":"EN656560","vehicleNo":"京AHH582","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324572","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511788a14002a","vehicleGpsId":"DN647663","vehicleNo":"京AQ1156","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314328","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511793c96002b","vehicleGpsId":"EN656581","vehicleNo":"京AG3876","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324712","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511924a45002c","vehicleGpsId":"DN647646","vehicleNo":"冀G61116","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324387","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155161a02bc02be","vehicleGpsId":"EN656588","vehicleNo":"冀HM7209","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201318843","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551620561502c0","vehicleGpsId":"DN647655","vehicleNo":"冀HE8172","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325437","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551632f95102c1","vehicleGpsId":"DN647668","vehicleNo":"京AAL600","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201317479","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155164991b102c2","vehicleGpsId":"DN647657","vehicleNo":"京AK4243","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325340","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155164b010402c3","vehicleGpsId":"EN656565","vehicleNo":"京AG1008","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324917","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155164d81f802c4","vehicleGpsId":"EN656566","vehicleNo":"京AU7565","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319624","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551651e65002c5","vehicleGpsId":"EN656592","vehicleNo":"京AU7533","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201320846","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551654c06602c6","vehicleGpsId":"EN656586","vehicleNo":"冀BR7075","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201320054","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155165628fc02c7","vehicleGpsId":"EN656587","vehicleNo":"京AU0288","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201320749","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155165768d702c8","vehicleGpsId":"DN647667","vehicleNo":"京G86309","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319224","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015516609cf402c9","vehicleGpsId":"DN647662","vehicleNo":"京AT0681","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314092","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551661da2b02ca","vehicleGpsId":"EN656575","vehicleNo":"京AAD157","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324945","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155166336ad02cb","vehicleGpsId":"EN656569","vehicleNo":"京AG1006","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324651","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551665d1a002cc","vehicleGpsId":"EN656595","vehicleNo":"京AL2867","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319524","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155167a37b902cd","vehicleGpsId":"DN647641","vehicleNo":"京AD9700","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325348","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155169d4f1b02ce","vehicleGpsId":"DN647666","vehicleNo":"京AAH796","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319284","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015516da7d9b02cf","vehicleGpsId":"EN656579","vehicleNo":"京AF8294","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324864","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"}],"palings":[{"palingId":"402880845510a101015511c48c840000","palingName":null,"mudId":"40288082550f3d6601550fbf6042001e","placeName":"安次区码头镇（朱官屯）","palingCode":null,"point":"116.72182:39.354208,116.725486:39.340146,116.746326:39.340481,116.738206:39.357556","priorGrade":null,"limitSpeed":"60","longStay":null,"shortStay":null,"updateDate":1464907141000,"opperUser":"136316217525616458547","delFlag":"0"},{"palingId":"402880845510a101015511cd88190001","palingName":null,"mudId":"8a92e481533fb5d701537d51e32900b6","placeName":"永清县别古庄镇刘庄村（朱官屯西）","palingCode":null,"point":"116.675863:39.33797,116.67766:39.326361,116.687865:39.323626,116.688152:39.325077,116.691673:39.3253,116.693254:39.324798,116.704465:39.325356,116.696632:39.337244,116.695554:39.337467","priorGrade":null,"limitSpeed":"60","longStay":null,"shortStay":null,"updateDate":1464907730000,"opperUser":"136316217525616458547","delFlag":"0"},{"palingId":"402880e4552ee91101552ef11f570001","palingName":null,"mudId":"40288082551020b7015511b1f615002d","placeName":"葛渔城下官村","palingCode":null,"point":"116.435297:39.894396,116.437381:39.896943,116.446616:39.894258,116.443669:39.889635,116.443777:39.888694,116.443777:39.888694","priorGrade":null,"limitSpeed":"111","longStay":null,"shortStay":null,"updateDate":1465425745000,"opperUser":"135400151155036223240","delFlag":"0"},{"palingId":"402880e4552ee91101552ef9899d0003","palingName":null,"mudId":"402880e4552ee91101552ef9141b0002","placeName":"1","palingCode":null,"point":"116.447451:39.89551,116.448529:39.897559,116.450326:39.89677,116.450272:39.895441,116.450272:39.895441","priorGrade":null,"limitSpeed":"12","longStay":null,"shortStay":null,"updateDate":1465425964000,"opperUser":"135400151155036223240","delFlag":"0"},{"palingId":"ff808081559a046f0155a04af6df0013","palingName":null,"mudId":"402880e455498cdc015549a536df0000","placeName":"4 54他","palingCode":null,"point":"116.441513:39.898783,116.44137:39.899171,116.44137:39.899171","priorGrade":null,"limitSpeed":"123","longStay":null,"shortStay":null,"updateDate":1467273115000,"opperUser":"1","delFlag":"0"}],"latOffset":"0.007288486844","vehicleTypes":[{"vehicleTypeId":"223","typeName":"卡车","commonState":"/static/images/vehicle/v1_e.png","east":"/static/images/vehicle/v1_e.png","west":"/static/images/vehicle/v1_w.png","northEast":"/static/images/vehicle/v1_ne.png","northWest":"/static/images/vehicle/v1_nw.png","stopState":"/static/images/vehicle/v1_e.png","south":"/static/images/vehicle/v1_s.png","north":"/static/images/vehicle/v1_n.png","southEast":"/static/images/vehicle/v1_se.png","southWest":"/static/images/vehicle/v1_sw.png","icoWidth":"53","icoHeight":"40","updateDate":1353312000000,"opperUser":"admin","delFlag":"0"}]}
     */
    private String errorCode;
    private String errorMsg;
    /**
     * groupInfos : [{"groupId":"40288acf554eabda01554ec192b20000","unitId":"临时运输单位","groupName":"132","groupIntro":"123","groupBak":"123","groupGrade":"1","groupBlock":"西城区","updateDate":1465959156000,"opperUser":null,"delFlag":null},{"groupId":"8a92e48152a143140152a4aa0e200027","unitId":"临时运输单位","groupName":"临时运输车组","groupIntro":null,"groupBak":null,"groupGrade":"1","groupBlock":"丰台区","updateDate":1464881032000,"opperUser":null,"delFlag":"0"}]
     * lngOffset : 0.01277149072
     * vehicleInfosMap : [{"vehicleId":"40288082551020b701551029ef6c0003","vehicleGpsId":"0","vehicleNo":"冀R90620","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":" ","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102a219d0004","vehicleGpsId":null,"vehicleNo":"冀FF6682","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"30950","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":null,"cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102a5bda0005","vehicleGpsId":"EN656577","vehicleNo":"冀R72371","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201313466","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102b96720007","vehicleGpsId":"EN656591","vehicleNo":"冀R79399","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"30120","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201318345","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102cde8e0008","vehicleGpsId":"DN647643","vehicleNo":"京AS8568","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324851","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102d09510009","vehicleGpsId":"DN647651","vehicleNo":"京AS8561","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324754","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102d3e16000a","vehicleGpsId":"DN647642","vehicleNo":"冀HK6630","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314458","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155102d800a000b","vehicleGpsId":"DN647647","vehicleNo":"冀R57908","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201312954","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551031bbe4000d","vehicleGpsId":"DN647644","vehicleNo":"冀FC4612","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314431","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155103238c5000f","vehicleGpsId":"DN647654","vehicleNo":"冀FH6462","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"38300","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314546","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551032677e0010","vehicleGpsId":"DN647648","vehicleNo":"冀FG8319","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"38300","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314560","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551032bd930012","vehicleGpsId":"DN647649","vehicleNo":"冀BQ6957","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"38300","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311425","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551032e7080013","vehicleGpsId":"DN647645","vehicleNo":"冀HM3020","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"40000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311214","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510331ba40014","vehicleGpsId":"EN656573","vehicleNo":"冀HG2112","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324920","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155103365a40015","vehicleGpsId":"EN656582","vehicleNo":"京G50574","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201309274","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155103391cf0016","vehicleGpsId":"EN656584","vehicleNo":"京AN8515","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314397","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551033ec150018","vehicleGpsId":"EN656585","vehicleNo":"冀DZ6303","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"31000","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18291324912","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551055696c0019","vehicleGpsId":"DN647661","vehicleNo":"京AW3692","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201309490","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155105bd84e001a","vehicleGpsId":"DN647638","vehicleNo":"冀AU1519","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311349","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155107eb6cd001b","vehicleGpsId":"DN647659","vehicleNo":"京AJ7508","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311940","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155107f6107001c","vehicleGpsId":"DN647653","vehicleNo":"京AAH792","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201309742","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155109d778f001d","vehicleGpsId":"EN656559","vehicleNo":"冀HM5587","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201311349","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510fa5947001e","vehicleGpsId":"DN647660","vehicleNo":"京AG1680","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324527","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510fb6267001f","vehicleGpsId":"EN656576","vehicleNo":"京AG1132","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324571","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510fe46c00020","vehicleGpsId":"DN647665","vehicleNo":"京AH9896","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201313488","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015510ff2ace0021","vehicleGpsId":"EN656583","vehicleNo":"京AG1009","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314173","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511323c330022","vehicleGpsId":"EN656574","vehicleNo":"冀EJ6802","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314217","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551132b66d0023","vehicleGpsId":"DN647639","vehicleNo":"京G83179","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314146","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511331a730024","vehicleGpsId":"DN647658","vehicleNo":"京AG1137","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201327423","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551133b3d40025","vehicleGpsId":"DN647656","vehicleNo":"冀HK4461","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201327420","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511346bff0026","vehicleGpsId":"DN647650","vehicleNo":"京AG1135","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201326004","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551134d54f0027","vehicleGpsId":"DN647640","vehicleNo":"京AL2876","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325849","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511354bf10028","vehicleGpsId":"EN656578","vehicleNo":"京G77319","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325848","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551177594f0029","vehicleGpsId":"EN656560","vehicleNo":"京AHH582","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324572","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511788a14002a","vehicleGpsId":"DN647663","vehicleNo":"京AQ1156","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314328","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511793c96002b","vehicleGpsId":"EN656581","vehicleNo":"京AG3876","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324712","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015511924a45002c","vehicleGpsId":"DN647646","vehicleNo":"冀G61116","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324387","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155161a02bc02be","vehicleGpsId":"EN656588","vehicleNo":"冀HM7209","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201318843","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551620561502c0","vehicleGpsId":"DN647655","vehicleNo":"冀HE8172","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325437","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551632f95102c1","vehicleGpsId":"DN647668","vehicleNo":"京AAL600","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201317479","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155164991b102c2","vehicleGpsId":"DN647657","vehicleNo":"京AK4243","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325340","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155164b010402c3","vehicleGpsId":"EN656565","vehicleNo":"京AG1008","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324917","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155164d81f802c4","vehicleGpsId":"EN656566","vehicleNo":"京AU7565","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319624","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551651e65002c5","vehicleGpsId":"EN656592","vehicleNo":"京AU7533","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201320846","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551654c06602c6","vehicleGpsId":"EN656586","vehicleNo":"冀BR7075","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201320054","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155165628fc02c7","vehicleGpsId":"EN656587","vehicleNo":"京AU0288","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201320749","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155165768d702c8","vehicleGpsId":"DN647667","vehicleNo":"京G86309","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319224","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015516609cf402c9","vehicleGpsId":"DN647662","vehicleNo":"京AT0681","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201314092","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551661da2b02ca","vehicleGpsId":"EN656575","vehicleNo":"京AAD157","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324945","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155166336ad02cb","vehicleGpsId":"EN656569","vehicleNo":"京AG1006","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324651","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b701551665d1a002cc","vehicleGpsId":"EN656595","vehicleNo":"京AL2867","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319524","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155167a37b902cd","vehicleGpsId":"DN647641","vehicleNo":"京AD9700","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201325348","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b70155169d4f1b02ce","vehicleGpsId":"DN647666","vehicleNo":"京AAH796","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201319284","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"},{"vehicleId":"40288082551020b7015516da7d9b02cf","vehicleGpsId":"EN656579","vehicleNo":"京AF8294","vehicleType":"223","vehiclePattem":null,"partentUnit":"临时运输单位","biaoZhong":"0","measurement":null,"driverId":null,"videoFlag":null,"recorFlag":null,"vehicleVin":null,"vehicleTzxs":null,"vehicleCjds":null,"vehicleState":null,"limitspeed":null,"recordCode":null,"groupId":"8a92e48152a143140152a4aa0e200027","vehicleLine":null,"licenseTypeId":null,"overtimeSpan":null,"pinpai":null,"chuDate":null,"shangDate":null,"oilType":null,"enginType":null,"changjia":null,"totalMail":null,"repairNum":null,"haoOil":null,"insurerType":null,"insurerLimit":null,"vehicleVoid":null,"vehicleBuymode":null,"vehicleBuydate":null,"vehicleServicetime":null,"serviceBank":null,"serviceInsurer":null,"gpsInstalldate":null,"simNo":"18201324864","cmd11":null,"cmd12":null,"cmd13":null,"alarmFlag":null,"oilparamconfigid":"0.000000000000000000000000000000","oilparamconfigid2":"0.000000000000000000000000000000","linealarmFlag":0,"datmaintain":null,"datverify":null,"datservefee":null,"datinsur":null,"datrun":null,"updateDate":null,"opperUser":null,"delFlag":"0","stat":"1"}]
     * palings : [{"palingId":"402880845510a101015511c48c840000","palingName":null,"mudId":"40288082550f3d6601550fbf6042001e","placeName":"安次区码头镇（朱官屯）","palingCode":null,"point":"116.72182:39.354208,116.725486:39.340146,116.746326:39.340481,116.738206:39.357556","priorGrade":null,"limitSpeed":"60","longStay":null,"shortStay":null,"updateDate":1464907141000,"opperUser":"136316217525616458547","delFlag":"0"},{"palingId":"402880845510a101015511cd88190001","palingName":null,"mudId":"8a92e481533fb5d701537d51e32900b6","placeName":"永清县别古庄镇刘庄村（朱官屯西）","palingCode":null,"point":"116.675863:39.33797,116.67766:39.326361,116.687865:39.323626,116.688152:39.325077,116.691673:39.3253,116.693254:39.324798,116.704465:39.325356,116.696632:39.337244,116.695554:39.337467","priorGrade":null,"limitSpeed":"60","longStay":null,"shortStay":null,"updateDate":1464907730000,"opperUser":"136316217525616458547","delFlag":"0"},{"palingId":"402880e4552ee91101552ef11f570001","palingName":null,"mudId":"40288082551020b7015511b1f615002d","placeName":"葛渔城下官村","palingCode":null,"point":"116.435297:39.894396,116.437381:39.896943,116.446616:39.894258,116.443669:39.889635,116.443777:39.888694,116.443777:39.888694","priorGrade":null,"limitSpeed":"111","longStay":null,"shortStay":null,"updateDate":1465425745000,"opperUser":"135400151155036223240","delFlag":"0"},{"palingId":"402880e4552ee91101552ef9899d0003","palingName":null,"mudId":"402880e4552ee91101552ef9141b0002","placeName":"1","palingCode":null,"point":"116.447451:39.89551,116.448529:39.897559,116.450326:39.89677,116.450272:39.895441,116.450272:39.895441","priorGrade":null,"limitSpeed":"12","longStay":null,"shortStay":null,"updateDate":1465425964000,"opperUser":"135400151155036223240","delFlag":"0"},{"palingId":"ff808081559a046f0155a04af6df0013","palingName":null,"mudId":"402880e455498cdc015549a536df0000","placeName":"4 54他","palingCode":null,"point":"116.441513:39.898783,116.44137:39.899171,116.44137:39.899171","priorGrade":null,"limitSpeed":"123","longStay":null,"shortStay":null,"updateDate":1467273115000,"opperUser":"1","delFlag":"0"}]
     * latOffset : 0.007288486844
     * vehicleTypes : [{"vehicleTypeId":"223","typeName":"卡车","commonState":"/static/images/vehicle/v1_e.png","east":"/static/images/vehicle/v1_e.png","west":"/static/images/vehicle/v1_w.png","northEast":"/static/images/vehicle/v1_ne.png","northWest":"/static/images/vehicle/v1_nw.png","stopState":"/static/images/vehicle/v1_e.png","south":"/static/images/vehicle/v1_s.png","north":"/static/images/vehicle/v1_n.png","southEast":"/static/images/vehicle/v1_se.png","southWest":"/static/images/vehicle/v1_sw.png","icoWidth":"53","icoHeight":"40","updateDate":1353312000000,"opperUser":"admin","delFlag":"0"}]
     */

    private DataEntity data;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        private String lngOffset;
        private String latOffset;
        /**
         * groupId : 40288acf554eabda01554ec192b20000
         * unitId : 临时运输单位
         * groupName : 132
         * groupIntro : 123
         * groupBak : 123
         * groupGrade : 1
         * groupBlock : 西城区
         * updateDate : 1465959156000
         * opperUser : null
         * delFlag : null
         */

        private List<GroupInfosEntity> groupInfos;
        /**
         * vehicleId : 40288082551020b701551029ef6c0003
         * vehicleGpsId : 0
         * vehicleNo : 冀R90620
         * vehicleType : 223
         * vehiclePattem : null
         * partentUnit : 临时运输单位
         * biaoZhong : 31000
         * measurement : null
         * driverId : null
         * videoFlag : null
         * recorFlag : null
         * vehicleVin : null
         * vehicleTzxs : null
         * vehicleCjds : null
         * vehicleState : null
         * limitspeed : null
         * recordCode : null
         * groupId : 8a92e48152a143140152a4aa0e200027
         * vehicleLine : null
         * licenseTypeId : null
         * overtimeSpan : null
         * pinpai : null
         * chuDate : null
         * shangDate : null
         * oilType : null
         * enginType : null
         * changjia : null
         * totalMail : null
         * repairNum : null
         * haoOil : null
         * insurerType : null
         * insurerLimit : null
         * vehicleVoid : null
         * vehicleBuymode : null
         * vehicleBuydate : null
         * vehicleServicetime : null
         * serviceBank : null
         * serviceInsurer : null
         * gpsInstalldate : null
         * simNo :
         * cmd11 : null
         * cmd12 : null
         * cmd13 : null
         * alarmFlag : null
         * oilparamconfigid : 0.000000000000000000000000000000
         * oilparamconfigid2 : 0.000000000000000000000000000000
         * linealarmFlag : 0
         * datmaintain : null
         * datverify : null
         * datservefee : null
         * datinsur : null
         * datrun : null
         * updateDate : null
         * opperUser : null
         * delFlag : 0
         * stat : 1
         */

        private List<VehicleInfosMapEntity> vehicleInfosMap;
        /**
         * palingId : 402880845510a101015511c48c840000
         * palingName : null
         * mudId : 40288082550f3d6601550fbf6042001e
         * placeName : 安次区码头镇（朱官屯）
         * palingCode : null
         * point : 116.72182:39.354208,116.725486:39.340146,116.746326:39.340481,116.738206:39.357556
         * priorGrade : null
         * limitSpeed : 60
         * longStay : null
         * shortStay : null
         * updateDate : 1464907141000
         * opperUser : 136316217525616458547
         * delFlag : 0
         */

        private List<PalingsEntity> palings;
        /**
         * vehicleTypeId : 223
         * typeName : 卡车
         * commonState : /static/images/vehicle/v1_e.png
         * east : /static/images/vehicle/v1_e.png
         * west : /static/images/vehicle/v1_w.png
         * northEast : /static/images/vehicle/v1_ne.png
         * northWest : /static/images/vehicle/v1_nw.png
         * stopState : /static/images/vehicle/v1_e.png
         * south : /static/images/vehicle/v1_s.png
         * north : /static/images/vehicle/v1_n.png
         * southEast : /static/images/vehicle/v1_se.png
         * southWest : /static/images/vehicle/v1_sw.png
         * icoWidth : 53
         * icoHeight : 40
         * updateDate : 1353312000000
         * opperUser : admin
         * delFlag : 0
         */

        private List<VehicleTypesEntity> vehicleTypes;

        public void setLngOffset(String lngOffset) {
            this.lngOffset = lngOffset;
        }

        public void setLatOffset(String latOffset) {
            this.latOffset = latOffset;
        }

        public void setGroupInfos(List<GroupInfosEntity> groupInfos) {
            this.groupInfos = groupInfos;
        }

        public void setVehicleInfosMap(List<VehicleInfosMapEntity> vehicleInfosMap) {
            this.vehicleInfosMap = vehicleInfosMap;
        }

        public void setPalings(List<PalingsEntity> palings) {
            this.palings = palings;
        }

        public void setVehicleTypes(List<VehicleTypesEntity> vehicleTypes) {
            this.vehicleTypes = vehicleTypes;
        }

        public String getLngOffset() {
            return lngOffset;
        }

        public String getLatOffset() {
            return latOffset;
        }

        public List<GroupInfosEntity> getGroupInfos() {
            return groupInfos;
        }

        public List<VehicleInfosMapEntity> getVehicleInfosMap() {
            return vehicleInfosMap;
        }

        public List<PalingsEntity> getPalings() {
            return palings;
        }

        public List<VehicleTypesEntity> getVehicleTypes() {
            return vehicleTypes;
        }

        public static class GroupInfosEntity {
            private String groupId;
            private String unitId;
            private String groupName;
            private String groupIntro;
            private String groupBak;
            private String groupGrade;
            private String groupBlock;
            private long updateDate;
            private Object opperUser;
            private Object delFlag;

            public void setGroupId(String groupId) {
                this.groupId = groupId;
            }

            public void setUnitId(String unitId) {
                this.unitId = unitId;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

            public void setGroupIntro(String groupIntro) {
                this.groupIntro = groupIntro;
            }

            public void setGroupBak(String groupBak) {
                this.groupBak = groupBak;
            }

            public void setGroupGrade(String groupGrade) {
                this.groupGrade = groupGrade;
            }

            public void setGroupBlock(String groupBlock) {
                this.groupBlock = groupBlock;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public void setOpperUser(Object opperUser) {
                this.opperUser = opperUser;
            }

            public void setDelFlag(Object delFlag) {
                this.delFlag = delFlag;
            }

            public String getGroupId() {
                return groupId;
            }

            public String getUnitId() {
                return unitId;
            }

            public String getGroupName() {
                return groupName;
            }

            public String getGroupIntro() {
                return groupIntro;
            }

            public String getGroupBak() {
                return groupBak;
            }

            public String getGroupGrade() {
                return groupGrade;
            }

            public String getGroupBlock() {
                return groupBlock;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public Object getOpperUser() {
                return opperUser;
            }

            public Object getDelFlag() {
                return delFlag;
            }
        }

        public static class VehicleInfosMapEntity {
            private String vehicleId;
            private String vehicleGpsId;
            private String vehicleNo;
            private String vehicleType;
            private Object vehiclePattem;
            private String partentUnit;
            private String biaoZhong;
            private Object measurement;
            private Object driverId;
            private Object videoFlag;
            private Object recorFlag;
            private Object vehicleVin;
            private Object vehicleTzxs;
            private Object vehicleCjds;
            private Object vehicleState;
            private Object limitspeed;
            private Object recordCode;
            private String groupId;
            private Object vehicleLine;
            private Object licenseTypeId;
            private Object overtimeSpan;
            private Object pinpai;
            private Object chuDate;
            private Object shangDate;
            private Object oilType;
            private Object enginType;
            private Object changjia;
            private Object totalMail;
            private Object repairNum;
            private Object haoOil;
            private Object insurerType;
            private Object insurerLimit;
            private Object vehicleVoid;
            private Object vehicleBuymode;
            private Object vehicleBuydate;
            private Object vehicleServicetime;
            private Object serviceBank;
            private Object serviceInsurer;
            private Object gpsInstalldate;
            private String simNo;
            private Object cmd11;
            private Object cmd12;
            private Object cmd13;
            private Object alarmFlag;
            private String oilparamconfigid;
            private String oilparamconfigid2;
            private int linealarmFlag;
            private Object datmaintain;
            private Object datverify;
            private Object datservefee;
            private Object datinsur;
            private Object datrun;
            private Object updateDate;
            private Object opperUser;
            private String delFlag;
            private String stat;

            public void setVehicleId(String vehicleId) {
                this.vehicleId = vehicleId;
            }

            public void setVehicleGpsId(String vehicleGpsId) {
                this.vehicleGpsId = vehicleGpsId;
            }

            public void setVehicleNo(String vehicleNo) {
                this.vehicleNo = vehicleNo;
            }

            public void setVehicleType(String vehicleType) {
                this.vehicleType = vehicleType;
            }

            public void setVehiclePattem(Object vehiclePattem) {
                this.vehiclePattem = vehiclePattem;
            }

            public void setPartentUnit(String partentUnit) {
                this.partentUnit = partentUnit;
            }

            public void setBiaoZhong(String biaoZhong) {
                this.biaoZhong = biaoZhong;
            }

            public void setMeasurement(Object measurement) {
                this.measurement = measurement;
            }

            public void setDriverId(Object driverId) {
                this.driverId = driverId;
            }

            public void setVideoFlag(Object videoFlag) {
                this.videoFlag = videoFlag;
            }

            public void setRecorFlag(Object recorFlag) {
                this.recorFlag = recorFlag;
            }

            public void setVehicleVin(Object vehicleVin) {
                this.vehicleVin = vehicleVin;
            }

            public void setVehicleTzxs(Object vehicleTzxs) {
                this.vehicleTzxs = vehicleTzxs;
            }

            public void setVehicleCjds(Object vehicleCjds) {
                this.vehicleCjds = vehicleCjds;
            }

            public void setVehicleState(Object vehicleState) {
                this.vehicleState = vehicleState;
            }

            public void setLimitspeed(Object limitspeed) {
                this.limitspeed = limitspeed;
            }

            public void setRecordCode(Object recordCode) {
                this.recordCode = recordCode;
            }

            public void setGroupId(String groupId) {
                this.groupId = groupId;
            }

            public void setVehicleLine(Object vehicleLine) {
                this.vehicleLine = vehicleLine;
            }

            public void setLicenseTypeId(Object licenseTypeId) {
                this.licenseTypeId = licenseTypeId;
            }

            public void setOvertimeSpan(Object overtimeSpan) {
                this.overtimeSpan = overtimeSpan;
            }

            public void setPinpai(Object pinpai) {
                this.pinpai = pinpai;
            }

            public void setChuDate(Object chuDate) {
                this.chuDate = chuDate;
            }

            public void setShangDate(Object shangDate) {
                this.shangDate = shangDate;
            }

            public void setOilType(Object oilType) {
                this.oilType = oilType;
            }

            public void setEnginType(Object enginType) {
                this.enginType = enginType;
            }

            public void setChangjia(Object changjia) {
                this.changjia = changjia;
            }

            public void setTotalMail(Object totalMail) {
                this.totalMail = totalMail;
            }

            public void setRepairNum(Object repairNum) {
                this.repairNum = repairNum;
            }

            public void setHaoOil(Object haoOil) {
                this.haoOil = haoOil;
            }

            public void setInsurerType(Object insurerType) {
                this.insurerType = insurerType;
            }

            public void setInsurerLimit(Object insurerLimit) {
                this.insurerLimit = insurerLimit;
            }

            public void setVehicleVoid(Object vehicleVoid) {
                this.vehicleVoid = vehicleVoid;
            }

            public void setVehicleBuymode(Object vehicleBuymode) {
                this.vehicleBuymode = vehicleBuymode;
            }

            public void setVehicleBuydate(Object vehicleBuydate) {
                this.vehicleBuydate = vehicleBuydate;
            }

            public void setVehicleServicetime(Object vehicleServicetime) {
                this.vehicleServicetime = vehicleServicetime;
            }

            public void setServiceBank(Object serviceBank) {
                this.serviceBank = serviceBank;
            }

            public void setServiceInsurer(Object serviceInsurer) {
                this.serviceInsurer = serviceInsurer;
            }

            public void setGpsInstalldate(Object gpsInstalldate) {
                this.gpsInstalldate = gpsInstalldate;
            }

            public void setSimNo(String simNo) {
                this.simNo = simNo;
            }

            public void setCmd11(Object cmd11) {
                this.cmd11 = cmd11;
            }

            public void setCmd12(Object cmd12) {
                this.cmd12 = cmd12;
            }

            public void setCmd13(Object cmd13) {
                this.cmd13 = cmd13;
            }

            public void setAlarmFlag(Object alarmFlag) {
                this.alarmFlag = alarmFlag;
            }

            public void setOilparamconfigid(String oilparamconfigid) {
                this.oilparamconfigid = oilparamconfigid;
            }

            public void setOilparamconfigid2(String oilparamconfigid2) {
                this.oilparamconfigid2 = oilparamconfigid2;
            }

            public void setLinealarmFlag(int linealarmFlag) {
                this.linealarmFlag = linealarmFlag;
            }

            public void setDatmaintain(Object datmaintain) {
                this.datmaintain = datmaintain;
            }

            public void setDatverify(Object datverify) {
                this.datverify = datverify;
            }

            public void setDatservefee(Object datservefee) {
                this.datservefee = datservefee;
            }

            public void setDatinsur(Object datinsur) {
                this.datinsur = datinsur;
            }

            public void setDatrun(Object datrun) {
                this.datrun = datrun;
            }

            public void setUpdateDate(Object updateDate) {
                this.updateDate = updateDate;
            }

            public void setOpperUser(Object opperUser) {
                this.opperUser = opperUser;
            }

            public void setDelFlag(String delFlag) {
                this.delFlag = delFlag;
            }

            public void setStat(String stat) {
                this.stat = stat;
            }

            public String getVehicleId() {
                return vehicleId;
            }

            public String getVehicleGpsId() {
                return vehicleGpsId;
            }

            public String getVehicleNo() {
                return vehicleNo;
            }

            public String getVehicleType() {
                return vehicleType;
            }

            public Object getVehiclePattem() {
                return vehiclePattem;
            }

            public String getPartentUnit() {
                return partentUnit;
            }

            public String getBiaoZhong() {
                return biaoZhong;
            }

            public Object getMeasurement() {
                return measurement;
            }

            public Object getDriverId() {
                return driverId;
            }

            public Object getVideoFlag() {
                return videoFlag;
            }

            public Object getRecorFlag() {
                return recorFlag;
            }

            public Object getVehicleVin() {
                return vehicleVin;
            }

            public Object getVehicleTzxs() {
                return vehicleTzxs;
            }

            public Object getVehicleCjds() {
                return vehicleCjds;
            }

            public Object getVehicleState() {
                return vehicleState;
            }

            public Object getLimitspeed() {
                return limitspeed;
            }

            public Object getRecordCode() {
                return recordCode;
            }

            public String getGroupId() {
                return groupId;
            }

            public Object getVehicleLine() {
                return vehicleLine;
            }

            public Object getLicenseTypeId() {
                return licenseTypeId;
            }

            public Object getOvertimeSpan() {
                return overtimeSpan;
            }

            public Object getPinpai() {
                return pinpai;
            }

            public Object getChuDate() {
                return chuDate;
            }

            public Object getShangDate() {
                return shangDate;
            }

            public Object getOilType() {
                return oilType;
            }

            public Object getEnginType() {
                return enginType;
            }

            public Object getChangjia() {
                return changjia;
            }

            public Object getTotalMail() {
                return totalMail;
            }

            public Object getRepairNum() {
                return repairNum;
            }

            public Object getHaoOil() {
                return haoOil;
            }

            public Object getInsurerType() {
                return insurerType;
            }

            public Object getInsurerLimit() {
                return insurerLimit;
            }

            public Object getVehicleVoid() {
                return vehicleVoid;
            }

            public Object getVehicleBuymode() {
                return vehicleBuymode;
            }

            public Object getVehicleBuydate() {
                return vehicleBuydate;
            }

            public Object getVehicleServicetime() {
                return vehicleServicetime;
            }

            public Object getServiceBank() {
                return serviceBank;
            }

            public Object getServiceInsurer() {
                return serviceInsurer;
            }

            public Object getGpsInstalldate() {
                return gpsInstalldate;
            }

            public String getSimNo() {
                return simNo;
            }

            public Object getCmd11() {
                return cmd11;
            }

            public Object getCmd12() {
                return cmd12;
            }

            public Object getCmd13() {
                return cmd13;
            }

            public Object getAlarmFlag() {
                return alarmFlag;
            }

            public String getOilparamconfigid() {
                return oilparamconfigid;
            }

            public String getOilparamconfigid2() {
                return oilparamconfigid2;
            }

            public int getLinealarmFlag() {
                return linealarmFlag;
            }

            public Object getDatmaintain() {
                return datmaintain;
            }

            public Object getDatverify() {
                return datverify;
            }

            public Object getDatservefee() {
                return datservefee;
            }

            public Object getDatinsur() {
                return datinsur;
            }

            public Object getDatrun() {
                return datrun;
            }

            public Object getUpdateDate() {
                return updateDate;
            }

            public Object getOpperUser() {
                return opperUser;
            }

            public String getDelFlag() {
                return delFlag;
            }

            public String getStat() {
                return stat;
            }
        }

        public static class PalingsEntity {
            private String palingId;
            private Object palingName;
            private String mudId;
            private String placeName;
            private Object palingCode;
            private String point;
            private Object priorGrade;
            private String limitSpeed;
            private Object longStay;
            private Object shortStay;
            private long updateDate;
            private String opperUser;
            private String delFlag;

            public void setPalingId(String palingId) {
                this.palingId = palingId;
            }

            public void setPalingName(Object palingName) {
                this.palingName = palingName;
            }

            public void setMudId(String mudId) {
                this.mudId = mudId;
            }

            public void setPlaceName(String placeName) {
                this.placeName = placeName;
            }

            public void setPalingCode(Object palingCode) {
                this.palingCode = palingCode;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public void setPriorGrade(Object priorGrade) {
                this.priorGrade = priorGrade;
            }

            public void setLimitSpeed(String limitSpeed) {
                this.limitSpeed = limitSpeed;
            }

            public void setLongStay(Object longStay) {
                this.longStay = longStay;
            }

            public void setShortStay(Object shortStay) {
                this.shortStay = shortStay;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public void setOpperUser(String opperUser) {
                this.opperUser = opperUser;
            }

            public void setDelFlag(String delFlag) {
                this.delFlag = delFlag;
            }

            public String getPalingId() {
                return palingId;
            }

            public Object getPalingName() {
                return palingName;
            }

            public String getMudId() {
                return mudId;
            }

            public String getPlaceName() {
                return placeName;
            }

            public Object getPalingCode() {
                return palingCode;
            }

            public String getPoint() {
                return point;
            }

            public Object getPriorGrade() {
                return priorGrade;
            }

            public String getLimitSpeed() {
                return limitSpeed;
            }

            public Object getLongStay() {
                return longStay;
            }

            public Object getShortStay() {
                return shortStay;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public String getOpperUser() {
                return opperUser;
            }

            public String getDelFlag() {
                return delFlag;
            }
        }

        public static class VehicleTypesEntity {
            private String vehicleTypeId;
            private String typeName;
            private String commonState;
            private String east;
            private String west;
            private String northEast;
            private String northWest;
            private String stopState;
            private String south;
            private String north;
            private String southEast;
            private String southWest;
            private String icoWidth;
            private String icoHeight;
            private long updateDate;
            private String opperUser;
            private String delFlag;

            public void setVehicleTypeId(String vehicleTypeId) {
                this.vehicleTypeId = vehicleTypeId;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public void setCommonState(String commonState) {
                this.commonState = commonState;
            }

            public void setEast(String east) {
                this.east = east;
            }

            public void setWest(String west) {
                this.west = west;
            }

            public void setNorthEast(String northEast) {
                this.northEast = northEast;
            }

            public void setNorthWest(String northWest) {
                this.northWest = northWest;
            }

            public void setStopState(String stopState) {
                this.stopState = stopState;
            }

            public void setSouth(String south) {
                this.south = south;
            }

            public void setNorth(String north) {
                this.north = north;
            }

            public void setSouthEast(String southEast) {
                this.southEast = southEast;
            }

            public void setSouthWest(String southWest) {
                this.southWest = southWest;
            }

            public void setIcoWidth(String icoWidth) {
                this.icoWidth = icoWidth;
            }

            public void setIcoHeight(String icoHeight) {
                this.icoHeight = icoHeight;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public void setOpperUser(String opperUser) {
                this.opperUser = opperUser;
            }

            public void setDelFlag(String delFlag) {
                this.delFlag = delFlag;
            }

            public String getVehicleTypeId() {
                return vehicleTypeId;
            }

            public String getTypeName() {
                return typeName;
            }

            public String getCommonState() {
                return commonState;
            }

            public String getEast() {
                return east;
            }

            public String getWest() {
                return west;
            }

            public String getNorthEast() {
                return northEast;
            }

            public String getNorthWest() {
                return northWest;
            }

            public String getStopState() {
                return stopState;
            }

            public String getSouth() {
                return south;
            }

            public String getNorth() {
                return north;
            }

            public String getSouthEast() {
                return southEast;
            }

            public String getSouthWest() {
                return southWest;
            }

            public String getIcoWidth() {
                return icoWidth;
            }

            public String getIcoHeight() {
                return icoHeight;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public String getOpperUser() {
                return opperUser;
            }

            public String getDelFlag() {
                return delFlag;
            }
        }
    }
}
