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
	
	JFrame frame			= new JFrame(); // ������
	JPanel EditPanel_Tree	= new JPanel(); // �Ҳ����ͱ༭����
	//ShowPanel showPanel		= new ShowPanel(); // 3Dչʾ���
	Canvas3D showPanel		= new ShowPanel().returnCanvas(); // 3Dչʾ���
	
	EditPanel EditPanel_Show	= new EditPanel(); // �༭3D���
	
	JPanel JTreePanel_Tree	= new JPanel(); // �����
	JPanel JTreePanel_Des	= new JPanel(); // ���ı༭���

	JSplitPane JTreesplit = new JSplitPane(); //���������Ϣ
	JSplitPane Showsplit  = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); //���3Dչʾ���
	
	JPanel toppanel = new JPanel();			 //�����		
	
	DesJPanel despanel = new DesJPanel();				


	public Main_Frame(){
	
		EditPanel_Tree.setLayout(new BorderLayout());
	
		frame.setSize(1600,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	//����������Ҫ���
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