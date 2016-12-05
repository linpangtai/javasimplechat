package com.wechat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

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
	private ClientFunction cf;
	private String[] str = {"abc"};
	
	public ClientWindow(String id)
	{
		cf = new ClientFunction();
		cf.connect();
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
		
		
		sendmessButton = new JButton("发送");
		
		sendmessButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String str = viewField.getText();
						viewField.setText("");
						try {
							cf.sendMess(id+":"+str);
							//System.out.println("经过了此过程");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
		
		
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
		this.setTitle(id);
		//this.setDefaultCloseOperation(3);
		
		this.addWindowListener(new WindowAdapter() { //响应关闭窗口事件
            public void windowClosing(WindowEvent e) {
                cf.disconnect();
                System.exit(0);
            }
        });
		
		//cf.connect();
		recvThread r = new recvThread(); 
		new Thread(r).start();

		}
		class recvThread implements Runnable {
			public String message;// 客户端线程接收数据
			public void run() {
				while (true) {
					String str;
					str = cf.getMess();
					message += str;// 拿到数据
					viewArea.setText(viewArea.getText() + str + "\n");
					
				}
			}
		
	}
	
	public static void main(String args[])
	{
		
		
	}
	
}
