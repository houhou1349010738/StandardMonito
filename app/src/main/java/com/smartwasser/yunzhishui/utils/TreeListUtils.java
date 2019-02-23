package com.smartwasser.yunzhishui.utils;

import com.smartwasser.yunzhishui.bean.DeviceMenuListResponse;
import com.smartwasser.yunzhishui.bean.EquipTypeResponse;
import com.smartwasser.yunzhishui.bean.FileBean;
import com.smartwasser.yunzhishui.bean.FindBuComBoxResponse;
import com.smartwasser.yunzhishui.bean.FloodcontrolResponse;
import com.smartwasser.yunzhishui.bean.HitchTypeResponse;
import com.smartwasser.yunzhishui.bean.OrgBean;
import com.smartwasser.yunzhishui.bean.ProductResponse;
import com.smartwasser.yunzhishui.bean.ProjectNameResponse;
import com.smartwasser.yunzhishui.bean.PurchesaMenuResponse;
import com.smartwasser.yunzhishui.bean.RmonMenuResponse;
import com.smartwasser.yunzhishui.bean.SiteResponse;
import com.smartwasser.yunzhishui.bean.SubordinateResponse;
import com.smartwasser.yunzhishui.bean.TrafficMenuListResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangmengjie on 2016/6/22 0022.
 */
