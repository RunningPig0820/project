import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/*
 *  �༭�����¼� ѡ�� ����ѡ��
*/
public class HandlerListener_2 implements ActionListener{
	
	HandlerBean bean ;

	public HandlerListener_2(HandlerBean bean){
		this.bean = bean;
	}

	@Override
	public void actionPerformed(ActionEvent e){	
		
		JRadioButton temp=(JRadioButton)e.getSource();
		if(temp.isSelected()){
			String saveValue=temp.getText();
			bean.setConstruction(saveValue);
			System.out.println(temp.getText());
		}

	}

}