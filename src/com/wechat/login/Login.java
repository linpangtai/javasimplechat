package com.wechat.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Login extends JFrame {
	private JLabel logo;
	private JLabel name;
	private JLabel password;
	private JButton close;
	private JButton login;
	private JButton resign;
	private JPanel NorthPane;
	private JPanel contentPane;
	private JLabel showImg;
	private JTextField textField;
	private JPasswordField passwordField;
	private final static int imgWidth=60;
	private final static int imgHeight=60;
	private int width;
	private int height;
	private int xx, yy;
	private boolean isDraging = false;
	static Point origin = new Point();
	
	
	public Login(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth(); 
		logo = new JLabel("WeChat");
		logo.setFont(new Font("Arial",0,15));
		logo.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		close = new JButton();
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setFocusPainted(false);
		close.setIcon(new ImageIcon("./img/close.gif"));
		
		NorthPane = new JPanel();
		NorthPane.setLayout(new BorderLayout());
		NorthPane.add(logo,BorderLayout.WEST);
		NorthPane.add(close,BorderLayout.EAST);
		NorthPane.setSize(280,50);
		
		JPanel Imgjp = new JPanel();
		showImg = new JLabel();
		ImageIcon headImage = new ImageIcon("./img/weixin.jpg");
		headImage.setImage(headImage.getImage().getScaledInstance(Login.imgWidth,Login.imgHeight,Image.SCALE_DEFAULT));
		showImg.setIcon(headImage);
		Imgjp.add(showImg);
		
		
		JPanel jpname = new JPanel();
		name = new JLabel("ÕËºÅ:");
		textField = new JTextField(16);
		jpname.add(name);
		jpname.add(textField);
		jpname.setBorder(new EmptyBorder(10,10,10,10));
		
		JPanel jppswd = new JPanel();
		password = new JLabel("ÃÜÂë:");
		passwordField = new JPasswordField(16);
		jppswd.add(password);
		jppswd.add(passwordField);
		
		JPanel jplogin = new JPanel();
		login = new JButton("µÇÂ¼");
		login.setBackground(Color.green);
		login.setForeground(Color.black);
		login.setBorderPainted(false);
		login.setFocusPainted(false);
		jplogin.setLayout(null);
		jplogin.add(login);
		login.setSize(220,40);
		login.setLocation(35, 0);
		
		resign = new JButton("×¢²á");
		JPanel jprs = new JPanel();
		jprs.setLayout(null);
		resign.setForeground(Color.black);
		resign.setBackground(Color.gray);
		resign.setBorderPainted(false);
		resign.setFocusPainted(false);
		resign.setBounds(115, 0, 60,40);

		jprs.add(resign);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(5,1));
		contentPane.add(Imgjp);
		contentPane.add(jpname);
		contentPane.add(jppswd);
		contentPane.add(jplogin);
		contentPane.add(jprs);
		contentPane.setBorder(new EmptyBorder(30,0,0,0));
		
		this.add(NorthPane,BorderLayout.NORTH);
		this.add(contentPane,BorderLayout.CENTER);
		this.setLocation(width/2-140,height/2-200);
		this.setUndecorated(true);
		this.setSize(280, 400);
		this.setVisible(true);
		
		//login button Action Listener 
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String id = textField.getText();
				String psw = passwordField.getText();
				LoginFunction lf = new LoginFunction();
				boolean Exist = false;
				try {
					Exist = lf.isExist(id, psw);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(Exist == true)
				{
					Socket socket = new Socket();
					try {
						socket = lf.Connect();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					System.out.println("login fail");
				}
				
			}
		});
		
		
		
		
		//register button Action Listener
		resign.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Register();
			}
		});
		
		
		
		
		//close button Action Listener
		close.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) { 
                System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				close.setContentAreaFilled(true);
				close.setBackground(Color.red);
				close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				close.setContentAreaFilled(false);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			});
		
		
		//NorthPane action listener
		NorthPane.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				isDraging = true;
				  
				xx = e.getX();
				  
				yy = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				isDraging = false;
			}
			
		});
		
		
		NorthPane.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if(isDraging){
					int left = getLocation().x;
					int top = getLocation().y;
					setLocation(left + e.getX() - xx, top + e.getY() - yy);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
	}
	
	
	public static void main(String args[]){
		new Login();
	}

}

