package com.smartwasser.yunzhishui.rmonactivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.BuildingResponse;
import com.smartwasser.yunzhishui.bean.BusinessUnitResponse;
import com.smartwasser.yunzhishui.bean.QuotaResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.RundataResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;
import com.smartwasser.yunzhishui.utils.TimeUtils;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.SupportBarChart;

import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.support.SupportBarSeriesRender;
import org.achartengine.renderer.support.SupportSelectedChartType;
import org.achartengine.renderer.support.SupportXAlign;
import org.achartengine.renderer.support.SupportYAlign;
import org.seny.android.utils.MyToast;

import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/8/1 0001.
 */
public class RunDataReslutZtActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_fan,image_add,image_serc;
    private TextView tv_toolbar_zhu,tv_toolbar_centext;


    private ImageButton xiala;
    private RelativeLayout relat;
    private int i=1;
    private ImageButton image_zzt,image_zxt,image_xj;
    private RelativeLayout relayout;
    private RundataResponse mRundata;
    private XYMultipleSeriesDataset mXYMultipleSeriesDataSet;
    protected XYMultipleSeriesRenderer  mXYRenderer=new XYMultipleSeriesRenderer();;


    private EditText ed_rmon_dw,ed_rmon_gzw,ed_rmon_zb
            ,ed_muchtrend_strattime,ed_muchtrend_endtime
            ,ed_kuaijie_muchtime,ed_xiaoshi,ed_shunshi;
    private ImageButton image_rmon_dw,image_rmon_gzw,
            image_rmon_zb, but_muchtrend_strattime
            ,but_end_time,image_kuaijie,image_xiaoshi
            ,image_shunshi;
    private ListView minitListView2,minitListView3,minitListView4,
            minitListView5,minitListView6,minitListView7;

    private TimeUtils time=new TimeUtils();
    private BusinessUnitResponse mBusinessUnit;
    private MyBusinesAdapter myBusinesAdapter;
    private String code="";
    private BuildingResponse mBuilding;
    private  MyBuildingAdapter myBuildingAdapter;
    private String buildCode="";
    private QuotaResponse mQuota;
    private MyQuotaAdapter myQuotaAdapter;
    private String indeCode="";
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private PopListViewUtils plu=new PopListViewUtils(this);


    @Override
    protected int initContentView() {
        return R.layout.activity_run_data;
    }
    @Override
    protected void initView() {
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        button_fan.setBackgroundResource(R.drawable.fanhu);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_add.setVisibility(View.GONE);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        xiala= (ImageButton) findViewById(R.id.xiala);
        relat= (RelativeLayout) findViewById(R.id.relat_shi);
        image_zzt= (ImageButton) findViewById(R.id.image_zzt);
        image_zxt= (ImageButton) findViewById(R.id.image_zxt);
        image_xj= (ImageButton) findViewById(R.id.image_sj);
        relayout= (RelativeLayout) findViewById(R.id.relayout);


        ed_rmon_dw= (EditText) findViewById(R.id.ed_rmon_dw);
        ed_rmon_gzw= (EditText) findViewById(R.id.ed_rmon_gzw);
        ed_rmon_zb= (EditText) findViewById(R.id.ed_rmon_zb);
        ed_muchtrend_strattime= (EditText) findViewById(R.id.ed_muchtrend_strattime);
        ed_muchtrend_endtime= (EditText) findViewById(R.id.ed_muchtrend_endtime);
        ed_kuaijie_muchtime= (EditText) findViewById(R.id.ed_kuaijie_muchtime);
        image_rmon_dw= (ImageButton) findViewById(R.id.image_rmon_dw);
        image_rmon_gzw= (ImageButton) findViewById(R.id.image_rmon_gzw);
        image_rmon_zb= (ImageButton) findViewById(R.id.image_rmon_zb);
        but_muchtrend_strattime= (ImageButton) findViewById(R.id. but_muchtrend_strattime);
        but_end_time= (ImageButton) findViewById(R.id.but_end_time);
        image_kuaijie= (ImageButton) findViewById(R.id.image_kuaijie);
        ed_xiaoshi= (EditText) findViewById(R.id.ed_xiaoshi);
        ed_shunshi= (EditText) findViewById(R.id. ed_shunshi);
        image_xiaoshi= (ImageButton) findViewById(R.id.image_xiaoshi);
        image_shunshi= (ImageButton) findViewById(R.id.image_shunshi);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        image_xj.setOnClickListener(this);
        image_zxt.setOnClickListener(this);
        ed_rmon_dw.setOnClickListener(this);
        ed_rmon_gzw.setOnClickListener(this);
        ed_rmon_zb.setOnClickListener(this);
        ed_muchtrend_strattime.setOnClickListener(this);
        ed_muchtrend_endtime.setOnClickListener(this);
        ed_kuaijie_muchtime.setOnClickListener(this);
        ed_xiaoshi.setOnClickListener(this);
        ed_shunshi.setOnClickListener(this);
        image_serc.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar_zhu.setText("远程监控");
        xiala.setOnClickListener(this);
        tv_toolbar_centext.setText("运行数据查询");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**刷新界面*/
       /* View view= ChartFactory.getBarChartView(this, initBarChartView(),initRender(),);
        relayout.addView(view);*/
        initRender();
        relayout.addView(initBarChartView());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiala:
                if (i % 2 == 0) {
                    relat.setVisibility(View.GONE);
                } else {
                    relat.setVisibility(View.VISIBLE);
                }
                ++i;
                break;
            case R.id.image_zxt:
                /**跳到折线图界面*/
                EventBus.getDefault().postSticky(mRundata);
                Intent intent2=new Intent(RunDataReslutZtActivity.this,RunDataReslutActivity.class);
                startActivity(intent2);
                break;
            case R.id.image_sj:
                /**跳到数据页面*/
                EventBus.getDefault().postSticky(mRundata);
                Intent intent=new Intent(RunDataReslutZtActivity.this,RunDataTwoActivity.class);
                startActivity(intent);
                break;
            case R.id. ed_rmon_dw:
                /**单位*/
                minitListView5 = initListView5();
                PopupWindowUtils.showPopupWindow(minitListView5, ed_rmon_dw);
                break;
            case R.id.ed_xiaoshi:
                minitListView3= plu.initListView8();
                PopupWindowUtils.showPopupWindow(minitListView3, ed_xiaoshi);
                minitListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_xiaoshi.setText(plu.mListView8.get(position));
                        if("精细查询".equals( ed_xiaoshi.getText().toString())){
                            image_shunshi.setVisibility(View.GONE);
                            ed_shunshi.setVisibility(View.GONE);
                        }else{
                            image_shunshi.setVisibility(View.VISIBLE);
                            ed_shunshi.setVisibility(View.VISIBLE);
                        }
                        PopupWindowUtils.closePopupWindow();
                    }
                });
                break;
            case R.id.ed_shunshi:
                minitListView4= plu.initListView9();
                PopupWindowUtils.showPopupWindow(minitListView4, ed_shunshi);
                minitListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_shunshi.setText(plu.mListView9.get(position));
                        PopupWindowUtils.closePopupWindow();
                    }
                });
                break;
            case R.id.ed_rmon_gzw:
                /**构筑物*/
                String s = ed_rmon_dw.getText().toString();
                if ("".equals(s) || "null".equals(s) || s == null) {
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择单位", Toast.LENGTH_SHORT).show();
                    return;
                }
                minitListView6 = initListView6();
                PopupWindowUtils.showPopupWindow4(minitListView6, ed_rmon_gzw);
                break;
            case R.id.ed_rmon_zb:
                /**指标*/
                String s2 = ed_rmon_dw.getText().toString();
                if ("".equals(s2) || "null".equals(s2) || s2 == null) {
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择单位", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s3 = ed_rmon_gzw.getText().toString();
                if ("".equals(s3) || "null".equals(s3) || s3 == null) {
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择构筑物", Toast.LENGTH_SHORT).show();
                    return;
                }
                minitListView7 = initListView7();
                PopupWindowUtils.showPopupWindow4(minitListView7, ed_rmon_zb);
                break;
            case R.id.ed_muchtrend_strattime:
                /**开始时间*/
                dialog.show(ed_muchtrend_strattime);
                dialog.showTime();
                break;
            case R.id.ed_muchtrend_endtime:
                /**结束时间*/
                dialog.show(ed_muchtrend_endtime);
                dialog.showTime();
                break;
            case R.id.ed_kuaijie_muchtime:
                /**快捷时间*/
                // 初始化ListView控件和里边的数据
                minitListView2 = plu.initListView();
                PopupWindowUtils.showPopupWindow(minitListView2, ed_kuaijie_muchtime);
                minitListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<String> list = time.showTimeShortcut();
                        if (position >= 1) {
                            ed_muchtrend_strattime.setText(list.get(position * 2 - 2));
                            ed_muchtrend_endtime.setText(list.get(position * 2 - 1));
                            ed_kuaijie_muchtime.setText(plu.mListView.get(position));
                        }
                        /**关闭popupwindow*/
                        PopupWindowUtils.closePopupWindow();
                    }
                });
                break;
            case R.id.image_serc:
                /**发起网络请求*/
                HashMap<String, Object> prams = new HashMap<>();
                String dw=ed_rmon_dw.getText().toString();
                if("".equals(dw)||dw==null||"null".equals(dw)){
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择单位", Toast.LENGTH_SHORT).show();
                    return;
                }
                String gzw=ed_rmon_gzw.getText().toString();
                if("".equals(gzw)||gzw==null||"null".equals(gzw)){
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择构筑物", Toast.LENGTH_SHORT).show();
                    return;
                }
                String sb=ed_rmon_zb.getText().toString();
                if("".equals(sb)||sb==null||"null".equals(sb)){
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                String start=ed_muchtrend_strattime.getText().toString();
                String end=ed_muchtrend_endtime.getText().toString();
                if("".equals(start)||start==null||"null".equals(start)){
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择开始时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(end)||end==null||"null".equals(end)){
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择结束时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                String xiao=ed_xiaoshi.getText().toString();
                if("".equals(xiao)||xiao==null||"null".equals(xiao)){
                    Toast.makeText(RunDataReslutZtActivity.this, "请选择查询模式", Toast.LENGTH_SHORT).show();
                    return;
                }
                String shun=ed_shunshi.getText().toString();
                if(!xiao.equals("精细查询")){
                    if(shun.equals("瞬时值")){
                        prams.put("indeName","INS");
                    }else if(shun.equals("峰值")){
                        prams.put("indeName","MAX");
                    }else if(shun.equals("谷值")){
                        prams.put("indeName","MIN");
                    }else if(shun.equals("平均值")){
                        prams.put("indeName","AVG");
                    }
                }
                if(xiao.equals("小时查询")){
                    prams.put("pattern","findbyhour");
                }else if(xiao.equals("精细查询")){
                    prams.put("pattern","findbyhis");
                }
                prams.put("businessCode",code);
                prams.put("buildCode",buildCode);
                prams.put("indeCode",indeCode);
                prams.put("dataTimeFrom",start);
                prams.put("dataTimeTo",end);
                HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCRUNDATA, prams,
                        RundataResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCRUNDATA, this, false).setTag(this);
                break;
        }
    }
    public void onEvent(RundataResponse mRundata){
        this.mRundata=mRundata;
    }

    public  View   initBarChartView(){
        mXYMultipleSeriesDataSet = new XYMultipleSeriesDataset();

        SupportBarSeriesRender barSeriesRender =new SupportBarSeriesRender();
        //设置柱状图的背景阴影是否可见
        barSeriesRender.setShowBarChartShadow(true);
        barSeriesRender.setSelectedChartType(SupportSelectedChartType.BOTH);
        XYSeries sysSeries = new XYSeries("");
        for(int i=0;i<mRundata.getData().getDataList().size();i++){
                sysSeries.add(i,Double.valueOf(mRundata.getData().getDataList().get(i)));
                mXYRenderer.addXTextLabel(i,mRundata.getData().getDateArray().get(i));
        }
        mXYMultipleSeriesDataSet.addSeries(sysSeries);
        View chartView = ChartFactory.getSupportBarChartView(this,mXYMultipleSeriesDataSet,
                mXYRenderer,barSeriesRender, SupportBarChart.Type.STACKED);
        chartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphicalView graphicalView = (GraphicalView)v;
              //graphicalView.handPointClickEvent("s");
            }
        });
        return chartView;
    }
    private void initRender() {
        // 1, 构造显示用渲染图
        // float textSize = 10f;

        mXYRenderer.setChartTitle("运行数据");
        mXYRenderer.setXTitle("日期");
        mXYRenderer.setYTitle("数值");
        mXYRenderer.setAxesColor(Color.BLACK);
        mXYRenderer.setLabelsColor(Color.BLACK);
        //设置字体的大小
        mXYRenderer.setAxisTitleTextSize(50f);
        mXYRenderer.setChartTitleTextSize(50f);
        mXYRenderer.setLabelsTextSize(30f);
        mXYRenderer.setLegendTextSize(50f);
        // 设置背景颜色
        mXYRenderer.setBackgroundColor(Color.WHITE);
        // 设置页边空白的颜色
        mXYRenderer.setMarginsColor(Color.WHITE);
        // 设置背景颜色生效
        mXYRenderer.setApplyBackgroundColor(true);

        // 设置坐标轴,轴的颜色
        mXYRenderer.setXLabelsColor(Color.parseColor("#797C7E"));
        mXYRenderer.setYLabelsColor(0, Color.parseColor("#797C7E"));
        //设置网格的颜色
        mXYRenderer.setShowGrid(true);
        mXYRenderer.setGridColor(Color.parseColor("#55797C7E"));
       mXYRenderer.addSeriesRenderer(getSimpleSeriesRender(Color.parseColor("#45b97c")));

        // 设置合适的刻度,在轴上显示的数量是 MAX / labels
        mXYRenderer.setYLabels(6);
        mXYRenderer.setXLabels(0); // 设置 X 轴不显示数字（改用我们手动添加的文字标签）
        mXYRenderer.setMargins(new int[]{70, 90, 70,70});
        mXYRenderer.setXAxisMin(0.5);
        mXYRenderer.setXAxisMax(5.5);
        mXYRenderer.setYAxisMin(0);
        mXYRenderer.setYAxisMax(600);

        // 设置x,y轴显示的排列,默认是 Align.CENTER
        mXYRenderer.setXLabelsAlign(Paint.Align.CENTER);
        mXYRenderer.setYLabelsAlign(Paint.Align.RIGHT);

        mXYRenderer.setAntialiasing(true);
        mXYRenderer.setFitLegend(true);
        mXYRenderer.setShowAxes(true);  // 设置坐标轴是否可见
        mXYRenderer.setShowLegend(true);
        mXYRenderer.setBarSpacing(0.8f);
        // 刻度线与X轴坐标文字左侧对齐
        mXYRenderer.setXLabelsAlign(Paint.Align.CENTER);
        // Y轴与Y轴坐标文字左对齐
        mXYRenderer.setYLabelsAlign(Paint.Align.LEFT);
        // 设置x,y轴上的刻度的颜色
        // 设置是否显示,坐标轴的轴,默认为 true
        // 是否支持图表移动
       /* mXYRenderer.setZoomButtonsVisible(true);*/
        mXYRenderer.setPanEnabled(true, false);// 表盘移动
        mXYRenderer.setZoomEnabled(true,false);
        mXYRenderer.setClickEnabled(true);// 是否可点击
        mXYRenderer.setSelectableBuffer(10);// 点击区域大小
    }

    protected void setRespectiveRender(XYMultipleSeriesRenderer render) {
        mXYRenderer.setBarWidth(125);
        mXYRenderer.setBarSpacing(1.5f);
        mXYRenderer.setXAxisMin(-0.5);
        mXYRenderer.setXAxisMax(8);
        mXYRenderer.setShowGrid(false);
        //设置XY轴Title的位置，默认是Center
        mXYRenderer.setSupportXAlign(SupportXAlign.RIGHT);
        mXYRenderer.setSupportYAlign(SupportYAlign.CENTER);
    }
    protected XYSeriesRenderer getSimpleSeriesRender(int color) {
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setColor(Color.RED);
        renderer.setDisplayChartValues(true);  // 设置是否在点上显示数据
        renderer.setPointStrokeWidth(10f);
        renderer.setChartValuesTextSize(50f);
        renderer.setGradientStart(0, Color.GRAY);  //可以设置柱状图颜色的渐变
        renderer.setGradientStop(10, Color.GREEN);
        renderer.setGradientEnabled(false);
        return renderer;
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUSINESS
                && response instanceof BusinessUnitResponse) {
            mBusinessUnit= (BusinessUnitResponse) response;
            if ("00000".equals( mBusinessUnit.getErrorCode())) {
                myBusinesAdapter = new MyBusinesAdapter();
                minitListView5.setAdapter(myBusinesAdapter);
                minitListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_rmon_dw.setText(mBusinessUnit.getData().getComboboxList().get(position).getText());
                        code = mBusinessUnit.getData().getComboboxList().get(position).getId();
                        PopupWindowUtils.closePopupWindow();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUILDING
                && response instanceof BuildingResponse) {
            mBuilding = (BuildingResponse) response;
            if ("00000".equals(mBuilding.getErrorCode())) {
                myBuildingAdapter = new MyBuildingAdapter();
                minitListView6.setAdapter( myBuildingAdapter);
                minitListView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_rmon_gzw.setText(mBuilding.getData().getComboboxList().get(position).getText());
                        buildCode = mBuilding.getData().getComboboxList().get(position).getId();
                        PopupWindowUtils.closePopupWindow();
                    }
                });

            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCQUOTA
                && response instanceof QuotaResponse) {
            mQuota = (QuotaResponse) response;
            if ("00000".equals(mQuota.getErrorCode())) {
                myQuotaAdapter = new MyQuotaAdapter();
                minitListView7.setAdapter( myQuotaAdapter);
                minitListView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_rmon_zb.setText( mQuota.getData().getComboboxList().get(position).getText());
                        indeCode = mQuota.getData().getComboboxList().get(position).getId();
                        PopupWindowUtils.closePopupWindow();
                    }
                });

            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCRUNDATA
                && response instanceof  RundataResponse) {
            mRundata= ( RundataResponse) response;
            Log.i("00000", mRundata.getErrorCode());
            if("00014".equals(mRundata.getErrorCode())){
                Toast.makeText(RunDataReslutZtActivity.this, "没有你想要查询的数据", Toast.LENGTH_SHORT).show();
            }
            if("00000".equals(mRundata.getErrorCode())){
                   /**刷新界面*/
               finish();
               Intent intent=new Intent(this,RunDataReslutZtActivity.class);
               startActivity(intent);
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    private ListView initListView7(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("businessCode",code);
        prams.put("buildCode",buildCode);
        prams.put("dataType2"," A1");
        HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCQUOTA, prams,
                QuotaResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCQUOTA, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView6(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("businessCode", code);
        HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCBUILDING, prams,
                BuildingResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUILDING, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView5(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCBUSINESS, prams,
                BusinessUnitResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUSINESS, this, false).setTag(this);
        return mListViews;
    }
    class MyBusinesAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mBusinessUnit.getData().getComboboxList().size();
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
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(RunDataReslutZtActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mBusinessUnit.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class  MyBuildingAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mBuilding.getData().getComboboxList().size();
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
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(RunDataReslutZtActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mBuilding.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class MyQuotaAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mQuota.getData().getComboboxList().size();
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
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(RunDataReslutZtActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mQuota.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class ViewHolder{
        TextView v_listview_item_number;
    }
}
