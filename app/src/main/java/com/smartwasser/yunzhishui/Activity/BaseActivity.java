package com.smartwasser.yunzhishui.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import java.util.logging.LogRecord;

public abstract class BaseActivity extends AppCompatActivity{
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题
       // getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //设置窗口背景不透明
        getWindow().setBackgroundDrawable(null);
        //有EditView的界面，默认不弹窗软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在加载数据....");
        setContentView(initContentView());
        initView();
        initData();
        initListener();
    }
    /**
     * 显示加载数据的dialog
     */
   public void showProgressDialog() {
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                  mProgressDialog.show();
        }
    }
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
        }
    }
    /**
     * 返回界面的布局
     * @return layout id
     */
    protected abstract int initContentView();
    /**
     * 初始化控件，findViewById()
     */
    protected abstract void initView();
    /**
     * 给控件设置监听器，初始化监听器
     */
    protected abstract void initListener();

    /**
     * 初始化数据（网络加载、本地加载数据等操作）
     */
    protected abstract void initData();
}
