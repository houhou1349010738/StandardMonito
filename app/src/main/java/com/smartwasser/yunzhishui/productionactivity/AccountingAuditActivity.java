package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
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
import com.smartwasser.yunzhishui.bean.FgldResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.ReimburseDetailsResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.bean.ZnbmResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.ListViewHeightUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.view.MyGridView;
import com.smartwasser.yunzhishui.view.MyGridView2;

import org.seny.android.utils.MyToast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/28 0028.
 */
public class AccountingAuditActivity extends BaseActivity implements HttpLoader.ResponseListener,View.OnClickListener{
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
    private RadioGroup group,group_znbm,group_fgld,group_zjl;
    private MyGridView  grid_znbm;
    private MyGridView2 grid_fgld;
    private EditText ed_audit_shyj;
    private String s="",znbm="",zjl="",fgld="";
    private ImageButton fanhui,queding;
    private Toolbar toolbar;
    private ZnbmResponse mZnbm;
    private  FgldResponse mFgld;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private MyZnbmAdapter myZnbmAdapter;
    private MyFgldAdapter myFgldAdapter;
    private  HashMap<Integer,Boolean> isSelected=new HashMap<Integer, Boolean>();
    private  HashMap<Integer,Boolean> fgldSelected=new HashMap<Integer, Boolean>();
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
        // toolbar= (Toolbar) findViewById(R.id.toolbar);
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
        View view=View.inflate(this,R.layout.popup_accaudit,null);
        audit_time= (TextView) view.findViewById(R.id.audit_time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        audit_time.setText("审核时间:"+df.format(new Date()));
        group= (RadioGroup) view.findViewById(R.id.group);
        ed_audit_shyj= (EditText) view.findViewById(R.id.ed_audit_shyj);
        fanhui= (ImageButton) view.findViewById(R.id.fanhui);
        queding= (ImageButton) view.findViewById(R.id.queding);
        group_fgld= (RadioGroup) view.findViewById(R.id.group_fgld);
        group_znbm= (RadioGroup) view.findViewById(R.id.group_znbm);
        group_zjl= (RadioGroup) view.findViewById(R.id.group_zjl);
        grid_fgld= (MyGridView2) view.findViewById(R.id.grid_fgld);
        grid_znbm= (MyGridView) view.findViewById(R.id.grid_znbm);
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
                tv_detail_xmmc.setText("单位名称:" + meDetails.getData().getUnitName());
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
                        dwqrr.setVisibility(View.VISIBLE);
                        mdaadd.setVisibility(View.VISIBLE);
                        tvqwee.setVisibility(View.VISIBLE);
                        tv_dateil_j.setVisibility(View.VISIBLE);
                        tv_dateil_shui.setVisibility(View.VISIBLE);
                        tv_dateil_j.setText("￥" + meDetails.getData().getInv().getInvoiceMoney());
                        tv_dateil_shui_lv.setText(meDetails.getData().getInv().getInvoiceTaxes()+"");
                        tv_dateil_shui.setText(meDetails.getData().getInv().getInvoiceTax() + "");
                    }
                    tv_dateil_fplx.setText("发票类型:" + m);
                }
                tv_dateil_bxzj.setText("￥"+meDetails.getData().getPo().getClaimSum()+"");
                tv_dateil_dx.setText(meDetails.getData().getPo().getClaimSumcn());
                tv_dateil_bxsm.setText(meDetails.getData().getPo().getClaimDesc());
                tv_dateil_sqr.setText("申请人:" + meDetails.getData().getPo().getClaimRealuser());
                tv_dateil_sqrq.setText("申请日期:" + meDetails.getData().getPo().getClaimTime());
               /* if(meDetails.getData().getPo().getExamineState().equals(event.getExamineState())&&
                        meDetails.getData().getPo().getClaimUser().equals(event.getUserName())){
                       linearlayout.setVisibility(View.VISIBLE);
                }*/
                button_audit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /**弹出Pupowindow*/
                        showMuchTrend();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERZNBM
                && response instanceof ZnbmResponse) {
                 mZnbm=(ZnbmResponse) response;
                 if("00000".equals(mZnbm.getErrorCode())){
                          /**设置适配器*/
                     for(int j=0;j<mZnbm.getData().getComboboxList().size();j++){
                         isSelected.put(j,false);
                     }
                     myZnbmAdapter=new MyZnbmAdapter();
                     grid_znbm.setAdapter(myZnbmAdapter);
                     grid_znbm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                             /**点击事件*/
                             ViewHolde holder = (ViewHolde) view.getTag();
                             holder.check.toggle();
                             isSelected.put(position, holder.check.isChecked());
                             myZnbmAdapter.setIsSelected(isSelected);
                         }
                     });
                 }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT
                && response instanceof FgldResponse) {
             mFgld=(FgldResponse) response;
            for(int i=0;i<mFgld.getData().getComboboxList().size();i++){
                fgldSelected.put(i, false);
            }
              myFgldAdapter=new MyFgldAdapter();
              grid_fgld.setAdapter(myFgldAdapter);
              grid_fgld.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    /**点击事件*/
                    ViewHolde holder = (ViewHolde) view.getTag();
                    holder.check.toggle();
                    myFgldAdapter.getIsSelecteds().put(position, holder.check.isChecked());
                    fgldSelected.put(position, holder.check.isChecked());
                    myFgldAdapter.setIsSelecteds(fgldSelected);
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERREVIEWs
                && response instanceof SaveResponse) {
                mSave=(SaveResponse)response;
            if("00000".equals(mSave.getErrorCode())){
                psu.colsePopupWindow();
                Intent intent = new Intent(AccountingAuditActivity.this,ReimburseAuditActivity.class);
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
                    Toast.makeText(AccountingAuditActivity.this, "请填写审核意见", Toast.LENGTH_SHORT).show();
                    return;
                }
                prams2.put("claimRealuser",meDetails.getData().getPo().getClaimRealuser());
                prams2.put("claimId", meDetails.getData().getPo().getClaimId());
                prams2.put("isContract", meDetails.getData().getPo().getIsContract());
                prams2.put("operResult",s);
                prams2.put("message",shyj);
                prams2.put("zjl",zjl);
                prams2.put("fgld",fgld);
                prams2.put("zn",znbm);
                if(!"否".equals(znbm)){
                    String zId="";
                    List<String> list=new ArrayList<String>();
                    for(int i=0;i<isSelected.size();i++){
                        if(isSelected.get(i)){
                            list.add(mZnbm.getData().getComboboxList().get(i).getId());
                        }
                    }
                    if(list.size()==0){
                        Toast.makeText(AccountingAuditActivity.this, "请选择职能部门", Toast.LENGTH_SHORT).show();
                        return ;
                    }else{
                        for(int n=0;n<list.size();n++){
                            if(n!=list.size()-1){
                               zId+=list.get(n)+",";
                            }else{
                                zId+=list.get(n);
                            }
                        }
                        prams2.put("znid",zId);
                    }
                }
                if(!"否".equals(fgld)){
                    String fId="";
                    List<String> list2=new ArrayList<String>();
                    for(int i=0;i<fgldSelected.size();i++){
                        if(fgldSelected.get(i)){
                            list2.add(mFgld.getData().getComboboxList().get(i).getId());
                        }
                    }
                    if(fgldSelected.size()==0){
                        Toast.makeText(AccountingAuditActivity.this, "请选择职能部门", Toast.LENGTH_SHORT).show();
                        return ;
                    }else{
                        for(int n=0;n<list2.size();n++){
                            if(n!=list2.size()-1){
                                fId+=list2.get(n)+",";
                            }else{
                                fId+=list2.get(n);
                            }
                        }
                        prams2.put("fgldid", fId);
                    }
                }
                if("".equals(s)){
                    Toast.makeText(AccountingAuditActivity.this,"请选择审核意见", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(zjl)||zjl==null||"null".equals(zjl)){
                    Toast.makeText(AccountingAuditActivity.this,"是否提交经理审核", Toast.LENGTH_SHORT).show();
                    return;
                }
                prams2.put("claimtypeId",meDetails.getData().getPo().getClaimtypeId());
                prams2.put("datadate", meDetails.getData().getPo().getClaimTime());
                prams2.put("examineState", meDetails.getData().getPo().getExamineState());
                prams2.put("scopetypeId", meDetails.getData().getPo().getScopetypeId());
                HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERREVIEWs, prams2,
                        SaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERREVIEWs, AccountingAuditActivity.this, false).setTag(this);
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
                convertView=View.inflate(AccountingAuditActivity.this,R.layout.item_ywkm,null);
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
        psu.showPopupSearch3(getViews(), button_menu);
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
        group_znbm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.yes:
                        znbm="是";
                        grid_znbm.setVisibility(View.VISIBLE);
                        /**请求网络*/
                        HashMap<String, Object> prams2 = new HashMap<>();
                        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERZNBM, prams2,
                                ZnbmResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERZNBM,AccountingAuditActivity.this, false).setTag(this);
                        break;
                    case R.id.no:
                        znbm = "否";
                        grid_znbm.setVisibility(View.GONE);
                        break;
                }
            }
        });
        group_fgld.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.yes_fgld:
                        fgld="是";
                        grid_fgld.setVisibility(View.VISIBLE);
                        /**请求网络*/
                        HashMap<String, Object> prams2 = new HashMap<>();
                        prams2.put("typeCode","FGLD");
                        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSELECT, prams2,
                                FgldResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT,AccountingAuditActivity.this, false).setTag(this);
                        break;
                    case R.id.no_fgld:
                        fgld = "否";
                        grid_fgld.setVisibility(View.GONE);
                        break;
                }
            }
        });
        group_zjl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.yes_zjl:
                        zjl="是";
                        break;
                    case R.id.no_zjl:
                        zjl = "否";
                        break;
                }
            }
        });
    }
    class MyZnbmAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mZnbm.getData().getComboboxList().size();
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
            ViewHolde holder;

            if(convertView==null){
                convertView=View.inflate(AccountingAuditActivity.this,R.layout.item_znbm,null);
                holder=new ViewHolde();
                holder.check= (CheckBox) convertView.findViewById(R.id.check);
                holder.tv_znbm= (TextView) convertView.findViewById(R.id.tv_znbm);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolde) convertView.getTag();
            }
            if(position==0){
                holder.check.setVisibility(View.GONE);
            }
            holder.check.setChecked(getIsSelected().get(position));
            holder.tv_znbm.setText(mZnbm.getData().getComboboxList().get(position).getText());

            return convertView;
        }
        public  HashMap<Integer,Boolean> getIsSelected() {
            return isSelected;
        }
        public void setIsSelected(HashMap<Integer,Boolean> isSelecte) {
              isSelected = isSelecte;
        }
    }
    class MyFgldAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mFgld.getData().getComboboxList().size();
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
            ViewHolde holder;

            if(convertView==null){
                convertView=View.inflate(AccountingAuditActivity.this,R.layout.item_znbm,null);
                holder=new ViewHolde();
                holder.check= (CheckBox) convertView.findViewById(R.id.check);
                holder.tv_znbm= (TextView) convertView.findViewById(R.id.tv_znbm);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolde) convertView.getTag();
            }
            if (position==0){
                holder.check.setVisibility(View.GONE);
            }
            holder.tv_znbm.setText(mFgld.getData().getComboboxList().get(position).getText());
            holder.check.setChecked(getIsSelecteds().get(position));
            return convertView;
        }
        public  HashMap<Integer,Boolean> getIsSelecteds() {
            return fgldSelected;
        }
        public void setIsSelecteds(HashMap<Integer,Boolean> isSelecte) {
            fgldSelected = isSelecte;
        }
    }
 class ViewHolde{
        CheckBox check;
        TextView tv_znbm;
    }
}
