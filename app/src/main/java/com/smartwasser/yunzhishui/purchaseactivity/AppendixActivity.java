package com.smartwasser.yunzhishui.purchaseactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/8/6 0006.
 */
public class AppendixActivity extends AppCompatActivity{
    private WebView webview;
    private EventNormSelect event;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_append);
        /**注册一个EventBus*/
        EventBus.getDefault().registerSticky(this);
        initView();
    }
    private void initData() {
        //Log.i("999999999999",ConstantsYunZhiShui.URL_SERVERssssssss+event.getUrl() );
       // ,
        webview.loadUrl(ConstantsYunZhiShui.URL_SERVERssssssss + event.getUrl());
        Log.i("000000",event.getUrl());
     /*webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });*/
    }
    private void initView() {
        webview= (WebView) findViewById(R.id.webview);
        initData();
    }
    public void onEvent(EventNormSelect event){
        this.event=event;
    }
}
