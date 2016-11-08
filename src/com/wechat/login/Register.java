package com.wechat.login;

import javax.swing.*;

public class Register extends JFrame
{
	private JLabel account;
	private JLabel password;
	private JPanel Jp;

	private JTextField accTextFd;
	private JTextField pasTextFd;
	
	private JButton Jb1;
	private JButton Jb2;
	
	public Register()
	{
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
		this.setSize(150, 200);
	}
	
	public static void main(String args[]){
		new Register();
	}
	
}
