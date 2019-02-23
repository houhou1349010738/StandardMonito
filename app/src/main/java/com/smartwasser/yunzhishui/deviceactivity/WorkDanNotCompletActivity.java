package com.smartwasser.yunzhishui.deviceactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.WorkDanList;
import com.smartwasser.yunzhishui.bean.WorkDanMxBybwResponse;
import com.smartwasser.yunzhishui.bean.WorkDanMxBylbResponse;
import com.smartwasser.yunzhishui.bean.WorkDanMxResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/6/21 0021.
 */
public class WorkDanNotCompletActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu, norm_ser;
    private TextView tv_toolbar;
    private Toolbar toolbar;
    private EditText ed_workdan_sbmc, ed_workdan_bylx, ed_workdan_bybw;
    private Button button_workdan;
    private TextView tv_vv;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private ListView list_workdan_complet;
    private int page=1;
    private EventNormSelect norm;
    private WorkDanMxResponse danList;
    private WorkDanMxAdapter mWorkAdapter;
    private ListView minlistView,minlistView2;
    private View parientView;
    private  WorkDanMxBybwResponse mMxbybw;
    private  WorkDanMxBylbResponse  mMxBylb;
    /** 弹出自定义密码对话框的方法 */
    private AlertDialog dialog;
    private String  bwCode="";
    private String lbCode="";
    private TextView tianjia;
    private EventSearchResponse es=new EventSearchResponse();
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List<WorkDanMxResponse.DataEntity.EqMaintainDetailEntity.RowsEntity> lists=new ArrayList<>();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return R.layout.activity_workdan_noteomplet;
    }
    @Override
    protected void initView() {
        button_menu = (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        norm_ser = (ImageButton) findViewById(R.id.norm_ser);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        list_workdan_complet= (ListView) findViewById(R.id.list_workdan_complet);
        tianjia= (TextView) findViewById(R.id.tianjia);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        norm_ser.setOnClickListener(this);
        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                es.setAddId(norm.getTianId());
                es.setAddState(norm.getWorkdanState());
                EventBus.getDefault().postSticky(es);
                Intent intent = new Intent(WorkDanNotCompletActivity.this, AddWorkDanMxActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private View getView() {
        View view = View.inflate(this, R.layout.dialog_workdan_search, null);
        ed_workdan_sbmc = (EditText) view.findViewById(R.id.ed_workdan_sbmc);
        ed_workdan_bylx = (EditText) view.findViewById(R.id.ed_workdan_bylx);
        ed_workdan_bybw = (EditText) view.findViewById(R.id.ed_workdan_bybw);
        button_workdan = (Button) view.findViewById(R.id.button_workdan);
        tv_vv= (TextView) view.findViewById(R.id. tv_vv);
        return view;
    }
    @Override
    protected void initData() {
        /**
         * 设置下拉刷新的颜色
         */
        myRefreshListView.setColorSchemeResources(android.R.color.holo_blue_bright
                , android.R.color.holo_orange_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_light
        );
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar.setText("保养工单明细");
        norm_ser.setVisibility(View.VISIBLE);
        if(!"1".equals(norm.getWorkdanState())){
            /**将添加隐藏*/
            tianjia.setVisibility(View.GONE);
        }
                 /**请求网络*/
        HashMap<String, Object> params = new HashMap<>();
        params.put("page",1);
        params.put("id",norm.getTianId());
        HttpLoader.get(ConstantsYunZhiShui.URL_GDMXLIST, params, WorkDanMxResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDMXLIST, this, false).setTag(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.norm_ser:
                showMuchTrend();
                break;
            case R.id.button_menu:
                finish();
                break;
            case R.id.ed_workdan_bylx:
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView,parientView,ed_workdan_bylx.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.220),(int)(GetScreenParam.getScreenHeight(this)*0.132));
                break;
            case R.id.ed_workdan_bybw:
                minlistView2= initListView2();
                pwtu.showPopupWindow(minlistView2,parientView,ed_workdan_bybw.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.515),(int)(GetScreenParam.getScreenHeight(this)*0.22));
                break;
            case R.id.button_workdan:
                /**搜索*/
                psu.colsePopupWindow();
                page=1;
                lists.clear();
                flag=false;
                show(page);
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDMXLIST
                && response instanceof WorkDanMxResponse) {
               danList =(WorkDanMxResponse) response;
              if("00000".equals( danList.getErrorCode())){
                  if(!flag){
                      total=danList.getData().getEqMaintainDetail().getTotal();
                  }
                  for(int n=0;n<danList.getData().getEqMaintainDetail().getRows().size();n++){
                      lists.add(danList.getData().getEqMaintainDetail().getRows().get(n));
                  }
                  list_workdan_complet.setVisibility(View.VISIBLE);
                  if(mWorkAdapter==null){
                      mWorkAdapter=new WorkDanMxAdapter();
                      list_workdan_complet.setAdapter(mWorkAdapter);
                  }else {
                      mWorkAdapter.notifyDataSetChanged();
                  }
                  myRefreshListView.setRefreshing(false);
                  myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                      @Override
                      public void onRefresh() {
                          list_workdan_complet.setVisibility(View.GONE);
                          myRefreshListView.postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  danList= null;
                                  page=1;
                                  flag = true;
                                  lists.clear();
                                  show(page);
                              }
                          },1000);
                      }
                  });
                  // 加载监听器
                  myRefreshListView.setOnLoadListener(new RefreshLayout.OnLoadListener() {
                      @Override
                      public void onLoad() {
                          myRefreshListView.postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  loadData();
                                  flag = false;
                                  myRefreshListView.setLoading(false);
                              }
                          }, 2000);

                      }
                  });

              }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDMXDELETE
                && response instanceof DeleteResponse) {
            DeleteResponse mDelete=(DeleteResponse)response;
            if("00000".equals(mDelete.getErrorCode())){
                    dialog.dismiss();
                     /**请求网络*/
                mWorkAdapter.notifyDataSetChanged();
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI
                && response instanceof WorkDanMxBylbResponse) {
            mMxBylb =(WorkDanMxBylbResponse) response;
            MyAdapter adapter=new MyAdapter();
            minlistView.setAdapter(adapter);
            minlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_workdan_bylx.setText(mMxBylb.getData().getComboboxList().get(position).getText());
                    lbCode=mMxBylb.getData().getComboboxList().get(position).getId();
                    pwtu.closePopupWindow();
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI
                && response instanceof WorkDanMxBybwResponse) {
                mMxbybw =(WorkDanMxBybwResponse) response;
            MyAdapter2 adapter2=new MyAdapter2();
            minlistView2.setAdapter(adapter2);
            minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_workdan_bybw.setText(mMxbybw .getData().getComboboxList().get(position).getText());
                    bwCode=mMxbybw.getData().getComboboxList().get(position).getId();
                    pwtu.closePopupWindow();
                }
            });

        }

    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventNormSelect enst){
                norm=enst;
    }
    private void  loadData(){
        ++page;
        if(total+10>(page*10)) {
            myRefreshListView.pull_to_refresh_loadmore_text.setText("玩命加载中");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.VISIBLE);
            show(page);
        }else{
            myRefreshListView.pull_to_refresh_loadmore_text.setText("没有更多数据了.....");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.GONE);
        }
    }
    private void showMuchTrend(){
        psu.showPopupSearch(getView(), toolbar);
        parientView=toolbar;
        tv_vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_workdan_bylx.setOnClickListener(this);
        ed_workdan_bybw.setOnClickListener(this);
        button_workdan.setOnClickListener(this);
    }
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode", "EQ_MAINTAIN_TYPE_CODE");
        HttpLoader.get(ConstantsYunZhiShui.URL_SBBUWEI, prams,
                WorkDanMxBylbResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","EQ_PART_CODE");
        HttpLoader.get(ConstantsYunZhiShui.URL_SBBUWEI, prams,
                WorkDanMxBybwResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI, this, false).setTag(this);
        return mListViews;
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return  mMxBylb.getData().getComboboxList().size();
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
                convertView = View.inflate(WorkDanNotCompletActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mMxBylb.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class ViewHolder{
        TextView v_listview_item_number;
    }
    class MyAdapter2 extends BaseAdapter{
        @Override
        public int getCount() {
            return  mMxbybw.getData().getComboboxList().size();
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
                convertView = View.inflate(WorkDanNotCompletActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mMxbybw.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    public class WorkDanMxAdapter extends BaseAdapter{
        @Override
        public int getCount() {

            return lists.size();
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
                convertView=View.inflate(WorkDanNotCompletActivity.this, R.layout.item_workdan_complet,null);
                holder=new ViewHolder();
                holder.tv_workdan_sbName= (TextView) convertView.findViewById(R.id.tv_workdan_sbName);
                holder.tv_notcomplet= (TextView) convertView.findViewById(R.id.tv_notcomplet);
                holder.tv_workdan_zcbh= (TextView) convertView.findViewById(R.id.tv_workdan_zcbh);
                holder.tv_workdan_sydw= (TextView) convertView.findViewById(R.id.tv_workdan_sydw);
                holder.tv_workdan_ssdw= (TextView) convertView.findViewById(R.id.tv_workdan_ssdw);
                holder.tv_workdan_bylx= (TextView) convertView.findViewById(R.id.tv_workdan_bylx);
                holder.tv_workdan_bybw= (TextView) convertView.findViewById(R.id.tv_workdan_bybw);
                holder.tv_workdan_bynr= (TextView) convertView.findViewById(R.id.tv_workdan_bynr);
                holder.tv_workdan_bz= (TextView) convertView.findViewById(R.id.tv_workdan_bz);
                holder.write_workdan= (ImageButton) convertView.findViewById(R.id.write_workdan);
                holder.del_workdan= (ImageButton) convertView.findViewById(R.id.del_workdan);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder)convertView.getTag();
            }
            holder.tv_workdan_sbName.setText("设备名称:" + lists.get(position).getEquipName());
            String s=lists.get(position).getMaintainStatus();
            if("1".equals(s)){
                holder.tv_notcomplet.setText("未完成");
                holder.tv_notcomplet.setTextColor(Color.RED);
            }else if("2".equals(s)){
                holder.tv_notcomplet.setText("完成");
                holder.tv_notcomplet.setTextColor(Color.GREEN);
            }
            if(!"1".equals(norm.getWorkdanState())){
                holder.write_workdan.setVisibility(View.GONE);
                holder.del_workdan.setVisibility(View.GONE);
            }
            holder.del_workdan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**删除*/
                    showPwdAlertDialog(position);
                }
            });
            holder.write_workdan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**跳到修改页*/
                    String sid =lists.get(position).getId();
                    es.setMaintainId(sid);
                    EventBus.getDefault().postSticky(es);
                    Intent intent = new Intent(WorkDanNotCompletActivity.this, WorkDanMxUpdateActivity.class);
                    startActivity(intent);
                }
            });
            holder.tv_workdan_zcbh.setText("资产编码:" + lists.get(position).getEquipAscode());
            holder.tv_workdan_sydw.setText("使用单位:"+lists.get(position).getEquipDeptName());
            holder.tv_workdan_ssdw.setText("实施单位:"+lists.get(position).getMaintainUnitName());
            String bylb=lists.get(position).getMaintainName();
            if("".equals(bylb)||"null".equals(bylb)||bylb==null){
                bylb="";
            }
            holder.tv_workdan_bylx.setText("保养类别:"+bylb);
            String bybw=lists.get(position).getMaintainPartName();
            if("".equals(bybw)||"null".equals(bybw)||bybw==null){
                bybw="";
            }
            holder.tv_workdan_bybw.setText("保养部位:"+bybw);
            holder.tv_workdan_bynr.setText("保养内容:"+lists.get(position).getMaintainComment());
            return convertView;
        }
        class ViewHolder{
            TextView tv_workdan_sbName,tv_notcomplet,tv_workdan_zcbh,tv_workdan_sydw,tv_workdan_ssdw
                    ,tv_workdan_bylx,tv_workdan_bybw,tv_workdan_bynr,tv_workdan_bz;
            ImageButton write_workdan,del_workdan;
        }

        public void showPwdAlertDialog(final int i) {
            View view = View.inflate(WorkDanNotCompletActivity.this, R.layout.dialog_paw, null);
            Button but_pwd_ok = (Button) view.findViewById(R.id.but_pwd_ok);
            Button but_pwd_cancel = (Button) view.findViewById(R.id.but_pwd_cancel);
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkDanNotCompletActivity.this);
            builder.setView(view);
            builder.setCancelable(false);
            but_pwd_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**掉用删除接口*/
                    HashMap<String, Object> params = new HashMap<>();
                    lists.remove(i);
                    params.put("id", lists.get(i).getId());
                    HttpLoader.get(ConstantsYunZhiShui.URL_GDMXDELETE, params, DeleteResponse.class,
                            ConstantsYunZhiShui.REQUEST_CODE_GDMXDELETE,WorkDanNotCompletActivity.this, false).setTag(this);
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
    }
    private void show(int page){
        HashMap<String, Object> params = new HashMap<>();
        if( ed_workdan_sbmc!=null&&ed_workdan_bylx!=null&&ed_workdan_bybw!=null) {
            String sbName = ed_workdan_sbmc.getText().toString();
            String bylb = ed_workdan_bylx.getText().toString();
            String bybw = ed_workdan_bybw.getText().toString();
            if (!"".equals(sbName)&&!"null".equals(sbName)&&sbName != null) {
                params.put("equipName", sbName);
            }
            if (!"".equals(bylb)&& !"null".equals(bylb) && bylb != null) {
                params.put("maintainType", lbCode);
            }

            if (!"".equals(bybw) && !"null".equals(bybw) && bybw != null) {
                params.put("maintainPart", bwCode);
            }
        }
        /**请求网络*/
        params.put("page", page);
        params.put("id",  norm.getTianId());
        HttpLoader.get(ConstantsYunZhiShui.URL_GDMXLIST, params, WorkDanMxResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDMXLIST, this, false).setTag(this);
    }
}