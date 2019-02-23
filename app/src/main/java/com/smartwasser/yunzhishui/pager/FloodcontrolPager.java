package com.smartwasser.yunzhishui.pager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter6;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.FloodcontrolResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.floodcontrolactivity.FieldRainActivity;
import com.smartwasser.yunzhishui.floodcontrolactivity.PumpstationActivity;
import com.smartwasser.yunzhishui.floodcontrolactivity.RainfallActivity;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class FloodcontrolPager extends BasePager implements HttpLoader.ResponseListener{
    private Context mContext;
    private ListView list_floodcontrol;
    private   FloodcontrolResponse  mFloodcontrol;
    private SimpleTreeListViewAdapter6 SimleTreeadapter4;
    private TreeListUtils tlu=new TreeListUtils();
    private EventSearchResponse search=new EventSearchResponse();
    private EventNormSelect event=new EventNormSelect();
    public FloodcontrolPager(Context context) {
        super(context);
        mContext=context;
    }
    @Override
    public View initViews() {
        view=View.inflate(context, R.layout.pager_device,null);
        list_floodcontrol=(ListView)view.findViewById(R.id.list_device);
        return view;
    }
    @Override
    public void initDatas() throws IllegalAccessException {
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_FXXTSITE, prams,
               FloodcontrolResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FXXTSITE, this).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FXXTSITE
                && response instanceof  FloodcontrolResponse) {
             mFloodcontrol=( FloodcontrolResponse)response;
            if("00000".equals(mFloodcontrol.getErrorCode())) {
                tlu.initDataText8(mFloodcontrol);
                try {
                    SimleTreeadapter4 = new SimpleTreeListViewAdapter6(list_floodcontrol, mContext, tlu.mDatas2, 0);
                    list_floodcontrol.setAdapter(SimleTreeadapter4);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                SimleTreeadapter4.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        if (node.isleaf()) {
                            switch (node.getId()) {
                                case "1363597917410540442518":
                                    /**雨量监测*/
                                    search.setFlag(true);
                                    EventBus.getDefault().postSticky(search);
                                    Intent intent=new Intent(mContext,RainfallActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent);
                                    break;
                                case "1366456400325340764868":
                                    /**场降雨量雨量统计*/
                                    event.setFlag(true);
                                    EventBus.getDefault().postSticky(event);
                                    Intent intent2=new Intent(mContext,FieldRainActivity.class);
                                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent2);
                                    break;
                                case "1365673620104266382418":
                                    /**泵站运行状态监测*/
                                    Intent intent3=new Intent(mContext,PumpstationActivity.class);
                                    intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    mContext.startActivity(intent3);
                                    break;
                                case "1363598006955630061048":
                                    /**桥区液位监测*/
                                    break;
                                case "136567409302213803615":
                                    /**交通信息*/
                                    break;
                                case "136765700187148873733":
                                    /**小时雨量*/
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
