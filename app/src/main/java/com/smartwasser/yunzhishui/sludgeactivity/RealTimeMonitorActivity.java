package com.smartwasser.yunzhishui.sludgeactivity;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

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
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.RealTimeMainResponse;
import com.smartwasser.yunzhishui.bean.RealTimeMonitorResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.service.LocationService;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.GetScreenParam;

import org.seny.android.utils.MyToast;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/14 0014.
 */
public class RealTimeMonitorActivity extends Activity implements HttpLoader.ResponseListener,View.OnClickListener{
    MapView mMapView = null;
    BaiduMap mBaiduMap;
    private LocationService locService;
    private TextView tv_toolbar_centext,tv_toolbar_zhu;
    private ImageButton button_fan,image_add,image_serc;
    public LocationService locationService;
    private int i=1,n=1,m=1;
    public Vibrator mVibrator;
    private TextView image_lukuang,image_ditu,image_weixing,image_sanwei
            ,yunxing,dengdai;
    private  RealTimeMainResponse  mRealMain;
    private  RealTimeMonitorResponse mRealTime;
    private  Timer timer;
    private int d=0,y=0;
    private BitmapDescriptor bitmap3= null;
    private BitmapDescriptor bitmap4= null;
    private EventNormSelect ece=new EventNormSelect();
    private PopupWindow pw;
    private EventSearchResponse event;
    private ImageButton sousu_chepai;
    private EditText sousou;
    private  double d1=0.0, d2=0.0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_realtimemonitor);
        image_lukuang= (TextView) findViewById(R.id.image_lukuang);
        image_ditu= (TextView) findViewById(R.id.image_ditu);
        image_weixing= (TextView) findViewById(R.id.image_weixing);
        image_sanwei= (TextView) findViewById(R.id.image_sanwei);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        sousu_chepai= (ImageButton) findViewById(R.id.sousu_chepai);
        sousou= (EditText) findViewById(R.id.sousuo);
        image_serc.setVisibility(View.GONE);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_add.setVisibility(View.GONE);
        dengdai= (TextView) findViewById(R.id.dengdai);
        yunxing= (TextView) findViewById(R.id.yunxing);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        EventBus.getDefault().registerSticky(this);
        initData();
    }
    private void initData() {
        tv_toolbar_centext.setText("实时监控");
        tv_toolbar_zhu.setText("污泥运输");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
           /**网络请求*/
        HashMap<String, Object> params = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTMAIN, params, RealTimeMainResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMAIN,this,false).setTag(this);
        /**网络请求*/
        HashMap<String, Object> params2 = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTREALTIME, params2, RealTimeMonitorResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTREALTIME,this,false).setTag(this);
         timer = new Timer();
         timer.schedule(new TimerTask() {
             @Override
             public void run() {
                 /**网络请求*/
                 d = 0;
                 y = 0;
                 HashMap<String, Object> params2 = new HashMap<>();
                 HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTREALTIME, params2, RealTimeMonitorResponse.class,
                         ConstantsYunZhiShui.REQUEST_CODE_TRANPORTREALTIME, RealTimeMonitorActivity.this, false).setTag(this);
             }
         }, 2000, 3000);
        dengdai.setOnClickListener(this);
        yunxing.setOnClickListener(this);
        image_lukuang.setOnClickListener(this);
        image_ditu.setOnClickListener(this);
        image_weixing.setOnClickListener(this);
        image_sanwei.setOnClickListener(this);

    }
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
                    getNearbyShop();
                    if(event==null/*&&(d1==0.0&&d2==0.0)*/){
                        point = new LatLng(location.getLatitude(), location.getLongitude());
                       // MaintelsLogUtils.outLog(location.getLatitude() + "_____" + location.getLongitude() + "");
                        // 构建Marker图标
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_openmap_mark2);
//                    LatLng point = new LatLng(location.getLatitude(), location.getLongitude());
                    }else /*if(event!=null&&(d1==0.0&&d2==0.0))*/{
                        point = new LatLng(event.getLat()+  0.007288486844,event.getLng()+0.01277149072);
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.car1);
                    }/*else if(d1!=0.0||d2!=0.0){
                        point = new LatLng(d1+0.007288486844,d2+0.01277149072);
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.car1);
                    }*/
                    // 构建MarkerOption，用于在地图上添加Marker
                    OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
                    // 在地图上添加Marker，并显示
                    mBaiduMap.addOverlay(option);
                    //设置地图新中心点
                    mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(point));
                    //定位的坐标并显示在地图中心，为了后面的标注物效果我们是用固定值
                    mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            final String title = marker.getTitle();
                            View vi=null;
                            BitmapDescriptor bitmap= marker.getIcon();
                            if(bitmap.equals(bitmap3)||
                                    bitmap.equals(bitmap4)){
                                vi= View.inflate(RealTimeMonitorActivity.this,
                                        R.layout.pop_layout2, null);
                                show(vi,marker);
                                final LatLng ll = marker.getPosition();
                                Point p = mBaiduMap.getProjection().toScreenLocation(ll);
                                p.y +=(int)(GetScreenParam.getScreenHeight(RealTimeMonitorActivity.this)*0.045);
                                p.x -=(int)(GetScreenParam.getScreenWidth(RealTimeMonitorActivity.this)*0.18);
                                TextView location_tips = (TextView) vi.findViewById(R.id.location_tips);
                                if (title != null) {
                                    location_tips.setText(title);
                                    pw.showAtLocation(mMapView, Gravity.LEFT + Gravity.TOP, p.x, p.y);
                                    // Toast.makeText(RealTimeMonitorActivity.this, title, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RealTimeMonitorActivity.this, "未知位置", Toast.LENGTH_SHORT).show();
                                }
                            }else{

                                vi= View.inflate(RealTimeMonitorActivity.this,
                                        R.layout.pop_layout, null);
                                Button but= (Button) vi.findViewById(R.id.jiankong);
                                but.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ece.setTitleCarName(title);
                                        EventBus.getDefault().postSticky(ece);
                                        Intent intent=new Intent(RealTimeMonitorActivity.this,CarMonitorActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                show(vi,marker);
                                final LatLng ll = marker.getPosition();
                                Point p = mBaiduMap.getProjection().toScreenLocation(ll);
                                p.y -=(int)(GetScreenParam.getScreenHeight(RealTimeMonitorActivity.this)*0.1042);
                                p.x -=(int)(GetScreenParam.getScreenWidth(RealTimeMonitorActivity.this)*0.186);
                                TextView location_tips = (TextView) vi.findViewById(R.id.location_tips);
                                if (title != null) {
                                    location_tips.setText(title);
                                    pw.showAtLocation(mMapView, Gravity.LEFT + Gravity.TOP, p.x, p.y);
                                    // Toast.makeText(RealTimeMonitorActivity.this, title, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RealTimeMonitorActivity.this, "未知位置", Toast.LENGTH_SHORT).show();
                                }
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
    /**
     * 根据经纬度获取附近的商铺并显示出来
     */

    private void getNearbyShop() {
        // 构建Marker图标
        BitmapDescriptor bitmap = null;
        BitmapDescriptor  bitmap2 = null;

        bitmap2 = BitmapDescriptorFactory.fromResource(R.drawable.car1);
        bitmap= BitmapDescriptorFactory.fromResource(R.drawable.car2);
        bitmap3=BitmapDescriptorFactory.fromResource(R.drawable.icon_openmap_mark);
        bitmap4=BitmapDescriptorFactory.fromResource(R.drawable.icon_openmap_focuse_mark);
        LatLng point =null;
        /*double[][] testNum = {{34.826574, 113.569846}, {34.825322, 113.568809}, {34.825129, 113.570525}, {34.825163, 113.567695}, {34.826759, 113.570147}, {113.571935, 34.823474}, {34.823959, 113.575093}};
        String[] shopName = {"no Name","万州烤鱼","君荷酒店","湘香烤鱼","圣禧牛肉汤","中国工商银行","莲花公园"};*/
        Bundle bundle = new Bundle();
            for (int i = 0; i < mRealTime.getData().getRealTimeData().size(); i++) {
                if(mRealTime.getData().getRealTimeData().get(i).isWaiting()){
                    bundle.clear();
                    bundle.putString("shopName", mRealTime.getData().getRealTimeData().get(i).getVehicleNo());
                     point = new LatLng(mRealTime.getData().getRealTimeData().get(i).getLat()+ 0.007288486844, mRealTime.getData().getRealTimeData().get(i).getLng()+0.01277149072);
                    OverlayOptions option = new MarkerOptions().position(point).icon(bitmap).title(mRealTime.getData().getRealTimeData().get(i).getVehicleNo());
                    mBaiduMap.addOverlay(option);
                    getZaiw(point,mRealTime.getData().getRealTimeData().get(i).getVehicleNo());
                }else{
                    bundle.clear();
                    bundle.putString("shopName", mRealTime.getData().getRealTimeData().get(i).getVehicleNo());
                    point = new LatLng(mRealTime.getData().getRealTimeData().get(i).getLat()+0.007288486844, mRealTime.getData().getRealTimeData().get(i).getLng()+0.01277149072);
                    OverlayOptions option = new MarkerOptions().position(point).icon(bitmap2).title(mRealTime.getData().getRealTimeData().get(i).getVehicleNo());
                    mBaiduMap.addOverlay(option);
                    getZaiw(point,mRealTime.getData().getRealTimeData().get(i).getVehicleNo());
                }

            }
        double a1;
        double a2;
        LatLng point1=null;
        for(int j=0;j<mRealMain.getData().getWeightList().size();j++){
            bundle.clear();
            if(mRealMain.getData().getWeightList().get(j).getWeightPoint()!=null){
                bundle.putString("shopName", mRealMain.getData().getWeightList().get(j).getWeightPoint().getName());
            }
            String arr[]=mRealMain.getData().getWeightList().get(j).getWeightPointRef().getWeightPoint().split(":");
            a1=Double.parseDouble(arr[0]);
            a2=Double.parseDouble(arr[1]);
            point1 = new LatLng(a2+0.007288486844,a1+0.01277149072);
            OverlayOptions option = new MarkerOptions().position(point1).icon(bitmap3);
            if(mRealMain.getData().getWeightList().get(j).getWeightPoint()!=null){
                option = new MarkerOptions().position(point1).icon(bitmap3).title(mRealMain.getData().getWeightList().get(j).getWeightPoint().getName());
            }
            mBaiduMap.addOverlay(option);
        }
        for(int n=0;n<mRealMain.getData().getPalingInfoList().size();n++){
            bundle.clear();
            bundle.putString("shopName", mRealMain.getData().getPalingInfoList().get(n).getMud().getPlaceName());
            String s[]=mRealMain.getData().getPalingInfoList().get(n).getPaling().getPoint().split(",");
            for(int i=0;i<s.length;i++){
                 String a[]=s[0].split(":");
                 LatLng point2 = new LatLng(Double.parseDouble(a[1])+ 0.007288486844,Double.parseDouble(a[0])+0.01277149072);
                 OverlayOptions option = new MarkerOptions().position(point2).icon(bitmap4);
                if(mRealMain.getData().getPalingInfoList().get(n).getMud().getPlaceName()!=null){
                   option = new MarkerOptions().position(point2).icon(bitmap4).title(mRealMain.getData().getPalingInfoList().get(n).getMud().getPlaceName());
                }
                mBaiduMap.addOverlay(option);
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        locService.unregisterListener(listener);
        locService.stop();
        mMapView.onDestroy();
        timer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
       /* btnLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mBaiduMap != null) {
                    mBaiduMap.clear();
                }
                doLocation();
            }
        });*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMAIN
                && response instanceof RealTimeMainResponse) {
             mRealMain = (RealTimeMainResponse) response;
             if("00000".equals( mRealMain.getErrorCode())){
                     doLocation();
             }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTREALTIME
                && response instanceof RealTimeMonitorResponse) {
            mRealTime = (RealTimeMonitorResponse) response;
            if("00000".equals( mRealTime.getErrorCode())){
                sousu_chepai.setOnClickListener(this);
            }
            for(int i=0;i< mRealTime.getData().getRealTimeData().size();i++){
                boolean s= mRealTime.getData().getRealTimeData().get(i).isWaiting();
                if(s){
                    /**等待*/
                   ++d;
                }else{
                    /**运行*/
                   ++y;
                }
            }
            dengdai.setText("等待车辆:"+d);
            yunxing.setText("运行车辆:"+y);
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventSearchResponse edu){
        event=edu;
    }
    private void getZaiw(LatLng point,String s){
        //构建文字Option对象，用于在地图上添加文字
        OverlayOptions textOption = new TextOptions()
                .bgColor(0xAA000000)
                .fontSize(24)
                .fontColor(0xFFFFFFFF)
                .text(s)
                .rotate(0)
                .position(point);
        //在地图上添加该文字对象并显示
        mBaiduMap.addOverlay(textOption);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. image_lukuang:
                mMapView.refreshDrawableState();
                if (i%2!=0) {
                    mBaiduMap.setTrafficEnabled(true);
                    locService.stop();
                    /**弹出popwindow*/
                }else{
                    mBaiduMap.setTrafficEnabled(false);
                    locService.start();
                }
                i++;
              break;
            case R.id.image_ditu:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                mBaiduMap.setTrafficEnabled(false);
                mBaiduMap.showMapPoi(true);
                locService.start();
            break;
            case R.id.image_weixing:
                if (n%2!=0) {
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                    locService.stop();
                    /**弹出popwindow*/
                }else{
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                    mBaiduMap.showMapPoi(true);
                    locService.start();
                }
                n++;
            break;
            case R.id.image_sanwei:
                if (m%2!=0) {
                    mBaiduMap.showMapPoi(true);
                    mBaiduMap.setTrafficEnabled(false);
                    locService.stop();
                    /**弹出popwindow*/
                }else{
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                    mBaiduMap.setTrafficEnabled(false);
                    mBaiduMap.showMapPoi(false);
                    locService.start();
                }
                m++;
            break;
            case R.id.yunxing:
             ece.setStateCar(false);
            EventBus.getDefault().postSticky(ece);
            Intent intent = new Intent(RealTimeMonitorActivity.this, RealTimeCarActivity.class);
            startActivity(intent);
            break;
            case R.id.dengdai:
                ece.setStateCar(true);
                EventBus.getDefault().postSticky(ece);
                Intent intent2=new Intent(RealTimeMonitorActivity.this,RealTimeCarActivity.class);
                startActivity(intent2);
                break;
            case R.id.sousu_chepai:
                String  sou=sousou.getText().toString().trim();
                if("".equals(sou)||sou==null||"null".equals(sou)){
                    Toast.makeText(RealTimeMonitorActivity.this, "请输入正确的车牌", Toast.LENGTH_SHORT).show();
                    return;
                }
                /**循环遍历车牌,如果等于输入车牌,则将其定位*/
               for(int i=0;i<mRealTime.getData().getRealTimeData().size();i++) {
                   if(sou.equals(mRealTime.getData().getRealTimeData().get(i).getVehicleNo())){
                               /**获得当前的经纬度*/
                       d1=mRealTime.getData().getRealTimeData().get(i).getLat();
                       d2=mRealTime.getData().getRealTimeData().get(i).getLng();
                   }
               }
                if(d1==0.0&&d2==0.0){
                    Toast.makeText(RealTimeMonitorActivity.this, "没有您要搜索的车辆", Toast.LENGTH_SHORT).show();
                    return;
                }
                doLocation();
                break;
        }
    }
    private void show(View vi,Marker marker){
        if (pw != null) {
            pw.dismiss();
            pw = null;
        }
        pw = new PopupWindow(vi, -2, -2);
        pw.setBackgroundDrawable(new ColorDrawable());
        ScaleAnimation sa = new ScaleAnimation(0.3f, 1.0f, 0.3f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        sa.setDuration(500);
        vi.startAnimation(sa);
        pw.setOutsideTouchable(true);
    }
}
