package com.smartwasser.yunzhishui.sludgeactivity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.TransportDaitilRespose;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/14 0014.
 */
public class TrasportadetailsActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private ImageButton but_menu;
    private TextView tv_toolbar;
    private EventNormSelect mNorm;
    private  TransportDaitilRespose mDetails;
    private EventSearchResponse eventsa=new EventSearchResponse();
    private TextView tv_xiangqing_cph,tv_xiangqing_state,tv_xiangqing_czd
            ,tv_xiangqing_chuzd,tv_xiangqing_wnzl,tv_xiangqing_yj,tv_xiangqing_qdzb
            ,tv_xiangqing_zdzb,tv_xiangqing_pzsj,tv_xiangqing_mzsj,tv_xiangqing_startTime
            ,tv_xiangqing_endTime,tv_xiangqing_xzyj,tv_xiangqing_xzsm,tv_xiangqing_xzr
            ,tv_xiangqing_xzsj;
    private Button but_xiangqing_cklsjl;
    @Override
    protected int initContentView() {
        return R.layout.activity_transporta_xianqing;
    }
    @Override
    protected void initView() {
        but_menu= (ImageButton) findViewById(R.id.button_menu);
        but_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        tv_xiangqing_cph= (TextView) findViewById(R.id.tv_xiangqing_cph);
        tv_xiangqing_state= (TextView) findViewById(R.id.tv_xiangqing_state);
        tv_xiangqing_czd= (TextView) findViewById(R.id.tv_xiangqing_czd);
        tv_xiangqing_chuzd= (TextView) findViewById(R.id.tv_xiangqing_chuzd);
        tv_xiangqing_wnzl= (TextView) findViewById(R.id.tv_xiangqing_wnzl);
        tv_xiangqing_yj= (TextView) findViewById(R.id.tv_xiangqing_yj);
        tv_xiangqing_qdzb= (TextView) findViewById(R.id.tv_xiangqing_qdzb);
        tv_xiangqing_zdzb= (TextView) findViewById(R.id.tv_xiangqing_zdzb);
        tv_xiangqing_pzsj= (TextView) findViewById(R.id.tv_xiangqing_pzsj);
        tv_xiangqing_mzsj= (TextView) findViewById(R.id.tv_xiangqing_mzsj);
        tv_xiangqing_startTime= (TextView) findViewById(R.id.tv_xiangqing_startTime);
        tv_xiangqing_endTime= (TextView) findViewById(R.id.tv_xiangqing_endTime);
        tv_xiangqing_xzyj= (TextView) findViewById(R.id.tv_xiangqing_xzyj);
        tv_xiangqing_xzsm= (TextView) findViewById(R.id.tv_xiangqing_xzsm);
        tv_xiangqing_xzr= (TextView) findViewById(R.id.tv_xiangqing_xzr);
        tv_xiangqing_xzsj= (TextView) findViewById(R.id.tv_xiangqing_xzsj);
        but_xiangqing_cklsjl= (Button) findViewById(R.id.but_xiangqing_cklsjl);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        tv_toolbar.setText("运输任务管理");
        but_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", mNorm.getTransportaId());
        HttpLoader.get(ConstantsYunZhiShui.URL_TRANPORTVIEW, params, TransportDaitilRespose.class,
                ConstantsYunZhiShui.REQUEST_CODE_TRANPORTVIEW, this, false).setTag(this);
        but_xiangqing_cklsjl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  /**跳到历史轨迹查询页*/
                String s=tv_xiangqing_state.getText().toString();
                if("".equals(s)||"null".equals(s)||s==null){
                        return;
                }
                eventsa.setGuijiId(mDetails.getData().getTask().getTransportTaskId());
                EventBus.getDefault().postSticky(eventsa);
                Intent intent=new Intent(TrasportadetailsActivity.this,HistoricalTrackActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onEvent(EventNormSelect masl){
              mNorm=masl;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TRANPORTVIEW
                && response instanceof TransportDaitilRespose) {
                mDetails=(TransportDaitilRespose)response;
            if("00000".equals(  mDetails.getErrorCode())){
                tv_xiangqing_cph.setText("     " + mDetails.getData().getTask().getVehicleNo());
                String state=mDetails.getData().getTask().getStatusName();
                if("正常".equals(state)){
                    tv_xiangqing_state.setTextColor(Color.parseColor("#4cd964"));
                }else if("完成".equals(state)){
                    tv_xiangqing_state.setTextColor(Color.parseColor("#12b7f5"));
                }else if("无定位信号".equals(state)){
                    tv_xiangqing_state.setTextColor(Color.parseColor("#fc3b3c"));
                }else if("异常结束".equals(state)||"无终点".equals(state)){
                    tv_xiangqing_state.setTextColor(Color.parseColor("#ff9800"));
                }else{
                    tv_xiangqing_state.setTextColor(Color.parseColor("#0000ff"));
                }
                tv_xiangqing_state.setText(state);
                tv_xiangqing_czd.setText("称重点:"+"      "+mDetails.getData().getTask().getBusiUnitName());
                tv_xiangqing_chuzd.setText("处置点:"+"     "+mDetails.getData().getTask().getMudName());
                tv_xiangqing_wnzl.setText("污泥种类:"+"     "+mDetails.getData().getTask().getWnKind());
                tv_xiangqing_yj.setText("运距:"+"    "+mDetails.getData().getTask().getDistance());
                tv_xiangqing_qdzb.setText("起点坐标:"+"     "+mDetails.getData().getTask().getStartPositionLng()+":"+mDetails.getData().getTask().getStartPositionLat());
                tv_xiangqing_zdzb.setText("终点坐标:"+"     "+mDetails.getData().getTask().getEndPositionLng()+":"+mDetails.getData().getTask().getEndPositionLat());
                tv_xiangqing_pzsj.setText("皮重时间:"+"     "+mDetails.getData().getTask().getTareWeightTime());
                tv_xiangqing_mzsj.setText("毛重时间:"+"     "+mDetails.getData().getTask().getGrossWeightTime());
                tv_xiangqing_startTime.setText("任务开始时间:"+"    "+mDetails.getData().getTask().getStartTime());
                tv_xiangqing_endTime.setText("任务结束时间:"+"     "+mDetails.getData().getTask().getEndTime());
                if(mDetails.getData().getTask().getStat()==null){
                    tv_xiangqing_xzyj.setText("修正运距:"+"    "+"未审核");
                    tv_xiangqing_xzsm.setText("修正说明:"+"     "+"未审核");
                    tv_xiangqing_xzr.setText("修正人:"+"     "+"未审核");
                    tv_xiangqing_xzsj.setText("修正时间:"+"     "+"未审核");
                }
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
}
