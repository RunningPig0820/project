package server;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.lang.ClassNotFoundException;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.ServerSocket;  

import javax.swing.JOptionPane;

import mysql.Mysql;


public class Server_Chat_iport{
	
	private ServerSocket server = null;   
	private Socket socket = null ;  
	private ObjectOutputStream os = null;  //send Object
	private ObjectInputStream is = null;   // get Object
		
	private Mysql mysql = new Mysql();
	
	public Server_Chat_iport(){
		try{
			server = new ServerSocket(10003);
		}catch(IOException ex){
			System.out.println(ex);
		}
	}

	//服务器与客户端链接 起始端口为 10002
	public void Server_Chat_iport(){				
		//匿名线程类
		new Thread(new Runnable(){
			public void run(){			
				while(true){
					try{
						socket = server.accept();
												
						os = new ObjectOutputStream(socket.getOutputStream()); 
						is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
						
						System.out.println("Server_Chat_iport : success");

						String friends_qq = (String)is.readObject();
						System.out.println();
						System.out.println();
						System.out.println("Server_Chat_iport friends_iport : " + friends_qq);
						System.out.println();

						findiport(friends_qq);
						
					}catch(IOException ex){
						System.out.println(ex);
					}catch(ClassNotFoundException ex){
						System.out.println(ex);
					}
				}
			}
		}).start();
	}



	//查找好友端口
	public void findiport(String friends_qq){
		String sql = " select * from loginn where qq = '" + friends_qq + "'" ;
		System.out.println(sql);
													
		ResultSet rs = mysql.selectSQL(sql);
		
		try{
			if(rs.next()){	
				
				System.out.println("Server_Chat_iport iport_success ");
				int iport = rs.getInt("iport");	
				System.out.println("Server friendiport " + iport);
				
				os.writeObject(iport);
				os.flush();
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args){
		Server_Chat_iport server_chat_iport = new Server_Chat_iport();
		server_chat_iport.Server_Chat_iport();
	}
	
}