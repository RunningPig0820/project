//�¼�����Ӧ
//��Ҫ�����������Ӧ�����ؼ�������������ƥ��
//��Ҫ��������⣨�� �� Ӧ��⣨�� ����
//�����ַ�¼�����ڡ��ַ������������͡�MOUSE�ƶ����ڡ����̻������ڡ��ظ����޸��ַ��ռ���
			
import java.awt.event.*;
import java.util.Random;
			
public class handler2 implements ActionListener{			
			
		public void actionPerformed(ActionEvent e){	
			jiqiren2.s1 = jiqiren2.text1.getText();//��������������
			System.out.println("ԭʼ  jiqiren.s1 = " + jiqiren2.s1);
			
//�򵥵ķִ�ϵͳ	��ȥ����е��ұ���ַ��ͷ�����		
			fencixitong fcxt = new fencixitong(jiqiren2.s1);
			jiqiren2.s1 = fcxt.gg;
			System.out.println("�ִ�ϵͳ jiqiren.s1 = " + jiqiren2.s1+"\n");
			
//          �򵥵�Ӧ����
			new yingdaqi(jiqiren2.s1);
			System.out.println("***Ӧ����  jiqiren.s1 = " + jiqiren2.s1+"\n");			
		}				
}