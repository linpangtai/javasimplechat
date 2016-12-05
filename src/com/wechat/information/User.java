package com.wechat.information;

public class User 
{
	public String id;
	public String name;
	
	public User(String id,String name)
	{
		this.id = id;
		this.name = name;;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getId()
	{
		return id;
	}
	
}
