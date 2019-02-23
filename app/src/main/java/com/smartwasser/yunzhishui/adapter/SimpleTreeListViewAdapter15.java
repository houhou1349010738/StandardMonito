package com.smartwasser.yunzhishui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.utils.Node;
import com.smartwasser.yunzhishui.utils.TreeHepler;

import java.util.HashMap;
import java.util.List;

public class SimpleTreeListViewAdapter15<T> extends TreeListViewAdapter2<T>

{
	// 用来控制CheckBox的选中状况
	private ViewHolder holder = null;
	private  HashMap<Integer,Boolean> isSelecteds = new HashMap<Integer, Boolean>();
	public SimpleTreeListViewAdapter15(ListView tree, Context context,
									   List<T> datas, int defaultExpandLevel)
			throws IllegalArgumentException, IllegalAccessException
	{
		super(tree, context, datas, defaultExpandLevel);
		initDate();
	}
	// 初始化isSelected的数据
	private void initDate(){
		for(int i=0; i<mAllNodes.size()+20;i++) {
			getIsSelected().put(i,false);
		}
	}
	@Override
	public View getConvertView(Node node, final int position, View convertView,
			ViewGroup parent)
	{

		if (convertView == null)
		{
			convertView = mInflater.inflate(R.layout.item_multi_datareport2, parent, false);
			holder = new ViewHolder();
			holder.mIcon = (ImageView) convertView
					.findViewById(R.id.iv_item_multi);
			holder.mText = (TextView) convertView
					.findViewById(R.id.tv_ExlistView);
			holder.checkBox= (CheckBox)convertView
					.findViewById(R.id.check_danwei);
			convertView.setTag(holder);
			holder.item_pull = (ImageButton) convertView
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
		holder.checkBox.setChecked(getIsSelected().get(position));
		/*holder.checkBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (holder.checkBox.isClickable()) {
					getIsSelected().put(position, false);
				} else {
					getIsSelected().put(position, true);
				}
			}
		});*/
		holder.item_pull.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				expandOrCollapse(position);
				   /**判断是否是展开*/
				/*if (mListener != null)
				{
					mListener.onClick(mVisibleNodes.get(position), position);
				}*/

			}
		});
	/*mTree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				*//*if (holder.checkBox.isClickable()) {
					getIsSelected().put(position, false);
				} else {
					getIsSelected().put(position, true);
				}*//*
				if (mListener != null)
				{
					mListener.onClick(mVisibleNodes.get(position), position);
				}
			}
		});*/
		return convertView;
	}
	private class ViewHolder
	{
		ImageView mIcon;
		ImageButton item_pull;
		TextView mText;
		CheckBox checkBox;
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
	public  HashMap<Integer,Boolean> getIsSelected(){
		   return isSelecteds;
	}
	public  void setIsSelected(HashMap<Integer,Boolean> isSelected) {
		      isSelecteds = isSelected;
	}
}
