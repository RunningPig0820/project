import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

//机器人界面

public class jiqiren extends JFrame{

	static JTextField text1;
	static JTextArea t1;//可以输入多行的文本框
	static JLabel lbl1;
//	static JLabel lbl1;
	static String s="这是一个字符串演示文本\n";
	static String s1 ; //提问者输出的字符串

	public jiqiren(){
		super("文本框的文本区域测试程序");//引用父类，给文本框一个标题
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		lbl1=new JLabel("你想要问些什么呢？");
		c.add(lbl1);
		text1=new JTextField(35);
		c.add(text1);
		text1.addActionListener(new handler());//监听回车键

		t1=new JTextArea(s,30,30);
		c.add(t1);
		setSize(550,650);
		show();
	}
	
}

	