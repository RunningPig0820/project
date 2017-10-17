package frame;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.sun.awt.AWTUtilities;
import java.awt.event.*;
import javax.swing.text.*;
import java.io.*;
import java.net.*;

import frame.JMPanel; 

public class talk_panel extends JFrame{
	
	int y = -30 ;

	private int pointx = 0 ;
	private int pointy = 0 ;	

	private JPanel showpanel = new JPanel();
	private JTextPane sendpanel = new JTextPane();
	private JButton closebutton = new JButton("-");
	private JButton minimizebutton = new JButton("×");
	private JButton iconbutton  = new JButton();
	private JButton sendbutton = new JButton("发送");
	private JLabel  namelabel  = new JLabel();
	private JScrollPane scroll = new JScrollPane(showpanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	private String person_qq = null ;
	private String person_name = null ;
	private String person_photo = null ;
	private String friends_qq = null ;
	private String friends_name = null ; 
	private String friends_photo = null ;
	
	private int friends_iport = 0;
	
	private FriendPanel friend = null ;
	
	public talk_panel(String person_qq,String person_name,String person_photo, String friends_qq, String friends_name,String friends_photo,int friends_iport){
		
		this.person_qq = person_qq ;
		this.person_name = person_name ;
		this.person_photo = person_photo ;
		this.friends_qq = friends_qq ;
		this.friends_name = friends_name ; 
		this.friends_photo = friends_photo;
		this.friends_iport = friends_iport;
		
		setLayout(null);

		setUndecorated(true);
		AWTUtilities.setWindowOpacity(this, 0.8f);   
		
		getContentPane().setBackground(new Color(200,60,200));				
		
		ImageIcon img = new ImageIcon(person_photo);
		img.setImage(img.getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH));		
		iconbutton.setIcon(img);
		namelabel.setText(person_name);
		
		iconbutton.setBounds(10,10,30,30);
		namelabel.setBounds(50,10,80,30);
		minimizebutton.setBounds(370,0,30,30);
		closebutton.setBounds(330,0,30,30);
		scroll.setBounds(40,60,300,280);
		showpanel.setBounds(40, 60, 300, 280);	
		sendpanel.setBounds(40,350,300,90);
		sendbutton.setBounds(350,410,40,30);

		iconbutton.setMargin(new Insets(0,0,0,0));
		minimizebutton.setMargin(new Insets(0,0,0,0));
		minimizebutton.setBackground(Color.white);
		closebutton.setMargin(new Insets(0,0,0,0));
		closebutton.setBackground(Color.white);
		sendbutton.setMargin(new Insets(0,0,0,0));
		sendbutton.setBackground(Color.white);

		add(iconbutton);
		add(namelabel);
		add(minimizebutton);
		add(closebutton);
		add(scroll);
		add(sendpanel);
		add(sendbutton);

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
		
		closebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		minimizebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		sendbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
				show(sendpanel.getText(),person_photo);			
			}
		});
	
		setSize(400, 460);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	
	//聊天气泡
	public void show(String send , String StringIMG){

		JButton jb = new JButton();
		ImageIcon img = new ImageIcon(StringIMG);				

		JLabel jlL = new JLabel(img);
		JLabel jl = new JLabel("       ");//使标签移入组件内部
		JLabel jl1 = new JLabel("       ");//使标签移入组件内部

		JPanel questionPane = new JPanel();//保证每次多为新的questionPane

		jb.setMargin(new Insets(0,0,0,0));
		jb.setBorder(null);
		img.setImage(img.getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH));		
		jb.add(jlL);

		JTextField jt = new JTextField(send);

		JMPanel t1 = new JMPanel(jt);//重绘JPanel 在getSize后创建,重绘气泡				
				
		showpanel.setLayout(null);	
		showpanel.add(questionPane);//添加组件	

		questionPane.add(jb);	
		questionPane.add(t1);		

		t1.add(jl);			
		t1.add(jt);
		t1.add(jl1);
				
		y = y + t1.getSizeHeight()+30;
		questionPane.setBounds(0,y,t1.getSizeWidth()+120,t1.getSizeHeight()+30);	
		showpanel.updateUI();

		t1.repaint();
		jt.setOpaque(false);
		
		questionPane.updateUI();
		scroll.updateUI();
	}	

}
