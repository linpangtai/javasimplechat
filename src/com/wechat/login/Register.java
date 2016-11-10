package com.wechat.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.jdbc.Statement;

public class Register extends JFrame
{
	private JLabel account;
	private JLabel password;
	private JPanel Jp;

	private JTextField accTextFd;
	private JTextField pasTextFd;
	
	private JButton Jb1;
	private JButton Jb2;
	
	
	
	public void registe(String acc,String pas)
	{
		String url = "jdbc:mysql://127.0.0.1:3306/user";
        String name = "com.mysql.jdbc.Driver"; 
        String user = "root";  
        String password = "";  
        Connection conn = null;
        
        
        
        String sqlexc = "USE user";
        String sqlins = "insert into information (id,password) values"+'('+acc +','+ pas +')';
        
        //System.out.println(acc);
        //System.out.println(pas);
        
        
        
        java.sql.Statement stmt = null;
        
        try 
    	{
			Class.forName(name);
		}
    	
    	catch (ClassNotFoundException e1) 
    	{
			e1.printStackTrace();
		}
		
		try 
		{
			conn = DriverManager.getConnection(url , user , password ) ;
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			
		} 
    	System.out.println("链接成功");
    	
    	try
    	{
    		Statement stmt1 = (Statement) conn.createStatement();
    		stmt1.execute(sqlexc);
    		stmt1.execute(sqlins);
    	}
    	catch(Exception e1)
    	{
    		e1.printStackTrace();
    		System.out.println("hello");
    	}
        
        
	}
	public Register()
	{
		
		
		
		
		Jp = new JPanel();
		Jb1 = new JButton("注册");
		Jb2 = new JButton("取消");
		

		this.add(Jp);
		account = new JLabel("账号");
		password = new JLabel("密码");
		
		accTextFd = new JTextField(10);
		pasTextFd = new JTextField(10);
		Jp.add(account);
		Jp.add(accTextFd);
		Jp.add(password);
		Jp.add(pasTextFd);
		Jp.add(Jb1);
		Jp.add(Jb2);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setSize(150, 200);
		
    	
        
       
        
        
		Jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String acc = accTextFd.getText();
				String pas = pasTextFd.getText();
				
				if(acc != null || pas != null)
				{
					registe(acc,pas);
				}
			}
		});
		
		
		
	}
	
	public static void main(String args[]){
		new Register();
	}
	
}
