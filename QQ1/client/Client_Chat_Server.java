package client;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

import java.util.HashMap;

import frame.FriendPanel;

//聊天服务器
public class Client_Chat_Server{	
	
	private Socket socket = null;			//link Server
	
	private ObjectInputStream is =  null  ;	
	
	public HashMap<String,FriendPanel> FriendPanel_list = new HashMap<String,FriendPanel>();

	private String person_qq = null;

	public Client_Chat_Server(int person_iport){
		S_getmessage(person_iport);
	}
	
	public void putlist(String qq ,FriendPanel friendpanel ){
		FriendPanel_list.put(qq,friendpanel);
	}

	//服务器接受消息
	public void S_getmessage(int person_iport){	
		try{
			int person_iport1 = person_iport + 2000 ;
			ServerSocket server = new ServerSocket(person_iport1);
			
			System.out.println();
			System.out.println("******************");
			System.out.println("Client_Chat_Server :  " + person_iport1);
			System.out.println("******************");
			System.out.println();

			//匿名线程类
			new Thread(new Runnable(){
				public void run(){			
					Socket sockett = null;

					while(true){
						try{

							socket = server.accept();
							
							is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
							
							getmessage(is);
							

						}catch(IOException ex){
							System.out.println(ex);
						}
					}
				}
			}).start();

		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	
	//服务器接受消息
	public void getmessage(ObjectInputStream iis){	
		
		//匿名线程类
		new Thread(new Runnable(){
			public void run(){			
				while(true){
					try{
						
						String qq = (String)iis.readObject();
						System.out.println(qq);
						
						String message = (String)iis.readObject();
						System.out.println(message);
						
						String head = (String)iis.readObject();
						System.out.println(head);
						
						System.out.println();
						System.out.println("Client_Chat_Server qq : " + qq);
						System.out.println("Client_Chat_Server message : " + message);
						System.out.println("Client_Chat_Server head : " + head);	
						System.out.println();
						
						//FriendPanel_list.get(qq).talk.show(message,head);

					}catch(IOException ex){
						System.out.println(ex);
					}catch(ClassNotFoundException ex){
						System.out.println(ex);
					}
				}
			}
		}).start();

	}


}