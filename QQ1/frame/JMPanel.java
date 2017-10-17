package frame;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import frame.JMPanelsize;


public class JMPanel extends JPanel{

 	private int paintSizeWidth = 0;
	private int paintSizeHeight = 0;

	public void setWidth(int paintSizeWidth){
		this.paintSizeWidth = paintSizeWidth;
	}

	public void setHeight(int paintSizeHeight){
		this.paintSizeHeight = paintSizeHeight;
	}

	public int getSizeWidth(){
		return paintSizeWidth;
	}

	public int getSizeHeight(){
		return paintSizeHeight;
	}

	public JMPanel(){
		super();
		setOpaque(false); // 设置成背景透明后，完全自绘才会看到效果
	}

	public JMPanel(JTextField jt){
		super();
		setOpaque(false); // 设置成背景透明后，完全自绘才会看到效果
		JMPanelsize jmp =new JMPanelsize();//通过JTextField的长度确定气泡的大小
		
		jmp.getSize(jt);
		System.out.println(jmp.getWidth()+"*******"+jmp.getHeight());

		paintSizeWidth  = jmp.getWidth();
		paintSizeHeight = jmp.getHeight();
		setWidth(paintSizeWidth);
		setHeight(paintSizeHeight);
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		//设置颜色
		g2D.setColor(Color.lightGray);
		//画箭头
		int xPoints[] = new int[3];  
		int yPoints[] = new int[3]; 
		
		xPoints[0] =  10;  
		yPoints[0] =  (getSize().height-1)/2;  
		xPoints[1] =  30;  
		yPoints[1] =  (getSize().height-1)/2+10;  
		xPoints[2] =  30;  
		yPoints[2] =  (getSize().height-1)/2-10;

		g2D.fillPolygon(xPoints, yPoints, 3); 
		
		//画气泡
		g2D.fillRoundRect(20, 0, 30+paintSizeWidth, 10 + paintSizeHeight,20,20);//jqi5
	}	
}	 	
	