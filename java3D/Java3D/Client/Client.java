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
	
	public Bean bean;
	
	//����Server
	public Client(){
		try{
			
			socket_work		= new Socket("192.168.24.77",10001);
		
			os_work		= new ObjectOutputStream(socket_work.getOutputStream()); 
			is_work		= new ObjectInputStream(new BufferedInputStream(socket_work.getInputStream()));									
						
			bean = (Bean)is_work.readObject();
			
		}catch(IOException ex){
		//	System.out.println(ex);
			ex.printStackTrace();
		}catch(Exception ex){
		//	System.out.println(ex);
			ex.printStackTrace();
		}
	}
	
	
	public Bean getBean(){
		return bean;
	}

	/*
	public static void main(String[] args){
		Client client = new Client();		
	}
	*/
}	
	