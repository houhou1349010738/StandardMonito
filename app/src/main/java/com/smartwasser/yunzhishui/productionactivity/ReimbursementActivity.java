package com.smartwasser.yunzhishui.productionactivity;

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
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.AddTypResponse;
import com.smartwasser.yunzhishui.bean.BusinessTypeResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.ProjectNameResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.ReimburseListResponse;
import com.smartwasser.yunzhishui.bean.ReimbursementResponse;
import com.smartwasser.yunzhishui.bean.ScheduleResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.SharedUtils;
import com.smartwasser.yunzhishui.utils.TreeListUtils;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class ReimbursementActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext,fas;
    private ImageButton image_add,image_serc,button_fan;
    private ListView list_reimburse;
    private int page=1;
    private ReimburseAdapter myAdapter;
    private ReimburseListResponse mReimburseList;
    private  ReimbursementResponse mReimbursement;
    private EventNormSelect mece=new EventNormSelect();
    private  BusinessTypeResponse mBusiness;
    private TreeListUtils tlu=new TreeListUtils();

    /***搜索控件的声明*/
    private EditText ed_reimburse_xmmc,ed_reimburse_ywlx,
               ed_reimburse_sqsj,ed_reimburse_sqjd,ed_reimburse_bxdlx;
    private Button but_reimburse_search;
    private TextView tv_reimburse;
    private View  parientView;
    private Toolbar toolbar;
    private int i=0;
    private ListView minlistView,minlistView2,minlistView3,minlistView4;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private MyBusinessAdapter mBusinAdapter;
    private  ScheduleResponse  mSchedule;
    private MyScheduleAdapter mSchedAdapter;
    private AddTypResponse  mAddType;
    private MyTypeAdapter mTypeAdapter;
    private  ProjectNameResponse mProject;
    private DialogTimeUtils dialogs=new DialogTimeUtils(this);
    private SimpleTreeListViewAdapter3 mAdapter;
    private String  xmCode="";
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private  String arr[];
    private List<ReimbursementResponse.DataEntity.PayCostClaimEntity.RowsEntity> lists=new ArrayList<>();
    @Override
    protected int initContentView() {
        return R.layout.activity_contract;
    }
    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        fas= (TextView) findViewById(R.id.fas);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        list_reimburse= (ListView) findViewById(R.id.list_contract);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
               findViewById(R.id.swipe_layout);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
    }
    private View getViews(){
        View view=View.inflate(this,R.layout.popup_reimburse,null);
        ed_reimburse_xmmc= (EditText) view.findViewById(R.id.ed_reimburse_xmmc);
        ed_reimburse_ywlx= (EditText) view.findViewById(R.id.ed_reimburse_ywlx);
        ed_reimburse_sqsj= (EditText) view.findViewById(R.id.ed_reimburse_sqsj);
        ed_reimburse_sqjd= (EditText) view.findViewById(R.id.ed_reimburse_sqjd);
        ed_reimburse_bxdlx= (EditText) view.findViewById(R.id.ed_reimburse_bxdlx);
        but_reimburse_search= (Button) view.findViewById(R.id.but_reimburse_search);
        tv_reimburse= (TextView)view.findViewById(R.id.tv_reimburse);
        return view;
    }
    @Override
    protected void initListener() {
        image_add.setOnClickListener(this);
        image_serc.setOnClickListener(this);
        button_fan.setOnClickListener(this);
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
        tv_toolbar_zhu.setText("生产成本");
        tv_toolbar_centext.setText("费用报销");
        fas.setText("费用报销申请列表");
       /* *请求网络*/
        String s=SharedUtils.getStringData(this,"production","");
        arr=s.split(",");
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("nodeId", arr[1]);
        prams.put("flowCode", arr[0]);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERLIST, prams,
                ReimburseListResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERLIST, this, false).setTag(this);
    }
    @Override
    public void onClick(View v) {
         switch (v.getId()){
              case R.id.image_add:
                  /**跳到报销单类型*/
                  Intent intent=new Intent(ReimbursementActivity.this,AddReimburseTypeActivity.class);
                  startActivity(intent);
                  break;
              case R.id.image_serc:
                  /**弹出搜索界面*/
                  showMuchTrend();
                  break;
              case R.id.button_fan:
                  finish();
                  break;
              case R.id.ed_reimburse_xmmc:
                  /**项目名称*/
                  minlistView=initListView();
                  pwtu.showPopupWindow(minlistView,parientView,ed_reimburse_xmmc.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.11));
                  break;
              case R.id. ed_reimburse_ywlx:
                   /**业务类型*/
                  minlistView2=initListView2();
                  pwtu.showPopupWindow(minlistView2,parientView,ed_reimburse_ywlx.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.17));
                 break;
              case R.id.ed_reimburse_sqsj:
                  /**申请时间*/
                  dialogs.show(ed_reimburse_sqsj);
                  dialogs.showTime();
                 break;
              case R.id.ed_reimburse_sqjd:
                  /**申请进度*/
                  minlistView3=initListView3();
                  pwtu.showPopupWindow(minlistView3,parientView,ed_reimburse_sqjd.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.29));
                 break;
              case R.id. ed_reimburse_bxdlx:
                      /**报销单类型*/
                  minlistView4=initListView4();
                  pwtu.showPopupWindow(minlistView4,parientView,ed_reimburse_bxdlx.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.36));
                 break;
              case R.id.but_reimburse_search:
                  /**查询*/
                  ++i;
                  page=1;
                  lists.clear();
                  flag=false;
                  show(page);
                 break;
         }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFILLFIND
                && response instanceof ReimbursementResponse) {
              mReimbursement = (ReimbursementResponse) response;
            if("00000".equals(mReimbursement.getErrorCode())){
                if(!flag) {
                    total = mReimbursement.getData().getPayCostClaim().getTotal();
                }else{
                    lists.clear();
                }
                for(int m=0;m<mReimbursement.getData().getPayCostClaim().getRows().size();m++){
                    lists.add(mReimbursement.getData().getPayCostClaim().getRows().get(m));
                }
                list_reimburse.setVisibility(View.VISIBLE);
                if(myAdapter==null) {
                    myAdapter = new ReimburseAdapter();
                    list_reimburse.setAdapter(myAdapter);
                }else{
                    myAdapter.notifyDataSetChanged();
                }
                if(i!=0){
                    psu.colsePopupWindow();
                }
                myRefreshListView.setRefreshing(false);
                myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        list_reimburse.setVisibility(View.GONE);
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mReimbursement = null;
                                page=1;
                                flag = true;
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
                list_reimburse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                             /**跳到详情页*/
                        mece.setUnitName(lists.get(position).getUNIT_NAME());
                        mece.setClaimId(lists.get(position).getCLAIM_ID());
                        mece.setUserName(mReimburseList.getData().getUserName());
                        mece.setNodeId(arr[1]);
                        mece.setFlowCode(arr[0]);
                        mece.setExamineState(mReimburseList.getData().getExamineState());
                        EventBus.getDefault().postSticky(mece);
                        Intent intent=new Intent(ReimbursementActivity.this,ReimburseDetailsActivity.class);
                        startActivity(intent);
                    }
                });
            }
            dismissProgressDialog();
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERLIST
                && response instanceof ReimburseListResponse) {
            mReimburseList = (ReimburseListResponse) response;
            if("00000".equals(mReimburseList.getErrorCode())){
            HashMap<String, Object> prams2 = new HashMap<>();
                prams2.put("page",1);
                prams2.put("nodeId",arr[1]);
            HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFILLFIND, prams2,
                    ReimbursementResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFILLFIND, this, false).setTag(this);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT
                && response instanceof BusinessTypeResponse) {
                     /**类型*/
                mBusiness = (BusinessTypeResponse) response;
               if("00000".equals(mBusiness.getErrorCode())){
                   mBusinAdapter=new MyBusinessAdapter();
                   minlistView2.setAdapter(mBusinAdapter);
                   minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                           ed_reimburse_ywlx.setText(mBusiness.getData().getComboboxList().get(position).getText());
                           pwtu.closePopupWindow();
                       }
                   });
               }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYSCHEDULE
                && response instanceof ScheduleResponse) {
                        /**申请进度*/
            mSchedule = (ScheduleResponse) response;
            if("00000".equals(mSchedule.getErrorCode())){
                mSchedAdapter=new MyScheduleAdapter();
                minlistView3.setAdapter(mSchedAdapter);
                minlistView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_reimburse_sqjd.setText(mSchedule.getData().getComboboxList().get(position).getText());
                        pwtu.closePopupWindow();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT
                && response instanceof AddTypResponse) {
                        /**申请单类型*/
              mAddType = (AddTypResponse) response;
            if("00000".equals(mAddType.getErrorCode())){
                mTypeAdapter=new MyTypeAdapter();
                minlistView4.setAdapter(mTypeAdapter);
                minlistView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_reimburse_bxdlx.setText(mAddType.getData().getComboboxList().get(position).getText());
                        pwtu.closePopupWindow();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYPAYBOXLIST
                && response instanceof ProjectNameResponse) {
            mProject=(ProjectNameResponse)response;

            tlu.initDataText5(mProject);
            try {
                mAdapter = new SimpleTreeListViewAdapter3(minlistView, this,
                        tlu.mDatas2, 0);
                minlistView.setAdapter(mAdapter);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                @Override
                public void onClick(Node node, int position) {
                    if (node.isleaf()) {
                        ed_reimburse_xmmc.setText(node.getName());
                        for (int i = 0; i < mProject.getData().getListTree().size(); i++) {
                            if (ed_reimburse_xmmc.getText().toString().equals(mProject.getData().getListTree().get(i).getText())) {
                                xmCode = mProject.getData().getListTree().get(i).getId();
                            }
                        }
                        pwtu.closePopupWindow();
                    }
                }
            });
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
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
    class ReimburseAdapter extends BaseAdapter{
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(ReimbursementActivity.this,R.layout.item_reimburse,null);
                holder=new ViewHolder();
                holder.tv_reimburse_bxdlb= (TextView) convertView.findViewById(R.id.tv_reimburse_bxdlb);
                holder.tv_reimburse_type= (TextView) convertView.findViewById(R.id.tv_reimburse_type);
                holder.tv_reimburse_je= (TextView) convertView.findViewById(R.id.tv_reimburse_je);
                holder.tv_reimburse_xmmc= (TextView) convertView.findViewById(R.id.tv_reimburse_xmmc);
                holder.tv_reimburse_rqr= (TextView) convertView.findViewById(R.id.tv_reimburse_rqr);
                holder.tv_reimburse_ywlx= (TextView) convertView.findViewById(R.id.tv_reimburse_ywlx);
                holder.tv_reimburse_sqrq= (TextView) convertView.findViewById(R.id.tv_reimburse_sqrq);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
                }
                    String s2 =lists.get(position).getSCOPETYPE_ID();
                    String m = "";
                    if (s2.equals("JKD")) {
                        m = "借款单";
                    } else if (s2.equals("ZCBXD")) {
                        m = "支出报销单";
                    } else if (s2.equals("QTYSZCBXD")) {
                        m = "其他预算支出报销单";
                    } else if (s2.equals("ZPLYD")) {
                        m = "支票领用单";
                    } else if (s2.equals("WGCCBXD")) {
                        m = "外埠出差报销单";
                    } else if (s2.equals("XJZCBXD")) {
                        m = "现金支出报销单";
                    }
                    holder.tv_reimburse_bxdlb.setText(m);
                    holder.tv_reimburse_type.setText(lists.get(position).getEXAMINE_STATE());
                    if ("通过".equals(lists.get(position).getEXAMINE_STATE())) {
                        holder.tv_reimburse_type.setTextColor(Color.parseColor("#4ad261"));
                    } else {
                        holder.tv_reimburse_type.setTextColor(Color.parseColor("#ff8200"));
                    }
                    holder.tv_reimburse_je.setText("金额:" + "￥" + lists.get(position).getCLAIM_SUM());
                    holder.tv_reimburse_xmmc.setText(lists.get(position).getUNIT_NAME());
                    holder.tv_reimburse_rqr.setText("申请人:" + lists.get(position).getCLAIM_REALUSER());
                    holder.tv_reimburse_ywlx.setText(lists.get(position).getCLAIMTYPE_ID());
                    holder.tv_reimburse_sqrq.setText(lists.get(position).getCLAIM_TIME());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_reimburse_bxdlb,tv_reimburse_type,tv_reimburse_je
                ,tv_reimburse_xmmc,tv_reimburse_rqr,tv_reimburse_ywlx,tv_reimburse_sqrq;
    }
    private void showMuchTrend(){
        psu.showPopupSearch(getViews(), toolbar);
        parientView= toolbar;
        tv_reimburse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_reimburse_xmmc.setOnClickListener(this);
        ed_reimburse_sqsj.setOnClickListener(this);
        ed_reimburse_ywlx.setOnClickListener(this);
        ed_reimburse_sqjd.setOnClickListener(this);
        ed_reimburse_bxdlx.setOnClickListener(this);
        but_reimburse_search.setOnClickListener(this);

    }
    private ListView initListView(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("tableName","SELECT_FACTORY");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERPAYBOXLIST, prams,
                ProjectNameResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYPAYBOXLIST, this, false).setTag(this);
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
        prams.put("typeCode","FYLX");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSELECT, prams,
                BusinessTypeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView3(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("flowCode","YWLC10005");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSCHEDULE, prams,
                ScheduleResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYSCHEDULE, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView4(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","BXDLB");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSELECT, prams,
                AddTypResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT, this, false).setTag(this);
        return mListViews;
    }
    class MyBusinessAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mBusiness.getData().getComboboxList().size();
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
                convertView = View.inflate(ReimbursementActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mBusiness.getData().getComboboxList().get(position).getText());
            return convertView;
        }
        class ViewHolder{
            TextView v_listview_item_number;
        }
    }
    class MyScheduleAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mSchedule.getData().getComboboxList().size();
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
                convertView = View.inflate(ReimbursementActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mSchedule.getData().getComboboxList().get(position).getText());
            return convertView;
        }
        class ViewHolder{
            TextView v_listview_item_number;
        }
    }
    class MyTypeAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mAddType.getData().getComboboxList().size();
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
                convertView = View.inflate(ReimbursementActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mAddType.getData().getComboboxList().get(position).getText());
            return convertView;
        }
        class ViewHolder{
            TextView v_listview_item_number;
        }
    }
    private void show(int page){
        HashMap<String, Object> prams2 = new HashMap<>();
        if (ed_reimburse_ywlx!=null&&ed_reimburse_sqjd!=null&&ed_reimburse_sqsj!=null
                && ed_reimburse_bxdlx!=null&&ed_reimburse_xmmc!=null){
            String ywlx = ed_reimburse_ywlx.getText().toString();
            String sqjd = ed_reimburse_sqjd.getText().toString();
            String sqsj = ed_reimburse_sqsj.getText().toString();
            String sqdlx = ed_reimburse_bxdlx.getText().toString();
            String xmmc = ed_reimburse_xmmc.getText().toString();
        if(!"".equals(ywlx)&&!"null".equals(ywlx)&&ywlx!=null){
            prams2.put("claimtypeId",ywlx);
        }
        if(!"".equals(sqjd)&&!"null".equals(sqjd)&&sqjd!=null){
            prams2.put("examineState",sqjd);
        }
        if(!"".equals(sqsj)&&!"null".equals(sqsj)&&sqsj!=null){
            prams2.put("claimTime",sqsj);
        }
        String codeId="";
        if(!"".equals(sqdlx)&&!"null".equals(sqdlx)&&sqdlx!=null){
            for(int i=0;i<mAddType.getData().getComboboxList().size();i++){
                if(sqdlx.equals(mAddType.getData().getComboboxList().get(i).getText())){
                    codeId=mAddType.getData().getComboboxList().get(i).getId();
                }
                prams2.put("scopetypeId", codeId);
            }
        }
        if(!"".equals(xmmc)&&!"null".equals(xmmc)&&xmmc!=null){
            prams2.put("claimDep",xmCode);
        }
    }
        prams2.put("nodeId", arr[1]);
        prams2.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFILLFIND, prams2,
                ReimbursementResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFILLFIND, this, false).setTag(this);
    }
}
