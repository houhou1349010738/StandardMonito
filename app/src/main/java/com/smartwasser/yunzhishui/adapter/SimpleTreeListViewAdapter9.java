package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeHepler;

import java.util.List;

public class SimpleTreeListViewAdapter9<T> extends TreeListViewAdapter<T>
{
	private int[]icon={R.drawable.traffic_01,R.drawable.traffic_02
	,R.drawable.traffic_03,R.drawable.traffic_04};
	private int[] iconSon={R.drawable.procurement_icon_07};
	public SimpleTreeListViewAdapter9(ListView tree, Context context,
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
			switch (node.getId()){
				case "20130227001":
					holder.mIcon.setImageResource(icon[0]);
					break;
				case "20130227002":
					holder.mIcon.setImageResource(icon[1]);
					break;
				case "20130227003":
					holder.mIcon.setImageResource(icon[2]);
					break;
				case "20130227018":
					holder.mIcon.setImageResource(icon[3]);
					break;
				default:
					holder.mIcon.setImageResource(icon[3]);
					break;
			}
		}else {
			switch (node.getId()){
				case "20130227001":
					holder.mIcon.setImageResource(icon[0]);
					break;
				case "20130227002":
					holder.mIcon.setImageResource(icon[1]);
					break;
				case "20130227003":
					holder.mIcon.setImageResource(icon[2]);
					break;
				case "20130227018":
					holder.mIcon.setImageResource(icon[3]);
					break;
				default:
					holder.mIcon.setImageResource(icon[3]);
					break;
			}
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
