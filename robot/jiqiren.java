import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

//�����˽���

public class jiqiren extends JFrame{

	static JTextField text1;
	static JTextArea t1;//����������е��ı���
	static JLabel lbl1;
//	static JLabel lbl1;
	static String s="����һ���ַ�����ʾ�ı�\n";
	static String s1 ; //������������ַ���

	public jiqiren(){
		super("�ı�����ı�������Գ���");//���ø��࣬���ı���һ������
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		lbl1=new JLabel("����Ҫ��Щʲô�أ�");
		c.add(lbl1);
		text1=new JTextField(35);
		c.add(text1);
		text1.addActionListener(new handler());//�����س���

		t1=new JTextArea(s,30,30);
		c.add(t1);
		setSize(550,650);
		show();
	}
	
}

	