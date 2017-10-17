package client;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

import bag.User;
import bag.FriendsList;

import frame.MainFrame;
import frame.FriendPanel;

import client.Client_Chat_Server;
import client.Client_Chat_iport;

/* 
 * ��¼����
*/
public class Client{
	
	private Socket socket = null;			//link Server
	private	ObjectOutputStream os = null;	//send Object
	private ObjectInputStream is =null;		//get Object
	
	private Integer identifier = 0 ;		//������
	
	private MainFrame mainframe = null ;			//QQ�����
	
	private FriendPanel friendpanel = null ; 
	
	private User user = null;
	
	private int iport;
	private int friend_iport ;

	//��ʼ��
	public Client(User user){
		Client_Server();
		this.user = user;
	}
	
	//����Server
	public void Client_Server(){
		try{

			socket = new Socket("localhost",10001);
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));					
			
			iport = socket.getLocalPort();
			
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,"Client��д����","����",JOptionPane.INFORMATION_MESSAGE);		
			System.out.println(ex);
		}
	}
	
	
	//���ܷ�������Ϣ	
	public void getserver(){
		//�����߳���
		new Thread(new Runnable(){
			public void run(){
				while(true){
					try{

						String choose = (String)is.readObject();
						System.out.println("Client_choose = : " + choose);
											
						if(choose.equals("server_client")){
							identifier = (Integer)is.readObject();
							System.out.println("identifier = " + identifier + " :  server_client ");
							
							register(user);
						}
	
						if(choose.equals("register_success")){
							System.out.println("register_success");						
							mainframe = new MainFrame(iport);			
						}

						if(choose.equals("FriendsList")){
							System.out.println("FriendsList");
							FriendsList friend = (FriendsList)is.readObject();
							getFriendsList(friend);
						}

						if(choose.equals("iport_success")){
							System.out.println("iport_success");
							friend_iport = (int)is.readObject();
							System.out.println(" Client  getServer  : " + friend_iport);
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
	
	//���¼������������¼��֤
	public void register(User user){						
		try{
			
			System.out.println("��¼");
			
			os.writeObject("user");
			os.flush();

			os.writeObject(iport);
			os.flush();

			os.writeObject(user);  
			os.flush();

		}catch(IOException ex) {  
			System.out.println(ex);
		} 
	}
	
	//��ȡ�����б�	
	public void getFriendsList(FriendsList friend){

		ArrayList<String> list = friend.getFriends();
		
		for(int i = 0;i < list.size(); i = i + 8){
	
			System.out.println("Client list.size()    :  " + list.size());
			
			System.out.println("Client getFriendsList : friends_iport " + friend_iport + "  User qq  :  " + (String)list.get(i));

			friendpanel = new FriendPanel((String)list.get(i),(String)list.get(i+1),(String)list.get(i+2),(String)list.get(i+3),(String)list.get(i+4),(String)list.get(i+5),(String)list.get(i+6),(String)list.get(i+7),iport);

			mainframe.client_chat_server.putlist((String)list.get(i+4),friendpanel);
			
			mainframe.addChatPanel(friendpanel);
			
			friendpanel.updateUI();
			
		}

		mainframe.repaint();

	}

} 