//ͨ��JTextField�ĳ���ȷ�����ݵĴ�С
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
	  textH = metrics.getHeight();//�ַ����ĸ�,   ֻ�������й�
	  textW = metrics.stringWidth(jt.getText());//�ַ����Ŀ�
	  setWidth(textW);
	  setHeight(textH);

	}
}