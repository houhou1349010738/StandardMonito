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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.ContractTypeResponse;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.ProjectNameResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SkContractResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
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
 * Created by huangmengjie on 2016/7/18 0018.
 */
public class ContractQueActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ImageButton image_add,image_serc,button_fan;
    private int page=1;
    private  SkContractResponse mSkContract;
    private MyContracAdapter  MyContrac;
    private ListView list_contract;
    private Toolbar toolbar;
    private ListView minlistView,minlistView2,minlistView3;
    private SimpleTreeListViewAdapter3 mAdapter;
    private  MyScheduleAdapter myTypeAdapter;
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private PopListViewUtils plu=new PopListViewUtils(this);
    private int i=0;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    /**搜索框*/
    private EditText ed_reimburse_htbh,ed_reimburse_xmmc,ed_reimburse_qdsj,
            ed_reimburse_sfht,ed_reimburse_htlx;
    private ImageButton image_reimburse_xmmc,image_weight_startTiem,
            image_reimburse_sfht,image_reimburse_htlx;
    private TextView tv_reimburse;
    private Button   but_reimburse_search;
    private View  parientView;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private TreeListUtils tlu=new TreeListUtils();
    private  ProjectNameResponse mProject;
    private  String  xmCode="";
    private DialogTimeUtils dialogs=new DialogTimeUtils(this);
    private  ContractTypeResponse mBusiness;
    private Button but_reimburse_chongzhi;
    private EventSearchResponse search=new EventSearchResponse();

    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List<SkContractResponse.DataEntity.ContrBasicEntity.RowsEntity> lists=new ArrayList<>();
    @Override
    protected int initContentView() {
        return R.layout.activity_contract;
    }

    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_add.setVisibility(View.GONE);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        list_contract= (ListView) findViewById(R.id.list_contract);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
    }
    private View getViews(){
        View view=View.inflate(this,R.layout.popup_contract,null);
        ed_reimburse_htbh= (EditText) view.findViewById(R.id.ed_reimburse_xmmc);
        ed_reimburse_xmmc= (EditText) view.findViewById(R.id.ed_reimburse_ywlx);
        ed_reimburse_qdsj= (EditText) view.findViewById(R.id.ed_reimburse_sqsj);
        ed_reimburse_sfht= (EditText) view.findViewById(R.id.ed_reimburse_sqjd);
        ed_reimburse_htlx= (EditText) view.findViewById(R.id.ed_reimburse_bxdlx);
        image_weight_startTiem= (ImageButton) view.findViewById(R.id.image_weight_startTiem);
        image_reimburse_xmmc=(ImageButton) view.findViewById(R.id.image_reimburse_ywlx);
        image_reimburse_sfht=(ImageButton) view.findViewById(R.id.image_reimburse_sqjd);
        image_reimburse_htlx=(ImageButton) view.findViewById(R.id.image_reimburse_bxdlx);
        but_reimburse_search= (Button) view.findViewById(R.id.but_reimburse_search);
        but_reimburse_chongzhi= (Button) view.findViewById(R.id.but_reimburse_chongzhi);
        tv_reimburse= (TextView)view.findViewById(R.id.tv_reimburse);
        return view;
    }
    @Override
    protected void initListener() {
        button_fan.setOnClickListener(this);
        image_serc.setOnClickListener(this);
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
        tv_toolbar_centext.setText("收款确认");
        /**请求网络*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("page", 1);
        prams.put("fundsType","SK");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFEED, prams,
                SkContractResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFEED, this, false).setTag(this);
    }
    private ListView initListView(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("tableName", "SELECT_FACTORY");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERPAYBOXLIST, prams,
                ProjectNameResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYPAYBOXLIST, this, false).setTag(this);
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
        prams.put("typeCode", "HTLXSK");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERTYPEMASTER, prams,
               ContractTypeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERTYPEMASTER, this, false).setTag(this);
        return mListViews;
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
             case R.id.ed_reimburse_ywlx:
                 /**项目名称*/
                 minlistView=initListView();
                 pwtu.showPopupWindow(minlistView,parientView,ed_reimburse_xmmc.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.17));
             break;
             case R.id.ed_reimburse_sqsj:
                 /**签订时间*/
                 dialogs.show(ed_reimburse_qdsj);
                 dialogs.showTime();
             break;
             case R.id.ed_reimburse_sqjd:
                 /**是否合同*/
                 minlistView2=plu.initListView7();
                 pwtu.showPopupWindow(minlistView2,parientView,ed_reimburse_sfht.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.29));
                 minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         ed_reimburse_sfht.setText(plu.mListView7.get(position));
                         pwtu.closePopupWindow();
                     }
                 });
             break;
             case R.id.ed_reimburse_bxdlx:
                 /**合同类型*/
                 minlistView3=initListView3();
                 pwtu.showPopupWindow(minlistView3,parientView,ed_reimburse_htlx.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.25),(int)(GetScreenParam.getScreenHeight(this)*0.36));
             break;
             case R.id.but_reimburse_search:
                 /**请求网络*/
                 ++i;
                 page=1;
                 lists.clear();
                 flag=false;
                 show(page);
                 break;
             case R.id.but_reimburse_chongzhi:
                 ed_reimburse_htbh.setText("");
                 ed_reimburse_qdsj.setText("");
                 ed_reimburse_xmmc.setText("");
                 ed_reimburse_sfht.setText("");
                 ed_reimburse_htlx.setText("");
                 break;
         }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFEED
                && response instanceof SkContractResponse) {
                mSkContract = (SkContractResponse) response;
            if("00000".equals(mSkContract.getErrorCode())) {
                if (!flag) {
                    total = mSkContract.getData().getContrBasic().getTotal();
                }
                for (int n = 0; n < mSkContract.getData().getContrBasic().getRows().size(); n++) {
                    lists.add(mSkContract.getData().getContrBasic().getRows().get(n));
                }
                list_contract.setVisibility(View.VISIBLE);
                if( MyContrac==null){
                   MyContrac = new MyContracAdapter();
                   list_contract.setAdapter(MyContrac);
                }else{
                    MyContrac.notifyDataSetChanged();
                }
                if (i != 0) {
                    psu.colsePopupWindow();
                }
                myRefreshListView.setRefreshing(false);
                myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        list_contract.setVisibility(View.GONE);
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mSkContract = null;
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
                list_contract.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        /**跳到详情页*/
                        search.setContractId(lists.get(position).getId());
                        search.setContracttype(lists.get(position).getType());
                        search.setContractunitName(lists.get(position).getUnitName());
                        EventBus.getDefault().postSticky(search);
                        Intent intent = new Intent(ContractQueActivity.this, ContractDetailsQueActicity.class);
                        startActivity(intent);
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
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERTYPEMASTER
                && response instanceof ContractTypeResponse) {
            /**类型*/
                mBusiness = (ContractTypeResponse) response;
            if("00000".equals( mBusiness.getErrorCode())){
                  /**设置适配器*/
                myTypeAdapter=new MyScheduleAdapter();
                minlistView3.setAdapter(myTypeAdapter);
                minlistView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_reimburse_htlx.setText( mBusiness.getData().getComboboxList().get(position).getText());
                        pwtu.closePopupWindow();
                    }
                });
            }
        }
    }
    class MyScheduleAdapter extends BaseAdapter{
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
                convertView = View.inflate(ContractQueActivity.this, R.layout.item_search, null);
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
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    class MyContracAdapter extends BaseAdapter{

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
                convertView=View.inflate(ContractQueActivity.this,R.layout.item_contract,null);
                holder=new ViewHolder();
                holder.tv_contract_lsdh= (TextView) convertView.findViewById(R.id.tv_contract_lsdh);
                holder.tv_contract_htmc= (TextView) convertView.findViewById(R.id.tv_contract_htmc);
                holder.tv_contract_ssxm= (TextView) convertView.findViewById(R.id.tv_contract_ssxm);
                holder.tv_contract_htje= (TextView) convertView.findViewById(R.id.tv_contract_htje);
                holder.tv_contract_yf= (TextView) convertView.findViewById(R.id.tv_contract_yf);
                holder.tv_contract_jz= (TextView) convertView.findViewById(R.id.tv_contract_jz);
                holder.tv_contract_htlx= (TextView) convertView.findViewById(R.id.tv_contract_htlx);
                holder.tv_contract_qdsj= (TextView) convertView.findViewById(R.id.tv_contract_qdsj);
                holder.but_zhixing= (ImageView) convertView.findViewById(R.id.but_zhixing);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_contract_lsdh.setText(lists.get(position).getContrCode());
            holder.tv_contract_htmc.setText("合同名称:"+"  "+lists.get(position).getContrName());
            holder.tv_contract_ssxm.setText("所属单位:" + "  " + lists.get(position).getUnitName());
            holder.tv_contract_htje.setText("合同金额:" + "  " + lists.get(position).getContrAmount());
            holder.tv_contract_yf.setText("乙   方:" + "  " + lists.get(position).getContrSecondParty());
            holder.tv_contract_jz.setText("资金类型:" + "  " + lists.get(position).getFundsType());
            holder.tv_contract_htlx.setText("合同类型:" + "  " + lists.get(position).getContrType());
            holder.tv_contract_qdsj.setText("签订时间:" + "  " + lists.get(position).getSignTime());
            return convertView;
        }
        class ViewHolder{
            TextView tv_contract_lsdh,tv_contract_htmc,tv_contract_ssxm
                    ,tv_contract_htje,tv_contract_yf,tv_contract_jz,
                    tv_contract_htlx,tv_contract_qdsj;
            ImageView but_zhixing;
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
        ed_reimburse_qdsj.setOnClickListener(this);
        ed_reimburse_sfht.setOnClickListener(this);
        ed_reimburse_htlx.setOnClickListener(this);
        but_reimburse_search.setOnClickListener(this);
        but_reimburse_chongzhi.setOnClickListener(this);
    }
    private void show(int page){
        HashMap<String, Object> prams = new HashMap<>();
        if(ed_reimburse_htbh!=null&&ed_reimburse_qdsj!=null&&ed_reimburse_xmmc!=null&&
            ed_reimburse_sfht!=null&&ed_reimburse_htlx!=null) {
            String htbh = ed_reimburse_htbh.getText().toString();
            String time = ed_reimburse_qdsj.getText().toString();
            String xmmc = ed_reimburse_xmmc.getText().toString();
            String sfht = ed_reimburse_sfht.getText().toString();
            String htlx = ed_reimburse_htlx.getText().toString();
            if (!"".equals(htbh) && !"null".equals(htbh) && htbh != null) {
                prams.put("contrCode", htbh);
            }
            if (!"".equals(time) && !"null".equals(time) && time != null) {
                prams.put("signTime", time);
            }
            if (!"".equals(xmmc) && !"null".equals(xmmc) && xmmc != null) {
                prams.put("buCode", xmCode);
            }
            if (!"".equals(sfht) && !"null".equals(sfht) && sfht != null) {
                if (sfht.equals("是")) {
                    prams.put("type", 1);
                } else if (sfht.equals("否")) {
                    prams.put("type", 2);
                }
            }
            String code = "";
            if (!"".equals(htlx) && !"null".equals(htlx) && htlx != null) {
                for (int i = 0; i < mBusiness.getData().getComboboxList().size(); i++) {
                    if (htlx.equals(mBusiness.getData().getComboboxList().get(i).getText())) {
                        code = mBusiness.getData().getComboboxList().get(i).getId();
                    }
                    prams.put("contrType", code);
                }
            }
        }
        prams.put("page", page);
        prams.put("fundsType","SK");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFEED, prams,
                SkContractResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFEED, this, false).setTag(this);
    }
}
