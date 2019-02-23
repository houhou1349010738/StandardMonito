package com.smartwasser.yunzhishui.adapter;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeHepler;
public class SimpleTreeListViewAdapter<T> extends TreeListViewAdapter<T>

{
	private int[] icon=new int[]{R.drawable.parent1,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent5,R.drawable.parent6,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent1,R.drawable.parent6,R.drawable.parent1,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent5,R.drawable.parent1,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent5,R.drawable.parent6,R.drawable.parent2};
	private int[]iconSon=new int[]{R.drawable.son1,R.drawable.son2,R.drawable.son3,R.drawable.son4,R.drawable.son5,R.drawable.son6,R.drawable.son7,R.drawable.son8,R.drawable.son1,R.drawable.son3,R.drawable.son5,R.drawable.son4,R.drawable.son5,R.drawable.son6,R.drawable.son7,R.drawable.son8,R.drawable.son1,R.drawable.son3,R.drawable.son5,R.drawable.son1,R.drawable.son2,R.drawable.son3,R.drawable.son4,R.drawable.son5,R.drawable.son6,R.drawable.son7};
	public SimpleTreeListViewAdapter(ListView tree, Context context,
			List<T> datas, int defaultExpandLevel)
			throws IllegalArgumentException, IllegalAccessException
	{
		super(tree, context, datas, defaultExpandLevel);
	}
	@Override
	public View getConvertView(Node node, int position, View convertView,
			ViewGroup parent)
	{
		ViewHolder holder = null;
		if (convertView == null)
		{
			convertView = mInflater.inflate(R.layout.item_multi_datareport, parent, false);
			holder = new ViewHolder();
			holder.mIcon = (ImageView) convertView
					.findViewById(R.id.iv_item_multi);
			holder.mText = (TextView) convertView
					.findViewById(R.id.tv_ExlistView);
			convertView.setTag(holder);
			holder.item_pull = (ImageView) convertView
					.findViewById(R.id.item_pull);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		if (node.getIcon() == -1)
		{
			holder.item_pull .setVisibility(View.INVISIBLE);
		} else
		{
			holder.item_pull .setVisibility(View.VISIBLE);
			holder.item_pull .setImageResource(node.getIcon());
		}
		holder.mText.setText(node.getName());
		if(node.isleaf()){
			holder.mIcon.setImageResource(iconSon[position]);
		}else {
			holder.mIcon.setImageResource(icon[position]);
		}
		return convertView;
	}

	private class ViewHolder
	{
		ImageView mIcon,item_pull;
		TextView mText;
	}
	/**
	 * 动态插入节点
	 * 
	 * @param position
	 * @param string
	 */
	public void addExtraNode(int position, String string)
	{
		Node node = mVisibleNodes.get(position);
		int  indexOf = mAllNodes.indexOf(node);
		Node extraNode = new Node(null,node.getId(), string);
		extraNode.setParent(node);
		node.getChildre().add(extraNode);
		mAllNodes.add(indexOf + 1, extraNode);
		mVisibleNodes = TreeHepler.filterVisibleNodes(mAllNodes);
		notifyDataSetChanged();
	}
}
