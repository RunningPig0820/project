  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
/** 
 * @use ʹ��Executor��ʾ�Ĵ���Thread���� 
 * @author Bird 
 * 
 */  
   
class LiftOff implements Runnable{//����һ����ʵ��Runable�ӿ�  
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
        ExecutorService exec = Executors.newCachedThreadPool();//�����̳߳�  
        for(int i = 0; i < 5; i++){  
            exec.execute(new LiftOff());//���й���  
        }  
        exec.shutdown();  
    }  
}  