import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class jiqiren3 extends JFrame{
	JFrame frame = new JFrame();
	JPanel jp = new JPanel(); 
	JLabel label1 = new JLabel("��������Ҫѵ��������  : ");
	JLabel label2 = new JLabel("��������Ҫѵ���Ĵ�  : ");	
	JTextField text1 = new JTextField(25);
	JTextField text2 = new JTextField(25);
	JButton jb1 = new JButton("ȷ��");
	JButton jb2 = new JButton("�˳�");

	public jiqiren3(){
		frame.getContentPane().add(jp);
		jp.add(label1);
		jp.add(text1);
		jp.add(label2);
		jp.add(text2);
		jp.add(jb1);
		jp.add(jb2);
		
		text1.addActionListener(new handler4());
		text1.addActionListener(new handler4());
		jb1.addActionListener(new handler4());
		jb2.addActionListener(new handler4());

		frame.setSize(300,200);
		frame.setVisible(true);
	}
	
	class handler4 implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			MySQL3 ms = new MySQL3();
			ms.connSQL();		
			if(e.getActionCommand().equals("ȷ��") ){
				String insert = "insert into linshiku(wenti,daan) values(\"" + text1.getText() + "\",\"" + text2.getText() + "\")";	
				String insert1 = "insert into yingdaku(wenti,daan) values(\"" + text1.getText() + "\",\"" + text2.getText() + "\")";	
				String insert2 = "insert into fenci(suoyin,ciyu,pinglv,cixing) values(0,\""+ text1.getText() +"\",0,0)";	
				System.out.println(insert);	
				System.out.println(text1.getText() != null);
				System.out.println(!text1.getText().isEmpty());
				System.out.println(text2.getText() != null);	
				System.out.println(!text2.getText().isEmpty());	  	
				if( text1.getText() != null  && text2.getText() != null && !text1.getText().isEmpty()  && !text2.getText().isEmpty()){					
					ms.insertSQL(insert);
					ms.insertSQL(insert1);
					ms.insertSQL(insert2);
					JOptionPane.showMessageDialog(null,"ѵ���ɹ�","��ʾ��Ϣ",JOptionPane.PLAIN_MESSAGE);			
				}else{
					JOptionPane.showMessageDialog(null,"ѵ������","��ʾ��Ϣ",JOptionPane.PLAIN_MESSAGE);					
				}
				frame.setVisible(false);
			}else if(e.getActionCommand().equals("�˳�")){
				JOptionPane.showMessageDialog(null,"�˳�ѵ��","��ʾ��Ϣ",JOptionPane.PLAIN_MESSAGE);
				frame.setVisible(false);
			}
			ms.deconnSQL();
		}			
	}	
/*
	public static void main(String[] args){
		new jiqiren3();
	}
*/
}