package com.smartwasser.yunzhishui.pager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.AmendActivity;
import com.smartwasser.yunzhishui.Activity.AuditActivity;
import com.smartwasser.yunzhishui.Activity.LookDataActivity;
import com.smartwasser.yunzhishui.Activity.WaterworksDayActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.DataReportAdapter;
import com.smartwasser.yunzhishui.adapter.PopupAdapter;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.AmendToEditResponse;
import com.smartwasser.yunzhishui.bean.DataReportResponse;
import com.smartwasser.yunzhishui.bean.DeleteResponse;
import com.smartwasser.yunzhishui.bean.EventLookData;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.FindBuComBoxResponse;
import com.smartwasser.yunzhishui.bean.HasAddResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.WorkDay;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TimeUtils;
import com.smartwasser.yunzhishui.utils.TreeListUtils;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import org.seny.android.utils.MyToast;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
import android.app.AlertDialog.Builder;
/**
 * Created by huangmengjie on 2016/5/5 0005.
 */
public class ReportPager extends BasePager implements HttpLoader.ResponseListener,View.OnClickListener{
    public ListView list_report;
    private int page=1;
    private  HasAddResponse mAddResponese;
    private DataReportAdapter mAdapter;
    private  Context mcontext;
    private  DataReportResponse mResponese;
    private  String stat;
    private boolean flag=false;
    private WorkDay mWorkResponese;
    private boolean isLastRow=false;
    private  String nextPageCode;
    private    String extId;
    private   String eid;
    public String nodeId;
    public  EventLookData  mlookdata = new EventLookData();
    private  AmendToEditResponse  mToEditResponse;
    private   String addTime;
    private  String addName;
    private   String pageCode;
    private EventSearchResponse search;
    private  String flowCode;
           /**搜索*/
    private TextView data_search;
    private EditText ed_adddanwei,ed_zhibiao;
    private PopupAdapter myAdapter3;
    private Button but_search;
    private EditText dateAndTimeLabel;
    private EditText dateAndTime2,ed_shortcut;
    private View  parientView;

    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private ListView minitListView2;
    private  ListView minitListView3;
    private  ListView minitListView;
    private TimeUtils time=new TimeUtils();
    private String code;
    private FindBuComBoxResponse mFindBu;
    private SimpleTreeListViewAdapter mAdapters;
    private TreeListUtils tlu=new TreeListUtils();
    private List<String> mListZt;
    private  RefreshLayout myRefreshListView;
    private  DataReportResponse m=null;
    private  int total;
    private boolean flags=false;
    private List<DataReportResponse.DataEntity.RundataUpDailyListEntity.RowsEntity>  lists=new ArrayList<>();
    private PopupSearchUtils psu=new PopupSearchUtils((WaterworksDayActivity)context);
    public ReportPager(Context context) {
        super(context);
        this.mcontext=context;

    }
    @Override
    public View initViews() {
        view=View.inflate(context,R.layout.pager_workreport,null);
        list_report= (ListView) view.findViewById(R.id.list_report);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                view.findViewById(R.id.swipe_layout);
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().registerSticky(this);
        EventBus.getDefault().postSticky(list_report);
        initData();
        return view;
    }
    @Override
    public void initDatas(){
        /**
         * 设置下拉刷新的颜色
         */
        myRefreshListView.setColorSchemeResources(android.R.color.holo_blue_bright
                , android.R.color.holo_orange_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_light
        );
    }
    private void initData(){
        HashMap<String, Object> params5 = new HashMap<>();
        params5.put("flowCode", search.getFlowCode());
        HttpLoader.get(ConstantsYunZhiShui.URL_DAILY, params5, WorkDay.class,
                ConstantsYunZhiShui.REQUEST_CODE_DAILY, this, false).setTag(this);
        ((WaterworksDayActivity)context).mreport.image_serc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   showMuchTrend();
            }
        });

    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        /**成功网络请求*/
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_DAILY
                && response instanceof WorkDay) {
                mWorkResponese =(WorkDay) response;
            if("00000".equals(mWorkResponese.getErrorCode())) {
                pageCode = mWorkResponese.getData().getAddNode().getFlowPage();
                nodeId = mWorkResponese.getData().getAddNode().getId();
                flowCode = mWorkResponese.getData().getAddNode().getFlowCode();
                String nodeIndex = mWorkResponese.getData().getAddNode().getNodeCode();
                String upStat = mWorkResponese.getData().getAddNode().getNode_Name();
                String flowNodeCode = mWorkResponese.getData().getAddNode().getNodeId();
                mlookdata.setWork_pageCode(pageCode);
                mlookdata.setWork_flowCode(flowCode);
                mlookdata.setWork_id(nodeId);
                mlookdata.setFolwCodes(search.getFlowCode());
                mlookdata.setTableName(search.getTableName());
                mlookdata.setWork_nodeIndex(nodeIndex);
                mlookdata.setWork_flowNodeCode(flowNodeCode);
                mlookdata.setWork_upStat(upStat);
                  /**网络请求*/
                    show();
            }
        }
                    /**成功网络请求*/
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_DAILYLIST
                && response instanceof DataReportResponse){
                mResponese= (DataReportResponse)response;
                if("00000".equals(mResponese.getErrorCode())) {
                    if(!flags) {
                        total =mResponese.getData().getRundataUpDailyList().getTotal();
                    }else{
                        lists.clear();
                    }
                    for(int i=0;i<mResponese.getData().getRundataUpDailyList().getRows().size();i++){
                            if(!mResponese.equals(m)) {
                                lists.add(mResponese.getData().getRundataUpDailyList().getRows().get(i));
                            }
                    }
                    if(mAdapter==null){
                        mAdapter=new DataReportAdapter(context,lists);
                        list_report.setAdapter(mAdapter);
                    }else{
                        mAdapter.notifyDataSetChanged();
                    }
                    myRefreshListView.setRefreshing(false);
                    myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            myRefreshListView.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mResponese = null;
                                    page=1;
                                    flags = true;
                                    select(page);
                                }
                            }, 2000);
                        }
                    });
                    // 加载监听器
                    myRefreshListView.setOnLoadListener(new RefreshLayout.OnLoadListener() {
                        @Override
                        public void onLoad() {
                            myRefreshListView.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    loadDatas();
                                    flags = false;
                                    myRefreshListView.setLoading(false);
                                }
                            }, 2000);

                        }
                    });
                    m=mResponese;
                    /**发起网络请求*/
                    HashMap<String,Object> params2 = new HashMap<>();
                    params2.put("flowCode", flowCode);
                    HttpLoader.get(ConstantsYunZhiShui.URL_HASADD, params2, HasAddResponse.class,
                            ConstantsYunZhiShui.REQUEST_CODE_HASADD, this, false).setTag(this);
                    showList();
                }
            dismissProgressDialog();
        }
       if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_HASADD
               && response instanceof HasAddResponse) {
           mAddResponese = (HasAddResponse) response;
           if (mAddResponese.getData()!=null) {
               if (mAddResponese.getData().isHasAdd()) {
                   flag = true;
               } else {
                   flag = false;
               }
               EventBus.getDefault().postSticky(flag);
           }
       }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_TOEDIT
                && response instanceof AmendToEditResponse) {
            mToEditResponse = (AmendToEditResponse) response;
            if ("00000".equals(mToEditResponse .getErrorCode())) {
                nextPageCode = mToEditResponse.getData().getNextNode().getFlowPage();
                String Node_name = mToEditResponse.getData().getNextNode().getNode_Name();
                mlookdata.setNextPageCode(nextPageCode);
                mlookdata.setNode_name(Node_name);
                String addNode_flowCode = mWorkResponese.getData().getAddNode().getFlowCode();
                String addNode_upstat = mWorkResponese.getData().getAddNode().getNode_Name();
                String addNode_flowNodeCode = mWorkResponese.getData().getAddNode().getNodeId();
                String addNode_nodeInex = mWorkResponese.getData().getAddNode().getNodeCode();
                mlookdata.setAddNode_flowCode(addNode_flowCode);
                mlookdata.setAddNode_upstat(addNode_upstat);
                mlookdata.setAddNode_flowNodeCode(addNode_flowNodeCode);
                mlookdata.setAddNode_nodeInex(addNode_nodeInex);
                if ("1".equals(stat)) {
                    EventBus.getDefault().postSticky(mlookdata);
                    Intent intent8 = new Intent(context, AmendActivity.class);//跳到修改页
                    intent8.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent8);
                }
                if("2".equals(stat)){
                    EventBus.getDefault().postSticky(mlookdata);
                    Intent intent = new Intent(context, AuditActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                if(("3".equals(stat))){
                    EventBus.getDefault().postSticky(mlookdata);
                    Intent intent = new Intent(context, AuditActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_DELETE
                && response instanceof DeleteResponse){
            DeleteResponse mDelete=(DeleteResponse)response;
            if("00000".equals(mDelete.getErrorCode())){
                Toast.makeText(context, "已删除", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                mAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM
                && response instanceof FindBuComBoxResponse) {
            mFindBu = (FindBuComBoxResponse) response;
            tlu.initDataText(mFindBu);
            try {
                mAdapters = new SimpleTreeListViewAdapter(minitListView2,mcontext,
                        tlu.mDatas2, 0);
                minitListView2.setAdapter(mAdapters);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mAdapters.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                @Override
                public void onClick(Node node, int position) {
                    if (node.isleaf()) {
                        ed_adddanwei.setText(node.getName());
                        for(int i=0;i< mFindBu .getData().getListTree().size();i++){
                            if(node.getName().equals(mFindBu .getData().getListTree().get(i).getBusinessUnitName())){
                                code = mFindBu.getData().getListTree().get(i).getBusinessUnitCode();
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
        MyToast.show(context, "error: " + error.getMessage());
    }
    /**
     * 模拟加载数据
     */
    private void loadDatas(){
                   page++;
        if(total+10>(page*10)) {
            myRefreshListView.pull_to_refresh_loadmore_text.setText("玩命加载中");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.VISIBLE);
            select(page);
        }else{
            myRefreshListView.pull_to_refresh_loadmore_text.setText("没有更多数据了.....");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.GONE);
        }

   }
    /** 弹出自定义密码对话框的方法 */
    private AlertDialog dialog;
    public void showPwdAlertDialog(final int i) {
        View view = View.inflate(context, R.layout.dialog_paw, null);
        Button but_pwd_ok = (Button) view.findViewById(R.id.but_pwd_ok);
        Button but_pwd_cancel = (Button) view.findViewById(R.id.but_pwd_cancel);
        Builder builder = new Builder(context);
        builder.setView(view);
        builder.setCancelable(false);
        but_pwd_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /**掉用删除接口*/
                String id=lists.get(i).getId();
                lists.remove(i);
                HashMap<String, Object> params = new HashMap<>();
                params.put("id", id);
                HttpLoader.get(ConstantsYunZhiShui.URL_DELETE, params, DeleteResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_DELETE, ReportPager.this,false).setTag(this);
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
    private void requestShow(String s2,String s3,String s4,String s5,String s6){
        /**发起网络请求*/
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("tableName", search.getTableName());
        map.put("assuUnit", s2);
        map.put("dataData", s3);
        map.put("extId", s4);
        map.put("id", s5);
        map.put("addNodeId",s6);
        HttpLoader.get(ConstantsYunZhiShui.URL_TOEDIT, map,
                AmendToEditResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TOEDIT, ReportPager.this,false).setTag(this);
    }
    public void onEvent(EventSearchResponse search){
        this.search=search;
    }
          /**如何将第二次请求的数据添加到后面*/
    public void showList(){
        /**Item的长按点击事件*/
        list_report.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showPwdAlertDialog(position);
                return true;
            }
        });
        list_report.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                stat = lists.get(position).getNodeIndex();
                addTime = lists.get(position).getDataDate();
                addName = lists.get(position).getAssuUnit();
                String name = lists.get(position).getReviewManName();
                String folwCode = lists.get(position).getFlowCode();
                extId = lists.get(position).getExtId();
                eid = lists.get(position).getId();
                String upStat = lists.get(position).getUpStat();
                String flowNodeCode = lists.get(position).getFlowNodeCode();
                String nodeInex = lists.get(position).getNodeIndex();
                mlookdata.setAddName(addName);
                mlookdata.setAddTime(addTime);
                mlookdata.setPageCode(pageCode);
                mlookdata.setName(name);
                mlookdata.setFolwCode(folwCode);
                mlookdata.setExtId(extId);
                mlookdata.setUpStat(upStat);
                mlookdata.setFlowNodeCode(flowNodeCode);
                mlookdata.setNodeInex(nodeInex);
                mlookdata.setEid(eid);
                /**stat*/
                if ("1".equals(stat)) {
                    if (mAddResponese.getData().isHasEdit()) {
                        requestShow(addName, addTime, extId, eid, nodeId);
                    } else {
                        EventBus.getDefault().postSticky(mlookdata);
                        Intent intent3 = new Intent(context, LookDataActivity.class);//跳到详情页
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent3);
                    }
                } else if ("2".equals(stat)) {
                    if (mAddResponese.getData().isHasCheck()) {
                        requestShow(addName, addTime, extId, eid, nodeId);
                    } else {
                        /**进入详情页*/
                        EventBus.getDefault().postSticky(mlookdata);
                        Intent intent = new Intent(context, LookDataActivity.class);//跳到详情页
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                } else if ("3".equals(stat)) {
                    if (mAddResponese.getData().isHasReview()) {
                        requestShow(addName, addTime, extId, eid, nodeId);
                    } else {
                        /**进入详情页*/
                        EventBus.getDefault().postSticky(mlookdata);
                        Intent intent3 = new Intent(context, LookDataActivity.class);//跳到详情页
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent3);
                    }
                } else {
                    /**进入详情页*/
                    EventBus.getDefault().postSticky(mlookdata);
                    Intent intent3 = new Intent(context, LookDataActivity.class);//跳到详情页
                    intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent3);
                }
            }
        });
    }
    private void showMuchTrend(){
        psu.showPopupSearch4(getViews(), ((WaterworksDayActivity)context).mreport.toolbar);
        parientView= ((WaterworksDayActivity)context).mreport.toolbar;
        data_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        dateAndTimeLabel.setOnClickListener(this);
        dateAndTime2.setOnClickListener(this);
        ed_shortcut.setOnClickListener(this);
        ed_adddanwei.setOnClickListener(this);
        ed_zhibiao.setOnClickListener(this);
        but_search.setOnClickListener(this);
    }
    private View getViews(){
        View view=View.inflate(context,R.layout.popup_search,null);
        dateAndTimeLabel= (EditText) view.findViewById(R.id.ed_kaishi_time);
        dateAndTime2= (EditText)view.findViewById(R.id.ed_end_time);
        ed_shortcut= (EditText)view.findViewById(R.id.ed_kuaijie_time);
        but_search= (Button)view.findViewById(R.id.but_search);
        ed_adddanwei= (EditText)view.findViewById(R.id.ed_adddanwei);
        ed_zhibiao= (EditText)view.findViewById(R.id.ed_zhibiao);
        data_search= (TextView)view.findViewById(R.id.data_search);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ed_kaishi_time:
                DialogTimeUtils dialog = new DialogTimeUtils(mcontext);
                dialog.show(dateAndTimeLabel);
                dialog.showTime();
                break;
            case R.id.ed_end_time:
                DialogTimeUtils dialog2 = new DialogTimeUtils(mcontext);
                dialog2.show(dateAndTime2);
                dialog2.showTime();
                break;
            case R.id.ed_kuaijie_time:
                // 初始化ListView控件和里边的数据
                final PopListViewUtils plus = new PopListViewUtils(mcontext);
                minitListView = plus.initListView();
                pwtu.showPopupWindow(minitListView, parientView, ed_shortcut.getWidth() - 4, (int) (GetScreenParam.getScreenWidth((WaterworksDayActivity)mcontext) * 0.37), (int) (GetScreenParam.getScreenHeight((WaterworksDayActivity)mcontext) * 0.22));
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<String> list = time.showTimeShortcut();
                        if (position >= 1) {
                            dateAndTimeLabel.setText(list.get(position * 2 - 2));
                            dateAndTime2.setText(list.get(position * 2 - 1));
                            ed_shortcut.setText(plus.mListView.get(position));
                        }
                        pwtu.closePopupWindow();
                    }
                });
                break;
            case R.id.but_search:
                psu.colsePopupWindow();
                page=1;
                flags=false;
                lists.clear();
                select(page);
                break;
            case R.id.ed_adddanwei:
                minitListView2 = initListView2();
                pwtu.showPopupWindow(minitListView2, parientView, ed_adddanwei.getWidth() - 4, (int) (GetScreenParam.getScreenWidth((WaterworksDayActivity)mcontext) * 0.213), (int) (GetScreenParam.getScreenHeight((WaterworksDayActivity)mcontext) * 0.052));
                break;
            case R.id.ed_zhibiao:
                minitListView3 = initListView3();
                pwtu.showPopupWindow(minitListView3, parientView, ed_zhibiao.getWidth() - 4, (int) (GetScreenParam.getScreenWidth((WaterworksDayActivity)mcontext) * 0.213), (int) (GetScreenParam.getScreenHeight((WaterworksDayActivity)mcontext) * 0.104));
                minitListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_zhibiao.setText(mListZt.get(position));
                        pwtu.closePopupWindow();
                    }
                });
                break;
        }
    }
    private ListView initListView3() {
        ListView mListViews3 = new ListView(mcontext);
        mListViews3.setDividerHeight(0);
        mListViews3.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews3.setVerticalScrollBarEnabled(false);
        mListZt = new ArrayList<>();
        mListZt.add("填报");
        mListZt.add("复核");
        mListZt.add("审核");
        mListZt.add("集团审核");
        myAdapter3 = new PopupAdapter(mListZt, mcontext);
        mListViews3.setAdapter(myAdapter3);
        return mListViews3;
    }
    private ListView initListView2() {
        ListView mListViews = new ListView(mcontext);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("tableName",mlookdata.getTableName());
        HttpLoader.get(ConstantsYunZhiShui.URL_FINDBUCOM, prams,
                FindBuComBoxResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM, this, false).setTag(this);
        return mListViews;
    }
    public  void select(int page){
        HashMap<String, Object> params = new HashMap<>();
        if (dateAndTimeLabel != null && dateAndTime2 != null && ed_zhibiao != null) {
            String s = dateAndTimeLabel.getText().toString().trim();
            String s2 = dateAndTime2.getText().toString().trim();
            String s3 = ed_zhibiao.getText().toString().trim();
            /**调用查询接口*/
            try {
                URLEncoder.encode(s3, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (!"".equals(code) && !"null".equals(code) && code != null) {
                params.put("assuUnit", code);
            }
            if (!"".equals(s) && !"null".equals(s) && s != null) {
                params.put("startTime1", s);
            }
            if (!"".equals(s2) && !"null".equals(s2) && s2 != null) {
                params.put("startTime2", s2);
            }
            if (!"".equals(s3) && !"null".equals(s3) && s3 != null) {
                params.put("upStat", s3);
            }
        }
        params.put("page", page);
        params.put("flowCode", flowCode);
        params.put("tableName", search.getTableName());
        HttpLoader.get(ConstantsYunZhiShui.URL_DAILYLIST, params, DataReportResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_DAILYLIST, this, false).setTag(this);
    }
    private void show(){
        showProgressDialog();
        HashMap<String, Object> params = new HashMap<>();
        params.put("page",1);
        params.put("flowCode",flowCode);
        params.put("tableName",search.getTableName());
        HttpLoader.get(ConstantsYunZhiShui.URL_DAILYLIST, params,DataReportResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_DAILYLIST,this,false).setTag(this);
        showProgressDialog();
    }
}
