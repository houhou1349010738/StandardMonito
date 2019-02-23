package com.smartwasser.yunzhishui.deviceactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.HitchBuweiResponse;
import com.smartwasser.yunzhishui.bean.HitchSaveResponse;
import com.smartwasser.yunzhishui.bean.HitchTypeResponse;
import com.smartwasser.yunzhishui.bean.HitchUpdateSaveResponse;
import com.smartwasser.yunzhishui.bean.HttchQueWeiResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/7 0007.
 */
public class HitchUpdateActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
    private EventSearchResponse event;
    private HttchQueWeiResponse mQueRen;
    private ImageButton image_add_guzhan_starttime;
    private ImageButton image_add_guzhan_leibie,image_add_guzhan_buwei;
    private EditText ed_add_guzhan_starttime,ed_add_guzhan_endtime;
    private ImageButton image_add_guzhan_endtime;
    private Button but_bianji;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private HitchSaveResponse mHitchSave;
    private EditText ed_add_shebei_name,ed_add_shiyong_danwei;
    private ImageButton button_qinxz,button_gzhanxx;
    private HitchTypeResponse mHitchType;
    private ListView minlistView;
    private EditText ed_add_guzhan_leibie,ed_add_guzhan_buwei;
    private SimpleTreeListViewAdapter3 mAdapter;
    private ListView minlistView2;
    private String code="";
    private TreeListUtils tlu=new TreeListUtils();
    private HitchBuweiResponse mHitchBuwei;
    private MyAdapter myAdapter;
    private EditText ed_add_guzhan_xianxiang;
    private List<String> list=new ArrayList<String>();
    private List<String> list2=new ArrayList<String>();
    private EventNormSelect sss=new EventNormSelect();
    private String codes="";
    private EditText ed_add_guzhan_jcff,ed_add_guzhan_yuanying,ed_add_guzhan_clff,ed_add_guzhan_bgbz;
    @Override
    protected int initContentView() {
        return R.layout.activity_addhitch;
    }
    @Override
    protected void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_qinxz= (ImageButton) findViewById(R.id.button_qinxz);
        ed_add_guzhan_buwei= (EditText) findViewById(R.id.ed_add_guzhan_buwei);
        image_add_guzhan_buwei= (ImageButton) findViewById(R.id.image_add_guzhan_buwei);
        ed_add_guzhan_leibie= (EditText) findViewById(R.id.ed_add_guzhan_leibie);
        ed_add_shebei_name= (EditText)findViewById(R.id.ed_add_shebei_name);
        button_gzhanxx= (ImageButton) findViewById(R.id.button_gzhanxx);
        image_add_guzhan_leibie= (ImageButton) findViewById(R.id.image_add_guzhan_leibie);
        ed_add_shiyong_danwei= (EditText) findViewById(R.id.ed_add_shiyong_danwei);
        ed_add_guzhan_starttime= (EditText) findViewById(R.id.ed_add_guzhan_starttimes);
        ed_add_guzhan_endtime= (EditText) findViewById(R.id.ed_add_guzhan_endtimes);
        image_add_guzhan_starttime= (ImageButton) findViewById(R.id.image_add_guzhan_starttime);
        image_add_guzhan_endtime= (ImageButton) findViewById(R.id.image_add_guzhan_endtime);
        ed_add_guzhan_xianxiang= (EditText) findViewById(R.id.ed_add_guzhan_xianxiang);
        but_bianji= (Button) findViewById(R.id.but_bianji);
        ed_add_guzhan_jcff= (EditText) findViewById(R.id.ed_add_guzhan_jcff);
        ed_add_guzhan_yuanying= (EditText) findViewById(R.id.ed_add_guzhan_yuanying);
        ed_add_guzhan_clff= (EditText) findViewById(R.id.ed_add_guzhan_clff);
        ed_add_guzhan_bgbz= (EditText) findViewById(R.id.ed_add_guzhan_bgbz);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        button_menu.setOnClickListener(this);
        ed_add_guzhan_starttime.setOnClickListener(this);
        ed_add_guzhan_endtime.setOnClickListener(this);
        button_qinxz.setOnClickListener(this);
        button_gzhanxx.setOnClickListener(this);
        but_bianji.setOnClickListener(this);
        ed_add_guzhan_leibie.setOnClickListener(this);
        ed_add_guzhan_buwei.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        button_menu.setBackgroundResource(R.drawable.fanhu);
        tv_toolbar.setText("故障信息修改");
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", event.getUpdateId());
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZQRW, params,HttchQueWeiResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SBGZQRW, this, false).setTag(this);
        if(event!=null){
            if(event.getX()!=1){
                if(event.getTempAdd()==1){
                    ed_add_shebei_name.setText(event.getSbName());
                    ed_add_shiyong_danwei.setText(event.getSbDanwei());
                    ed_add_guzhan_xianxiang.setText(event.getmList().get(8));
                    ed_add_guzhan_leibie.setText(event.getmList().get(0));
                    ed_add_guzhan_buwei.setText(event.getmList().get(1));
                    ed_add_guzhan_starttime.setText(event.getmList().get(2));
                    ed_add_guzhan_endtime.setText(event.getmList().get(3));
                    ed_add_guzhan_jcff.setText(event.getmList().get(4));
                    ed_add_guzhan_yuanying.setText(event.getmList().get(5));
                    ed_add_guzhan_clff.setText(event.getmList().get(6));
                    ed_add_guzhan_bgbz.setText(event.getmList().get(7));
                }else if(event.getTempAdd()==2){
                    ed_add_shebei_name.setText(event.getmList2().get(0));
                    ed_add_shiyong_danwei.setText(event.getmList2().get(1));
                    ed_add_guzhan_leibie.setText(event.getmList2().get(2));
                    ed_add_guzhan_buwei.setText(event.getmList2().get(3));
                    ed_add_guzhan_starttime.setText(event.getmList2().get(4));
                    ed_add_guzhan_endtime.setText(event.getmList2().get(5));
                    ed_add_guzhan_jcff.setText(event.getmList2().get(6));
                    ed_add_guzhan_clff.setText(event.getmList2().get(7));
                    ed_add_guzhan_bgbz.setText(event.getmList2().get(8));
                    ed_add_guzhan_xianxiang.setText(event.getPhenomen());
                }
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_menu:
                finish();
                break;
            case R.id.ed_add_guzhan_starttimes:
                dialog.show(ed_add_guzhan_starttime);
                dialog.showTime();
                break;
            case R.id.ed_add_guzhan_endtimes:
                dialog.show(ed_add_guzhan_endtime);
                dialog.showTime();
                break;
            case R.id.button_qinxz:
                /**跳转到设备选择页面*/
                String leibie2=ed_add_guzhan_leibie.getText().toString();
                String buwei2=ed_add_guzhan_buwei.getText().toString();
                String start2=ed_add_guzhan_starttime.getText().toString();
                String end2=ed_add_guzhan_endtime.getText().toString();
                String jcff2=ed_add_guzhan_jcff.getText().toString();
                String yuanying2=ed_add_guzhan_yuanying.getText().toString();
                String  clff2=ed_add_guzhan_clff.getText().toString();
                String  bz2=ed_add_guzhan_bgbz.getText().toString();
                String  xianx=ed_add_guzhan_xianxiang.getText().toString();
                list.add(leibie2);
                list.add(buwei2);
                list.add(start2);
                list.add(end2);
                list.add(jcff2);
                list.add(yuanying2);
                list.add(clff2);
                list.add(bz2);
                list.add(xianx);
                int temp=1;
                sss.setTemp(temp);
                sss.setList(list);
                sss.setGxId(mQueRen.getData().getEqFailure().getFailureId());
                EventBus.getDefault().postSticky(sss);
                Intent intent=new Intent(HitchUpdateActivity.this,EquipSelectActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.button_gzhanxx:
                String name2=ed_add_shebei_name.getText().toString();
                String danwei=ed_add_shiyong_danwei.getText().toString();
                String leibie=ed_add_guzhan_leibie.getText().toString();
                String buwei=ed_add_guzhan_buwei.getText().toString();
                String start=ed_add_guzhan_starttime.getText().toString();
                String end=ed_add_guzhan_endtime.getText().toString();
                String jcff=ed_add_guzhan_jcff.getText().toString();
                String yuanying=ed_add_guzhan_yuanying.getText().toString();
                String  clff=ed_add_guzhan_clff.getText().toString();
                String  bz=ed_add_guzhan_bgbz.getText().toString();
                list2.add(name2);
                list2.add(danwei);
                list2.add(leibie);
                list2.add(buwei);
                list2.add(start);
                list2.add(end);
                list2.add(jcff);
                list2.add(yuanying);
                list2.add(clff);
                list2.add(bz);
                sss.setList2(list2);
                sss.setHitcUpdatehCode(event.getSbNameCode());
                sss.setGxId(mQueRen.getData().getEqFailure().getFailureId());
                EventBus.getDefault().postSticky(sss);
                Intent intent2=new Intent(HitchUpdateActivity.this,PhenomenaActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.ed_add_guzhan_leibie:
                /**点击故障类别*/
                minlistView=initListView();
                PopupWindowUtils.showPopupWindow(minlistView, ed_add_guzhan_leibie);
                break;
            case R.id.ed_add_guzhan_buwei:
                minlistView2=initListView2();
                PopupWindowUtils.showPopupWindow(minlistView2, ed_add_guzhan_buwei);
                break;
            case R.id.but_bianji:
                /**保存*/
                HashMap<String, Object> params = new HashMap<>();
                params.put("failureId",event.getUpdateId());
                String name= ed_add_shebei_name.getText().toString();
                String ownDept=ed_add_shiyong_danwei.getText().toString();
                String tbType=ed_add_guzhan_leibie.getText().toString();
                String part=ed_add_guzhan_buwei.getText().toString();
                String sdate=ed_add_guzhan_starttime.getText().toString();
                String edate=ed_add_guzhan_endtime.getText().toString();
                String appear=ed_add_guzhan_xianxiang.getText().toString();
                String method=ed_add_guzhan_jcff.getText().toString();
                String reason=ed_add_guzhan_yuanying.getText().toString();
                String deal=ed_add_guzhan_clff.getText().toString();
                String remark=ed_add_guzhan_bgbz.getText().toString();
                if("".equals(name)||"".equals(ownDept)||"".equals(tbType)
                        ||"".equals(part)||"".equals(sdate)||"".equals(edate)||
                        "".equals(appear)||"".equals(method)||"".equals(reason)||
                        "".equals(deal)||"".equals(remark)){
                    Toast.makeText(HitchUpdateActivity.this, "数据填写不完整,无法保存", Toast.LENGTH_SHORT).show();
                    return;
                }
                String sCode=event.getMhitchCode();
                if("".equals(sCode)||sCode==null||"null".equals(sCode)){
                    sCode=code;
                }
                String s2Code=event.getMhitchCodebuwei();
                if("".equals(s2Code)||s2Code==null||"null".equals(s2Code)){
                    s2Code=codes;
                }
                params.put("equipName",name);
                params.put("equipCode",event.getSbNameCode());
                params.put("equipOwnDept",ownDept);
                params.put("failureTbType", sCode);
                params.put("failurePart",s2Code );
                params.put("Sdate",sdate);
                params.put("Edate",edate);
                params.put("failureAppear",appear);
                params.put("checkMethod",method);
                params.put("failureReason",reason);
                params.put("failureDeal",deal);
                params.put("failureRemark",remark);
                HttpLoader.get(ConstantsYunZhiShui.URL_SBGZUPDATESAVE, params,HitchUpdateSaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_SBGZUPDATESAVE,this,false).setTag(this);
                break;
        }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZQRW
                && response instanceof HttchQueWeiResponse) {
              mQueRen = (HttchQueWeiResponse) response;
                     /**拿到数据赋值*/
            if(event.getSbName()==null||"".equals(event.getSbName())) {
                ed_add_shebei_name.setText(mQueRen.getData().getEqFailure().getEquipName());
                ed_add_shiyong_danwei.setText(mQueRen.getData().getEqFailure().getEquipOwnDept());
            }
            ed_add_guzhan_buwei.setText(event.getBuwei());
            ed_add_guzhan_leibie.setText(event.getLeibei());
            ed_add_guzhan_starttime.setText(mQueRen.getData().getEqFailure().getFailureSdate().substring(0,10));
            ed_add_guzhan_endtime.setText(mQueRen.getData().getEqFailure().getFailureEdate().substring(0,10));
            ed_add_guzhan_xianxiang.setText(mQueRen.getData().getEqFailure().getFailureAppear());
            ed_add_guzhan_jcff.setText(mQueRen.getData().getEqFailure().getCheckMethod());
            ed_add_guzhan_yuanying.setText(mQueRen.getData().getEqFailure().getFailureReason());
            ed_add_guzhan_clff.setText(mQueRen.getData().getEqFailure().getFailureDeal());
            ed_add_guzhan_bgbz.setText(mQueRen.getData().getEqFailure().getFailureRemark());
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZLB
                && response instanceof HitchTypeResponse) {
            mHitchType= ( HitchTypeResponse) response;
            tlu.initDataText2(mHitchType);
            try {
                mAdapter = new SimpleTreeListViewAdapter3(minlistView, this,
                        tlu.mDatas2, 0);
                minlistView.setAdapter(mAdapter);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                @Override
                public void onClick(Node node, int position) {
                    if (node.isleaf()) {
                        ed_add_guzhan_leibie.setText(node.getName());
                        code=mHitchType.getData().getListTree().get(position).getId();
                        sss.setHitchCode(code);
                        EventBus.getDefault().postSticky(sss);
                        PopupWindowUtils.closePopupWindow();
                    }
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI
                && response instanceof  HitchBuweiResponse) {
            mHitchBuwei= (HitchBuweiResponse) response;
            myAdapter=new MyAdapter();
            minlistView2.setAdapter(myAdapter);
            minlistView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ed_add_guzhan_buwei.setText(mHitchBuwei.getData().getComboboxList().get(position).getText());
                    codes=mHitchBuwei.getData().getComboboxList().get(position).getId();
                    sss.setHitchbuweiCode(codes);
                    EventBus.getDefault().postSticky(sss);
                    PopupWindowUtils.closePopupWindow();
                }
            });
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZUPDATESAVE
                && response instanceof HitchUpdateSaveResponse) {
            HitchUpdateSaveResponse  mHitchUpdate = (HitchUpdateSaveResponse) response;
            if("00000".equals(mHitchUpdate.getErrorCode())){
                Toast.makeText(HitchUpdateActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(HitchUpdateActivity.this,HitchActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
           MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventSearchResponse esr){
                event=esr;
    }
    private ListView initListView() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_SBGZLB, prams,
                HitchTypeResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBGZLB, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView2() {
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","EQ_PART_CODE");
        HttpLoader.get(ConstantsYunZhiShui.URL_SBBUWEI, prams,
                HitchBuweiResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI, this, false).setTag(this);
        return mListViews;
    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mHitchBuwei.getData().getComboboxList().size();
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
                convertView = View.inflate(HitchUpdateActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mHitchBuwei.getData().getComboboxList().get(position).getText());
            return convertView;
        }
        class ViewHolder {
            TextView v_listview_item_number;
        }
    }
}
