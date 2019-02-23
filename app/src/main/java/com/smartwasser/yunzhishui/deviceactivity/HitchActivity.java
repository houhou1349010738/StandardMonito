package com.smartwasser.yunzhishui.deviceactivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.HitchAdapter;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.HitchResponse;
import com.smartwasser.yunzhishui.bean.HitchTypeResponse;
import com.smartwasser.yunzhishui.bean.LegerListResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TreeListUtils;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/6/16 0016.
 */
public class HitchActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private Toolbar toolbar2;
    private ImageButton button_fan,image_serc,image_add;
    private ListView list_hitch;
    private HitchAdapter myAdapter;
    private int i=0;
    /**设备名称*/
    private EditText ed_hitch_sbname;
    /**故障状态*/
    private EditText ed_hitch_gzstart;
    /**故障类别*/
    private EditText ed_hitch_gzlb;
    private ImageButton image_hitch_sblei;
    /**故障开始时间*/
    private EditText ed_hitch_startTime;
    private ImageButton image_hitch_startTiem;
    /**故障结束时间*/
    private EditText ed_hitch_endTime;
    private ImageButton image_hitch_endTiem;
    Date cDate2,cDate3;
    /**查询*/
    private Button but_hitch_search;
    private View parientView;
    private TextView tv_hitchsea;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private  HitchResponse mHitch;
    private ListView minlistView;
    private int page=1;
    private SimpleTreeListViewAdapter3 mAdapter;
    private HitchTypeResponse  mHitchType;
    private String code="";
    private TreeListUtils tlu=new TreeListUtils();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private EventNormSelect ensel=new EventNormSelect();
    private EventSearchResponse ss=new EventSearchResponse();
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List<HitchResponse.DataEntity.EqFailureEntity.RowsEntity> lists=new ArrayList<>();
    @Override
    protected int initContentView() {
        return R.layout.activity_hitch;
    }
    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_add= (ImageButton) findViewById(R.id.image_add);
        list_hitch= (ListView) findViewById(R.id.list_hitch);
        toolbar2= (Toolbar) findViewById(R.id.toolbar2);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
    }
    @Override
    protected void initListener() {
        button_fan.setOnClickListener(this);
        image_serc.setOnClickListener(this);
        image_add.setOnClickListener(this);
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
        tv_toolbar_zhu.setText("设备运行");
        tv_toolbar_centext.setText("故障管理");
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", 1);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZLIST,params,HitchResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBGZLIST,this,false).setTag(this);

    }
    private View getView(){
        View view=View.inflate(this,R.layout.popup_hitchsearch,null);
        ed_hitch_sbname= (EditText) view.findViewById(R.id.ed_hitch_sbname);
        ed_hitch_gzstart= (EditText) view.findViewById(R.id.ed_hitch_gzstart);
        ed_hitch_gzlb= (EditText) view.findViewById(R.id.ed_hitch_gzlb);
        ed_hitch_startTime= (EditText) view.findViewById(R.id.ed_hitch_startTime);
        ed_hitch_endTime= (EditText) view.findViewById(R.id.ed_hitch_endTime);
        image_hitch_sblei= (ImageButton) view.findViewById(R.id.image_hitch_sblei);
        image_hitch_startTiem= (ImageButton) view.findViewById(R.id.image_hitch_startTiem);
        image_hitch_endTiem=(ImageButton) view.findViewById(R.id. image_hitch_endTiem);
        but_hitch_search= (Button) view.findViewById(R.id.but_hitch_search);
        tv_hitchsea= (TextView) view.findViewById(R.id.tv_hitchsea);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_fan:
                finish();
                break;
            case R.id.image_serc:
                /**弹出搜索界面*/
                showMuchTrend();
                break;
            case R.id.image_add:
                int x=1;
                ss.setX(1);
                EventBus.getDefault().postSticky(ss);
                Intent intent2=new Intent(HitchActivity.this,AddHitchActivity.class);
                startActivity(intent2);
                break;
            case R.id. ed_hitch_endTime:
                /**结束时间*/
                dialog.show(ed_hitch_endTime);
                dialog.showTime();
                break;
            case R.id.ed_hitch_startTime:
                /**开始时间*/
                dialog.show(ed_hitch_startTime);
                dialog.showTime();
                break;
            case R.id.ed_hitch_gzlb:
                 /**故障类别弹出pop*/
                minlistView=initListView();
                pwtu.showPopupWindow(minlistView,parientView,ed_hitch_gzlb.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.222),(int)(GetScreenParam.getScreenHeight(this)*0.229));
                break;
            case R.id.but_hitch_search:
                psu.colsePopupWindow();
                page=1;
                lists.clear();
                flag=false;
                show(page);
                break;
        }
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZLIST
                && response instanceof HitchResponse) {
               mHitch= (HitchResponse) response;
              if("00000".equals( mHitch.getErrorCode())){
                  if(!flag){
                      total= mHitch.getData().getEqFailure().getTotal();
                  }
                  for(int n=0;n<mHitch.getData().getEqFailure().getRows().size();n++){
                      lists.add(mHitch.getData().getEqFailure().getRows().get(n));
                  }
                  list_hitch.setVisibility(View.VISIBLE);
                  if( myAdapter==null){
                      myAdapter=new HitchAdapter(this,lists);
                      list_hitch.setAdapter( myAdapter);
                  }else {
                      myAdapter.notifyDataSetChanged();
                  }
                  myRefreshListView.setRefreshing(false);
                  myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                      @Override
                      public void onRefresh() {
                          list_hitch.setVisibility(View.GONE);
                          myRefreshListView.postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  mHitch= null;
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
            list_hitch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    /**未确认状态的页面*/
                    String stat =lists.get(position).getFailureState();
                    String failureId = lists.get(position).getFailureId();
                    String leibie = lists.get(position).getFailureTbType();
                    String buwei = lists.get(position).getFailurePart();
                    /**将s传到HitchNotConfir页面*/
                    ensel.setState(stat);
                    ensel.setFailureId(failureId);
                    ensel.setLeibie(leibie);
                    ensel.setBuwei(buwei);
                    EventBus.getDefault().postSticky(ensel);
                    Intent intent = new Intent(HitchActivity.this, HitchNotConfirmedActivity.class);
                    startActivity(intent);
                }
            });
              }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZLB
                && response instanceof HitchTypeResponse) {
             mHitchType= ( HitchTypeResponse) response;
            tlu.initDataText2(mHitchType);
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
                        ed_hitch_gzlb.setText(node.getName());
                        for (int i = 0; i < mHitchType.getData().getListTree().size(); i++) {
                            if (node.getName().equals(mHitchType.getData().getListTree().get(i).getTbTypeName())) {
                                code = mHitchType.getData().getListTree().get(position).getId();
                            }
                        }
                        pwtu.closePopupWindow();
                    }
                }
            });
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
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZLB, prams,
                HitchTypeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBGZLB, this, false).setTag(this);
        return mListViews;
    }

    private void showMuchTrend(){
        psu.showPopupSearch(getView(), toolbar2);
        parientView= toolbar2;
        tv_hitchsea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_hitch_endTime.setOnClickListener(this);
        ed_hitch_startTime.setOnClickListener(this);
        ed_hitch_gzlb.setOnClickListener(this);
        but_hitch_search.setOnClickListener(this);
    }
    private void show(int page){
        /**判断是否为空*/
        HashMap<String,Object> params = new HashMap<>();
        String s="";
        /**获取设备名称*/
        if(ed_hitch_startTime!=null&&ed_hitch_endTime!=null
                &&ed_hitch_sbname!=null&&ed_hitch_gzstart!=null
                &&ed_hitch_gzlb!=null){
        String start=ed_hitch_startTime.getText().toString();
        String end=ed_hitch_endTime.getText().toString();
        String name=ed_hitch_sbname.getText().toString();
        String state=ed_hitch_gzstart.getText().toString();
        String gzlb=ed_hitch_gzlb.getText().toString();
        if("".equals(gzlb)){
            code="";
        }
        if("已确认".equals(state)){
            s="1";
        }else if("未确认".equals(state)){
            s="0";
        }
        if(!"0".equals(s)&&!"1".equals(s)&&!"".equals(s)){
            Toast.makeText(HitchActivity.this, "状态填写有误", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!"".equals(start)&&!"null".equals(start)&&start!=null){
            params.put("start",start);
        }
        if(!"".equals(name)&&!"null".equals(name)&&name!=null){
            params.put("equipName",name);
        }
        if(!"".equals(end)&&!"null".equals(end)&&end!=null){
            params.put("end",end);
        }
        if(!"".equals(gzlb)&&!"null".equals(gzlb)&&gzlb!=null){
            params.put("failureTbType",code);
        }
        if(!"".equals(state)&&!"null".equals(state)&&state!=null){
            params.put("failureState", s);
          }
        }
        params.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZLIST, params,HitchResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBGZLIST,this,false).setTag(this);
    }
}
