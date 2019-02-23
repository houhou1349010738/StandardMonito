package com.smartwasser.yunzhishui.deviceactivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter3;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.HitchBuweiResponse;
import com.smartwasser.yunzhishui.bean.HitchSaveResponse;
import com.smartwasser.yunzhishui.bean.HitchTypeResponse;
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
 * Created by huangmengjie on 2016/6/18 0018.
 */
public class AddHitchActivity extends Activity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_menu;
    private TextView tv_toolbar;
    private ImageButton image_add_guzhan_starttime;
    private ImageButton image_add_guzhan_leibie,image_add_guzhan_buwei;
    private EditText ed_add_guzhan_starttime,ed_add_guzhan_endtime;
    private ImageButton image_add_guzhan_endtime;
    private Button but_bianji;
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private  HitchSaveResponse  mHitchSave;
    private EditText ed_add_shebei_name,ed_add_shiyong_danwei;
    private ImageButton button_qinxz,button_gzhanxx;
    private EventSearchResponse mNorm;
    private  HitchTypeResponse mHitchType;
    private ListView minlistView;
    private EditText ed_add_guzhan_leibie,ed_add_guzhan_buwei;
    private SimpleTreeListViewAdapter3 mAdapter;
    private ListView minlistView2;
    private String code="";
    private TreeListUtils tlu=new TreeListUtils();
    private HitchBuweiResponse  mHitchBuwei;
    private MyAdapter myAdapter;
    private EditText ed_add_guzhan_xianxiang;
    private  String codes="";
    private List<String> list=new ArrayList<String>();
    private List<String> list2=new ArrayList<String>();
    private EventNormSelect sss=new EventNormSelect();
    private EditText ed_add_guzhan_bgbz,ed_add_guzhan_clff,ed_add_guzhan_yuanying,
            ed_add_guzhan_jcff;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_addhitch);
         initView();
    }
    public void initView() {
        button_menu= (ImageButton) findViewById(R.id.button_menu);
        button_menu.setBackgroundResource(R.drawable.fanhu);
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
        ed_add_guzhan_bgbz= (EditText) findViewById(R.id.ed_add_guzhan_bgbz);
        ed_add_guzhan_clff= (EditText) findViewById(R.id.ed_add_guzhan_clff);
        ed_add_guzhan_yuanying= (EditText) findViewById(R.id.ed_add_guzhan_yuanying);
        ed_add_guzhan_jcff= (EditText) findViewById(R.id.ed_add_guzhan_jcff);
        but_bianji= (Button) findViewById(R.id.but_bianji);
        EventBus.getDefault().registerSticky(this);
        initListener();
        initData();
    }
    public void initListener() {
        button_menu.setOnClickListener(this);
        ed_add_guzhan_starttime.setOnClickListener(this);
        ed_add_guzhan_endtime.setOnClickListener(this);
        button_qinxz.setOnClickListener(this);
        button_gzhanxx.setOnClickListener(this);
        but_bianji.setOnClickListener(this);
        ed_add_guzhan_leibie.setOnClickListener(this);
        ed_add_guzhan_buwei.setOnClickListener(this);
    }
    public void initData() {
        tv_toolbar.setText("故障信息生成");
        if(mNorm!=null){
            if(mNorm.getX()!=1){
            if(mNorm.getTempAdd()==1){
                ed_add_shebei_name.setText(mNorm.getSbName());
                ed_add_shiyong_danwei.setText(mNorm.getSbDanwei());
                ed_add_guzhan_xianxiang.setText(mNorm.getmList().get(8));
                ed_add_guzhan_leibie.setText(mNorm.getmList().get(0));
                ed_add_guzhan_buwei.setText(mNorm.getmList().get(1));
                ed_add_guzhan_starttime.setText(mNorm.getmList().get(2));
                ed_add_guzhan_endtime.setText(mNorm.getmList().get(3));
                ed_add_guzhan_jcff.setText(mNorm.getmList().get(4));
                ed_add_guzhan_yuanying.setText(mNorm.getmList().get(5));
                ed_add_guzhan_clff.setText(mNorm.getmList().get(6));
                ed_add_guzhan_bgbz.setText(mNorm.getmList().get(7));
            }else if(mNorm.getTempAdd()==2){
                ed_add_shebei_name.setText(mNorm.getmList2().get(0));
                ed_add_shiyong_danwei.setText(mNorm.getmList2().get(1));
                ed_add_guzhan_leibie.setText(mNorm.getmList2().get(2));
                ed_add_guzhan_buwei.setText(mNorm.getmList2().get(3));
                ed_add_guzhan_starttime.setText(mNorm.getmList2().get(4));
                ed_add_guzhan_endtime.setText(mNorm.getmList2().get(5));
                ed_add_guzhan_jcff.setText(mNorm.getmList2().get(6));
                ed_add_guzhan_clff.setText(mNorm.getmList2().get(7));
                ed_add_guzhan_bgbz.setText(mNorm.getmList2().get(8));
                ed_add_guzhan_xianxiang.setText(mNorm.getPhenomen());
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
                int temp=2;
                sss.setTemp(temp);
                sss.setList(list);
                EventBus.getDefault().postSticky(sss);
                Intent intent=new Intent(AddHitchActivity.this,EquipSelectActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.button_gzhanxx:
                String name=ed_add_shebei_name.getText().toString();
                String danwei=ed_add_shiyong_danwei.getText().toString();
                String leibie=ed_add_guzhan_leibie.getText().toString();
                String buwei=ed_add_guzhan_buwei.getText().toString();
                String start=ed_add_guzhan_starttime.getText().toString();
                String end=ed_add_guzhan_endtime.getText().toString();
                String jcff=ed_add_guzhan_jcff.getText().toString();
                String yuanying=ed_add_guzhan_yuanying.getText().toString();
                String  clff=ed_add_guzhan_clff.getText().toString();
                String  bz=ed_add_guzhan_bgbz.getText().toString();
                list2.add(name);
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
                EventBus.getDefault().postSticky(sss);
                Intent intent2=new Intent(AddHitchActivity.this,PhenomenaActivity.class);
                startActivity(intent2);
                finish();
                 break;
            case R.id.but_bianji:
                /**保存*/
                String startTime= ed_add_guzhan_starttime.getText().toString();
                String endTime=ed_add_guzhan_endtime.getText().toString();
                String sbName=ed_add_shebei_name.getText().toString();
                String leibie3=ed_add_guzhan_leibie.getText().toString();
                String buwei3=ed_add_guzhan_buwei.getText().toString();
                String xianxiang=ed_add_guzhan_xianxiang.getText().toString();
                String sbDanwei=ed_add_shiyong_danwei.getText().toString();
                String sydw=ed_add_shiyong_danwei.getText().toString();
                String jcff3=ed_add_guzhan_jcff.getText().toString();
                String yuanying3=ed_add_guzhan_yuanying.getText().toString();
                String  clf3=ed_add_guzhan_clff.getText().toString();
                String  bz3=ed_add_guzhan_bgbz.getText().toString();
                if("".equals(startTime)||"".equals(endTime)||"".equals(sbName)

                        ||"".equals(leibie3)||"".equals(xianxiang)||"".equals(sbDanwei)

                        ||"".equals(sydw)||"".equals(buwei3)){
                    Toast.makeText(AddHitchActivity.this, "请将信息填全", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, Object> params = new HashMap<>();
                params.put("equipName",sbName);
                params.put("equipOwnDept",sydw);
                params.put("failureTbType",mNorm.getMhitchCode());
                params.put("failurePart",mNorm.getMhitchCodebuwei());
                params.put("Sdate",startTime);
                params.put("Edate",endTime);
                params.put("failureAppear",xianxiang);
                params.put("checkMethod",jcff3);
                params.put("failureReason",yuanying3);
                params.put("failureDeal",clf3);
                params.put("failureRemark", bz3);
                HttpLoader.get(ConstantsYunZhiShui.URL_SBGZSAVE, params,HitchSaveResponse.class,
                        ConstantsYunZhiShui.REQUEST_CODE_SBGZSAVE,this,false).setTag(this);
                        break;
            case R.id.ed_add_guzhan_leibie:
                   /**点击故障类别*/
                minlistView=initListView();
                PopupWindowUtils.showPopupWindow(minlistView,ed_add_guzhan_leibie);
                      break;
            case R.id.ed_add_guzhan_buwei:
                minlistView2=initListView2();
                PopupWindowUtils.showPopupWindow(  minlistView2,ed_add_guzhan_buwei);
                      break;
        }
    }
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_SBGZSAVE
                && response instanceof  HitchSaveResponse) {
            mHitchSave= (HitchSaveResponse) response;
            Log.i("0000", mHitchSave.getErrorCode());
            if("00000".equals(mHitchSave.getErrorCode())){
                Toast.makeText(AddHitchActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AddHitchActivity.this,HitchActivity.class);
                startActivity(intent);
                finish();
            }
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
                        for(int i=0;i<mHitchType.getData().getListTree().size();i++){
                            if (node.getName().equals(mHitchType.getData().getListTree().get(i).getTbTypeName())) {
                                code=mHitchType.getData().getListTree().get(position).getId();
                                sss.setHitchCode(code);
                            }
                        }
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
                    EventBus.getDefault().postSticky( sss);
                    PopupWindowUtils.closePopupWindow();
                }
            });
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    public void onEvent(EventSearchResponse normsel){
          mNorm=normsel;
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
        prams.put("typeCode", "EQ_PART_CODE");
        HttpLoader.get(ConstantsYunZhiShui.URL_SBBUWEI, prams,
              HitchBuweiResponse.class, ConstantsYunZhiShui.REQUEST_CODE_SBBUWEI, this, false).setTag(this);
        return mListViews;
    }
    class MyAdapter extends BaseAdapter{
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
                convertView = View.inflate(AddHitchActivity.this, R.layout.item_search, null);
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
