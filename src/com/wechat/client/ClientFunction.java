package com.wechat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class ClientFunction 
{		
	Socket s = null;
	DataOutputStream dos;
	DataInputStream dis;
	boolean bConnected;
	
	//connect
	public boolean getConnect()
	{
		return bConnected;
	}
	
	public void connect(){
		try {
			s = new Socket("127.0.0.1", 8888); 
			//建立客户端对象
	        dos = new DataOutputStream(s.getOutputStream());
	        dis = new DataInputStream(s.getInputStream());
	        bConnected = true;
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	           
	        }
	    }
	
	 public void disconnect() { //窗口关闭时关闭客户端，输入，输出
	        try {
	            dos.close();
	            dis.close();
	            s.close();
	        } catch (IOException e) {
	            
	            e.printStackTrace();
	        }
	    }
	
	 
	//send message to others
	public void sendMess(String message) throws UnknownHostException, IOException
	{
		dos.writeUTF(message);
		dos.flush();
		System.out.println("发送成功");
	}
	
	public String getMess()
	{
		try {
			return dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("退出了");
			return null;
		}
	}
	
	//send name to servers;
	
	
	
	
}
