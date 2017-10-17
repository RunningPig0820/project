import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class jiqiren3 extends JFrame{
	JFrame frame = new JFrame();
	JPanel jp = new JPanel(); 
	JLabel label1 = new JLabel("请输入你要训练的问题  : ");
	JLabel label2 = new JLabel("请输入你要训练的答案  : ");	
	JTextField text1 = new JTextField(25);
	JTextField text2 = new JTextField(25);
	JButton jb1 = new JButton("确定");
	JButton jb2 = new JButton("退出");

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
			if(e.getActionCommand().equals("确定") ){
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
					JOptionPane.showMessageDialog(null,"训练成功","提示信息",JOptionPane.PLAIN_MESSAGE);			
				}else{
					JOptionPane.showMessageDialog(null,"训练出错","提示信息",JOptionPane.PLAIN_MESSAGE);					
				}
				frame.setVisible(false);
			}else if(e.getActionCommand().equals("退出")){
				JOptionPane.showMessageDialog(null,"退出训练","提示信息",JOptionPane.PLAIN_MESSAGE);
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