package server;

import java.io.BufferedInputStream;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.Vector;

public class Server_Frame extends JFrame{
	
	private JPanel panel = new JPanel();//�����
	
	private JMenuBar menubar = new JMenuBar();//�˵���
	
	private JMenu exitMenu = new JMenu("�˳�");
	private JMenu operateMenu = new JMenu("����");
	private JMenu helpMenu = new JMenu("����");
	
	private JMenuItem exitnMenuItem= new JMenuItem("�˳�");
	private JMenuItem restartMenuItem= new JMenuItem("����������");
	private JMenuItem closeMenuItem= new JMenuItem("�رշ�����");
	private JMenuItem helpMenuItem = new JMenuItem("����");
	
	private Table j1 = new Table();   //�������
	private JPanel j3 = new JPanel(); //����ϵͳ��Ϣ
	private JPanel j2 = new JPanel(); //ϵͳ��־
	private JPanel j4 = new JPanel(); //ϵͳ����
	
	private JTabbedPane tab = new JTabbedPane();	

	public Server_Frame(){
		
		setLayout(null);
		
		setpanel();

		setSize(620,450);
		panel.setBounds(0,0,600,400);
		
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	//���������	
	public void setpanel(){
		panel.setLayout(null);

		menubar.setBounds(0,0,600,30);
		
		tab.setBounds(0, 30, 600, 370);
		tab.addTab("�������",j1);
		tab.addTab("����ϵͳ��Ϣ",j2);
		tab.addTab("ϵͳ��־",j3);
		tab.addTab("ϵͳ����",j4);

		menubar.add(exitMenu);
		menubar.add(operateMenu);
		menubar.add(helpMenu);
		
		exitMenu.add(exitnMenuItem);
		operateMenu.add(restartMenuItem);
		operateMenu.add(closeMenuItem);
		helpMenu.add(helpMenuItem);

		panel.add(menubar);
		panel.add(tab);
	}

	public static void main(String[] args){
		new Server_Frame();
	}
}