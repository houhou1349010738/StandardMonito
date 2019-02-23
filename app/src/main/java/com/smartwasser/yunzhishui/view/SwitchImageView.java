package com.smartwasser.yunzhishui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.smartwasser.yunzhishui.R;
/**
 * Created by huangmengjie on 2016/5/10 0010.
 */
public class SwitchImageView extends ImageButton{
    /**这是一个开关自定义控件,所以要有开关的状态*/
    private boolean switchstatus=true;
    public boolean getSwitchstatus() {
        return switchstatus;
    }
    public void setSwitchstatus(boolean switchstatus) {
        this.switchstatus = switchstatus;
        if(switchstatus){
            setBackgroundResource(R.drawable.on);
        }else{
            setBackgroundResource(R.drawable.off);
        }
    }
    public void changeSwitchstatus(){
        setSwitchstatus(!switchstatus);
    }
    public SwitchImageView(Context context) {
        super(context);
    }

    public SwitchImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwitchImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
    }
}
