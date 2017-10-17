//通过JTextField的长度确定气泡的大小
package frame;

import java.awt.*;
import javax.swing.*;

public class JMPanelsize{	

	private int JMPanelWidth  ;
	private int JMPanelHeight ;
	
	public void setWidth(int JMPanelWidth){
		this.JMPanelWidth = JMPanelWidth ;
	}


	public void setHeight(int JMPanelHeight){
		this.JMPanelHeight = JMPanelHeight ;
	}
	 
	public int getWidth(){
		return JMPanelWidth;
	}

	public int getHeight(){
		return JMPanelHeight;
	}

	public void getSize(JTextField jt){
	  
	  jt.setBorder(null);
	  jt.setEditable(false);  
	  
	  FontMetrics metrics; 
	  int textH = 0;
	  int textW = 0;
		
	  metrics = jt.getFontMetrics(jt.getFont());
	  textH = metrics.getHeight();//字符串的高,   只和字体有关
	  textW = metrics.stringWidth(jt.getText());//字符串的宽
	  setWidth(textW);
	  setHeight(textH);

	}
}