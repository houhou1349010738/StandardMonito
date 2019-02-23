package com.smartwasser.yunzhishui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.ReimburseListResponse;
import com.smartwasser.yunzhishui.bean.ReimbursementResponse;
import com.smartwasser.yunzhishui.bean.SkContractResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.productionactivity.AccountingAuditActivity;
import com.smartwasser.yunzhishui.productionactivity.AuditDetailsActivity;
import com.smartwasser.yunzhishui.productionactivity.ReimburseDetailsActivity;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.view.RefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/7/20 0020.
 */
public class ReimburseFragment extends Fragment implements HttpLoader.ResponseListener{
    private ListView lsit_reimburse_audit;
    public int page=1;
    private  ReimbursementResponse  mReimbursement;
    private ReimburseAdapter  myAdapter;
    private int i=0;
    private  String ywlx,sqsj,sqdlx,xmmc,sqjd;
    private EventSearchResponse event;
    private ReimburseListResponse mReimburseList;
    private EventNormSelect ev=new EventNormSelect();

    private RefreshLayout myRefreshListView;
    private  int total;
    public boolean flag=false;
    public List<ReimbursementResponse.DataEntity.PayCostClaimEntity.RowsEntity> lists=new ArrayList<>();
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_audit,null);
        lsit_reimburse_audit= (ListView) view.findViewById(R.id.lsit_reimburse_audit);
        // 获取RefreshLayout实例
        myRefreshListView =(RefreshLayout)
                view.findViewById(R.id.swipe_layout);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().registerSticky(this);
          /* *请求网络*/
        /**
         * 设置下拉刷新的颜色
         */
        myRefreshListView.setColorSchemeResources(android.R.color.holo_blue_bright
                , android.R.color.holo_orange_light, android.R.color.holo_green_light,
                android.R.color.holo_blue_light
        );
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("nodeId", event.getNodeId());
        prams.put("flowCode", event.getFlowCode());
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERLIST, prams,
                ReimburseListResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERLIST, this, false).setTag(this);
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
               if("00000".equals(mReimburseList.getErrorCode())){
                       show(1);
               }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFILLFIND
                && response instanceof ReimbursementResponse) {
              mReimbursement = (ReimbursementResponse) response;
            if ("00000".equals(mReimbursement.getErrorCode())){
                if(!flag) {
                    total = mReimbursement.getData().getPayCostClaim().getTotal();
                }
                for(int j=0;j<mReimbursement.getData().getPayCostClaim().getRows().size();j++){
                    lists.add(mReimbursement.getData().getPayCostClaim().getRows().get(j));
                }
                lsit_reimburse_audit.setVisibility(View.VISIBLE);
                if( myAdapter ==null){
                    myAdapter = new ReimburseAdapter();
                    lsit_reimburse_audit.setAdapter(myAdapter);
                }else{
                    myAdapter.notifyDataSetChanged();
                }
                myRefreshListView.setRefreshing(false);
                myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mReimbursement= null;
                                page=1;
                                flag = true;
                                lists.clear();
                                lsit_reimburse_audit.setVisibility(View.GONE);
                                show(page);
                            }
                        },1000);
                    }
                });
                // 加载监听器
                myRefreshListView.setOnLoadListener(new RefreshLayout.OnLoadListener() {
                    @Override
                    public void onLoad() {
                        myRefreshListView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadData();
                                flag=false;
                                myRefreshListView.setLoading(false);
                            }
                        }, 2000);

                    }
                });
                lsit_reimburse_audit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        /**跳转到AuditDetail*/
                        if( mReimburseList.getData().getExamineState().equals(lists.get(position).getEXAMINE_STATE())&& mReimburseList.getData().getUserName().equals(lists.get(position).getCLAIM_USER())){
                            if(event.isFlag()){
                                ev.setClaimId(lists.get(position).getCLAIM_ID());
                                ev.setUnitName(lists.get(position).getUNIT_NAME());
                                EventBus.getDefault().postSticky(ev);
                                Intent intent=new Intent(getActivity(),AccountingAuditActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getActivity().startActivity(intent);
                            }else {
                                ev.setClaimId(lists.get(position).getCLAIM_ID());
                                ev.setUnitName(lists.get(position).getUNIT_NAME());
                                EventBus.getDefault().postSticky(ev);
                                Intent intent = new Intent(getActivity(), AuditDetailsActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getActivity().startActivity(intent);
                            }
                        }else{
                            /**跳到详情页*/
                            ev.setClaimId(lists.get(position).getCLAIM_ID());
                            ev.setUnitName(lists.get(position).getUNIT_NAME());
                            ev.setUserName(mReimburseList.getData().getUserName());
                            ev.setExamineState(mReimburseList.getData().getExamineState());
                            Intent intent = new Intent(getActivity(), ReimburseDetailsActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getActivity().startActivity(intent);
                        }
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
            return lists.size();
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
            String s2=lists.get(position).getSCOPETYPE_ID();
            String m = "";
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
            holder.tv_reimburse_type.setText(lists.get(position).getEXAMINE_STATE());
            if("通过".equals(lists.get(position).getEXAMINE_STATE())){
                holder.tv_reimburse_type.setTextColor(Color.parseColor("#4ad261"));
            }else{
                holder.tv_reimburse_type.setTextColor(Color.parseColor("#ff8200"));
            }
            holder.tv_reimburse_je.setText("金额:"+"￥"+lists.get(position).getCLAIM_SUM());
            holder.tv_reimburse_xmmc.setText(lists.get(position).getUNIT_NAME());
            holder.tv_reimburse_rqr.setText("申请人:"+lists.get(position).getCLAIM_REALUSER());
            holder.tv_reimburse_ywlx.setText(lists.get(position).getCLAIMTYPE_ID());
            holder.tv_reimburse_sqrq.setText(lists.get(position).getCLAIM_TIME());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv_reimburse_bxdlb,tv_reimburse_type,tv_reimburse_je
                ,tv_reimburse_xmmc,tv_reimburse_rqr,tv_reimburse_ywlx,tv_reimburse_sqrq;
    }
    private void  loadData(){
        ++page;
        if((total+10)>(page*10)) {
            myRefreshListView.pull_to_refresh_loadmore_text.setText("玩命加载中");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.VISIBLE);
            show(page);
        }else{
            myRefreshListView.pull_to_refresh_loadmore_text.setText("没有更多数据了.....");
            myRefreshListView.pull_to_refresh_load_progress.setVisibility(View.GONE);
        }
    }
    public void setPraments(String s,String s2,String s3,String s4,String s5){
        sqjd=s2;
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
        sqjd="";
    }
    public void onEvent(EventSearchResponse event){
        this.event=event;
    }
    public void show(int page){
        HashMap<String, Object> prams2 = new HashMap<>();
        if (!"".equals(ywlx) && !"null".equals(ywlx) && ywlx != null) {
            prams2.put("claimtypeId", ywlx);
        }
        if (!"".equals(sqjd) && !"null".equals(sqjd) && sqjd != null) {
            prams2.put("examineState", sqjd);
        }
        if (!"".equals(sqsj) && !"null".equals(sqsj) && sqsj != null) {
            prams2.put("claimTime", sqsj);
        }
        if (!"".equals(xmmc) && !"null".equals(xmmc) && xmmc != null) {
            prams2.put("claimDep", xmmc);
        }
        if (!"".equals(sqdlx) && !"null".equals(sqdlx) && sqdlx != null) {
            prams2.put("scopetypeId", sqdlx);
        }
        prams2.put("page", page);
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERFILLFIND, prams2,

                ReimbursementResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERFILLFIND, this, false).setTag(this);
    }
}
