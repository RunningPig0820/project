//事件的响应
//需要对问题进行响应，即关键字与问题库进行匹配
//需要建立问题库（表） 和 应答库（表） 未建
			
import java.awt.event.*;
import java.util.Random;
			
public class handler implements ActionListener{			
		Random random=new Random();
		
//		简单的答案库
/*		
		String b[]={"你也好","我不好","你开心就好","你想干嘛"};
		String c[]={"我是应答机器人","朋友家的孩子","你猜猜","吼吼"};
		String d[]={"你又是谁？","那你是谁","你先说","恩？"};
*/		
		public void actionPerformed(ActionEvent e){	
			jiqiren.s1 = jiqiren.text1.getText();//链接了整个代码
			System.out.println("原始  jiqiren.s1 = " + jiqiren.s1);
				
//			简单长语句的分句
//			中文的逗好需要链表来存放“，”隔开之后的字段	
			
//			String[] arr=jiqiren.s1.split("，");
			
//			简单的分词系统	除去语句中的乱标点字符和非中文		
			fencixitong fcxt = new fencixitong(jiqiren.s1);
			jiqiren.s1 = fcxt.gg;
			System.out.println("分词系统 jiqiren.s1 = " + jiqiren.s1+"\n");
			
//          简单的应答器
			new yingdaqi(jiqiren.s1);
			System.out.println("***应答器  jiqiren.s1 = " + jiqiren.s1+"\n");
			
				
//			简单的关键字与问题库匹配
		
/*			for(int i=0 ; i<arr.length ; i++){				
				if(arr[i].equals("你好"))
					jiqiren.t1.append(arr[i]+"\n\t"+b[random.nextInt(b.length)]+"\n");//把字符串打印到JTextArea
				else if(arr[i].equals("你是谁"))
					jiqiren.t1.append(arr[i]+"\n\t"+c[random.nextInt(b.length)]+"\n");
				else if(arr[i].equals("你是谁？"))
					jiqiren.t1.append(arr[i]+"\n\t"+d[random.nextInt(b.length)]+"\n");
				else
					jiqiren.t1.append(arr[i]+"\n\t我什么都不知道（'#.#）\n");
			}
*/		}
				
}