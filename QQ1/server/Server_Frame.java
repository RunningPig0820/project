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
	
	private JPanel panel = new JPanel();//主面板
	
	private JMenuBar menubar = new JMenuBar();//菜单栏
	
	private JMenu exitMenu = new JMenu("退出");
	private JMenu operateMenu = new JMenu("操作");
	private JMenu helpMenu = new JMenu("帮助");
	
	private JMenuItem exitnMenuItem= new JMenuItem("退出");
	private JMenuItem restartMenuItem= new JMenuItem("重启服务器");
	private JMenuItem closeMenuItem= new JMenuItem("关闭服务器");
	private JMenuItem helpMenuItem = new JMenuItem("帮助");
	
	private Table j1 = new Table();   //在线情况
	private JPanel j3 = new JPanel(); //发送系统消息
	private JPanel j2 = new JPanel(); //系统日志
	private JPanel j4 = new JPanel(); //系统设置
	
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
	
	
	//设置主面板	
	public void setpanel(){
		panel.setLayout(null);

		menubar.setBounds(0,0,600,30);
		
		tab.setBounds(0, 30, 600, 370);
		tab.addTab("在线情况",j1);
		tab.addTab("发送系统消息",j2);
		tab.addTab("系统日志",j3);
		tab.addTab("系统设置",j4);

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