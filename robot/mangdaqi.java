//��Ҫ��һ��ä��⣨.txt�ļ���
//��Ҫ��һ�����ܿ⣨�����洢�� δ��

/*
	ä����Ŀ����Ϊ�˷��� ��ɸѡ�����ߵ����ͺ�ʹ�������㷨

	��������� ��ä����������������������Ϊ   �� ����������   ʹ����������㷨
	��������� û�а��� ä������������������Ϊ ������������  	ʹ�ùؼ����㷨

	ʹ�õ����ļ���ʽ������ä���
*/

import java.util.LinkedList;
import java.io.* ;
import java.util.Random;

public class mangdaqi{
	 
	LinkedList<String> list = new LinkedList<String>();//ʹ�������洢����������
	int finishCount = 0 ;  // ������¼���ʴ���	����������
					
	public mangdaqi(String string){
		if(string.length() > 10){
			 list.add(string);
			 mangda(string);
		}
	}

	public void mangda(String string){

//		ä��
		try{
			Random random=new Random();
			int i = 0 ;
			FileReader reader = new FileReader("E://1.txt");//ä����ļ���λ��
			BufferedReader br = new BufferedReader(reader);         
			String   strs ;
			String[] str  = new String[100];			
			while((strs = br.readLine()) != null){									
				str[i] = strs ;
				i++ ;
			} 
			reader.close();			
			
			System.out.println("ä��Ĵ𰸣� "+str[Math.abs(random.nextInt())%i]);
			jiqiren.t1.append(string+"\n\t"+str[Math.abs(random.nextInt())%i]+"\n");//���ַ�����ӡ��JTextArea

		}catch(IOException e){
			System.out.println("File read error : " + e);
		}catch(Exception e){
			System.out.println(e);
		}	

//		ɸѡ�����ߵ����ͺ�ʹ�������㷨			
/*
		��Ҫ�ж������������ʳ��ȣ�
		1.����������ʳ��ȶ��� 10��������    ������Ϊ���������ͣ�ʹ�ùؼ����㷨   �� Ӧ���
		2.�������������������������������� ������Ϊ���������ͣ�ʹ����������㷨 �� ���ܿ�		
	
*/		



			list.add(string);
			finishCount ++  ;
	}											
								
}	
