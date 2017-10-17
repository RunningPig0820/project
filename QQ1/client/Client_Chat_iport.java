package client;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;

import javax.swing.JOptionPane;

/*
 * 获取聊天好友端口
*/
public class Client_Chat_iport{	
	
	private Socket socket = null;			//link Server
	
	private ObjectInputStream is =  null  ;
	private ObjectOutputStream os = null ;
	
	private int iport = 0 ;

	public Client_Chat_iport(String friends_qq){
		send_iport(friends_qq);
	}
	 

	public void send_iport(String friends_qq){
					
		try{
			socket = new Socket("localhost",10003);
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));								
			
			System.out.println("Client_Chat_iport friends_qq : " + friends_qq);

			os.writeObject(friends_qq);
			os.flush();			

		}catch(IOException ex){
			System.out.println(ex);
		}
	
	}

	public int get_iport(){
		
		try{
			int friends_iport = (int)is.readObject();
			return friends_iport;
		}catch(IOException ex){
			System.out.println(ex);
		}catch(ClassNotFoundException ex){
			System.out.println(ex);
		}
				
		return 0;

	}
	
}	