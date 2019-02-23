package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.AddToResponse;
import com.smartwasser.yunzhishui.bean.BusinessResponse;
import com.smartwasser.yunzhishui.bean.BusinessTypeResponse;
import com.smartwasser.yunzhishui.bean.ContractDetailResponse;
import com.smartwasser.yunzhishui.bean.DaBinkResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.IsFillResponse;
import com.smartwasser.yunzhishui.bean.ItemBean;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.ListViewHeightUtils;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/8/9 0009.
 */
public class AddContractActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private TextView tv_contract_htbh,tv_contract_htje
            ,tv_contract_wsje,tv_contract_htysje,zhankai;
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
            private ImageButton button_fan,image_add,image_serc;
    /**中间部分的数据*/
    private TextView tv_contract_htjsfs,tv_contract_htmc
            ,tv_contract_xmmc,tv_contract_htlx
            ,tv_contract_jf,tv_contract_yf
            ,tv_contract_qdsj;
    private RelativeLayout relat;
    private int i=1;
    private ContractDetailResponse mContractDetail;
    private   BusinessResponse mBusine;
    private DialogTimeUtils dialogs=new DialogTimeUtils(this);
    private  ListView minlistView3, minlistView2;
    private PopListViewUtils plu=new PopListViewUtils(this);
    private EditText ed_addreimbures_sqbxje,
            ed_addreimbures_fplx,ed_addreimbures_sqsj,ed_addreimbures_skjes
            ,ed_addreimbures_sl,ed_addreimbures_se,ed_addreimbures_je,
            ed_addreimbures_sqjedx,ed_addreimbures_bxsm,ed_addreimbures_khhmc
            ,ed_addreimbures_khhzh,ed_addreimbures_dwdz,ed_addreimbures_sksm
            ,ed_addreimbures_lxfs,ed_addreimbures_xxje,ed_addreimbures_dxje;
    private Button but_addreimbures_save;

    private TextView tv_addreimbures_sqr,tianjia;

    private ListView  list_add_ywkm;
    private   DaBinkResponse mBink;
    private MyBinkAdapter mBinkAdapter;
    private ViewHolder holder;
    private int page=1;
    private MyAdapters myAdapters;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private View loadMoreView;
    private EditText ed_add_reimburse;
    private Button but_add_reimburse,but_addreimbures_fanhui;
    private ListView list_business;
    private TextView tv_reimburse;
    private MyAdapter myAdapter;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private String sqr,ywCode;
    private List<String> listCode=new ArrayList<>();

    private List<ItemBean> mData=new ArrayList<>();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private Toolbar toolbar;
    private String sqsj;
    private AddToResponse mAddTo;
    @Override
    protected int initContentView() {
        return R.layout.activity_addcontract;
    }
    @Override
    protected void initView() {
        tv_contract_htbh= (TextView) findViewById(R.id.tv_contract_htbh);
        tv_contract_htje= (TextView) findViewById(R.id.tv_contract_htje);
        tv_contract_wsje= (TextView) findViewById(R.id.tv_contract_wsje);
        tv_contract_htysje= (TextView) findViewById(R.id.tv_contract_htysje);
        zhankai= (TextView) findViewById(R.id.zhankai);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        button_fan.setBackgroundResource(R.drawable.fanhu);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_add.setVisibility(View.GONE);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_serc.setVisibility(View.GONE);
        /**中间部分的数据*/
        tv_contract_htjsfs= (TextView) findViewById(R.id.tv_contract_htjsfs);
        tv_contract_htmc= (TextView) findViewById(R.id.tv_contract_htmc);
        tv_contract_xmmc= (TextView) findViewById(R.id.tv_contract_xmmc);
        tv_contract_htlx= (TextView) findViewById(R.id.tv_contract_htlx);
        tv_contract_jf= (TextView) findViewById(R.id.tv_contract_jf);
        tv_contract_yf= (TextView) findViewById(R.id.tv_contract_yf);
        tv_contract_qdsj= (TextView) findViewById(R.id.tv_contract_qdsj);
        relat= (RelativeLayout) findViewById(R.id.rayout);

        tv_addreimbures_sqr= (TextView) findViewById(R.id.tv_addreimbures_sqr);
        ed_addreimbures_sqbxje= (EditText) findViewById(R.id.ed_addreimbures_sqbxje);
        ed_addreimbures_fplx= (EditText) findViewById(R.id.ed_addreimbures_fplx);
        ed_addreimbures_sqsj= (EditText) findViewById(R.id.ed_addreimbures_sqsj);
        list_add_ywkm= (ListView) findViewById(R.id. list_add_ywkm);
        tianjia= (TextView) findViewById(R.id.tianjia);
        but_addreimbures_save= (Button) findViewById(R.id.but_addreimbures_save);

        ed_addreimbures_skjes= (EditText) findViewById(R.id.ed_addreimbures_skjes);
        ed_addreimbures_sl= (EditText) findViewById(R.id.ed_addreimbures_sl);
        ed_addreimbures_se= (EditText) findViewById(R.id.ed_addreimbures_se);
        ed_addreimbures_je= (EditText) findViewById(R.id.ed_addreimbures_je);
        ed_addreimbures_sqjedx= (EditText) findViewById(R.id.ed_addreimbures_sqjedx);
        ed_addreimbures_bxsm= (EditText) findViewById(R.id.ed_addreimbures_bxsm);
        ed_addreimbures_khhmc= (EditText) findViewById(R.id.ed_addreimbures_khhmc);
        ed_addreimbures_khhzh= (EditText) findViewById(R.id.ed_addreimbures_khhzh);
        ed_addreimbures_dwdz= (EditText) findViewById(R.id.ed_addreimbures_dwdz);
        ed_addreimbures_sksm= (EditText) findViewById(R.id.ed_addreimbures_sksm);
        ed_addreimbures_lxfs= (EditText) findViewById(R.id.ed_addreimbures_lxfs);
        ed_addreimbures_xxje= (EditText) findViewById(R.id.ed_addreimbures_xxje);
        ed_addreimbures_dxje= (EditText) findViewById(R.id.ed_addreimbures_dxje);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        but_addreimbures_fanhui= (Button) findViewById(R.id.but_addreimbures_fanhui);
        EventBus.getDefault().registerSticky(this);
    }
    private View getViews(){
        View view=View.inflate(this,R.layout.popup_addreimburse,null);
        ed_add_reimburse= (EditText) view.findViewById(R.id.ed_add_reimburse);
        but_add_reimburse= (Button) view.findViewById(R.id.but_add_reimburse);
        list_business= (ListView) view.findViewById(R.id.list_business);
        tv_reimburse= (TextView) view.findViewById(R.id.tv_reimburse);
        loadMoreView=View.inflate(this, R.layout.load_more, null);
        loadMoreButton = (ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        list_business.addFooterView(loadMoreView);
        return view;
    }
    @Override
    protected void initListener() {
        ed_addreimbures_sqbxje.setOnClickListener(this);
        ed_addreimbures_fplx.setOnClickListener(this);
        tianjia.setOnClickListener(this);
        ed_addreimbures_sqsj.setOnClickListener(this);
        but_addreimbures_save.setOnClickListener(this);
        but_addreimbures_fanhui.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_toolbar_zhu.setText("生产成本");
        tv_toolbar_centext.setText("合同管理");
        myAdapter = new MyAdapter();
        list_add_ywkm.setAdapter(myAdapter);
        ListViewHeightUtils.setListViewHeight(list_add_ywkm);
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
        tv_contract_qdsj.setText("签订时间:"+mContractDetail.getData().getPo().getSignTime());
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
        ed_addreimbures_skjes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                String  sl=ed_addreimbures_sl.getText().toString();
                if("".equals(sl)||"null".equals(sl)||sl==null){
                    sl="0";
                }
                String s2=s.toString();
                if(s2==null||"".equals(s2)){
                    s2="0";
                }
                ed_addreimbures_je.setText((Double.parseDouble(s2)-((Double.parseDouble(sl)/100)*Double.parseDouble(s2)))+"");
                ed_addreimbures_se.setText(((Double.parseDouble(sl)/100)*Double.parseDouble(s2))+"");
            }
        });
        ed_addreimbures_sl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                String s2=ed_addreimbures_skjes.getText().toString();
                if(s2==null||"".equals(s2)){
                    s2="0";
                }
                String s3=s.toString();
                if(s3==null||"".equals(s3)){
                    s3="0";
                }
                ed_addreimbures_je.setText(Double.parseDouble(s2)-Double.parseDouble(s2) * (Double.parseDouble(s3) / 100) + "");
                ed_addreimbures_se.setText((Double.parseDouble(s2)/100) * (Double.parseDouble(s3)) + "");
            }
        });
        HashMap<String, Object> prams2 = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTO, prams2,
                AddToResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTO, this, false).setTag(this);
    }
    public void onEvent(ContractDetailResponse mContractDetail){
        this.mContractDetail=mContractDetail;

    }
    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.but_addreimbures_fanhui:
                 finish();
                  break;
             case R.id.ed_addreimbures_sqbxje:
                 /**业务类型*/
                 minlistView2=initListView2();
                 PopupWindowUtils.showPopupWindow(minlistView2,ed_addreimbures_sqbxje);
             break;
             case R.id.ed_addreimbures_fplx:
                 minlistView3=plu.initListView5();
                 PopupWindowUtils.showPopupWindow(minlistView3, ed_addreimbures_fplx);
                 minlistView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         ed_addreimbures_fplx.setText(plu.mListView5.get(position));
                         PopupWindowUtils.closePopupWindow();
                     }
                 });
             break;
             case R.id.ed_addreimbures_sqsj:
                 /**申请时间*/
                 dialogs.show( ed_addreimbures_sqsj);
                 dialogs.showTime();
             break;
             case R.id.but_addreimbures_save:
                 String sCode="";
                 String dyje="";
                 double  m=0;
                 for(int i=0;i<listCode.size();i++){
                     if(i==listCode.size()-1){
                         sCode+=listCode.get(i);
                     }else{
                         sCode+=listCode.get(i)+",";
                     }
                 }
                 for(int j=0;j<mData.size();j++){
                     if(j==mData.size()-1){
                         dyje+=mData.get(j).getTextJe();
                     }else{
                         dyje+=mData.get(j).getTextJe()+",";
                     }
                     m+=Double.parseDouble(mData.get(j).getTextJe().toString());
                     ed_addreimbures_xxje.setText(m + "");
                     ed_addreimbures_dxje.setText(MoneyChange.digitUppercase(m));
                 }
                  /**保存*/
                 String fplx=ed_addreimbures_fplx.getText().toString();
                 String sl=ed_addreimbures_sl.getText().toString();
                 String se=ed_addreimbures_se.getText().toString();
                 String je=ed_addreimbures_je.getText().toString();
                 String skjes= ed_addreimbures_skjes.getText().toString();
                 String kpdw=ed_addreimbures_sqjedx.getText().toString();
                 String dzyh=ed_addreimbures_sqbxje.getText().toString();
                 String nsrsbh=ed_addreimbures_bxsm.getText().toString();
                 String khhmc=ed_addreimbures_khhmc.getText().toString();
                 String khhzh=ed_addreimbures_khhzh.getText().toString();
                 String sqrq=ed_addreimbures_sqsj.getText().toString();
                 String dwdz=ed_addreimbures_dwdz.getText().toString();
                 String sksm=ed_addreimbures_sksm.getText().toString();
                 String lxfs=ed_addreimbures_lxfs.getText().toString();
                 if("".equals(fplx)||fplx==null||"null".equals(fplx)){
                     Toast.makeText(AddContractActivity.this, "请选择发票类型", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(sl)||sl==null||"null".equals(sl)){
                     Toast.makeText(AddContractActivity.this, "请填写税率", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(se)||se==null||"null".equals(se)){
                     Toast.makeText(AddContractActivity.this, "请填写税额", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(skjes)||skjes==null||"null".equals(skjes)){
                     Toast.makeText(AddContractActivity.this, "请填写收款金额", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(kpdw)||kpdw==null||"null".equals(kpdw)){
                     Toast.makeText(AddContractActivity.this, "请填写开票单位", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(dzyh)||dzyh==null||"null".equals(dzyh)){
                     Toast.makeText(AddContractActivity.this, "请填写到账银行", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(nsrsbh)||nsrsbh==null||"null".equals(nsrsbh)){
                     Toast.makeText(AddContractActivity.this, "请填写纳税识别号", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(khhmc)||khhmc==null||"null".equals(khhmc)){
                     Toast.makeText(AddContractActivity.this, "请填写开户行名称", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(khhzh)||khhzh==null||"null".equals(khhzh)){
                     Toast.makeText(AddContractActivity.this, "请填写开户行账号", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(sqrq)|| sqrq==null||"null".equals(sqrq)){
                     Toast.makeText(AddContractActivity.this, "请选择申请日期", Toast.LENGTH_SHORT).show();
                     return;
                 }

                 if("".equals(dwdz)||dwdz==null||"null".equals(dwdz)){
                     Toast.makeText(AddContractActivity.this, "请填写单位地址", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(sksm)||sksm==null||"null".equals(sksm)){
                     Toast.makeText(AddContractActivity.this, "请填写收款说明", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if("".equals(lxfs)||lxfs==null||"null".equals(lxfs)){
                     Toast.makeText(AddContractActivity.this, "请填写联系方式", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if(fplx.equals("增值税普通发票")){
                     fplx="PT";
                 }else if(fplx.equals("增值税专用发票")){
                     fplx="ZY";
                 }else{
                     fplx="QT";
                 }
                 /**如果金额不等于报销金额则不能添加*/
                 if(m!=Double.parseDouble(ed_addreimbures_skjes.getText().toString())){
                     Toast.makeText(AddContractActivity.this, "业务科目金额和申请金额不相等", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 /**发起网络请求*/
                 HashMap<String, Object> prams = new HashMap<>();

                 prams.put("fundsType",mContractDetail.getData().getPo().getFundsType());
                 prams.put("contrId",mContractDetail.getData().getPo().getId());
                 prams.put("buCode",mContractDetail.getData().getPo().getBuCode());
                 prams.put("invoiceType",fplx);
                 prams.put("incomeMoney1",skjes);
                 prams.put("invoiceTaxes",sl);
                 prams.put("invoiceTax1",se);
                 prams.put("invoiceMoney1",je);
                 prams.put("bank",dzyh);
                 prams.put("organizationName",kpdw);

                 prams.put("taxpayer",nsrsbh);
                 prams.put("bankName",khhmc);
                 prams.put("bankNumber",khhzh);

                 prams.put("applyTime",sqrq);
                 prams.put("organizationAdd",dwdz);
                 prams.put("incomeSummary",sksm);
                 prams.put("phone",lxfs);

                 prams.put("professionSubject1",sCode);
                 prams.put("feeAmount1", dyje);
                 HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSAVESK, prams,
                         SaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSAVESK, this, false).setTag(this);
             break;
             case R.id.tianjia:
                 mData.add(new ItemBean());
                 myAdapter.notifyDataSetChanged();
                 ListViewHeightUtils.setListViewHeight(list_add_ywkm);
                 break;
         }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTO
                && response instanceof AddToResponse) {
            mAddTo = (AddToResponse) response;
            if("00000".equals( mAddTo.getErrorCode())){
                sqr=mAddTo.getData().getUserName();
                tv_addreimbures_sqr.setText("申请人:"+sqr);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT
                && response instanceof DaBinkResponse) {
            /**类型*/
            mBink = (DaBinkResponse) response;
            if ("00000".equals(mBink.getErrorCode())) {
                mBinkAdapter = new MyBinkAdapter();
                minlistView2.setAdapter(mBinkAdapter);
                minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_addreimbures_sqbxje.setText(mBink.getData().getComboboxList().get(position).getText());
                        PopupWindowUtils.closePopupWindow();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERYWKMJY
                && response instanceof IsFillResponse) {
            IsFillResponse IsFill = (IsFillResponse) response;
            if ("00000".equals(IsFill.getErrorCode())) {
                /**请求网络*/
                String sqsj = ed_addreimbures_sqsj.getText().toString();
                HashMap<String, Object> prams = new HashMap<>();
                prams.put("datadate", sqsj);
                prams.put("page", page);
                HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTOINDE, prams,
                        BusinessResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE, AddContractActivity.this, false).setTag(this);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE
                && response instanceof BusinessResponse) {
            mBusine = (BusinessResponse) response;
            if ("00000".equals(mBusine.getErrorCode())) {
                if (page == 1) {
                    showMuchTrend();
                }
                myAdapters = new MyAdapters();
                list_business.setAdapter(myAdapters);
                list_business.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ywCode = mBusine.getData().getCostIndeMaster().getRows().get(position).getIndeCode();
                        listCode.add(ywCode);
                        /**将数据显示到EditText上*/
                        for (int i = 0; i < list_add_ywkm.getChildCount(); i++) {
                            LinearLayout layout = (LinearLayout) list_add_ywkm.getChildAt(Integer.parseInt(holder.but_xuanze.getTag().toString()));
                            holder.ed_addreimbures_ywkm = (EditText) layout.findViewById(R.id.ed_addreimbures_ywkm);
                            holder.ed_addreimbures_dyjhz = (EditText) layout.findViewById(R.id.ed_addreimbures_dyjhz);
                            holder.ed_addreimbures_dyje = (EditText) layout.findViewById(R.id.ed_addreimbures_dyje);
                            holder.ed_addreimbures_dyjhz.setText(mBusine.getData().getCostIndeMaster().getRows().get(position).getMaxValue());
                            holder.ed_addreimbures_ywkm.setText(mBusine.getData().getCostIndeMaster().getRows().get(position).getIndeName());
                            holder.ed_addreimbures_dyjhsyz = (EditText) layout.findViewById(R.id.ed_addreimbures_dyjhsyz);
                            holder.ed_addreimbures_dyjhsyz.setText(mBusine.getData().getCostIndeMaster().getRows().get(position).getMinValue());
                            mData.get(i).setTextKemu(holder.ed_addreimbures_ywkm.getText().toString());
                            mData.get(i).setTextJhz(holder.ed_addreimbures_dyjhz.getText().toString());
                            mData.get(i).setTextSyz(holder.ed_addreimbures_dyjhsyz.getText().toString());
                        }
                        psu.colsePopupWindow();
                    }
                });

            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSAVESK
                && response instanceof SaveResponse) {
            SaveResponse msave = (SaveResponse) response;
            if("00000".equals(msave.getErrorCode())){
                /**跳转到首页*/
                Intent intent=new Intent(AddContractActivity.this,ContractActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
    private void showMuchTrend(){
        psu.showPopupSearch(getViews(), toolbar);
        tv_reimburse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
                page=1;
            }
        });
        but_add_reimburse.setOnClickListener(this);
        list_business.setOnScrollListener(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        list_business.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });

    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int  itemsLastIndex = myAdapter.getCount()-1;//数据集最后一项的索引
        int  lastIndex =itemsLastIndex + 1;        //加上底部的loadMoreView项
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex) {
            //如果是自动加载,可以在这里放置异步加载数据的代码
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }
    private void  loadData(){
        ++page;
        /**查询接口*/
        String sqsj=ed_addreimbures_sqsj.getText().toString();
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("datadate", sqsj);
        String s= ed_add_reimburse.getText().toString();
        if(!"".equals(s)||!"null".equals(s)||s!=null){
            prams.put("indeName",s);
        }
        prams.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTOINDE, prams,
                BusinessResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE,this, false).setTag(this);
    }
    class MyAdapters extends BaseAdapter{
        @Override
        public int getCount() {
            return   mBusine.getData().getCostIndeMaster().getRows().size();
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
                convertView=View.inflate(AddContractActivity.this,R.layout.item_business,null);
                holder=new ViewHolder();
                holder.tv_business_ywkm= (TextView) convertView.findViewById(R.id.tv_business_ywkm);
                holder.tv_business_ywlx=(TextView) convertView.findViewById(R.id.tv_business_ywlx);
                holder.tv_business_dyjhz=(TextView) convertView.findViewById(R.id.tv_business_dyjhz);
                holder.tv_business_dyjhsyz=(TextView) convertView.findViewById(R.id.tv_business_dyjhsyz);
                convertView.setTag( holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_business_ywkm.setText("业务科目:"+"  "+mBusine.getData().getCostIndeMaster().getRows().get(position).getIndeName());
            holder.tv_business_ywlx.setText("业务类型:"+"  "+mBusine.getData().getCostIndeMaster().getRows().get(position).getCostType());
            String s=mBusine.getData().getCostIndeMaster().getRows().get(position).getMaxValue();
            if(s.length()>=5){
                s=s.substring(0,4);
            }
            String s2=mBusine.getData().getCostIndeMaster().getRows().get(position).getMinValue();
            if(s2.length()>=7){
                s2=s2.substring(0,6);
            }
            holder.tv_business_dyjhz.setText("当月计划值:￥" +s);
            holder.tv_business_dyjhsyz.setText("当月计划剩余值:￥"+s2);
            return convertView;
        }
        class ViewHolder{
            TextView tv_business_ywkm,tv_business_ywlx,
                    tv_business_dyjhz,tv_business_dyjhsyz;
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    private ListView initListView2(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","KHYH");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSELECT, prams,
                DaBinkResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT, this, false).setTag(this);
        return mListViews;
    }
    class MyBinkAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mBink.getData().getComboboxList().size();
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
                convertView = View.inflate(AddContractActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mBink.getData().getComboboxList().get(position).getText());
            return convertView;
        }
        class ViewHolder{
            TextView v_listview_item_number;
        }
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return   mData.size();
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
        public View getView(final int position, View convertView, final ViewGroup parent) {
            if(convertView==null){
                convertView=View.inflate(AddContractActivity.this,R.layout.item_yewukemu,null);
                holder=new ViewHolder();
                holder.but_add_delete= (ImageButton) convertView.findViewById(R.id.but_add_delete);
                holder.ed_addreimbures_ywkm= (EditText) convertView.findViewById(R.id.ed_addreimbures_ywkm);
                holder.ed_addreimbures_dyjhz= (EditText) convertView.findViewById(R.id.ed_addreimbures_dyjhz);
                holder.ed_addreimbures_dyje= (EditText) convertView.findViewById(R.id.ed_addreimbures_dyje);
                holder.ed_addreimbures_dyjhsyz= (EditText) convertView.findViewById(R.id.ed_addreimbures_dyjhsyz);
                holder.tv_conut= (TextView) convertView.findViewById(R.id.tv_conut);
                holder.but_xuanze= (ImageButton) convertView.findViewById(R.id.but_xuanze);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder)convertView.getTag();
            }
            if(position== mData.size()-1){
                /**给删除显示*/
                holder.but_add_delete.setVisibility(View.VISIBLE);
            }else{
                holder.but_add_delete.setVisibility(View.GONE);
            }
            final ItemBean itemObj=mData.get(position);
            holder.tv_conut.setText(position+1+"");
            if (holder.ed_addreimbures_dyje.getTag() instanceof TextWatcher) {
                holder.ed_addreimbures_dyje.removeTextChangedListener((TextWatcher) holder.ed_addreimbures_dyje.getTag());
            }
            holder.ed_addreimbures_dyje.setText(itemObj.getTextJe());
            holder.ed_addreimbures_ywkm.setText(itemObj.getTextKemu());
            holder.ed_addreimbures_dyjhsyz.setText(itemObj.getTextSyz());
            holder.ed_addreimbures_dyjhz.setText(itemObj.getTextJhz());

            TextWatcher watcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
                @Override
                public void afterTextChanged(Editable s) {
                    if (TextUtils.isEmpty(s)) {
                        itemObj.setTextJe("");
                    } else {
                        itemObj.setTextJe(s.toString());
                        ed_addreimbures_xxje.setText(s.toString());
                        ed_addreimbures_dxje.setText(MoneyChange.digitUppercase(Double.parseDouble(s.toString())));
                    }
                }
            };
            holder.ed_addreimbures_dyje.addTextChangedListener(watcher);
            holder.ed_addreimbures_dyje.setTag(watcher);
            /**删除*/
            holder.but_add_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**去除一个*/
                    mData.remove(itemObj);
                    if(listCode.size()>=1) {
                        listCode.remove(listCode.size() - 1);
                    }
                    notifyDataSetChanged();
                    ListViewHeightUtils.setListViewHeight(list_add_ywkm);
                }
            });
            holder.but_xuanze.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.but_xuanze.setTag(position);
                    /**判断项目名称是否为空*/
                    sqsj = ed_addreimbures_sqsj.getText().toString();
                   if ("".equals(sqsj) || "null".equals(sqsj) || sqsj == null) {
                        Toast.makeText(AddContractActivity.this, "请选择申请时间", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        /**调用校验接口*/
                        HashMap<String, Object> prams = new HashMap<>();
                        prams.put("claimDep",mContractDetail.getData().getPo().getBuCode());
                        prams.put("datadate", sqsj);
                        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERYWKMJY, prams,
                                IsFillResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERYWKMJY, AddContractActivity.this, false).setTag(this);
                    }
                }
            });
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_conut;
        ImageButton but_add_delete, but_xuanze;
        EditText ed_addreimbures_ywkm,ed_addreimbures_dyje
                ,ed_addreimbures_dyjhz,ed_addreimbures_dyjhsyz;
    }
}
