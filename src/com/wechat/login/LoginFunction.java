package com.wechat.login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.wechat.client.ClientWindow;
import com.wechat.information.User;

public class LoginFunction 
{
	public LoginFunction()
	{
		
	}
	
	
	public void register(String acc,String pas) throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:mysql://127.0.0.1:3306/user";
        String name = "com.mysql.jdbc.Driver"; 
        String user = "root";  
        String password = "";  
        Connection conn = null;
        
        
        
        String sqlexc = "USE user";
        String sqlins = "insert into information (id,password) values"+'('+acc +','+ pas +')';
        
		Class.forName(name);
		conn = DriverManager.getConnection(url , user , password ) ;
    	System.out.println("connect success");

    	Statement stmt1 = (Statement) conn.createStatement();
    	stmt1.execute(sqlexc);
    	stmt1.execute(sqlins);
    	
        
        
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
        
        if(id != "" & psw != "")
        {
        	String use = "USE user";
            String select = "select * from information where id = " + id + " and password = "+ psw;
            
            stmt = con.createStatement();
    		stmt.execute(use);
    		isExist = stmt.execute(select);
    		
    		return isExist;
    	
        }
        else
        {
        	System.out.println("must have a id");
        	return isExist;
        }
		
	}
	
	public void Connect(String id) throws UnknownHostException, IOException
	{	
		ClientWindow cw = new ClientWindow(id);
		
	}
	

	
	/*public void sendinfor(String id) throws UnknownHostException, IOException
	{
		Socket s = new Socket("127.0.0.1",8888);
		OutputStream os = s.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write(id);
		pw.flush();
		pw.close();
		System.out.println("πÿ±’¡À");
		s.close();
	}*/
	
	
	
}
