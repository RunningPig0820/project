package frame;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.Integer;


public class Bregister extends JDialog{
	
	public Bregister(){					
	
		jf11.addFocusListener(s);
		jf12.addFocusListener(s);
		jf21.addFocusListener(s);
		jf22.addFocusListener(s);
		jf31.addFocusListener(s);
		jf32.addFocusListener(s);
		jf41.addFocusListener(s);
		jf42.addFocusListener(s);

		setLayout(null);
		getContentPane().setBackground(new Color(191,79,250)); 
		add(jp);
		jp.setBounds(0,150,480,350);
		setjp();
		
		setSize(500,700);
		setVisible(true);
		
	}

	JLabel jl1 = new JLabel("QQ : ");
	JLabel jl2 = new JLabel("密码 : ");
	JLabel jl3 = new JLabel("姓名 : ");
	JLabel jl4 = new JLabel("爱好 : ");
	JLabel jl5 = new JLabel("年龄 : ");
	JLabel jl6 = new JLabel("个性签名 ： ");

	JLabel jlc1 = new JLabel(" "); 
	JLabel jlc2 = new JLabel(" "); 
	JLabel jlc3 = new JLabel(" "); 
	JLabel jlc4 = new JLabel(" "); 
	JLabel jlc5 = new JLabel(" ");
	JLabel jlc6 = new JLabel(" ");
	
	JLabel zhiti = new JLabel("账号个人信息");

	JTextField jf11= new JTextField();
	JTextField jf12= new JTextField();
	JTextField jf21= new JTextField();
	JTextField jf22= new JTextField();
	JTextField jf31= new JTextField();
	JTextField jf32= new JTextField();
	JTextField jf41= new JTextField();
	JTextField jf42= new JTextField();
	JTextField jf51= new JTextField();
	JTextField jf52= new JTextField();
	JTextField jf6= new JTextField();

	JButton jb = new JButton("确   定");
	
	JPanel jp = new JPanel();

	handler s = new handler();
	
	private boolean b ;

	public void setb(boolean b){
		this.b = b ;
	}

	public boolean getb(){
		return b;
	}


	public void setjp(){
		jp.setLayout(null);
			
		zhiti.setFont(new Font("Dialog",  1,  15));
		zhiti.setForeground(new Color(191,79,250));
		jb.setFont(new Font("Dialog",  1,  15));
		jb.setForeground(new Color(191,79,250));
		jb.setBackground(new Color(200,200,60));

		zhiti.setBounds(200,20,100,40);
		
		jl1.setBounds(100,70,80,25);
		jlc1.setBounds(190,75,15,15);
		jf11.setBounds(220,70,110,25);
		jf12.setBounds(340,70,110,25);

		jl2.setBounds(100,100,80,25);
		jlc2.setBounds(190,105,15,15);
		jf21.setBounds(220,100,110,25);
		jf22.setBounds(340,100,110,25);
		
		jl3.setBounds(100,130,80,25);
		jlc3.setBounds(190,135,15,15);
		jf31.setBounds(220,130,110,25);
		jf32.setBounds(340,130,110,25);

		jl4.setBounds(100,160,80,25);
		jlc4.setBounds(190,165,15,15);
		jf41.setBounds(220,160,110,25);
		jf42.setBounds(340,160,110,25);

		jl5.setBounds(100,190,80,25);
		jlc5.setBounds(190,195,15,15);
		jf51.setBounds(220,190,110,25);
		jf52.setBounds(340,190,110,25);

		jl6.setBounds(100,220,80,25);
		jlc6.setBounds(190,225,15,15);
		jf6.setBounds(220,220,230,25);
		
		jb.setBounds(150,270,200,45);

		jp.add(zhiti);

		jp.add(jl1);
		jp.add(jl2);
		jp.add(jl3);
		jp.add(jl4);
		jp.add(jl5);
		
		jp.add(jlc1);
		jp.add(jlc2);
		jp.add(jlc3);
		jp.add(jlc4);
		jp.add(jlc5);

		jp.add(jf11);
		jp.add(jf12);
		jp.add(jf21);
		jp.add(jf22);
		jp.add(jf31);
		jp.add(jf32);
		jp.add(jf41);
		jp.add(jf42);
		jp.add(jf51);
		jp.add(jf52);
		jp.add(jf6);

		jp.add(jb);
	}
	
	class handler implements FocusListener{
		
		public boolean set(JTextField jl1 , JTextField jl2 ,JLabel jlc){
			if(jl1.getText().equals(jl2.getText())){
				jlc.setBackground(Color.green);
				jlc.setOpaque(true);
				return true;
			}else{
				jlc.setBackground(Color.red);
				jlc.setOpaque(true);
				return false;
			}
		}

		public void focusLost(FocusEvent e){
			
			boolean a1 = set(jf11,jf12,jlc1);
			boolean a2 = set(jf21,jf22,jlc2);
			boolean a3 = set(jf31,jf32,jlc3);
			boolean a4 = set(jf41,jf42,jlc4);
			boolean a5 = set(jf51,jf52,jlc5);

			setb(a1&&a2&&a3&&a4&&a5);
									
		} 

		public void focusGained(FocusEvent e) {}
	}



} 