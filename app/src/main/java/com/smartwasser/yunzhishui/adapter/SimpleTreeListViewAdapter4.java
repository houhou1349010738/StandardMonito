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
public class SimpleTreeListViewAdapter4<T> extends TreeListViewAdapter<T>
{
	private int[]iconSon={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.f,R.drawable.g,R.drawable.c,R.drawable.d,R.drawable.f,R.drawable.c,R.drawable.d,R.drawable.yellowss,R.drawable.redss,R.drawable.blue,R.drawable.yellowss,R.drawable.blue,R.drawable.yellowss,R.drawable.redss,R.drawable.yellowss,R.drawable.blue,R.drawable.yellowss,R.drawable.blue,R.drawable.yellowss,R.drawable.yellowss,R.drawable.blue,R.drawable.yellowss,R.drawable.yellowss,R.drawable.blue,R.drawable.yellowss};
	private int[]icon=new int[]{R.drawable.feiyong,R.drawable.hetong};
	public SimpleTreeListViewAdapter4(ListView tree, Context context,
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
			    if("收款通知".equals(node.getName())){
					holder.mIcon.setImageResource(iconSon[11]);
				}else if("收款确认".equals(node.getName())){
					holder.mIcon.setImageResource(iconSon[12]);
				}else if("支付申请".equals(node.getName())){
					holder.mIcon.setImageResource(iconSon[13]);
				}else{
					holder.mIcon.setImageResource(iconSon[position]);
				}

		}else {
			if("费用报销".equals(node.getName())) {
				holder.mIcon.setImageResource(icon[0]);
			}else if("合同管理".equals(node.getName())){
				holder.mIcon.setImageResource(icon[1]);
			}else{
				holder.mIcon.setImageResource(icon[0]);
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
