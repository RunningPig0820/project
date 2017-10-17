package bag ;

import java.io.Serializable;

/*
	µÇÂ¼Ê§°Ü»ØÓ¦°ü
*/
public class Failure implements Serializable {  
    private static final long serialVersionUID = 1L;  
    private String status;  
  
    public Failure() {            
    }  
      
    public Failure(String status) {  
        setstatus(status);  
    }  
     
     public void setstatus(String status) {  
        this.status = status;  
    }  

    public String getstatus() {  
        return status;  
    }  
  

}  