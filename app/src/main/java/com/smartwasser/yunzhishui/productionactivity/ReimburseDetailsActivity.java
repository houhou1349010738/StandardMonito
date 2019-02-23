package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.ReimburseDetailsResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.ListViewHeightUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class ReimburseDetailsActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private EventNormSelect event;
    private ImageButton button_menu,norm_ser;
    private  ReimburseDetailsResponse  meDetails;
    private TextView tv_weight_lsdh,tv_detail_xmmc,tv_detail_estate
            ,tv_dateil_ywlx,tv_dateil_skdw,tv_dateil_fplx,tv_dateil_j
            ,tv_dateil_shui,tv_dateil_bxzj,tv_dateil_dx,tv_dateil_bxsm
            ,tv_dateil_sqr,tv_dateil_sqrq,tv_dateil_shui_lv;
    private ListView list_ywkm;
    private LinearLayout linearlayout;
    private RelativeLayout relat;
    private MyDetailAdapter myAdapter;
    private EventSearchResponse esc=new EventSearchResponse();
    private Button but_dateil_edit,but_dateil_commit;
    private SaveResponse mSave;
    private TextView dwqrr,mdaadd,tvqwee;
    @Override
    protected int initContentView() {
        return R.layout.activity_reimburse_details;
    }
    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        tv_weight_lsdh= (TextView) findViewById(R.id.tv_weight_lsdh);
        tv_detail_xmmc= (TextView) findViewById(R.id.tv_detail_xmmc);
        tv_detail_estate= (TextView) findViewById(R.id.tv_detail_estate);
        tv_dateil_ywlx= (TextView) findViewById(R.id.tv_dateil_ywlx);
        tv_dateil_skdw= (TextView) findViewById(R.id.tv_dateil_skdw);
        tv_dateil_fplx= (TextView) findViewById(R.id.tv_dateil_fplx);
        tv_dateil_j= (TextView) findViewById(R.id.tv_dateil_j);
        dwqrr= (TextView) findViewById(R.id.dwqrr);
        mdaadd= (TextView) findViewById(R.id.mdaadd);
        tvqwee= (TextView) findViewById(R.id.tvqwee);
        tv_dateil_shui= (TextView) findViewById(R.id.tv_dateil_shui);
        tv_dateil_bxzj= (TextView) findViewById(R.id.tv_dateil_bxzj);
        tv_dateil_dx= (TextView) findViewById(R.id.tv_dateil_dx);
        tv_dateil_bxsm= (TextView) findViewById(R.id.tv_dateil_bxsm);
        tv_dateil_sqr= (TextView) findViewById(R.id.tv_dateil_sqr);
        tv_dateil_sqrq= (TextView) findViewById(R.id.tv_dateil_sqrq);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        linearlayout= (LinearLayout) findViewById(R.id.linearlayout);
        tv_dateil_shui_lv= (TextView) findViewById(R.id.tv_dateil_shui_lv);
        list_ywkm= (ListView) findViewById(R.id.list_ywkm);
        relat= (RelativeLayout) findViewById(R.id.relat);
        but_dateil_edit= (Button) findViewById(R.id.but_dateil_edit);
        but_dateil_commit= (Button) findViewById(R.id.but_dateil_commit);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        norm_ser.setVisibility(View.GONE);
        tv_toolbar.setText("费用报销申请详情");
        button_menu.setBackgroundResource(R.drawable.fanhu);
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
                 /**请求网络*/
        HashMap<String, Object> prams2 = new HashMap<>();
        prams2.put("claimId",event.getClaimId());
        prams2.put("unitName",event.getUnitName());
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERPAYVIEW, prams2,
                ReimburseDetailsResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYVIEW, this, false).setTag(this);
        but_dateil_edit.setOnClickListener(new View.OnClickListener() {
                    @Override
            public void onClick(View v) {
                        /**跳到编辑页面*/
                        esc.setClaimId(event.getClaimId());
                        esc.setUnitName(event.getUnitName());
                        esc.setFlowCode(event.getFlowCode());
                        EventBus.getDefault().postSticky(esc);
                        Intent intent=new Intent(ReimburseDetailsActivity.this,ReimburseEditActivity.class);
                        startActivity(intent);
            }
        });
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYVIEW
                && response instanceof ReimburseDetailsResponse) {
             meDetails = (ReimburseDetailsResponse) response;
            if("00000".equals(meDetails.getErrorCode())) {
                myAdapter=new MyDetailAdapter();
                list_ywkm.setAdapter(myAdapter);
                ListViewHeightUtils.setListViewHeight(list_ywkm);
                String s=meDetails.getData().getPo().getClaimYear();
                if("".equals(s)||s==null){
                     s="";
                }
                tv_weight_lsdh.setText(s);
                tv_detail_xmmc.setText(meDetails.getData().getUnitName());
                if ("通过".equals(meDetails.getData().getPo().getExamineState())) {
                    tv_detail_estate.setTextColor(Color.parseColor("#4ad261"));
                } else {
                    tv_detail_estate.setTextColor(Color.parseColor("#ff8200"));
                }
                tv_detail_estate.setText(meDetails.getData().getPo().getExamineState());
                String ywlx=meDetails.getData().getPo().getClaimtypeId();
                String skdw=meDetails.getData().getPo().getXfdw();
                if(ywlx==null){
                    ywlx="";
                }
                if(skdw==null){
                    skdw="";
                }
                tv_dateil_ywlx.setText("业务类型:" +ywlx);
                tv_dateil_skdw.setText("收款单位:" +skdw);
                if(!"".equals(meDetails.getData().getInv())&&!"null".equals(meDetails.getData().getInv())&&
                        meDetails.getData().getInv()!=null) {
                    String ts = meDetails.getData().getInv().getInvoiceType();
                    String m = "";
                    if ("ZY".equals(ts)) {
                        m = "增值税专用发票";
                    } else if ("PT".equals(ts)) {
                        m = "增值税普通发票";
                    } else if ("QT".equals(ts)) {
                        m = "其他发票";
                    }
                    if("ZY".equals(ts)){
                        tv_dateil_j.setVisibility(View.VISIBLE);
                        dwqrr.setVisibility(View.VISIBLE);
                        mdaadd.setVisibility(View.VISIBLE);
                        tvqwee.setVisibility(View.VISIBLE);
                        tv_dateil_shui.setVisibility(View.VISIBLE);
                        tv_dateil_j.setText("￥" + meDetails.getData().getInv().getInvoiceMoney());
                        tv_dateil_shui_lv.setText(meDetails.getData().getInv().getInvoiceTaxes()+"");
                        tv_dateil_shui.setText("￥"+meDetails.getData().getInv().getInvoiceMoney()*(meDetails.getData().getInv().getInvoiceTaxes()/100));
                    }
                        tv_dateil_fplx.setText("发票类型:" + m);
                    }
                tv_dateil_bxzj.setText("￥"+meDetails.getData().getPo().getClaimSum()+"");
                tv_dateil_dx.setText(meDetails.getData().getPo().getClaimSumcn());
                tv_dateil_bxsm.setText(meDetails.getData().getPo().getClaimDesc());
                tv_dateil_sqr.setText("申请人:" + meDetails.getData().getPo().getClaimRealuser());
                tv_dateil_sqrq.setText("申请日期:" + meDetails.getData().getPo().getClaimTime());
                if(meDetails.getData().getPo().getExamineState().equals(event.getExamineState())&&
                        meDetails.getData().getPo().getClaimUser().equals(event.getUserName())){
                        linearlayout.setVisibility(View.VISIBLE);
                }
                relat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                          String id=meDetails.getData().getPo().getClaimId();
                          esc.setClaimId(id);
                          EventBus.getDefault().postSticky(esc);
                          Intent intent=new Intent(ReimburseDetailsActivity.this,AuditStatusActivity.class);
                          startActivity(intent);
                    }
                });
                but_dateil_commit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**请求网络*/
                        HashMap<String, Object> prams2 = new HashMap<>();
                        prams2.put("datadate",meDetails.getData().getPo().getClaimTime());
                        prams2.put("claimId",meDetails.getData().getPo().getClaimId());
                        prams2.put("examineState",meDetails.getData().getPo().getExamineState());
                        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERCOMMIT, prams2,
                                SaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERCOMMIT,ReimburseDetailsActivity.this, false).setTag(this);
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERCOMMIT
                && response instanceof SaveResponse) {
              mSave=(SaveResponse)response;
            if( "00000".equals(mSave.getErrorCode())){
                Toast.makeText(ReimburseDetailsActivity.this, "提交完成", Toast.LENGTH_SHORT).show();
                 Intent intent=new Intent(ReimburseDetailsActivity.this,ReimbursementActivity.class);
                 startActivity(intent);
                 finish();
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventNormSelect ece){
           event=ece;
    }
    class MyDetailAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return  meDetails.getData().getFeeSubjectRelation().size();
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
                convertView=View.inflate(ReimburseDetailsActivity.this,R.layout.item_ywkm,null);
                holder=new ViewHolder();
                holder.tv_dateil_ywkm= (TextView)convertView.findViewById(R.id.tv_dateil_ywkm);
                holder.tv_dateil_dyje= (TextView)convertView.findViewById(R.id.tv_dateil_dyje);
                holder.tv_dateil_dyjhz= (TextView)convertView.findViewById(R.id.tv_dateil_dyjhz);
                holder.tv_dateil_dysyz= (TextView)convertView.findViewById(R.id.tv_dateil_dysyz);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_dateil_ywkm.setText("业务科目:"+meDetails.getData().getFeeSubjectRelation().get(position).getIndeName());
            holder.tv_dateil_dyje.setText("对应金额:"+"￥"+meDetails.getData().getFeeSubjectRelation().get(position).getFeeAmount());
            holder.tv_dateil_dyjhz.setText("当月计划值:"+"￥"+meDetails.getData().getFeeSubjectRelation().get(position).getMaxValue());
            holder.tv_dateil_dysyz.setText("当月剩余值:"+"￥"+meDetails.getData().getFeeSubjectRelation().get(position).getMinValue());
            return convertView;
        }
    }
    class ViewHolder{
        TextView  tv_dateil_ywkm,tv_dateil_dyje
        ,tv_dateil_dyjhz,tv_dateil_dysyz;
    }
}
