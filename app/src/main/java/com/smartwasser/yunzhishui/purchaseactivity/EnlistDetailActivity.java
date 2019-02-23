package com.smartwasser.yunzhishui.purchaseactivity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EnlistDetailResponse;
import com.smartwasser.yunzhishui.bean.EnlistListResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.ProjectDetailResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/8/4 0004.
 */
public class EnlistDetailActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private ListView list_enlist_detail;
    private EventNormSelect event;
    private   EnlistDetailResponse mEnlistDetail;
    private TextView tv_quote_detail_hm,tv_quote_detail_xmmc,tv_quote_detail_rq
            ,tv_quote_detail_ysje,tv_quote_detail_kzj,tv_quote_detail_htq,
            tv_quote_detail_cglb,tv_quote_detail_zzxs,tv_quote_detail_htxs,
            tv_quote_detail_cgfs;
    private ImageButton image_shouqi;
    private RelativeLayout layout_htq,layout_rq;
    private int j=1;
    private EnlistDetailAdapter mDetailAdapter;
    private  ProjectDetailResponse mProjectDetail;
    private EventSearchResponse ens=new EventSearchResponse();
    @Override
    protected int initContentView() {
        return R.layout.activity_dateil_enlist;
    }

    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        list_enlist_detail= (ListView) findViewById(R.id.list_enlist_detail);
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
        tv_toolbar.setText("报名管理");
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
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINEFINDDETAIL
                && response instanceof EnlistDetailResponse) {
            mEnlistDetail = (EnlistDetailResponse) response;
            if("00000".equals(mEnlistDetail.getErrorCode())){
                  /**设置适配器*/
                mDetailAdapter=new EnlistDetailAdapter();
                list_enlist_detail.setAdapter(mDetailAdapter);
            }

        }

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
                HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEFINDDETAIL, prams,
                        EnlistDetailResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEFINDDETAIL, this, false).setTag(this);
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
    class EnlistDetailAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mEnlistDetail.getData().getSupplierList().size();
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
                convertView=View.inflate(EnlistDetailActivity.this,R.layout.item_dateil_enlist,null);
                holder=new ViewHolder();
                holder.tv_enlist_qymc= (TextView) convertView.findViewById(R.id.tv_enlist_qymc);
                holder.tv_enlist_bmsj= (TextView) convertView.findViewById(R.id.tv_enlist_bmsj);
                holder.but_enlist_zczt= (Button) convertView.findViewById(R.id.but_enlist_zczt);
                holder.but_enlist_shzt= (Button) convertView.findViewById(R.id.but_enlist_shzt);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_enlist_qymc.setText(mEnlistDetail.getData().getSupplierList().get(position).getName());
            holder.tv_enlist_bmsj.setText(mEnlistDetail.getData().getSupplierList().get(position).getApplyTime());
            holder.but_enlist_zczt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**获取其id跳到详情页*/
                    ens.setEnlistDetailId(mEnlistDetail.getData().getSupplierList().get(position).getId());
                    EventBus.getDefault().postSticky(ens);
                    Intent intent=new Intent(EnlistDetailActivity.this, QrobotActivity.class);
                    startActivity(intent);
                }
            });
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_enlist_qymc,tv_enlist_bmsj;
        Button but_enlist_zczt,but_enlist_shzt;
    }
}
