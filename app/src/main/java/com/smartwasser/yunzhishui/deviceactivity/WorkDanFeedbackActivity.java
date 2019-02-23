package com.smartwasser.yunzhishui.deviceactivity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.WorkDanFeedAdapter;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.WorkDanList;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.ListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/6/17 0017.
 */
public class WorkDanFeedbackActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ImageButton button_fan,image_serc,image_add;
    private EditText workdan_month;
    private ImageButton image_workdan_month;
    private ListView  list_distri;
    private ListView  minitListView;
    private List<String> mlist;
    private WorkDanFeedAdapter  myAdapter;
    private  WorkDanList workDanList;
    private EditText  ed_home;
    private Toolbar toolbar2;
    private Toolbar toolbar;
    private int page=1;
    private Button image_quxiao;
    private ImageButton but_sousuo;
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List<WorkDanList.DataEntity.EqMaintainEntity.RowsEntity> lists=new ArrayList<>();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return R.layout.fragment_workdan;
    }
    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        ed_home= (EditText) findViewById(R.id.ed_home);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_add= (ImageButton) findViewById(R.id.image_add);
        workdan_month= (EditText)findViewById(R.id.workdan_month);
        toolbar= (Toolbar)findViewById(R.id.toolbars);
        toolbar2= (Toolbar) findViewById(R.id.toolbar2);
        image_quxiao= (Button) findViewById(R.id.image_quxiao);
        but_sousuo= (ImageButton) findViewById(R.id.but_sousuo);
        image_workdan_month= (ImageButton)findViewById(R.id.image_workdan_month);
        list_distri= (ListView)findViewById(R.id.list_distri);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
    }

    @Override
    protected void initListener() {
        button_fan.setOnClickListener(this);
        image_serc.setOnClickListener(this);
        image_quxiao.setOnClickListener(this);
        but_sousuo.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        /**
         * 设置下拉刷新的颜色
         */
        myRefreshListView.setColorSchemeResources(android.R.color.holo_blue_bright
                , android.R.color.holo_orange_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_light
        );
        image_add.setVisibility(View.GONE);
        tv_toolbar_zhu.setText("设备运行");
        tv_toolbar_centext.setText("工单反馈");
        HashMap<String, Object> params = new HashMap<>();
        params.put("page",1);
        HttpLoader.get(ConstantsYunZhiShui.URL_GDLB, params,WorkDanList.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDLB,this,false).setTag(this);
        mlist=new ArrayList<>();
        ListViewUtils utils=new ListViewUtils(this);
        minitListView=utils.initListView(mlist);
        workdan_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtils.showPopupWindow(minitListView, workdan_month);
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        workdan_month.setText(mlist.get(position));
                        PopupWindowUtils.closePopupWindow();
                    }
                });
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_fan:
                finish();
            break;
             case R.id.image_serc:
                 /**弹出搜索界面*/
                 toolbar.setVisibility(View.VISIBLE);
                 toolbar2.setVisibility(View.INVISIBLE);
                 image_quxiao.setVisibility(View.VISIBLE);
            break;
            case R.id.image_quxiao:
                toolbar.setVisibility(View.INVISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                image_quxiao.setVisibility(View.GONE);
                break;
            case R.id.but_sousuo:
                page=1;
                lists.clear();
                flag=false;
                show(page);
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDLB
                && response instanceof WorkDanList) {
            workDanList = (WorkDanList) response;
            if("00000".equals( workDanList.getErrorCode())){
                if(!flag){
                    total=workDanList.getData().getEqMaintain().getTotal();
                }
                for(int n=0;n<workDanList.getData().getEqMaintain().getRows().size();n++){
                    lists.add(workDanList.getData().getEqMaintain().getRows().get(n));
                }
                list_distri.setVisibility(View.VISIBLE);
                if(myAdapter ==null){
                    myAdapter=new WorkDanFeedAdapter(this,lists);
                    list_distri.setAdapter(myAdapter);
                }else {
                    myAdapter.notifyDataSetChanged();
                }
                myRefreshListView.setRefreshing(false);
                myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        list_distri.setVisibility(View.GONE);
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                workDanList= null;
                                page=1;
                                flag = true;
                                lists.clear();
                                show(page);
                            }
                        },1000);
                    }
                });
                // 加载监听器
                myRefreshListView.setOnLoadListener(new RefreshLayout.OnLoadListener() {
                    @Override
                    public void onLoad() {
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadData();
                                flag = false;
                                myRefreshListView.setLoading(false);
                            }
                        }, 2000);
                    }
                });
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }

    private void  loadData(){
        ++page;
        if(total+10>(page*10)) {
            myRefreshListView.pull_to_refresh_loadmore_text.setText("玩命加载中");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.VISIBLE);
            show(page);
        }else{
            myRefreshListView.pull_to_refresh_loadmore_text.setText("没有更多数据了.....");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.GONE);
        }
    }
    private void show(int page){
        /**搜索按钮*/
        HashMap<String, Object> params = new HashMap<>();
        if(workdan_month!=null&& ed_home!=null) {
            String maintainMonth = workdan_month.getText().toString();
            String maintainName = ed_home.getText().toString();

            if (!"".equals(maintainMonth) && maintainMonth != null &&!"null".equals(maintainMonth)) {
                params.put("maintainMonth", maintainMonth);
            }
            if (!"".equals(maintainName) && maintainName != null && !"null".equals(maintainName)) {
                params.put("maintainName", maintainName);
            }
        }
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_GDLB, params,WorkDanList.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDLB,this,false).setTag(this);
    }
}