public class TreeListUtils {
    public List<OrgBean> mDatas2;
    private List<FileBean> mDatas;
    public void initDataText(FindBuComBoxResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().getListTree().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().getListTree().get(j).getBusinessUnitCode(), mFindBu.getData().getListTree().get(j).getParentUnitCode(), mFindBu.getData().getListTree().get(j).getBusinessUnitName());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().getListTree().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().getListTree().get(i).getBusinessUnitCode(), mFindBu.getData().getListTree().get(i).getParentUnitCode(), mFindBu.getData().getListTree().get(i).getBusinessUnitName());
            mDatas2.add(bean2);
        }
    }
    public void initDataText2(HitchTypeResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().getListTree().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().getListTree().get(j).getEqTypeCode(),mFindBu.getData().getListTree().get(j).getTbTypeParentCode(), mFindBu.getData().getListTree().get(j).getTbTypeName());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().getListTree().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().getListTree().get(i).getEqTypeCode(),mFindBu.getData().getListTree().get(i).getTbTypeParentCode(),mFindBu.getData().getListTree().get(i).getTbTypeName());
            mDatas2.add(bean2);
        }
    }
    public void initDataText3(EquipTypeResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().getListTree().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().getListTree().get(j).getTypeCode(),mFindBu.getData().getListTree().get(j).getTypeParentCode(), mFindBu.getData().getListTree().get(j).getTypeName());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().getListTree().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().getListTree().get(i).getTypeCode(),mFindBu.getData().getListTree().get(i).getTypeParentCode(),mFindBu.getData().getListTree().get(i).getTypeName());
            mDatas2.add(bean2);
        }
    }
    public void initDataText4(SubordinateResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().getListTree().size(); j++) {
           // System.out.println("444444444444"+mFindBu.getData().getListTree().get(j).getBusinessUnitCode()+mFindBu.getData().getListTree().get(j).getParentUnitCode());
            FileBean bean = new FileBean(mFindBu.getData().getListTree().get(j).getBusinessUnitCode(),mFindBu.getData().getListTree().get(j).getParentUnitCode(),mFindBu.getData().getListTree().get(j).getBusinessUnitName());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().getListTree().size(); i++) {
           // System.out.println("88888888888888"+mFindBu.getData().getListTree().get(i).getBusinessUnitCode()+mFindBu.getData().getListTree().get(i).getParentUnitCode());
            OrgBean bean2 = new OrgBean(mFindBu.getData().getListTree().get(i).getBusinessUnitCode(),mFindBu.getData().getListTree().get(i).getParentUnitCode(),mFindBu.getData().getListTree().get(i).getBusinessUnitName());
            mDatas2.add(bean2);
        }
    }
    public void initDataText5(ProjectNameResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().getListTree().size(); j++) {
            // System.out.println("444444444444"+mFindBu.getData().getListTree().get(j).getBusinessUnitCode()+mFindBu.getData().getListTree().get(j).getParentUnitCode());
            FileBean bean = new FileBean(mFindBu.getData().getListTree().get(j).getId(),mFindBu.getData().getListTree().get(j).getPid(),mFindBu.getData().getListTree().get(j).getText());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().getListTree().size(); i++) {
            // System.out.println("88888888888888"+mFindBu.getData().getListTree().get(i).getBusinessUnitCode()+mFindBu.getData().getListTree().get(i).getParentUnitCode());
            OrgBean bean2 = new OrgBean(mFindBu.getData().getListTree().get(i).getId(),mFindBu.getData().getListTree().get(i).getPid(),mFindBu.getData().getListTree().get(i).getText());
            mDatas2.add(bean2);
        }
    }
    public void initDataText6(ProductResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().get(j).getId(),mFindBu.getData().get(j).getParentid(),mFindBu.getData().get(j).getFuncnamech());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().get(i).getId(),mFindBu.getData().get(i).getParentid(),mFindBu.getData().get(i).getFuncnamech());
            mDatas2.add(bean2);
        }
    }
    public void initDataText7(RmonMenuResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().get(j).getId(),mFindBu.getData().get(j).getParentid(),mFindBu.getData().get(j).getFuncnamech());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().get(i).getId(),mFindBu.getData().get(i).getParentid(),mFindBu.getData().get(i).getFuncnamech());
            mDatas2.add(bean2);
        }
    }
    public void initDataText8(FloodcontrolResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().get(j).getId(),mFindBu.getData().get(j).getParentid(),mFindBu.getData().get(j).getFuncnamech());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().get(i).getId(),mFindBu.getData().get(i).getParentid(),mFindBu.getData().get(i).getFuncnamech());
            mDatas2.add(bean2);
        }
    }
    public void initDataText9(PurchesaMenuResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().get(j).getId(),mFindBu.getData().get(j).getParentid(),mFindBu.getData().get(j).getFuncnamech());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().get(i).getId(),mFindBu.getData().get(i).getParentid(),mFindBu.getData().get(i).getFuncnamech());
            mDatas2.add(bean2);
        }
    }
    public void initDataText10(TrafficMenuListResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().get(j).getId(),mFindBu.getData().get(j).getParentid(),mFindBu.getData().get(j).getFuncnamech());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().get(i).getId(),mFindBu.getData().get(i).getParentid(),mFindBu.getData().get(i).getFuncnamech());
            mDatas2.add(bean2);
        }
    }
    public void initDataText11( DeviceMenuListResponse mFindBu) {
        mDatas = new ArrayList<FileBean>();
        for (int j = 0; j < mFindBu.getData().size(); j++) {
            FileBean bean = new FileBean(mFindBu.getData().get(j).getId(),mFindBu.getData().get(j).getParentid(),mFindBu.getData().get(j).getFuncnamech());
            mDatas.add(bean);
        }
        mDatas2 = new ArrayList<OrgBean>();
        for (int i = 0; i < mFindBu.getData().size(); i++) {
            OrgBean bean2 = new OrgBean(mFindBu.getData().get(i).getId(),mFindBu.getData().get(i).getParentid(),mFindBu.getData().get(i).getFuncnamech());
            mDatas2.add(bean2);
        }
    }
    public void initDataText12(SiteResponse mResponese) {
        mDatas = new ArrayList<FileBean>();
        if( mResponese.getData()!=null) {
            for (int i = 0; i < mResponese.getData().size(); i++) {
                FileBean bean = new FileBean(mResponese.getData().get(i).getId(), mResponese.getData().get(i).getParentid(), mResponese.getData().get(i).getFuncnamech());
                mDatas.add(bean);
            }
            mDatas2 = new ArrayList<OrgBean>();
            for (int i = 0; i < mResponese.getData().size(); i++) {
                OrgBean bean2 = new OrgBean(mResponese.getData().get(i).getId(), mResponese.getData().get(i).getParentid(), mResponese.getData().get(i).getFuncnamech());
                mDatas2.add(bean2);
            }
        }
    }
}
