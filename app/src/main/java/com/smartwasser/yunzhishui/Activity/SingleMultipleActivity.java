package com.smartwasser.yunzhishui.Activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.GropLxindeAdapter;
import com.smartwasser.yunzhishui.adapter.GropNormAdapter;
import com.smartwasser.yunzhishui.adapter.LxindeAdapter;
import com.smartwasser.yunzhishui.adapter.NormAdapter;
import com.smartwasser.yunzhishui.adapter.PopupAdapter;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.FindBuComBoxResponse;
import com.smartwasser.yunzhishui.bean.IndeFindReaponse;
import com.smartwasser.yunzhishui.bean.IndeGropReaponse;
import com.smartwasser.yunzhishui.bean.LxIndeResponse;
import com.smartwasser.yunzhishui.bean.LxindeGropResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TimeUtils;
import com.smartwasser.yunzhishui.utils.TreeListUtils;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class SingleMultipleActivity extends BaseActivity implements HttpLoader.ResponseListener,View.OnClickListener,TextWatcher{
    private ListView list_norm;
    private TextView tv_toolbar;
    private ImageButton button_menu,norm_ser;
    private GropLxindeAdapter myAdapter4;
    private GropNormAdapter mNormAdapters;
    private int page=1;
    /**搜索的控件*/
    private EditText dateAndTimeLabel;
    private EditText dateAndTime2,ed_shortcut;
    private EditText ed_norm_danwei,ed_zhibiao_norm;
    private Button but_search_norm;
    private Toolbar toolbar;
    private TextView tv_singlemultiple;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private  PopupAdapter myAdapter;
    private  ListView minitListView;
    private List<String> mListView;
    private TimeUtils time=new TimeUtils();
    private ListView minitListView2;
    private LxindeGropResponse mGropLxinde;
    private FindBuComBoxResponse mFindBu;
    private SimpleTreeListViewAdapter mAdapter;
    private String code;
    private  ListView minitListView3;
    private  ListView minitListView4;
    private LxIndeResponse mLxinde;
    private LxindeAdapter myAdapter3;
    private String indeCode;
    private IndeFindReaponse mIndeFind;
    private NormAdapter mNormAdapter;
    private int i=0;
    private String s,s2;
    private  View parientView;
    private EventNormSelect norms;
    private IndeGropReaponse mIndeGropFind;
    private RefreshLayout myRefreshListView;
    private TreeListUtils tlu=new TreeListUtils();
    private PopupWindowTwoUtil pwut=new PopupWindowTwoUtil();
    private TextView  iv_zhibiao_norm;
    private Handler mHandler = new Handler();
    private List<IndeFindReaponse.DataEntity.DailyIndeListEntity> lists=new ArrayList<>();
    private List<IndeGropReaponse.DataEntity.DailyIndeGrpListEntity> listGroups=new ArrayList<>();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return  R.layout.activity_norm;
    }
    @Override
    protected void initView() {
        list_norm= (ListView)findViewById(R.id.list_norm);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        toolbar= (Toolbar)findViewById(R.id.toolbar);
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
        toolbar.setTitle("");
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        EventBus.getDefault().registerSticky(this);
        time.showTimeShortcut();
        mHandler.postDelayed(mRunnable, 300);
    }
    private Runnable mRunnable = new Runnable() {
        public void run() {
            // 弹出PopupWindow的具体代码
            showSearch();
        }
    };
    @Override
    protected void initListener() {
    }
    @Override
    protected void initData() {
        if(norms.getTags()==1){
            tv_toolbar.setText("按指标查询");
        }else  if(norms.getTags()==2){
            tv_toolbar.setText("按指标组查询");
        }
        toolbar.setNavigationIcon(R.drawable.fanhui);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_menu.setVisibility(View.GONE);
        norm_ser.setVisibility(View.VISIBLE);
        norm_ser.setOnClickListener(this);
        /**
         * 设置下拉刷新的颜色
         */
        myRefreshListView.setColorSchemeResources(android.R.color.holo_blue_bright
                , android.R.color.holo_orange_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_light
        );
        myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myRefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIndeFind = null;
                        mIndeGropFind = null;
                        listGroups.clear();
                        lists.clear();
                        if (norms.getTags() == 1) {
                            normWork(1);
                        } else if (norms.getTags() == 2) {
                            normWork2(1);
                        }
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
                        if (norms.getTags() == 1) {
                            loadDatas();
                        } else if (norms.getTags() == 2) {
                            loadDatas2();
                        }
                        myRefreshListView.setLoading(false);
                    }
                }, 2000);

            }
        });
    }

    private void  loadDatas(){
        page++;
        showProgressDialog();
        HashMap<String, Object> params = new HashMap<>();
          params.put("dateFrom", s);
          params.put("dateTo", s2);
          params.put("assuUnit", code);
          params.put("page", page);
          params.put("indeCode", indeCode);
        HttpLoader.get(ConstantsYunZhiShui.URL_INDEFIND, params, IndeFindReaponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_INDEFIND, this,false).setTag(this);
        showProgressDialog();
    }
    private void  loadDatas2(){
        page++;
        showProgressDialog();
        HashMap<String, Object> params = new HashMap<>();
        params.put("dateFrom", s);
        params.put("dateTo", s2);
        params.put("assuUnit", code);
        params.put("page", page);
        params.put("indeCode", indeCode);
        HttpLoader.get(ConstantsYunZhiShui.URL_INDEGROPFIND, params, IndeGropReaponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_INDEGROPFIND, this,false).setTag(this);
        showProgressDialog();
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM
                && response instanceof FindBuComBoxResponse) {
            mFindBu = (FindBuComBoxResponse) response;
            if("00000".equals(mFindBu.getErrorCode())) {
                tlu.initDataText(mFindBu);
                try {
                    mAdapter = new SimpleTreeListViewAdapter(minitListView2, this,
                            tlu.mDatas2, 0);
                    minitListView2.setAdapter(mAdapter);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        if (node.isleaf()) {
                            ed_norm_danwei.setText(node.getName());
                            for (int i = 0; i < mFindBu.getData().getListTree().size(); i++) {
                                if (node.getName().equals(mFindBu.getData().getListTree().get(i).getBusinessUnitName())) {
                                    code = mFindBu.getData().getListTree().get(i).getBusinessUnitCode();
                                }
                            }
                            pwut.closePopupWindow();
                        }
                    }
                });
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_LXINDE
                && response instanceof LxIndeResponse){
            mLxinde= (LxIndeResponse) response;
            if("00000".equals(mLxinde.getErrorCode())) {
                myAdapter3 = new LxindeAdapter(mLxinde, this);
                minitListView3.setAdapter(myAdapter3);
                minitListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        i++;
                        pwut.closePopupWindow();
                        ed_zhibiao_norm.setText(mLxinde.getData().getIndeList().get(position).getIndeName());
                        indeCode = mLxinde.getData().getIndeList().get(position).getIndeCode();
                    }
                });
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_INDEFIND
                && response instanceof IndeFindReaponse){
               mIndeFind=(IndeFindReaponse)response;
            if("00014".equals(mIndeFind.getErrorCode())){
                Toast.makeText(SingleMultipleActivity.this, "这个时间段没有数据", Toast.LENGTH_SHORT).show();
            }
            if("00000".equals(mIndeFind.getErrorCode())) {
                  for(int i=0;i<mIndeFind.getData().getDailyIndeList().size();i++){
                      lists.add(mIndeFind.getData().getDailyIndeList().get(i));
                    }
                    mNormAdapter = new NormAdapter(this,lists);
                    list_norm.setAdapter(mNormAdapter);
                myRefreshListView.setRefreshing(false);
            }
            dismissProgressDialog();
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_LXGROPINDE
                && response instanceof LxindeGropResponse){
            mGropLxinde= (LxindeGropResponse) response;
            if("00000".equals( mGropLxinde.getErrorCode())) {
                myAdapter4 = new GropLxindeAdapter(mGropLxinde, this);
                minitListView4.setAdapter(myAdapter4);
                minitListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        i++;
                        pwut.closePopupWindow();
                        ed_zhibiao_norm.setText(mGropLxinde.getData().getIndeList().get(position).getIndegrpName());
                        indeCode = mGropLxinde.getData().getIndeList().get(position).getIndegrpCode();
                    }
                });
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_INDEGROPFIND
                && response instanceof IndeGropReaponse){
            mIndeGropFind=(IndeGropReaponse)response;
            if("00014".equals(mIndeGropFind.getErrorCode())){
                Toast.makeText(SingleMultipleActivity.this, "此时间段没有数据", Toast.LENGTH_SHORT).show();
            }
            if("00000".equals( mIndeGropFind.getErrorCode())){
                  for(int j=0;j<mIndeGropFind.getData().getDailyIndeGrpList().size();j++){
                     listGroups.add(mIndeGropFind.getData().getDailyIndeGrpList().get(i));
                  }
                mNormAdapters = new GropNormAdapter(this,listGroups);
                list_norm.setAdapter(mNormAdapters);
                myRefreshListView.setRefreshing(false);
            }
            dismissProgressDialog();
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {

    }
    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }
    private View getViews(){
        View view=View.inflate(this,R.layout.activity_norm_select,null);
        dateAndTimeLabel= (EditText)view.findViewById(R.id.ed_kaishi_time);
        dateAndTime2= (EditText)view.findViewById(R.id.ed_end_time);
        ed_shortcut= (EditText)view.findViewById(R.id.ed_kuaijie_time);
        iv_zhibiao_norm= (TextView) view.findViewById(R.id.iv_zhibiao_norm);
        but_search_norm= (Button)view.findViewById(R.id.but_search_norm);
        ed_norm_danwei= (EditText)view.findViewById(R.id.ed_norm_danwei);
        ed_zhibiao_norm= (EditText)view.findViewById(R.id.ed_zhibiao_norm);
        tv_singlemultiple= (TextView) view.findViewById(R.id.tv_singlemultiple);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.norm_ser:
                showSearch();
                break;
            case R.id.ed_kaishi_time:
                dialog.show(dateAndTimeLabel);
                dialog.showTime();
                break;
            case R.id.ed_end_time:
                dialog.show(dateAndTime2);
                dialog.showTime();
                break;
            case R.id.ed_kuaijie_time:
                // 初始化ListView控件和里边的数据
                minitListView = initListView();
                pwut.showPopupWindow(minitListView,parientView,ed_shortcut.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.388),(int)(GetScreenParam.getScreenHeight(this)*0.218));
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<String> list =time.showTimeShortcut();
                        if(position>=1) {
                            dateAndTimeLabel.setText(list.get(position * 2 - 2));
                            dateAndTime2.setText(list.get(position * 2 - 1));
                            ed_shortcut.setText(mListView.get(position));
                        }
                        pwut.closePopupWindow();
                    }
                });
                break;
            /**查询接口*/
            case R.id.but_search_norm:
                if(norms.getTags()==1){
                    normWork(1);
                }else if(norms.getTags()==2){
                    normWork2(1);
                }
                break;
            case R.id.ed_norm_danwei:
                minitListView2 =initListView2();
                pwut.showPopupWindow(minitListView2, parientView,ed_norm_danwei.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.231),(int)(GetScreenParam.getScreenHeight(this)*0.052));
                break;
        }
    }
    /**文本改变前调用的方法*/
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    /**文本改变调用的方法*/
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int tags = norms.getTags();
        if (tags==1){
              minitListView3 = initListView3(s.toString());
          if (i != 1 || "".equals(s.toString())) {
              pwut.showPopupWindow(minitListView3, parientView, ed_zhibiao_norm.getWidth() - 4,(int)(GetScreenParam.getScreenWidth(this)*0.231),(int)(GetScreenParam.getScreenHeight(this)*0.104));
           }
       }else if(tags==2){
            minitListView4 = initListView4(s.toString());
            if (i != 1 || "".equals(s.toString())) {
                pwut.showPopupWindow(minitListView4, parientView, ed_zhibiao_norm.getWidth() - 4,(int)(GetScreenParam.getScreenWidth(this)*0.231),(int)(GetScreenParam.getScreenHeight(this)*0.104));
            }
        }
    }
    /**文本改变之后调用的方法*/
    @Override
    public void afterTextChanged(Editable s){

    }
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        mListView = new ArrayList<String>();
        // 模拟数据
        mListView.add("快速查找");
        mListView.add("本周");
        mListView.add("上周");
        mListView.add("本月");
        mListView.add("上月");
        mListView.add("本年");
        mListView.add("上年");
        mListView.add("本季度");
        mListView.add("上季度");
        myAdapter = new PopupAdapter(mListView,this);
        mListViews.setAdapter(myAdapter);
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
        prams.put("tableName","DAILY_WATER");
        HttpLoader.get(ConstantsYunZhiShui.URL_FINDBUCOM, prams,
                FindBuComBoxResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView3(String s) {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        if(!"".equals(code)&&code!=null&&!"null".equals(code)){
            prams.put("assuUnit",code);
        }
        if(s==null||"".equals(s)||"null".equals("")){
            s="0";
        }
        prams.put("indeName",s);
        HttpLoader.get(ConstantsYunZhiShui.URL_LXINDE, prams,
                LxIndeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LXINDE, this, false).setTag(this);
        return mListViews;
    }
    public void normWork(int page){
        /**调用查询接口*/
        HashMap<String, Object> params = new HashMap<>();
        s = dateAndTimeLabel.getText().toString().trim();
        s2 = dateAndTime2.getText().toString().trim();
        if(s==null||"".equals(s)||"null".equals(s)){
            Toast.makeText(SingleMultipleActivity.this, "请输入查询时间", Toast.LENGTH_SHORT).show();
            return;
        }
        if(code==null||"".equals(code)||"null".equals(code)){
            Toast.makeText(SingleMultipleActivity.this, "选择单位名称", Toast.LENGTH_SHORT).show();
            return;
        }
        if(indeCode==null||"".equals(indeCode)||"null".equals(indeCode)){
            Toast.makeText(SingleMultipleActivity.this, "选择指标名称", Toast.LENGTH_SHORT).show();
            return;
        }
        psu.colsePopupWindow();
        showProgressDialog();
        params.put("assuUnit", code);
        params.put("dateFrom", s);
        params.put("dateTo", s2);
        params.put("page",page);
        params.put("indeCode", indeCode);
        HttpLoader.get(ConstantsYunZhiShui.URL_INDEFIND, params,IndeFindReaponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_INDEFIND,this,false).setTag(this);
        showProgressDialog();
    }
    private void showSearch(){
        psu.showPopupSearch(getViews(), toolbar);
        tv_singlemultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        parientView=toolbar;
        dateAndTimeLabel.setOnClickListener(this);
        dateAndTime2.setOnClickListener(this);
        ed_shortcut.setOnClickListener(this);
        but_search_norm.setOnClickListener(this);
        ed_norm_danwei.setOnClickListener(this);
        ed_zhibiao_norm.addTextChangedListener(this);
        if(norms.getTags()==1){
            iv_zhibiao_norm.setText("指标选择");
        }else if(norms.getTags()==2){
            iv_zhibiao_norm.setText("指标组选择");
        }
    }
    private ListView initListView4(String s) {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        if(!"".equals(code)&&code!=null&&!"null".equals(code)){
            prams.put("assuUnit",code);
        }
        if(s==null||"".equals(s)||"null".equals("")){
            s="0";
        }
        prams.put("indegrpName", s);
        HttpLoader.get(ConstantsYunZhiShui.URL_LXGROPINDE, prams,
                LxindeGropResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LXGROPINDE, this, false).setTag(this);
        return mListViews;
    }
  public void onEvent(EventNormSelect norm){
      norms=norm;
  }
    public void normWork2(int page){
        /**调用查询接口*/
        HashMap<String, Object> params = new HashMap<>();
        s = dateAndTimeLabel.getText().toString().trim();
        s2 = dateAndTime2.getText().toString().trim();
        if(code==null||"".equals(code)||"null".equals(code)){
            Toast.makeText(SingleMultipleActivity.this, "选择单位名称", Toast.LENGTH_SHORT).show();
            return;
        }
        if(indeCode==null||"".equals(indeCode)||"null".equals(indeCode)){
            Toast.makeText(SingleMultipleActivity.this, "选择指标名称", Toast.LENGTH_SHORT).show();
            return;
        }
        if(s==null||"".equals(s)||"null".equals(s)){
            Toast.makeText(SingleMultipleActivity.this, "请选择开始时间", Toast.LENGTH_SHORT).show();
            return;
        }
        if(s2==null||"".equals(s2)||"null".equals(s2)){
            Toast.makeText(SingleMultipleActivity.this, "请选择结束时间", Toast.LENGTH_SHORT).show();
            return;
        }
        psu.colsePopupWindow();
        showProgressDialog();
        params.put("dateFrom", s);
        params.put("assuUnit", code);
        params.put("dateTo", s2);
        params.put("page", page);
        params.put("indegrpCode", indeCode);
        HttpLoader.get(ConstantsYunZhiShui.URL_INDEGROPFIND, params, IndeGropReaponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_INDEGROPFIND,this,false).setTag(this);
        showProgressDialog();
    }
}
