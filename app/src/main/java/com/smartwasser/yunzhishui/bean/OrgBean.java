package com.smartwasser.yunzhishui.bean;


import com.smartwasser.yunzhishui.annotation.TreeNodeId;
import com.smartwasser.yunzhishui.annotation.TreeNodeLabel;
import com.smartwasser.yunzhishui.annotation.TreeNodePid;

public class OrgBean
{
	@TreeNodeId
	private String _id;
	@TreeNodePid
	private String parentId;
	@TreeNodeLabel
	private String name;
	public OrgBean(String _id,String parentId, String name)
	{
		this._id = _id;
		this.parentId = parentId;
		this.name = name;
	}
	public String get_id()
	{
		return _id;
	}
	public void set_id(String _id)
	{
		this._id = _id;
	}
	public String getParentId()
	{
		return parentId;
	}
	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

}
