import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;

/**
 * ���巶Χ
 * 
 * @author ����
 * @version 1.0 2016-10-1 ���� 8:45
 */
public class Server{
	
	//�ͻ��˶����б�		

	private ServerSocket server_work	= null ;   
	
	private Socket socket_work		= null ;
	
	public ObjectInputStream  is_work;
	public ObjectOutputStream os_work;

	public Server(){

		try{			
			server_work   = new ServerSocket(10001); //�������Ӷ˿�						
		}catch(IOException ex){
			ex.printStackTrace();
		}

	}


	//���ܿͻ�����Ϣ
	//��������
	public void link(){
	//	while(true){
			try{								
				//���쳣
				socket_work   = server_work.accept();
				
				is_work		= new ObjectInputStream(new BufferedInputStream(socket_work.getInputStream()));
				os_work		= new ObjectOutputStream(socket_work.getOutputStream()); 			

			}catch(IOException ex){
				ex.printStackTrace();
			}catch(Exception ex){
				ex.printStackTrace();
			}			
	//	}
	}

	public static void main(String[] args){
		Server server = new Server();
		Bean bean = new Bean();
		
		

		server.link();

		Thread t2 = new Thread(
			new Runnable(){  
				@Override  
				public void run(){  			   
					try{
						while(true){ 
							System.out.println("����");
							String string = (String)server.is_work.readObject();
							
							System.out.println(string);

							if(string.equals("1")){
								Group_House house = new Group_House();
								bean.setSimple_Group(house);
							}else if(string.equals("2")){
								Group_House_Great house = new Group_House_Great();
								bean.setSimple_Group(house);
							}									
							server.os_work.writeObject(bean);
							server.os_work.flush();
						} 
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}  
			}  
        );  
        t2.start(); 
		

	}

}
