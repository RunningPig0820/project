import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *  �༭�����¼� ѡ�� �������
*/
public class HandlerListener_3 implements ActionListener{
	
	HandlerBean bean ;

	public HandlerListener_3(HandlerBean bean){
		this.bean = bean;
	}

	@Override
	public void actionPerformed(ActionEvent e){	
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("����");
		System.out.println("getConstruction :   " + bean.getConstruction());
		System.out.println("getpointX()     :   " + bean.getpointX());
		System.out.println("getpointY()     :   " + bean.getpointY());
		System.out.println("getpointZ()     :   " + bean.getpointZ());
		System.out.println();
	}

}