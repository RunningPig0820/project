//事件的响应
//需要对问题进行响应，即关键字与问题库进行匹配
//需要建立问题库（表） 和 应答库（表） 建立
//开启字符录入周期、字符数、语言类型、MOUSE移动周期、键盘击打周期、重复与修改字符收集）
			
import java.awt.event.*;
import java.util.Random;
			
public class handler2 implements ActionListener{			
			
		public void actionPerformed(ActionEvent e){	
			jiqiren2.s1 = jiqiren2.text1.getText();//链接了整个代码
			System.out.println("原始  jiqiren.s1 = " + jiqiren2.s1);
			
//简单的分词系统	除去语句中的乱标点字符和非中文		
			fencixitong fcxt = new fencixitong(jiqiren2.s1);
			jiqiren2.s1 = fcxt.gg;
			System.out.println("分词系统 jiqiren.s1 = " + jiqiren2.s1+"\n");
			
//          简单的应答器
			new yingdaqi(jiqiren2.s1);
			System.out.println("***应答器  jiqiren.s1 = " + jiqiren2.s1+"\n");			
		}				
}