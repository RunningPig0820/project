import java.util.LinkedList;
import java.sql.*;
import java.util.*;
import java.io.* ;


public class guanjianzi{
		
	public guanjianzi(LinkedList<String> list){
		System.out.println("����ʹ�ùؼ����㷨");
		guanjianzisuanfa(list);
	}

	public void guanjianzisuanfa(LinkedList<String> list){
		list.add("��ֹʹ��substring�ǳ���");//�����ำһ��ֵ����ֹʹ��substring�ǳ���
		String[] my = list.toArray(new String[0]);
		
		System.out.println("  my.length�ĳ���     " + my.length);
		for (int i = 0; i < my.length; i++) {  
			System.out.println(my[i]);  
		}  

		char[] arr1=my[2].toCharArray();//�ѵ��������ʲ��ȴ����ڼӵ�
		char[] arr2=my[1].toCharArray();//�ѵڶ������ʲ�
		char[] arr3=my[0].toCharArray();//�ѵ�һ�����ʲ�
		int[] text=new int[arr1.length];//��ȡ�ؼ�������
		int d=0;//�ؼ���λ��
		int Ee=text[1];//��¼�������ÿ�����Ĵ�����Ŀ����ȡ�ؼ���λ��
		int ff=1;//�ؼ��ֳ���
		
		for(int	ii=0 ; ii<arr1.length ; ii++){//�жϸ����ַ����ִ���	
			for(int Jj=0 ; Jj<arr2.length ; Jj++ ){
				if(arr1[ii] == arr2[Jj]){
					text[ii]+=1;
					System.out.println("����"+arr1[ii]+"  λ�õ�"+ii+"��������:"+text[ii]);
				}
			}
			for(int k=0 ; k<arr3.length ; k++ ){
				if(arr1[ii] == arr3[k]){
					text[ii]+=1;
					System.out.println("����"+arr1[ii]+"  λ�õ�"+ii+"��������:"+text[ii]);
				}
			}
		}
		
		for( int Ii=1;Ii<arr1.length; Ii++){//�жϹؼ���λ��
			if(Ee < text[Ii]){
				Ee=text[Ii];
				d=Ii;
			}
		}
		System.out.println("�ؼ��ֿ�ͷλ��"+d);//���Թؼ��ֿ�ͷλ�ã��Ի����˳���û����ÿ���ɾ��
		
		for( int Ii=1;Ii<arr1.length; Ii++){
			if(text[d]==text[d+1]){
				System.out.println("��û�н����ж�");//������û�н����ж�
				ff+=1;//�ؼ��ֳ���
				d+=1;//�ؼ��ֿ�ͷλ��
			}
		}
		System.out.println("           �ؼ��ֳ��ȣ�       "+ff);//���Թؼ��ֳ���λ�ã��Ի����˳���û����ÿ���ɾ��
		System.out.println("    �ؼ��ֿ�ͷλ��          ��"+d);//���Թؼ��ֽ�βλ�ã��Ի����˳���û����ÿ���ɾ��
		
		String str = my[2].substring(d+1-ff,d+1);//��ȡ��ͷû�н�β
		System.out.println("         �ؼ���                "+str);
//��ҪӦ��ʹ�ó��ܿ�
		
		MySQL3 ms = new MySQL3() ;
		ms.connSQL();//��λ
		String Sql = "select * from yingdaku";
		ResultSet resultSet = ms.selectSQL(Sql);
		ms.layoutStyle1(resultSet,str);	
		ms.deconnSQL();

		if(ms.getCOUNT() == 0){
			try{
				FileReader reader = new FileReader("E:/buhuiyingda.txt");
				new mangda().mangda1("",reader);
			}catch(IOException e){
				System.out.println("File read error : " + e);
			}catch(Exception e){
				System.out.println(e);
			}
		}

	}
	
}