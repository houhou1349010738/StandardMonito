package com.smartwasser.yunzhishui.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;

import android.util.Log;
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

import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter15;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter2;
import com.smartwasser.yunzhishui.bean.FindBuComBoxResponse;
import com.smartwasser.yunzhishui.bean.LxIndeResponse;
import com.smartwasser.yunzhishui.bean.MuchTrendResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;

import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TimeUtils;
import com.smartwasser.yunzhishui.utils.TreeListUtils;
import org.achartengine.ChartFactory;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.support.SupportXAlign;
import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Created by huangmengjie on 2016/5/22 0022.
 */
public class MuchTrendLookActivity extends BaseActivity implements HttpLoader.ResponseListener, View.OnClickListener,TextWatcher {
    private TextView tv_toolbar;
    private ImageButton button_menu,norm_ser;
    private Toolbar toolbar;
    private LinearLayout lin_bar_linear;
    private XYMultipleSeriesDataset mXYMultipleSeriesDataSet;
    private XYMultipleSeriesRenderer  mXYRenderer;
    private  String ss[];
    private int y=0;
         /**查询控件*/
    private TextView tv_muchtrend;
    /**合计和平均的选择*/
    private EditText ed_trend_muchhei;
    private ImageButton image_muchhei;
    /**年月日的选择*/
    private EditText ed_norm_muchyue;
    private ImageButton image_muchyue;
    /**开始时间*/
    private EditText dateAndTimeLabel;
    private ImageButton but_muchtrend_strattime;
    /**结束时间*/
    private EditText dateAndTime2;
    private ImageButton but_end_time;
    /**快捷选择方式*/
    private EditText ed_kuaijie_muchtime;
    private ImageButton image_kuaijie;
    /**厂站选择*/
    private EditText ed_trend_muchchan;
    private ImageButton image_hei_muchchan;
    /**指标选择*/
    private EditText ed_trend_muchzhibao;
    /**点击查询按钮*/
    private Button but_select_muchchan;
    private ListView minitListView,minitListView3,minitListView2,minitListView4,minitListView5;
    private String ruleType;
    private String indeFreq;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private TimeUtils time=new TimeUtils();
    private TreeListUtils tlu=new TreeListUtils();
    private FindBuComBoxResponse mFindBu;
    private SimpleTreeListViewAdapter15 mAdapter;
    private String code="";
    private LxIndeResponse mLxinde;
    private String indeCode;
    private LxindeAdapter myAdapter5;
    private  String s="";
    private MuchTrendResponse mMuchTrend;
    private int i=0;
    private View parientView;
    private int m=0;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private Handler mHandler=new Handler();
    private PopupWindowTwoUtil potw=new PopupWindowTwoUtil();
    private PopListViewUtils plu=new PopListViewUtils(this);
    private ListView  mListViews;
    private Button queding,quxiao;
    private List<String> list=new ArrayList<>();
    @Override
    protected int initContentView() {
        return R.layout.activity_trend;
    }
    @Override
    protected void initView() {
        lin_bar_linear= (LinearLayout)findViewById(R.id.lin_bar_linear);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        toolbar= (Toolbar)findViewById(R.id.toolbar);
        norm_ser= (ImageButton) findViewById(R.id.norm_ser);
        time.showTimeShortcut();
        mHandler.postDelayed(mRunnable,300);
    }
    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            showMuchTrend();
        }
    };
    private View getViews(){
        View view=View.inflate(this,R.layout.activity_norm_muchtrend,null);
        ed_trend_muchhei= (EditText)view.findViewById(R.id.ed_trend_muchhei);
        image_muchhei= (ImageButton)view.findViewById(R.id.image_muchhei);
        ed_norm_muchyue= (EditText)view.findViewById(R.id.ed_norm_muchyue);
        image_muchyue= (ImageButton)view.findViewById(R.id.image_muchyue);
        dateAndTimeLabel= (EditText)view.findViewById(R.id.ed_muchtrend_strattime);
        but_muchtrend_strattime= (ImageButton)view.findViewById(R.id.but_muchtrend_strattime);
        dateAndTime2= (EditText)view.findViewById(R.id.ed_muchtrend_endtime);
        ed_kuaijie_muchtime= (EditText)view.findViewById(R.id.ed_kuaijie_muchtime);
        image_kuaijie= (ImageButton)view.findViewById(R.id.image_kuaijie);
        but_end_time= (ImageButton)view.findViewById(R.id.but_end_time);
        ed_trend_muchchan= (EditText)view.findViewById(R.id.ed_trend_muchchan);
        image_hei_muchchan= (ImageButton)view.findViewById(R.id.image_hei_muchchan);
        ed_trend_muchzhibao= (EditText)view.findViewById(R.id.ed_trend_muchzhibao);
        but_select_muchchan= (Button)view.findViewById(R.id.but_select_muchchan);
        tv_muchtrend= (TextView) view.findViewById(R.id.tv_muchtrend);
        return view;
    }
    @Override
    protected void initListener() {
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("多厂站单指标趋势对比");
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
        mXYRenderer = new XYMultipleSeriesRenderer();
        mXYMultipleSeriesDataSet = new XYMultipleSeriesDataset();
        List<String> mlistData = new ArrayList<>();
        List<String> mListValue = new ArrayList<>();
        Set<String> set=new HashSet<>();
        String s2=ed_trend_muchchan.getText().toString();
        ss=s2.split(",");
        for (int j=0; j <ss.length; j++){
            XYSeries sysSeries = new XYSeries(ss[j]);
            for (int i = 0; i<mMuchTrend.getData().size();i++){
                if(ss[j].equals(mMuchTrend.getData().get(i).getBUSINESS_UNIT_NAME())){
                    mlistData.add(mMuchTrend.getData().get(i).getDATA_DATE());
                    mListValue.add(mMuchTrend.getData().get(i).getINDE_VALUE());
                }
            }
            set.addAll(mListValue);
            if(mlistData.size()!=0&&mListValue.size()!=0&&set.size()!=1&&set.size()!=0){
                for (int m = 0; m < mlistData.size(); m++) {
                    String txt = mListValue.get(m);
                    if("".equals(txt)||txt==null||"null".equals(txt)){
                        txt="0";
                    }
                    sysSeries.add(m,Double.valueOf(txt));
                    mXYRenderer.addXTextLabel(m,mlistData.get(m));
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
        mXYRenderer.setChartTitle(mMuchTrend.getData().get(0).getINDE_NAME());
        mXYRenderer.setXTitle("日期");
        mXYRenderer.setYTitle("指标");
        mXYRenderer.setAxesColor(Color.BLACK);
        mXYRenderer.setLabelsColor(Color.BLACK);
        //设置字体的大小
        mXYRenderer.setAxisTitleTextSize(30f);
        mXYRenderer.setChartTitleTextSize(50f);
        mXYRenderer.setLabelsTextSize(30f);
        mXYRenderer.setLegendTextSize(20f);
        mXYRenderer.setPointSize(20f);
        // 设置合适的刻度,在轴上显示的数量是 MAX / labels
        mXYRenderer.setYLabels(10);
        mXYRenderer.setXLabels(0);  // 设置 X 轴不显示数字（改用我们手动添加的文字标签）
        mXYRenderer.setXAxisMin(0.5);
        mXYRenderer.setXAxisMax(10);
        mXYRenderer.setYAxisMin(0);
        mXYRenderer.setSupportXAlign(SupportXAlign.RIGHT);
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
        mXYRenderer.setPanEnabled(true,true);// 表盘移动
        mXYRenderer.setZoomEnabled(true, true);
       /* mXYRenderer.setZoomButtonsVisible(true);*/
        mXYRenderer.setMargins(new int[]{70, 90,70, 70});
        // 设置x,y轴显示的排列,默认是 Align.CENTER
        mXYRenderer.setXLabelsAlign(Paint.Align.CENTER);
        mXYRenderer.setYLabelsAlign(Paint.Align.LEFT);
        mXYRenderer.setAntialiasing(true);
        mXYRenderer.setFitLegend(true);
        mXYRenderer.setShowAxes(true);  //设置坐标轴是否可见
        mXYRenderer.setShowLegend(true);

        XYSeriesRenderer renderer;
        int s[]=new int[]{Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.GRAY};
        for(int i=0;i<y;i++){
            renderer=new XYSeriesRenderer();
            renderer.setFillPoints(true);
            renderer.setColor(s[i]);
            renderer.setLineWidth(8f);
            renderer.setFillPoints(true);
            /**将点的值显示出来*/
            renderer.setDisplayChartValues(true);
            /**显示的点的值与图的距离*/
            renderer.setChartValuesSpacing(30f);
            /**点的值的文字大小 */
            renderer.setChartValuesTextSize(30f);
            mXYRenderer.addSeriesRenderer(renderer);
        }
        return mXYRenderer;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.norm_ser:
                  if(m!=0){
                    finish();
                    Intent intent=new Intent(this,MuchTrendLookActivity.class);
                    startActivity(intent);
                 }
                i=0;
                s="";
                code="";
                showMuchTrend();
            break;
            case R.id.ed_trend_muchhei:
                /**选择月的*/
                // 初始化ListView控件和里边的数据
                minitListView = plu.initListView2();
                potw.showPopupWindow(minitListView,parientView,ed_trend_muchhei.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.240),(int)(GetScreenParam.getScreenHeight(this)*0.057));
                minitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_trend_muchhei.setText(plu.mListView2.get(position));
                        potw.closePopupWindow();

                    }
                });
                break;
            case R.id.ed_norm_muchyue:
                minitListView3 =plu.initListView3();
                potw.showPopupWindow(minitListView3,parientView,ed_norm_muchyue.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.240),(int)(GetScreenParam.getScreenHeight(this)*0.119));
                minitListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_norm_muchyue.setText(plu.mListView3.get(position));
                        potw.closePopupWindow();
                    }
                });
                break;
            case R.id.ed_muchtrend_strattime:
                dialog.show(dateAndTimeLabel);
                dialog.showTime();
                break;
            case R.id.ed_muchtrend_endtime:
                dialog.show(dateAndTime2);
                dialog.showTime();
                break;
            case R.id.ed_kuaijie_muchtime:
                // 初始化ListView控件和里边的数据
                minitListView2= plu.initListView();
                potw.showPopupWindow(minitListView2,parientView,ed_kuaijie_muchtime.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.407),(int)(GetScreenParam.getScreenHeight(this)*0.229));
                minitListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<String> list =time.showTimeShortcut();
                        if(position>=1) {
                            dateAndTimeLabel.setText(list.get(position * 2 - 2));
                            dateAndTime2.setText(list.get(position * 2 - 1));
                            ed_kuaijie_muchtime.setText(plu.mListView.get(position));
                         }
                        /**关闭popupwindow*/
                        potw.closePopupWindow();
                    }
                });
                break;
            case R.id.ed_trend_muchchan:
                /**发起网络请求*/
                showProgressDialog();
                HashMap<String, Object> prams5 = new HashMap<>();
                prams5.put("tableName","DAILY_WATER");
                HttpLoader.get(ConstantsYunZhiShui.URL_FINDBUCOM, prams5,
                        FindBuComBoxResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM, this, false).setTag(this);
                showProgressDialog();
                break;
            case R.id.quxiao:
                potw.closePopupWindow();
                break;
            case R.id.queding:
                /*for(int i=0;i<mAdapter.getIsSelected().size();i++){
                    if(mAdapter.getIsSelected().get(i).equals(true)){

                        Log.i("99999999", mFindBu.getData().getListTree().get(i).getBusinessUnitName());
                    }
                }*/
                for(int i=0;i<list.size();i++){
                    for(int j=0;j<mFindBu.getData().getListTree().size();j++){
                          if(list.get(i).equals(mFindBu.getData().getListTree().get(j).getBusinessUnitName())){
                              code += mFindBu.getData().getListTree().get(j).getBusinessUnitCode() + ",";
                          }
                    }
                    s +=list.get(i)+",";
                }
                ed_trend_muchchan.setText(s);
                Log.i("99999999", code);
                potw.closePopupWindow();

                break;
            case R.id.but_select_muchchan:
                /**查询*/
                String dateFrom=dateAndTimeLabel.getText().toString();
                String dateTo=dateAndTime2.getText().toString();
                String yue=ed_norm_muchyue.getText().toString();
                String chan= ed_trend_muchchan.getText().toString();
                String zhibao=ed_trend_muchzhibao.getText().toString();
                if("".equals(dateFrom)||"null".equals(dateFrom)||dateFrom==null){
                    Toast.makeText(MuchTrendLookActivity.this, "请选择开始时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(dateTo)||"null".equals(dateTo)||dateTo==null){
                    Toast.makeText(MuchTrendLookActivity.this, "请选择结束时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(chan)||"null".equals(chan)||chan==null){
                    Toast.makeText(MuchTrendLookActivity.this, "请选择厂站", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(zhibao)||"null".equals(zhibao)||zhibao==null){
                    Toast.makeText(MuchTrendLookActivity.this, "请选择指标", Toast.LENGTH_SHORT).show();
                    return;
                }
                psu.colsePopupWindow();
                if("请选择".equals(yue)){
                    indeFreq="0";
                }else if("日".equals(yue)){
                    indeFreq="day";
                }else if("月".equals(yue)){
                    indeFreq="mounth";
                }else if("年".equals(yue)){
                    indeFreq="year";
                }
                String heji=  ed_trend_muchhei.getText().toString();
                if("默认".equals(heji)){
                    ruleType="0";
                }else if("合计".equals(heji)){
                    ruleType="sum";
                }else if("平均".equals(heji)){
                    ruleType="avg";
                }

                if(("".equals(code)||"null".equals(code)||code==null)
                        ||("".equals(indeCode)||"null".equals(indeCode)||indeCode==null)||
                        ("".equals( indeFreq)||"null".equals( indeFreq)|| indeFreq==null)||
                        ("".equals( ruleType)||"null".equals(ruleType)|| ruleType==null)||
                        ("".equals(dateFrom)||"null".equals(dateFrom)|| dateFrom==null)||
                        ("".equals(dateTo)||"null".equals(dateTo)||  dateTo==null)||
                        ("".equals(code)||"null".equals(code)|| code==null)) {
                    Toast.makeText(MuchTrendLookActivity.this, "数据没有填写完整", Toast.LENGTH_SHORT).show();
                }else {
                    String code2 =code.substring(0, code.length() - 1);
                   showProgressDialog();
                    /**发起网络请求*/
                    HashMap<String, Object> prams = new HashMap<>();
                    prams.put("dateFrom", dateFrom);
                    prams.put("dateTo", dateTo);
                    prams.put("indeCode", indeCode);
                    prams.put("unitCode", code2);
                    prams.put("ruleType", ruleType);
                    prams.put("indeFreq", indeFreq);
                    HttpLoader.get(ConstantsYunZhiShui.URL_DCDANZ, prams,
                            MuchTrendResponse.class, ConstantsYunZhiShui.REQUEST_CODE_DCDANZ, this, false).setTag(this);
                    showProgressDialog();
                }
                break;
        }
    }
    private void showMuchTrend(){
        psu.showPopupSearch(getViews(),toolbar);
        parientView=toolbar;
        tv_muchtrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();

            }
        });
        ed_trend_muchzhibao.addTextChangedListener(this);
        ed_trend_muchhei.setText("默认");
        ed_norm_muchyue.setText("请选择");
        ed_trend_muchhei.setOnClickListener(this);
        ed_norm_muchyue.setOnClickListener(this);
        dateAndTimeLabel.setOnClickListener(this);
        ed_kuaijie_muchtime.setOnClickListener(this);
        but_select_muchchan.setOnClickListener(this);
        ed_trend_muchchan.setOnClickListener(this);
        dateAndTime2.setOnClickListener(this);
    }
    private View getView2(){
        View view=View.inflate(this,R.layout.listview_shuxing,null);
        mListViews= (ListView) view.findViewById(R.id.listView_shu);
        queding= (Button)view.findViewById(R.id.queding);
        quxiao= (Button) view.findViewById(R.id.quxiao);
        return view;
    }
    private void showMuchTrend2(){
                    /**弹出窗体*/
        potw.showPopupWindow2(getView2(), parientView, GetScreenParam.getScreenWidth(this),(int)(GetScreenParam.getScreenHeight(this)*0.8));
        queding.setOnClickListener(this);
        quxiao.setOnClickListener(this);
    }
    /*private ListView initListView4() {

        *//**发起网络请求*//*
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("tableName","DAILY_WATER");
        HttpLoader.get(ConstantsYunZhiShui.URL_FINDBUCOM, prams,
                FindBuComBoxResponse.class, ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM, this, false).setTag(this);
        return mListViews;
    }*/
    private ListView initListView5(String s) {
        ListView mListViews4 = new ListView(this);
        mListViews4.setDividerHeight(0);
        mListViews4.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews4.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        if(s==null||"".equals(s)||"null".equals("")){
            s="0";
        }
        prams.put("indeName",s);
        HttpLoader.get(ConstantsYunZhiShui.URL_LXINDE, prams,
                LxIndeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_LXINDE, this, false).setTag(this);
        return mListViews4;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_FINDBUCOM
                && response instanceof FindBuComBoxResponse) {
            mFindBu = (FindBuComBoxResponse) response;
            if("00000".equals(mFindBu.getErrorCode())) {
                dismissProgressDialog();
                showMuchTrend2();
                tlu.initDataText(mFindBu);
                try {
                    mAdapter = new SimpleTreeListViewAdapter15(mListViews, this,
                            tlu.mDatas2, 0);
                    mListViews.setAdapter(mAdapter);
                   //ListViewHeightUtils.setListViewHeight(mListViews);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                /*mListViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(mAdapter.getIsSelected().get(position)==true){
                            mAdapter.getIsSelected().put(position,false);
                            *//**将code存入*//*
                          //list.add(.getName());
                        }else {
                            mAdapter.getIsSelected().put(position, true);
                        }
                        mAdapter.notifyDataSetChanged();
                        Log.i("000000000",position+"");
                        //
                    }
                });*/
                mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter2.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        /*if(node.getLevel()>1){
                            if(node.isExpand()) {

                            }else{
                                list.remove(node.getName());
                                mAdapter.getIsSelected().put(position, false);
                            }
                        }else{*/
