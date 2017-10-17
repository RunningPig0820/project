import java.awt.event.*;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class handler3 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		Icon icon=new ImageIcon("E:/1234.gif");
		JOptionPane.showMessageDialog(null,"\t\t\t开启训练模式\t\t"," 提示 ",JOptionPane. PLAIN_MESSAGE,icon);
		new jiqiren3();	
	}		
	
}	
