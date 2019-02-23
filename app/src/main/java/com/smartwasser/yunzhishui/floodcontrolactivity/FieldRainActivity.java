package com.smartwasser.yunzhishui.floodcontrolactivity;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.PumpForCqResponse;
import com.smartwasser.yunzhishui.bean.PumpForResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.RainCityJsonResponse;
import com.smartwasser.yunzhishui.bean.RainCityResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.service.LocationService;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;
import org.seny.android.utils.MyToast;
import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class FieldRainActivity extends Activity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu,norm_ser;
    private TextView image_weixing,image_sanwei;
    private Button but_chuqi,bangzhan;
    private ImageButton tiaoxu;
    private TextView fanhui2;
    private  RainCityJsonResponse  mRainCityJson;
    private PopListViewUtils plu=new PopListViewUtils(this);
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    public LocationService locationService;
    public Vibrator mVibrator;
    private  PumpForResponse  mPumpFor;
    private RelativeLayout jian,chuqi,hanxu;
    private  PumpForCqResponse mPumpForCq;
    private ListView minListView;
    private Toolbar toolbar;
    private    RainCityResponse mRainCityTop;
    private MyCityAdapter mMyCityAdapter;
    private EventNormSelect event=null;
    private EventSearchResponse seach=new EventSearchResponse();
    private Handler mHandler = new Handler();
    private RelativeLayout layout;
    private int i=1;
    private ImageButton fanhui;
    private int n=1,m=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator) getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_fieldrain);
        mMapView = (MapView) findViewById(R.id.mMapview);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mHandler.postDelayed(mRunnable, 500);
        fanhui2= (TextView)findViewById(R.id.fanhui2);
        initView();
    }
    private void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        jian= (RelativeLayout) findViewById(R.id.jian);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        chuqi= (RelativeLayout) findViewById(R.id.chuqi);
        hanxu= (RelativeLayout) findViewById(R.id.hanxu);
        norm_ser.setVisibility(View.VISIBLE);
        norm_ser.setBackgroundResource(R.drawable.icon_15);
        image_weixing= (TextView) findViewById(R.id.image_weixing);
        image_sanwei= (TextView) findViewById(R.id.image_sanwei);
        tiaoxu= (ImageButton) findViewById(R.id.tiaoxu);
        but_chuqi= (Button) findViewById(R.id.but_chuqi);
        bangzhan= (Button) findViewById(R.id.bangzhan);
        layout= (RelativeLayout) findViewById(R.id. layout);
        fanhui= (ImageButton) findViewById(R.id.fanhui);
        EventBus.getDefault().registerSticky(this);
        initData();
    }
    private void initData() {
        image_weixing.setOnClickListener(this);
        image_sanwei.setOnClickListener(this);
        tiaoxu.setOnClickListener(this);
        layout.setBackgroundColor(Color.parseColor("#b3ffffff"));
        button_menu.setOnClickListener(this);
        but_chuqi.setOnClickListener(this);
        norm_ser.setOnClickListener(this);
        bangzhan.setOnClickListener(this);
        tv_toolbar.setText("场降雨累计雨量");
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINCITYJSON, prams,
                RainCityJsonResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINCITYJSON, this, false).setTag(this);
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
                                 Intent intent=new Intent(FieldRainActivity.this,RainfallActivity.class);
                                 startActivity(intent);
                                 finish();
                                 break;
                             case 1:
                                 /**弹出一个pup,在toolbar的下方*/
                                 minListView=initListView();
                                 PopupWindowUtils.showPopupWindow3(minListView,toolbar);
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
                 if(i%2==0){
                     but_chuqi.setVisibility(View.GONE);
                     bangzhan.setVisibility(View.GONE);
                     fanhui.setBackgroundResource(R.drawable.icon_50);
                     tiaoxu.setBackgroundResource(R.drawable.side_bg_02);
                     fanhui2.setTextColor(Color.parseColor("#ffffff"));
                 }
                 if(i%2!=0){
                     fanhui.setBackgroundResource(R.drawable.icon_13);
                     tiaoxu.setBackgroundResource(R.drawable.side_bg_01);
                     fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                     but_chuqi.setVisibility(View.VISIBLE);
                     bangzhan.setVisibility(View.VISIBLE);
                     but_chuqi.setTextColor(Color.parseColor("#ffffff"));
                     bangzhan.setTextColor(Color.parseColor("#ffffff"));
                     but_chuqi.setBackgroundColor(Color.parseColor("#22b3e9"));
                     bangzhan.setBackgroundColor(Color.parseColor("#22b3e9"));
                 }
                 ++i;
                 fanhui2.setText("调蓄");
                 mBaiduMap.clear();
                 HashMap<String, Object> prams = new HashMap<>();
                 HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINPUMPFOR, prams,
                        PumpForResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFOR, this, false).setTag(this);
             break;
             case R.id.but_chuqi:
                 /**初期*/
                 tv_toolbar.setText("初期");
                 mBaiduMap.clear();
                 jian.setVisibility(View.GONE);
                 chuqi.setVisibility(View.VISIBLE);
                 hanxu.setVisibility(View.GONE);
                 fanhui2.setText("初期");
                 if(i%2==0){
                     but_chuqi.setVisibility(View.GONE);
                     bangzhan.setVisibility(View.GONE);
                     fanhui.setBackgroundResource(R.drawable.icon_50);
                     tiaoxu.setBackgroundResource(R.drawable.side_bg_02);
                     fanhui2.setTextColor(Color.parseColor("#ffffff"));
                 }
                 if(i%2!=0){
                     fanhui.setBackgroundResource(R.drawable.icon_13);
                     tiaoxu.setBackgroundResource(R.drawable.side_bg_01);
                     fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                     but_chuqi.setVisibility(View.VISIBLE);
                     bangzhan.setVisibility(View.VISIBLE);
                     but_chuqi.setTextColor(Color.parseColor("#ffffff"));
                     bangzhan.setTextColor(Color.parseColor("#ffffff"));
                     but_chuqi.setBackgroundColor(Color.parseColor("#22b3e9"));
                     bangzhan.setBackgroundColor(Color.parseColor("#22b3e9"));
                 }
                 ++i;
                 HashMap<String, Object> prams2 = new HashMap<>();
                 HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINPUMPFORCQ, prams2,
                         PumpForCqResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFORCQ, this, false).setTag(this);
                 break;
             case R.id.bangzhan:
                 /**泵站*/
                 fanhui2.setText("泵站");
                 tv_toolbar.setText("泵站运行状态监测");
                 if(i%2==0){
                     but_chuqi.setVisibility(View.GONE);
                     bangzhan.setVisibility(View.GONE);
                     fanhui.setBackgroundResource(R.drawable.icon_50);
                     tiaoxu.setBackgroundResource(R.drawable.side_bg_02);
                     fanhui2.setTextColor(Color.parseColor("#ffffff"));
                 }
                 if(i%2!=0){
                     fanhui.setBackgroundResource(R.drawable.icon_13);
                     tiaoxu.setBackgroundResource(R.drawable.side_bg_01);
                     fanhui2.setTextColor(Color.parseColor("#22b3e9"));
                     but_chuqi.setVisibility(View.VISIBLE);
                     bangzhan.setVisibility(View.VISIBLE);
                     but_chuqi.setTextColor(Color.parseColor("#ffffff"));
                     bangzhan.setTextColor(Color.parseColor("#ffffff"));
                     but_chuqi.setBackgroundColor(Color.parseColor("#22b3e9"));
                     bangzhan.setBackgroundColor(Color.parseColor("#22b3e9"));
                 }
                 ++i;
                 Intent intent=new Intent(FieldRainActivity.this,PumpstationActivity.class);
                 startActivity(intent);
                 finish();
                 break;
         }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINCITYJSON
                && response instanceof RainCityJsonResponse) {
           mRainCityJson= (RainCityJsonResponse) response;
            if("00000".equals(mRainCityJson.getErrorCode())){
                    getNearbyShop3();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFOR
                && response instanceof PumpForResponse) {
             mPumpFor= (PumpForResponse) response;
            if("00000".equals(mPumpFor.getErrorCode())){
                getNearbyShop();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINPUMPFORCQ
                && response instanceof PumpForCqResponse) {
            mPumpForCq= (PumpForCqResponse) response;
            if("00000".equals( mPumpForCq.getErrorCode())){
                getNearbyShop2();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINCITYTOP
                && response instanceof RainCityResponse) {
            mRainCityTop= (RainCityResponse) response;
            if("00000".equals(mRainCityTop.getErrorCode())){
                    /**设置适配器*/
                mMyCityAdapter=new MyCityAdapter();
                minListView.setAdapter(mMyCityAdapter);
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
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
            }else if("0".equals( mRainCityJson.getData().getYlMap().get(i).getLevel())){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap2);
                mBaiduMap.addOverlay(option);
            }
            getZaiw(point, mPumpForCq.getData().getYlMap().get(i).getUnitName()+
                    (mPumpForCq.getData().getYlMap().get(i).getCqcValue()/100)+mPumpForCq.getData().getYlMap().get(i).getCqcElevation()+"m/"+
                    mPumpForCq.getData().getYlMap().get(i).getCqcHighest()+"m/"+Math.round((mPumpForCq.getData().getYlMap().get(i).getCqcValue()/100)/(mPumpForCq.getData().getYlMap().get(i).getCqcHighest()-mPumpForCq.getData().getYlMap().get(i).getCqcElevation()*1000))/100);

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
    public void getNearbyShop() {
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
    public void getNearbyShop3() {
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
        for (int i = 0; i < mRainCityJson.getData().getYlMap().size(); i++) {
            String arr[]= mRainCityJson.getData().getYlMap().get(i).getPoint().split(":");
            point = new LatLng(Double.parseDouble(arr[1]),Double.parseDouble(arr[0]));
            if("4".equals( mRainCityJson.getData().getYlMap().get(i).getLevel())){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap4);
                mBaiduMap.addOverlay(option);
            }else if("3".equals( mRainCityJson.getData().getYlMap().get(i).getLevel())){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap3);
                mBaiduMap.addOverlay(option);
            }else if("2".equals( mRainCityJson.getData().getYlMap().get(i).getLevel())){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
                mBaiduMap.addOverlay(option);
            }else if("1".equals( mRainCityJson.getData().getYlMap().get(i).getLevel())){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap2);
                mBaiduMap.addOverlay(option);
            }else if("0".equals( mRainCityJson.getData().getYlMap().get(i).getLevel())){
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap2);
                mBaiduMap.addOverlay(option);
            }
            getZaiw(point, mRainCityJson.getData().getYlMap().get(i).getUnitName()+
                    mRainCityJson.getData().getYlMap().get(i).getValue());

        }
    }
    private ListView initListView(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTRAINCITYTOP, prams,
                RainCityResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTRAINCITYTOP, this, false).setTag(this);
        return mListViews;
    }
    class MyCityAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mRainCityTop.getData().getYlMap().size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(FieldRainActivity.this, R.layout.item_search2, null);
                holder.paiming = (TextView) convertView.findViewById(R.id.paiming);
                holder.rain_name = (TextView) convertView.findViewById(R.id.rain_name);
                holder.rain_value = (TextView) convertView.findViewById(R.id.rain_value);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.paiming.setText("排行");
                holder.rain_name.setText("名称");
                holder.rain_value.setText("雨量");
                holder.paiming.setTextColor(Color.parseColor("#000000"));
                holder.rain_name.setTextColor(Color.parseColor("#000000"));
                holder.rain_value.setTextColor(Color.parseColor("#000000"));
            }
            else {
                holder.paiming.setText(position+"");
                holder.rain_name.setText(mRainCityTop.getData().getYlMap().get(position - 1).getUnitName());
                holder.rain_value.setText(mRainCityTop.getData().getYlMap().get(position - 1).getValue());
            }
            return convertView;
        }
        class ViewHolder{
            TextView paiming,rain_name,rain_value;
        }
    }
    public void onEvent(EventNormSelect event){
           this.event=event;
    }
    private Runnable mRunnable = new Runnable() {
        public void run() {
            // 弹出PopupWindow的具体代码
            if(event!=null){
                /**弹出一个pup,在toolbar的下方*/
                if(!event.isFlag()) {
                    minListView = initListView();
                    PopupWindowUtils.showPopupWindow3(minListView, toolbar);
                }
            }
        }
    };

}
