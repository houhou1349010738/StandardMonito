package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.BusinessTypeResponse;
import com.smartwasser.yunzhishui.bean.ContractDetailResponse;
import com.smartwasser.yunzhishui.bean.ContractDetailsListResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.ProjectNameResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.ListViewHeightUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/25 0025.
 */
public class ContractDetailsActicity extends BaseActivity implements HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;

    private TextView tv_contract_htbh,tv_contract_htje
            ,tv_contract_wsje,tv_contract_htysje,zhankai
            ,tianjia;
    private ListView list_contract_detail;

    private   ContractDetailResponse  mContractDetail;
    private EventSearchResponse search;
    private int page=1;
    private  ContractDetailsListResponse  mDetailsList;
    private EventNormSelect event=new EventNormSelect();
    private MyAdapter myAdapter;
    private int i=1;
    /**中间部分的数据*/
    private TextView tv_contract_htjsfs,tv_contract_htmc
            ,tv_contract_xmmc,tv_contract_htlx
            ,tv_contract_jf,tv_contract_yf
            ,tv_contract_qdsj;
    private RelativeLayout relat;
    @Override
    protected int initContentView() {
        return R.layout.activity_contractdetail;
    }
    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id. button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_contract_htbh= (TextView) findViewById(R.id.tv_contract_htbh);
        tv_contract_htje= (TextView) findViewById(R.id.tv_contract_htje);
        tv_contract_wsje= (TextView) findViewById(R.id.tv_contract_wsje);
        tv_contract_htysje= (TextView) findViewById(R.id.tv_contract_htysje);
        zhankai= (TextView) findViewById(R.id.zhankai);
        list_contract_detail= (ListView) findViewById(R.id.list_contract_detail);
        tianjia= (TextView) findViewById(R.id.tianjia);

        /**中间部分的数据*/
        tv_contract_htjsfs= (TextView) findViewById(R.id.tv_contract_htjsfs);
        tv_contract_htmc= (TextView) findViewById(R.id.tv_contract_htmc);
        tv_contract_xmmc= (TextView) findViewById(R.id.tv_contract_xmmc);
        tv_contract_htlx= (TextView) findViewById(R.id.tv_contract_htlx);
        tv_contract_jf= (TextView) findViewById(R.id.tv_contract_jf);
        tv_contract_yf= (TextView) findViewById(R.id.tv_contract_yf);
        tv_contract_qdsj= (TextView) findViewById(R.id.tv_contract_qdsj);
        relat= (RelativeLayout) findViewById(R.id.rayout);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        tv_toolbar.setText("合同管理");
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**请求网络*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("nodeId", "fill_sk");
        prams.put("flowCode", "YWLC10004");
        prams.put("id",search.getContractId());
        prams.put("unitName",search.getContractunitName());
        prams.put("type",search.getContracttype());
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSKFIND, prams,
              ContractDetailResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSKFIND,this, false).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSKFIND
                && response instanceof ContractDetailResponse) {
                              /**类型*/
             mContractDetail= (ContractDetailResponse) response;
             if("00000".equals( mContractDetail.getErrorCode())){
                 tv_contract_htbh.setText("NO:" + mContractDetail.getData().getPo().getContrCode());
                 tv_contract_htje.setText("￥"+mContractDetail.getData().getPo().getContrAmount());
                 String wsje=mContractDetail.getData().getPo().getProfessionSubject();
                 if(wsje.length()>8){
                     wsje=wsje.substring(0,6);
                 }
                 tv_contract_wsje.setText("￥"+wsje);
                 tv_contract_htysje.setText("￥"+mContractDetail.getData().getPo().getInitialAmount());
                 tv_contract_htjsfs.setText("合同结算方式:"+mContractDetail.getData().getPo().getSettlementMethod());
                 tv_contract_htmc.setText("合同名称:"+mContractDetail.getData().getPo().getContrName());
                 tv_contract_xmmc.setText("单位名称:"+mContractDetail.getData().getUnitName());
                 tv_contract_htlx.setText("合同类型:"+mContractDetail.getData().getPo().getContrType());
                 tv_contract_jf.setText("甲        方:"+mContractDetail.getData().getPo().getContrFirstParty());
                 tv_contract_yf.setText("乙        方:"+mContractDetail.getData().getPo().getContrSecondParty());
                 tv_contract_qdsj.setText("签订时间:" + mContractDetail.getData().getPo().getSignTime());
                   zhankai.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           if (i % 2 != 0) {
                               relat.setVisibility(View.GONE);
                               zhankai.setText("展开");
                           } else {
                               relat.setVisibility(View.VISIBLE);
                               zhankai.setText("收起");
                           }
                           ++i;
                       }
                   });

                 /**请求网络*/
                 HashMap<String, Object> prams = new HashMap<>();
                 prams.put("nodeId", "fill_sk");
                 prams.put("contrId", mContractDetail.getData().getPo().getId());
                 prams.put("page",page);
                 HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFINDFEESK, prams,
                         ContractDetailsListResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFINDFEESK,this, false).setTag(this);
             }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFINDFEESK
                && response instanceof ContractDetailsListResponse) {
            /**类型*/
             mDetailsList = (ContractDetailsListResponse) response;
            if("00000".equals(mDetailsList.getErrorCode())||"00014".equals(mDetailsList.getErrorCode())){
                myAdapter=new MyAdapter();
                list_contract_detail.setAdapter(myAdapter);
                ListViewHeightUtils.setListViewHeight(list_contract_detail);
                tianjia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**判断是否还有未确定的收款*/
                        if (mDetailsList.getData() != null) {
                            for (int i = 0; i < mDetailsList.getData().getFeeIncome().getRows().size(); i++) {
                                if ("收款通知".equals(mDetailsList.getData().getFeeIncome().getRows().get(i).getStatus())) {
                                    Toast.makeText(ContractDetailsActicity.this, "收款确认后才能添加", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        }
                        EventBus.getDefault().postSticky(mContractDetail);
                        Intent intent = new Intent(ContractDetailsActicity.this, AddContractActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventSearchResponse search){
               this.search=search;
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            if( mDetailsList .getData()==null){
                return 0;
            }
            return  mDetailsList .getData().getFeeIncome().getRows().size();
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
                convertView=View.inflate(ContractDetailsActicity.this,R.layout.item_contract_detail,null);
                holder=new ViewHolder();
                holder.tv_contract_time= (TextView) convertView.findViewById(R.id.tv_contract_time);
                holder.tv_contract_sktz= (TextView) convertView.findViewById(R.id.tv_contract_sktz);
                holder.tv_contract_htje= (TextView) convertView.findViewById(R.id.tv_contract_htje);
                holder.tv_contract_wsje= (TextView) convertView.findViewById(R.id.tv_contract_wsje);
                holder.bianji= (Button) convertView.findViewById(R.id.bianji);
                holder.queding= (Button) convertView.findViewById(R.id.queding);
                holder.chakan= (Button) convertView.findViewById(R.id.chakan);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_contract_time.setText(mDetailsList.getData().getFeeIncome().getRows().get(position).getApplyTime());
            String s=mDetailsList.getData().getFeeIncome().getRows().get(position).getStatus();
            if("收款通知".equals(s)){
                holder.tv_contract_sktz.setTextColor(Color.parseColor("#ffcc00"));
                holder.bianji.setVisibility(View.VISIBLE);
                holder.queding.setVisibility(View.VISIBLE);
                holder.chakan.setVisibility(View.GONE);
            }else if("收款完结".equals(s)){
                holder.tv_contract_sktz.setTextColor(Color.parseColor("#4cd964"));
                holder.bianji.setVisibility(View.GONE);
                holder.queding.setVisibility(View.GONE);
                holder.chakan.setVisibility(View.VISIBLE);
            }else{
                holder.tv_contract_sktz.setTextColor(Color.parseColor("#ffcc00"));
                holder.bianji.setVisibility(View.GONE);
                holder.queding.setVisibility(View.GONE);
                holder.chakan.setVisibility(View.VISIBLE);
            }
            holder.tv_contract_sktz.setText(s);
            holder.tv_contract_htje.setText("￥"+mDetailsList.getData().getFeeIncome().getRows().get(position).getIncomeMoney()+"");
            holder.tv_contract_wsje.setText("￥"+mDetailsList.getData().getFeeIncome().getRows().get(position).getIncomeMoney()+"");
            holder.chakan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**将这些值传过去*/
                    event.setContrCode(mContractDetail.getData().getPo().getContrCode());
                    event.setContrAmount(mContractDetail.getData().getPo().getContrAmount() + "");
                    event.setContractFlag(false);
                    event.setInitialAmount(mContractDetail.getData().getPo().getInitialAmount() + "");
                    event.setProfessionSubject(mContractDetail.getData().getPo().getProfessionSubject());
                    event.setContractId(mDetailsList.getData().getFeeIncome().getRows().get(position).getId());
                    event.setContrId(mContractDetail.getData().getPo().getId());
                    event.setUnitName(mContractDetail.getData().getPo().getUnitName());
                    event.setFundsType(mContractDetail.getData().getPo().getFundsType());
                    EventBus.getDefault().postSticky(event);
                    Intent intent = new Intent(ContractDetailsActicity.this, ContractLookActivity.class);
                    startActivity(intent);
                }
            });
            holder.queding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**将这些值传过去*/
                    event.setContractFlag(true);
                    event.setContrCode(mContractDetail.getData().getPo().getContrCode());
                    event.setContrAmount(mContractDetail.getData().getPo().getContrAmount() + "");
                    event.setInitialAmount(mContractDetail.getData().getPo().getInitialAmount() + "");
                    event.setProfessionSubject(mContractDetail.getData().getPo().getProfessionSubject());
                    event.setContractId(mDetailsList.getData().getFeeIncome().getRows().get(position).getId());
                    event.setContrId(mContractDetail.getData().getPo().getId());
                    event.setUnitName(mContractDetail.getData().getPo().getUnitName());
                    event.setFundsType(mContractDetail.getData().getPo().getFundsType());
                    EventBus.getDefault().postSticky(event);
                    Intent intent = new Intent(ContractDetailsActicity.this, ContractLookActivity.class);
                    startActivity(intent);
                }
            });
            holder.bianji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**将mContractDetail传过去*/
                    event.setmContractDetail(mContractDetail);
                    event.setContractId(mDetailsList.getData().getFeeIncome().getRows().get(position).getId());
                    EventBus.getDefault().postSticky(event);
                    Intent intent = new Intent(ContractDetailsActicity.this, ContractEditActivity.class);
                    startActivity(intent);
                }
            });
            return convertView;
        }
        class ViewHolder{
            TextView tv_contract_time,tv_contract_sktz,
                    tv_contract_htje,tv_contract_wsje;
            Button bianji,queding,chakan;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
