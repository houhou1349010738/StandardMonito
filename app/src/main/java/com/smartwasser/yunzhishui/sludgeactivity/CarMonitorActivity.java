package com.smartwasser.yunzhishui.sludgeactivity;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.CarJanKanResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.service.LocationService;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/18 0018.
 */
public class CarMonitorActivity extends Activity implements HttpLoader.ResponseListener{
     private  MapView mMapView = null;
     private  BaiduMap mBaiduMap;
     private ImageButton button_fan,image_add,image_serc;
     private TextView tv_toolbar_centext,tv_toolbar_zhu;
     public LocationService locationService;
     public Vibrator mVibrator;
     private LocationService locService;
     private EventNormSelect event;
     private Button jiqnk,quxiaojiank;
    private  Timer timer;
    private   CarJanKanResponse mJanKan;
    @Override
    public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         locationService = new LocationService(getApplicationContext());
         mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
         SDKInitializer.initialize(getApplicationContext());
         setContentView(R.layout.activity_carmonitor);
         initView();
    }
    private void initView() {
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_add.setVisibility(View.GONE);
        image_serc.setVisibility(View.GONE);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        mMapView = (MapView) findViewById(R.id.mapview);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        jiqnk= (Button) findViewById(R.id.jiqnk);
        quxiaojiank= (Button) findViewById(R.id.quxiaojiank);
        EventBus.getDefault().registerSticky(this);
        initData();
    }
    private void initData() {
        tv_toolbar_centext.setText("车辆监控");
        tv_toolbar_zhu.setText("污泥运输");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        jiqnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        /**网络请求*/
                        HashMap<String, Object> params = new HashMap<>();
                        params.put("vehicleNo", event.getTitleCarName());
                        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTCLJK, params, CarJanKanResponse.class,
                                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTCLJK, CarMonitorActivity.this, false).setTag(this);
                    }
                }, 2000, 1000);
            }
        });
        quxiaojiank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
            }
        });
    }
    /***
     * 接收定位结果消息，并显示在地图上
     */
    private Handler locHander = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            try {
                BDLocation location = msg.getData().getParcelable("loc");
                if (location != null) {
                    LatLng point=null;
                    BitmapDescriptor bitmap = null;
                        // getNearbyShop(location.getLatitude(), location.getLongitude());
                        point = new LatLng(mJanKan.getData().getRealTimeData().getLat()+ 0.007288486844,mJanKan.getData().getRealTimeData().getLng()+0.01277149072);
                        //Log.i("222222222",mJanKan.getData().getRealTimeData().getLat()+"------"+mJanKan.getData().getRealTimeData().getLng());
                        // MaintelsLogUtils.outLog(location.getLatitude() + "_____" + location.getLongitude() + "");
                        // 构建Marker图标
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.car1);
                         // 构建MarkerOption，用于在地图上添加Marker
                        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
                        // 在地图上添加Marker，并显示
                        mBaiduMap.addOverlay(option);
                    //构建文字Option对象，用于在地图上添加文字
                      OverlayOptions textOption = new TextOptions()
                            .bgColor(0xAA000000)
                            .fontSize(24)
                            .fontColor(0xFFFFFFFF)
                            .text(event.getTitleCarName())
                            .rotate(0)
                            .position(point);
                       //在地图上添加该文字对象并显示
                       mBaiduMap.addOverlay(textOption);
                         //设置地图新中心点
                        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(point));
                        //定位的坐标并显示在地图中心，为了后面的标注物效果我们是用固定值
                        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            final String title = marker.getTitle();
                           /* View vi = View.inflate(RealTimeMonitorActivity.this,
                                    R.layout.pop_layout, null);
                            TextView location_tips = (TextView) vi.findViewById(R.id.location_tips);
                            Button but= (Button) vi.findViewById(R.id.jiankong);
                            if (pw != null) {
                                pw.dismiss();
                                pw = null;
                            }*/
                            if (title != null) {
                                // Toast.makeText(RealTimeMonitorActivity.this, title, Toast.LENGTH_SHORT).show();
                            } else {
                                //Toast.makeText(RealTimeMonitorActivity.this, "未知位置", Toast.LENGTH_SHORT).show();
                            }

                            return false;
                        }
                    });
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    };
    /***
     * 初始化定位sdk，
     */
    /**
     * 进行定位
     */
    private void doLocation() {
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(16));
        locService =locationService;
        LocationClientOption mOption = locService.getDefaultLocationClientOption();
        mOption.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
        mOption.setCoorType("bd09ll");
        locService.setLocationOption(mOption);
        locService.registerListener(listener);
        locService.start();
    }
    /***
     * 定位结果回调，在此方法中处理定位结果
     */
    BDLocationListener listener = new BDLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation location) {

            if (location != null && (location.getLocType() == 161 || location.getLocType() == 66)) {
                Message locMsg = locHander.obtainMessage();
                Bundle locData = new Bundle();
                locData.putParcelable("loc", location);
                locMsg.setData(locData);
                locHander.sendMessage(locMsg);
            }
        }
    };
    public void onEvent(EventNormSelect ente){
             event=ente;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTCLJK
                && response instanceof CarJanKanResponse) {
             mJanKan = (CarJanKanResponse) response;
            // Log.i("22222222", mJanKan.getErrorCode());
            if("00000".equals( mJanKan.getErrorCode())){
                doLocation();
            }

        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {

    }
}
