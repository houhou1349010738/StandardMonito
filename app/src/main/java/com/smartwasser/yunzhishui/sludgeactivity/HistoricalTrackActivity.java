package com.smartwasser.yunzhishui.sludgeactivity;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.CarJanKanResponse;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.LishiguijiResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.service.LocationService;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/18 0018.
 */
public class HistoricalTrackActivity extends Activity implements HttpLoader.ResponseListener{
    private MapView  mMapView=null;
    private BaiduMap mBaiduMap;
    private ImageButton button_fan,image_add,image_serc;
    private TextView tv_toolbar_centext,tv_toolbar_zhu;
    private EventSearchResponse even;
    private Timer timer;
    public LocationService locationService;
    public Vibrator mVibrator;
    private Button jiqnk;
    private Button quxiaojiank;
    private int c=0;
    private  LishiguijiResponse  mLishi;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_historical);
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
        jiqnk= (Button) findViewById(R.id.jiqnk);
        mMapView = (MapView) findViewById(R.id.mapView);
        quxiaojiank= (Button) findViewById(R.id.quxiaojiank);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        EventBus.getDefault().registerSticky(this);
        initData();
    }
    private void initData() {
        tv_toolbar_centext.setText("运输管理");
        tv_toolbar_zhu.setText("污泥运输");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
               /**请求网络*/
        /**网络请求*/
        HashMap<String, Object> params = new HashMap<>();
        params.put("transportTaskId", even.getGuijiId());
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTLSGJ,params,LishiguijiResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTLSGJ, this, false).setTag(this);
        jiqnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Refresh();
            }
        });
        quxiaojiank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void onEvent(EventSearchResponse event){
        even=event;
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTLSGJ
                && response instanceof LishiguijiResponse) {
            mLishi = (LishiguijiResponse) response;
            addCustomElementsDemo();
            addCustomElementsDemo2();

        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
    }
    List<LatLng> points =null;
    Polyline mMarkerPolyLine=null;
    Marker mMarkerA,MarkerB,MarkerC;
    public void Refresh(){
        final Handler handler = new Handler(){
            public void handleMessage(Message msg) {
                    if(c<=mLishi.getData().getJson().size()){
                    LatLng p1 = new LatLng(mLishi.getData().getJson().get(c).getLat()+Double.parseDouble(mLishi.getData().getLatOffset()),mLishi.getData().getJson().get(c).getLng()+Double.parseDouble(mLishi.getData().getLngOffset()));
                    mMarkerA.setPosition(p1);
                    }
            }
        };
        TimerTask task = new TimerTask(){
            public void run() {
                Message message = new Message();
                message.what = 1;
                ++c;
                handler.sendMessage(message);
            }
        };

        timer = new Timer(true);
        timer.schedule(task, 1000,500);
    }
    /**
     * 添加点、线、多边形、圆、文字  aj
     */
    public void addCustomElementsDemo() {
        LatLng p;
        LatLng p1 = null;
        LatLng p2 = null;
        points = new ArrayList<LatLng>();
        if (mLishi.getData().getJson()==null){
            Toast.makeText(HistoricalTrackActivity.this, "数据为空,无法查看轨迹", Toast.LENGTH_SHORT).show();
            return;
        }
            for (int i = 0; i < mLishi.getData().getJson().size(); i++) {
                p = new LatLng(mLishi.getData().getJson().get(i).getLat() + Double.parseDouble(mLishi.getData().getLatOffset()), mLishi.getData().getJson().get(i).getLng() + Double.parseDouble(mLishi.getData().getLngOffset()));
                points.add(p);
                if (i == 0) {
                    p1 = new LatLng(mLishi.getData().getJson().get(0).getLat() + Double.parseDouble(mLishi.getData().getLatOffset()), mLishi.getData().getJson().get(0).getLng() + Double.parseDouble(mLishi.getData().getLngOffset()));
                    points.add(p1);
                }
                if (i == mLishi.getData().getJson().size() - 1) {
                    p2 = new LatLng(mLishi.getData().getJson().get(i).getLat() + Double.parseDouble(mLishi.getData().getLatOffset()), mLishi.getData().getJson().get(i).getLng() + Double.parseDouble(mLishi.getData().getLngOffset()));
                    points.add(p2);
                }
            }

        OverlayOptions ooPolyline = new PolylineOptions().width(12)
                .color(0xAAFF0000).points(points);
        mMarkerPolyLine = (Polyline) mBaiduMap.addOverlay(ooPolyline);
        BitmapDescriptor bda = BitmapDescriptorFactory
                .fromResource(R.drawable.car1);
        BitmapDescriptor bdA= BitmapDescriptorFactory
                .fromResource(R.drawable.content_msg_img_01);
        BitmapDescriptor bdB= BitmapDescriptorFactory
                .fromResource(R.drawable.content_msg_img_02);
        OverlayOptions ooA = new MarkerOptions().position(p1).icon(bdA);
        OverlayOptions ooA2 = new MarkerOptions().position(p2).icon(bdB);
        OverlayOptions ooA3 = new MarkerOptions().position(p1).icon(bda);
        mMarkerA = (Marker) (mBaiduMap.addOverlay(ooA3));
        MarkerB= (Marker)(mBaiduMap.addOverlay(ooA2));
        MarkerC= (Marker) (mBaiduMap.addOverlay(ooA));
    }
   /* *
     * 添加点、线、多边形、圆、文字  aj*/
    public void addCustomElementsDemo2() {
        LatLng p;
        points = new ArrayList<LatLng>();
        // 添加折线
        if (mLishi.getData().getPalingPointsJson()==null){
            Toast.makeText(HistoricalTrackActivity.this, "数据为空,无法查看轨迹", Toast.LENGTH_SHORT).show();
            return;
            }
            String s1[]= mLishi .getData().getPalingPointsJson().getPoint().split(",");
            for(int j=0;j<s1.length;j++){
                String a1[]=s1[j].split(":");
                p = new LatLng(Double.parseDouble(a1[1]),Double.parseDouble(a1[0]));
                points.add(p);
            }
            OverlayOptions polygonOption = new PolygonOptions().points(points)
                    .stroke(new Stroke(5,0xAA00FF00))
                    .fillColor(0xAAFFFF00);
            //在地图上添加多边形Option，用于显示
            mBaiduMap.addOverlay(polygonOption);
            points.clear();
    }
}