//                            if (mAdapter.getIsSelected().get(position) == true) {
//                                mAdapter.getIsSelected().put(position, false);
//                                list.remove(node.getName());
//                            } else {
//                                mAdapter.getIsSelected().put(position, true);
//                                list.add(node.getName());
//                            }
                        mAdapter.notifyDataSetChanged();
                    }
                });
              /*mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        if (node.isleaf()) {
                            if (!s.contains(node.getName())) {
                                s += node.getName() + ",";
                            }
                            ed_trend_muchchan.setText(s);
                            for (int i = 0; i < mFindBu.getData().getListTree().size(); i++) {
                                if (node.getName().equals(mFindBu.getData().getListTree().get(i).getBusinessUnitName())) {
                                    if (!code.contains(mFindBu.getData().getListTree().get(i).getBusinessUnitCode())) {
                                        code += mFindBu.getData().getListTree().get(i).getBusinessUnitCode() + ",";
                                    }
                                }
                            }
                        }
                    }
                });*/
            }
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_LXINDE
                && response instanceof LxIndeResponse){
            mLxinde= (LxIndeResponse) response;
            myAdapter5=new LxindeAdapter(mLxinde,this);
            minitListView5.setAdapter(myAdapter5);
            minitListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    i++;
                    potw.closePopupWindow();
                    ed_trend_muchzhibao.setText(mLxinde.getData().getIndeList().get(position).getIndeName());
                    indeCode = mLxinde.getData().getIndeList().get(position).getIndeCode();
                }
            });
        }
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_DCDANZ
                && response instanceof MuchTrendResponse){
                mMuchTrend=(MuchTrendResponse)response;
               dismissProgressDialog();
            if("00014".equals(mMuchTrend.getErrorCode())){
                Toast.makeText(MuchTrendLookActivity.this, "这个时间段没有数据", Toast.LENGTH_SHORT).show();
                psu.colsePopupWindow();
                return;
            }
            if("00000".equals(mMuchTrend.getErrorCode())){
                View view= ChartFactory.getLineChartView(this, initLineGraphView(), initRender());
                lin_bar_linear.addView(view);
                m++;
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
         /**EditText中数据改变的时候调用*/
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        minitListView5 =initListView5(s.toString());
        if(i!=1||"".equals(s.toString())) {
            potw.showPopupWindow(minitListView5,parientView,ed_trend_muchzhibao.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.24),(int)(GetScreenParam.getScreenHeight(this)*0.41));
        }
    }
    @Override
    public void afterTextChanged(Editable s) {
    }
    @Override
    protected void onStop() {
        super.onStop();
        HttpLoader.cancelRequest(this);
        potw.closePopupWindow();
    }
}
