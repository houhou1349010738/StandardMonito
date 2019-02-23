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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.TransportationAdapter;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.MudResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.TransportResponse;
import com.smartwasser.yunzhishui.bean.WeightCzdResponse;
import com.smartwasser.yunzhishui.bean.WeightResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogSludgeTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/13 0013.
 */
public class TransportationActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private ImageButton button_fan,image_add,image_serc;
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ListView list_transporta;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private Toolbar toolbar;
    private TransportationAdapter mTransportaAdapter;
    private TransportResponse mTransportResponse;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    /**搜索框*/
    private TextView tv_transporta;
    private EditText ed_transporta_czds,ed_transporta_chuzds,ed_weight_szsj,ed_weight_endTime;
    private ImageButton image_transporta_czds,image_transporta_chuzds,image_weight_startTiem,image_weight_endTiem;
    private Button  but_weight_search;
    private View loadMoreView;
    private int i=0;
    private int page=1;
    private  WeightCzdResponse  mWeighTCzd;
    private MyAdapter myAdapters;
    private DialogSludgeTimeUtils dialogs=new DialogSludgeTimeUtils(this);
    private View  parientView;
    private ListView minlistView, minlistView2;
    private MudAdapter mMudapter;
    private  MudResponse mMudResponse;
    private EventNormSelect mNorm=new EventNormSelect();
    @Override
    protected int initContentView() {
        return R.layout.activity_transporta;
    }
    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_add.setVisibility(View.GONE);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        list_transporta= (ListView) findViewById(R.id.list_transporta);
        loadMoreView=View.inflate(this, R.layout.load_more, null);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        loadMoreButton = (ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        list_transporta.addFooterView(loadMoreView);
    }
    private View getView(){
        View view=View.inflate(this,R.layout.popup_transporta,null);
        ed_transporta_czds= (EditText) view.findViewById(R.id.ed_transporta_czds);
        ed_transporta_chuzds= (EditText) view.findViewById(R.id.ed_transporta_chuzds);
        ed_weight_szsj= (EditText) view.findViewById(R.id.ed_weight_szsj);
        ed_weight_endTime= (EditText) view.findViewById(R.id.ed_weight_endTime);
        image_transporta_czds= (ImageButton) view.findViewById(R.id.image_transporta_czds);
        image_weight_startTiem= (ImageButton) view.findViewById(R.id.image_weight_startTiem);
        image_weight_endTiem=(ImageButton) view.findViewById(R.id.image_weight_endTiem);
        but_weight_search= (Button) view.findViewById(R.id.but_weight_search);
        image_transporta_chuzds= (ImageButton) view.findViewById(R.id.image_transporta_chuzds);
        tv_transporta= (TextView)view.findViewById(R.id. tv_transporta);
        return view;
    }
    @Override
    protected void initListener() {
        button_fan.setOnClickListener(this);
        image_serc.setOnClickListener(this);
        list_transporta.setOnScrollListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar_zhu.setText("污泥运输");
        tv_toolbar_centext.setText("运输任务管理");
        showProgressDialog();
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTTASK, params, TransportResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTASK,this,false).setTag(this);
        showProgressDialog();
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        list_transporta.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });
        list_transporta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String transportaId=mTransportResponse.getData().getTransportTask().getRows().get(position).getTransportTaskId();
                mNorm.setTransportaId(transportaId);
                EventBus.getDefault().postSticky(mNorm);
                Intent intent=new Intent(TransportationActivity.this,TrasportadetailsActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int  itemsLastIndex = mTransportaAdapter.getCount()-1;//数据集最后一项的索引
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
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTTASK, params, TransportResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTASK,this,false).setTag(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.button_fan:
               finish();
               break;
           case R.id.image_serc:
               /**弹出搜索框*/
               showMuchTrend();
               break;
           case R.id. ed_weight_szsj:
               dialogs.show(ed_weight_szsj);
               dialogs.showTime();
               break;
           case R.id.ed_weight_endTime:
               /**结束时间*/
               dialogs.show(ed_weight_endTime);
               dialogs.showTime();
               break;
           case R.id.ed_transporta_czds:
               /**称重点*/
               minlistView=initListView();
               pwtu.showPopupWindow(minlistView,parientView,ed_transporta_czds.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.176),(int)(GetScreenParam.getScreenHeight(this)*0.099));
               break;
           case R.id.ed_transporta_chuzds:
               /**处置点*/
               minlistView2=initListView2();
               pwtu.showPopupWindow(minlistView2,parientView,ed_transporta_chuzds.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.186),(int)(GetScreenParam.getScreenHeight(this)*0.1563));
               break;
           case R.id. but_weight_search:
               ++i;
               HashMap<String, Object> params = new HashMap<>();
               /**查询*/
               String start=ed_weight_szsj.getText().toString();
               String end=ed_weight_endTime.getText().toString();
               String czd=ed_transporta_czds.getText().toString();
               String chuzds=ed_transporta_chuzds.getText().toString();
               if(!"".equals(start)&&!"null".equals(start)&&start!=null){
                   params.put("dateFrom",start);
               }
               if(!"".equals(end)&&!"null".equals(end)&&end!=null){
                   params.put("dateTo",end);
               }
               if(!"".equals(czd)&&!"null".equals(czd)&&czd!=null){
                   for(int i=0;i<mWeighTCzd.getData().getWeightPointManagement().size();i++){
                       if(czd.equals(mWeighTCzd.getData().getWeightPointManagement().get(i).getText())){
                           String id=mWeighTCzd.getData().getWeightPointManagement().get(i).getId();
                           params.put("weightPointNumber",id);
                       }
                   }
               }
               if(!"".equals(chuzds)&&!"null".equals(chuzds)&&chuzds!=null){
                   for(int j=0;j<mMudResponse.getData().getMudInfo().size();j++){
                       if(chuzds.equals(mMudResponse.getData().getMudInfo().get(j).getText())){
                           String id=mMudResponse.getData().getMudInfo().get(j).getId();
                           params.put("mudId",id);
                       }
                   }
               }
               params.put("page", page);
               HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTTASK, params, TransportResponse.class,
                       ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTASK,this,false).setTag(this);
               break;
       }
    }
    private void showMuchTrend(){
        psu.showPopupSearch(getView(), toolbar);
        parientView= toolbar;
        tv_transporta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_transporta_czds.setOnClickListener(this);
        ed_weight_szsj.setOnClickListener(this);
        ed_weight_endTime.setOnClickListener(this);
        but_weight_search.setOnClickListener(this);
        ed_transporta_chuzds.setOnClickListener(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTTASK
                && response instanceof TransportResponse) {
            mTransportResponse=(TransportResponse)response;
            if("00000".equals(mTransportResponse.getErrorCode())) {
                mTransportaAdapter = new TransportationAdapter(this, mTransportResponse);
                list_transporta.setAdapter(mTransportaAdapter);
                if (i != 0) {
                    psu.colsePopupWindow();
                }
            }
            dismissProgressDialog();
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTPOINT
                && response instanceof WeightCzdResponse) {
            mWeighTCzd = (WeightCzdResponse) response;
            if("00000".equals( mWeighTCzd.getErrorCode())) {
                myAdapters = new MyAdapter();
                minlistView.setAdapter(myAdapters);
                minlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_transporta_czds.setText(mWeighTCzd.getData().getWeightPointManagement().get(position).getText());
                        pwtu.closePopupWindow();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMUD
                && response instanceof MudResponse) {
            mMudResponse=(MudResponse)response;
            if("00000".equals(mMudResponse.getErrorCode())){
            mMudapter=new MudAdapter();
            minlistView2.setAdapter(mMudapter);
            minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_transporta_chuzds.setText(mMudResponse.getData().getMudInfo().get(position).getText());
                    pwtu.closePopupWindow();
                  }
            });
            }
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
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTPOINT, prams,
                WeightCzdResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTPOINT, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTMUD, prams,
                MudResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMUD, this, false).setTag(this);
        return mListViews;
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return  mWeighTCzd.getData().getWeightPointManagement().size();
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
                convertView = View.inflate(TransportationActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mWeighTCzd.getData().getWeightPointManagement().get(position).getText());
            return convertView;
        }
    }
    class ViewHolder {
        TextView v_listview_item_number;
    }
    class MudAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return  mMudResponse.getData().getMudInfo().size();
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
                convertView = View.inflate(TransportationActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mMudResponse.getData().getMudInfo().get(position).getText());
            return convertView;
        }
    }
}
