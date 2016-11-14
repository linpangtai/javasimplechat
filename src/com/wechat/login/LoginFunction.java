package com.wechat.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFunction 
{
	public LoginFunction()
	{
		
	}
	
	public boolean isExist(String id,String psw) throws SQLException, ClassNotFoundException
	{
		Connection con = null;  
    	String url = "jdbc:mysql://127.0.0.1:3306/user";
        String name = "com.mysql.jdbc.Driver"; 
        String user = "root";  
        String password = "";  
        java.sql.Statement stmt = null;
        boolean isExist = false;
        
        Class.forName(name);
        con = DriverManager.getConnection(url , user , password ) ; 
        System.out.println("connect success");
        
        String sql1 = "USE user";
        String sql2 = "select * from information";
        
        stmt = con.createStatement();
		stmt.execute(sql1);
		ResultSet rs = stmt.executeQuery(sql2);
		
		while (rs.next()){
			String namelist = rs.getString(1);
			String passwordlist = rs.getString(2);
			if(namelist.equals(name))
			{
				if(passwordlist.equals(psw))
				{
					System.out.println("login in success!");
					isExist = true;
					break;
				}
				else
				{
					continue;
				}
			}
			else
			{
				System.out.println("sorry,user can't be found");
				isExist = false;
				return isExist;
			}
        }
		return isExist;
       
	}
	
	public boolean isConnect()
	{
		return false;
		
	}
	
	
	
}
