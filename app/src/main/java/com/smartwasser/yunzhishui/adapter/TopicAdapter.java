package com.smartwasser.yunzhishui.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.TopicResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsRedBaby;

/**
 * Created by xiongmc on 2015/12/23.
 */
public class TopicAdapter extends BaseAdapter {
    private Context mContext;
    private TopicResponse mTopic;
    public TopicAdapter(Context mContext, TopicResponse mTopic) {
        this.mContext = mContext;
        this.mTopic = mTopic;
    }
    public void setTopic(TopicResponse topic) {
        this.mTopic = topic;
    }
    @Override
    public int getCount() {
        if (mTopic == null && mTopic.getTopic() == null) {
            return 0;
        }
        return mTopic.getTopic().size();
    }

    @Override
    public Object getItem(int position) {
        return mTopic.getTopic().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View view;
        if (convertView != null && convertView instanceof RelativeLayout) {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        } else {
            view = View.inflate(mContext, R.layout.topic_item_activity, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        TopicResponse.TopicEntity topicEntity = mTopic.getTopic().get(position);
        holder.mTopicTV.setText(topicEntity.getName());
        //TODO
        HttpLoader.getImageLoader().get(ConstantsRedBaby.URL_SERVER + topicEntity.getPic(), ImageLoader.getImageListener(holder.mTopicIV, R.mipmap.ic_launcher, R.mipmap.ic_launcher));
        return view;
    }
    static class ViewHolder {
        TextView mTopicTV;
        ImageView mTopicIV;
        public ViewHolder(View view) {
            this.mTopicTV = (TextView) view.findViewById(R.id.topic_TV);
            this.mTopicIV = (ImageView) view.findViewById(R.id.topic_IV);
        }
    }
}
