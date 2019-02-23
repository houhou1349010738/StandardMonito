package com.smartwasser.yunzhishui.productionactivity;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.AddTypResponse;
import com.smartwasser.yunzhishui.bean.BusinessTypeResponse;
import com.smartwasser.yunzhishui.bean.ProjectNameResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.ScheduleResponse;
import com.smartwasser.yunzhishui.fragment.AllListFragment;
import com.smartwasser.yunzhishui.fragment.FunctionFragment;
import com.smartwasser.yunzhishui.fragment.PendingAuditFragment;
import com.smartwasser.yunzhishui.fragment.ReimburseFragment;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import java.util.HashMap;

/**
 * Created by huangmengjie on 2016/7/20 0020.
 */
public class FunctionAuditActivity extends FragmentActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private AllListFragment mReimburse;
    private ImageView iv1;
    private float moveTo=0.0f;
    private FunctionFragment mPendingAuditFragment;
    private TextView tv_mei1,tv_mei2;
    private TextView tv_toolbar_centext,tv_toolbar_zhu;
    private ImageButton button_fan,image_add,image_serc;

    /***搜索控件的声明*/
    private EditText ed_reimburse_xmmc,ed_reimburse_ywlx,
            ed_reimburse_sqsj,ed_reimburse_sqjd,ed_reimburse_bxdlx;
    private ImageButton image_reimburse_xmmc,image_reimburse_ywlx
            ,image_weight_startTiem,image_reimburse_sqjd,image_reimburse_bxdlx;
    private Button but_reimburse_search;
    private TextView tv_reimburse;
    private View  parientView;
    private Toolbar toolbar;
    private ListView minlistView,minlistView2,minlistView3,minlistView4;
    private  TextView tv_weight_cphsd;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private MyBusinessAdapter mBusinAdapter;
    private ScheduleResponse mSchedule;
    private MyScheduleAdapter mSchedAdapter;
    private AddTypResponse mAddType;
    private MyTypeAdapter mTypeAdapter;
    private ProjectNameResponse mProject;
    private DialogTimeUtils dialogs=new DialogTimeUtils(this);
    private SimpleTreeListViewAdapter3 mAdapter;
    private  BusinessTypeResponse mBusiness;
    private TreeListUtils tlu=new TreeListUtils();
    private String xmCode="";
    private  String codeId="", ywlx,sqjd,sqsj,sqdlx;
    private float currPosition=0,toPosition=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reimburse_audit);
        initView();
    }
    private void initView() {
        iv1= (ImageView) findViewById(R.id.iv1);
        tv_mei1= (TextView) findViewById(R.id.tv_mei1);
        tv_mei2= (TextView) findViewById(R.id.tv_mei2);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        initData();
    }
    private void initData() {
        tv_mei1.setOnClickListener(this);
        tv_mei2.setOnClickListener(this);
        mReimburse=new  AllListFragment ();
        image_add.setVisibility(View.GONE);
        image_serc.setOnClickListener(this);
        tv_toolbar_centext.setText("职能部门审核");
        tv_toolbar_zhu.setText("生产成本");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.layout, mReimburse, "REIMBURSE")
                .commit();
        PlayAnimtion(0);
    }

    /**将横线画出来*/
    public void drawLine(){
        /**得到屏幕的宽度*/
        DisplayMetrics metrics=new DisplayMetrics();
        WindowManager win= (WindowManager) getSystemService(WINDOW_SERVICE);
        win.getDefaultDisplay().getMetrics(metrics);
        int screenw=metrics.widthPixels;
        /**重新绘制宽度*/
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) iv1.getLayoutParams();
        params.width=screenw/2;
        iv1.setLayoutParams(params);
        moveTo=params.width;
    }
                /**播放动画*/
    public void PlayAnimtion(int position){
        drawLine();
        /**得到开始值*/
         currPosition=iv1.getTranslationX();
         toPosition=position*moveTo;
         ObjectAnimator animator=ObjectAnimator.ofFloat(iv1,"translationX",currPosition,toPosition);
         animator.setDuration(300);
         animator.start();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_mei1:
                mReimburse=new  AllListFragment ();
                getSupportFragmentManager().
                        beginTransaction()
                        .replace(R.id.layout, mReimburse, "REIMBURSE")
                        .commit();
                PlayAnimtion(0);
                break;
            case R.id.tv_mei2:
                mPendingAuditFragment=new FunctionFragment();
                getSupportFragmentManager().
                        beginTransaction()
                        .replace(R.id.layout,mPendingAuditFragment,"PENDING")
                        .commit();
                PlayAnimtion(1);
                break;
            case R.id.image_serc:
                showMuchTrend();
                ywlx="";
                sqjd="";
                sqsj="";
                sqdlx="";
                break;
            case R.id. ed_reimburse_xmmc:
                /**项目名称*/
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView,parientView,ed_reimburse_xmmc.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.11));
                break;
            case R.id.ed_reimburse_ywlx:
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
            case R.id.ed_reimburse_bxdlx:
                /**报销单类型*/
                minlistView4=initListView4();
                pwtu.showPopupWindow(minlistView4,parientView,ed_reimburse_bxdlx.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.36));
                break;
            case R.id.but_reimburse_search:
                ywlx=ed_reimburse_ywlx.getText().toString();
                sqjd=ed_reimburse_sqjd.getText().toString();
                sqsj=ed_reimburse_sqsj.getText().toString();
                sqdlx=ed_reimburse_bxdlx.getText().toString();
                String xmmc=ed_reimburse_xmmc.getText().toString();
                if(!"".equals(sqdlx)&&!"null".equals(sqdlx)&&sqdlx!=null){
                    for(int i=0;i<mAddType.getData().getComboboxList().size();i++){
                        if(sqdlx.equals(mAddType.getData().getComboboxList().get(i).getText())){
                            codeId=mAddType.getData().getComboboxList().get(i).getId();
                        }
                    }
                }
                if(sqdlx==null||"".equals(sqdlx)||"null".equals(v)){
                    codeId="";
                }
                if(xmmc==null||"".equals(xmmc)||"null".equals(xmmc)){
                    xmCode="";
                }
                /**点击查询就传过去了*/
                if(currPosition==0.0&&toPosition==540.0){
                    mPendingAuditFragment=new FunctionFragment();
                    mPendingAuditFragment.setPrams(ywlx,sqsj,codeId, xmCode);
                           /**重新替换*/
                    getSupportFragmentManager().
                            beginTransaction()
                            .replace(R.id.layout,mPendingAuditFragment,"PENDING")
                            .commit();
                    psu.colsePopupWindow();
                }else{
                    mReimburse=new  AllListFragment ();
                    mReimburse.setPraments(ywlx,sqjd,sqsj,codeId,xmCode);
                    getSupportFragmentManager().
                            beginTransaction()
                            .replace(R.id.layout, mReimburse, "REIMBURSE")
                            .commit();
                    psu.colsePopupWindow();
                }
                break;
        }
    }
    private View getViews(){
        View view=View.inflate(this,R.layout.popup_reimburse,null);
        ed_reimburse_xmmc= (EditText) view.findViewById(R.id.ed_reimburse_xmmc);
        tv_weight_cphsd= (TextView) view.findViewById(R.id.tv_weight_cphsd);
        ed_reimburse_ywlx= (EditText) view.findViewById(R.id.ed_reimburse_ywlx);
        ed_reimburse_sqsj= (EditText) view.findViewById(R.id.ed_reimburse_sqsj);
        ed_reimburse_sqjd= (EditText) view.findViewById(R.id.ed_reimburse_sqjd);
        ed_reimburse_bxdlx= (EditText) view.findViewById(R.id. ed_reimburse_bxdlx);
        image_reimburse_xmmc= (ImageButton) view.findViewById(R.id.image_reimburse_xmmc);
        image_weight_startTiem= (ImageButton) view.findViewById(R.id.image_weight_startTiem);
        image_reimburse_ywlx=(ImageButton) view.findViewById(R.id.image_reimburse_ywlx);
        image_reimburse_sqjd=(ImageButton) view.findViewById(R.id.image_reimburse_sqjd);
        image_reimburse_bxdlx=(ImageButton) view.findViewById(R.id.image_reimburse_bxdlx);
        but_reimburse_search= (Button) view.findViewById(R.id.but_reimburse_search);
        tv_reimburse= (TextView)view.findViewById(R.id.tv_reimburse);
        ImageView image= (ImageView) view.findViewById(R.id.faeoifiww);
        if(currPosition==0.0&&toPosition==540.0) {
            tv_weight_cphsd.setVisibility(View.GONE);
            image_reimburse_sqjd.setVisibility(View.GONE);
            ed_reimburse_sqjd.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
        }
        return view;
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

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
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
                                xmCode= mProject.getData().getListTree().get(i).getId();
                                System.out.println(xmCode);
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
    class MyBusinessAdapter extends BaseAdapter {
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
                convertView = View.inflate(FunctionAuditActivity.this, R.layout.item_search, null);
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
                convertView = View.inflate(FunctionAuditActivity.this, R.layout.item_search, null);
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
                convertView = View.inflate(FunctionAuditActivity.this, R.layout.item_search, null);
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
}
