import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
	
	
/**
 * Client 客户端
 *
 * 不断等待接受服务器发来的消息进行处理
 * 定时向服务器发送本机状态用于服务器调整客户端线程和判断客户端是否存活
 * 可接受服务器强行关闭指令
 *	
 * @author 张敏
 * @version 1.0 2016-10-1 上午8:45
 */	
public class Client{
	
	
	private Socket socket_work	 ;	//工作链接端口
	
	public ObjectOutputStream os_work	;
	public ObjectInputStream is_work	;
	
	//public Bean[] bean = new Bean[2];
	public Bean[] bean = new Bean[2];

	//链接Server
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
	