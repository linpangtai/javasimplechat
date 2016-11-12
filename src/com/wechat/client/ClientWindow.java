package com.wechat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.*;

public class ClientWindow extends JFrame
{
	private JPanel WestPanel;
	private JPanel EastPanel;
	private int height;
	private int width;
	private JTextArea viewArea;
	private JTextField viewField;
	private JList userList;
	
	private String[] str = {"monday","Tuesday","wednesday",
			"Thursday","friday","no",
			"hello","world","new","yes"};
	public ClientWindow()
	{
		this.setLayout(new GridLayout(1,2));
		WestPanel = new JPanel(new BorderLayout());
		EastPanel = new JPanel();
	
		WestPanel.setBackground(Color.white);
		
		userList  = new JList(str);	
		userList.setFixedCellWidth(200);
		
		viewArea = new JTextArea();
		viewField = new JTextField(2);
		JScrollPane sp1 = new JScrollPane(userList);
		JScrollPane sp2 = new JScrollPane(viewArea);
		
		//MessPane  = new JTextPane();
		//sendMessPane = new JTextArea(5,40);
		
		
		WestPanel.add(sp2,BorderLayout.CENTER);
		WestPanel.add(viewField,BorderLayout.SOUTH);
		
		
		EastPanel.add(userList);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth();
		
		this.add(WestPanel,BorderLayout.WEST);
		this.add(EastPanel,BorderLayout.EAST);
		this.setLocation(width/2-450, height/2-300);
		this.setSize(900,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		
	}
	public static void main(String args[])
	{
		new ClientWindow();
	}
	
}
