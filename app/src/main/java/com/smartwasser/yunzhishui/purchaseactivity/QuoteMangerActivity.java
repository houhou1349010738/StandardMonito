package com.smartwasser.yunzhishui.purchaseactivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EnlistListResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.QuoteResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.GetScreenParam;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupSearchUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowTwoUtil;
import com.smartwasser.yunzhishui.utils.TimeUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class QuoteMangerActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ImageButton button_fan,image_add,image_serc;
    private  int page=1;
    private QuoteResponse mQuote;
    private ListView list_quote;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private View loadMoreView;
    private ListView minitListView2;
    private QuoteListAdapter mQuoteAdapter;
    private PopListViewUtils plu=new PopListViewUtils(this);
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private PopupWindowTwoUtil potw=new PopupWindowTwoUtil();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    /**搜索*/
    private EditText ed_xmbh,ed_xmmc,ed_xzrq,
            ed_jsrq, ed_kj;
    private ImageButton image_enlist_startTiem
            ,image_enlist_endTiem, image_kj;
    private Button but_enlist_search,but_enlist_chongzhi;
    private TextView tv_ledgerser;
    private Toolbar toolbar;
    private View parientView;
    private String xmbh, xmmc,start,end;
    private PopupSearchUtils psu=new PopupSearchUtils(this);
    private TimeUtils time=new TimeUtils();
    private EventNormSelect event=new EventNormSelect();
    private int i=0;
    @Override
    protected int initContentView() {
        return R.layout.activity_quote_manage;
    }
    @Override
    protected void initView() {
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        button_fan.setBackgroundResource(R.drawable.fanhu);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_add.setVisibility(View.GONE);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        list_quote= (ListView) findViewById(R.id.list_quote);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        loadMoreView=View.inflate(this, R.layout.load_more, null);
        loadMoreButton = (ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        list_quote.addFooterView(loadMoreView);
    }
    @Override
    protected void initListener() {
        list_quote.setOnScrollListener(this);
        button_fan.setOnClickListener(this);
        image_serc.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar_zhu.setText("采购管理");
        tv_toolbar_centext.setText("报价管理");
        /**调用校验接口*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEQUOTELIST, prams,
                QuoteResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUOTELIST, this, false).setTag(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        list_quote.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_fan:
                finish();
                break;
            case R.id.image_serc:
                /**弹出搜索界面*/
                showMuchTrend();
                break;
            case R.id.ed_xzrq:
                /**开始时间*/
                dialog.show(ed_xzrq);
                dialog.showTime();
                break;
            case R.id.ed_weight_endTime:
                /**结束时间*/
                dialog.show(ed_jsrq);
                dialog.showTime();
                break;
            case R.id. ed_kj:
                /**快捷时间*/
                // 初始化ListView控件和里边的数据
                minitListView2= plu.initListView();
                potw.showPopupWindow(minitListView2,parientView, ed_kj.getWidth()-4,(int)(GetScreenParam.getScreenWidth(this)*0.407),(int)(GetScreenParam.getScreenHeight(this)*0.229));
                minitListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<String> list =time.showTimeShortcut();
                        if(position>=1) {
                            ed_xzrq.setText(list.get(position * 2 - 2));
                            ed_jsrq.setText(list.get(position * 2 - 1));
                            ed_kj.setText(plu.mListView.get(position));
                        }
                        /**关闭popupwindow*/
                        potw.closePopupWindow();
                    }
                });
                break;
            case R.id.but_enlist_chongzhi:
                /**重置,将数据清空*/
                ed_xmbh.setText("");
                ed_xmmc.setText("");
                ed_xzrq.setText("");
                ed_jsrq.setText("");
                ed_kj.setText("");
                break;
            case R.id.but_enlist_search:
                /**查询*/
                psu.colsePopupWindow();
                HashMap<String, Object> prams = new HashMap<>();
                xmbh=ed_xmbh.getText().toString();
                xmmc=ed_xmmc.getText().toString();
                start=ed_xzrq.getText().toString();
                end=ed_jsrq.getText().toString();
                if(!"".equals(xmbh)&&!"null".equals(xmbh)&&xmbh!=null){
                    prams.put("projCode", xmbh);
                }
                if(!"".equals(xmmc)&&!"null".equals(xmmc)&&xmmc!=null){
                    prams.put("projName", xmbh);
                }
                if(!"".equals(start)&&!"null".equals(start)&&start!=null){
                    prams.put("startTime1", start);
                }
                if(!"".equals(end)&&!"null".equals(end)&&end!=null){
                    prams.put("startTime2",end);
                }
                prams.put("page", page);
                HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEQUOTELIST, prams,
                       QuoteResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUOTELIST, this, false).setTag(this);
                break;
        }
    }
    private View getView(){
        View view=View.inflate(this,R.layout.popup_enlist,null);
        ed_xmbh= (EditText) view.findViewById(R.id.ed_xmbh);
        ed_xmmc= (EditText) view.findViewById(R.id.ed_xmmc);
        ed_xzrq= (EditText) view.findViewById(R.id.ed_xzrq);
        ed_jsrq= (EditText) view.findViewById(R.id.ed_jsrq);
        ed_kj= (EditText) view.findViewById(R.id. ed_kj);
        image_enlist_startTiem= (ImageButton) view.findViewById(R.id.image_enlist_startTiem);
        image_enlist_endTiem=(ImageButton) view.findViewById(R.id.image_enlist_endTiem);
        image_kj=(ImageButton) view.findViewById(R.id.image_kj);
        but_enlist_search= (Button) view.findViewById(R.id.but_enlist_search);
        but_enlist_chongzhi= (Button) view.findViewById(R.id. but_enlist_chongzhi);
        tv_ledgerser= (TextView)view.findViewById(R.id.tv_ledgerser);
        return view;
    }

    private void showMuchTrend(){
        psu.showPopupSearch(getView(), toolbar);
        parientView= toolbar;
        tv_ledgerser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psu.colsePopupWindow();
            }
        });
        ed_xzrq.setOnClickListener(this);
        ed_jsrq.setOnClickListener(this);
        ed_kj.setOnClickListener(this);
        but_enlist_search.setOnClickListener(this);
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUOTELIST
                && response instanceof QuoteResponse) {
            mQuote = (QuoteResponse) response;
            if("00000".equals( mQuote.getErrorCode())){
                /**请求成功设置适配器*/
                mQuoteAdapter=new QuoteListAdapter();
                list_quote.setAdapter( mQuoteAdapter);
                if(i!=0){
                    psu.colsePopupWindow();
                }
                list_quote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        event.setEnlistId(mQuote.getData().getQuoteList().getRows().get(position).getId());
                        EventBus.getDefault().postSticky(event);
                        Intent intent=new Intent(QuoteMangerActivity.this,QuoteDetailActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int  itemsLastIndex = mQuoteAdapter.getCount()-1;//数据集最后一项的索引
        int  lastIndex =itemsLastIndex + 1;        //加上底部的loadMoreView项
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex) {
            //如果是自动加载,可以在这里放置异步加载数据的代码
            Log.i("LOADMORE", "loading...");
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }
    private void  loadData(){
        ++page;
        /**调用校验接口*/
        HashMap<String, Object> prams = new HashMap<>();
        if(!"".equals(xmbh)&&!"null".equals(xmbh)&&xmbh!=null){
            prams.put("projCode", xmbh);
        }
        if(!"".equals(xmmc)&&!"null".equals(xmmc)&&xmmc!=null){
            prams.put("projName", xmbh);
        }
        if(!"".equals(start)&&!"null".equals(start)&&start!=null){
            prams.put("startTime1", start);
        }
        if(!"".equals(end)&&!"null".equals(end)&&end!=null){
            prams.put("startTime2",end);
        }
        prams.put("page", page);
        /**把搜索条件加上*/
        HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEQUOTELIST, prams,
               QuoteResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUOTELIST, this, false).setTag(this);
    }
    class QuoteListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mQuote.getData().getQuoteList().getRows().size();
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
            if(convertView==null){
                convertView=View.inflate(QuoteMangerActivity.this,R.layout.item_quote,null);
                holder=new ViewHolder();
                holder.tv_quote_bh= (TextView) convertView.findViewById(R.id.tv_quote_bh);
                holder.tv_quote_xmmc= (TextView) convertView.findViewById(R.id.tv_quote_xmmc);
                holder.tv_quote_cgdw= (TextView) convertView.findViewById(R.id.tv_quote_cgdw);
                holder.tv_quote_jjq= (TextView) convertView.findViewById(R.id.tv_quote_jjq);

                holder.tv_quote_dshbj= (TextView) convertView.findViewById(R.id.tv_quote_dshbj);
                holder.tv_quote_wbj= (TextView) convertView.findViewById(R.id.tv_quote_wbj);
                holder.tv_quote_zzyxbj= (TextView) convertView.findViewById(R.id.tv_quote_zzyxbj);
                holder.tv_quote_yxbj= (TextView) convertView.findViewById(R.id.tv_quote_yxbj);
                holder.tv_quote_wxbj= (TextView) convertView.findViewById(R.id.tv_quote_wxbj);
                holder.tv_quote_zzwxbj= (TextView) convertView.findViewById(R.id.tv_quote_zzwxbj);
                holder.tv_quote_zzdshbj= (TextView) convertView.findViewById(R.id.tv_quote_zzdshbj);
                holder.tv_quote_zzwbj= (TextView) convertView.findViewById(R.id.tv_quote_zzwbj);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            holder.tv_quote_bh.setText(mQuote.getData().getQuoteList().getRows().get(position).getProjCode());
            holder.tv_quote_xmmc.setText("项目名称:"+"        "+mQuote.getData().getQuoteList().getRows().get(position).getProjName());
            holder.tv_quote_cgdw.setText("采购单位:"+"        "+mQuote.getData().getQuoteList().getRows().get(position).getPurchaseUnit());
            holder.tv_quote_jjq.setText("竞价期:"+"        "+mQuote.getData().getQuoteList().getRows().get(position).getNoticeStartTime()
                    +"至"+mQuote.getData().getQuoteList().getRows().get(position).getNoticeEndTime());
            holder.tv_quote_yxbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getYxbj());
            holder.tv_quote_wxbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getWxbj());
            holder.tv_quote_dshbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getDsh());
            holder.tv_quote_wbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getWbj());
            holder.tv_quote_zzyxbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getDshyxbj());
            holder.tv_quote_zzwxbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getDshwxbj());
            holder.tv_quote_zzdshbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getDshbj());
            holder.tv_quote_zzwbj.setText(mQuote.getData().getQuoteList().getRows().get(position).getDshwbj());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_quote_bh,tv_quote_xmmc,tv_quote_cgdw
                ,tv_quote_jjq,tv_quote_yxbj,tv_quote_wxbj
                ,tv_quote_dshbj,tv_quote_wbj,tv_quote_zzyxbj
                ,tv_quote_zzwxbj,tv_quote_zzdshbj,tv_quote_zzwbj;
    }
}