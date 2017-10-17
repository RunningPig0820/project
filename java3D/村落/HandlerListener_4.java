import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/*
 *  �༭�����¼� ѡ�� ����λ��
*/
public class HandlerListener_4 implements FocusListener{
	
	HandlerBean bean ;
	
	String name	;

	public HandlerListener_4(HandlerBean bean,String name){
		
		this.bean = bean;		
		this.name = name;
	}
	
	@Override
	public void focusGained(FocusEvent e){
	}

	@Override
	public void focusLost(FocusEvent e){
		JTextField temp=(JTextField)e.getSource();	
		
		if(name.equals("X")){
			bean.setPointX(temp.getText());
		}else if(name.equals("Y")){
			bean.setPointY(temp.getText());
		}else if(name.equals("Z")){
			bean.setPointZ(temp.getText());
		}
		
		System.out.println(temp.getText());	

	}

}