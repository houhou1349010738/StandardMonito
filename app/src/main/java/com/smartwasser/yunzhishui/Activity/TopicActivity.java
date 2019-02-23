package com.smartwasser.yunzhishui.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.App;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.TopicAdapter;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.TopicResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsRedBaby;
import org.seny.android.utils.MyToast;
import java.util.HashMap;
/**
 * Created by xiongmc on 2015/12/23.
 */
public class TopicActivity extends BaseActivity implements HttpLoader.ResponseListener {
    private ListView mListView;
    private TopicAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected int initContentView() {
        return R.layout.activity_datamain;
    }
    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.list_home);
    }
    @Override
    protected void initListener() {
    }
    @Override
    protected void initData() {
        showProgressDialog();
        //准备请求参数
        HashMap<String,Object> params = new HashMap<>();
        params.put("page", "1");
        params.put("pageNum", "8");

        //发起请求，并设置一个Tag，(设置Tag后可以根据该Tag取消该次请求,比如当退出当前Activity时(见onStop()))
        HttpLoader.get(ConstantsRedBaby.URL_TOPIC, params, TopicResponse.class,
                ConstantsRedBaby.REQUEST_CODE_TOPIC, this).setTag(this);
        showProgressDialog();
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        //根据请求码判断响应结果是否是对应的请求，响应结果是否是期望的bean对象
        if (requestCode == ConstantsRedBaby.REQUEST_CODE_TOPIC
                && response instanceof TopicResponse) {
            TopicResponse topicResponse = (TopicResponse) response;
            if (mAdapter == null) {
                mAdapter = new TopicAdapter(this, topicResponse);
                mListView.setAdapter(mAdapter);
            } else {
                mAdapter.setTopic(topicResponse);
                mAdapter.notifyDataSetChanged();
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
    protected void onStop() {
        super.onStop();
        //当退出当前页面的时候，根据业务需求决定是否需要取消本次请求
        HttpLoader.cancelRequest(this);
        dismissProgressDialog();
    }
}
