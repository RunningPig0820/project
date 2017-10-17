package frame;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.lang.Integer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import javax.swing.JButton;
import javax.swing.*;

import java.net.URL;

import java.io.*;

import frame.Bregister; 
import bag.User;
import client.Client;

/*
   QQµÇÂ¼½çÃæ
*/
public class LoginForm extends JFrame{
	
	private int pointx = 0 , pointy = 0 ;
	public TitlePanel titlepanel = new TitlePanel();
	
	private JLabel head = new JLabel();	
	private ImageIcon headImg = new ImageIcon("E:/java20161/QQ/picture/QQ.png");
	
	private JLabel registered = new JLabel("×¢²áÕËºÅ");
	private JLabel retrievepassword = new JLabel("ÕÒ»ØÃÜÂë");
		
	private JTextField  QQid = new JTextField();
	private JPasswordField QQpassword = new JPasswordField();
	
	private JButton register = new JButton(" °² È« µÇ Â¼ ");

	public LoginForm(){

		setLayout(null);
		setSize(450,350);
		setUndecorated(true);			
	
		headImg.setImage(headImg.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH));	

		head.setIcon(headImg);
		
		head.setBounds(40,210,80,80);
		QQid.setBounds(130,210,200,30);
		registered.setBounds(350,210,100,30);
		QQpassword.setBounds(130,250,200,30);	
		retrievepassword.setBounds(350,250,100,30);
		register.setBounds(140,300,150,30);

		titlepanel.setBounds(0,0,450,200);
		

		register.addMouseListener(new RegisterHandler());

		add(titlepanel);
		add(head);
		add(QQid);
		add(QQpassword);
		add(register);
		add(registered);
		add(retrievepassword);

		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				pointx = e.getX();
				pointy = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){				
				setLocation(e.getXOnScreen()-pointx,e.getYOnScreen()-pointy);
			}
		});
		
		registered.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				new Bregister();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args)throws Exception{
		
		LoginForm a = new LoginForm();
		
	}

	class TitlePanel extends JPanel{
	
		private JButton closebutton = new JButton("¡Á");
		private JButton minimizebutton = new JButton("-");
			
		private TitlePanel(){
			
			setBackground(new Color(50,160,240));

			setLayout(null);
					
			minimizebutton.setBounds(410,0,20,20);
			closebutton.setBounds(430,0,20,20);
								
			minimizebutton.setBorder(null);
			minimizebutton.setBackground(new Color(50,160,240));
			minimizebutton.setMargin(new Insets(0,0,0,0));
			minimizebutton.setForeground(Color.white);
			minimizebutton.setFocusPainted(false);
			minimizebutton.setFont(new Font("ËÎÌå",Font.PLAIN,20));
			closebutton.setBorder(null);
			closebutton.setBackground(new Color(50,160,240));
			closebutton.setMargin(new Insets(0,0,0,0));
			closebutton.setForeground(Color.white);
			closebutton.setFocusPainted(false);
			closebutton.setFont(new Font("Ó×Ô²",Font.PLAIN,20));

			add(minimizebutton);
			add(closebutton);

			minimizebutton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					setExtendedState(JFrame.ICONIFIED);
				}
				public void mouseEntered(MouseEvent e){
					minimizebutton.setBackground(new Color(53,180,250));
				}
				public void mouseExited(MouseEvent e){
					minimizebutton.setBackground(new Color(50,160,240));
				}
			});
			
			closebutton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					dispose();
				}
				public void mouseEntered(MouseEvent e){
					closebutton.setBackground(new Color(214,32,32));
				}
				public void mouseExited(MouseEvent e){
					closebutton.setBackground(new Color(50,160,240));
				}
			});	
			
		} 
	}
	
	class RegisterHandler extends MouseAdapter{
		
		private String name ;
		private String password ;

		public void mousePressed(MouseEvent e){
			name = QQid.getText();
			password = QQpassword.getText();
			User user = new User(name,password);
			System.out.println(" 1. " + name+"   "+password);
			Client client = new Client(user);
			client.getserver();
		}
	
	}	

}
	
			