import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/*
 *  编辑界面事件 选择 构建选择
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