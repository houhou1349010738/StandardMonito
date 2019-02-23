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
import com.smartwasser.yunzhishui.bean.EquipTypeResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.LegerListResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SkContractResponse;
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
 * Created by huangmengjie on 2016/6/17 0017.
 */
public class LedgerActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ImageButton image_serc,image_add,button_fan;
    private ListView list_ledger;
    private MyAdapter adapter;
    private ListView minlistView,minlistView2;
    private EditText ed_ledger_zcbianhao,ed_ledger_sbname,ed_ledger_sbleibie,ed_ledger_danwei;
    private ImageButton image_ledger_sbleibie,image_ledger_danwei;
    private Button but_ledger_search;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private TextView tv_ledgerser;
    private View parientView;
    private EquipTypeResponse mEquip;
    private Toolbar toolbar;
    private SimpleTreeListViewAdapter3 mAdapter,mAdapter2;
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private int page=1;
    private int i=0;
    private LegerListResponse  mLeger;
    private SubordinateResponse mSubord;
    private String code="";
    private String SubordCode="";
    private TreeListUtils tlu=new TreeListUtils();
    private EventNormSelect morn=new EventNormSelect();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List<LegerListResponse.DataEntity.EqEquipInfoEntity.RowsEntity> lists=new ArrayList<>();
    @Override
    protected int initContentView() {
        return R.layout.activity_ledger;
    }
    @Override
    protected void initView() {
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_add.setVisibility(View.GONE);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        list_ledger= (ListView) findViewById(R.id.list_ledger);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
    }
    @Override
    protected void initListener() {
        image_serc.setOnClickListener(this);
        button_fan.setOnClickListener(this);
        image_add.setOnClickListener(this);
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
        tv_toolbar_zhu.setText("设备运行");
        tv_toolbar_centext.setText("设备台账");
        HashMap<String, Object> params = new HashMap<>();
        params.put("page",1);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBLEGERLIST, params, LegerListResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBLEGERLIST, this, false).setTag(this);

    }
    public View getView(){
        View view=View.inflate(this,R.layout.popup_ledgersearch,null);
        ed_ledger_zcbianhao= (EditText)view.findViewById(R.id.ed_ledger_zcbianhao);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_serc:
                showMuchTrend();
                break;
            case R.id.button_fan:
                finish();
                break;
            case R.id.ed_ledger_sbleibie:
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView, parientView, ed_ledger_sbleibie.getWidth() - 4, (int) (GetScreenParam.getScreenWidth(this) * 0.264),(int) (GetScreenParam.getScreenHeight(this) * 0.250));
                break;
            case R.id.ed_ledger_danwei:
                minlistView2=initListView2();
                pwtu.showPopupWindow(minlistView2, parientView, ed_ledger_danwei.getWidth() - 4, (int) (GetScreenParam.getScreenWidth(this) * 0.264),(int) (GetScreenParam.getScreenHeight(this) * 0.308));
                break;
            case R.id.but_ledger_search:
                /**搜索*/
                psu.colsePopupWindow();
                page=1;
                lists.clear();
                flag=false;
                show(page);
                break;
            case R.id.image_add:
                Intent intent=new Intent(LedgerActivity.this,AddLedgerActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBLEGERLIST
                && response instanceof  LegerListResponse) {
            mLeger = (LegerListResponse)response;
            if("00000".equals(mLeger.getErrorCode())){
                if(!flag){
                    total= mLeger.getData().getEqEquipInfo().getTotal();
                }
                for(int n=0;n<mLeger.getData().getEqEquipInfo().getRows().size();n++){
                    lists.add(mLeger.getData().getEqEquipInfo().getRows().get(n));
                }
                list_ledger.setVisibility(View.VISIBLE);
                if(adapter==null){
                    adapter=new MyAdapter();
                    list_ledger.setAdapter(adapter);
                }else {
                    adapter.notifyDataSetChanged();
                }
            myRefreshListView.setRefreshing(false);
            myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    list_ledger.setVisibility(View.GONE);
                    myRefreshListView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mLeger = null;
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
             list_ledger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* *跳转到设备管理详情页*/
                String s=lists.get(position).getEquipId();
                String sss=lists.get(position).getIsFiling();
                String ss=lists.get(position).getEquipUseStatusName();
                String ssss=lists.get(position).getEquipLocCodeName();
                morn.setLedgerId(s);
                morn.setFiling(sss);
                morn.setStatusName(ss);
                morn.setLocCodeName(ssss);
                EventBus.getDefault().postSticky(morn);
                Intent intent = new Intent(LedgerActivity.this, LedgerDetailActivity.class);
                startActivity(intent);
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
                mAdapter2= new SimpleTreeListViewAdapter3(minlistView2,this,
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
                        for (int i = 0; i < mSubord.getData().getListTree().size(); i++) {
                            if (node.getName().equals(mSubord.getData().getListTree().get(i).getBusinessUnitName())) {
                                SubordCode = mSubord.getData().getListTree().get(i).getBusinessUnitCode();
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

    class MyAdapter extends BaseAdapter{
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
                holder=new ViewHolder();
                convertView=View.inflate(LedgerActivity.this,R.layout.item_ledger,null);
                holder.tv_ledger_bianhao= (TextView) convertView.findViewById(R.id.tv_ledger_bianhao);
                holder.tv_ledger_start= (TextView) convertView.findViewById(R.id.tv_ledger_start);
                holder.tv_ledger_name= (TextView) convertView.findViewById(R.id.tv_ledger_name);
                holder.tv_ledger_xinghao= (TextView) convertView.findViewById(R.id.tv_ledger_xinghao);
                holder.tv_ledger= (TextView) convertView.findViewById(R.id.tv_ledger);
                holder.tv_ledger_zcbh= (TextView) convertView.findViewById(R.id.tv_ledger_zcbh);
                holder.tv_ledger_sydw= (TextView) convertView.findViewById(R.id.tv_ledger_sydw);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_ledger_bianhao.setText("编号:" + lists.get(position).getEquipCode());
            String s=lists.get(position).getEquipUseStatusName();
            if("淘汰".equals(s)){
                holder.tv_ledger_start.setTextColor(Color.parseColor("#e10305"));
            }else if("运行".equals(s)){
                holder.tv_ledger_start.setTextColor(Color.parseColor("#77b92b"));
            }
            holder.tv_ledger_start.setText(s);
            holder.tv_ledger_name.setText("设备名称:" + lists.get(position).getEquipName());
            holder.tv_ledger_xinghao.setText("型号:" +lists.get(position).getEquipModel());
            holder.tv_ledger.setText(lists.get(position).getTypeName());
            String zcbh=lists.get(position).getAsCode();
            if("".equals(zcbh)||"null".equals(zcbh)||zcbh==null){
                zcbh="";
            }
            holder.tv_ledger_zcbh.setText("资产编号:" +zcbh);
            String sydw=lists.get(position).getEquipOwnDeptName();
            if("".equals(sydw)||"null".equals(sydw)||sydw==null){
                sydw="";
            }
            holder.tv_ledger_sydw.setText("使用单位:" +sydw);
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_ledger_bianhao, tv_ledger_start,
                tv_ledger_name,tv_ledger_xinghao,tv_ledger
                ,tv_ledger_zcbh,tv_ledger_sydw;
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
    private void show(int page){
        HashMap<String, Object> params = new HashMap<>();
        if(ed_ledger_danwei!=null&&ed_ledger_sbleibie!=null&&ed_ledger_zcbianhao!=null&&
                ed_ledger_sbname!=null){
        String danwei=ed_ledger_danwei.getText().toString();
        String leibie=ed_ledger_sbleibie.getText().toString();
        String bianhao=ed_ledger_zcbianhao.getText().toString();
        String sbname= ed_ledger_sbname.getText().toString();
        if("".equals(danwei)){
            SubordCode="";
        }
        if(!"".equals(danwei)&&!"null".equals(danwei)&&danwei!=null){
            params.put("equipOwnDept",SubordCode);
        }
        if("".equals(leibie)){
            code="";
        }
        if(!"".equals(leibie)&&!"null".equals(leibie)&&leibie!=null){
            params.put("typeCode",code);
        }
        if(!"".equals(sbname)&&!"null".equals(sbname)&&sbname!=null){
            params.put("equipName",sbname);
        }
        if(!"".equals(bianhao)&&!"null".equals(bianhao)&&bianhao!=null){
            params.put("asCode",bianhao);
        }
        }
        params.put("page",page);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBLEGERLIST, params, LegerListResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBLEGERLIST,this, false).setTag(this);
    }
}
