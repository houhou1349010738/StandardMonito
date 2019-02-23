package com.smartwasser.yunzhishui.sludgeactivity;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.TrajectoryCarResponse;
import com.smartwasser.yunzhishui.bean.TrajectoryResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.service.LocationService;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/16 0016.
 */
public class TrajectoryActivity extends Activity implements HttpLoader.ResponseListener{
    private TextView tv_toolbar_centext,tv_toolbar_zhu;
    private ImageButton button_fan,image_add,image_serc;
    public LocationService locationService;
    public Vibrator mVibrator;
    // 地图相关
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private Button xuanze;
    private Button qingchu;
    private EventNormSelect enorm;
    private TrajectoryResponse  mTrajectory;
    private  TrajectoryCarResponse mTrajectoryCar;
    private  int c=0;
    private ImageButton bofang;
    private ImageButton zanting;
    private   Timer timer;
    private List<String> lists=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_trajectory);
        // 初始化地图
        mMapView = (MapView) findViewById(R.id.mMapview);
        mBaiduMap = mMapView.getMap();
              /**初始化ui*/
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_serc.setVisibility(View.GONE);
        xuanze= (Button) findViewById(R.id.xuanze);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_add= (ImageButton) findViewById(R.id.image_add);
        bofang= (ImageButton) findViewById(R.id.bofang);
        zanting=(ImageButton) findViewById(R.id.zanting);
        image_add.setVisibility(View.GONE);
        qingchu= (Button) findViewById(R.id.qingchu);
        EventBus.getDefault().registerSticky(this);
        initData();
    }
    private void initData() {
        tv_toolbar_centext.setText("轨迹重现");
        tv_toolbar_zhu.setText("污泥运输");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTGJCX, prams,
                TrajectoryResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGJCX, this, false).setTag(this);
        if(enorm!=null){
                       /**请求网络*/
            HashMap<String, Object> prams2 = new HashMap<>();
            prams2.put("start_time",enorm.getCarStartDate());
            prams2.put("end_time",enorm.getCarEndDate());
            prams2.put("selVehicleNo",enorm.getCarName());
            HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTMULTI,prams2,
                    TrajectoryCarResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMULTI, this, false).setTag(this);
        }
        View.OnClickListener clearListener = new View.OnClickListener() {
            public void onClick(View v) {
                clearClick();
            }
        };

        View.OnClickListener restListener = new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent=new Intent(TrajectoryActivity.this,TrajectoryCarActivity.class);
                    startActivity(intent);
            }
        };
        // 界面加载时添加绘制图层
        qingchu.setOnClickListener(clearListener);
        xuanze.setOnClickListener(restListener);
        bofang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enorm==null){
                    Toast.makeText(TrajectoryActivity.this, "请选择车辆", Toast.LENGTH_SHORT).show();
                }else{
                    Refresh();
                }
            }
        });
        zanting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( timer!=null){
                    timer.cancel();
                }
            }
        });
    }
    List<LatLng> points =null;
    Polyline mMarkerPolyLine=null;
    Marker mMarkerA,MarkerB,MarkerC;
    public void Refresh(){
        final Handler handler = new Handler(){
            public void handleMessage(Message msg) {
                if(c<=mTrajectoryCar.getData().getHistoryData().size()) {

                    LatLng p1 = new LatLng(mTrajectoryCar.getData().getHistoryData().get(c).getLat()+0.007288486844, mTrajectoryCar.getData().getHistoryData().get(c).getLng()+0.01277149072);
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
        timer.schedule(task, 1000,1000);
    }
    /**
     * 添加点、线、多边形、圆、文字  aj
     */
    public void addCustomElementsDemo() {
        LatLng p;
        LatLng p1=null;
        LatLng p2=null;
        points = new ArrayList<LatLng>();

        for(int i=0;i<mTrajectoryCar.getData().getHistoryData().size();i++){
            p= new LatLng(mTrajectoryCar.getData().getHistoryData().get(i).getLat()+0.007288486844,mTrajectoryCar.getData().getHistoryData().get(i).getLng()+0.01277149072);
            points.add(p);
            if(i==0){
                p1= new LatLng(mTrajectoryCar.getData().getHistoryData().get(0).getLat()+ 0.007288486844,mTrajectoryCar.getData().getHistoryData().get(0).getLng()+0.01277149072);
                points.add(p1);
            }
            if(i==mTrajectoryCar.getData().getHistoryData().size()-1){
                p2=new LatLng(mTrajectoryCar.getData().getHistoryData().get(i).getLat()+ 0.007288486844,mTrajectoryCar.getData().getHistoryData().get(i).getLng()+0.01277149072);
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
        MarkerB= (Marker) (mBaiduMap.addOverlay(ooA2));
        MarkerC= (Marker) (mBaiduMap.addOverlay(ooA));
    }
    /*public void resetClick() {
        // 添加绘制元素
        addCustomElementsDemo();
    }*/
    public void clearClick() {
        // 清除所有图层
        mMapView.getMap().clear();
    }
    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        lists.clear();
    }
   public void onEvent(EventNormSelect envent){
            enorm=envent;
   }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGJCX
                && response instanceof  TrajectoryResponse) {
             mTrajectory = (TrajectoryResponse) response;
            if("00000".equals(mTrajectory.getErrorCode())){
                addCustomElementsDemo2();
                getZHang();
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMULTI
                && response instanceof  TrajectoryCarResponse) {
            mTrajectoryCar = (TrajectoryCarResponse) response;
            if("00000".equals(mTrajectoryCar.getErrorCode())){
                addCustomElementsDemo();
            }

        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    /**
     * 添加点、线、多边形、圆、文字  aj
     */
    public void addCustomElementsDemo2() {
        LatLng p;
        points = new ArrayList<LatLng>();
        // 添加折线
        for (int i = 0; i <mTrajectory.getData().getPalings().size(); i++) {
            String s1[]= mTrajectory.getData().getPalings().get(i).getPoint().split(",");
            for(int j=0;j<s1.length;j++){
                String a1[]=s1[j].split(":");
                p = new LatLng(Double.parseDouble(a1[1])+ 0.007288486844,Double.parseDouble(a1[0])+0.01277149072);
                points.add(p);
            }
            OverlayOptions polygonOption = new PolygonOptions().points(points)
             .stroke(new Stroke(5, 0xAA00FF00))
                    .fillColor(0xAAFFFF00);
            //在地图上添加多边形Option，用于显示
            mBaiduMap.addOverlay(polygonOption);
            points.clear();
        }
    }
    public void getZHang(){
        //定义文字所显示的坐标点
        /**处置点的障碍物*/
         LatLng  point;

        for(int i=0;i<mTrajectory.getData().getPalings().size();i++) {
            String s[] = mTrajectory.getData().getPalings().get(i).getPoint().split(",");
            for (int j = 0; j < s.length; j++) {
                String arr[] = s[j].split(":");
                double a1 = Double.parseDouble(arr[0]);
                double a2 = Double.parseDouble(arr[1]);
                point = new LatLng(a2 + 0.007288486844, a1 + 0.01277149072);
                /**去掉重复的名字*/
                String ss = mTrajectory.getData().getPalings().get(i).getPlaceName();
                /*if (!lists.contains(ss)) {

                }*/
                //构建文字Option对象，用于在地图上添加文字
                if (mTrajectory.getData().getPalings().get(i).getPlaceName() != null && !"".equals(
                        mTrajectory.getData().getPalings().get(i).getPlaceName())) {
                    if(!lists.contains(ss)){
                    OverlayOptions textOption = new TextOptions()
                            .bgColor(0xAAFFFF00)
                            .fontSize(24)
                            .fontColor(0xFFFF00FF)
                            .text(ss)
                            .rotate(0)
                            .position(point);
                    //在地图上添加该文字对象并显示
                    mBaiduMap.addOverlay(textOption);
                    lists.add(ss);
                    }
                }
            }
        }
        }
}
