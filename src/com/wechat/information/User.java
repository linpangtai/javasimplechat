package com.wechat.information;

import java.net.Socket;

public class User 
{
	public String id;
	public String name;
	private Socket uSocket;
	
	public User(String id,String name,Socket sc)
	{
		this.id = id;
		this.name = name;
		this.uSocket = sc;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Socket getSocket()
	{
		return uSocket;
	}
	
	public String getId()
	{
		return id;
	}
	
}
