package com.smartwasser.yunzhishui.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.Activity.DayNormHomeActivity;
import com.smartwasser.yunzhishui.Activity.MuchTrendLookActivity;
import com.smartwasser.yunzhishui.Activity.NormTrendLookActivity;
import com.smartwasser.yunzhishui.Activity.SingleMultipleActivity;
import com.smartwasser.yunzhishui.Activity.WaterworksDayActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter;
import com.smartwasser.yunzhishui.adapter.SimpleTreeListViewAdapter10;
import com.smartwasser.yunzhishui.adapter.TreeListViewAdapter;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.EventSearchResponse;
import com.smartwasser.yunzhishui.bean.FileBean;
import com.smartwasser.yunzhishui.bean.OrgBean;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.SiteResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeListUtils;

import org.seny.android.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;
/**
 * Created by huangmengjie on 2016/home/28 0028.
 */
public class MenuFragment extends BaseFragment implements HttpLoader.ResponseListener{
    private ListView list_menu;
    private SiteResponse  mResponese;
    private EventSearchResponse event=new EventSearchResponse();
    private SimpleTreeListViewAdapter10 mAdapter;
    private TreeListUtils tlu=new TreeListUtils();
    private EventNormSelect norms=new EventNormSelect();

    private int tags=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View initView() {
        View view=View.inflate(getActivity(), R.layout.left_listview,null);
        list_menu=(ListView)view.findViewById(R.id.list_menu);
        return view;
    }
    @Override
    public void initDate() {
        HashMap<String, Object> params = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_SITE, params, SiteResponse.class,
                ConstantsYunZhiShui.REQUEST_CODE_SITE, this,false).setTag(this);
       }
    /**数据初始化*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
           /**请求成功的方法*/
    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if(requestCode == ConstantsYunZhiShui.REQUEST_CODE_SITE
                && response instanceof SiteResponse) {
            mResponese = (SiteResponse) response;
            if ("00000".equals(mResponese .getErrorCode())) {
                    tlu.initDataText12(mResponese);
                    try {
                        mAdapter = new SimpleTreeListViewAdapter10(list_menu,context,
                                tlu.mDatas2, 0);
                        list_menu.setAdapter(mAdapter);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                    @Override
                    public void onClick(Node node, int position) {
                        if (node.isleaf()) {
                            if ("142933219070868803212".equals(node.getPid())) {
                                for (int i = 0; i < mResponese.getData().size(); i++) {
                                    if (node.getName().equals(mResponese.getData().get(i).getFuncnamech())) {
                                        show(i);
                                    }
                                }
                            } else if ("8F61A8EBFBE1492F8A1CCF50F129D180".equals(node.getPid())) {
                                switch (node.getId()) {
                                    case "BB99D6497B264551B14363D2ADDB911D":
                                        tags = 1;
                                        norms.setTags(tags);
                                        EventBus.getDefault().postSticky(norms);
                                        Intent intent = new Intent(getActivity(), SingleMultipleActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent);
                                        break;
                                    case "E58D7C14CFE74B74B34F0AE150C57D55":
                                        tags = 2;
                                        norms.setTags(tags);
                                        EventBus.getDefault().postSticky(norms);
                                        Intent intent2 = new Intent(getActivity(), SingleMultipleActivity.class);
                                        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent2);
                                        break;
                                    case "21BBF13959D30787E050007F01000F7C":
                                        Intent intent3 = new Intent(getActivity(), NormTrendLookActivity.class);
                                        intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent3);
                                        break;
                                    case "21D218793A4B911DE050007F010076FC":
                                        Intent intent4 = new Intent(getActivity(), DayNormHomeActivity.class);
                                        intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent4);
                                        break;
                                    case "41C1133D770840F1A71950CD32CCD239":
                                        Intent intent5 = new Intent(getActivity(), MuchTrendLookActivity.class);
                                        intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent5);
                                        break;
                                }
                            }
                        }
                    }
                });
                }
            }
        }
          /**请求失败的方法*/
    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(context, "error: " + error.getMessage());
    }
    private void show(int i){
        String s= mResponese.getData().get(i).getFuncurl();
        String arr[]=s.split("\\?");
        String m[]=arr[1].split("&");
        String tableName=m[0].split("=")[1];
        String flowCode=m[1].split("=")[1];
        /**跳转到水厂日报*/
        event.setFlowCode(flowCode);
        event.setTableName(tableName);
        event.setTitleName(mResponese.getData().get(i).getFuncnamech());
        EventBus.getDefault().postSticky(event);
        Intent intent = new Intent(getActivity(),WaterworksDayActivity.class);
        startActivity(intent);
    }
}
