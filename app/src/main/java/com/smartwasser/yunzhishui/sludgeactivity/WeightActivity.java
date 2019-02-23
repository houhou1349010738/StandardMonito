package com.smartwasser.yunzhishui.sludgeactivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
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
import com.smartwasser.yunzhishui.bean.DeleteResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.HitchResponse;
import com.smartwasser.yunzhishui.bean.HitchTypeResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.WeightCzdResponse;
import com.smartwasser.yunzhishui.bean.WeightResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogSludgeTimeUtils;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/6/15 0015.
 */
public class WeightActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private TextView tv_toolbar_centext,tv_toolbar_zhu;
    private ImageButton button_fan,image_add,image_serc;
    private ListView list_weight;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private  WeightAdapter myAdapter;
    /** 弹出自定义密码对话框的方法 */
    private AlertDialog dialog;
    private  WeightResponse mWeight;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private View loadMoreView;
    private int i=0;
    private int page=1;
    private EventNormSelect enor=new EventNormSelect();
    /**找到搜索控件*/
    private TextView tv_weight;
    private EditText ed_weight_czds,ed_weight_cphs,ed_weight_szsj,ed_weight_endTime;
    private ImageButton image_weight_czds,image_weight_startTiem,image_weight_endTiem;
    private Button but_weight_search;
    private Toolbar toolbar;
    private View  parientView;
    private DialogSludgeTimeUtils dialogs=new DialogSludgeTimeUtils(this);
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private ListView minlistView;
    private  WeightCzdResponse  mWeighTCzd;
    private MyAdapter myAdapters;
    @Override
    protected int initContentView() {
        return R.layout.activity_weight;
    }
    @Override
    protected void initView() {
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        list_weight= (ListView) findViewById(R.id.list_weight);
        loadMoreView=View.inflate(this, R.layout.load_more, null);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        loadMoreButton = (ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        list_weight.addFooterView(loadMoreView);

    }
    private View getView(){
        View view=View.inflate(this,R.layout.popup_weight,null);
        ed_weight_czds= (EditText) view.findViewById(R.id.ed_weight_czds);
        ed_weight_cphs= (EditText) view.findViewById(R.id.ed_weight_cphs);
        ed_weight_szsj= (EditText) view.findViewById(R.id.ed_weight_szsj);
        ed_weight_endTime= (EditText) view.findViewById(R.id.ed_weight_endTime);
        image_weight_czds= (ImageButton) view.findViewById(R.id.image_weight_czds);
        image_weight_startTiem= (ImageButton) view.findViewById(R.id.image_weight_startTiem);
        image_weight_endTiem=(ImageButton) view.findViewById(R.id.image_weight_endTiem);
        but_weight_search= (Button) view.findViewById(R.id.but_weight_search);
        tv_weight= (TextView)view.findViewById(R.id.tv_weight);
        return view;
    }

    @Override
    protected void initListener() {
        list_weight.setOnScrollListener(this);
        button_fan.setOnClickListener(this);
        image_serc.setOnClickListener(this);
        image_add.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar_centext.setText("称重数据监控");
        tv_toolbar_zhu.setText("污泥运输");
        image_add.setVisibility(View.VISIBLE);
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTINFO, params, WeightResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTINFO,this,false).setTag(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        list_weight.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_fan:
                finish();
            break;
            case R.id.image_serc:
                /**弹出搜索界面*/
                showMuchTrend();
                break;
            case R.id.image_add:
                /**添加*/
                Intent intent =new Intent(WeightActivity.this,AddWeightActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ed_weight_szsj:
                dialogs.show(ed_weight_szsj);
                dialogs.showTime();
                break;
            case R.id. ed_weight_endTime:
                /**结束时间*/
                dialogs.show(ed_weight_endTime);
                dialogs.showTime();
                break;
            case R.id. ed_weight_czds:
                /**称重点*/
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView,parientView,ed_weight_czds.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.176),(int)(GetScreenParam.getScreenHeight(this)*0.099));
                break;
            case R.id.but_weight_search:
                ++i;
                HashMap<String, Object> params = new HashMap<>();
                String  cph=ed_weight_cphs.getText().toString();
                String  start= ed_weight_szsj.getText().toString();
                String  end= ed_weight_endTime.getText().toString();
                String czd=ed_weight_czds.getText().toString().trim();
                if (!"".equals(cph)&&!"null".equals(cph)&&cph!=null){
                    params.put("carNo", cph);
                }
                if(!"".equals(start)&&!"null".equals(start)&&start!=null){
                    params.put("dateFrom",start);
                }
                if(!"".equals(end)&&!"null".equals(end)&&end!=null){
                    params.put("dateTo", end);
                }
                if(!"".equals(czd)&&!"null".equals(czd)&&czd!=null){
                    for(int i=0;i<mWeighTCzd.getData().getWeightPointManagement().size();i++){
                        if(czd.equals(mWeighTCzd.getData().getWeightPointManagement().get(i).getText())){
                            String id=mWeighTCzd.getData().getWeightPointManagement().get(i).getId();
                            params.put("busiUnit",id);
                        }
                    }
                }
                params.put("page", page);
                HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTINFO, params, WeightResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_TRANPORTINFO,this,false).setTag(this);
                break;
        }
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
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTINFO, params, WeightResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTINFO,this,false).setTag(this);
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTINFO
                && response instanceof WeightResponse) {
              mWeight=(WeightResponse)response;
              myAdapter=new WeightAdapter();
              list_weight.setAdapter(myAdapter);
            if(i!=0){
                psu.colsePopupWindow();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTDELETE
                && response instanceof DeleteResponse) {
            DeleteResponse mDelete = (DeleteResponse) response;
            if("00000".equals(mDelete.getErrorCode())){
                dialog.dismiss();
                HashMap<String, Object> params = new HashMap<>();
                params.put("page", page);
                HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTINFO, params, WeightResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_TRANPORTINFO,this,false).setTag(this);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTPOINT
                && response instanceof WeightCzdResponse) {
            mWeighTCzd = (WeightCzdResponse) response;
            myAdapters = new MyAdapter();
            minlistView.setAdapter(myAdapters);
            minlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_weight_czds.setText(mWeighTCzd.getData().getWeightPointManagement().get(position).getText());
                    pwtu.closePopupWindow();
                }
            });
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public class WeightAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mWeight.getData().getTransportTask().getRows().size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(WeightActivity.this,R.layout.item_weight,null);
                holder=new ViewHolder();
                holder.tv_weight_lsdh= (TextView) convertView.findViewById(R.id.tv_weight_lsdh);
                holder.weight_ly= (TextView) convertView.findViewById(R.id.weight_ly);
                holder.tv_weight_cph= (TextView) convertView.findViewById(R.id.tv_weight_cph);
                holder.tv_weight_czd= (TextView) convertView.findViewById(R.id.tv_weight_czd);
                holder.tv_weight_wnzl= (TextView) convertView.findViewById(R.id.tv_weight_wnzl);
                holder.tv_weight_jz= (TextView) convertView.findViewById(R.id.tv_weight_jz);
                holder.tv_weight_pzsj= (TextView) convertView.findViewById(R.id.tv_weight_pzsj);
                holder.tv_weight_pz= (TextView) convertView.findViewById(R.id.tv_weight_pz);
                holder.tv_weight_mzsj= (TextView) convertView.findViewById(R.id.tv_weight_mzsj);
                holder.tv_weight_mz= (TextView) convertView.findViewById(R.id.tv_weight_mz);
                holder.weight_del= (ImageButton) convertView.findViewById(R.id.weight_del);
                holder.weight_witer= (ImageButton) convertView.findViewById(R.id.weight_witer);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_weight_lsdh.setText(mWeight.getData().getTransportTask().getRows().get(position).getId());
            String s=mWeight.getData().getTransportTask().getRows().get(position).getDataSource();
            if("1".equals(s)){
                s="人工";
            }else{
                s="系统";
            }
            holder.weight_ly.setText("来源:"+"  "+s);
            holder.tv_weight_cph.setText("车牌号:"+"  "+mWeight.getData().getTransportTask().getRows().get(position).getCarNo());
            holder.tv_weight_czd.setText("称重点:"+"  "+mWeight.getData().getTransportTask().getRows().get(position).getBusiUnit());
            holder.tv_weight_wnzl.setText("污泥种类:"+"  "+mWeight.getData().getTransportTask().getRows().get(position).getWnKind());
            holder.tv_weight_jz.setText("净重(T):"+"  "+mWeight.getData().getTransportTask().getRows().get(position).getNetWeight());
            holder.tv_weight_pzsj.setText("皮重时间:" + "  " + mWeight.getData().getTransportTask().getRows().get(position).getTareWeightTimeName());
            holder.tv_weight_pz.setText("皮重(T):" + "  " + mWeight.getData().getTransportTask().getRows().get(position).getTareWeight());
            holder.tv_weight_mzsj.setText("毛重时间:" + "  " + mWeight.getData().getTransportTask().getRows().get(position).getGrossWeightTimeName());
            holder.tv_weight_mz.setText("毛重(T):" + "  " + mWeight.getData().getTransportTask().getRows().get(position).getGrossWeight());
                    holder.weight_del.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                               /**删除*/
                            showPwdAlertDialog(position);
                        }
                    });
            holder.weight_witer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**修改*/
                    enor.setWeightId(mWeight.getData().getTransportTask().getRows().get(position).getId());
                    enor.setWeightWnkind(mWeight.getData().getTransportTask().getRows().get(position).getBusiUnit());
                    EventBus.getDefault().postSticky(enor);
                    Intent intent = new Intent(WeightActivity.this, WeightUpdateActivity.class);
                    startActivity(intent);
                }
            });
            return convertView;
        }
        class ViewHolder{
            TextView tv_weight_lsdh,weight_ly,tv_weight_cph,
                    tv_weight_czd,tv_weight_wnzl,tv_weight_jz,
                    tv_weight_pzsj,tv_weight_pz,tv_weight_mzsj
                    ,tv_weight_mz;
            ImageButton weight_del,weight_witer;
        }
    }
    public void showPwdAlertDialog(final int i) {
        View view = View.inflate(WeightActivity.this, R.layout.dialog_paifa, null);
        TextView text= (TextView) view.findViewById(R.id.title_dialog);
        text.setText("是否删除该数据?");
        Button but_pwd_ok = (Button) view.findViewById(R.id.but_pwd_ok);
        Button but_pwd_cancel = (Button) view.findViewById(R.id.but_pwd_cancel);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);
        but_pwd_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**掉用删除接口*/
                HashMap<String, Object> params = new HashMap<>();
                params.put("id", mWeight.getData().getTransportTask().getRows().get(i).getId());
                HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTDELETE, params, DeleteResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_TRANPORTDELETE,WeightActivity.this, false).setTag(this);
            }
        });
        but_pwd_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }
    private void showMuchTrend(){
        psu.showPopupSearch(getView(), toolbar);
        parientView= toolbar;
        tv_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_weight_czds.setOnClickListener(this);
        ed_weight_szsj.setOnClickListener(this);
        ed_weight_endTime.setOnClickListener(this);
        but_weight_search.setOnClickListener(this);
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
    class MyAdapter extends BaseAdapter{
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
                convertView = View.inflate(WeightActivity.this, R.layout.item_search, null);
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
        class ViewHolder {
            TextView v_listview_item_number;
        }
    }
}
