import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventDemo extends JFrame implements/* ActionListener,*/KeyListener{
	JTextField txt1;
	JPanel pnlMain;

	public KeyEventDemo(){
		pnlMain=new JPanel();
		setContentPane(pnlMain);
	  
		txt1=new JTextField(10);
		JButton btnOK=new JButton("确认");
		btnOK.addKeyListener(this);//1
	  
		pnlMain.add(txt1);

		setVisible(true);
		setTitle("好啊");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} 

	public void keyTyped(KeyEvent e){//6
		char c=e.getKeyChar();
			if(c=='o'){
				txt1.setText("收到，呵呵");
			} 
	}

	public void actionPerformed(){} //5
	public void  keyTyped(){}//2
	public void  keyPressed(){}//3
	public void  keyReleased(){}//4 

	public static void main(String[] args){
		new KeyEventDemo();
	}
}  