package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
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
import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.BusinessResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/21 0021.
 */
public class BusinesssuBjectsActivity extends BaseActivity implements HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private ListView list_business;
    private TextView tv_toolbar;
    private ImageButton button_menu,norm_ser;
    private EventNormSelect event;
    private  BusinessResponse mBusiness;
    private MyAdapter myAdapter;
    private int page=1;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private View loadMoreView;
    private Toolbar toolbar;
    private Toolbar toolbar2;
    private Button image_quxiao;
    private ImageButton but_sousuo;
    private EditText ed_home;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return R.layout.activity_businessubjects;
    }
    @Override
    protected void initView() {
        list_business= (ListView) findViewById(R.id.list_business);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        norm_ser.setVisibility(View.VISIBLE);
        ed_home= (EditText) findViewById(R.id.ed_home);
        image_quxiao= (Button)findViewById(R.id.image_quxiao);
        loadMoreView=View.inflate(this, R.layout.load_more, null);
        loadMoreButton = (ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        list_business.addFooterView(loadMoreView);
        toolbar= (Toolbar) findViewById(R.id.toolbars);

        toolbar2= (Toolbar) findViewById(R.id.toolbar);
        but_sousuo= (ImageButton) findViewById(R.id.but_sousuo);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        list_business.setOnScrollListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("业务科目");
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        norm_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.INVISIBLE);
                image_quxiao.setVisibility(View.VISIBLE);
            }
        });
        image_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setVisibility(View.INVISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                image_quxiao.setVisibility(View.GONE);
            }
        });
        but_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   /**查询接口*/
                HashMap<String, Object> prams = new HashMap<>();
                prams.put("busiType",event.getBusiType());
                prams.put("claimDep", event.getClaimDep());
                prams.put("datadate", event.getDatadate());
                String s=ed_home.getText().toString();
                if(!"".equals(s)||!"null".equals(s)||s!=null){
                    prams.put("indeName",s);
                }
                prams.put("page", page);
                HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTOINDE, prams,
                        BusinessResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE,BusinesssuBjectsActivity.this, false).setTag(this);
            }
        });
           /**调用校验接口*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("busiType",event.getBusiType());
        prams.put("claimDep", event.getClaimDep());
        prams.put("datadate", event.getDatadate());
        prams.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTOINDE, prams,
                BusinessResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE, this, false).setTag(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        list_business.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE
                && response instanceof BusinessResponse) {
               mBusiness=(BusinessResponse)response;
              if("00000".equals(mBusiness.getErrorCode())){
                  myAdapter=new MyAdapter();
                  list_business.setAdapter(myAdapter);
                  list_business.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                      @Override
                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                 /**将数据带回那边*/
                              Intent intent=new Intent(BusinesssuBjectsActivity.this,AddReimburseActivity.class);
                              startActivity(intent);
                      }
                  });
              }
           }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }

    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return   mBusiness.getData().getCostIndeMaster().getRows().size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(BusinesssuBjectsActivity.this,R.layout.item_business,null);
                holder=new ViewHolder();
                holder.tv_business_ywkm= (TextView) convertView.findViewById(R.id.tv_business_ywkm);
                holder.tv_business_ywlx=(TextView) convertView.findViewById(R.id.tv_business_ywlx);
                holder.tv_business_dyjhz=(TextView) convertView.findViewById(R.id.tv_business_dyjhz);
                holder.tv_business_dyjhsyz=(TextView) convertView.findViewById(R.id.tv_business_dyjhsyz);
                convertView.setTag( holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_business_ywkm.setText("业务科目:"+"  "+mBusiness.getData().getCostIndeMaster().getRows().get(position).getIndeName());
            holder.tv_business_ywlx.setText("业务类型:"+"  "+mBusiness.getData().getCostIndeMaster().getRows().get(position).getCostType());
            holder.tv_business_dyjhz.setText("当月计划值:￥" + mBusiness.getData().getCostIndeMaster().getRows().get(position).getMaxValue());
            holder.tv_business_dyjhsyz.setText("当月计划剩余值:￥"+mBusiness.getData().getCostIndeMaster().getRows().get(position).getMinValue());
            return convertView;
        }
        class ViewHolder{
            TextView tv_business_ywkm,tv_business_ywlx,
                    tv_business_dyjhz,tv_business_dyjhsyz;
        }
    }
    public void onEvent(EventNormSelect  esc){
             event=esc;
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int  itemsLastIndex = myAdapter.getCount()-1;//数据集最后一项的索引
        int  lastIndex =itemsLastIndex + 1;        //加上底部的loadMoreView项
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex) {
            //如果是自动加载,可以在这里放置异步加载数据的代码
            Log.i("LOADMORE", "loading...");
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }
    private void  loadData(){
        ++page;
        /**查询接口*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("busiType",event.getBusiType());
        prams.put("claimDep", event.getClaimDep());
        prams.put("datadate", event.getDatadate());
        String s=ed_home.getText().toString();
        if(!"".equals(s)||!"null".equals(s)||s!=null){
            prams.put("indeName",s);
        }
        prams.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERADDTOINDE, prams,
                BusinessResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERADDTOINDE,BusinesssuBjectsActivity.this, false).setTag(this);
    }
}
