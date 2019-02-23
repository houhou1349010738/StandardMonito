package com.smartwasser.yunzhishui.sludgeactivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.RealTimeMainResponse;
import com.smartwasser.yunzhishui.bean.RealTimeMonitorResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/16 0016.
 */
public class RealTimeCarActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private GridView grid_carzu;
    private GridView grid_car;
    private  RealTimeMainResponse  mRealMain;
    private  RealTimeMonitorResponse mRealTime;
    private MyCarZu zuAdapter;
    private List<Double> listLng=new ArrayList<>();
    private List<Double> listLat=new ArrayList<>();
    private List<String> listName=new ArrayList<>();
    private EventNormSelect mNorm;
    private String zuId;
    ViewHolder holder;
    private  int clickPosition=-1;
    private MyCarAdapter myCarAdapter;
    private EventSearchResponse ser=new EventSearchResponse();
    @Override
    protected int initContentView() {
        return R.layout.activity_realtimecar;
    }
    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        grid_carzu= (GridView) findViewById(R.id.grid_carzu);
        grid_car= (GridView) findViewById(R.id.grid_car);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        tv_toolbar.setText("实时监控");
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**网络请求*/
        HashMap<String, Object> params = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTMAIN, params, RealTimeMainResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMAIN,this,false).setTag(this);
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMAIN
                && response instanceof RealTimeMainResponse) {
              mRealMain = (RealTimeMainResponse) response;
              zuAdapter=new MyCarZu();
              grid_carzu.setAdapter(zuAdapter);
            grid_carzu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    /**网络请求*/
                    clickPosition=position;
                    zuAdapter.notifyDataSetChanged();
                    listName.clear();
                    zuId = mRealMain.getData().getGroups().get(position).getGroupId();
                    HashMap<String, Object> params2 = new HashMap<>();
                    HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTREALTIME, params2, RealTimeMonitorResponse.class,
                            ConstantsYunZhiShui.REQUEST_CODE_TRANPORTREALTIME, RealTimeCarActivity.this, false).setTag(this);
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTREALTIME
                && response instanceof RealTimeMonitorResponse) {
              mRealTime = (RealTimeMonitorResponse) response;
            for(int i=0;i< mRealTime.getData().getRealTimeData().size();i++){
                String name;
                //Log.i("2222222",mRealTime.getData()+""+mRealTime.getErrorCode());
                boolean s= mRealTime.getData().getRealTimeData().get(i).isWaiting();
                if(mNorm.isStateCar()){
                    /**等待*/
                    if(s){
                        if(zuId.equals(mRealTime.getData().getRealTimeData().get(i).getRtPio())){
                            name=mRealTime.getData().getRealTimeData().get(i).getVehicleNo();
                            listName.add(name);
                            listLng.add(mRealTime.getData().getRealTimeData().get(i).getLng());
                            listLat.add(mRealTime.getData().getRealTimeData().get(i).getLat());
                        }
                    }
                }else{
                    if(!s){
                        if(zuId.equals(mRealTime.getData().getRealTimeData().get(i).getRtPio())) {
                            name = mRealTime.getData().getRealTimeData().get(i).getVehicleNo();
                            listName.add(name);
                            listLng.add(mRealTime.getData().getRealTimeData().get(i).getLng());
                            listLat.add(mRealTime.getData().getRealTimeData().get(i).getLat());
                        }
                    }
                }
            }
            myCarAdapter=new MyCarAdapter();
            grid_car.setAdapter(myCarAdapter);
            grid_car.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      double d=listLng.get(position);
                      double f= listLat.get(position);
                      ser.setLng(d);
                      ser.setLat(f);
                      EventBus.getDefault().postSticky(ser);
                      Intent intent=new Intent(RealTimeCarActivity.this,RealTimeMonitorActivity.class);
                      startActivity(intent);
                }
            });
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventNormSelect msad){
        mNorm=msad;
    }
    class MyCarZu extends BaseAdapter{

        @Override
        public int getCount() {
            return mRealMain.getData().getGroups().size();
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
            if(convertView==null){
                convertView=View.inflate(RealTimeCarActivity.this,R.layout.item_realtimecar,null);
                holder=new ViewHolder();
                holder.radio= (RadioButton) convertView.findViewById(R.id.radio);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            final int p = position;
            holder.radio.setText(mRealMain.getData().getGroups().get(position).getGroupName());
            holder.radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        clickPosition=p;
                    }
                    else{
                        clickPosition = -1;
                    }
                    notifyDataSetChanged();
                }
            });
              if(clickPosition == position) {
                  holder.radio.setChecked(true);
              }else{
                  holder.radio.setChecked(false);
              }
            return convertView;
        }
    }
    class MyCarAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return listName.size();
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
            if(convertView==null){
                convertView=View.inflate(RealTimeCarActivity.this,R.layout.item_carstime,null);
                holder=new ViewHolder();
                holder.tv_car= (TextView) convertView.findViewById(R.id.tv_car);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_car.setText(listName.get(position));
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_car;
        RadioButton radio;
    }
}
