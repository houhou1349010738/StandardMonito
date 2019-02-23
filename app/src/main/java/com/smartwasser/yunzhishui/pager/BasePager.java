package com.smartwasser.yunzhishui.pager;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
/**
 * Created by huangmengjie on 2016/home/28 0028.
 */
public abstract class BasePager{
    public View view;
    private ProgressDialog mProgressDialog;
    public Context context;
    public BasePager(Context context){
        this.context=context;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage("正在加载数据....");
    }
       /**获取View的方法*/
    public View getRotorView(){
        view=initViews();
        return view;
    }
    public abstract View initViews();
    public abstract void initDatas() throws IllegalAccessException;
    /**
     * 显示加载数据的dialog
     */
    protected void showProgressDialog() {
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }
    protected void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
