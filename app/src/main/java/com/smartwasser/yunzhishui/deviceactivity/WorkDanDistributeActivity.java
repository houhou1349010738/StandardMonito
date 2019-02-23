package com.smartwasser.yunzhishui.deviceactivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
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
import com.smartwasser.yunzhishui.bean.DeleteResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.LegerListResponse;
import com.smartwasser.yunzhishui.bean.PaifaResponse;
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
 * Created by huangmengjie on 2016/6/16 0016.
 */
public class WorkDanDistributeActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ImageButton button_fan,image_serc,image_add;
    private EditText workdan_month;
    private ImageButton image_workdan_month;
    private ListView list_distri;
    private WorkDanAdapter myAdapter;
    public List<String> mListView;
    private ListView  minitListView;
    private EditText ed_home;
    private Toolbar toolbar;
    private Toolbar toolbar2;
    private Button image_quxiao;
    private ImageButton but_sousuo;
    private  WorkDanList workDanList;
    private int page=1;
    /** 弹出自定义密码对话框的方法 */
    private AlertDialog dialog;
    private EventNormSelect norm=new EventNormSelect();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private RefreshLayout myRefreshListView;
    private  int total;
    private boolean flag=false;
    private List< WorkDanList.DataEntity.EqMaintainEntity.RowsEntity> lists=new ArrayList<>();
    @Override
    protected int initContentView() {
        return R.layout.fragment_workdan;
    }
    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        image_serc= (ImageButton) findViewById(R.id.image_serc);

        image_add= (ImageButton) findViewById(R.id.image_add);
        workdan_month= (EditText)findViewById(R.id.workdan_month);
        image_workdan_month= (ImageButton)findViewById(R.id.image_workdan_month);
        list_distri= (ListView)findViewById(R.id.list_distri);
        ed_home= (EditText) findViewById(R.id.ed_home);
        toolbar= (Toolbar)findViewById(R.id.toolbars);
        toolbar2= (Toolbar) findViewById(R.id.toolbar2);
        image_quxiao= (Button) findViewById(R.id.image_quxiao);
        but_sousuo= (ImageButton) findViewById(R.id.but_sousuo);
        // 获取RefreshLayout实例
        myRefreshListView = (RefreshLayout)
                findViewById(R.id.swipe_layout);
    }
    @Override
    protected void initListener() {
        button_fan.setOnClickListener(this);
        image_add.setOnClickListener(this);
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
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", 1);
        HttpLoader.get(ConstantsYunZhiShui.URL_GDLB, params,WorkDanList.class,
                ConstantsYunZhiShui.REQUEST_CODE_GDLB,this,false).setTag(this);
        tv_toolbar_zhu.setText("设备运行");
        tv_toolbar_centext.setText("工单派发");
        mListView=new ArrayList<>();
        ListViewUtils utils=new ListViewUtils(this);
        minitListView=utils.initListView(mListView);
        workdan_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtils.showPopupWindow(minitListView, workdan_month);
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        workdan_month.setText(mListView.get(position));
                        PopupWindowUtils.closePopupWindow();
                    }
                });
            }
        });


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_fan:
                finish();
                break;
            case R.id.image_serc:
                    /**弹出搜索界面*/
                toolbar.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.INVISIBLE);
                image_quxiao.setVisibility(View.VISIBLE);
                break;
            case R.id.image_add:
                /**跳到添加界面*/
                Intent intent=new Intent(this,AddWorkDanActivity.class);
                startActivity(intent);
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
              if("00000".equals(workDanList.getErrorCode())) {
                  if(!flag){
                      total=workDanList.getData().getEqMaintain().getTotal();
                  }
                  for(int n=0;n<workDanList.getData().getEqMaintain().getRows().size();n++){
                      lists.add(workDanList.getData().getEqMaintain().getRows().get(n));
                  }
                  list_distri.setVisibility(View.VISIBLE);
                  if(myAdapter ==null){
                      myAdapter = new WorkDanAdapter();
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
                  list_distri.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                      @Override
                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                          /**将id传入*/
                          String tianId = lists.get(position).getMaintainId();
                          String state =  lists.get(position).getMaintainStatus();
                          norm.setTianId(tianId);
                          norm.setWorkdanState(state);
                          EventBus.getDefault().postSticky(norm);
                          Intent intent = new Intent(WorkDanDistributeActivity.this, WorkDanNotCompletActivity.class);
                          startActivity(intent);
                      }
                  });
                  /**长按删除该工单*/
                  list_distri.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                      @Override
                      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                          showPwdAlertDialog(position);
                          return true;
                      }
                  });
              }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDDELETE
                && response instanceof DeleteResponse) {
            DeleteResponse mDelete= (DeleteResponse) response;
            if("00000".equals(mDelete.getErrorCode())){
                  /**删除成功刷新适配器**/
                dialog.dismiss();
                Toast.makeText(WorkDanDistributeActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                /**刷新适配器*/
                myAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_GDPF
                && response instanceof PaifaResponse) {
            PaifaResponse mPaifa = (PaifaResponse) response;
            if("00000".equals(mPaifa.getErrorCode())){
                /**完成派发,刷新界面*/
                dialog.dismiss();
                /**刷新适配器*/
                lists.clear();
                flag=false;
                HashMap<String, Object> params = new HashMap<>();
                params.put("page", 1);
                HttpLoader.get(ConstantsYunZhiShui.URL_GDLB, params,WorkDanList.class,
                        ConstantsYunZhiShui.REQUEST_CODE_GDLB,this,false).setTag(this);
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
    public void showPwdAlertDialog(final int i) {
        View view = View.inflate(this, R.layout.dialog_paw, null);
        Button but_pwd_ok = (Button) view.findViewById(R.id.but_pwd_ok);
        Button but_pwd_cancel = (Button) view.findViewById(R.id.but_pwd_cancel);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);
        but_pwd_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            /**掉用删除接口*/
                String id= lists.get(i).getMaintainId();
                lists.remove(i);
                HashMap<String, Object> params = new HashMap<>();
                params.put("id", id);
                HttpLoader.get(ConstantsYunZhiShui.URL_GDDELETE, params, DeleteResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_GDDELETE,WorkDanDistributeActivity.this, false).setTag(this);
            }
        });
        but_pwd_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }
    public class WorkDanAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return lists.size();
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
                holder=new ViewHolder();
                convertView=View.inflate(WorkDanDistributeActivity.this, R.layout.item_distribute,null);
                holder.tv_shebei_name= (TextView) convertView.findViewById(R.id.tv_shebei_name);
                holder.but_paifa= (Button) convertView.findViewById(R.id.but_paifa);
                holder.but_write= (ImageButton) convertView.findViewById(R.id.but_write);
                holder.tv_weixiu_month= (TextView) convertView.findViewById(R.id.tv_weixiu_month);
                holder.tv_workdan_name= (TextView) convertView.findViewById(R.id.tv_workdan_name);
                holder.tv_jihua_starttime= (TextView) convertView.findViewById(R.id.tv_jihua_starttime);
                holder.tv_jihua_endtime= (TextView) convertView.findViewById(R.id.tv_jihua_endtime);
                holder.tv_shishi_danwei= (TextView) convertView.findViewById(R.id.tv_shishi_danwei);
                holder.button_weixiu_state= (TextView) convertView.findViewById(R.id.button_weixiu_state);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_shebei_name.setText(lists.get(position).getMaintainName());
            holder.tv_weixiu_month.setText(lists.get(position).getMaintainMonth());
            holder.tv_workdan_name.setText("工单负责人:" + lists.get(position).getMaintainCharge());
            String s= lists.get(position).getMaintainSdate();
            String s1 = lists.get(position).getMaintainEdate();
            if(s!=null&&!"".equals(s)&&!"null".equals(s)){
                   s=s.substring(0,10);
             }
            if(s1!=null&&!"".equals(s1)&&!"null".equals(s1)){
                   s1=s1.substring(0,10);
            }
            holder.tv_jihua_starttime.setText("计划开始时间:"+s);
            holder.tv_jihua_endtime.setText("计划结束时间:" +s1);
            holder.tv_shishi_danwei.setText("实施单位:" + lists.get(position).getMaintainImpDept());
            String ss= lists.get(position).getMaintainStatus();
            if("1".equals(ss)){
                /**未派发*/
                holder.button_weixiu_state.setTextColor(Color.RED);
                holder.button_weixiu_state.setText("未派发");
                holder.but_paifa.setVisibility(View.VISIBLE);
                holder.but_write.setVisibility(View.VISIBLE);
            }else if("2".equals(ss)){
                /**派发*/
                holder.button_weixiu_state.setTextColor(Color.BLUE);
                holder.button_weixiu_state.setText("派发");
                holder.but_paifa.setVisibility(View.GONE);
                holder.but_write.setVisibility(View.GONE);
            }else if("3".equals(ss)){
                /**部分完成*/
                holder.button_weixiu_state.setTextColor(Color.parseColor("#77b92b"));
                holder.button_weixiu_state.setText("部分完成");
                holder.but_paifa.setVisibility(View.GONE);
                holder.but_write.setVisibility(View.GONE);
            }else if("4".equals(ss)){
                /**未完成*/
                holder.button_weixiu_state.setTextColor(Color.parseColor("#77b92b"));
                holder.button_weixiu_state.setText("完成");
                holder.but_paifa.setVisibility(View.GONE);
                holder.but_write.setVisibility(View.GONE);
            }
            holder.but_paifa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**点击弹出对话框,是否派发*/
                    showPwdAlertDialog2(position);
                }
            });
            holder.but_write.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**跳到工单修改页*/
                    String workdanId = lists.get(position).getMaintainId();
                    norm.setTianId(workdanId);
                    EventBus.getDefault().postSticky(norm);
                    Intent intent=new Intent(WorkDanDistributeActivity.this, WorkDanUpdateActivity.class);
                    startActivity(intent);
                }
            });
            return convertView;
        }

        class ViewHolder{
            TextView tv_shebei_name,tv_weixiu_month,
                    tv_workdan_name,tv_jihua_starttime,
                    tv_jihua_endtime,tv_shishi_danwei;
            TextView button_weixiu_state;
            ImageButton but_write;
            Button but_paifa;
        }
        public void showPwdAlertDialog2(final int i) {
            View view = View.inflate(WorkDanDistributeActivity.this, R.layout.dialog_paifa, null);
            Button but_pwd_ok = (Button) view.findViewById(R.id.but_pwd_ok);
            Button but_pwd_cancel = (Button) view.findViewById(R.id.but_pwd_cancel);
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkDanDistributeActivity.this);
            builder.setView(view);
            builder.setCancelable(false);
            but_pwd_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**掉用派发接口*/
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("id", lists.get(i).getMaintainId());
                    HttpLoader.get(ConstantsYunZhiShui.URL_GDPF, params, PaifaResponse.class,
                            ConstantsYunZhiShui.REQUEST_CODE_GDPF,WorkDanDistributeActivity.this, false).setTag(this);
                }
            });
            but_pwd_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog = builder.create();
            dialog.show();
        }
    }
   public void show(int page){
       /**搜索按钮*/
       HashMap<String, Object> params = new HashMap<>();
       if(workdan_month!=null&&ed_home!=null) {
           String maintainMonth = workdan_month.getText().toString();
           String maintainName = ed_home.getText().toString();
           if (!"".equals(maintainMonth) && maintainMonth != null &&! "null".equals(maintainMonth)) {
               params.put("maintainMonth", maintainMonth);
           }
           if (!"".equals(maintainName) && maintainName != null &&! "null".equals(maintainName)) {
               params.put("maintainName", maintainName);
           }
       }
       params.put("page", page);
       HttpLoader.get(ConstantsYunZhiShui.URL_GDLB, params,WorkDanList.class,
               ConstantsYunZhiShui.REQUEST_CODE_GDLB,this,false).setTag(this);
   }
}
