package frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.tree.*;
import javax.swing.text.AbstractDocument.BranchElement;

import java.util.HashMap;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.ServerSocket;

import frame.talk_panel;

import client.Client_Chat_iport;

//∫√”—√Ê∞Â
public class FriendPanel extends JButton{
	
	private JLabel nickname = new JLabel();
	private JLabel sign = new JLabel();
	private String person_qq = null ;
	private String person_name = null ;
	private String person_sign = null ;
	private String person_photo = null ;
	private String friends_qq = null ;
	private String friends_name = null ; 
	private String friends_sign = null ;
	private String friends_photo = null ;
	
	private int person_iport = 0 ;

	private Socket socket = null;			//link Server
	
	private ObjectInputStream is =  null  ;
	private ObjectOutputStream os = null ;

	public talk_panel talk = null;
	
	private Client_Chat_iport client_chat_iport = null ;

	public FriendPanel(String person_qq ,String person_name, String person_sign, String person_photo, String friends_qq, String friends_name, String friends_sign ,String friends_photo,int person_iport){
		
		setfriendpanel(friends_name,friends_sign,friends_photo);

		this.person_qq = person_qq ;
		this.person_name = person_name ;
		this.person_sign = person_sign ;
		this.person_photo = person_photo ;
		this.friends_qq = friends_qq ;
		this.friends_name = friends_name ; 
		this.friends_sign = friends_sign ;
		this.friends_photo = friends_photo;
		this.person_iport = person_iport;
		
		client_chat_iport = new Client_Chat_iport(friends_qq);

	}

	public void setfriendpanel(String nicknamestring,String signstring ,String img){
		
		setBorder(null);
		setLayout(null);
		setjp(nicknamestring,signstring,img);
		setBackground(new Color(238,238,238));

		addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				setBackground(new Color(224,212,83));
			} 
			
			public void mouseExited(MouseEvent e){
				setBackground(new Color(238,238,238));
			}
			
			public void mousePressed(MouseEvent e){			
				System.out.println("FriendPanel_MouseEvent friends_qq  : " + friends_qq);
				int friends_iport = client_chat_iport.get_iport();
				talk = new talk_panel(person_qq,person_name,person_photo,friends_qq,friends_name,friends_photo,friends_iport);			
			}

		});
	}
	
	public void setjp(String nicknamestring,String signstring ,String imgstring){
		
		ImageIcon img = new ImageIcon(imgstring);
		nickname.setText(nicknamestring);
		sign.setText(signstring);
		img.setImage(img.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH));
		
		JLabel photoID = new JLabel(img);
		
		photoID.setBounds(3,3,40,40);
		nickname.setBounds(60,0,190,20);
		sign.setBounds(60,25,190,25);
		
		add(photoID);
		add(nickname);
		add(sign);
	}
	
}