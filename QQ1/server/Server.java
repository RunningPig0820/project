package server;

import java.util.HashMap;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.lang.Integer;
import java.lang.ClassNotFoundException;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.ServerSocket;  

import javax.swing.JOptionPane;

import mysql.Mysql;

import bag.User;
import bag.FriendsList;
import bag.Server_Client_Bean;

public class Server{
	
	private ServerSocket server = null;   
	private Socket socket = null ;  
	private ObjectOutputStream os = null;  //send Object
	private ObjectInputStream is = null;   // get Object
	
	private Integer identifier = 0 ; // Server_Client_Bean 的编号		
	
	private Mysql mysql = new Mysql();
	
	private int iport = 0;

	public Server(){
		try{
			server = new ServerSocket(10001);
			Sever_Client();
		}catch(IOException ex){
			System.out.println(ex);
		}
	}

	//服务器与客户端链接 起始端口为 10000
	public void Sever_Client(){				
		//匿名线程类
		new Thread(new Runnable(){
			public void run(){			
				while(true){
					try{
						socket = server.accept();
												
						os = new ObjectOutputStream(socket.getOutputStream()); 
						is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
						
						System.out.println(server);
						System.out.println(os);
						System.out.println(is);
						
						os.writeObject("server_client");  
						os.flush();
						
						os.writeObject(identifier);  						
						os.flush();	
						
						System.out.println("identifier = " + identifier + " : 链接成功");
											
						identifier ++ ;
						
						getclient();
													
					}catch(IOException ex){
						System.out.println(ex);
					}
				}
			}
		}).start();
	}

	//接受服务器信息	
	public void getclient(){
		//匿名线程类
		new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						
						System.out.println("Server_getclient");
						
						System.out.println(is);

						String choose = (String)is.readObject();
						System.out.println("Client_choose = : " + choose);
											
						if(choose.equals("user")){
							iport = (int)is.readObject();
							User user = (User)is.readObject();
							getiport((String)user.getName(),iport);
							getregister((String)user.getName(),(String)user.getPassword());											
						}
						
						
					}catch(ClassNotFoundException ex){
						System.out.println(ex);
					}catch(IOException ex) {  
						System.out.println(ex);
					}
				}

			} 
		}).start();				
	}

	
	//设置端口
	public void getiport(String User_Name,int iport){
		String sql = "UPDATE loginn SET iport = '" + iport + "' WHERE qq = '" + User_Name + "'";
		System.out.println(sql);
				
		try{
			mysql.updateSQL(sql);
		}catch (Exception ex){  
			System.out.println(ex);
		}
	}
	
	//接受登录请求	
	public void getregister(String User_Name,String User_Password){
		String sql = " select * from person where qq = '" + User_Name + "'and pws = '" + User_Password + "'";
		System.out.println(sql);
													
		ResultSet rs = mysql.selectSQL(sql);
		
		try{
			if(rs.next()){	
				
				System.out.println("register_success");
				os.writeObject("register_success");//发送登录请求
				os.flush();
				
				System.out.println("FriendsList");
				os.writeObject("FriendsList");//发送好友列表
				os.flush();
				
				sendFriendsList(User_Name);//发送好友列表
			}
		}catch (IOException ex){  
			System.out.println(ex);
		}catch(SQLException ex){
			System.out.println();
		}
	}
	
	//向客户端发送好友列表	
	public void sendFriendsList(String user_name){
		
		String sql = " select * from chat1 where person_qq = '" + user_name +"'";
		System.out.println(sql);
		ArrayList<String> list = new ArrayList<String>();

		try{
			ResultSet rs = mysql.selectSQL(sql);
			while(rs.next()){				
				list.add(rs.getString("person_qq"));
				list.add(rs.getString("person_name"));
				list.add(rs.getString("person_sign"));
				list.add(rs.getString("person_photo"));				
				list.add(rs.getString("friends_qq"));
				list.add(rs.getString("friends_name"));
				list.add(rs.getString("friends_sign"));
				list.add(rs.getString("friends_photo"));
			}
		}catch (SQLException ex) {
			System.out.println("显示时数据库出错。");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("显示出错。");
			ex.printStackTrace();
		}
		
		try{
			os.writeObject(new FriendsList(list));  
			os.flush();
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,"发送好友列表出错","标题",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args){		
		Server server = new Server();
	}
}