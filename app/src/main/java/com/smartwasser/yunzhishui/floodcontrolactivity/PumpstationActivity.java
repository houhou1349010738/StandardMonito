package com.smartwasser.yunzhishui.floodcontrolactivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.PopupPumpstion;
import com.smartwasser.yunzhishui.bean.PopupwindRainResponse;
import com.smartwasser.yunzhishui.bean.PumpForCqResponse;
import com.smartwasser.yunzhishui.bean.PumpForResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.RainCityJsonResponse;
import com.smartwasser.yunzhishui.bean.RainCityResponse;
import com.smartwasser.yunzhishui.bean.RainPumpResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.service.LocationService;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.support.SupportXAlign;
import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/23 0023.
 */
public class PumpstationActivity extends Activity implements HttpLoader.ResponseListener,View.OnClickListener{
    private TextView tv_toolbar;
    private ImageButton button_menu,norm_ser;
    private TextView image_weixing,image_sanwei;
    private Button tiaoxu,but_chuqi;
    private PopListViewUtils plu=new PopListViewUtils(this);
    private ImageButton bangzhan;
    private TextView fanhui2;
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    public LocationService locationService;
    public Vibrator mVibrator;
    private PumpForResponse mPumpFor;
    private RelativeLayout jian,chuqi,hanxu;
    private PumpForCqResponse mPumpForCq;
    private   RainPumpResponse  mRainPump;
    private RelativeLayout layout;
    private int i=1;
    private ImageButton fanhui;
    private EventSearchResponse  seach=new EventSearchResponse();
    private int m=1,n=1;
    private String info,info2,info3;
    private TextView popup_bianhao,popup_name,popup_yuliang;
    private RelativeLayout popup_relat;
    private XYMultipleSeriesDataset mXYMultipleSeriesDataSet;
    private ProgressDialog mProgressDialog;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private  PopupPumpstion  mPopupPumpstion;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator) getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_pumpstation);
        mMapView = (MapView) findViewById(R.id.mMapview);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在加载数据....");
        initView();
    }
    private void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        jian= (RelativeLayout) findViewById(R.id.jian);
        chuqi= (RelativeLayout) findViewById(R.id.chuqi);
        hanxu= (RelativeLayout) findViewById(R.id.hanxu);
        fanhui= (ImageButton) findViewById(R.id.fanhui);
        norm_ser.setVisibility(View.VISIBLE);
        norm_ser.setBackgroundResource(R.drawable.icon_15);
        image_weixing= (TextView) findViewById(R.id.image_weixing);
        image_sanwei= (TextView) findViewById(R.id.image_sanwei);
        tiaoxu= (Button) findViewById(R.id.tiaoxu);
        but_chuqi= (Button) findViewById(R.id.but_chuqi);
        bangzhan=(ImageButton) findViewById(R.id.bangzhan);
        fanhui2= (TextView) findViewById(R.id.fanhui2);
        layout= (RelativeLayout) findViewById(R.id.layout);
        initData();
    }

    private void initData() {
        image_weixing.setOnClickListener(this);
        image_sanwei.setOnClickListener(this);
        tiaoxu.setOnClickListener(this);
        button_menu.setOnClickListener(this);
        but_chuqi.setOnClickListener(this);
        norm_ser.setOnClickListener(this);
        bangzhan.setOnClickListener(this);
        layout.setBackgroundColor(Color.parseColor("#b3ffffff"));
        tv_toolbar.setText("泵站运行状态监测");
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINPUMP, prams,
                RainPumpResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMP, this, false).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMP
                && response instanceof RainPumpResponse) {
              mRainPump= (RainPumpResponse) response;
            if("00000".equals(mRainPump.getErrorCode())){
                   getNearbyShop();
                mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        info = (String) marker.getExtraInfo().get("info");
                        info2 = (String) marker.getExtraInfo().get("info2");
                        info3 = (String) marker.getExtraInfo().get("info3");
                        /**请求网络*/
                        showProgressDialog();
                        HashMap<String, Object> prams2 = new HashMap<>();
                        prams2.put("unitCode",info);
                        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTBZRAIN, prams2,
                                PopupPumpstion.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTBZRAIN, PumpstationActivity.this, false).setTag(this);
                        showProgressDialog();
                        return false;
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTBZRAIN
                && response instanceof  PopupPumpstion) {
              mPopupPumpstion = (PopupPumpstion) response;
              if("00000".equals( mPopupPumpstion.getErrorCode())){
                  show();
                  View view= ChartFactory.getLineChartView(this, initLineGraphView(), initRender());
                  popup_relat.addView(view);
                  dismissProgressDialog();
              }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFORCQ
                && response instanceof PumpForCqResponse) {
            mPumpForCq= (PumpForCqResponse) response;
            if("00000".equals( mPumpForCq.getErrorCode())){
                getNearbyShop2();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFOR
                && response instanceof PumpForResponse) {
            mPumpFor= (PumpForResponse) response;
            if("00000".equals(mPumpFor.getErrorCode())){
                getNearbyShop3();
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_menu:
                finish();
                break;
            case R.id.norm_ser:
                /**弹出popupwind*/
                ListView minlistView3=plu.initListView6();
                PopupWindowUtils.showPopupWindow2(minlistView3, norm_ser,this);
                minlistView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {         /**网络请求*/
                            case 0:
                                EventBus.getDefault().postSticky(seach);
                                Intent intent=new Intent(PumpstationActivity.this,RainfallActivity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 1:
                                Intent intent2=new Intent(PumpstationActivity.this,FieldRainActivity.class);
                                startActivity(intent2);
                                finish();
                                break;
                        }
                    }
                });
                break;
            case R.id.image_weixing:
                /**卫星图*/
                if(m%2!=0){
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                }else{
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                }
                m++;
                break;
            case R.id.image_sanwei:
                /**三维图*/
                if(n%2!=0){
                    mBaiduMap.showMapPoi(false);
                }else{
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                }
                n++;
                break;
            case R.id.tiaoxu:
                /**调蓄*/
                tv_toolbar.setText("调蓄");
                jian.setVisibility(View.GONE);
                chuqi.setVisibility(View.GONE);
                hanxu.setVisibility(View.VISIBLE);
                mBaiduMap.clear();
                fanhui2.setText("调蓄");
                if(i%2==0){
                    but_chuqi.setVisibility(View.GONE);
                    tiaoxu.setVisibility(View.GONE);
                    fanhui.setBackgroundResource(R.drawable.icon_50);
                    bangzhan.setBackgroundResource(R.drawable.side_bg_02);
                    fanhui2.setTextColor(Color.parseColor("#ffffff"));
                }
                if(i%2!=0){
                    fanhui.setBackgroundResource(R.drawable.icon_13);
                    bangzhan.setBackgroundResource(R.drawable.side_bg_01);
                    fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                    but_chuqi.setVisibility(View.VISIBLE);
                    tiaoxu.setVisibility(View.VISIBLE);
                    but_chuqi.setTextColor(Color.parseColor("#ffffff"));
                    tiaoxu.setTextColor(Color.parseColor("#ffffff"));
                    but_chuqi.setBackgroundColor(Color.parseColor("#22b3e9"));
                    tiaoxu.setBackgroundColor(Color.parseColor("#22b3e9"));
                }
                ++i;
                HashMap<String, Object> prams = new HashMap<>();
                HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINPUMPFOR, prams,
                        PumpForResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFOR, this, false).setTag(this);
                break;
            case R.id.but_chuqi:
                /**初期*/
                mBaiduMap.clear();
                tv_toolbar.setText("初期");
                jian.setVisibility(View.GONE);
                chuqi.setVisibility(View.VISIBLE);
                hanxu.setVisibility(View.GONE);
                fanhui2.setText("初期");
                if(i%2==0){
                    but_chuqi.setVisibility(View.GONE);
                    tiaoxu.setVisibility(View.GONE);
                    fanhui.setBackgroundResource(R.drawable.icon_50);
                    bangzhan.setBackgroundResource(R.drawable.side_bg_02);
                    fanhui2.setTextColor(Color.parseColor("#ffffff"));
                }
                if(i%2!=0){
                    fanhui.setBackgroundResource(R.drawable.icon_13);
                    bangzhan.setBackgroundResource(R.drawable.side_bg_01);
                    fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                    but_chuqi.setVisibility(View.VISIBLE);
                    tiaoxu.setVisibility(View.VISIBLE);
                    but_chuqi.setTextColor(Color.parseColor("#ffffff"));
                    tiaoxu.setTextColor(Color.parseColor("#ffffff"));
                    but_chuqi.setBackgroundColor(Color.parseColor("#22b3e9"));
                    tiaoxu.setBackgroundColor(Color.parseColor("#22b3e9"));
                }
                ++i;
                HashMap<String, Object> prams2 = new HashMap<>();
                HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINPUMPFORCQ, prams2,
                        PumpForCqResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFORCQ, this, false).setTag(this);
                break;
            case R.id.bangzhan:
                /**泵站*/
                mBaiduMap.clear();
                tv_toolbar.setText("泵站");
                /**隐藏另2个布局*/
                jian.setVisibility(View.VISIBLE);
                chuqi.setVisibility(View.GONE);
                hanxu.setVisibility(View.GONE);
                fanhui2.setText("泵站");
                if(i%2==0){
                    but_chuqi.setVisibility(View.GONE);
                    tiaoxu.setVisibility(View.GONE);
                    fanhui.setBackgroundResource(R.drawable.icon_50);
                    bangzhan.setBackgroundResource(R.drawable.side_bg_02);
                    fanhui2.setTextColor(Color.parseColor("#ffffff"));
                }
                if(i%2!=0){
                    fanhui.setBackgroundResource(R.drawable.icon_13);
                    bangzhan.setBackgroundResource(R.drawable.side_bg_01);
                    fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                    but_chuqi.setVisibility(View.VISIBLE);
                    tiaoxu.setVisibility(View.VISIBLE);
                    but_chuqi.setTextColor(Color.parseColor("#ffffff"));
                    tiaoxu.setTextColor(Color.parseColor("#ffffff"));
                    but_chuqi.setBackgroundColor(Color.parseColor("#22b3e9"));
                    tiaoxu.setBackgroundColor(Color.parseColor("#22b3e9"));
                }
                ++i;
                HashMap<String, Object> prams3 = new HashMap<>();
                HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINPUMP, prams3,
                        RainPumpResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMP, this, false).setTag(this);
                break;
        }
    }
    public void getNearbyShop() {
        // 构建Marker图标
        BitmapDescriptor bitmap = null;
        BitmapDescriptor  bitmap2 = null;
        BitmapDescriptor bitmap3= null;
        BitmapDescriptor bitmap4= null;
        BitmapDescriptor bitmap5= null;
        BitmapDescriptor bitmap6= null;
        bitmap2 = BitmapDescriptorFactory.fromResource(R.drawable.icon_36);
        bitmap= BitmapDescriptorFactory.fromResource(R.drawable.icon_37);
        bitmap3=BitmapDescriptorFactory.fromResource(R.drawable.icon_38);
        bitmap4=BitmapDescriptorFactory.fromResource(R.drawable.icon_39);
        bitmap5=BitmapDescriptorFactory.fromResource(R.drawable.icon_40);
        bitmap6=BitmapDescriptorFactory.fromResource(R.drawable.icon_41);
        LatLng point =null;
        OverlayOptions option=null;
        Marker marker = null;
        for (int i = 0; i < mRainPump.getData().getYlMap().size(); i++) {
            String arr[]= mRainPump.getData().getYlMap().get(i).getPoints().split(":");
            point = new LatLng(Double.parseDouble(arr[1]),Double.parseDouble(arr[0]));
            if("雨水泵站".equals(mRainPump.getData().getYlMap().get(i).getUnitType())){
                     /** 0:states  停止   1:是运行   2:是未连通*/
                    if("0".equals(mRainPump.getData().getYlMap().get(i).getStatus())){
                                /**设置停止的图片*/
                       option = new MarkerOptions().position(point).icon(bitmap);
                    }else if("1".equals(mRainPump.getData().getYlMap().get(i).getStatus())){
                                /**设置运行图片*/
                        option = new MarkerOptions().position(point).icon(bitmap2);
                    }else if("2".equals(mRainPump.getData().getYlMap().get(i).getStatus())){
                                /**未连通*/
                        option = new MarkerOptions().position(point).icon(bitmap3);
                    }
            }else if("污水泵站".equals(mRainPump.getData().getYlMap().get(i).getUnitType())){
                if("0".equals(mRainPump.getData().getYlMap().get(i).getStatus())){
                    /**设置停止的图片*/
                    option = new MarkerOptions().position(point).icon(bitmap4);
                }else if("1".equals(mRainPump.getData().getYlMap().get(i).getStatus())){
                    /**设置运行图片*/
                   option = new MarkerOptions().position(point).icon(bitmap5);
                }else if("2".equals(mRainPump.getData().getYlMap().get(i).getStatus())){
                    /**未连通*/
                    option = new MarkerOptions().position(point).icon(bitmap6);
                }
            }
            marker = (Marker) mBaiduMap.addOverlay(option);
            //为marker添加识别标记信息
            Bundle bundle = new Bundle();
            bundle.putSerializable("info",mRainPump.getData().getYlMap().get(i).getUnitCode());
            bundle.putSerializable("info2",mRainPump.getData().getYlMap().get(i).getUnitName());
            bundle.putSerializable("info3",mRainPump.getData().getYlMap().get(i).getUnitType());
            marker.setExtraInfo(bundle);
            getZaiw(point, mRainPump.getData().getYlMap().get(i).getUnitName());
        }
    }
    private void getZaiw(LatLng point,String s){
        //构建文字Option对象，用于在地图上添加文字
        OverlayOptions textOption = new TextOptions()
                .bgColor(0xAA000000)
                .fontSize(30)
                .fontColor(0xFFFFFFFF)
                .text(s)
                .rotate(0)
                .position(point);
        //在地图上添加该文字对象并显示
        mBaiduMap.addOverlay(textOption);
    }
            /**初期池*/
    private void getNearbyShop2() {
        // 构建Marker图标
        BitmapDescriptor bitmap = null;
        BitmapDescriptor  bitmap2 = null;
        BitmapDescriptor bitmap3= null;
        BitmapDescriptor bitmap4= null;
        bitmap2 = BitmapDescriptorFactory.fromResource(R.drawable.icon_28);
        bitmap= BitmapDescriptorFactory.fromResource(R.drawable.icon_29);
        bitmap3=BitmapDescriptorFactory.fromResource(R.drawable.icon_33);
        bitmap4=BitmapDescriptorFactory.fromResource(R.drawable.icon_34);

        LatLng point =null;

        for (int i = 0; i < mPumpForCq.getData().getYlMap().size(); i++) {
            String arr[]=mPumpForCq.getData().getYlMap().get(i).getPoints().split(":");
            point = new LatLng(Double.parseDouble(arr[1]),Double.parseDouble(arr[0]));
            double s1=mPumpForCq.getData().getYlMap().get(i).getCqcValue();
            if("".equals(s1)||"null".equals(s1)){
                s1=0.0;
            }
            if(s1>=0&&s1<50){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap2);
                mBaiduMap.addOverlay(option);
            }else if (s1>=50&&s1<75){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
                mBaiduMap.addOverlay(option);
            }else if(s1>=75&&s1<100){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap3);
                mBaiduMap.addOverlay(option);
            }else if(s1>=100){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap4);
                mBaiduMap.addOverlay(option);
            }
            getZaiw(point, mPumpForCq.getData().getYlMap().get(i).getUnitName()+
                    (mPumpForCq.getData().getYlMap().get(i).getCqcValue()/100)+mPumpForCq.getData().getYlMap().get(i).getCqcElevation()+"m/"+
                    mPumpForCq.getData().getYlMap().get(i).getCqcHighest()+"m/"+Math.round((mPumpForCq.getData().getYlMap().get(i).getCqcValue()/100)/(mPumpForCq.getData().getYlMap().get(i).getCqcHighest()-mPumpForCq.getData().getYlMap().get(i).getCqcElevation()*1000))/100);

        }
    }
          /**调蓄池*/
    public void getNearbyShop3() {
        // 构建Marker图标
        BitmapDescriptor bitmap = null;
        BitmapDescriptor bitmap2 = null;
        BitmapDescriptor bitmap3 = null;
        BitmapDescriptor bitmap4 = null;
        BitmapDescriptor bitmap5 = null;
        BitmapDescriptor bitmap6 = null;
        BitmapDescriptor bitmap7 = null;
        BitmapDescriptor bitmap8 = null;
        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_05);
        bitmap2 = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_06);
        bitmap3 = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_07);
        bitmap4 = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_08);
        bitmap5 = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_13);
        bitmap6 = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_14);
        bitmap7 = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_15);
        bitmap8 = BitmapDescriptorFactory.fromResource(R.drawable.inflow_icon_16);
        LatLng point = null;
        for (int i = 0; i < mPumpFor.getData().getYlMap().size(); i++) {
            String arr[] = mPumpFor.getData().getYlMap().get(i).getPoints().split(":");
            point = new LatLng(Double.parseDouble(arr[1]), Double.parseDouble(arr[0]));
            /**进水*/
            double s1 = mPumpFor.getData().getYlMap().get(i).getTxcValue();
            if("".equals(s1)||"null".equals(s1)){
                s1=0.0;
            }
            if ("g".equals(mPumpFor.getData().getYlMap().get(i).getStatus())) {
                if (s1 >= 0 && s1 < 50) {
                    OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
                    mBaiduMap.addOverlay(option);
                } else if (s1>= 50 &&s1< 75) {
                    OverlayOptions option = new MarkerOptions().position(point).icon(bitmap2);
                    mBaiduMap.addOverlay(option);
                } else if (s1 >= 75 && s1 < 100) {
                    OverlayOptions option = new MarkerOptions().position(point).icon(bitmap3);
                    mBaiduMap.addOverlay(option);
                } else if (s1>= 100) {
                    OverlayOptions option = new MarkerOptions().position(point).icon(bitmap4);
                    mBaiduMap.addOverlay(option);
                }
            } else if ("c".equals(mPumpFor.getData().getYlMap().get(i).getStatus())) {
                /**出水*/
                if ("g".equals(mPumpFor.getData().getYlMap().get(i).getStatus())) {
                    if (s1 >= 0 &&s1 < 50) {
                        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap5);
                        mBaiduMap.addOverlay(option);
                    } else if (s1>= 50 && s1 < 75) {
                        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap6);
                        mBaiduMap.addOverlay(option);
                    } else if (s1 >= 75 && s1 < 100) {
                        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap7);
                        mBaiduMap.addOverlay(option);
                    } else if (s1 >= 100) {
                        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap8);
                        mBaiduMap.addOverlay(option);
                    }
                }
            }
            getZaiw(point, mPumpFor.getData().getYlMap().get(i).getUnitName()+
                    (mPumpFor.getData().getYlMap().get(i).getTxcValue()/100)+mPumpFor.getData().getYlMap().get(i).getTxcHighest()+"m/"+
                    mPumpFor.getData().getYlMap().get(i).getTxcHighest()+"m/"+Math.round((mPumpFor.getData().getYlMap().get(i).getTxcValue()/100)/(mPumpFor.getData().getYlMap().get(i).getTxcHighest()-mPumpFor.getData().getYlMap().get(i).getTxcElevation()*1000))/100);
        }
    }
    public View getViews(){
        View view=View.inflate(this,R.layout.popup_field,null);
        popup_bianhao= (TextView) view.findViewById(R.id.popup_bianhao);
        popup_name= (TextView) view.findViewById(R.id.popup_name);
        popup_yuliang= (TextView) view.findViewById(R.id.popup_yuliang);
        popup_relat= (RelativeLayout)view.findViewById(R.id.popup_relat);
        return view;
    }
    private void show(){
        psu.showPopupSearch5(getViews(), button_menu);
            popup_bianhao.setText("编号:" + info);
            popup_name.setText("名称:" + info2);
            popup_yuliang.setText("泵站名称:" +info3);
    }
    /**
     * 显示加载数据的dialog
     */
    public void showProgressDialog() {
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    public XYMultipleSeriesDataset initLineGraphView() {
        mXYMultipleSeriesDataSet = new XYMultipleSeriesDataset();
        XYSeries series=new XYSeries("");
        for(int i=0;i< mPopupPumpstion .getData().getPumpRunInfo().size();i++){
            String m=mPopupPumpstion .getData().getPumpRunInfo().get(i).getStat()+"";
            if(m==null||"".equals(m)||"null".equals(m)){
                m="0";
            }
            if(Integer.parseInt(m)==1) {
                if(i!=mPopupPumpstion .getData().getPumpRunInfo().size()-1){
                    String n=mPopupPumpstion .getData().getPumpRunInfo().get(i+1)+"";
                    if(m.equals(n)){
                        series.add(i,2);
                    }else{
                        series.add(i, 2);
                        series.add(i+1,1);
                        series.add(i,1);
                    }
                }
            }else {
                if(i!=mPopupPumpstion.getData().getPumpRunInfo().size()-1){
                    String n=mPopupPumpstion.getData().getPumpRunInfo().get(i+1).getStat()+"";
                    if(m.equals(n)){
                        series.add(i,1);
                    }else{
                        //  series.add(i,2);
                        series.add(i+1,1);
                        series.add(i,1);
                    }
                }

            }
        }
        mXYMultipleSeriesDataSet.addSeries(series);
        return mXYMultipleSeriesDataSet;
    }
    private XYMultipleSeriesRenderer initRender() {
        XYMultipleSeriesRenderer  mXYRenderer=new XYMultipleSeriesRenderer();
        // 1, 构造显示用渲染图
        mXYRenderer.setChartTitle("设备运行状态");
        mXYRenderer.setXTitle("日期");
        mXYRenderer.setYTitle("状态");
        mXYRenderer.setAxesColor(Color.BLACK);
        mXYRenderer.setLabelsColor(Color.BLACK);
        //设置字体的大小
        mXYRenderer.setAxisTitleTextSize(50f);
        mXYRenderer.setChartTitleTextSize(50f);
        mXYRenderer.setLabelsTextSize(30f);
        mXYRenderer.setLegendTextSize(50f);
        mXYRenderer.setPointSize(5f);
        // 设置合适的刻度,在轴上显示的数量是 MAX / labels
        mXYRenderer.setYLabels(3);
        mXYRenderer.setXLabels(0);  // 设置 X 轴不显示数字（改用我们手动添加的文字标签）
        mXYRenderer.setXAxisMin(0.5);
        mXYRenderer.setXAxisMax(5);
        mXYRenderer.setYAxisMin(0);
        mXYRenderer.setYAxisMax(3);
        mXYRenderer.setSupportXAlign(SupportXAlign.RIGHT);
        //设置网格的颜色
        mXYRenderer.setShowGrid(true);
        mXYRenderer.setGridColor(Color.parseColor("#55797C7E"));
        // 设置背景颜色
        mXYRenderer.setBackgroundColor(Color.WHITE);
        // 设置页边空白的颜色
        mXYRenderer.setMarginsColor(Color.WHITE);
        // 设置背景颜色生效
        mXYRenderer.setApplyBackgroundColor(true);

        // 设置坐标轴,轴的颜色
        mXYRenderer.setXLabelsColor(Color.parseColor("#797C7E"));
        mXYRenderer.setYLabelsColor(0, Color.parseColor("#797C7E"));
        mXYRenderer.setPanEnabled(true, false);// 表盘移动
        mXYRenderer.setZoomEnabled(true, false);
       /* mXYRenderer.setZoomButtonsVisible(true);*/
        mXYRenderer.setMargins(new int[]{70, 90, 70, 70});
        // 设置x,y轴显示的排列,默认是 Align.CENTER
        mXYRenderer.setXLabelsAlign(Paint.Align.CENTER);
        mXYRenderer.setYLabelsAlign(Paint.Align.LEFT);
        mXYRenderer.setAntialiasing(true);
        mXYRenderer.setFitLegend(true);
        mXYRenderer.setShowAxes(true);  // 设置坐标轴是否可见
        mXYRenderer.setShowLegend(true);
        for(int i=0;i< mPopupPumpstion.getData().getPumpRunInfo().size();i++) {
            String s=mPopupPumpstion.getData().getPumpRunInfo().get(i).getDataTime();
            if(s!=null) {
                s = s.substring(10);
            }
            mXYRenderer.addXTextLabel(i, s);
        }
        mXYRenderer.addYTextLabel(1,"停止");
        mXYRenderer.addYTextLabel(2,"运行");
        XYSeriesRenderer renderer;
        int s[] = new int[]{ Color.BLUE};
        renderer = new XYSeriesRenderer();
        renderer .setFillPoints(true);
        renderer.setPointStyle(PointStyle.CIRCLE);
        /**填充点（显示的点是空心还是实心）*/
        renderer.setColor(s[0]);
        renderer.setLineWidth(2f);
        mXYRenderer.addSeriesRenderer(renderer);
        return mXYRenderer;
    }
}
