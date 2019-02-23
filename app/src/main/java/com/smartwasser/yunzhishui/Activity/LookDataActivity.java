package com.smartwasser.yunzhishui.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.DetailsAdapter;
import com.smartwasser.yunzhishui.bean.EventLookData;
import com.smartwasser.yunzhishui.bean.LookDataResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import org.seny.android.utils.MyToast;
import java.util.HashMap;
import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/5/8 0008.
 */
public class LookDataActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
    private Toolbar toolbar;
    private DetailsAdapter mAdapter;
    private ListView look_list;
    private TextView ed_looktime;
    private TextView ed_lookdanwei;
    private EventLookData mlookdata;
    @Override
    protected int initContentView() {
        return R.layout.activity_lookdata;
    }
    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        look_list= (ListView) findViewById(R.id.look_list);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        ed_looktime= (TextView) findViewById(R.id.ed_looktime);
        ed_lookdanwei= (TextView) findViewById(R.id.ed_lookdanwei);
        button_menu.setVisibility(View.GONE);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        showProgressDialog();
        tv_toolbar.setText("数据上报(查看)");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**发起网络请求*/
        HashMap<String,Object> map=new HashMap<>();
        map.put("flowCode",mlookdata.getWork_flowCode());
        map.put("assuUnit", mlookdata.getAddName());
        map.put("dataDate", mlookdata.getAddTime());
       // Log.i(TAG,mlookdata.getAddName() + "----------" +mlookdata.getAddTime());
        HttpLoader.get(ConstantsYunZhiShui.URL_LOOKDATA, map, LookDataResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_LOOKDATA, this).setTag(this);
        showProgressDialog();
        ed_looktime.setText(mlookdata.getAddTime());
        ed_lookdanwei.setText(mlookdata.getName());
        toolbar.setNavigationIcon(R.drawable.fanhui);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_LOOKDATA
                && response instanceof LookDataResponse) {
            LookDataResponse mLookResponse = (LookDataResponse) response;
            if("00000".equals(mLookResponse.getErrorCode())) {
                if (mAdapter == null) {
                    mAdapter = new DetailsAdapter(this, mLookResponse);
                    look_list.setAdapter(mAdapter);
                } else {
                    mAdapter.SetLookData(mLookResponse);
                    mAdapter.notifyDataSetChanged();
                }
            }
        }
        dismissProgressDialog();
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
        dismissProgressDialog();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    public void onEvent(EventLookData lookdata){
        mlookdata=lookdata;
    }

    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
        dismissProgressDialog();
    }
}
