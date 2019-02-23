package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by xiongmc on 2015/12/24.
 */
public class HomeResponse extends RBResponse {

    /**
     * id : 0
     * pic : images/image1.png
     * title : 活动
     */

    private List<HomeBannerEntity> home_banner;
    public void setHomeBanner(List<HomeBannerEntity> home_banner) {
        this.home_banner = home_banner;
    }
    public List<HomeBannerEntity> getHomeBanner() {
        return home_banner;
    }

    public static class HomeBannerEntity {
        private int id;
        private String pic;
        private String title;

        public void setId(int id) {
            this.id = id;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public String getPic() {
            return pic;
        }

        public String getTitle() {
            return title;
        }
    }
}
