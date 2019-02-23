package com.smartwasser.yunzhishui.productionactivity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.AddTypResponse;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class AddReimburseTypeActivity extends BaseActivity implements HttpLoader.ResponseListener{
    private TextView tv_toolbar_centext;
    private ImageButton image_add,image_serc,button_fan;
    private ListView list_type;
    private AddTypResponse mAddType;
    private TypeAddapter mTypeAdapter;
    private EventSearchResponse ese=new EventSearchResponse();
    @Override
    protected int initContentView() {
        return R.layout.activity_bxdlx;
    }

    @Override
    protected void initView() {
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_add.setVisibility(View.GONE);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_serc.setVisibility(View.GONE);
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        list_type= (ListView) findViewById(R.id.list_contract);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {
        tv_toolbar_centext.setText("费用报销填报");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("typeCode","BXDLB");
        HttpLoader.get(ConstantsYunZhiShui.URL_TYPEMASTERSELECT, prams,
                AddTypResponse.class, ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT, this, false).setTag(this);

    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_TYPEMASTERSELECT
                && response instanceof AddTypResponse) {
                mAddType = (AddTypResponse) response;
               if("00000".equals(  mAddType.getErrorCode())){
                   mTypeAdapter=new TypeAddapter();
                   list_type.setAdapter(mTypeAdapter);
                   list_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                           ese.setFlowCode(mAddType.getData().getComboboxList().get(position).getId());
                           EventBus.getDefault().postSticky(ese);
                           switch (position){
                                 case 1:
                                     Intent intent=new Intent(AddReimburseTypeActivity.this,AddReimburseActivity.class);
                                     startActivity(intent);
                                     break;
                                 case 2:
                                     Intent intent2=new Intent(AddReimburseTypeActivity.this,AddReimburseActivity.class);
                                     startActivity(intent2);
                                     break;
                                 case 3:

                                     break;
                                 case 4:
                                     break;
                                 case 5:
                                     Intent intent5=new Intent(AddReimburseTypeActivity.this,AddReimburseActivity.class);
                                     startActivity(intent5);
                                     break;
                                 case 6:
                                     Intent intent6=new Intent(AddReimburseTypeActivity.this,AddReimburseActivity.class);
                                     startActivity(intent6);
                                     break;
                             }
                       }
                   });
               }
        }
    }
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    class TypeAddapter extends BaseAdapter {
        @Override
        public int getCount() {
            return   mAddType.getData().getComboboxList().size();
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
                holder=new ViewHolder();
                convertView=View.inflate(AddReimburseTypeActivity.this,R.layout.item_reimburse_type,null);
                holder.textview= (TextView) convertView.findViewById(R.id.tv_type);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder) convertView.getTag();
            }
            holder.textview.setText(mAddType.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class ViewHolder{
        TextView textview;
    }
}
