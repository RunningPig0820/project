import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

class PanelTest1 extends JPanel{			
	Image im = Toolkit.getDefaultToolkit().getImage("E:\\cs\\456.jpg");				
	public void paintComponent(Graphics g){
		g.drawImage(im,0,0,null);
	}
}

class PanelTest2 extends JPanel{		 	
	Image im = Toolkit.getDefaultToolkit().getImage("E:\\cs\\456.jpg");				
	public void paintComponent(Graphics g){
		g.drawImage(im,0,0,null);
	}
}

class PanelTest3 extends JPanel{			
	Image im = Toolkit.getDefaultToolkit().getImage("E:\\cs\\000.jpg");				
	public void paintComponent(Graphics g){
		g.drawImage(im,0,0,null);
	}
}

public class jiqiren2 extends JFrame{

	JFrame frame=new JFrame("������");     //��������		
	JPanel jp  = new JPanel(); //�����
	PanelTest1 jp1 = new PanelTest1(); //����
	PanelTest2 jp2 = new PanelTest2(); //��ť
	PanelTest3 jp3 = new PanelTest3(); //��ʾ����
	ImageIcon image = new ImageIcon("E:\\cs\\123.jpg");	
	JLabel label = new JLabel(image);
	JLabel label1 = new JLabel("�������������    :   ");
	JButton jb = new JButton("ѵ��");

	static JTextField text1 = new JTextField(40);
	static JTextArea t1 = new JTextArea(25,30);//����������е��ı���
	static String s="����һ���ַ�����ʾ�ı�\n";
	static String s1 ; //������������ַ���	
	
	public jiqiren2(){
		t1.setForeground(Color.RED);
		Font x = new Font("Serif",1,18);
		t1.setFont(x);
		
		jp.setLayout(null);//��jpΪ�ղ���
		jp1.setBounds(0,0,800,50);
		jp2.setBounds(0,50,200,600);
		jp3.setBounds(200,50,600,600);	
		
		jp1.setBorder (BorderFactory.createRaisedBevelBorder());
		jp2.setBorder (BorderFactory.createLoweredBevelBorder());
		jp3.setBorder (BorderFactory.createRaisedBevelBorder());	
		
		JScrollPane pane = new JScrollPane(t1);
		t1.setOpaque(false);		
		pane.setOpaque(false);
		pane.getViewport().setOpaque(false);
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		jp1.add(label1);
		jp1.add(text1);
		jp1.add(jb);
		jp2.add(label);
		jp3.add(pane);
		
		text1.addActionListener(new handler2());//�����س���
		jb.addActionListener(new handler3());
		
		text1.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent e){
				System.out.println(e.getKeyCode());
			 }			
		});

		frame.add(jp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,750);		
		frame.setVisible(true);
	}

	public static void main(String args[]){
		new jiqiren2();
	}
	
}
