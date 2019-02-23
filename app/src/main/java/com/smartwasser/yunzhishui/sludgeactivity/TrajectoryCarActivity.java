package com.smartwasser.yunzhishui.sludgeactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.CarResponse;
import com.smartwasser.yunzhishui.bean.CarZuResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.TrajectoryResponse;
import com.smartwasser.yunzhishui.bean.TransportResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogSludgeTimeUtils;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;
import com.smartwasser.yunzhishui.utils.TimeUtils2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/16 0016.
 */
public class TrajectoryCarActivity extends BaseActivity implements HttpLoader.ResponseListener, View.OnClickListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ImageButton image_add,image_serc,button_fan,but_chezu,
            but_car_starttime,but_car_endtime,but_date;
    private EditText chehao,chezu,ed_start_dates,ed_end_dates,ed_kaijie_dates;
    private Button but_chaxun;
    private GridView list_car;
    private  CarZuResponse mCarZu;
    private MyCarzuAdapter mCarAdapter;
    private ListView minlistView;
    private  TrajectoryResponse mCar;
    private MyAdapter myAdapter;
    private Button queren,quxiao;
    private DialogSludgeTimeUtils dialogs=new DialogSludgeTimeUtils(this);
    private PopListViewUtils plu=new PopListViewUtils(this);
    private ListView minlistView2;
    private EventNormSelect ent=new EventNormSelect();
    private String ids;
    private List<String> listName=new ArrayList<>();

    @Override
    protected int initContentView() {
        return R.layout.activity_trajectory_car;
    }
    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        but_chezu= (ImageButton) findViewById(R.id.but_chezu);
        but_car_starttime= (ImageButton) findViewById(R.id. but_car_starttime);
        but_car_endtime= (ImageButton) findViewById(R.id.but_car_endtime);
        but_date= (ImageButton) findViewById(R.id.but_date);
        chehao= (EditText) findViewById(R.id.chehao);
        chezu= (EditText) findViewById(R.id.chezu);
        ed_start_dates= (EditText) findViewById(R.id.ed_start_dates);
        ed_end_dates= (EditText) findViewById(R.id.ed_end_dates);
        ed_kaijie_dates= (EditText) findViewById(R.id.ed_kaijie_dates);
        but_chaxun= (Button) findViewById(R.id.but_chaxun);
        list_car= (GridView) findViewById(R.id.list_car);
        queren= (Button) findViewById(R.id.queren);
        quxiao= (Button) findViewById(R.id.quxiao);
    }
    @Override
    protected void initListener() {
        button_fan.setOnClickListener(this);
        chezu.setOnClickListener(this);
        ed_start_dates.setOnClickListener(this);
        ed_end_dates.setOnClickListener(this);
        ed_kaijie_dates.setOnClickListener(this);
        but_chaxun.setOnClickListener(this);
        queren.setOnClickListener(this);
        quxiao.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar_zhu.setText("污泥运输");
        tv_toolbar_centext.setText("轨迹重现");
        chezu.setText("全部");
        button_fan.setBackgroundResource(R.drawable.fanhu);
        image_add.setVisibility(View.GONE);
        image_serc.setVisibility(View.GONE);
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTGJCX, prams,
                TrajectoryResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGJCX,TrajectoryCarActivity.this, false).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGROUP
                && response instanceof CarZuResponse) {
            mCarZu=(CarZuResponse)response;
            mCarAdapter=new MyCarzuAdapter();
            minlistView.setAdapter(mCarAdapter);
            minlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            /***请求网络*/
                    ids=mCarZu.getData().getGroupInfo().get(position).getId();
                    listName.clear();
                    HashMap<String, Object> prams = new HashMap<>();
                    HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTGJCX, prams,
                            TrajectoryResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGJCX,TrajectoryCarActivity.this, false).setTag(this);
                    chezu.setText(mCarZu.getData().getGroupInfo().get(position).getText());
                    PopupWindowUtils.closePopupWindow();
                }
            });
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGJCX
                && response instanceof  TrajectoryResponse){
            mCar=( TrajectoryResponse)response;
            String  che= chezu.getText().toString();
            if("全部".equals(che)){
                for (int i = 0; i < mCar.getData().getVehicleInfosMap().size(); i++) {
                    listName.add(mCar.getData().getVehicleInfosMap().get(i).getVehicleNo());
                }
            }else if(listName.size()==0) {
                for (int i = 0; i < mCar.getData().getVehicleInfosMap().size(); i++) {
                    if (ids!=null){
                        if (ids.equals(mCar.getData().getVehicleInfosMap().get(i).getGroupId())) {
                            listName.add(mCar.getData().getVehicleInfosMap().get(i).getVehicleNo());
                        }
                    }
                }
            }
            myAdapter =new MyAdapter();
            list_car.setAdapter(myAdapter);
            list_car.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    chehao.setText(listName.get(position));
                }
            });
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. button_fan:
                finish();
                break;
            case R.id.ed_start_dates:
                dialogs.show(ed_start_dates);
                dialogs.showTime();
                break;
            case R.id. ed_end_dates:
                /**结束时间*/
                dialogs.show(ed_end_dates);
                dialogs.showTime();
                break;
            case R.id.ed_kaijie_dates:
                /**快捷时间*/
                // 初始化ListView控件和里边的数据
                minlistView2= plu.initListView4();
                final TimeUtils2 time2=new TimeUtils2();
                PopupWindowUtils.showPopupWindow(minlistView2,ed_kaijie_dates);
                minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_start_dates.setText(time2.getTimeDate(position+1));
                        ed_end_dates.setText(time2.getTimeDate(0));
                        ed_kaijie_dates.setText(plu.mListView4.get(position));
                        PopupWindowUtils.closePopupWindow();
                    }
                });
                break;
            case R.id.but_chaxun:
                listName.clear();
                String che=chehao.getText().toString();
                if(che!=null&&!"null".equals(che)&&!"".equals(che)){
                     listName.add(che);
                }
                HashMap<String, Object> prams2 = new HashMap<>();
                HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTGJCX, prams2,
                        TrajectoryResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGJCX,TrajectoryCarActivity.this, false).setTag(this);
                break;
            case R.id.chezu:
                minlistView = initListView();
                PopupWindowUtils.showPopupWindow(minlistView, chezu);
                break;
            case R.id.queren:
                /**跳转到轨迹页,并带上数据*/
                String che2=chehao.getText().toString();
                String start=ed_start_dates.getText().toString();
                String end=ed_end_dates.getText().toString();
                ent.setCarName(che2);
                ent.setCarStartDate(start);
                ent.setCarEndDate(end);
                EventBus.getDefault().postSticky(ent);
                Intent intent=new Intent(TrajectoryCarActivity.this,TrajectoryActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.quxiao:
                finish();
                break;
        }
    }
    class MyCarzuAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mCarZu.getData().getGroupInfo().size();
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
                convertView = View.inflate(TrajectoryCarActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mCarZu.getData().getGroupInfo().get(position).getText());
            return convertView;
        }
    }
    class ViewHolder {
        TextView v_listview_item_number,tv_car;
    }
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTGROUP, prams,
                CarZuResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTGROUP, this, false).setTag(this);
        return mListViews;
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return   listName.size();
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
                convertView=View.inflate(TrajectoryCarActivity.this,R.layout.item_carstime,null);
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
}
