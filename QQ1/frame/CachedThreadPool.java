  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
/** 
 * @use 使用Executor显示的创建Thread对象 
 * @author Bird 
 * 
 */  
   
class LiftOff implements Runnable{//创建一个类实现Runable接口  
    protected int countDown = 10;  
    private static int taskCount = 0;  
    private final int id = taskCount++;  
    public LiftOff(){}  
    public LiftOff(int countDown){  
        this.countDown = countDown;  
    }  
      
    public String status(){  
        return "#"+id+"("+(countDown > 0 ? countDown : "Liftoff !" + ")");  
    }  
      
    public void run(){  
        while(countDown-- > 0){  
            System.out.println(status());  
            Thread.yield();  
        }  
    }  
}  
  
public class CachedThreadPool {  
    public static void main(String[] args){  
        ExecutorService exec = Executors.newCachedThreadPool();//创建线程池  
        for(int i = 0; i < 5; i++){  
            exec.execute(new LiftOff());//进行工作  
        }  
        exec.shutdown();  
    }  
}  