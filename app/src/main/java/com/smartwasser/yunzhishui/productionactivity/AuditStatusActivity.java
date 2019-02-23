package com.smartwasser.yunzhishui.productionactivity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.AuditStatusAdapter;
import com.smartwasser.yunzhishui.bean.AduitStateResponse;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.ReimbursementResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/20 0020.
 */
public class AuditStatusActivity extends BaseActivity implements HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private TextView tv_toolbar,tv_count;
    private ImageButton button_menu,norm_ser;
    private ListView list_audit_state;
    private EventSearchResponse even;
    private int page=1;
    private   AduitStateResponse mAduitState;
    private AuditStatusAdapter mAduitStateAdapter;

    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private View loadMoreView;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected int initContentView() {
        return R.layout.activity_auditstatus;
    }

    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu.setBackgroundResource(R.drawable.fanhu);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        norm_ser.setVisibility(View.GONE);
        tv_count= (TextView)findViewById(R.id.tv_count);
        list_audit_state= (ListView) findViewById(R.id.list_audit_state);
        loadMoreView=View.inflate(this, R.layout.load_more, null);
        loadMoreButton = (ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        list_audit_state.addFooterView(loadMoreView);
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void initListener() {
        list_audit_state.setOnScrollListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("审核状态");
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 finish();
            }
        });
        /**请求网络*/
        HashMap<String, Object> prams2 = new HashMap<>();
        prams2.put("claimId",even.getClaimId());
        prams2.put("page",page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERREVIEW, prams2,
                AduitStateResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERREVIEW, this, false).setTag(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        list_audit_state.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERREVIEW
                && response instanceof AduitStateResponse) {
              mAduitState=(AduitStateResponse )response;
            if("00000".equals(mAduitState.getErrorCode())){
                   /**设置适配器*/
                tv_count.setText(mAduitState.getData().getPayOperationProcess().getRows().size()+"");
                mAduitStateAdapter=new AuditStatusAdapter(this,mAduitState);
                list_audit_state.setAdapter(mAduitStateAdapter);

            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventSearchResponse esc){
        even=esc;
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int  itemsLastIndex =mAduitStateAdapter.getCount()-1;//数据集最后一项的索引
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
        /**请求网络*/
        HashMap<String, Object> prams2 = new HashMap<>();
        prams2.put("claimId",even.getClaimId());
        prams2.put("page",page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERREVIEW, prams2,
                AduitStateResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERREVIEW, this, false).setTag(this);
    }
}
