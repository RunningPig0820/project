//�¼�����Ӧ
//��Ҫ�����������Ӧ�����ؼ�������������ƥ��
//��Ҫ��������⣨�� �� Ӧ��⣨�� δ��
			
import java.awt.event.*;
import java.util.Random;
			
public class handler implements ActionListener{			
		Random random=new Random();
		
//		�򵥵Ĵ𰸿�
/*		
		String b[]={"��Ҳ��","�Ҳ���","�㿪�ľͺ�","�������"};
		String c[]={"����Ӧ�������","���Ѽҵĺ���","��²�","���"};
		String d[]={"������˭��","������˭","����˵","����"};
*/		
		public void actionPerformed(ActionEvent e){	
			jiqiren.s1 = jiqiren.text1.getText();//��������������
			System.out.println("ԭʼ  jiqiren.s1 = " + jiqiren.s1);
				
//			�򵥳����ķ־�
//			���ĵĶ�����Ҫ��������š���������֮����ֶ�	
			
//			String[] arr=jiqiren.s1.split("��");
			
//			�򵥵ķִ�ϵͳ	��ȥ����е��ұ���ַ��ͷ�����		
			fencixitong fcxt = new fencixitong(jiqiren.s1);
			jiqiren.s1 = fcxt.gg;
			System.out.println("�ִ�ϵͳ jiqiren.s1 = " + jiqiren.s1+"\n");
			
//          �򵥵�Ӧ����
			new yingdaqi(jiqiren.s1);
			System.out.println("***Ӧ����  jiqiren.s1 = " + jiqiren.s1+"\n");
			
				
//			�򵥵Ĺؼ����������ƥ��
		
/*			for(int i=0 ; i<arr.length ; i++){				
				if(arr[i].equals("���"))
					jiqiren.t1.append(arr[i]+"\n\t"+b[random.nextInt(b.length)]+"\n");//���ַ�����ӡ��JTextArea
				else if(arr[i].equals("����˭"))
					jiqiren.t1.append(arr[i]+"\n\t"+c[random.nextInt(b.length)]+"\n");
				else if(arr[i].equals("����˭��"))
					jiqiren.t1.append(arr[i]+"\n\t"+d[random.nextInt(b.length)]+"\n");
				else
					jiqiren.t1.append(arr[i]+"\n\t��ʲô����֪����'#.#��\n");
			}
*/		}
				
}