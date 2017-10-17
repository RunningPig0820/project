import javax.swing.JFrame;
import javax.swing.JPanel;	
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import javax.media.j3d.Canvas3D;


public class Main_Frame {
	
	JFrame frame			= new JFrame(); // 主界面
	JPanel EditPanel_Tree	= new JPanel(); // 右侧树型编辑窗口
	//ShowPanel showPanel		= new ShowPanel(); // 3D展示面板
	Canvas3D showPanel		= new ShowPanel().returnCanvas(); // 3D展示面板
	
	EditPanel EditPanel_Show	= new EditPanel(); // 编辑3D面板
	
	JPanel JTreePanel_Tree	= new JPanel(); // 树面板
	JPanel JTreePanel_Des	= new JPanel(); // 树的编辑面板

	JSplitPane JTreesplit = new JSplitPane(); //存放树型信息
	JSplitPane Showsplit  = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); //存放3D展示面板
	
	JPanel toppanel = new JPanel();			 //存放树		
	
	DesJPanel despanel = new DesJPanel();				


	public Main_Frame(){
	
		EditPanel_Tree.setLayout(new BorderLayout());
	
		frame.setSize(1600,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	//设计主面板主要框架
	public void buildframe(){
						
		JTreesplit.setDividerLocation(250);
		JTreesplit.setLeftComponent(EditPanel_Tree);
		JTreesplit.setRightComponent(Showsplit); 
		JTreesplit.setEnabled(false);

		Showsplit.setLeftComponent(showPanel);  
        Showsplit.setRightComponent(EditPanel_Show);
		Showsplit.setDividerLocation(1000);
		Showsplit.setOneTouchExpandable(true); 
		Showsplit.setContinuousLayout(true);
				
		frame.add(JTreesplit,BorderLayout.CENTER);	

	}
	
	
	public static void main(String[] args){
		Main_Frame  main_frame = new Main_Frame();
		main_frame.buildframe();
	}
}