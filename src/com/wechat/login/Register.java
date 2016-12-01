package com.wechat.login;

import java.awt.Dimension;
import java.awt.Toolkit;
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
	
	private int width;
	private int height;
	
	
	
	
	public Register()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth(); 
		
		Jp = new JPanel();
		Jb1 = new JButton("×¢²á");
		Jb2 = new JButton("È¡Ïû");
		

		this.add(Jp);
		account = new JLabel("ÕËºÅ");
		password = new JLabel("ÃÜÂë");
		
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
		this.setSize(150, 220);
		this.setLocation(width/2-140,height/2-200);
    	
        
       
        
        
		Jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String acc = accTextFd.getText();
				String pas = pasTextFd.getText();
				
				if(acc != null || pas != null)
				{
					LoginFunction lf = new LoginFunction();
					try {
						lf.register(acc,pas);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		Jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new Login();
				
			}
		});
		
		
	}
	
	public static void main(String args[]){
		new Register();
	}
	
}
