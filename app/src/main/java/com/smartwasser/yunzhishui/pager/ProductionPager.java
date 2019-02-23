package com.smartwasser.yunzhishui.pager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter4;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.ProductResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.productionactivity.ContractActivity;
import com.smartwasser.yunzhishui.productionactivity.ContractQueActivity;
import com.smartwasser.yunzhishui.productionactivity.FfgileadAuditActivity;
import com.smartwasser.yunzhishui.productionactivity.FunctionAuditActivity;
import com.smartwasser.yunzhishui.productionactivity.PaymentActivity;
import com.smartwasser.yunzhishui.productionactivity.ReimburseAuditActivity;
import com.smartwasser.yunzhishui.productionactivity.ReimbursementActivity;
import com.smartwasser.yunzhishui.purchaseactivity.EnlistActivity;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.SharedUtils;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/18 0018.
 */
public class ProductionPager extends BasePager implements HttpLoader.ResponseListener{
    private Context mContext;
    private ListView list_production;
    private   ProductResponse mProduct;
    private EventSearchResponse sear=new EventSearchResponse();
    private TreeListUtils tlu=new TreeListUtils();
    private SimpleTreeListViewAdapter4 SimleTreeadapter4;
    public ProductionPager(Context context) {
        super(context);
        mContext=context;
    }
    @Override
    public View initViews() {
        view=View.inflate(context, R.layout.pager_device,null);
        list_production=(ListView)view.findViewById(R.id.list_device);
        return view;
    }
    @Override
    public void initDatas() throws IllegalAccessException {
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSITE, prams,
                ProductResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSITE, this).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSITE
                && response instanceof ProductResponse) {
            mProduct = (ProductResponse) response;
            if ("00000".equals(mProduct.getErrorCode())) {
                tlu.initDataText6(mProduct);
                try {
                    SimleTreeadapter4 = new SimpleTreeListViewAdapter4(list_production, mContext, tlu.mDatas2, 0);
                    list_production.setAdapter(SimleTreeadapter4);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                SimleTreeadapter4.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        String id="";
                        int j=0;
                        if (node.isleaf()) {
                                for (int i = 0; i < mProduct.getData().size(); i++) {
                                    if (node.getName().equals(mProduct.getData().get(i).getFuncnamech())) {
                                        id=mProduct.getData().get(i).getId();
                                        j=i;
                                    }
                                }
                            switch (id) {
                                case "136766030183844734511":
                                    /**费用报销申请*/
                                    String s2= mProduct.getData().get(j).getFuncurl();
                                    String arr2[]=s2.split("\\?");
                                    String m2[]=arr2[1].split("&");
                                    String x2=m2[0].split("=")[1];
                                    String y2=m2[1].split("=")[1];
                                    SharedUtils.setStringData(context,"production",x2+","+y2);
                                    Intent intent = new Intent(mContext, ReimbursementActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent);
                                    break;
                                case "136766030181122734511":
                                    /**项目经理审核*/
                                    show(j);
                                    Intent intent2 = new Intent(mContext, ReimburseAuditActivity.class);
                                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent2);
                                    break;
                                case "136766030181122734321":
                                    /**分子公司管理处审核*/
                                    show(j);
                                    Intent intent3 = new Intent(mContext, ReimburseAuditActivity.class);
                                    intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent3);
                                    break;
                                case "136766030341122734321":
                                    /**会计审核*/
                                    String s= mProduct.getData().get(j).getFuncurl();
                                    String arr[]=s.split("\\?");
                                    String m[]=arr[1].split("&");
                                    String x=m[0].split("=")[1];
                                    String y=m[1].split("=")[1];
                                    sear.setNodeId(y);
                                    sear.setFlowCode(x);
                                    sear.setFlag(true);
                                    sear.setTitleName(mProduct.getData().get(j).getFuncnamech());
                                    EventBus.getDefault().postSticky(sear);
                                    Intent intent4 = new Intent(mContext, ReimburseAuditActivity.class);
                                    intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent4);
                                    break;
                                case "136766030341121234321":
                                    /***职能部门审核,不一样*/
                                    show(j);
                                    Intent intent8 = new Intent(mContext, FunctionAuditActivity.class);
                                    intent8.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent8);
                                    break;
                                case "136766030341121798321":
                                    /**财务经理审核*/
                                    show(j);
                                    Intent intent5 = new Intent(mContext, ReimburseAuditActivity.class);
                                    intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent5);
                                    break;
                                case "136766030312121798321":
                                    /***分管领导审核,不一样*/
                                    show(j);
                                    Intent intent10 = new Intent(mContext, FfgileadAuditActivity.class);
                                    intent10.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent10);
                                    break;
                                case "7C7264752890437B824899E7B25987E2":
                                    /**总经理审核*/
                                   show(j);
                                    Intent intent6 = new Intent(mContext, ReimburseAuditActivity.class);
                                    intent6.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent6);
                                    break;
                                case "136766030314321798321":
                                    /***出纳及会计审核*/
                                    show(j);
                                    Intent intent7 = new Intent(mContext, ReimburseAuditActivity.class);
                                    intent7.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent7);
                                    break;
                                case "140369015725665841260":
                                    /**跳转收款通知*/
                                    show(j);
                                    Intent intent11 = new Intent(mContext, ContractActivity.class);
                                    intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent11);

                                    break;
                                case "140369015725665841261":
                                    /**跳到确认页*/
                                    show(j);
                                    Intent intent12 = new Intent(mContext, ContractQueActivity.class);
                                    intent12.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent12);
                                    break;
                                case "140369015725665841262":
                                    /**付款申请*/
                                    show(j);
                                    Intent intent13 = new Intent(mContext, PaymentActivity.class);
                                    intent13.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent13);
                                    break;
                            }
                        }
                    }
                });
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(mContext, "error: " + error.getMessage());
    }
    private void show(int i){
        String s= mProduct.getData().get(i).getFuncurl();
        String arr[]=s.split("\\?");
        String m[]=arr[1].split("&");
        String x=m[0].split("=")[1];
        String y=m[1].split("=")[1];
        sear.setNodeId(y);
        sear.setFlowCode(x);
        sear.setFlag(false);
        sear.setTitleName(mProduct.getData().get(i).getFuncnamech());
        EventBus.getDefault().postSticky(sear);
    }
}
