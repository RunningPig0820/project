import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
	
	
/**
 * Client �ͻ���
 *
 * ���ϵȴ����ܷ�������������Ϣ���д���
 * ��ʱ����������ͱ���״̬���ڷ����������ͻ����̺߳��жϿͻ����Ƿ���
 * �ɽ��ܷ�����ǿ�йر�ָ��
 *	
 * @author ����
 * @version 1.0 2016-10-1 ����8:45
 */	
public class Client{
	
	
	private Socket socket_work	 ;	//�������Ӷ˿�
	
	public ObjectOutputStream os_work	;
	public ObjectInputStream is_work	;
	
	//public Bean[] bean = new Bean[2];
	public Bean[] bean = new Bean[2];

	//����Server
	public Client(){
		try{
			
			//socket_work		= new Socket("192.168.24.77",10001);
			socket_work		= new Socket("192.168.24.77",10001);

			os_work		= new ObjectOutputStream(socket_work.getOutputStream()); 
			is_work		= new ObjectInputStream(new BufferedInputStream(socket_work.getInputStream()));									
						
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void send(String string){
		try{
			if(string.equals("1")){
				os_work.writeObject(string);
				os_work.flush();
				bean[0] = (Bean)is_work.readObject();
			}else if(string.equals("2")){
				os_work.writeObject(string);
				os_work.flush();
				bean[1] = (Bean)is_work.readObject();
				System.out.println("WC");
			}

			


		}catch(IOException ex){
		//	System.out.println(ex);
			ex.printStackTrace();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
	}

	
	public Bean getBean(int i){
		return bean[i];
	}

}	
	