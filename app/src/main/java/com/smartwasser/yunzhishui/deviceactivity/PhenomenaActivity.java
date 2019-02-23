package com.smartwasser.yunzhishui.deviceactivity;

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
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.HitchBuweiResponse;
import com.smartwasser.yunzhishui.bean.HitchPhenomenaResponse;
import com.smartwasser.yunzhishui.bean.HitchTypeResponse;
import com.smartwasser.yunzhishui.bean.LegerListResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TreeListUtils;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/6 0006.
 */
public class PhenomenaActivity extends BaseActivity implements View.OnClickListener, HttpLoader.ResponseListener{
    private Toolbar toolbar;
    private TextView tv_toolbar;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private  View parientView;
    private int page=1;
    private int i=0;
    private ImageButton norm_ser,button_menu;
    private EditText ed_ledger_zcbianhao,ed_ledger_sbname,ed_ledger_sbleibie,ed_ledger_danwei;
    private ImageButton image_ledger_gzleibie,image_ledger_gzbuwei;
    private Button but_ledger_search;
    private  TextView tv_ledgerser;
    private ListView phenomentList;
    private HitchPhenomenaResponse mPhenomena;
    private MyAdapter myAdapter;
    private String code="";
    private SimpleTreeListViewAdapter3 mAdapter;
    private ListView minlistView,minlistView2;
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private TreeListUtils tlu=new TreeListUtils();
    private  HitchTypeResponse mHitchType;
    private HitchBuweiResponse mHitchBuwei;
    private String buweiCode="";
    private MyAdapters myAdapter2;
    private EventSearchResponse en=new EventSearchResponse();
    private EventNormSelect s2;
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List<HitchPhenomenaResponse.DataEntity.EqTroubleAppearEntity.RowsEntity> lists=new ArrayList<>();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return R.layout.activity_phenomena;
    }
    @Override
    protected void initView() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        phenomentList= (ListView) findViewById(R.id.phenomentList);
        norm_ser.setVisibility(View.VISIBLE);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        norm_ser.setOnClickListener(this);
        button_menu.setOnClickListener(this);
    }
    public View getViews(){
        View view=View.inflate(this,R.layout.popup_pheno,null);
        ed_ledger_sbname= (EditText)view.findViewById(R.id.ed_ledger_sbname);
        ed_ledger_sbleibie= (EditText)view.findViewById(R.id.ed_ledger_sbleibie);
        ed_ledger_danwei= (EditText)view.findViewById(R.id.ed_ledger_danwei);
        image_ledger_gzleibie= (ImageButton)view.findViewById(R.id.image_ledger_sbleibie);
        but_ledger_search= (Button)view.findViewById(R.id.but_ledger_search);
        image_ledger_gzbuwei= (ImageButton) view.findViewById(R.id.image_ledger_danwei);
        tv_ledgerser= (TextView) view.findViewById(R.id.tv_ledgerser);
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
        tv_toolbar.setText("故障现象选择");
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", 1);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZXX, params, HitchPhenomenaResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBGZXX, this, false).setTag(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
            break;
            case R.id.norm_ser:
                /**搜索*/
                showMuchTrend();
                break;
            case R.id. ed_ledger_sbleibie:
                 /**故障类别*/
                /**点击故障类别*/
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView,parientView,ed_ledger_sbleibie.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.264),(int)(GetScreenParam.getScreenHeight(this)*0.184));
                break;
            case R.id.ed_ledger_danwei:
                 /**故障部位*/
                minlistView2=initListView2();
                pwtu.showPopupWindow(minlistView2,parientView,ed_ledger_danwei.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.264),(int)(GetScreenParam.getScreenHeight(this)*0.235));
                break;
            case R.id.but_ledger_search:
                 /**查询*/
                psu.colsePopupWindow();
                page=1;
                lists.clear();
                flag=false;
                show(page);
                break;
        }
    }
    private void showMuchTrend(){
        psu.showPopupSearch(getViews(), toolbar);
        parientView= toolbar;
        tv_ledgerser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_ledger_sbleibie.setOnClickListener(this);
        ed_ledger_danwei.setOnClickListener(this);
        but_ledger_search.setOnClickListener(this);
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
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZXX
                && response instanceof HitchPhenomenaResponse) {
            mPhenomena = (HitchPhenomenaResponse) response;
            if("00000".equals(mPhenomena.getErrorCode())){
                if(!flag){
                    total=  mPhenomena.getData().getEqTroubleAppear().getTotal();
                }
                for(int n=0;n< mPhenomena.getData().getEqTroubleAppear().getRows().size();n++){
                    lists.add(mPhenomena.getData().getEqTroubleAppear().getRows().get(n));
                }
                phenomentList.setVisibility(View.VISIBLE);
                if( myAdapter==null){
                    myAdapter = new MyAdapter();
                    phenomentList.setAdapter(myAdapter);
                }else {
                    myAdapter.notifyDataSetChanged();
                }
                myRefreshListView.setRefreshing(false);
                myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        phenomentList.setVisibility(View.GONE);
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mPhenomena= null;
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

            phenomentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String s =lists.get(position).getAppearContent();
                    en.setPhenomen(s);
                    en.setmList2(s2.getList2());
                    en.setMhitchCodebuwei(s2.getHitchbuweiCode());
                    en.setMhitchCode(s2.getHitchCode());
                    int i = 2;
                    en.setTempAdd(i);
                    en.setUpdateId(s2.getGxId());
                    en.setSbNameCode(s2.getHitcUpdatehCode());
                    EventBus.getDefault().postSticky(en);
                    Intent intent = new Intent(PhenomenaActivity.this, AddHitchActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZLB
                && response instanceof HitchTypeResponse) {
            mHitchType= ( HitchTypeResponse) response;
            tlu.initDataText2(mHitchType);
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
                        ed_ledger_sbleibie.setText(node.getName());
                        code= mHitchType.getData().getListTree().get(position).getId();
                        pwtu.closePopupWindow();
                    }
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI
                && response instanceof  HitchBuweiResponse) {
            mHitchBuwei= (HitchBuweiResponse) response;
            myAdapter2=new MyAdapters();
            minlistView2.setAdapter(myAdapter2);
            minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_ledger_danwei.setText(mHitchBuwei.getData().getComboboxList().get(position).getText());
                    buweiCode=mHitchBuwei.getData().getComboboxList().get(position).getId();
                    pwtu.closePopupWindow();
                }
            });
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    class MyAdapter extends BaseAdapter {
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(PhenomenaActivity.this,R.layout.item_phenomena,null);
                holder=new ViewHolder();
                holder.tv_phenom_gzxx= (TextView) convertView.findViewById(R.id.tv_phenom_gzxx);
                holder.tv_hitch_zglb= (TextView)convertView.findViewById(R.id.tv_hitch_zglb);
                holder.tv_hitch_gzbw= (TextView) convertView.findViewById(R.id.tv_hitch_gzbw);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_phenom_gzxx.setText("故障现象:" + lists.get(position).getAppearContent());
            holder.tv_hitch_zglb.setText("故障类别:" + lists.get(position).getTypeCode());
            holder.tv_hitch_gzbw.setText("故障部位:"+lists.get(position).getAppearPartCode());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_phenom_gzxx,tv_hitch_zglb,tv_hitch_gzbw;
    }
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZLB, prams,
                HitchTypeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBGZLB, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2(){
        ListView mListView = new ListView(this);
        mListView.setDividerHeight(0);
        mListView.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListView.setVerticalScrollBarEnabled(false);
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","EQ_PART_CODE");
        HttpLoader.get(ConstantsYunZhiShui.URL_SBBUWEI, prams,
                HitchBuweiResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI, this, false).setTag(this);
        return mListView;
    }
    class MyAdapters extends BaseAdapter{
        @Override
        public int getCount() {
            return mHitchBuwei.getData().getComboboxList().size();
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
                convertView = View.inflate(PhenomenaActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mHitchBuwei.getData().getComboboxList().get(position).getText());
            return convertView;
        }
        class ViewHolder {
            TextView v_listview_item_number;
        }
    }
    public void onEvent(EventNormSelect ss){
        s2=ss;
    }
    private void show(int page){
        HashMap<String, Object> params = new HashMap<>();
        if(ed_ledger_sbname!=null&&ed_ledger_sbleibie!=null&&ed_ledger_danwei!=null) {
            String sbname = ed_ledger_sbname.getText().toString();
            String sbleibie = ed_ledger_sbleibie.getText().toString();
            String buwei = ed_ledger_danwei.getText().toString();
            if (!"".equals(sbname)&&sbname != null &&!"null".equals(sbname)) {
                params.put("appearContent", sbname);
            }
            if ("".equals(sbleibie)) {
                code = "";
            }
            if (!"".equals(sbleibie) && sbleibie != null && !"null".equals(sbleibie)) {
                params.put("typeCode", code);
            }
            if ("".equals(buwei)) {
                buweiCode = "";
            }
            if (!"".equals(buwei) && buwei != null && !"null".equals(buwei)) {
                params.put("appearPartCode", buweiCode);
            }
        }
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZXX, params, HitchPhenomenaResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBGZXX, this, false).setTag(this);
    }
}
