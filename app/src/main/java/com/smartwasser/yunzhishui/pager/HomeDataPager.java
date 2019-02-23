package com.smartwasser.yunzhishui.pager;
import android.content.Context;
import android.content.Intent;

import android.support.v4.widget.SwipeRefreshLayout;

import android.view.View;
import android.widget.AdapterView;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.NoticeActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.DataMainAdapter;
import com.smartwasser.yunzhishui.bean.DataMainResponse;

import com.smartwasser.yunzhishui.bean.RBResponse;

import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.SharedUtils;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import org.seny.android.utils.MyToast;
import java.util.HashMap;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/4/26 0026.
 */
public class HomeDataPager extends BasePager implements HttpLoader.ResponseListener{
    private ListView list_data_home;
    private DataMainAdapter mMainAdapter;
    private int page=1;
    private  RefreshLayout myRefreshListView;
    public HomeDataPager(Context applicationContext) {
          super(applicationContext);
    }
    @Override
    public View initViews() {
        view=View.inflate(context, R.layout.datahome_pager,null);
        list_data_home= (ListView) view.findViewById(R.id.list_data_home);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                view.findViewById(R.id.swipe_layout);
        return view;
    }

    @Override
    public void initDatas() {
        myRefreshListView
                .setColorSchemeResources(android.R.color.holo_blue_bright
                        , android.R.color.holo_orange_light, android.R.color.holo_green_light,
                        android.R.color.holo_blue_light);
        /**准备请求参数*/
        HashMap<String,Object> params = new HashMap<>();
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_DATAMAIN,params, DataMainResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_DATAMAIN, this,false).setTag(this);
    }
           /**请求成功的方法*/
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_DATAMAIN
                && response instanceof DataMainResponse){
            DataMainResponse mResponese= (DataMainResponse) response;
            if("00000".equals(mResponese.getErrorCode())){
              mMainAdapter = new DataMainAdapter(context, mResponese, mResponese.getData().getBcCmsInfo());
              list_data_home.setAdapter(mMainAdapter);
                list_data_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        for (int i = 0; i < list_data_home.getChildCount(); i++) {
                            LinearLayout layout = (LinearLayout) list_data_home.getChildAt(i);
                            ImageView iV = (ImageView) layout.findViewById(R.id.iv_cue);
                            if (i == position) {
                                iV.setVisibility(View.GONE);
                                SharedUtils.setBooleanDate(context, position + "", true);
                            }
                        }
                        mMainAdapter.notifyDataSetChanged();
                        String ids = mMainAdapter.getmDataMain().getData().getBcCmsInfo().get(position).getId();
                        String url = ConstantsYunZhiShui.URL_TONGGAO + "id=" + ids;
                        EventBus.getDefault().postSticky(url);
                        /**跳转到另一个页面*/
                        Intent intent = new Intent(context, NoticeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });

                // 设置下拉刷新时的颜色值,颜色值需要定义在xml中

                // 设置下拉刷新监听器
                myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadData();
                                mMainAdapter.notifyDataSetChanged();
                                // 更新完后调用该方法结束刷新
                                myRefreshListView.setRefreshing(false);
                            }
                        }, 1000);
                    }
                });
            }
            dismissProgressDialog();
        }
    }
              /***请求失败的方法*/
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(context, "error: " + error.getMessage());
    }
    /**
     * 模拟加载数据
     */
    private void loadData() {
        page++;
        showProgressDialog();
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_DATAMAIN, params, DataMainResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_DATAMAIN, HomeDataPager.this).setTag(this);
        showProgressDialog();
    }
}
