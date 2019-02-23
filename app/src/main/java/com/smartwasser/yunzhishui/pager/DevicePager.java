package com.smartwasser.yunzhishui.pager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter2;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.DeviceMenuListResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.deviceactivity.HitchActivity;
import com.smartwasser.yunzhishui.deviceactivity.LedgerActivity;
import com.smartwasser.yunzhishui.deviceactivity.WorkDanDistributeActivity;
import com.smartwasser.yunzhishui.deviceactivity.WorkDanFeedbackActivity;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

/**
 * Created by huangmengjie on 2016/6/15 0015.
 */
public class DevicePager extends BasePager implements HttpLoader.ResponseListener{
    private ListView list_device;
    private SimpleTreeListViewAdapter2 adapter;
    private TreeListUtils tlu=new TreeListUtils();
    private   DeviceMenuListResponse  mDevice;
    public DevicePager(Context context) {
        super(context);
    }
    @Override
    public View initViews() {
        view=View.inflate(context, R.layout.pager_device,null);
        list_device= (ListView) view.findViewById(R.id.list_device);
        return view;
    }
    @Override
    public void initDatas() throws IllegalAccessException {
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGLMENULIST, prams,
                DeviceMenuListResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBGLMENULIST, this).setTag(this);

    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGLMENULIST
                && response instanceof DeviceMenuListResponse) {
             mDevice = (DeviceMenuListResponse) response;
            if("00000".equals(mDevice.getErrorCode())) {
                tlu.initDataText11(mDevice);
                try {
                    adapter = new SimpleTreeListViewAdapter2(list_device, context,tlu.mDatas2, 0);
                    list_device.setAdapter(adapter);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                adapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        if (node.isleaf()) {
                            switch (node.getId()) {
                                case "137482215078957405566":
                                    /**跳转到工单管理*/
                                    Intent intent2 = new Intent(context, WorkDanDistributeActivity.class);
                                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent2);
                                    break;
                                case "137482215078957405116":
                                    /**跳转到工单管理*/
                                    Intent intent = new Intent(context, WorkDanFeedbackActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent);
                                    break;
                                case "137480905179275576837":
                                    /**跳转到工单管理*/
                                    Intent intent3 = new Intent(context, LedgerActivity.class);
                                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent3);
                                    break;
                                case "137482220069050344437":
                                    Intent intent4 = new Intent(context, HitchActivity.class);
                                    intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent4);
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
        MyToast.show(context, "error: " + error.getMessage());
    }
}
