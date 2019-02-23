package com.smartwasser.yunzhishui.sludgeactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.CarResponse;
import com.smartwasser.yunzhishui.bean.CarZuResponse;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.WeightCzdResponse;
import com.smartwasser.yunzhishui.bean.WeightResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;
import java.util.Map;

import cn.smssdk.statistics.NewAppReceiver;
import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/13 0013.
 */
public class CarActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private TextView toolbar;
    private ImageButton but_image;
    private ListView list_car;
    private EditText chehao,chezu;
    private ImageButton but_chezu;
    private Button but_chaxun;
    private ListView minlistView;
    private MyCarzuAdapter mCarAdapter;
    private  CarZuResponse mCarZu;
    private MyAdapter myAdapter;
    private  CarResponse mCar;
    private int page=1;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private View loadMoreView;
    private EventSearchResponse esr=new EventSearchResponse();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return R.layout.activity_car;
    }
    @Override
    protected void initView() {
        toolbar= (TextView) findViewById(R.id.tv_toolbar);
        but_image= (ImageButton) findViewById(R.id.button_menu);
        but_image.setBackgroundResource(R.drawable.fanhu);
        list_car= (ListView) findViewById(R.id.list_car);
        chehao= (EditText) findViewById(R.id.chehao);
        chezu= (EditText) findViewById(R.id.chezu);
        but_chezu= (ImageButton) findViewById(R.id.but_chezu);
        but_chaxun= (Button) findViewById(R.id.but_chaxun);
        loadMoreView=View.inflate(this, R.layout.load_more, null);
        loadMoreButton = (ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        list_car.addFooterView(loadMoreView);

    }
    @Override
    protected void initListener() {
        chezu.setOnClickListener(this);
        but_chaxun.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        toolbar.setText("称重数据监控");
        but_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
                     /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("page",page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTCAR, prams,
                CarResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTCAR, this, false).setTag(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        list_car.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chezu:
                /**选择车组*/
                minlistView = initListView();
                PopupWindowUtils.showPopupWindow(minlistView,chezu);
            break;
            case R.id.but_chaxun:
                /**查询*/
                String a=chehao.getText().toString();
                if("".equals(a)||"null".equals(a)||a==null){
                    Toast.makeText(CarActivity.this, "请输入车牌号", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, Object> prams = new HashMap<>();
                String s2=chezu.getText().toString();
                String ids="";
                if(!"".equals(s2)&&!"null".equals(s2)&&s2!=null){
                    for(int i=0;i<mCarZu.getData().getGroupInfo().size();i++){
                        if(s2.equals(mCarZu.getData().getGroupInfo().get(i).getText())){
                            ids=mCarZu.getData().getGroupInfo().get(i).getId();
                        }
                    }
                    prams.put("groupId",ids);
                }
                prams.put("page",page);
                prams.put("vehicleNo",a);
                HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTCAR, prams,
                        CarResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTCAR, this, false).setTag(this);
            break;
        }
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
                    chezu.setText(mCarZu.getData().getGroupInfo().get(position).getText());
                    /**请求网络*/
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("page", page);
                    params.put("groupId", mCarZu.getData().getGroupInfo().get(position).getId());
                    String s=chehao.getText().toString();
                    if(!"".equals(s)&&!"null".equals(s)&&s!=null){
                        params.put("vehicleNo",s);
                    }
                    HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTCAR, params,
                            CarResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTCAR,CarActivity.this, false).setTag(this);
                    PopupWindowUtils.closePopupWindow();
                }
            });
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTCAR
                && response instanceof CarResponse){
                mCar=(CarResponse)response;
                myAdapter =new MyAdapter();
                list_car.setAdapter(myAdapter);
            list_car.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String cp= mCar.getData().getVehicleInfo().getRows().get(position).getVehicleNo();
                    esr.setCph(cp);
                    EventBus.getDefault().postSticky(esr);
                    Intent intent = new Intent(CarActivity.this, AddWeightActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mCar.getData().getVehicleInfo().getRows().size();
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
        public View getView(final int position, View convertView, final ViewGroup parent) {
            final ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(CarActivity.this,R.layout.item_cheliang,null);
                holder.tv_car_cph= (TextView) convertView.findViewById(R.id.tv_car_cph);
                holder.tv_chezuid= (TextView) convertView.findViewById(R.id.tv_chezuid);
                holder.car_clzt=(TextView) convertView.findViewById(R.id.car_clzt);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_car_cph.setText("车牌号:"+mCar.getData().getVehicleInfo().getRows().get(position).getVehicleNo());
            holder.tv_chezuid.setText("车组ID:"+mCar.getData().getVehicleInfo().getRows().get(position).getVehicleGpsId());
            holder.car_clzt.setText("车辆状态:"+mCar.getData().getVehicleInfo().getRows().get(position).getVehicleType());
            return  convertView;
        }
        class ViewHolder{
            TextView tv_chezuid,car_clzt,tv_car_cph;
        }
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
                convertView = View.inflate(CarActivity.this, R.layout.item_search, null);
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
        TextView v_listview_item_number;
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int  itemsLastIndex = myAdapter.getCount()-1;//数据集最后一项的索引
        int  lastIndex =itemsLastIndex + 1;        //加上底部的loadMoreView项
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex) {
            //如果是自动加载,可以在这里放置异步加载数据的代码
            Log.i("LOADMORE", "loading...");
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }
    private void  loadData(){
        ++page;
        HashMap<String, Object> params = new HashMap<>();
        String s=chehao.getText().toString();
        String s2=chezu.getText().toString();
        if(!"".equals(s)&&!"null".equals(s)&&s!=null){
            params.put("vehicleNo",page);
        }
        String ids="";
        if(!"".equals(s2)&&!"null".equals(s2)&&s2!=null){
             for(int i=0;i<mCarZu.getData().getGroupInfo().size();i++){
                   if(s2.equals(mCarZu.getData().getGroupInfo().get(i).getText())){
                       ids=mCarZu.getData().getGroupInfo().get(i).getId();
                   }
             }
            params.put("groupId",ids);
        }
        params.put("page",page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTCAR, params,  CarResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTCAR,this,false).setTag(this);
    }

}
