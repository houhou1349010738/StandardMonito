package com.smartwasser.yunzhishui.utils;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.smartwasser.yunzhishui.R;

/**
 * Created by huangmengjie on 2016/6/14 0014.
 */
public class PopupWindowTwoUtil {
    private  PopupWindow pw;
    public  void showPopupWindow(ListView view,View view2,int x,int m,int n){
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view,x, 800);
        // 设置可以使用焦点
        pw.setFocusable(true);
        ColorDrawable dw3 = new ColorDrawable(0xb0000000);
        pw.setBackgroundDrawable(dw3);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(new BitmapDrawable());
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(view2,m,n);
    }
    public void closePopupWindow(){
        if(pw!=null){
           pw.dismiss();
        }
    }
    public  void showPopupWindow2(View view,View view2,int x,int y){
        // 弹出一个PopupWindow的窗体, 把ListView作为其内容部分显示.
        pw = new PopupWindow(view,x,y);
        /**键盘弹出时,不会挡住pop*/
        pw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);

        // 设置可以使用焦点
        pw.setFocusable(true);
        // 设置popupwindow点击外部可以被关闭
        pw.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable();
        // 设置一个popupWindow的背景
        pw.setBackgroundDrawable(dw);
        // 把popupwindow显示出来, 显示的位置是: 在输入框的下面, 和输入框是连着的.
        pw.showAsDropDown(view2, 2, -5);
    }
}
