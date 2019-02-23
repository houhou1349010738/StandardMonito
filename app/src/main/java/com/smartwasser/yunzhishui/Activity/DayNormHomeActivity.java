package com.smartwasser.yunzhishui.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.LxindeAdapter;
import com.smartwasser.yunzhishui.bean.DayNormResponse;
import com.smartwasser.yunzhishui.bean.LxIndeResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.SupportBarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.support.SupportBarSeriesRender;
import org.achartengine.renderer.support.SupportColorLevel;
import org.achartengine.renderer.support.SupportSelectedChartType;
import org.achartengine.renderer.support.SupportTargetLineStyle;
import org.achartengine.renderer.support.SupportXAlign;
import org.achartengine.renderer.support.SupportYAlign;
import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by huangmengjie on 2016/5/20 0020.
 */
public class DayNormHomeActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener,TextWatcher {
    private LinearLayout layout;
    private TextView tv_toolbar;
    private ImageButton button_menu,norm_ser;
    private Toolbar toolbar;
    protected XYMultipleSeriesRenderer mXYRenderer;
    protected XYMultipleSeriesDataset mXYMultipleSeriesDataSet;
    /**搜索的控件*/
    private LxindeAdapter myAdapter3;
    private EditText ed_norm_daytime;
    private ImageButton but_norm_daytime;
    private EditText ed_zhibiao_daynorm;
    private RadioGroup group_drynorm;
    private Button but_search_daynorm;
    private TextView  tv_daynorm;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private ListView minitListView3;
    private boolean flag = false;
    private LxIndeResponse mLxindeDay;
    private  View parientView;
    private String indeCode;
    private DayNormResponse mDayNorm;
    private Handler mHandler=new Handler();
    private PopupWindowTwoUtil ptu=new PopupWindowTwoUtil();
    private int i = 0;
    private final  static int COLOR_UP_TARGET = Color.parseColor("#FF843D");
    private final  static int COLOR_LOW_TARGET = Color.parseColor("#FFC23E");
    private final  static int COLOR_OTHER= Color.parseColor("#8FD85A");
    @Override
    protected int initContentView() {
        return R.layout.pager_daynorm;
    }
    @Override
    protected void initView() {
        layout= (LinearLayout)findViewById(R.id.bar_linear);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        toolbar= (Toolbar)findViewById(R.id.toolbar);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
     }
      private View getViews(){
          View view =View.inflate(this,R.layout.activity_day_norm,null);
          ed_norm_daytime= (EditText) view.findViewById(R.id.ed_norm_daytime);
          but_norm_daytime= (ImageButton) view.findViewById(R.id.but_norm_daytime);
          ed_zhibiao_daynorm= (EditText) view.findViewById(R.id.ed_zhibiao_daynorm);
          group_drynorm= (RadioGroup) view.findViewById(R.id.group_drynorm);
          but_search_daynorm = (Button)view.findViewById(R.id.but_search_daynorm);
          tv_daynorm= (TextView) view.findViewById(R.id.tv_daynorm);
          return view;
      }
     @Override
     protected void initListener() {
    }
    @Override
    protected void initData() {

        tv_toolbar.setText("各分厂指标日数据对比");
        toolbar.setNavigationIcon(R.drawable.fanhui);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_menu.setVisibility(View.GONE);
        norm_ser.setVisibility(View.VISIBLE);
        norm_ser.setOnClickListener(this);
        mHandler.postDelayed(mRunnable,300);
    }
    private  Runnable mRunnable=new Runnable() {
        public void run() {
            // 弹出PopupWindow的具体代码
            showSearch();
        }
    };
    public View initBarChartView(){
        mXYMultipleSeriesDataSet = new XYMultipleSeriesDataset();
        SupportBarSeriesRender barSeriesRender =new SupportBarSeriesRender();
        //设置柱状图的背景阴影是否可见
        barSeriesRender.setShowBarChartShadow(true);
//        barSeriesRender.setShowBarChartShadow(Color.DKGRAY);
        barSeriesRender.setSelectedChartType(SupportSelectedChartType.BOTH);
        //设置是否使用颜色分级功能
        barSeriesRender.setColorLevelValid(true);
        ArrayList<SupportColorLevel> list = new ArrayList<SupportColorLevel>();
        //如果仅仅以target作为颜色分级，可以使用这个用法
      /*  SupportColorLevel supportColorLevel_a = new SupportColorLevel(0,mXYRenderer.getTargetValue(),COLOR_LOW_TARGET);
        SupportColorLevel supportColorLevel_b = new SupportColorLevel(mXYRenderer.getTargetValue(),mXYRenderer.getTargetValue()*10,COLOR_UP_TARGET);*/
        // 若有多个颜色等级可以使用这个用法
        SupportColorLevel supportColorLevel_a = new SupportColorLevel(0,10,COLOR_LOW_TARGET);
        SupportColorLevel supportColorLevel_b = new SupportColorLevel(10,15,COLOR_UP_TARGET);
        SupportColorLevel supportColorLevel_c = new SupportColorLevel(15,20,COLOR_OTHER);

        list.add(supportColorLevel_a);
        list.add(supportColorLevel_b);
        list.add(supportColorLevel_c);
        barSeriesRender.setColorLevelList(list);

        XYSeries sysSeries = new XYSeries(ed_norm_daytime.getText().toString().trim());
        for(int i=0;i< mDayNorm.getData().getIndeList().size();i++){
            String txt= mDayNorm.getData().getIndeList().get(i).getINDE_VALUE();
            if("".equals(txt)||"null".equals(txt)||txt==null){
                txt="0";
            }
           /*Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(txt);
            if(m.matches()){

            }else{
                sysSeries.add(i,Integer.valueOf("0"));
            }*/
            sysSeries.add(i,Double.valueOf(txt));
            mXYRenderer.addXTextLabel(i, mDayNorm.getData().getIndeList().get(i).getBUSINESS_UNIT_NAME());
        }
        mXYMultipleSeriesDataSet.addSeries(sysSeries);
        View chartView = ChartFactory.getSupportBarChartView(this, mXYMultipleSeriesDataSet,
                mXYRenderer, barSeriesRender, SupportBarChart.Type.STACKED);
        chartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphicalView graphicalView = (GraphicalView) v;
                /*graphicalView.handPointClickEvent("s");*/
            }
        });
        return  chartView;
    }
    private void initRender() {
        // 1, 构造显示用渲染图
       // float textSize = 10f;
        mXYRenderer=new XYMultipleSeriesRenderer();
        mXYRenderer.setChartTitle("多指标日数据对比");
        mXYRenderer.setXTitle("单位名称");
        mXYRenderer.setYTitle("指标值");
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
        mXYRenderer.setYLabels(20);
        mXYRenderer.setXLabels(0); // 设置 X 轴不显示数字（改用我们手动添加的文字标签）
        mXYRenderer.setMargins(new int[]{70, 90, 70, 70});
        mXYRenderer.setXAxisMin(0.5);
        mXYRenderer.setXAxisMax(5.5);
        mXYRenderer.setYAxisMin(0);

       /* mXYRenderer.setYAxisMax(200);*/

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
        mXYRenderer.setPanEnabled(true,false);// 表盘移动
        mXYRenderer.setZoomEnabled(true,true);
        mXYRenderer.setClickEnabled(true);// 是否可点击
        mXYRenderer.setSelectableBuffer(10);// 点击区域大小

        //设置目标线
        if(flag){
          mXYRenderer.setTargetLineVisible(true);
          mXYRenderer.setTargetLineColor(Color.MAGENTA);
            String s=mDayNorm.getData().getIndeValueMax();
            if("".equals(s)||s==null||"null".equals(s)){
                    s="0";
            }
            double max=0;
            for(int i=0;i< mDayNorm.getData().getIndeList().size();i++) {
                String txt = mDayNorm.getData().getIndeList().get(i).getINDE_VALUE();
                if("".equals(txt)||txt==null||"null".equals(txt)){
                       txt="0";
                }
                if(Double.valueOf(txt)>max){
                    max=Double.valueOf(txt);
                }
            }
            if(Double.parseDouble(s)>max){
                mXYRenderer.setTargetValue((int)max);
            }else{
                mXYRenderer.setTargetValue(Integer.parseInt(s));
            }
            mXYRenderer.setTargetLineStyle(SupportTargetLineStyle.Line_Dotted);
            mXYRenderer.setTargetDescription("Max    " + s);
        }
        Typeface typeFace = Typeface.createFromAsset(this.getAssets(), "fonts/Futura.ttc");
        mXYRenderer.setTextTypeface(typeFace);
        setRespectiveRender(mXYRenderer);
    }

    protected void setRespectiveRender(XYMultipleSeriesRenderer render) {
        mXYRenderer.setBarWidth(125);
        /**控制柱子之间的距离*/
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
        renderer.setColor(color);
        renderer.setDisplayChartValues(true);  // 设置是否在点上显示数据
        renderer.setPointStrokeWidth(10f);
        renderer.setChartValuesTextSize(50f);
        renderer.setGradientStart(0, Color.GRAY);  //可以设置柱状图颜色的渐变
        renderer.setGradientStop(10, Color.GREEN);
        renderer.setGradientEnabled(false);
        return renderer;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.norm_ser:
                if(psu.pw==null){
                    finish();
                    Intent intent=new Intent(this,DayNormHomeActivity.class);
                    startActivity(intent);
                }
                i=0;
                showSearch();
            break;
            case R.id.ed_norm_daytime:
                dialog.show(ed_norm_daytime);
                dialog.showTime();
                break;
            case R.id.but_search_daynorm:
                            /**搜索*/
                String time = ed_norm_daytime.getText().toString().trim();
                String zhibiao= ed_zhibiao_daynorm.getText().toString().trim();
                if(time==null||"".equals(time)||"null".equals(time)){
                    Toast.makeText(DayNormHomeActivity.this, "数据所属时间为空", Toast.LENGTH_SHORT).show();
                      return;
                }
                if(zhibiao==null||"".equals(zhibiao)||"null".equals(zhibiao)){
                    Toast.makeText(DayNormHomeActivity.this, "请选择指标", Toast.LENGTH_SHORT).show();
                    return;
                }
                psu.colsePopupWindow();
                showProgressDialog();
                HashMap<String, Object> params = new HashMap<>();
                params.put("indeCode", indeCode);
                params.put("dateFrom", time);
                HttpLoader.get(ConstantsYunZhiShui.URL_DCZBRI, params, DayNormResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_DCZBRI, this,false).setTag(this);
                showProgressDialog();
                break;
        }
    }
    private void showSearch(){
        psu.showPopupSearch(getViews(),toolbar);
        parientView=toolbar;
        tv_daynorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_norm_daytime.setOnClickListener(this);
        but_search_daynorm.setOnClickListener(this);
        ed_zhibiao_daynorm.addTextChangedListener(this);
        group_drynorm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but_false:
                        /**将其传入显示类中*/
                        flag = false;
                        break;
                    /**将其传入显示类中*/
                    case R.id.but_true:
                        flag = true;
                        break;
                }
            }
        });
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_LXINDE
                && response instanceof LxIndeResponse) {
            mLxindeDay = (LxIndeResponse) response;
            myAdapter3 = new LxindeAdapter(mLxindeDay,this);
            minitListView3.setAdapter(myAdapter3);
            minitListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    i++;
                    ptu.closePopupWindow();
                    ed_zhibiao_daynorm.setText(mLxindeDay.getData().getIndeList().get(position).getIndeName());
                    indeCode = mLxindeDay.getData().getIndeList().get(position).getIndeCode();
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_DCZBRI
                && response instanceof DayNormResponse) {
              mDayNorm = (DayNormResponse) response;
              dismissProgressDialog();
            if ("00014".equals(mDayNorm.getErrorCode())) {
                Toast.makeText(DayNormHomeActivity.this, "此时间没有数据", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("00000".equals(mDayNorm.getErrorCode())) {
                     /**刷新界面*/
                initRender();
                layout.addView(initBarChartView());
            }

        }
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        minitListView3 = initListView3(s.toString());
        if (i!= 1|| "".equals(s.toString())) {
            ptu.showPopupWindow(minitListView3, parientView,ed_zhibiao_daynorm.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.232),(int)(GetScreenParam.getScreenHeight(this)*0.113));
        }
    }
    private ListView initListView3(String s) {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        if (s == null || "".equals(s) || "null".equals("")) {
            s = "0";
        }
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("indeName", s);
        HttpLoader.get(ConstantsYunZhiShui.URL_LXINDE, prams,
                LxIndeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LXINDE, this, false).setTag(this);
        return mListViews;
    }
    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
    }
}
