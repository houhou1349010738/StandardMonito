package com.smartwasser.yunzhishui.pager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter7;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.PurchesaMenuResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.purchaseactivity.EnlistActivity;
import com.smartwasser.yunzhishui.purchaseactivity.QuoteMangerActivity;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;
/**
 * Created by huangmengjie on 2016/8/4 0004.
 */
public class PurchasePager extends BasePager implements HttpLoader.ResponseListener{
    private Context mContext;
    private ListView list_production;
    private PurchesaMenuResponse mProduct;
    private TreeListUtils tlu=new TreeListUtils();
    private SimpleTreeListViewAdapter7 SimleTreeadapter4;
    public PurchasePager(Context context) {
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
    public void initDatas()throws IllegalAccessException {
        HashMap<String,Object> prame=new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEMENULIST,prame,
                PurchesaMenuResponse.class,ConstantsYunZhiShui.REQUEST_CODE_ONLINEMENULIST,this).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode,RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINEMENULIST
                && response instanceof  PurchesaMenuResponse) {
               mProduct = ( PurchesaMenuResponse) response;
            if ("00000".equals(mProduct.getErrorCode())) {
                tlu.initDataText9(mProduct);
                try {
                    SimleTreeadapter4 = new SimpleTreeListViewAdapter7(list_production, mContext, tlu.mDatas2, 0);
                    list_production.setAdapter(SimleTreeadapter4);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                SimleTreeadapter4.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        if (node.isleaf()) {
                            switch (node.getId()){
                                case "7dcef57a297411e6bc63599f0f6ffeae7":
                                    Intent intent = new Intent(mContext, EnlistActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent);
                                break;
                                case "87830a58297411e6bc63599f0f6ffeae7":
                                    Intent intent2 = new Intent(mContext, QuoteMangerActivity.class);
                                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent2);
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
}
