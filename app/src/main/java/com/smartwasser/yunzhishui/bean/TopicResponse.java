package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by xiongmc on 2015/12/23.
 */
public class TopicResponse extends RBResponse {

    /**
     * id : 10000
     * name : 雅培金装0
     * pic : images/image1.png
     */

    private List<TopicEntity> topic;

    public void setTopic(List<TopicEntity> topic) {
        this.topic = topic;
    }

    public List<TopicEntity> getTopic() {
        return topic;
    }

    public static class TopicEntity {
        private int id;
        private String name;
        private String pic;
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setPic(String pic) {
            this.pic = pic;
        }
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPic() {
            return pic;
        }
    }
}
