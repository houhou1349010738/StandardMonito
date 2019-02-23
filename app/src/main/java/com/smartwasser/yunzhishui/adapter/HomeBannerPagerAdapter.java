package com.smartwasser.yunzhishui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.NetworkImageView;
import com.smartwasser.yunzhishui.App;
import com.smartwasser.yunzhishui.bean.HomeResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsRedBaby;


/**
 * Created by xiongmc on 2015/12/24.
 */
public class HomeBannerPagerAdapter extends PagerAdapter {

    private HomeResponse mHomeResponse;

    public HomeBannerPagerAdapter(HomeResponse mData) {
        this.mHomeResponse = mData;
    }

    public void setHomeResponse(HomeResponse homeResponse) {
        this.mHomeResponse = homeResponse;
    }

    @Override
    public int getCount() {
        if (mHomeResponse == null && mHomeResponse.getHomeBanner() == null) {
            return 0;
        }
        return mHomeResponse.getHomeBanner().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        HomeResponse.HomeBannerEntity banner = mHomeResponse.getHomeBanner().get(position);
        NetworkImageView networkImageView = new NetworkImageView(App.application);
        networkImageView.setImageUrl(ConstantsRedBaby.URL_SERVER + banner.getPic(), HttpLoader.getImageLoader());
        container.addView(networkImageView);
        return networkImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
