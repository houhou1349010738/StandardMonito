package com.smartwasser.yunzhishui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.ReimburseListResponse;
import com.smartwasser.yunzhishui.bean.ReimbursementResponse;
import com.smartwasser.yunzhishui.bean.ZnbmListResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.productionactivity.AuditDetailsActivity;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/28 0028.
 */
public class FfgiLeadFragment extends Fragment implements HttpLoader.ResponseListener,AbsListView.OnScrollListener{
    private ListView lsit_reimburse_audit;
    private int page=1;
    private ZnbmListResponse mReimbursement;
    public ReimburseAdapter  myAdapter;
    private ReimburseListResponse mReimburseList;
    private ImageButton loadMoreButton;
    private int visibleLastIndex =0;//最后的可视项索引
    private int visibleItemCount;// 当前窗口可见项总数
    private View loadMoreView;
    private  String ywlx,sqsj,sqdlx,xmmc;
    private EventSearchResponse event;
    private EventNormSelect ev=new EventNormSelect();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_audit,null);
        lsit_reimburse_audit= (ListView) view.findViewById(R.id.lsit_reimburse_audit);
        loadMoreView=view.inflate(getActivity(), R.layout.load_more, null);
        loadMoreButton =(ImageButton)loadMoreView.findViewById(R.id.loadMoreButton);
        lsit_reimburse_audit.addFooterView(loadMoreView);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().registerSticky(this);
        lsit_reimburse_audit.setOnScrollListener(this);
         /* *请求网络*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("nodeId",event.getNodeId());
        prams.put("flowCode",event.getFlowCode());
      //  Log.i("22222222",event.getNodeId()+"------"+event.getFlowCode());
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERLIST, prams,
                ReimburseListResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERLIST, this, false).setTag(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMoreButton.setVisibility(View.INVISIBLE);   //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        //数据集变化后,通知adapter
                        lsit_reimburse_audit.setSelection(visibleLastIndex - visibleItemCount + 1); //设置选中项
                        loadMoreButton.setVisibility(View.VISIBLE);    //恢复按钮文字
                    }
                }, 2000);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERLIST
                && response instanceof ReimburseListResponse) {
            mReimburseList = (ReimburseListResponse) response;
            if("00000".equals(mReimburseList.getErrorCode())) {
                HashMap<String, Object> prams2 = new HashMap<>();
                prams2.put("page", page);
                if(!"".equals(ywlx)&&!"null".equals(ywlx)&&ywlx!=null){
                    prams2.put("claimtypeId",ywlx);
                }
                if(!"".equals(sqsj)&&!"null".equals(sqsj)&&sqsj!=null){
                    prams2.put("claimTime",sqsj);
                }
                if(!"".equals(xmmc)&&!"null".equals(xmmc)&&xmmc!=null){
                    prams2.put("claimDep",xmmc);
                }
                if(!"".equals(sqdlx)&&!"null".equals(sqdlx)&&sqdlx!=null) {
                    prams2.put("scopetypeId",sqdlx);
                }
                prams2.put("nodeId",event.getNodeId());
                prams2.put("examineState", mReimburseList.getData().getExamineState());
                HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFGLDFIND, prams2,
                       ZnbmListResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFGLDFIND,this, false).setTag(this);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFGLDFIND
                && response instanceof  ZnbmListResponse) {
            mReimbursement = (ZnbmListResponse) response;
           //Log.i("3333333",mReimbursement.getData().getPayCostClaim().getRows().size()+"");
            if ("00000".equals(mReimbursement.getErrorCode())) {
                myAdapter = new ReimburseAdapter();
                lsit_reimburse_audit.setAdapter(myAdapter);
                lsit_reimburse_audit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ev.setClaimId(mReimbursement.getData().getPayCostClaim().getRows().get(position).getCLAIM_ID());
                        ev.setUnitName(mReimbursement.getData().getPayCostClaim().getRows().get(position).getUNIT_NAME());
                       /* Log.i("3333333", mReimbursement.getData().getPayCostClaim().getRows().get(position).getCLAIM_ID()
                                + "-------" + mReimbursement.getData().getPayCostClaim().getRows().get(position).getUNIT_NAME());*/
                        ev.setZnbmFlag(true);
                        String s=mReimbursement.getData().getPayCostClaim().getRows().get(position).getID2();
                       /* Log.i("2222222222",s+"");*/
                        if(s!=null){
                            ev.setId2(s);
                        }
                        EventBus.getDefault().postSticky(ev);
                        Intent intent = new Intent(getActivity(), AuditDetailsActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(intent);
                    }
                });
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {

    }
    class ReimburseAdapter extends BaseAdapter {
        @Override
        public int getCount(){
            return mReimbursement.getData().getPayCostClaim().getRows().size();
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
                convertView=View.inflate(getActivity(),R.layout.item_reimburse,null);
                holder=new ViewHolder();
                holder.tv_reimburse_bxdlb= (TextView) convertView.findViewById(R.id.tv_reimburse_bxdlb);
                holder.tv_reimburse_type= (TextView) convertView.findViewById(R.id.tv_reimburse_type);
                holder.tv_reimburse_je= (TextView) convertView.findViewById(R.id.tv_reimburse_je);
                holder.tv_reimburse_xmmc= (TextView) convertView.findViewById(R.id.tv_reimburse_xmmc);
                holder.tv_reimburse_rqr= (TextView) convertView.findViewById(R.id.tv_reimburse_rqr);
                holder.tv_reimburse_ywlx= (TextView) convertView.findViewById(R.id.tv_reimburse_ywlx);
                holder.tv_reimburse_sqrq= (TextView) convertView.findViewById(R.id.tv_reimburse_sqrq);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            String s2=mReimbursement.getData().getPayCostClaim().getRows().get(position).getSCOPETYPE_ID();
            String m="";
            if(s2.equals("JKD")){
                m="借款单";
            }else if(s2.equals("ZCBXD")){
                m="支出报销单";
            }else if(s2.equals("QTYSZCBXD")){
                m="其他预算支出报销单";
            }else if(s2.equals("ZPLYD")){
                m="支票领用单";
            }else if(s2.equals("WGCCBXD")){
                m="外埠出差报销单";
            }else if(s2.equals("XJZCBXD")){
                m="现金支出报销单";
            }
            holder.tv_reimburse_bxdlb.setText(m);
            holder.tv_reimburse_type.setText(mReimbursement.getData().getPayCostClaim().getRows().get(position).getEXAMINE_STATE());
            if("通过".equals(mReimbursement.getData().getPayCostClaim().getRows().get(position).getEXAMINE_STATE())){
                holder.tv_reimburse_type.setTextColor(Color.parseColor("#4ad261"));
            }else{
                holder.tv_reimburse_type.setTextColor(Color.parseColor("#ff8200"));
            }
            holder.tv_reimburse_je.setText("金额:"+"￥"+mReimbursement.getData().getPayCostClaim().getRows().get(position).getCLAIM_SUM());
            holder.tv_reimburse_xmmc.setText(mReimbursement.getData().getPayCostClaim().getRows().get(position).getUNIT_NAME());
            holder.tv_reimburse_rqr.setText("申请人:"+mReimbursement.getData().getPayCostClaim().getRows().get(position).getCLAIM_REALUSER());
            holder.tv_reimburse_ywlx.setText(mReimbursement.getData().getPayCostClaim().getRows().get(position).getCLAIMTYPE_ID());
            holder.tv_reimburse_sqrq.setText(mReimbursement.getData().getPayCostClaim().getRows().get(position).getCLAIM_TIME());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_reimburse_bxdlb,tv_reimburse_type,tv_reimburse_je
                ,tv_reimburse_xmmc,tv_reimburse_rqr,tv_reimburse_ywlx,tv_reimburse_sqrq;
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int  itemsLastIndex = myAdapter.getCount()-1;//数据集最后一项的索引
        int  lastIndex =itemsLastIndex + 1;        //加上底部的loadMoreView项
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex) {
            //如果是自动加载,可以在这里放置异步加载数据的代码
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }
    private void  loadData(){
        ++page;
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("page", page);
        prams.put("examineState",mReimburseList.getData().getExamineState());
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFILLFIND, prams,
                ReimbursementResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFILLFIND, this, false).setTag(this);
    }
    public void setPrams(String s,String s3,String s4,String s5){
        ywlx=s;
        sqsj=s3;
        sqdlx=s4;
        xmmc=s5;
    }

    @Override
    public void onStop() {
        super.onStop();
        ywlx="";
        sqsj="";
        sqdlx="";
        xmmc="";
    }
    public void onEvent(EventSearchResponse event){
        this.event=event;
    }
}
