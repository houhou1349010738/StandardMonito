package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.ContractLookResponse;
import com.smartwasser.yunzhishui.bean.ContractlistResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.bean.paymentLookResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.ListViewHeightUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/25 0025.
 */
public class PaymentLookActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private TextView tv_contract_htbh,tv_contract_htje
            ,tv_contract_wsje,tv_contract_htysje;
    private ListView list_contract_look;
    private EventNormSelect mNorm;
    private paymentLookResponse mContractLook;
             /**中间部分的数据*/
    private TextView tv_contract_htjsfs,tv_contract_htmc
                     ,tv_contract_xmmc,tv_contract_htlx
                     ,tv_contract_jf,tv_contract_yf
                     ,tv_contract_qdsj;
             /**执行信息*/
    private TextView tv_dateil_fplx,tv_dateil_j,tv_dateil_shui
                     ,tv_contract_sqsj,tv_contract_sqry
                     ,tv_contract_se,tv_contract_skdw;
    private ContractlistResponse mContractlist;
    private MyDetailAdapter myAdapter;
    private Button button_contract;
    @Override
    protected int initContentView() {
        return R.layout.activity_payment_look;
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
        list_contract_look= (ListView) findViewById(R.id.list_contract_look);

        /**中间部分的数据*/
        tv_contract_htjsfs= (TextView) findViewById(R.id.tv_contract_htjsfs);
        tv_contract_htmc= (TextView) findViewById(R.id.tv_contract_htmc);
        tv_contract_xmmc= (TextView) findViewById(R.id.tv_contract_xmmc);
        tv_contract_htlx= (TextView) findViewById(R.id.tv_contract_htlx);
        tv_contract_jf= (TextView) findViewById(R.id.tv_contract_jf);
        tv_contract_yf= (TextView) findViewById(R.id.tv_contract_yf);
        tv_contract_qdsj= (TextView) findViewById(R.id.tv_contract_qdsj);
         /**执行信息*/
        tv_dateil_fplx= (TextView) findViewById(R.id.tv_contract_fplx);
        tv_dateil_j= (TextView) findViewById(R.id.tv_contract_skje);
        tv_dateil_shui= (TextView) findViewById(R.id.tv_contract_sl);
        tv_contract_sqsj= (TextView) findViewById(R.id.tv_contract_sqsj);
        tv_contract_sqry= (TextView) findViewById(R.id.tv_contract_sqry);
        tv_contract_se= (TextView) findViewById(R.id.tv_contract_se);
        tv_contract_skdw= (TextView) findViewById(R.id.tv_contract_skdw);
        button_contract= (Button) findViewById(R.id.button_contract);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("合同管理");
        tv_contract_htbh.setText("NO:"+"  "+mNorm.getContrCode());
        tv_contract_htje.setText("￥"+mNorm.getContrAmount());
        String wsje=mNorm.getProfessionSubject();
        if(wsje.length()>8){
            wsje=wsje.substring(0,6);
        }
        tv_contract_wsje.setText("￥"+wsje);
        tv_contract_htysje.setText("￥"+mNorm.getInitialAmount());
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**请求网络*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("id", mNorm.getContractId());
        prams.put("contrId",mNorm.getContrId());
        String s="";
        if("收款".equals(mNorm.getFundsType())){
            s="shoukuan";
        }else{
            s="zhifu";
        }
        prams.put("fundsType", s);
        prams.put("unitName",mNorm.getUnitName());
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERVIEWZF, prams,
                paymentLookResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERVIEWZF, this, false).setTag(this);

    }
    public void onEvent(EventNormSelect norm){
               mNorm=norm;
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
                   /**显示中间部分的数据*/
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERVIEWZF
                && response instanceof paymentLookResponse) {
             mContractLook=(paymentLookResponse) response;
              if("00000".equals(mContractLook.getErrorCode())){
                  tv_contract_htjsfs.setText("合同结算方式:"+mContractLook.getData().getPo().getSettlementMethod());
                  tv_contract_htmc.setText("合同名称:"+mContractLook.getData().getPo().getContrName());
                  tv_contract_xmmc.setText("项目名称:"+mContractLook.getData().getUnitName());
                  tv_contract_htlx.setText("合同类型:"+mContractLook.getData().getPo().getContrType());
                  tv_contract_jf.setText("甲        方:"+mContractLook.getData().getPo().getContrFirstParty());
                  tv_contract_yf.setText("乙        方:"+mContractLook.getData().getPo().getContrSecondParty());
                  tv_contract_qdsj.setText("签订时间:"+mContractLook.getData().getPo().getSignTime());
                  if(!"".equals(mContractLook.getData().getInv())&&!"null".equals(mContractLook.getData().getInv())&&
                          mContractLook.getData().getInv()!=null) {
                      String ts =mContractLook.getData().getInv().getInvoiceType();
                      String m = "";
                      if ("ZY".equals(ts)) {
                          m = "增值税专用发票";
                          tv_dateil_shui.setVisibility(View.VISIBLE);
                          tv_contract_se.setVisibility(View.VISIBLE);
                          tv_dateil_shui.setText("税率:" + mContractLook.getData().getInv().getInvoiceTaxes() + "");
                          tv_contract_se.setText("税额:" + mContractLook.getData().getInv().getInvoiceTax());
                      } else if ("PT".equals(ts)) {
                          m = "增值税普通发票";
                          tv_dateil_shui.setVisibility(View.GONE);
                          tv_contract_se.setVisibility(View.GONE);
                      } else if ("QT".equals(ts)) {
                          m = "其他";
                          tv_dateil_shui.setVisibility(View.GONE);
                          tv_contract_se.setVisibility(View.GONE);
                      }
                      tv_dateil_fplx.setVisibility(View.VISIBLE);
                      tv_dateil_j.setVisibility(View.VISIBLE);
                      tv_dateil_fplx.setText("发票类型:" + m);
                      tv_dateil_j.setText("收款金额:"+"￥" +mContractLook.getData().getInv().getInvoiceMoney());
                  }
                  tv_contract_sqsj.setText("申请日期:"+mContractLook.getData().getVo().getApplyTime());
                  tv_contract_sqry.setText("申请人:"+mContractLook.getData().getVo().getApplyUsernamecn());
                  tv_contract_skdw.setText("收款单位:"+mContractLook.getData().getVo().getPayUnit());
                  if(mNorm.isContractFlag()){
                      button_contract.setVisibility(View.VISIBLE);
                      button_contract.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              HashMap<String, Object> prams = new HashMap<>();
                              prams.put("id",mContractLook.getData().getVo().getId());
                              HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFEETJZF, prams,
                                      SaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFEETJZF,PaymentLookActivity.this, false).setTag(this);
                          }
                      });
                  }
                  /**请求网络*/
                  HashMap<String, Object> prams = new HashMap<>();
                  prams.put("id",mContractLook.getData().getVo().getId());
                  prams.put("assuUnit", mContractLook.getData().getVo().getBuCode());
                  prams.put("datadate", mContractLook.getData().getVo().getApplyTime());
                  HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERMASTBYID, prams,
                          ContractlistResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERMASTBYID, this, false).setTag(this);
              }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERMASTBYID
                && response instanceof ContractlistResponse) {
              mContractlist = (ContractlistResponse) response;
              if("00000".equals(mContractlist.getErrorCode())){
                  myAdapter=new MyDetailAdapter();
                  list_contract_look.setAdapter(myAdapter);
                  ListViewHeightUtils.setListViewHeight(list_contract_look);
              }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFEETJZF
                && response instanceof SaveResponse) {
            SaveResponse mSave = (SaveResponse) response;
                if("00000".equals(mSave.getErrorCode())){
                    Intent intent=new Intent(PaymentLookActivity.this,PaymentActivity.class);
                    startActivity(intent);
                }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
           MyToast.show(this, "error: " + error.getMessage());
    }
    class MyDetailAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return  mContractlist.getData().getList1().size();
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
                convertView=View.inflate(PaymentLookActivity.this,R.layout.item_ywkm,null);
                holder=new ViewHolder();
                holder.tv_dateil_ywkm= (TextView)convertView.findViewById(R.id.tv_dateil_ywkm);
                holder.tv_dateil_dyje= (TextView)convertView.findViewById(R.id.tv_dateil_dyje);
                holder.tv_dateil_dyjhz= (TextView)convertView.findViewById(R.id.tv_dateil_dyjhz);
                holder.tv_dateil_dysyz= (TextView)convertView.findViewById(R.id.tv_dateil_dysyz);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_dateil_ywkm.setText("业务科目:"+mContractlist.getData().getList1().get(position).getIndeName());
            holder.tv_dateil_dyje.setText("对应金额:"+"￥"+mContractlist.getData().getList1().get(position).getFeeAmount());
            holder.tv_dateil_dyjhz.setText("当月计划值:"+"￥"+mContractlist.getData().getList1().get(position).getMaxValue());
            holder.tv_dateil_dysyz.setText("当月剩余值:"+"￥"+mContractlist.getData().getList1().get(position).getMinValue());
            return convertView;
        }
    }
    class ViewHolder{
        TextView  tv_dateil_ywkm,tv_dateil_dyje
                ,tv_dateil_dyjhz,tv_dateil_dysyz;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
