package bag;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;


/*
	¿Í»§¶ËµÄBean
*/

public class Client_Bean implements Serializable {  

	private static final long serialVersionUID = 1L;  
	
	private String username = null ;
	private Socket socket = null ;
	private ObjectOutputStream os = null ;
	private ObjectInputStream in = null ; 
	
	public void setusername(String username){		
		this.username = username;
	}
	
	public void setsocket(Socket socket){		
		this.socket = socket;
	}

	public void setos(ObjectOutputStream os){		
		this.os = os;
	}

	public void setin(ObjectInputStream in){		
		this.in = in ;
	}
	

	public String getusername(Socket socket){
		return username;
	}

	public Socket getsocket(){
		return socket;
	}

	public ObjectOutputStream getos(ObjectOutputStream os){
		return os;
	}
	
	public ObjectInputStream getin(ObjectInputStream in){
		return in;
	}
} 