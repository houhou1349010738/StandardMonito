package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

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
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;

import org.seny.android.utils.MyToast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/27 0027.
 */
public class AuditDetailsActivity extends BaseActivity implements HttpLoader.ResponseListener,View.OnClickListener{
    private TextView tv_toolbar;
    private EventNormSelect event;
    private ImageButton button_menu,norm_ser;
    private ReimburseDetailsResponse meDetails;
    private TextView tv_weight_lsdh,tv_detail_xmmc,tv_detail_estate
            ,tv_dateil_ywlx,tv_dateil_skdw,tv_dateil_fplx,tv_dateil_j
            ,tv_dateil_shui,tv_dateil_bxzj,tv_dateil_dx,tv_dateil_bxsm
            ,tv_dateil_sqr,tv_dateil_sqrq,tv_dateil_shui_lv;
    private ListView list_ywkm;
    private RelativeLayout relat;
    private MyDetailAdapter myAdapter;
    private EventSearchResponse esc=new EventSearchResponse();
    private SaveResponse mSave;
    private TextView dwqrr,mdaadd,tvqwee;
    private Button button_audit;


    private TextView audit_time;
    private RadioGroup group;
    private EditText ed_audit_shyj;
    private String s="";
    private ImageButton fanhui,queding;
    private Toolbar toolbar;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    @Override
    protected int initContentView() {
        return R.layout.activity_reimburse_auditdetails;
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
        tv_dateil_shui_lv= (TextView) findViewById(R.id.tv_dateil_shui_lv);
        list_ywkm= (ListView) findViewById(R.id.list_ywkm);
        relat= (RelativeLayout) findViewById(R.id.relat);
        button_audit= (Button) findViewById(R.id.button_audit);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {

    }
    public View getViews(){
        View view=View.inflate(this,R.layout.popup_audit,null);
        audit_time= (TextView) view.findViewById(R.id.audit_time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        audit_time.setText("审核时间:"+df.format(new Date()));
        group= (RadioGroup) view.findViewById(R.id.group);
        ed_audit_shyj= (EditText) view.findViewById(R.id.ed_audit_shyj);
        fanhui= (ImageButton) view.findViewById(R.id.fanhui);
        queding= (ImageButton) view.findViewById(R.id.queding);
        return view;
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
        prams2.put("unitName", event.getUnitName());
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERPAYVIEW, prams2,
                ReimburseDetailsResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYVIEW, this, false).setTag(this);
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
                String dh=meDetails.getData().getPo().getClaimYear();
                if(dh==null){
                    dh="";
                }
                tv_weight_lsdh.setText(dh);
                tv_detail_xmmc.setText(meDetails.getData().getUnitName());
                if ("通过".equals(meDetails.getData().getPo().getExamineState())) {
                    tv_detail_estate.setTextColor(Color.parseColor("#4ad261"));
                } else {
                    tv_detail_estate.setTextColor(Color.parseColor("#ff8200"));
                }
                tv_detail_estate.setText(meDetails.getData().getPo().getExamineState());
                tv_dateil_ywlx.setText("业务类型:" + meDetails.getData().getPo().getClaimtypeId());
                tv_dateil_skdw.setText("收款单位:" + meDetails.getData().getPo().getXfdw());
                if(!"".equals(meDetails.getData().getInv())&&!"null".equals(meDetails.getData().getInv())&&
                        meDetails.getData().getInv()!=null) {
                    String ts =meDetails.getData().getInv().getInvoiceType();
                    String m="";
                    if ("ZY".equals(ts)) {
                        m = "增值税专用发票";
                    }else if ("PT".equals(ts)) {
                        m ="增值税普通发票";
                    } else if ("QT".equals(ts )) {
                        m = "其他发票";
                    }
                    tv_dateil_fplx.setVisibility(View.VISIBLE);
                    tv_dateil_j.setVisibility(View.VISIBLE);
                    dwqrr.setVisibility(View.VISIBLE);
                    mdaadd.setVisibility(View.VISIBLE);
                    tvqwee.setVisibility(View.VISIBLE);
                    tv_dateil_fplx.setText("发票类型:" + m);
                    tv_dateil_shui.setVisibility(View.VISIBLE);
                    tv_dateil_j.setText("￥" + meDetails.getData().getInv().getInvoiceMoney());
                    tv_dateil_shui_lv.setText(meDetails.getData().getInv().getInvoiceTaxes()+"");
                    tv_dateil_shui.setText(meDetails.getData().getInv().getInvoiceTax() + "");
                }
                tv_dateil_bxzj.setText("￥"+meDetails.getData().getPo().getClaimSum()+"");
                tv_dateil_dx.setText(meDetails.getData().getPo().getClaimSumcn());
                tv_dateil_bxsm.setText(meDetails.getData().getPo().getClaimDesc());
                tv_dateil_sqr.setText("申请人:" + meDetails.getData().getPo().getClaimRealuser());
                tv_dateil_sqrq.setText("申请日期:" + meDetails.getData().getPo().getClaimTime());
                if(meDetails.getData().getPo().getExamineState().equals(event.getExamineState())&&
                        meDetails.getData().getPo().getClaimUser().equals(event.getUserName())){
                  }
                button_audit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**弹出Pupowindow*/
                        showMuchTrend();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERREVIEWs
                && response instanceof SaveResponse) {
               mSave=(SaveResponse)response;
              if("00000".equals(mSave.getErrorCode())){
                  if(event.isZnbmFlag()){
                      Intent intent = new Intent(AuditDetailsActivity.this, FunctionAuditActivity.class);
                      startActivity(intent);
                      finish();
                  }else {
                      Intent intent = new Intent(AuditDetailsActivity.this, ReimburseAuditActivity.class);
                      startActivity(intent);
                      finish();
                  }
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

    @Override
    public void onClick(View v) {
         /**请求网络*/
        switch (v.getId()) {
            case R.id.fanhui:
                psu.colsePopupWindow();
                break;
            case R.id.queding:
                HashMap<String, Object> prams2 = new HashMap<>();
                String  shyj= ed_audit_shyj.getText().toString();
                if("".equals(shyj)||"null".equals(shyj)|shyj==null){
                    Toast.makeText(AuditDetailsActivity.this, "请填写审核意见", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(event.isZnbmFlag()){
                    if(event.getId2()!=null){
                        prams2.put("id2",event.getId2());
                    }
                }
                prams2.put("claimRealuser",meDetails.getData().getPo().getClaimRealuser());
                prams2.put("claimId", meDetails.getData().getPo().getClaimId());
                prams2.put("isContract", meDetails.getData().getPo().getIsContract());
                prams2.put("operResult",s);
                prams2.put("message", shyj);
                prams2.put("claimtypeId", meDetails.getData().getPo().getClaimtypeId());
                prams2.put("datadate", meDetails.getData().getPo().getClaimTime());
                prams2.put("examineState", meDetails.getData().getPo().getExamineState());
                prams2.put("scopetypeId", meDetails.getData().getPo().getScopetypeId());
                HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERREVIEWs, prams2,
                        SaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERREVIEWs, AuditDetailsActivity.this, false).setTag(this);
                psu.colsePopupWindow();
                break;
        }
    }

    class MyDetailAdapter extends BaseAdapter {

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
                convertView=View.inflate(AuditDetailsActivity.this,R.layout.item_ywkm,null);
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
    private void showMuchTrend(){
        psu.showPopupSearch2(getViews(), button_menu);
        fanhui.setOnClickListener(this);
        queding.setOnClickListener(this);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tongyi:
                        s = "同意";
                        ed_audit_shyj.setText("通过");
                        break;
                    case R.id.butongyi:
                        s = "建议修改";
                        ed_audit_shyj.setText("");
                        break;
                }
            }
        });
    }
}
