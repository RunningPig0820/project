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

public class yingdaqi{
	 
	static LinkedList<String> list = new LinkedList<String>();//ʹ�������洢����������
	static int finishCount = -1 ;  // ��¼���ⳤ�ȴ���10������
	static int Count = -1; //������¼���ʴ��� 				
	
//		ɸѡ�����ߵ����ͺ�ʹ�������㷨			
/*
		��Ҫ�ж������������ʳ��ȣ�
		1.����������ʳ��ȶ��� 10��������    ������Ϊ���������ͣ�ʹ�ùؼ����㷨/���ܿ�
		2.�������������������������������� ������Ϊ���������ͣ�ʹ����������㷨/Ӧ���
	
		ʹ�� Count finishCount ���������������ж�
*/		

	public yingdaqi(String string){
	    Count ++ ;//������¼���ʴ���
		
		if(string.length() > 10){
			System.out.println("�ش���������10������");
			finishCount ++ ;
			list.add(string);
			try{
				jiqiren2.t1.append("   "+string+"\n\t"+"���ܲ���˵��һ�㰡���㲻˵��˵�˰� ��");//���ַ�����ӡ��JTextArea
				FileReader reader = new FileReader("E:/34.txt");
				new mangda().mangda1(string,reader);
			}catch(IOException e){
				System.out.println("File read error : " + e);
			}catch(Exception e){
				System.out.println(e);
			}
		}else if(string.length() > 4 && string.length() <= 10 ){
			System.out.println("�ش�������5-10֮��");
			tici1 t= new tici1() ;
			t.zhengxiangpipei(string);
		}else if(string.length() <= 4){
			System.out.println("�ش�������4����");
			char[] ch  = string.toCharArray();
			pailie3 p = new pailie3(ch);
			p.dopailie2(string);
		}

		System.out.println("Count     :   "+ Count + "            finishCount  : "+ finishCount + "\t");

		if(finishCount != Count){
			System.out.println("�������ⳤ�Ȳ�������10");
			list.clear();//����������¼�¼��һ��������������10 ������
			finishCount = -1 ;//���¼�¼
			Count       = -1 ;//���¼�¼
		}else if(finishCount == 2){//���߶���¼��3�Σ����������ͣ�ʹ�ùؼ����㷨/���ܿ�
			//�ؼ����㷨
			System.out.println("��Ҫʹ�ùؼ����㷨");
			new guanjianzi(list);
		}
	}
/*
	public void mangda(String string){

//		ä��
		try{
			Random random=new Random();
			int i = 0 ;//��¼�ı���
			FileReader reader = new FileReader("E:/34.txt");//ä����ļ���λ��
			BufferedReader br = new BufferedReader(reader);         
			String   strs ;
			String[] str  = new String[210];			
			while((strs = br.readLine()) != null){									
				str[i] = strs ;
				i++ ;
			} 
			reader.close();						
			System.out.println("ä��Ĵ�*�� "+str[Math.abs(random.nextInt())%i]+"\n");
			jiqiren2.t1.append("   "+string+"\n\t"+"���ܲ���˵��һ�㰡���㲻˵��˵�˰� ��");//���ַ�����ӡ��JTextArea
			jiqiren2.t1.append("\n\t"+str[Math.abs(random.nextInt())%i]+"\n");
				
		}catch(IOException e){
			System.out.println("File read error : " + e);
		}catch(Exception e){
			System.out.println(e);
		}	
	}		
*/	
}	
