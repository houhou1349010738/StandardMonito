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

public class SimpleTreeListViewAdapter10<T> extends TreeListViewAdapter<T>

{
	private int[] icons=new int[]{R.drawable.parent1,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent5,R.drawable.parent6,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent1,R.drawable.parent6,R.drawable.parent1,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent5,R.drawable.parent1,R.drawable.parent2,R.drawable.parent3,R.drawable.parent4,R.drawable.parent5,R.drawable.parent6,R.drawable.parent2};
	private int[]iconSon=new int[]{R.drawable.son1,R.drawable.cha_1,R.drawable.cha_2,R.drawable.cha_3,R.drawable.cha_4,R.drawable.cha_5};
	private int[]icon=new int[]{R.drawable.menu_data,R.drawable.menu_query};
	public SimpleTreeListViewAdapter10(ListView tree, Context context,
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
				 case "142933221065480207173":
				 holder.mIcon.setImageResource(iconSon[0]);
				 break;
				 case "41C1133D770840F1A71950CD32CCD239":
				 holder.mIcon.setImageResource(iconSon[1]);
				 break;
				 case "21BBF13959D30787E050007F01000F7C":
				 holder.mIcon.setImageResource(iconSon[2]);
				 break;
				 case "E58D7C14CFE74B74B34F0AE150C57D55":
				 holder.mIcon.setImageResource(iconSon[3]);
				 break;
				 case "21D218793A4B911DE050007F010076FC":
				 holder.mIcon.setImageResource(iconSon[4]);
				 break;
				 case "BB99D6497B264551B14363D2ADDB911D":
				 holder.mIcon.setImageResource(iconSon[5]);
				 break;
			 }
		}else {
			if("1415245533015010434641".equals(node.getId())){
				holder.mIcon.setImageResource(icon[0]);
			}else if("8F61A8EBFBE1492F8A1CCF50F129D180".equals(node.getId())){
				holder.mIcon.setImageResource(icon[1]);
			}
			if("日报上报".equals(node.getName())) {
				holder.mIcon.setImageResource(icons[0]);
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
