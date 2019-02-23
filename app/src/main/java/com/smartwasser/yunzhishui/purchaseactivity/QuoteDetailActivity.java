package com.smartwasser.yunzhishui.purchaseactivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EnlistDetailResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.ProjectDetailResponse;
import com.smartwasser.yunzhishui.bean.QuoteDetailResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class QuoteDetailActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private ListView  list_quote_detail;
    private EventNormSelect event;
    private  ProjectDetailResponse mProjectDetail;
    private int j=1;
    private TextView tv_quote_detail_hm,tv_quote_detail_xmmc,tv_quote_detail_rq
            ,tv_quote_detail_ysje,tv_quote_detail_kzj,tv_quote_detail_htq,
            tv_quote_detail_cglb,tv_quote_detail_zzxs,tv_quote_detail_htxs,
            tv_quote_detail_cgfs;
    private ImageButton image_shouqi;
    private RelativeLayout layout_htq,layout_rq;
    private QuoteDetailAdapter mQuoteDetailAdapter;
    private   QuoteDetailResponse  mQuoteDetail;
    @Override
    protected int initContentView() {
        return R.layout.activity_quote_detail;
    }

    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        list_quote_detail= (ListView) findViewById(R.id.list_quote_detail);
        image_shouqi= (ImageButton) findViewById(R.id.image_shouqi);
        tv_quote_detail_hm= (TextView) findViewById(R.id.tv_quote_detail_hm);
        tv_quote_detail_xmmc= (TextView) findViewById(R.id.tv_quote_detail_xmmc);
        tv_quote_detail_rq= (TextView) findViewById(R.id.tv_quote_detail_rq);
        tv_quote_detail_ysje= (TextView) findViewById(R.id.tv_quote_detail_ysje);
        tv_quote_detail_kzj= (TextView) findViewById(R.id.tv_quote_detail_kzj);
        tv_quote_detail_htq= (TextView) findViewById(R.id.tv_quote_detail_htq);
        tv_quote_detail_cglb= (TextView) findViewById(R.id.tv_quote_detail_cglb);
        tv_quote_detail_zzxs= (TextView) findViewById(R.id.tv_quote_detail_zzxs);
        tv_quote_detail_htxs= (TextView) findViewById(R.id.tv_quote_detail_htxs);
        tv_quote_detail_cgfs= (TextView) findViewById(R.id.tv_quote_detail_cgfs);
        layout_htq= (RelativeLayout) findViewById(R.id.layout_htq);
        layout_rq= (RelativeLayout) findViewById(R.id.layout_rq);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        image_shouqi.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("报价管理");
        button_menu.setBackgroundResource(R.drawable.fanhu);
        /**调用校验接口*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("projId", event.getEnlistId());
        HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEFPROJECTFIND, prams,
                ProjectDetailResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEFPROJECTFIND, this, false).setTag(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
                break;
            case R.id.image_shouqi:
                if(j%2==0){
                    image_shouqi.setBackgroundResource(R.drawable.procurement_icon_09);
                    /**隐藏*/
                    layout_htq.setVisibility(View.GONE);
                    layout_rq.setVisibility(View.GONE);
                }else{
                    image_shouqi.setBackgroundResource(R.drawable.procurement_icon_10);
                    /**显示*/
                    layout_htq.setVisibility(View.VISIBLE);
                    layout_rq.setVisibility(View.VISIBLE);
                }
                j++;
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINEFPROJECTFIND
                && response instanceof ProjectDetailResponse) {
            mProjectDetail = (ProjectDetailResponse) response;
            if("00000".equals(  mProjectDetail .getErrorCode())){
                tv_quote_detail_hm.setText("NO:"+"   "+ mProjectDetail.getData().getProjectBaseInfo().getProjCode());
                tv_quote_detail_xmmc.setText(mProjectDetail.getData().getProjectBaseInfo().getProjName());
                tv_quote_detail_rq.setText(mProjectDetail.getData().getProjectBaseInfo().getNoticeStartTime()+"至"
                        +mProjectDetail.getData().getProjectBaseInfo().getNoticeEndTime());
                tv_quote_detail_ysje.setText("预算金额:"+"    "+mProjectDetail.getData().getProjectBaseInfo().getBudgetSum());
                tv_quote_detail_kzj.setText("控制价:"+"    "+mProjectDetail.getData().getProjectBaseInfo().getBudgetControl());
                tv_quote_detail_htq.setText("合同期:"+"    "+mProjectDetail.getData().getProjectBaseInfo().getContrCycle());
                tv_quote_detail_cglb.setText("采购类别:"+"    "+mProjectDetail.getData().getProjectBaseInfo().getProductType());
                tv_quote_detail_zzxs.setText("组织形式:"+"    "+mProjectDetail.getData().getProjectBaseInfo().getPurchaseKind());
                tv_quote_detail_htxs.setText("合同形式:"+"    "+mProjectDetail.getData().getProjectBaseInfo().getContrType());
                tv_quote_detail_cgfs.setText("采购方式:"+"    "+mProjectDetail.getData().getProjectBaseInfo().getPurchaseType());
                /**调用校验接口*/
                HashMap<String, Object> prams = new HashMap<>();
                prams.put("projId", event.getEnlistId());
                HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEQUOTEDETAIL, prams,
                        QuoteDetailResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUOTEDETAIL, this, false).setTag(this);
            }

        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUOTEDETAIL
                && response instanceof QuoteDetailResponse) {
             mQuoteDetail = (QuoteDetailResponse) response;
            if("00000".equals( mQuoteDetail.getErrorCode())){
                /**设置适配器*/
                mQuoteDetailAdapter=new QuoteDetailAdapter();
                list_quote_detail.setAdapter(mQuoteDetailAdapter);
            }
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventNormSelect event){
        this.event= event;
    }
    class QuoteDetailAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return  mQuoteDetail.getData().getSupplierQuoteList().size();
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
                convertView=View.inflate(QuoteDetailActivity.this,R.layout.item_quote_dateil,null);
                holder=new ViewHolder();
                holder.tv_quote_qymc= (TextView) convertView.findViewById(R.id.tv_quote_qymc);
                holder.tv_quote_zxbjzje= (TextView) convertView.findViewById(R.id.tv_quote_zxbjzje);
                holder.tv_quote_bjcs= (TextView) convertView.findViewById(R.id.tv_quote_bjcs);
                holder.tv_quote_xmzcshzt= (TextView) convertView.findViewById(R.id.tv_quote_xmzcshzt);
                holder.tv_quote_bjzt= (TextView) convertView.findViewById(R.id.tv_quote_bjzt);
                holder.tv_quote_scbjsj= (TextView) convertView.findViewById(R.id.tv_quote_scbjsj);
                holder.tv_quote_zxbjsj= (TextView) convertView.findViewById(R.id.tv_quote_zxbjsj);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_quote_qymc.setText("企业名称:"+"     "+mQuoteDetail.getData().getSupplierQuoteList().get(position).getSupplierName());
            holder.tv_quote_zxbjzje.setText(mQuoteDetail.getData().getSupplierQuoteList().get(position).getQuotePrice()+"");
            holder.tv_quote_bjcs.setText(mQuoteDetail.getData().getSupplierQuoteList().get(position).getCountNum());
            holder.tv_quote_xmzcshzt.setText(mQuoteDetail.getData().getSupplierQuoteList().get(position).getCheckResult());
            holder.tv_quote_bjzt.setText(mQuoteDetail.getData().getSupplierQuoteList().get(position).getQuoteStage());
            holder.tv_quote_scbjsj.setText(mQuoteDetail.getData().getSupplierQuoteList().get(position).getFirstQuoteDate());
            holder.tv_quote_zxbjsj.setText(mQuoteDetail.getData().getSupplierQuoteList().get(position).getLastQuoteDate());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_quote_qymc,tv_quote_zxbjzje,tv_quote_bjcs
                ,tv_quote_xmzcshzt,tv_quote_bjzt,tv_quote_scbjsj
                ,tv_quote_zxbjsj;
    }
}
