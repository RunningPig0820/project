package bag;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;


/*
	客户端与服务器的Bean
*/

public class Client_Iport implements Serializable {  

	private static final long serialVersionUID = 1L;  
	
	private String username = null;
	private String iport = null;

	public void setusername(String username){		
		this.username = username;
	}
	
	public void setiport(String iport){		
		this.iport = iport;
	}

	public String getusername(){
		return username;
	}

	public String getiport(){
		return iport;
	}
} 