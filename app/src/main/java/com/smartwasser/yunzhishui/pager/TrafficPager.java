package com.smartwasser.yunzhishui.pager;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import android.widget.ListView;


import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter9;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.TrafficMenuListResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.sludgeactivity.RealTimeMonitorActivity;
import com.smartwasser.yunzhishui.sludgeactivity.TrajectoryActivity;
import com.smartwasser.yunzhishui.sludgeactivity.TransportationActivity;
import com.smartwasser.yunzhishui.sludgeactivity.WeightActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;
import java.util.HashMap;
/**
 * Created by huangmengjie on 2016/6/15 0015.
 */
public class TrafficPager extends BasePager implements HttpLoader.ResponseListener{
    private Context mContext;
    private ListView list_traff;
    private  TrafficMenuListResponse mTrafficMenu;
    private TreeListUtils tlu=new TreeListUtils();
    private SimpleTreeListViewAdapter9 SimleTreeadapter4;
    public TrafficPager(Context context) {
        super(context);
        mContext=context;
    }
    @Override
    public View initViews() {
        view=View.inflate(context, R.layout.pager_traffic,null);
        list_traff= (ListView)view.findViewById(R.id.list_traff);
        return  view;
    }
    @Override
    public void initDatas() {
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTMENULIST, prams,
                TrafficMenuListResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMENULIST, this).setTag(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTMENULIST
                && response instanceof TrafficMenuListResponse) {
            mTrafficMenu = (TrafficMenuListResponse) response;
            if ("00000".equals(mTrafficMenu.getErrorCode())) {
                tlu.initDataText10(mTrafficMenu);
                try {
                    SimleTreeadapter4 = new SimpleTreeListViewAdapter9(list_traff, mContext, tlu.mDatas2, 0);
                    list_traff.setAdapter(SimleTreeadapter4);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                SimleTreeadapter4.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        if (node.isleaf()) {
                            switch (node.getId()){
                                case "20130227001":
                                    Intent intent0=new Intent(context, RealTimeMonitorActivity.class);
                                    intent0.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent0);
                                    break;
                                case "20130227002":
                                    Intent intent=new Intent(context, TrajectoryActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent);
                                    break;
                                case "20130227003":
                                    Intent intent2=new Intent(context,TransportationActivity.class);
                                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent2);
                                    break;
                                case "20130227018":
                                    Intent intent3=new Intent(context,WeightActivity.class);
                                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    context.startActivity(intent3);
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
