package com.wechat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.wechat.client.ClientWindow;

public class ServerWindow 
{
	private boolean started;
	private ServerSocket ss;
	/*private JPanel content;
	private JTextArea viewArea;
	private JTextField viewField;
	private JList userList;
	private JButton banuser;
	private JButton noban;*/
	List<ChatClient> clients = new ArrayList<ChatClient>();
	
	public static void main(String args[])
	{
		ServerWindow sw = new ServerWindow();
		sw.start();
	}
	
	void start()
	{
		try 
		{
			ss = new ServerSocket(8888);
			started = true;
		}
		catch(BindException e)
		{
			System.out.println("端口使用中");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		while(started)
		{
			try {
				Socket s = ss.accept();
				ChatClient c = new ChatClient(s);
				c = new ChatClient(s);
				System.out.println("客户端成功连接");
				new Thread(c).start();
				clients.add(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	class ChatClient implements Runnable
	{
		private Socket s;
		DataInputStream dis;
		DataOutputStream dos;
		
		boolean bConnected;
		
		public ChatClient(Socket s) throws IOException
		{
			this.s = s;
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			bConnected = true;
		}
		
		
		void send(String str)
		{
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		public void run()
		{
			 try {
	                while (bConnected) {
	                    String str = dis.readUTF();
	                    //System.out.println(str);
	                    for (int i = 0; i < clients.size(); i++) {
	                        ChatClient c = clients.get(i);
	                        c.send(str);
	                    }
	                }
	            } catch (EOFException e) {
	                System.out.println("客戶端退出了");
	            } catch (IOException e) {
	                e.printStackTrace();
	            } finally {
	                if (dis != null)
	                    if (s != null)
	                        try {
	                            dis.close();
	                            s.close();
	                            dos.close();
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	            }
		}
	}
}
