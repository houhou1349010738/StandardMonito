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

public class SimpleTreeListViewAdapter6<T> extends TreeListViewAdapter<T>
{
	private int[]icon={R.drawable.fx_01,R.drawable.fx_02};
	private int[] iconSon={R.drawable.foold_01,R.drawable.foold_02,R.drawable.foold_03,R.drawable.foold_04,R.drawable.foold_05,R.drawable.foold_06};
	public SimpleTreeListViewAdapter6(ListView tree, Context context,
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
				case "1363597917410540442518":
					holder.mIcon.setImageResource(iconSon[0]);
				break;
				case "1366456400325340764868":
					holder.mIcon.setImageResource(iconSon[1]);
				break;
				case "1365673620104266382418":
					holder.mIcon.setImageResource(iconSon[2]);
				break;
				case "1363598006955630061048":
					holder.mIcon.setImageResource(iconSon[3]);
				break;
				case "136610681844140180465":
					holder.mIcon.setImageResource(iconSon[4]);
				break;
				case "136567639853784708567":
					holder.mIcon.setImageResource(iconSon[5]);
				break;
				default:
					holder.mIcon.setImageResource(iconSon[3]);
					break;
			}
		}else {
			if("汛情实况".equals(node.getName())){
				holder.mIcon.setImageResource(icon[0]);
			}else if("历史数据".equals(node.getParent())){
				holder.mIcon.setImageResource(icon[1]);
			}else{
				holder.mIcon.setImageResource(icon[1]);
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
