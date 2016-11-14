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
	private JPanel messagePanel;
	private JPanel buttonPanel;
	private int height;
	private int width;
	private JTextArea viewArea;
	private JTextField viewField;
	private JList userList;
	private JButton sendmessButton;
	
	
	
	private String[] str = {"monday","Tuesday","wednesday",
			"Thursday","friday","no",
			"hello","world","new","yes","ok","but","i","am","your",
			"father","haha","what","because",
			"thankyou","wa","we","do","this","together","thankyou",
			"wa","we","do","this","together"};
	public ClientWindow()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth();
		
		
		WestPanel = new JPanel(new BorderLayout());
		EastPanel = new JPanel();
		EastPanel.setBackground(Color.white);
		messagePanel = new JPanel(new BorderLayout());
		
		WestPanel.setPreferredSize(new Dimension(700,600));
		EastPanel.setPreferredSize(new Dimension(200,600));
		
		
		WestPanel.setBackground(Color.white);
		
		
		sendmessButton = new JButton("·¢ËÍ");
		
		
		
		userList  = new JList(str);	
		JScrollPane sp1 = new JScrollPane(userList);
		sp1.setPreferredSize(new Dimension(200,600));
		userList.setFixedCellWidth(200);
		
		viewArea = new JTextArea();
		viewField = new JTextField();

		//sp1.setVerticalScrollBarPolicy( 
				//JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JScrollPane sp2 = new JScrollPane(viewArea);
		
		//MessPane  = new JTextPane();
		//sendMessPane = new JTextArea(5,40);
		messagePanel.add(sp2,BorderLayout.CENTER);
		messagePanel.add(viewField,BorderLayout.SOUTH);
		
		
		WestPanel.add(messagePanel,BorderLayout.CENTER);
		WestPanel.add(sendmessButton,BorderLayout.SOUTH);
		
		EastPanel.add(sp1);
		
		
		this.add(WestPanel);
		this.add(EastPanel,BorderLayout.EAST);
		this.setLocation(width/2-450, height/2-300);
		this.setSize(900,600);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		
		
	}
	public static void main(String args[])
	{
		new ClientWindow();
	}
	
}
