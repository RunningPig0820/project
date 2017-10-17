package bag ;

import java.io.Serializable;


/*
	功能请求包
*/
public class User implements Serializable {  
    private static final long serialVersionUID = 1L;  
    private String function ; //choose function
	private String name ;  
    private String password ;  
  
    public User(){  

    }
	
	/*
		登录请求
	*/
    public User(String name, String password) {  
        this.name = name;  
        this.password = password;  
    }  
 
  
    public void setName(String name) {  
        this.name = name;  
    } 

    public void setPassword(String password) {  
        this.password = password;  
    }

    public String getName() {  
        return name;  
    } 

    public String getPassword() {  
        return password;  
    }  
        

 


}  