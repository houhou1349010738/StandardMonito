package com.smartwasser.yunzhishui.deviceactivity;


import android.content.Intent;
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
import com.smartwasser.yunzhishui.adapter.HitchAdapter;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EquipTypeResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.HitchResponse;
import com.smartwasser.yunzhishui.bean.LegerListResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SubordinateResponse;
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
public class EquipSelectActivity extends BaseActivity implements HttpLoader.ResponseListener,View.OnClickListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
    private MyAdapter myAdapter;
    private  LegerListResponse  mLeger;
    private ListView list;
    private ImageButton norm_ser;
    private EquipTypeResponse mEquip;
    private Toolbar toolbar;
    private int page=1;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private EditText ed_ledger_zcbianhao,ed_ledger_sbname,ed_ledger_sbleibie,ed_ledger_danwei;
    private ImageButton image_ledger_sbleibie,image_ledger_danwei;
    private Button but_ledger_search;
    private TextView tv_ledgerser;
    private View parientView;
    private ListView minlistView,minlistView2;
    private int i=0;
    private SimpleTreeListViewAdapter3 mAdapter;
    private SimpleTreeListViewAdapter mAdapter2;
    private TreeListUtils tlu=new TreeListUtils();
    private SubordinateResponse mSubord;
    private String code="";
    private String SubordCode="";
    private EventNormSelect es;
    private EventSearchResponse s2=new EventSearchResponse();
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List<LegerListResponse.DataEntity.EqEquipInfoEntity.RowsEntity> lists=new ArrayList<>();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return R.layout.activity_equip;
    }
    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        norm_ser.setVisibility(View.VISIBLE);
        list= (ListView) findViewById(R.id.list);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
        EventBus.getDefault().registerSticky(this);
    }
    public View getViews(){
        View view=View.inflate(this,R.layout.popup_equipsearch,null);
        ed_ledger_sbname= (EditText)view.findViewById(R.id.ed_ledger_sbname);
        ed_ledger_sbleibie= (EditText)view.findViewById(R.id.ed_ledger_sbleibie);
        ed_ledger_danwei= (EditText)view.findViewById(R.id.ed_ledger_danwei);
        image_ledger_sbleibie= (ImageButton)view.findViewById(R.id.image_ledger_sbleibie);
        but_ledger_search= (Button)view.findViewById(R.id.but_ledger_search);
        image_ledger_danwei= (ImageButton) view.findViewById(R.id.image_ledger_danwei);
        tv_ledgerser= (TextView) view.findViewById(R.id.tv_ledgerser);
        return view;
    }
    @Override
    protected void initListener() {
        norm_ser.setOnClickListener(this);
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
        tv_toolbar.setText("设备和使用单位选择");
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", 1);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBLEGERLIST, params, LegerListResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBLEGERLIST,this, false).setTag(this);

    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response){
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBLEGERLIST
                && response instanceof  LegerListResponse) {
            mLeger = (LegerListResponse) response;
            if("00000".equals(mLeger.getErrorCode())){
                if(!flag){
                    total=  mLeger.getData().getEqEquipInfo().getTotal();
                }
                for(int n=0;n< mLeger.getData().getEqEquipInfo().getRows().size();n++){
                    lists.add(mLeger.getData().getEqEquipInfo().getRows().get(n));
                }
                list.setVisibility(View.VISIBLE);
                if( myAdapter==null){
                    myAdapter = new MyAdapter();
                    list.setAdapter(myAdapter);
                }else {
                    myAdapter.notifyDataSetChanged();
                }
                myRefreshListView.setRefreshing(false);
                myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        list.setVisibility(View.GONE);
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mLeger= null;
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
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String sbName = lists.get(position).getEquipName();
                    String sbNameCode =  lists.get(position).getEquipCode();
                    String zcbm = lists.get(position).getAsCode();
                    String sbDanwei = lists.get(position).getEquipOwnDeptName();
                    String sbDanweiCode =lists.get(position).getEquipOwnDept();
                    s2.setSbName(sbName);
                    s2.setSbNameCode(sbNameCode);
                    s2.setSbDanwei(sbDanwei);
                    s2.setAsCode(zcbm);
                    s2.setUpdateId(es.getGxId());
                    s2.setMnAdd(es.getmAdds());
                    s2.setMnAddState(es.getmAddState());
                    s2.setMaintainId(es.getMainId());
                    s2.setSbDanweiCode(sbDanweiCode);
                    s2.setmList(es.getList());
                    s2.setMhitchCode(es.getHitchCode());
                    s2.setMhitchCodebuwei(es.getHitchbuweiCode());
                    s2.setUpdateId(es.getGxId());
                    int i = 1;
                    s2.setTempAdd(i);
                    EventBus.getDefault().postSticky(s2);
                    if (es.getTemp() == 2) {
                        Intent intent = new Intent(EquipSelectActivity.this, AddHitchActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (es.getTemp() == 0) {
                        Intent intent = new Intent(EquipSelectActivity.this, AddWorkDanMxActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (es.getTemp() == 1) {
                        Intent intent = new Intent(EquipSelectActivity.this, HitchUpdateActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (es.getTemp() == 3) {
                        Intent intent = new Intent(EquipSelectActivity.this, WorkDanMxUpdateActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            });
        }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBLB
                && response instanceof EquipTypeResponse) {
            mEquip= (EquipTypeResponse) response;
            tlu.initDataText3(mEquip);
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
                        for (int i = 0; i < mEquip.getData().getListTree().size(); i++) {
                            if (node.getName().equals(mEquip.getData().getListTree().get(i).getTypeName())) {
                                code = mEquip.getData().getListTree().get(position).getTypeCode();
                            }
                        }
                        pwtu.closePopupWindow();
                    }
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBSSDW
                && response instanceof SubordinateResponse) {
            mSubord= (SubordinateResponse) response;
            if(mSubord.getData()!=null){
                tlu.initDataText4(mSubord);
            }
            try {
                mAdapter2= new SimpleTreeListViewAdapter(minlistView2,this,
                        tlu.mDatas2,0);
                minlistView2.setAdapter(mAdapter2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mAdapter2.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                @Override
                public void onClick(Node node, int position) {
                    if (node.isleaf()) {
                        ed_ledger_danwei.setText(node.getName());
                        for(int i=0;i<mSubord.getData().getListTree().size();i++){
                            if(node.getName().equals(mSubord.getData().getListTree().get(i).getBusinessUnitName())){
                                SubordCode=mSubord.getData().getListTree().get(i).getBusinessUnitCode();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_ledger_search:
                psu.colsePopupWindow();
                 page=1;
                 lists.clear();
                 flag=false;
                 show(page);
                    break;
            case R.id.norm_ser:
                /**搜索*/
                showMuchTrend();
                break;
            case R.id.ed_ledger_sbleibie:
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView,parientView,ed_ledger_sbleibie.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.264),(int)(GetScreenParam.getScreenHeight(this)*0.184));
                break;
            case R.id.ed_ledger_danwei:
                minlistView2=initListView2();
                pwtu.showPopupWindow(minlistView2,parientView,ed_ledger_danwei.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.264),(int)(GetScreenParam.getScreenHeight(this)*0.235));
                break;
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
        HttpLoader.get(ConstantsYunZhiShui.URL_SBLB, prams,
                EquipTypeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBLB, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2(){
        ListView mListView = new ListView(this);
        mListView.setDividerHeight(0);
        mListView.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListView.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_SBSSDW, prams,
                SubordinateResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBSSDW, this, false).setTag(this);
        return mListView;
    }
    class MyAdapter extends BaseAdapter{
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
                convertView=View.inflate(EquipSelectActivity.this,R.layout.item_equip,null);
                holder=new ViewHolder();
                holder.tv_equip_sbname= (TextView) convertView.findViewById(R.id.tv_equip_sbname);
                holder.tv_equip_sydanwei= (TextView)convertView.findViewById(R.id.tv_equip_sydanwei);
                holder.tv_equip_sshudanwei= (TextView) convertView.findViewById(R.id.tv_equip_sshudanwei);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_equip_sbname.setText("设备名称:"+lists.get(position).getEquipName());
            holder.tv_equip_sydanwei.setText("使用单位:" + lists.get(position).getEquipOwnDeptName());
            holder.tv_equip_sshudanwei.setText("资产编码:"+lists.get(position).getAsCode());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_equip_sbname,tv_equip_sydanwei,tv_equip_sshudanwei;
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
    public void onEvent(EventNormSelect ess){
              es=ess;
    }
    private void show(int page) {
        HashMap<String, Object> params = new HashMap<>();
        if(ed_ledger_danwei!=null&&ed_ledger_sbleibie!=null&&ed_ledger_sbname!=null){
        String danwei = ed_ledger_danwei.getText().toString();
        String leibie = ed_ledger_sbleibie.getText().toString();
        String sbname = ed_ledger_sbname.getText().toString();
        /**查询*/
        if ("".equals(danwei)) {
            SubordCode = "";
        }
        if (!"".equals(danwei) && !"null".equals(danwei) && danwei != null) {
            params.put("equipOwnDept", SubordCode);
        }
        if ("".equals(leibie)) {
            code = "";
        }
        if (!"".equals(leibie) && !"null".equals(leibie) && leibie != null) {
            params.put("typeCode", code);
        }
        if (!"".equals(sbname) && !"null".equals(sbname) && sbname != null) {
            params.put("equipName", sbname);
        }
    }
        params.put("page",page);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBLEGERLIST, params, LegerListResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBLEGERLIST,this, false).setTag(this);
    }
}
