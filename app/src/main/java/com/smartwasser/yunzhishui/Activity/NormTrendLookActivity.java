package com.smartwasser.yunzhishui.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
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
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.LxindeAdapter;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.FindBuComBoxResponse;
import com.smartwasser.yunzhishui.bean.LxIndeResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.TreadResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogDateUtil;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.achartengine.ChartFactory;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.support.SupportColorLevel;
import org.achartengine.renderer.support.SupportLineSeriesRender;
import org.achartengine.renderer.support.SupportXAlign;
import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class NormTrendLookActivity extends BaseActivity implements View.OnClickListener,TextWatcher,HttpLoader.ResponseListener{
    private TextView tv_toolbar;
    private ImageButton button_menu, norm_ser;
    private Toolbar toolbar;
    private LinearLayout lin_bar_linear;
    private int y=0;
    private XYMultipleSeriesDataset mXYMultipleSeriesDataSet;
          /**查询的控件*/
    /**选择合计和平均*/
    private EditText ed_trend_hei;
    private ImageButton image_hei;
    /**选择年月日*/
    private EditText ed_norm_yue;
    private ImageButton image_yue;
    /**对比年的*/
    private EditText ed_trend_kaishi,ed_trend_end;
    /**日期*/
    private EditText  ed_trend_time_kaishi,ed_trend_time_end;
    /**厂站选择*/
    private EditText ed_trend_chan;
    private ImageButton image_hei_chan;
    private EditText ed_trend_zhibao;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private TextView tv_Normtrend;
    private ListView minitListView2;
    private FindBuComBoxResponse mFindBu;
    private SimpleTreeListViewAdapter mAdapter;
    private String code;
    private ListView minitListView,minitListView3,minitListView4;
    private String ruleType;
    private String indeFreq;
    private LxIndeResponse mLxinde;
    private String indeCode;
    private LxindeAdapter myAdapter4;
    private String dateFrom="";
    private String dateTo="";
    private TreeListUtils tlu=new TreeListUtils();
    private TreadResponse mTread;
    private ImageButton button_trend_time_kaishi,button_trend_time_end;
    private PopupWindowTwoUtil pwtu=new PopupWindowTwoUtil();
    private int i=0;
    private DialogDateUtil dialog=new DialogDateUtil(this);
    private  View parientView;
    private Handler mHandle=new Handler();
    private PopListViewUtils plu=new PopListViewUtils(this);
    /**查询*/
    private Button but_select_chan;
    private final static int COLOR_UP_TARGET = Color.parseColor("#FF843D");
    private final static int COLOR_LOW_TARGET = Color.parseColor("#FFC23E");
    private final static int COLOR_OTHER = Color.parseColor("#8FD85A");
    private XYMultipleSeriesRenderer  mXYRenderer;
    private   XYSeries sysSeries;
    @Override
    protected int initContentView() {
        return R.layout.activity_trend;
    }
    @Override
    protected void initView() {
        lin_bar_linear = (LinearLayout) findViewById(R.id.lin_bar_linear);
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        button_menu = (ImageButton) findViewById(R.id.button_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        norm_ser = (ImageButton) findViewById(R.id.norm_ser);
        mHandle.postDelayed(mRunnable,300);
    }
    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
           showSearch();
        }
    };
    private View getViews(){
        View view =View.inflate(this,R.layout.activity_norm_trend,null);
        ed_trend_hei= (EditText)view.findViewById(R.id.ed_trend_hei);
        image_hei= (ImageButton)view.findViewById(R.id.image_hei);
        ed_norm_yue= (EditText)view.findViewById(R.id.ed_norm_yue);
        image_yue= (ImageButton)view.findViewById(R.id.image_yue);
        ed_trend_kaishi= (EditText)view.findViewById(R.id.ed_trend_kaishi);
        ed_trend_end= (EditText)view.findViewById(R.id.ed_trend_end);
        ed_trend_time_kaishi= (EditText)view.findViewById(R.id.ed_trend_time_kaishi);
        ed_trend_time_end= (EditText)view.findViewById(R.id.ed_trend_time_end);
        ed_trend_chan= (EditText)view.findViewById(R.id.ed_trend_chan);
        image_hei_chan= (ImageButton)view.findViewById(R.id.image_hei_chan);
        but_select_chan= (Button)view.findViewById(R.id.but_select_chan);
        ed_trend_zhibao= (EditText)view.findViewById(R.id.ed_trend_zhibao);
        button_trend_time_kaishi= (ImageButton)view.findViewById(R.id.button_trend_time_kaishi);
        button_trend_time_end= (ImageButton)view.findViewById(R.id.button_trend_time_end);
        tv_Normtrend= (TextView) view.findViewById(R.id.tv_Normtrend);
        return view;
    }
    @Override
    protected void initListener() {
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("单指标历史同期趋势对比");
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
    }
    public XYMultipleSeriesDataset initLineGraphView() {
        mXYMultipleSeriesDataSet = new XYMultipleSeriesDataset();
        mXYRenderer = new XYMultipleSeriesRenderer();
        SupportLineSeriesRender lineSeriesRender = new SupportLineSeriesRender();
        lineSeriesRender.setClickPointColor(Color.parseColor("#8F77AA"));
        lineSeriesRender.setColorLevelValid(true);
        ArrayList<SupportColorLevel> list = new ArrayList<SupportColorLevel>();
        SupportColorLevel supportColorLevel_a = new SupportColorLevel(0, 10, COLOR_LOW_TARGET);
        SupportColorLevel supportColorLevel_b = new SupportColorLevel(10, 15, COLOR_UP_TARGET);
        SupportColorLevel supportColorLevel_c = new SupportColorLevel(15, 20, COLOR_OTHER);
        list.add(supportColorLevel_a);
        list.add(supportColorLevel_b);
        list.add(supportColorLevel_c);
        lineSeriesRender.setColorLevelList(list);
        String yearStrat = ed_trend_kaishi.getText().toString();
        String yearEnd =ed_trend_end.getText().toString();
        List<String> mlistData = new ArrayList<>();
        List<String> mListValue = new ArrayList<>();
        Set<String> set=new HashSet<>();
        for (int j = Integer.valueOf(yearStrat); j <= Integer.valueOf(yearEnd); j++) {
            sysSeries = new XYSeries(j+"");
            for (int i = 0; i< mTread.getData().size(); i++){
              //  Log.i(TAG, j + "年" + "----------------" + mNorm.getmTread().getData().get(i).getYEARS());
                if((j+"年").equals(mTread.getData().get(i).getYEARS())){
                    mlistData.add(mTread.getData().get(i).getDATA_DATE());
                    mListValue.add(mTread.getData().get(i).getINDE_VALUE());
                }
            }
            set.addAll(mListValue);
            if(mlistData.size()!=0&&mListValue.size()!=0&&set.size()!=1){
                for (int m = 0; m < mlistData.size(); m++) {
                    String txt = mListValue.get(m);
                    if("".equals(txt)||txt==null){
                        txt="0";
                    }
                    sysSeries.add(m, Integer.valueOf(txt));
                    mXYRenderer.addXTextLabel(m, mlistData.get(m));
                }
                mXYMultipleSeriesDataSet.addSeries(sysSeries);
                y++;
            }
            mlistData.clear();
            mListValue.clear();
            set.clear();
        }
        return  mXYMultipleSeriesDataSet;
    }
    private XYMultipleSeriesRenderer initRender() {

        // 1, 构造显示用渲染图
        mXYRenderer.setChartTitle(mTread.getData().get(0).getBUSINESS_UNIT_NAME());
        mXYRenderer.setXTitle("日期");
        mXYRenderer.setYTitle("指标");
        mXYRenderer.setAxesColor(Color.BLACK);
        mXYRenderer.setLabelsColor(Color.BLACK);
        //设置字体的大小
        mXYRenderer.setAxisTitleTextSize(50f);
        mXYRenderer.setChartTitleTextSize(50f);
        mXYRenderer.setLabelsTextSize(30f);
        mXYRenderer.setLegendTextSize(50f);
        mXYRenderer.setPointSize(20f);
        // 设置合适的刻度,在轴上显示的数量是 MAX / labels
        mXYRenderer.setYLabels(10);
        mXYRenderer.setXLabels(0);  // 设置 X 轴不显示数字（改用我们手动添加的文字标签）
        mXYRenderer.setXAxisMin(0.5);
        mXYRenderer.setXAxisMax(15);
        mXYRenderer.setYAxisMin(0);
        //设置网格的颜色
        mXYRenderer.setShowGrid(true);
        mXYRenderer.setGridColor(Color.parseColor("#55797C7E"));
        // 设置背景颜色
        mXYRenderer.setBackgroundColor(Color.WHITE);
        // 设置页边空白的颜色
        mXYRenderer.setMarginsColor(Color.WHITE);
        // 设置背景颜色生效
        mXYRenderer.setApplyBackgroundColor(true);

        // 设置坐标轴,轴的颜色
        mXYRenderer.setXLabelsColor(Color.parseColor("#797C7E"));
        mXYRenderer.setYLabelsColor(0, Color.parseColor("#797C7E"));
        mXYRenderer.setPanEnabled(false, false);// 表盘移动
        mXYRenderer.setZoomEnabled(true,true);
       /* mXYRenderer.setZoomButtonsVisible(true);*/
        mXYRenderer.setMargins(new int[]{70, 90,70,70});
        // 设置x,y轴显示的排列,默认是 Align.CENTER
        mXYRenderer.setXLabelsAlign(Paint.Align.CENTER);
        mXYRenderer.setYLabelsAlign(Paint.Align.LEFT);
        mXYRenderer.setSupportXAlign(SupportXAlign.RIGHT);
        mXYRenderer.setAntialiasing(true);
        mXYRenderer.setFitLegend(true);
        mXYRenderer.setShowAxes(true);  // 设置坐标轴是否可见
        mXYRenderer.setShowLegend(true);

        XYSeriesRenderer renderer;
        int s[]=new int[]{Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW,Color.GRAY,Color.BLACK,Color.CYAN};
        for(int i=0;i<y;i++){
            renderer=new XYSeriesRenderer();
            renderer.setFillPoints(true);
            renderer.setColor(s[i]);
            renderer.setLineWidth(5f);
            renderer.setFillPoints(true);
            /**将点的值显示出来*/
            renderer.setDisplayChartValues(true);
            /**显示的点的值与图的距离*/
            renderer.setChartValuesSpacing(30f);
            /**点的值的文字大小 */
            renderer.setChartValuesTextSize(20f);
            mXYRenderer.addSeriesRenderer(renderer);
        }
        return mXYRenderer;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.norm_ser:
                if(psu.pw==null){
                    finish();
                    Intent intent=new Intent(this,NormTrendLookActivity.class);
                    startActivity(intent);
               }
                i=0;
                showSearch();
            break;
            case R.id.ed_trend_hei:
                // 初始化ListView控件和里边的数据
                minitListView = plu.initListView2();
                pwtu.showPopupWindow(minitListView,parientView,ed_trend_hei.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.240),(int)(GetScreenParam.getScreenHeight(this)*0.057));
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_trend_hei.setText(plu.mListView2.get(position));
                        pwtu.closePopupWindow();
                    }
                });
                break;
            case R.id.ed_norm_yue:
                minitListView3 =plu.initListView3();
                pwtu.showPopupWindow(minitListView3,parientView, ed_norm_yue.getWidth(),(int)(GetScreenParam.getScreenWidth(this)*0.240),(int)(GetScreenParam.getScreenHeight(this)*0.119));
                minitListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_norm_yue.setText(plu.mListView3.get(position));
                        pwtu.closePopupWindow();
                    }
                });
                break;
            case R.id.ed_trend_chan:
                minitListView2 =initListView2();
                pwtu.showPopupWindow(minitListView2,parientView,ed_trend_chan.getWidth(),(int)(GetScreenParam.getScreenWidth(this)*0.235),(int)(GetScreenParam.getScreenHeight(this)*0.286));
                break;
            case R.id.but_select_chan:
                /**发起网络请求*/
                String year_kaishi=ed_trend_kaishi.getText().toString();
                String year_end=ed_trend_end.getText().toString();
                String time_kaishi=ed_trend_time_kaishi.getText().toString();
                String time_end=ed_trend_time_end.getText().toString();
                String heji= ed_trend_hei.getText().toString();
                String yue= ed_norm_yue.getText().toString();
                String chan=ed_trend_chan.getText().toString();
                String zhibiao= ed_trend_zhibao.getText().toString();
                if("".equals(chan)||"null".equals(chan)||chan==null){
                    Toast.makeText(NormTrendLookActivity.this, "请选择厂站", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(zhibiao)||"null".equals(zhibiao)||zhibiao==null){
                    Toast.makeText(NormTrendLookActivity.this, "请选择指标", Toast.LENGTH_SHORT).show();
                    return;
                }
                psu.colsePopupWindow();
                if("默认".equals(heji)){
                    ruleType="0";
                }else if("合计".equals(heji)){
                    ruleType="sum";
                }else if("平均".equals(heji)){
                    ruleType="avg";
                }
                if("请选择".equals(yue)){
                    indeFreq="0";
                }else if("日".equals(yue)){
                    indeFreq="day";
                }else if("月".equals(yue)){
                    indeFreq="mounth";
                }else if("年".equals(yue)){
                    indeFreq="year";
                }
                if(
                        ("".equals(year_kaishi)||"null".equals(year_kaishi)|| year_kaishi==null)||
                        ("".equals(year_end)||"null".equals(year_end)||  year_end==null)||
                        ("".equals(time_kaishi)||"null".equals(time_kaishi)|| time_kaishi==null)||
                        ("".equals(time_end)||"null".equals(time_end)|| time_end==null)){
                    Toast.makeText(NormTrendLookActivity.this, "数据没有填写完整", Toast.LENGTH_SHORT).show();
                }else{
                    for(int i=0;i<Integer.valueOf(year_end)-Integer.valueOf(year_kaishi)+1;i++){
                        if(i==Integer.valueOf(year_end)-Integer.valueOf(year_kaishi)) {
                            dateFrom += Integer.valueOf(year_kaishi) + i + "-" + time_kaishi;
                            dateTo += Integer.valueOf(year_kaishi) + i + "-" + time_end;
                        }else{
                            dateFrom += Integer.valueOf(year_kaishi) + i + "-" + time_kaishi + ",";
                            dateTo += Integer.valueOf(year_kaishi) + i + "-" + time_end+",";
                        }
                    }
                    /**发起网络请求*/
                    showProgressDialog();
                    HashMap<String, Object> prams= new HashMap<>();
                    prams.put("dateFrom",dateFrom);
                    prams.put("dateTo",dateTo);
                    prams.put("indeCode",indeCode);
                    prams.put("unitCode",code);
                    prams.put("ruleType",ruleType);
                    prams.put("indeFreq",indeFreq);
                    HttpLoader.get(ConstantsYunZhiShui.URL_DANZLS, prams,
                            TreadResponse.class,ConstantsYunZhiShui.REQUEST_CODE_DANZLS, this, false).setTag(this);
                    showProgressDialog();
                }
                break;
            case R.id.ed_trend_time_kaishi:
                /**开始时间*/
                dialog.show(ed_trend_time_kaishi);
                dialog.showTime();
                break;
            case R.id.ed_trend_time_end:
                /**结束时间*/
                dialog.show(ed_trend_time_end);
                dialog.showTime();
                break;
        }
    }
    private void showSearch(){
        psu.showPopupSearch(getViews(), toolbar);
        parientView=toolbar;
        tv_Normtrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwtu.closePopupWindow();
                psu.colsePopupWindow();
            }
        });
        ed_trend_hei.setText("默认");
        ed_norm_yue.setText("请选择");
        ed_trend_hei.setOnClickListener(this);
        ed_norm_yue.setOnClickListener(this);
        ed_trend_chan.setOnClickListener(this);
        but_select_chan.setOnClickListener(this);
        ed_trend_zhibao.addTextChangedListener(this);
        ed_trend_time_kaishi.setOnClickListener(this);
        ed_trend_time_end.setOnClickListener(this);
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        minitListView4=initListView4(s.toString());
        if(i!=1||"".equals(s.toString())) {
            pwtu.showPopupWindow(minitListView4,parientView,ed_trend_zhibao.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.222),(int)(GetScreenParam.getScreenHeight(this)*0.350));
        }
    }
    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
        pwtu.closePopupWindow();
    }
    private ListView initListView4(String s) {
        ListView mListViews4 = new ListView(this);
        mListViews4.setDividerHeight(0);
        mListViews4.setBackgroundResource(R.drawable.listview_background);
        mListViews4.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews4.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        if(!"".equals(code)&&code!=null&&!"null".equals(code)){
            prams.put("assuUnit",code);
        }
        if(s==null||"".equals(s)||"null".equals("")){
            s="0";
        }
        prams.put("indeName",s);
        HttpLoader.get(ConstantsYunZhiShui.URL_LXINDE, prams,
                LxIndeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LXINDE, this, false).setTag(this);
        return mListViews4;
    }
    private ListView initListView2() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("tableName", "DAILY_WATER");
        HttpLoader.get(ConstantsYunZhiShui.URL_FINDBUCOM, prams,
                FindBuComBoxResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM, this, false).setTag(this);
        return mListViews;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM
                && response instanceof FindBuComBoxResponse) {
            mFindBu = (FindBuComBoxResponse) response;
            tlu.initDataText(mFindBu);
            try {
                mAdapter = new SimpleTreeListViewAdapter(minitListView2, this,
                        tlu.mDatas2, 0);
                minitListView2.setAdapter(mAdapter);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                @Override
                public void onClick(Node node, int position) {
                    if (node.isleaf()) {
                        ed_trend_chan.setText(node.getName());
                        for(int i=0;i<mFindBu.getData().getListTree().size();i++) {
                            if(node.getName().equals(mFindBu.getData().getListTree().get(i).getBusinessUnitName())) {
                                code = mFindBu.getData().getListTree().get(i).getBusinessUnitCode();
                            }
                        }
                        pwtu.closePopupWindow();
                    }
                }
            });
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_LXINDE
                && response instanceof LxIndeResponse){
            mLxinde= (LxIndeResponse) response;
            myAdapter4=new LxindeAdapter(mLxinde,this);
            minitListView4.setAdapter(myAdapter4);
            minitListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    i++;
                    pwtu.closePopupWindow();
                    ed_trend_zhibao.setText(mLxinde.getData().getIndeList().get(position).getIndeName());
                    indeCode = mLxinde.getData().getIndeList().get(position).getIndeCode();
                }
            });
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_DANZLS
                && response instanceof TreadResponse){
                mTread=(TreadResponse)response;
            dismissProgressDialog();
            if("00014".equals(mTread.getErrorCode())){
                Toast.makeText(NormTrendLookActivity.this, "没有数据", Toast.LENGTH_SHORT).show();
                return;
            }
            if("00000".equals(mTread.getErrorCode())){
                View view=ChartFactory.getLineChartView(this, initLineGraphView(), initRender());
                lin_bar_linear.addView(view);
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
}

