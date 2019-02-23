package com.smartwasser.yunzhishui.purchaseactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.AchievementResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.ProjectDetailResponse;
import com.smartwasser.yunzhishui.bean.QrobotResponse;
import com.smartwasser.yunzhishui.bean.QualificationResponse;
import com.smartwasser.yunzhishui.bean.QuoteDetailResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.CatalogueResponse;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;

import org.seny.android.utils.MyToast;

import java.util.HashMap;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class QrobotActivity extends BaseActivity implements HttpLoader.ResponseListener,View.OnClickListener{
    private TextView tv_toolbar;
    private ImageButton button_menu;
    private EventSearchResponse event;
    private TextView tv_enlist_qymc,tv_enlist_qyyhm,tv_enlist_qygm,tv_enlist_sjrs
    ,tv_enlist_fwlb,tv_enlist_qyjj;
    private TextView tv_enlist_qylx,tv_enlist_yyzzzcm,tv_enlist_qydzzs,tv_enlist_fddbr,
            tv_enlist_zczbje,tv_enlist_sszb,tv_enlist_clsj,tv_enlist_jyqx,
            tv_enlist_djjg,tv_enlist_djsj,tv_enlist_jyywfw;

    private TextView tv_enlist_zzjgdm,tv_enlist_jglx,tv_enlist_dz,tv_enlist_fddbrfzr,
            tv_enlist_djh,tv_enlist_yxqx,tv_enlist_bfdw,tv_enlist_njjl;


    private TextView tv_enlist_dah,tv_enlist_dengjh,tv_enlist_djzclx,tv_enlist_pzsljg
            ,tv_enlist_fzsj;

    private TextView tv_enlist_khyhzh,tv_enlist_khyhhh,tv_enlist_khxkzhjh,tv_enlist_khxkzbh
            ,tv_enlist_khyh;

    private TextView tv_enlist_tsdz,tv_enlist_yzbm,tv_enlist_xslxr,tv_enlist_lxdhgd
            ,tv_enlist_lxdhsj,tv_enlist_lxdhfddbr,tv_enlist_yx;

    private TextView tv_enlist_cpmlmc,tv_enlist_ncn,tv_enlist_dw;

    private TextView tv_enlist_zdmc,tv_enlist_bz,tv_enlist_cz;

    private TextView tv_enlist_htmc,tv_enlist_gxsj,tv_enlist_yjcz;

    private TextView tv_enlist_shzt,tv_enlist_shyj;
    private ImageView image_cpml,image_zzzl,image_zyyw;
    private ListView list_cpml,list_zzzl,list_zyyw;
    private  CatalogueResponse mCatalogue;
    private int x=1,y=1,z=1;
    private MyCpmlAdapter mCpmlAdapter;
    private MyZhzlAdapter mZhzlAdapter;
    private RelativeLayout afliefepmfosd,afliefefri,afliefefrioadpwo;
    private  QualificationResponse  mQualifi;
    private   AchievementResponse mAchievement;
    private MyZyywAdapter mZyywAdapter;
    private EventNormSelect ends=new EventNormSelect();
    @Override
    protected int initContentView() {
        return R.layout.activity_enlist_detail;
    }

    @Override
    protected void initView() {
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        button_menu= (ImageButton) findViewById(R.id.button_menu);
                       /**基本信息*/
        tv_enlist_qymc= (TextView) findViewById(R.id.tv_enlist_qymc);
        tv_enlist_qyyhm= (TextView) findViewById(R.id.tv_enlist_qyyhm);
        tv_enlist_qygm= (TextView) findViewById(R.id.tv_enlist_qygm);
        tv_enlist_sjrs= (TextView) findViewById(R.id.tv_enlist_sjrs);
        tv_enlist_fwlb= (TextView) findViewById(R.id.tv_enlist_fwlb);
        tv_enlist_qyjj= (TextView) findViewById(R.id.tv_enlist_qyjj);
                       /**营业执照*/
        tv_enlist_qylx= (TextView) findViewById(R.id.tv_enlist_qylx);
        tv_enlist_yyzzzcm= (TextView) findViewById(R.id.tv_enlist_yyzzzcm);
        tv_enlist_qydzzs= (TextView) findViewById(R.id.tv_enlist_qydzzs);
        tv_enlist_fddbr= (TextView) findViewById(R.id.tv_enlist_fddbr);
        tv_enlist_zczbje= (TextView) findViewById(R.id. tv_enlist_zczbje);
        tv_enlist_sszb= (TextView) findViewById(R.id.tv_enlist_sszb);
        tv_enlist_clsj= (TextView) findViewById(R.id.tv_enlist_clsj);
        tv_enlist_jyqx= (TextView) findViewById(R.id.tv_enlist_jyqx);
        tv_enlist_djjg= (TextView) findViewById(R.id.tv_enlist_djjg);
        tv_enlist_djsj= (TextView) findViewById(R.id.tv_enlist_djsj);
        tv_enlist_jyywfw= (TextView) findViewById(R.id.tv_enlist_jyywfw);
                        /**组织机构代码*/
        tv_enlist_zzjgdm= (TextView) findViewById(R.id.tv_enlist_zzjgdm);
        tv_enlist_jglx= (TextView) findViewById(R.id.tv_enlist_jglx);
        tv_enlist_dz= (TextView) findViewById(R.id.tv_enlist_dz);
        tv_enlist_fddbrfzr= (TextView) findViewById(R.id.tv_enlist_fddbrfzr);
        tv_enlist_djh= (TextView) findViewById(R.id.tv_enlist_djh);
        tv_enlist_yxqx= (TextView) findViewById(R.id.tv_enlist_yxqx);
        tv_enlist_bfdw= (TextView) findViewById(R.id.tv_enlist_bfdw);
        tv_enlist_njjl= (TextView) findViewById(R.id.tv_enlist_njjl);
                         /**税务登记证*/
        tv_enlist_dah= (TextView) findViewById(R.id.tv_enlist_dah);
        tv_enlist_dengjh= (TextView) findViewById(R.id.tv_enlist_dengjh);
        tv_enlist_djzclx= (TextView) findViewById(R.id.tv_enlist_djzclx);
        tv_enlist_pzsljg= (TextView) findViewById(R.id.tv_enlist_pzsljg);
        tv_enlist_fzsj= (TextView) findViewById(R.id.tv_enlist_fzsj);
                         /**银行信息*/
        tv_enlist_khyhzh= (TextView) findViewById(R.id.tv_enlist_khyhzh);
        tv_enlist_khyhhh= (TextView) findViewById(R.id.tv_enlist_khyhhh);
        tv_enlist_khxkzhjh= (TextView) findViewById(R.id.tv_enlist_khxkzhjh);
        tv_enlist_khxkzbh= (TextView) findViewById(R.id.tv_enlist_khxkzbh);
        tv_enlist_khyh= (TextView) findViewById(R.id.tv_enlist_khyh);
                        /**联系方式*/
        tv_enlist_tsdz= (TextView) findViewById(R.id. tv_enlist_tsdz);
        tv_enlist_yzbm= (TextView) findViewById(R.id.tv_enlist_yzbm);
        tv_enlist_xslxr= (TextView) findViewById(R.id.tv_enlist_xslxr);
        tv_enlist_lxdhgd= (TextView) findViewById(R.id.tv_enlist_lxdhgd);
        tv_enlist_lxdhsj= (TextView) findViewById(R.id.tv_enlist_lxdhsj);
        tv_enlist_lxdhfddbr= (TextView) findViewById(R.id.tv_enlist_lxdhfddbr);
        tv_enlist_yx= (TextView) findViewById(R.id.tv_enlist_yx);
                       /**产品目录*/
        image_cpml= (ImageView) findViewById(R.id.image_cpml);
        list_cpml= (ListView) findViewById(R.id.list_cpml);
        afliefepmfosd= (RelativeLayout) findViewById(R.id.afliefepmfosd);
                      /**资质资料*/
        image_zzzl= (ImageView) findViewById(R.id.image_zzzl);
        list_zzzl= (ListView) findViewById(R.id.list_zzzl);
        afliefefri= (RelativeLayout) findViewById(R.id.afliefefri);
                       /**主要业绩*/
        image_zyyw= (ImageView) findViewById(R.id. image_zyyw);
        list_zyyw= (ListView) findViewById(R.id.list_zyyw);
        afliefefrioadpwo= (RelativeLayout) findViewById(R.id.afliefefrioadpwo);
                       /**审核意见*/
        tv_enlist_shzt= (TextView) findViewById(R.id.tv_enlist_shzt);
        tv_enlist_shyj= (TextView) findViewById(R.id.tv_enlist_shyj);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        afliefepmfosd.setOnClickListener(this);
        afliefefri.setOnClickListener(this);
        afliefefrioadpwo.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar.setText("供应商注册登记信息");
        button_menu.setBackgroundResource(R.drawable.fanhu);
        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("supplierId", event.getEnlistDetailId());
        HttpLoader.get(ConstantsYunZhiShui.URL_ONLINESUPPLIER, prams,
                QrobotResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINESUPPLIER, this, false).setTag(this);
    }
    public void onEvent(EventSearchResponse event){
        this.event=event;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINESUPPLIER
                && response instanceof  QrobotResponse) {
            QrobotResponse  mQrobot = ( QrobotResponse) response;
            if("00000".equals( mQrobot.getErrorCode())){
                if(mQrobot.getData().getSupplierInfo()!=null&&mQrobot.getData()!=null) {
                    tv_enlist_qymc.setText("企业名称:" + "    " + mQrobot.getData().getSupplierInfo().getName());
                    tv_enlist_qyyhm.setText("企业用户名:" + "    " + mQrobot.getData().getSupplierInfo().getUsername());
                    tv_enlist_qygm.setText("企业规模:" + "    " + mQrobot.getData().getSupplierInfo().getScale());
                    tv_enlist_sjrs.setText("实际人数:" + "    " + mQrobot.getData().getSupplierInfo().getPersonNum());
                    tv_enlist_fwlb.setText("产品/服务类别:" + "    " + mQrobot.getData().getSupplierInfo().getBusiness());
                    tv_enlist_qyjj.setText("企业简介:" + "    " + mQrobot.getData().getSupplierInfo().getIntroduction());

                    tv_enlist_qylx.setText("企业类型:" + "     " + mQrobot.getData().getSupplierInfo().getType());
                    tv_enlist_yyzzzcm.setText("营业执照注册码:" + "     " + mQrobot.getData().getSupplierInfo().getBusinessLicenseNum());
                    tv_enlist_qydzzs.setText("企业地址/住所:" + "     " + mQrobot.getData().getSupplierInfo().getAddressFactoryCountry());
                    tv_enlist_fddbr.setText("法定代表人(负责人):" + "     " + mQrobot.getData().getSupplierInfo().getLegal());
                    tv_enlist_zczbje.setText("注册资本金额:" + "     " + mQrobot.getData().getSupplierInfo().getRegCapital() + "");
                    tv_enlist_sszb.setText("实收资本:" + "     " + mQrobot.getData().getSupplierInfo().getPaidCapital() + "");
                    tv_enlist_clsj.setText("成立/注册时间:" + "     " + mQrobot.getData().getSupplierInfo().getUpTime());
                    tv_enlist_jyqx.setText("经营/营业/合伙期限:" + "     " + mQrobot.getData().getSupplierInfo().getOperatingPeriodStart());
                    tv_enlist_djjg.setText("登记机关:" + "     " + mQrobot.getData().getSupplierInfo().getRegistrationAuthority());
                    tv_enlist_djsj.setText("等级时间:" + "     " + mQrobot.getData().getSupplierInfo().getRegistrationTime());
                    tv_enlist_jyywfw.setText("经营业务范围:" + "     " + mQrobot.getData().getSupplierInfo().getScopeBusiness());

                    tv_enlist_zzjgdm.setText("组织机构代码:" + "     " + mQrobot.getData().getSupplierInfo().getOrganizationCode());
                    tv_enlist_jglx.setText("机构类型:" + "     " + mQrobot.getData().getSupplierInfo().getOrganizationType());
                    tv_enlist_dz.setText("地址:" + "     " + mQrobot.getData().getSupplierInfo().getAddressCountry());
                    tv_enlist_fddbrfzr.setText("法定代表人(负责人):" + "     " + mQrobot.getData().getSupplierInfo().getLegalZuzhi());
                    tv_enlist_djh.setText("登记号:" + "     " + mQrobot.getData().getSupplierInfo().getRegistrationNum());
                    tv_enlist_yxqx.setText("有限期限:" + "     " + mQrobot.getData().getSupplierInfo().getPeriodValidityEnd());
                    tv_enlist_bfdw.setText("颁发单位:" + "     " + mQrobot.getData().getSupplierInfo().getIssuedUnit());
                    tv_enlist_njjl.setText("年检记录:" + "     " + mQrobot.getData().getSupplierInfo().getInspectionRecord());

                    tv_enlist_dah.setText("档案号:" + "     " + mQrobot.getData().getSupplierInfo().getFileNum());
                    tv_enlist_dengjh.setText("登记号:" + "     " + mQrobot.getData().getSupplierInfo().getTaxRegistrationNum());
                    tv_enlist_djzclx.setText("登记注册类型:" + "     " + mQrobot.getData().getSupplierInfo().getRegistrationType());
                    tv_enlist_pzsljg.setText("批准设立机关:" + "     " + mQrobot.getData().getSupplierInfo().getApprovingOrgan());
                    tv_enlist_fzsj.setText("发证时间:" + "     " + mQrobot.getData().getSupplierInfo().getIssuingTime());

                    tv_enlist_khyhzh.setText("开户银行账号:" + "     " + mQrobot.getData().getSupplierInfo().getAccount());
                    tv_enlist_khyhhh.setText("开户银行行号:" + "     " + mQrobot.getData().getSupplierInfo().getBankLineNumber());
                    tv_enlist_khxkzhjh.setText("开户许可证核准号:" + "     " + mQrobot.getData().getSupplierInfo().getPermitApprovalNumber());
                    tv_enlist_khxkzbh.setText("开户许可证编号:" + "     " + mQrobot.getData().getSupplierInfo().getLicenseNumber());
                    tv_enlist_khyh.setText("开户银行:" + "     " + mQrobot.getData().getSupplierInfo().getBank());


                    tv_enlist_tsdz.setText("通讯地址:" + mQrobot.getData().getSupplierInfo().getAddressCountry()
                            + "----" + mQrobot.getData().getSupplierInfo().getAddressProvince() +
                            "----" + mQrobot.getData().getSupplierInfo().getAddressCity() + "----" +
                            mQrobot.getData().getSupplierInfo().getAddress());
                    tv_enlist_yzbm.setText("邮政编码:" + mQrobot.getData().getSupplierInfo().getZipCode());
                    tv_enlist_xslxr.setText("销售联系人:" + mQrobot.getData().getSupplierInfo().getSell());
                    tv_enlist_lxdhgd.setText("联系电话(固定):" + mQrobot.getData().getSupplierInfo().getSellPhoneCode());
                    tv_enlist_lxdhsj.setText("联系电话(手机):" + mQrobot.getData().getSupplierInfo().getSupplierContact());
                    tv_enlist_lxdhfddbr.setText("联系电话(法定代表人):" + mQrobot.getData().getSupplierInfo().getLegalContact());
                    tv_enlist_yx.setText("邮箱:" + mQrobot.getData().getSupplierInfo().getEmail());
                       /*     checkResult
                            checkOpinion
                    tv_enlist_shzt.setText("审核状态:"+"    "+);
                    tv_enlist_shyj.setText("审核意见:"+"    "+ mQrobot.getData().getSupplierInfo().);*/
                }


              /*  tv_enlist_zdmc.setText();
                tv_enlist_bz.setText();
                tv_enlist_cz.setText();

                tv_enlist_htmc.setText();
                tv_enlist_gxsj.setText();
                tv_enlist_yjcz.setText();

              */
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINECATALOGUE
                && response instanceof  CatalogueResponse) {
            mCatalogue = (CatalogueResponse)response;
            if("00000".equals(mCatalogue.getErrorCode())){
                /**设置适配器*/
                mCpmlAdapter=new MyCpmlAdapter();
                list_cpml.setAdapter(mCpmlAdapter);
                setListViewHeight(list_cpml);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUALIFI
                && response instanceof  QualificationResponse) {
              mQualifi = ( QualificationResponse)response;
            if("00000".equals(mQualifi.getErrorCode())){
                /**设置适配器*/
                mZhzlAdapter=new MyZhzlAdapter();
                list_zzzl.setAdapter( mZhzlAdapter);
                setListViewHeight(list_zzzl);
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ONLINEACHIE
                && response instanceof  AchievementResponse) {
            mAchievement = ( AchievementResponse)response;
           // Log.i("9999999", mCatalogue.getErrorCode());
            if("00000".equals(mAchievement.getErrorCode())){
                /**设置适配器*/
                mZyywAdapter=new MyZyywAdapter();
                list_zyyw.setAdapter(mZyywAdapter);
                setListViewHeight(list_zyyw);
            }
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    /**
     * 重新计算ListView的高度，解决ScrollView和ListView两个View都有滚动的效果，在嵌套使用时起冲突的问题
     * @param listView
     */
    public void setListViewHeight(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.afliefepmfosd:
                 /**切换图片*/
                 if(x%2==0){
                     image_cpml.setBackgroundResource(R.drawable.menu_next);
                     list_cpml.setVisibility(View.GONE);
                 }else{
                     /**显示*/
                     image_cpml.setBackgroundResource(R.drawable.xiang);
                     list_cpml.setVisibility(View.VISIBLE);
                     /**请求网络*/
                     HashMap<String, Object> prams3 = new HashMap<>();
                     prams3.put("supplierId", event.getEnlistDetailId());
                     HttpLoader.get(ConstantsYunZhiShui.URL_ONLINECATALOGUE, prams3,
                            CatalogueResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINECATALOGUE, this, false).setTag(this);
                 }
                 x++;
             break;
             case R.id.afliefefri:
                 /**切换图片*/
                 if(y%2==0){
                     image_zzzl.setBackgroundResource(R.drawable.menu_next);
                     list_zzzl.setVisibility(View.GONE);
                 }else{
                     /**显示*/
                     image_zzzl.setBackgroundResource(R.drawable.xiang);
                     list_zzzl.setVisibility(View.VISIBLE);
                     /**请求网络*/
                     HashMap<String, Object> prams2 = new HashMap<>();
                     prams2.put("supplierId", event.getEnlistDetailId());
                     HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEQUALIFI, prams2,
                             QualificationResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEQUALIFI, this, false).setTag(this);
                 }
                 y++;
                 break;
             case R.id.afliefefrioadpwo:
                 if(z%2==0){
                     image_zyyw.setBackgroundResource(R.drawable.menu_next);
                     list_zyyw.setVisibility(View.GONE);
                 }else{
                     /**显示*/
                     image_zyyw.setBackgroundResource(R.drawable.xiang);
                     list_zyyw.setVisibility(View.VISIBLE);
                     /**请求网络*/
                     HashMap<String, Object> prams2 = new HashMap<>();
                     prams2.put("supplierId", event.getEnlistDetailId());
                     HttpLoader.get(ConstantsYunZhiShui.URL_ONLINEACHIE, prams2,
                             AchievementResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ONLINEACHIE, this, false).setTag(this);
                 }
                 z++;
                 break;
         }
    }

    class MyCpmlAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return  mCatalogue.getData().getSupplierPurTypeList().size();
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
            ViewHolders holder;
            if(convertView==null){
                 convertView=View.inflate(QrobotActivity.this,R.layout.item_changermulu,null);
                 holder=new ViewHolders();
                 holder.tv_enlist_htmc= (TextView) convertView.findViewById(R.id.tv_enlist_htmc);
                 holder.tv_enlist_gxsj= (TextView) convertView.findViewById(R.id.tv_enlist_gxsj);
                 holder.tv_enlist_yjcz= (TextView) convertView.findViewById(R.id.tv_enlist_yjcz);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolders) convertView.getTag();
            }
            holder.tv_enlist_htmc.setText("产品目录名称:"+"   "+mCatalogue.getData().getSupplierPurTypeList().get(position).getTypeName());
            holder.tv_enlist_gxsj.setText("年产能:"+"   "+mCatalogue.getData().getSupplierPurTypeList().get(position).getTypeNum());
            holder.tv_enlist_yjcz.setText("单位:"+"   "+mCatalogue.getData().getSupplierPurTypeList().get(position).getTypeDanwei());
            return convertView;
        }
    }
    class ViewHolders{
        TextView tv_enlist_htmc,tv_enlist_gxsj,tv_enlist_yjcz;
    }
    class MyZhzlAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mQualifi.getData().getSupplierFileList().size();
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
            ViewHolders holder;
            if(convertView==null){
                convertView=View.inflate(QrobotActivity.this,R.layout.item_changermulu,null);
                holder=new ViewHolders();
                holder.tv_enlist_htmc= (TextView) convertView.findViewById(R.id.tv_enlist_htmc);
                holder.tv_enlist_gxsj= (TextView) convertView.findViewById(R.id.tv_enlist_gxsj);
                holder.tv_enlist_yjcz= (TextView) convertView.findViewById(R.id.tv_enlist_yjcz);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolders) convertView.getTag();
            }
            holder.tv_enlist_htmc.setText("资料名称:" + "   " + mQualifi.getData().getSupplierFileList().get(position).getFileTitle());
            holder.tv_enlist_gxsj.setText("备注:"+"   "+mQualifi.getData().getSupplierFileList().get(position).getRemark());
            holder.tv_enlist_yjcz.setText("查看");
            holder.tv_enlist_yjcz.setTextColor(Color.BLUE);
            holder.tv_enlist_yjcz.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                }
            });
            return convertView;
        }
    }
    class MyZyywAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mAchievement.getData().getSupplierScoreList().size();
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
        public View getView(final  int position, View convertView, ViewGroup parent) {
            ViewHolders holder;
            if(convertView==null){
                convertView=View.inflate(QrobotActivity.this,R.layout.item_changermulu,null);
                holder=new ViewHolders();
                holder.tv_enlist_htmc= (TextView) convertView.findViewById(R.id.tv_enlist_htmc);
                holder.tv_enlist_gxsj= (TextView) convertView.findViewById(R.id.tv_enlist_gxsj);
                holder.tv_enlist_yjcz= (TextView) convertView.findViewById(R.id.tv_enlist_yjcz);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolders) convertView.getTag();
            }
            holder.tv_enlist_htmc.setText("合同名称:" + "   " + mAchievement.getData().getSupplierScoreList().get(position).getContractName());
            holder.tv_enlist_gxsj.setText("更新时间:"+"   "+ mAchievement.getData().getSupplierScoreList().get(position).getUpdateDate());
            holder.tv_enlist_yjcz.setText("查看附件");
            holder.tv_enlist_yjcz.setTextColor(Color.BLUE);
            holder.tv_enlist_yjcz.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                      ends.setUrl(mAchievement.getData().getSupplierScoreList().get(position).getContractFilePath());
                      EventBus.getDefault().postSticky(ends);
                      Intent  intent=new Intent(QrobotActivity.this,AppendixActivity.class);
                      startActivity(intent);
                }
            });
            return convertView;
        }
    }
}
