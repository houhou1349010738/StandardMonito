package com.smartwasser.yunzhishui.productionactivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.AddToResponse;
import com.smartwasser.yunzhishui.bean.BusinessResponse;
import com.smartwasser.yunzhishui.bean.BusinessTypeResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.IsFillResponse;
import com.smartwasser.yunzhishui.bean.ItemBean;
import com.smartwasser.yunzhishui.bean.ProjectNameResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SaveResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.ListViewHeightUtils;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/21 0021.
 */
public class AddReimburseActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private TextView tv_toolbar;
    private ImageButton norm_ser,button_menu;
    private TextView tianjia;
    private ListView list_add_ywkm;
    private  AddToResponse mAddTo;
    private MyAdapter myAdapter;
    private ListView minlistView,minlistView2,minlistView3;
    private TextView tv_addreimbures_dh,tv_addreimbures_sqr;
    private ProjectNameResponse mProject;
    private SimpleTreeListViewAdapter3 mAdapter;
    private EditText ed_addreimbures_xmmc,ed_addreimbures_ywlx,
            ed_addreimbures_sqsj,ed_addreimbures_fplx,ed_addreimbures_xxje
            ,ed_addreimbures_dxje,ed_addreimbures_sqbxje,
               ed_addreimbures_sqjedx,ed_addreimbures_je
            ,ed_addreimbures_sl,ed_addreimbures_se
            ,ed_addreimbures_skdw,ed_addreimbures_bxsm;
    private String  xmCode="";
    private Button but_addreimbures_save,but_addreimbures_fanhui;
    private TreeListUtils tlu=new TreeListUtils();
    private DialogTimeUtils dialogs=new DialogTimeUtils(this);
    private BusinessTypeResponse mBusiness;
    private MyBusinessAdapter mBusinAdapter;
    private  String ywlx,sqsj;
    private PopListViewUtils plu=new PopListViewUtils(this);
    private Toolbar toolbar;

    private EditText ed_add_reimburse;
    private Button but_add_reimburse;
    private ListView list_business;
    private TextView tv_reimburse;
    private PopupSearchUtils psu=new PopupSearchUtils(this);

    private int page=1;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private View loadMoreView;
    private BusinessResponse  mBusine;
    private MyAdapters myAdapters;
    private ViewHolder holder;
    private RelativeLayout relative;
    private String sqdh,sqr,ywCode;
    private List<ItemBean> mData=new ArrayList<>();
    private List<String> listCode=new ArrayList<>();

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private EventSearchResponse  event;
    double s=0;
    private TextView aeffafw;
    protected int initContentView() {
        return R.layout.activity_add_reimburse;
    }
    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        norm_ser.setVisibility(View.GONE);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_addreimbures_dh= (TextView) findViewById(R.id.tv_addreimbures_dh);
        tianjia= (TextView) findViewById(R.id.tianjia);
        list_add_ywkm= (ListView) findViewById(R.id.list_add_ywkm);
        tv_addreimbures_sqr= (TextView) findViewById(R.id.tv_addreimbures_sqr);
        ed_addreimbures_xmmc= (EditText) findViewById(R.id.ed_addreimbures_xmmc);
        ed_addreimbures_ywlx= (EditText) findViewById(R.id.ed_addreimbures_ywlx);
        ed_addreimbures_sqsj= (EditText) findViewById(R.id.ed_addreimbures_sqsj);
        ed_addreimbures_fplx= (EditText) findViewById(R.id.ed_addreimbures_fplx);
        but_addreimbures_save= (Button) findViewById(R.id.but_addreimbures_save);
        ed_addreimbures_xxje= (EditText) findViewById(R.id.ed_addreimbures_xxje);
        ed_addreimbures_dxje= (EditText) findViewById(R.id.ed_addreimbures_dxje);
        ed_addreimbures_sqbxje= (EditText) findViewById(R.id.ed_addreimbures_sqbxje);
        ed_addreimbures_sqjedx=(EditText) findViewById(R.id.ed_addreimbures_sqjedx);

        ed_addreimbures_je= (EditText) findViewById(R.id.ed_addreimbures_je);
        ed_addreimbures_sl= (EditText) findViewById(R.id.ed_addreimbures_sl);
        ed_addreimbures_se= (EditText) findViewById(R.id.ed_addreimbures_se);
        ed_addreimbures_skdw= (EditText) findViewById(R.id.ed_addreimbures_skdw);
        ed_addreimbures_bxsm= (EditText) findViewById(R.id.ed_addreimbures_bxsm);
        relative= (RelativeLayout) findViewById(R.id.relative);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        aeffafw= (TextView) findViewById(R.id.aeffafw);
        but_addreimbures_fanhui= (Button) findViewById(R.id.but_addreimbures_fanhui);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        tianjia.setOnClickListener(this);
        ed_addreimbures_xmmc.setOnClickListener(this);
        ed_addreimbures_ywlx.setOnClickListener(this);
        ed_addreimbures_sqsj.setOnClickListener(this);
        ed_addreimbures_fplx.setOnClickListener(this);
        but_addreimbures_save.setOnClickListener(this);
        but_addreimbures_fanhui.setOnClickListener(this);
        ed_addreimbures_je.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String sl = ed_addreimbures_sl.getText().toString();
                if ("".equals(sl) || "null".equals(sl) || sl == null) {
                    sl = "0";
                }
                String s2 = s.toString();
                if (s2 == null || "".equals(s2)) {
                    s2 = "0";
                }
                ed_addreimbures_sqbxje.setText((Double.parseDouble(s2) + ((Double.parseDouble(sl) / 100) * Double.parseDouble(s2))) + "");
                ed_addreimbures_se.setText(((Double.parseDouble(sl) / 100) * Double.parseDouble(s2)) + "");
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
                String s2 = ed_addreimbures_je.getText().toString();
                if (s2 == null || "".equals(s2)) {
                    s2 = "0";
                }
                String s3 = s.toString();
                if (s3 == null || "".equals(s3)) {
                    s3 = "0";
                }
                ed_addreimbures_sqbxje.setText(Double.parseDouble(s2) + Double.parseDouble(s2) * (Double.parseDouble(s3) / 100) + "");
                ed_addreimbures_se.setText((Double.parseDouble(s2) / 100) * (Double.parseDouble(s3)) + "");
            }
        });
        ed_addreimbures_sqbxje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String ss = s.toString();
                if ("".equals(s.toString()) || ss == null) {
                    ss = "0";
                }
                ed_addreimbures_sqjedx.setText(MoneyChange.digitUppercase(Double.parseDouble(ss)));
            }
        });
    }
    @Override
    protected void initData() {
        myAdapter = new MyAdapter();
        list_add_ywkm.setAdapter(myAdapter);
        ListViewHeightUtils.setListViewHeight(list_add_ywkm);
        tv_toolbar.setText("费用报销填报");
        HashMap<String, Object> prams2 = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTO, prams2,
                AddToResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTO, this, false).setTag(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. but_addreimbures_fanhui:
                finish();
                break;
            case R.id.button_menu:
                finish();
            break;
            case R.id.tianjia:
                mData.add(new ItemBean());
                myAdapter.notifyDataSetChanged();
                ListViewHeightUtils.setListViewHeight(list_add_ywkm);
                break;
            case R.id.ed_addreimbures_xmmc:
                /**项目名称*/
                minlistView=initListView();
                PopupWindowUtils.showPopupWindow(minlistView, ed_addreimbures_xmmc);
                break;
            case R.id.ed_addreimbures_ywlx:
                /**业务类型*/
                minlistView2=initListView2();
                PopupWindowUtils.showPopupWindow(minlistView2,ed_addreimbures_ywlx);
                break;
            case R.id.ed_addreimbures_sqsj:
                /**申请时间*/
                dialogs.show( ed_addreimbures_sqsj);
                dialogs.showTime();
                break;
            case R.id. ed_addreimbures_fplx:
                minlistView3=plu.initListView5();
                PopupWindowUtils.showPopupWindow(minlistView3,ed_addreimbures_fplx);
                minlistView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_addreimbures_fplx.setText(plu.mListView5.get(position));
                        PopupWindowUtils.closePopupWindow();
                        String fple=ed_addreimbures_fplx.getText().toString();
                        if("增值税专用发票".equals(fple)){
                            relative.setVisibility(View.VISIBLE);
                            aeffafw.setText("报销金额总计:");
                            ed_addreimbures_sqbxje.setEnabled(false);
                            ed_addreimbures_sqbxje.setTextColor(Color.parseColor("#000000"));
                        }else{
                            relative.setVisibility(View.GONE);
                            aeffafw.setText("申请报销金额:");
                            ed_addreimbures_sqbxje.setEnabled(true);
                        }
                    }
                });
                break;
            case R.id. but_addreimbures_save:
                String dyje="";
                String sCode="";
                double m=0;
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
                  /**发起网络请求*/
                HashMap<String, Object> prams = new HashMap<>();
                  /**项目名称*/
                String xmmc=ed_addreimbures_xmmc.getText().toString();
                String sqsj=ed_addreimbures_sqsj.getText().toString();
                String ywlx=ed_addreimbures_ywlx.getText().toString();
                String fplx=ed_addreimbures_fplx.getText().toString();
                String je= ed_addreimbures_je.getText().toString();
                String sl=ed_addreimbures_sl.getText().toString();
                String se=ed_addreimbures_se.getText().toString();
                String skdw= ed_addreimbures_skdw.getText().toString();
                String sqbxje=ed_addreimbures_sqbxje.getText().toString();
                String sqdxje=ed_addreimbures_sqjedx.getText().toString();
                String bxsm= ed_addreimbures_bxsm.getText().toString();
                String xxje=ed_addreimbures_xxje.getText().toString();
                String dxje=ed_addreimbures_dxje.getText().toString();

                if("".equals(xmmc)||"null".equals(xmmc)||xmmc==null){
                    Toast.makeText(AddReimburseActivity.this, "请选择项目名项目", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(sqsj)||sqsj==null||"null".equals(sqsj)){
                    Toast.makeText(AddReimburseActivity.this, "请选择申请时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(ywlx)||ywlx==null||"null".equals(ywlx)){
                    Toast.makeText(AddReimburseActivity.this, "请选择业务类型", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(fplx)||fplx==null||"null".equals(fplx)){
                    Toast.makeText(AddReimburseActivity.this, "请选择发票类型", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(fplx.equals("增值税专用发票")){
                    prams.put("claimSum1",sqbxje);
                    fplx="ZY";
                    if("".equals(je) || je == null || "null".equals(je)){
                        Toast.makeText(AddReimburseActivity.this, "请填写金额", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if("".equals(sl) || sl == null || "null".equals(sl)){
                        Toast.makeText(AddReimburseActivity.this, "请填写税率", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if("".equals(se) || se == null || "null".equals(se)){
                        Toast.makeText(AddReimburseActivity.this, "请填写税额", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    prams.put("invoiceMoney1",je);
                    prams.put("invoiceTaxes",sl);
                    prams.put("InvoiceTax1",se);
                    /**如果金额不等于报销金额则不能添加*/
                    if(m!=Double.parseDouble(je)){
                        Toast.makeText(AddReimburseActivity.this, "业务科目金额和申请金额不相等", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }else if(fplx.equals("增值税普通发票")){
                    if(sqbxje==null||"".equals(sqbxje)){
                        Toast.makeText(AddReimburseActivity.this, "请填写报销金额", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    prams.put("claimSum1",sqbxje);
                    /**如果金额不等于报销金额则不能添加*/
                    if(m!=Double.parseDouble(sqbxje)){
                        Toast.makeText(AddReimburseActivity.this, "业务科目金额和申请金额不相等", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    fplx="PT";
                }else{
                    fplx="QT";
                    if(sqbxje==null||"".equals(sqbxje)){
                        Toast.makeText(AddReimburseActivity.this, "请填写报销金额", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    prams.put("claimSum1",sqbxje);
                    /**如果金额不等于报销金额则不能添加*/
                    if(m!=Double.parseDouble(sqbxje)){
                        Toast.makeText(AddReimburseActivity.this, "业务科目金额和申请金额不相等", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if("".equals(skdw) || skdw == null || "null".equals(skdw)){
                    Toast.makeText(AddReimburseActivity.this, "请填写收款单位", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(sqbxje) ||sqbxje == null || "null".equals(sqbxje)){
                    Toast.makeText(AddReimburseActivity.this, "请填写申请金额", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(bxsm) ||bxsm == null || "null".equals(bxsm)){
                    Toast.makeText(AddReimburseActivity.this, "请填写报销说明", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(dyje) ||dyje == null || "null".equals(dyje)){
                    Toast.makeText(AddReimburseActivity.this, "请填写对应金额", Toast.LENGTH_SHORT).show();
                    return;
                }
                String ywkm=holder.ed_addreimbures_ywkm.getText().toString();
                if("".equals(ywkm) ||ywkm == null || "null".equals(ywkm)){
                    Toast.makeText(AddReimburseActivity.this, "业务科目不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
               /*         *//**报销金额应该在当月剩余值范围内*//*
                if(m>Double.parseDouble(holder.ed_addreimbures_dyjhsyz.getText().toString())){
                    Toast.makeText(AddReimburseActivity.this, "报销金额应该在当月剩余值范围内", Toast.LENGTH_SHORT).show();
                    return;
                }*/

                prams.put("claimDep", xmCode);
                prams.put("scopetypeId",event.getFlowCode());
                prams.put("claimTime",sqsj);
                prams.put("claimtypeId",ywlx);
                prams.put("claimYear1",sqdh);
                prams.put("invoiceType",fplx);
                prams.put("xfdw",skdw);
                prams.put("claimSumValue",sqbxje);
                prams.put("claimSumcn",sqdxje);
                prams.put("claimRealuser",sqr);
                prams.put("claimDesc",bxsm);
                prams.put("feeAmount",dyje);
                prams.put("professionSubject", sCode);
                prams.put("totalmoney2", xxje);
                prams.put("totalmoney2cn",dxje);
                HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSAVE, prams,
                        SaveResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSAVE, this, false).setTag(this);
                break;
        }
    }
    private ListView initListView(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("tableName","SELECT_FACTORY");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERPAYBOXLIST, prams,
                ProjectNameResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYPAYBOXLIST, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","FYLX");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSELECT, prams,
                BusinessTypeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT, this, false).setTag(this);
        return mListViews;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTO
                && response instanceof AddToResponse) {
                mAddTo = (AddToResponse) response;
            if("00000".equals( mAddTo.getErrorCode())){
                sqdh=mAddTo.getData().getYsCode();
                sqr=mAddTo.getData().getUserName();
                tv_addreimbures_dh.setText("NO:"+sqdh);
                tv_addreimbures_sqr.setText("申请人:"+sqr);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERPAYPAYBOXLIST
                && response instanceof ProjectNameResponse) {
            mProject = (ProjectNameResponse) response;
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
                        ed_addreimbures_xmmc.setText(node.getName());
                        for (int i = 0; i < mProject.getData().getListTree().size(); i++) {
                            if (ed_addreimbures_xmmc.getText().toString().equals(mProject.getData().getListTree().get(i).getText())) {
                                xmCode = mProject.getData().getListTree().get(i).getId();
                            }
                        }
                        PopupWindowUtils.closePopupWindow();
                    }
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERYWKMJY
                && response instanceof IsFillResponse) {
            IsFillResponse   IsFill = (IsFillResponse) response;
            if("00000".equals(IsFill.getErrorCode())){
                if(IsFill.getData().getSize()>=1){
                    /**传值*/
                    HashMap<String, Object> prams = new HashMap<>();
                    prams.put("busiType",ywlx);
                    prams.put("claimDep",xmCode);
                    prams.put("datadate",sqsj);
                    prams.put("page", page);
                    HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTOINDE, prams,
                            BusinessResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE, this, false).setTag(this);
                }else{
                    Toast.makeText(AddReimburseActivity.this, "本月无该项目预算计划", Toast.LENGTH_SHORT).show();
                }
            }

        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT
                && response instanceof BusinessTypeResponse) {
            /**类型*/
            mBusiness = (BusinessTypeResponse) response;
            if("00000".equals(mBusiness.getErrorCode())){
                mBusinAdapter=new MyBusinessAdapter();
                minlistView2.setAdapter(mBusinAdapter);
                minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_addreimbures_ywlx.setText(mBusiness.getData().getComboboxList().get(position).getText());
                        PopupWindowUtils.closePopupWindow();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE
                && response instanceof BusinessResponse) {
                mBusine= (BusinessResponse) response;
              if("00000".equals(mBusine.getErrorCode())){
                  if(page==1){
                      showMuchTrend();
                  }
                  myAdapters=new MyAdapters();
                  list_business.setAdapter(myAdapters);
                  list_business.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                      @Override
                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                          ywCode = mBusine.getData().getCostIndeMaster().getRows().get(position).getIndeCode();
                          listCode.add(ywCode);
                          /**将数据显示到EditText上*/
                          for (int i = 0; i <list_add_ywkm.getChildCount(); i++) {
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
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSAVE
                && response instanceof SaveResponse) {
            SaveResponse msave = (SaveResponse) response;
            if("00000".equals(msave.getErrorCode())){
                /**跳转到首页*/
                Intent intent=new Intent(AddReimburseActivity.this,ReimbursementActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
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
                convertView=View.inflate(AddReimburseActivity.this,R.layout.item_yewukemu,null);
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
            //This is important. An EditText just one TextWatcher.
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
                        String ss=mData.get(position).getTextJe().toString();
                        if(ss==null){
                            ss="0";
                        }
                        ed_addreimbures_xxje.setText(ss);
                        ed_addreimbures_dxje.setText(MoneyChange.digitUppercase(Double.parseDouble(ss)));
                      /*ed_addreimbures_xxje.setText(m+"");
                        ed_addreimbures_dxje.setText(MoneyChange.digitUppercase(m));*/
                    }
                }
            };
            if(mData.get(position).getTextJe()!=null&&!"".equals(mData.get(position).getTextJe())){

            }
            holder.ed_addreimbures_dyje.addTextChangedListener(watcher);
            holder.ed_addreimbures_dyje.setTag(watcher);
                    /**删除*/
            holder.but_add_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                         /**去除一个*/
                      mData.remove(itemObj);
                      if(listCode.size()>=1){
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
                    String xmmc = ed_addreimbures_xmmc.getText().toString();
                    ywlx = ed_addreimbures_ywlx.getText().toString();
                    sqsj = ed_addreimbures_sqsj.getText().toString();
                    if ("".equals(xmmc) || "null".equals(xmmc) || xmmc == null) {
                        Toast.makeText(AddReimburseActivity.this, "请选择项目名称", Toast.LENGTH_SHORT).show();
                        return;
                    } else if ("".equals(ywlx) || "null".equals(ywlx) || ywlx == null) {
                        Toast.makeText(AddReimburseActivity.this, "请选择业务类型", Toast.LENGTH_SHORT).show();
                        return;
                    } else if ("".equals(sqsj) || "null".equals(sqsj) || sqsj == null) {
                        Toast.makeText(AddReimburseActivity.this, "请选择申请时间", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                               /**调用校验接口*/
                        HashMap<String, Object> prams = new HashMap<>();
                        prams.put("busiType", ywlx);
                        prams.put("claimDep", xmCode);
                        prams.put("datadate", sqsj);
                        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERYWKMJY, prams,
                                IsFillResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERYWKMJY, AddReimburseActivity.this, false).setTag(this);
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

    class MyBusinessAdapter extends BaseAdapter{
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
                convertView = View.inflate(AddReimburseActivity.this, R.layout.item_search, null);
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
        int  itemsLastIndex = myAdapters.getCount()-1;//数据集最后一项的索引
        int  lastIndex =itemsLastIndex + 1;        //加上底部的loadMoreView项
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex) {
            //如果是自动加载,可以在这里放置异步加载数据的代码
            Log.i("LOADMORE", "loading...");
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
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("busiType",ywlx);
        prams.put("claimDep", xmCode);
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
                convertView=View.inflate(AddReimburseActivity.this,R.layout.item_business,null);
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
    public void onEvent(EventSearchResponse ese){
        event=ese;
    }
}
