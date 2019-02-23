package com.smartwasser.yunzhishui.deviceactivity;

import android.app.AlertDialog;
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
import com.smartwasser.yunzhishui.adapter.WorkDanFeedAdapter;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
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
 * Created by huangmengjie on 2016/7/10 0010.
 */
public class FeedbackMxActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu, norm_ser;
    private TextView tv_toolbar;
    private Toolbar toolbar;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private ListView minlistView,minlistView2;
    private View parientView;
    private  WorkDanMxBybwResponse mMxbybw;
    private  WorkDanMxBylbResponse  mMxBylb;
    private ListView list_workdan_complet;
    private Button button_workdan;
    private EventSearchResponse mEvent;
    private WorkDanMxResponse danList;
    private TextView tv_vv;
    private String  bwCode="";
    private WorkDanFeedMxAdapter mWorkAdapter;
    private int page=1;
    private String lbCode="";
    private int i=0;
    /** 弹出自定义密码对话框的方法 */
    private AlertDialog dialog;
    private EditText ed_workdan_sbmc, ed_workdan_bylx, ed_workdan_bybw;
    private ImageButton image_workdan_bylx, image_workdan_bybw;
    private TextView tianjia;
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List< WorkDanMxResponse.DataEntity.EqMaintainDetailEntity.RowsEntity> lists=new ArrayList<>();
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
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        norm_ser.setVisibility(View.VISIBLE);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tianjia= (TextView) findViewById(R.id.tianjia);
        list_workdan_complet= (ListView) findViewById(R.id.list_workdan_complet);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        norm_ser.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("工单反馈明细");
        tianjia.setVisibility(View.GONE);
            /**请求网络*/
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("id", mEvent.getFeedId());
        HttpLoader.get(ConstantsYunZhiShui.URL_GDMXLIST, params, WorkDanMxResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDMXLIST, this, false).setTag(this);

    }
    private View getView() {
        View view = View.inflate(this, R.layout.dialog_workdan_search, null);
        ed_workdan_sbmc = (EditText) view.findViewById(R.id.ed_workdan_sbmc);
        ed_workdan_bylx = (EditText) view.findViewById(R.id.ed_workdan_bylx);
        ed_workdan_bybw = (EditText) view.findViewById(R.id.ed_workdan_bybw);
        image_workdan_bylx = (ImageButton) view.findViewById(R.id.image_workdan_bylx);
        image_workdan_bybw = (ImageButton) view.findViewById(R.id.image_workdan_bybw);
        button_workdan = (Button) view.findViewById(R.id.button_workdan);
        tv_vv= (TextView) view.findViewById(R.id. tv_vv);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.norm_ser:
                showMuchTrend();
                break;
            case R.id.button_menu:
                Intent intent=new Intent(FeedbackMxActivity.this,WorkDanFeedbackActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ed_workdan_bylx :
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView,parientView,ed_workdan_bylx.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.220),(int)(GetScreenParam.getScreenHeight(this)*0.132));
                break;
            case R.id.ed_workdan_bybw:
                minlistView2= initListView2();
                pwtu.showPopupWindow(minlistView2,parientView,ed_workdan_bybw.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.685),(int)(GetScreenParam.getScreenHeight(this)*0.132));
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
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDFK
                && response instanceof SaveResponse) {
            SaveResponse save =(SaveResponse) response;
            if("00000".equals(save.getErrorCode())){
                   dialog.dismiss();
                      /**请求网络*/
                lists.clear();
                flag=false;
                HashMap<String, Object> params = new HashMap<>();
                params.put("page",1);
                params.put("id",mEvent.getFeedId());
                HttpLoader.get(ConstantsYunZhiShui.URL_GDMXLIST, params, WorkDanMxResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_GDMXLIST, this, false).setTag(this);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDMXLIST
                && response instanceof WorkDanMxResponse) {
            danList =(WorkDanMxResponse) response;
            if("00000".equals(danList.getErrorCode())) {
                if (!flag) {
                    total = danList.getData().getEqMaintainDetail().getTotal();
                }
                for (int n = 0; n < danList.getData().getEqMaintainDetail().getRows().size(); n++) {
                    lists.add(danList.getData().getEqMaintainDetail().getRows().get(n));
                }
                list_workdan_complet.setVisibility(View.VISIBLE);
                if (mWorkAdapter == null) {
                    mWorkAdapter=new WorkDanFeedMxAdapter();
                    list_workdan_complet.setAdapter(mWorkAdapter);
                } else {
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
                                danList  = null;
                                page = 1;
                                flag = true;
                                lists.clear();
                                show(page);
                            }
                        }, 1000);
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
    class MyAdapter extends BaseAdapter {
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
                convertView = View.inflate(FeedbackMxActivity.this, R.layout.item_search, null);
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
                convertView = View.inflate(FeedbackMxActivity.this, R.layout.item_search, null);
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
    public void onEvent(EventSearchResponse event){
             mEvent=event;
    }
    public class WorkDanFeedMxAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return  lists.size();
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
            if (convertView == null) {
                convertView = View.inflate(FeedbackMxActivity.this, R.layout.item_workdan_feed, null);
                holder = new ViewHolder();
                holder.tv_workdan_sbName = (TextView) convertView.findViewById(R.id.tv_workdan_sbName);
                holder.tv_notcomplet = (TextView) convertView.findViewById(R.id.tv_notcomplet);
                holder.tv_workdan_zcbh = (TextView) convertView.findViewById(R.id.tv_workdan_zcbh);
                holder.tv_workdan_sydw = (TextView) convertView.findViewById(R.id.tv_workdan_sydw);
                holder.tv_workdan_ssdw = (TextView) convertView.findViewById(R.id.tv_workdan_ssdw);
                holder.tv_workdan_bylx = (TextView) convertView.findViewById(R.id.tv_workdan_bylx);
                holder.tv_workdan_bybw = (TextView) convertView.findViewById(R.id.tv_workdan_bybw);
                holder.tv_workdan_bynr = (TextView) convertView.findViewById(R.id.tv_workdan_bynr);
                holder.tv_workdan_bz = (TextView) convertView.findViewById(R.id.tv_workdan_bz);
                holder.but_workdan= (Button) convertView.findViewById(R.id.but_workdan);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_workdan_sbName.setText("设备名称:" + lists.get(position).getEquipName());
            String s =lists.get(position).getMaintainStatus();
            if ("1".equals(s)) {
                holder.tv_notcomplet.setText("未完成");
                holder.tv_notcomplet.setTextColor(Color.RED);
                holder.but_workdan.setVisibility(View.VISIBLE);
            } else if ("2".equals(s)) {
                holder.tv_notcomplet.setText("完成");
                holder.tv_notcomplet.setTextColor(Color.GREEN);
                holder.but_workdan.setVisibility(View.GONE);
            }
            holder.tv_workdan_zcbh.setText("资产编码:" + lists.get(position).getEquipAscode());
            holder.tv_workdan_sydw.setText("使用单位:" +lists.get(position).getEquipDeptName());
            holder.tv_workdan_ssdw.setText("实施单位:" + lists.get(position).getMaintainUnitName());
            String bylb= lists.get(position).getMaintainName();
            if("".equals(bylb)||"null".equals(bylb)||bylb==null){
                bylb="";
            }
            holder.tv_workdan_bylx.setText("保养类别:"+bylb);
            String bybw= lists.get(position).getMaintainPartName();
            if("".equals(bybw)||"null".equals(bybw)||bybw==null){
                bybw="";
            }
            holder.tv_workdan_bybw.setText("保养部位:" + bybw);
            holder.tv_workdan_bynr.setText("保养内容:" + lists.get(position).getMaintainComment());
            holder.but_workdan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     /***/
                    showPwdAlertDialog(position);
                }
            });
            return convertView;
            }
        class ViewHolder{
            TextView tv_workdan_sbName,tv_notcomplet,tv_workdan_zcbh,tv_workdan_sydw,tv_workdan_ssdw
                    ,tv_workdan_bylx,tv_workdan_bybw,tv_workdan_bynr,tv_workdan_bz;
             Button but_workdan;
          }
        }
    public void showPwdAlertDialog(final int i) {
        View view = View.inflate(FeedbackMxActivity.this, R.layout.dialog_paifa, null);
        TextView text= (TextView) view.findViewById(R.id.title_dialog);
        text.setText("确认完成?");
        Button but_pwd_ok = (Button) view.findViewById(R.id.but_pwd_ok);
        Button but_pwd_cancel = (Button) view.findViewById(R.id.but_pwd_cancel);
        AlertDialog.Builder builder = new AlertDialog.Builder(FeedbackMxActivity.this);
        builder.setView(view);
        builder.setCancelable(false);
        but_pwd_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            /**掉用派发接口*/
                HashMap<String, Object> params = new HashMap<>();
                params.put("maintainId",mEvent.getFeedId());
                params.put("id",lists.get(i).getId());
                params.put("maintainStatus",2);
                HttpLoader.get(ConstantsYunZhiShui.URL_GDFK, params, SaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_GDFK,FeedbackMxActivity.this, false).setTag(this);
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
    private void show(int page){
        HashMap<String, Object> params = new HashMap<>();
        if(ed_workdan_sbmc!=null&&ed_workdan_bylx!=null&&ed_workdan_bybw!=null) {
            String sbName = ed_workdan_sbmc.getText().toString();
            String bylb = ed_workdan_bylx.getText().toString();
            String bybw = ed_workdan_bybw.getText().toString();
            if (!"".equals(sbName) && !"null".equals(sbName) && sbName != null) {
                params.put("equipName", sbName);
            }
            if ("".equals(bylb)) {
                lbCode = "";
            }
            if (!"".equals(bylb)&& !"null".equals(bylb) && bylb != null) {
                params.put("maintainType", lbCode);
            }
            if ("".equals(bybw)) {
                bwCode = "";
            }
            if (!"".equals(bybw) && !"null".equals(bybw) && bybw != null) {
                params.put("maintainPart", bwCode);
            }
        }
        /**请求网络*/
        params.put("page", page);
        params.put("id", mEvent.getFeedId());
        HttpLoader.get(ConstantsYunZhiShui.URL_GDMXLIST, params, WorkDanMxResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDMXLIST, this, false).setTag(this);
    }
}

