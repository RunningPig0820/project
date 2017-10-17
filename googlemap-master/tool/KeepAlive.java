package tool;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//心跳包时间
public class KeepAlive implements Serializable{    
    /**
	 * 覆盖该方法 
     */  
    public String toString() {  
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  
    }  
  
}