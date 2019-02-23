package com.smartwasser.yunzhishui.floodcontrolactivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Vibrator;
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
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.PopupRainQiangResponse;
import com.smartwasser.yunzhishui.bean.PopupwindRainResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.RainQiangResponse;
import com.smartwasser.yunzhishui.bean.RainResponse;
import com.smartwasser.yunzhishui.bean.RainTopResponse;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class RainfallActivity extends Activity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ProgressDialog mProgressDialog;
    private ImageButton button_menu,norm_ser;
    private RelativeLayout relativelayout;
    private Button but_yuqiang;
    private TextView image_weixing,image_sanwei;
    private ImageButton yulaing;
    private TextView fanhui2;
    public LocationService locationService;
    public Vibrator mVibrator;
    private   RainResponse mRain;
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private LocationService locService;
    private   RainQiangResponse   mRainQiang;
    private TextView tv_one,tv_two,tv_three,tv_one_qiang
            ,tv_two_qiang,tv_three_qiang,tv_three_pj
            ,dwadadw,dawfafs,tv_three_ss;
    private PopListViewUtils plu=new PopListViewUtils(this);
    private EventNormSelect event=new EventNormSelect();
    private EventSearchResponse search;
    private ImageButton fanhui;
    private int i=1;
    private  int m=1,n=1;
    private TextView popup_bianhao,popup_name,popup_yuliang;
    private RelativeLayout popup_relat;
    private  PopupwindRainResponse mPopupwindRain;
    private XYMultipleSeriesDataset mXYMultipleSeriesDataSet;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private   String info,info2,info3,info4,info5,info6;
    private  PopupRainQiangResponse  mPopupRainQiang;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_rainfall);
        // 初始化地图
        mMapView = (MapView) findViewById(R.id.mMapview);
        mBaiduMap = mMapView.getMap();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在加载数据....");
        initView();
    }
    private void initView() {
        tv_toolbar= (TextView)findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        norm_ser.setVisibility(View.VISIBLE);
        norm_ser.setBackgroundResource(R.drawable.icon_15);
        image_weixing= (TextView) findViewById(R.id.image_weixing);
        image_sanwei= (TextView) findViewById(R.id.image_sanwei);
        but_yuqiang= (Button) findViewById(R.id.but_yuqiang);
        yulaing= (ImageButton) findViewById(R.id.yulaing);
        fanhui2= (TextView) findViewById(R.id.fanhui2);
        relativelayout= (RelativeLayout) findViewById(R.id.relativelayout);
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        tv_one= (TextView) findViewById(R.id.tv_one);
        tv_two= (TextView) findViewById(R.id.tv_two);
        tv_three= (TextView) findViewById(R.id. tv_three);
        tv_one_qiang= (TextView) findViewById(R.id.tv_one_qiang);
        tv_two_qiang= (TextView) findViewById(R.id.tv_two_qiang);
        tv_three_qiang= (TextView) findViewById(R.id.tv_three_qiang);
        tv_three_pj= (TextView) findViewById(R.id.tv_three_pj);
        dwadadw= (TextView) findViewById(R.id.dwadadw);
        dawfafs= (TextView) findViewById(R.id.dawfafs);
        tv_three_ss= (TextView) findViewById(R.id.tv_three_ss);
        fanhui= (ImageButton) findViewById(R.id.fanhui);
        EventBus.getDefault().registerSticky(this);
        initData();
    }
    private void initData() {
        but_yuqiang.setOnClickListener(this);
        yulaing.setOnClickListener(this);
        norm_ser.setOnClickListener(this);
        image_weixing.setOnClickListener(this);
        image_sanwei.setOnClickListener(this);
        tv_toolbar.setText("雨量监测");
        relativelayout.setBackgroundColor(Color.parseColor("#b3ffffff"));
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search = null;
                finish();
            }
        });
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAIN, prams,
               RainResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAIN, this, false).setTag(this);
        if(search!=null){
            if(!search.isFlag()) {
                dwadadw.setVisibility(View.VISIBLE);
                dawfafs.setVisibility(View.VISIBLE);
                tv_three_ss.setVisibility(View.VISIBLE);
                HashMap<String, Object> prams2 = new HashMap<>();
                HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINTOP, prams2,
                        RainTopResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINTOP, RainfallActivity.this, false).setTag(this);
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_yuqiang:
                mBaiduMap.clear();
                but_yuqiang.setTextColor(Color.parseColor("#ffffff"));
                but_yuqiang.setBackgroundColor(Color.parseColor("#22b3e9"));
                fanhui2.setText("雨强");
                if(i%2!=0){
                    fanhui.setBackgroundResource(R.drawable.icon_13);
                    yulaing.setBackgroundResource(R.drawable.side_bg_01);
                    fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                    but_yuqiang.setVisibility(View.VISIBLE);
                    but_yuqiang.setBackgroundColor(Color.parseColor("#22b3e9"));
                    but_yuqiang.setTextColor(Color.parseColor("#ffffff"));
                }
                if(i%2==0){
                    yulaing.setBackgroundResource(R.drawable.side_bg_02);
                    fanhui2.setTextColor(Color.parseColor("#ffffff"));
                    fanhui.setBackgroundResource(R.drawable.icon_50);
                    but_yuqiang.setVisibility(View.GONE);
                }
                ++i;
                HashMap<String, Object> prams = new HashMap<>();
                HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINQIANG, prams,
                        RainQiangResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINQIANG, this, false).setTag(this);
                break;
            case R.id.yulaing:
                mBaiduMap.clear();
                fanhui2.setText("雨量");
                if(i%2==0){
                    yulaing.setBackgroundResource(R.drawable.side_bg_02);
                    fanhui2.setTextColor(Color.parseColor("#ffffff"));
                    fanhui.setBackgroundResource(R.drawable.icon_50);
                    but_yuqiang.setVisibility(View.GONE);
                }
                if(i%2!=0){
                    fanhui.setBackgroundResource(R.drawable.icon_13);
                    yulaing.setBackgroundResource(R.drawable.side_bg_01);
                    fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                    but_yuqiang.setVisibility(View.VISIBLE);
                    but_yuqiang.setBackgroundColor(Color.parseColor("#22b3e9"));
                    but_yuqiang.setTextColor(Color.parseColor("#ffffff"));
                }
                ++i;
                HashMap<String, Object> prams2 = new HashMap<>();
                HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAIN, prams2,
                        RainResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAIN, this, false).setTag(this);

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
            case R.id.norm_ser:
                /**弹出popupwind*/
                ListView minlistView3=plu.initListView6();
                PopupWindowUtils.showPopupWindow2(minlistView3,norm_ser,this);
                minlistView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                              switch (position) {         /**网络请求*/
                                  case 0:
                                      dwadadw.setVisibility(View.VISIBLE);
                                      dawfafs.setVisibility(View.VISIBLE);
                                      tv_three_ss.setVisibility(View.VISIBLE);
                                      HashMap<String, Object> prams = new HashMap<>();
                                      HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINTOP, prams,
                                              RainTopResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINTOP, RainfallActivity.this, false).setTag(this);
                                      PopupWindowUtils.closePopupWindow();
                                      break;
                                  case 1:
                                      EventBus.getDefault().postSticky(event);
                                      Intent intent=new Intent(RainfallActivity.this,FieldRainActivity.class);
                                      startActivity(intent);
                                      finish();
                                      break;
                              }
                    }
                });
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAIN
                && response instanceof RainResponse) {
               mRain = (RainResponse) response;
            if("00000".equals(mRain.getErrorCode())){
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
                        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTLSCXRAIN, prams2,
                                PopupwindRainResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTLSCXRAIN, RainfallActivity.this, false).setTag(this);
                        showProgressDialog();
                        return false;
                    }
                });
            }

        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINQIANG
                && response instanceof RainQiangResponse) {
              mRainQiang = (RainQiangResponse) response;
            if("00000".equals(mRainQiang.getErrorCode())) {
                getNearbyShop2();
                mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        info4= (String)marker.getExtraInfo().get("info4");
                        info5 = (String)marker.getExtraInfo().get("info5");
                        info6= (String)marker.getExtraInfo().get("info6");
                        /**请求网络*/
                        showProgressDialog();
                        HashMap<String, Object> prams= new HashMap<>();
                        prams.put("unitCode", info4);
                        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTYQCXRAIN, prams,
                                PopupRainQiangResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTYQCXRAIN, RainfallActivity.this, false).setTag(this);
                        showProgressDialog();
                        return false;
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTYQCXRAIN
                && response instanceof  PopupRainQiangResponse) {
              mPopupRainQiang=( PopupRainQiangResponse)response;
             if("00000".equals(mPopupRainQiang.getErrorCode())){
                 show();
                 View view= ChartFactory.getLineChartView(this,initLineGraphView(), initRender());
                 popup_relat.addView(view);
                 dismissProgressDialog();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTLSCXRAIN
                && response instanceof PopupwindRainResponse) {
            mPopupwindRain=(PopupwindRainResponse)response;
            if("00000".equals(mPopupwindRain.getErrorCode())){
                show();
                View view= ChartFactory.getLineChartView(this,initLineGraphView(), initRender());
                popup_relat.addView(view);
                dismissProgressDialog();
            }

        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINTOP
                && response instanceof RainTopResponse) {
            RainTopResponse mRainTop = (RainTopResponse) response;
            if("00000".equals(mRainTop.getErrorCode())){
                String s=mRainTop.getData().getRainList().get(0).getINDE_VALUE();
                if(s.length()>=6){
                    s=s.substring(0,5);
                }
                tv_one.setText("1:" + mRainTop.getData().getRainList().get(0).getUNIT_NAME() + "   " + s + "mm");
                tv_two.setText("2:" + mRainTop.getData().getRainList().get(1).getUNIT_NAME() + "   " + s + "mm");
                tv_three.setText("3:" + mRainTop.getData().getRainList().get(2).getUNIT_NAME() + "   " + s + "mm");
                tv_three_pj.setText(mRainTop.getData().getAvgRain().getInde_value() + "mm");
                if( mRainTop.getData().getRainIList().size()!=0) {
                    String s1= mRainTop.getData().getRainIList().get(0).getRi();
                    String s2=mRainTop.getData().getRainIList().get(1).getRi();
                    String s3=mRainTop.getData().getRainIList().get(2).getRi();
                    if(s1==null||"null".equals(s1)){
                        s1="-----";
                    }else{
                        s1=s1+"mm";
                    }
                    if(s2==null||"null".equals(s2)){
                        s2="-----";
                    }else{
                        s2=s2+"mm";
                    }
                    if(s3==null||"null".equals(s3)){
                        s3="-----";
                    }else{
                        s3=s3+"mm";
                    }
                    tv_one_qiang.setText("1:" + mRainTop.getData().getRainIList().get(0).getUNIT_NAME() +s1);
                    tv_two_qiang.setText("2:" + mRainTop.getData().getRainIList().get(1).getUNIT_NAME() + s2);
                    tv_three_qiang.setText("3:" + mRainTop.getData().getRainIList().get(2).getUNIT_NAME() +s3);
                }
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    /**
     * 根据经纬度获取附近的商铺并显示出来
     **/
    private void getNearbyShop() {
        // 构建Marker图标
        BitmapDescriptor bitmap = null;
        BitmapDescriptor  bitmap2 = null;
        BitmapDescriptor bitmap3= null;
        BitmapDescriptor bitmap4= null;
        bitmap2 = BitmapDescriptorFactory.fromResource(R.drawable.icon_20);
        bitmap= BitmapDescriptorFactory.fromResource(R.drawable.icon_21);
        bitmap3=BitmapDescriptorFactory.fromResource(R.drawable.icon_22);
        bitmap4=BitmapDescriptorFactory.fromResource(R.drawable.icon_23);
        LatLng point =null;
        Marker marker = null;
        OverlayOptions option=null;
        for (int i = 0; i < mRain.getData().getYlMap().size(); i++) {
                String arr[]=mRain.getData().getYlMap().get(i).getPoint().split(":");
                point = new LatLng(Double.parseDouble(arr[1]),Double.parseDouble(arr[0]));
                if("4".equals(mRain.getData().getYlMap().get(i).getLevel())){
                    option = new MarkerOptions().position(point).icon(bitmap4);
                }else if("3".equals(mRain.getData().getYlMap().get(i).getLevel())){
                    option = new MarkerOptions().position(point).icon(bitmap3);
                }else if("2".equals(mRain.getData().getYlMap().get(i).getLevel())){
                    option = new MarkerOptions().position(point).icon(bitmap);
                }else if("1".equals(mRain.getData().getYlMap().get(i).getLevel())){
                    option = new MarkerOptions().position(point).icon(bitmap2);
                }else if("0".equals(mRain.getData().getYlMap().get(i).getLevel())){
                    option = new MarkerOptions().position(point).icon(bitmap2);
                }
            marker = (Marker) mBaiduMap.addOverlay(option);
            //为marker添加识别标记信息
            Bundle bundle = new Bundle();
            bundle.putSerializable("info",mRain.getData().getYlMap().get(i).getUnitCode());
            bundle.putSerializable("info2",mRain.getData().getYlMap().get(i).getUnitName());
            bundle.putSerializable("info3",mRain.getData().getYlMap().get(i).getValue());
            marker.setExtraInfo(bundle);
            getZaiw(point,mRain.getData().getYlMap().get(i).getUnitName()+
                    mRain.getData().getYlMap().get(i).getValue());
        }

    }
    /**雨强*/
    private void getNearbyShop2() {
        // 构建Marker图标
        BitmapDescriptor bitmap = null;
        BitmapDescriptor  bitmap2 = null;
        BitmapDescriptor bitmap3= null;
        BitmapDescriptor bitmap4= null;
        bitmap2 = BitmapDescriptorFactory.fromResource(R.drawable.icon_20);
        bitmap= BitmapDescriptorFactory.fromResource(R.drawable.icon_21);
        bitmap3=BitmapDescriptorFactory.fromResource(R.drawable.icon_22);
        bitmap4=BitmapDescriptorFactory.fromResource(R.drawable.icon_23);
        LatLng point =null;
        Marker marker = null;
        OverlayOptions option=null;
        for (int i = 0; i < mRainQiang.getData().getYlMap().size(); i++) {
            String arr[]=mRainQiang.getData().getYlMap().get(i).getPoint().split(":");
            point = new LatLng(Double.parseDouble(arr[1]),Double.parseDouble(arr[0]));

            if("4".equals(mRainQiang.getData().getYlMap().get(i).getLevel())){
                option = new MarkerOptions().position(point).icon(bitmap4);
            }else if("3".equals(mRainQiang.getData().getYlMap().get(i).getLevel())){
                option = new MarkerOptions().position(point).icon(bitmap3);
            }else if("2".equals(mRainQiang.getData().getYlMap().get(i).getLevel())){
                option = new MarkerOptions().position(point).icon(bitmap);
            }else if("1".equals(mRainQiang.getData().getYlMap().get(i).getLevel())){
                option = new MarkerOptions().position(point).icon(bitmap2);
            }else if("0".equals(mRainQiang.getData().getYlMap().get(i).getLevel())){
                 option = new MarkerOptions().position(point).icon(bitmap2);
            }
            marker = (Marker) mBaiduMap.addOverlay(option);
            //为marker添加识别标记信息
            Bundle bundle = new Bundle();
            bundle.putSerializable("info4", mRainQiang.getData().getYlMap().get(i).getUnitCode());
            bundle.putSerializable("info5", mRainQiang.getData().getYlMap().get(i).getUnitName());
            bundle.putSerializable("info6",mRainQiang.getData().getYlMap().get(i).getValue());
            marker.setExtraInfo(bundle);
            getZaiw(point, mRainQiang.getData().getYlMap().get(i).getUnitName() +
                    mRainQiang.getData().getYlMap().get(i).getValue());
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
    public void onEvent(EventSearchResponse search){
        this.search=search;
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
        if("雨量".equals(fanhui2.getText())) {
            popup_bianhao.setText("编号:" + info);
            popup_name.setText("名称:" + info2);
            if (info3 != null) {
                if (info3.length() >= 6) {
                    info3 = info3.substring(0, 5);
                }
            }
            popup_yuliang.setText("平均降雨:" + info3);
        }else{
            popup_bianhao.setText("编号:" + info4);
            popup_name.setText("名称:" + info5);
            if (info5 != null) {
                if (info5.length() >= 6) {
                    info5 = info5.substring(0, 5);
                }
            }
            popup_yuliang.setText("平均降雨:" + info6);
        }
    }
    public XYMultipleSeriesDataset initLineGraphView() {
        mXYMultipleSeriesDataSet = new XYMultipleSeriesDataset();
        XYSeries series=new XYSeries("");
        if("雨量".equals(fanhui2.getText())) {
            for (int i = 0; i < mPopupwindRain.getData().getRainlist().size(); i++) {
                series.add(i, mPopupwindRain.getData().getRainlist().get(i).getValue());
            }
        }else{
            for (int i = 0; i < mPopupRainQiang.getData().getPumpRaininessTopInfo().size(); i++) {
                series.add(i, mPopupRainQiang.getData().getPumpRaininessTopInfo().get(i).getValue());
            }
        }
        mXYMultipleSeriesDataSet.addSeries(series);
        return mXYMultipleSeriesDataSet;
    }
    private XYMultipleSeriesRenderer initRender() {
        XYMultipleSeriesRenderer  mXYRenderer=new XYMultipleSeriesRenderer();
        // 1, 构造显示用渲染图
        mXYRenderer.setChartTitle("雨量趋势图");
        mXYRenderer.setXTitle("日期");
        mXYRenderer.setYTitle("雨量");
        mXYRenderer.setAxesColor(Color.BLACK);
        mXYRenderer.setLabelsColor(Color.BLACK);
        //设置字体的大小
        mXYRenderer.setAxisTitleTextSize(50f);
        mXYRenderer.setChartTitleTextSize(50f);
        mXYRenderer.setLabelsTextSize(30f);
        mXYRenderer.setLegendTextSize(50f);
        mXYRenderer.setPointSize(5f);
        // 设置合适的刻度,在轴上显示的数量是 MAX / labels
        mXYRenderer.setYLabels(5);
        mXYRenderer.setXLabels(0);  // 设置 X 轴不显示数字（改用我们手动添加的文字标签）
        mXYRenderer.setXAxisMin(0.5);
        mXYRenderer.setXAxisMax(5);
        mXYRenderer.setYAxisMin(0);
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
        mXYRenderer.setPanEnabled(true, true);// 表盘移动
        mXYRenderer.setZoomEnabled(true,false);
       /* mXYRenderer.setZoomButtonsVisible(true);*/
        mXYRenderer.setMargins(new int[]{70, 90, 70, 70});
        // 设置x,y轴显示的排列,默认是 Align.CENTER
        mXYRenderer.setXLabelsAlign(Paint.Align.CENTER);
        mXYRenderer.setYLabelsAlign(Paint.Align.LEFT);
        mXYRenderer.setAntialiasing(true);
        mXYRenderer.setFitLegend(true);
        mXYRenderer.setShowAxes(true);  // 设置坐标轴是否可见
        mXYRenderer.setShowLegend(true);
        if("雨量".equals(fanhui2.getText())) {
            for (int i = 0; i < mPopupwindRain.getData().getRainlist().size(); i++) {
                String s = mPopupwindRain.getData().getRainlist().get(i).getDataTime();
                s = s.substring(10);
                mXYRenderer.addXTextLabel(i, s);
            }
        }else{
            for (int i = 0; i < mPopupRainQiang.getData().getPumpRaininessTopInfo().size(); i++) {
                String s2 = mPopupRainQiang.getData().getPumpRaininessTopInfo().get(i).getDataTime();
                s2 = s2.substring(10);
                mXYRenderer.addXTextLabel(i, s2);
            }
        }
        XYSeriesRenderer renderer;
        int s[] = new int[]{ Color.RED};
        renderer = new XYSeriesRenderer();
        renderer .setFillPoints(true);
        renderer.setPointStyle(PointStyle.CIRCLE);
        /**填充点（显示的点是空心还是实心）*/
        renderer.setColor(s[0]);
        renderer.setLineWidth(7f);
        /**将点的值显示出来*/
        renderer .setDisplayChartValues(true);
        /**显示的点的值与图的距离*/
        renderer .setChartValuesSpacing(10);
        /**点的值的文字大小 */
        renderer.setChartValuesTextSize(13);
        mXYRenderer.addSeriesRenderer(renderer);
        return mXYRenderer;
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
}
