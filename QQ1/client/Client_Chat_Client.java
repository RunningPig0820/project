package client;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;

public class Client_Chat_Client{
	
	private int friends_iport = 0;	
	private String friends_qq = null;
	private String friends_photo = null;

	private Socket socket = null ;
	
	private ObjectOutputStream os = null ;
	
	public Client_Chat_Client(int friends_iport , String friends_qq ,String friends_photo){
		
	 	this.friends_iport = friends_iport;
		this.friends_qq = friends_qq ;
		this.friends_photo = friends_photo ;

		try{
			int friends_iport1 = friends_iport + 2000 ;
			socket = new Socket("localhost",friends_iport1);
			os = new ObjectOutputStream(socket.getOutputStream());
			
			System.out.println();
			System.out.println("******************");
			System.out.println("talk_panel iport  : " + (friends_iport1));
			System.out.println("******************");
			System.out.println();

		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	
	//∑¢–≈œ¢
	public void send(String message){
		try{
						
			os.writeObject(friends_qq);
			os.writeObject(message);
			os.writeObject(friends_photo);
			os.flush();
			
			System.out.println();
			System.out.println("Client_Chat_Client ***********");
			System.out.println("friends_qq : " + friends_qq);
			System.out.println("message : " + message);
			System.out.println("friends_photo : " + friends_photo);
			System.out.println();

		
		}catch(IOException ex){
			System.out.println(ex);
		}
	}

}
