import java.sql.*;
import java.util.LinkedList;
import java.io.* ;
import java.util.Random;

public class tici1{
	int MAXNUM ;//���ƥ������ ѡȡ�ʿ���ĳ���
	String str1 ;//��¼�ַ���
	void zhengxiangpipei(String str){
	int temp  = 5 ; //��¼���ٵĳ���	
	MAXNUM = str.length();//��¼�ַ������� 

	while(MAXNUM >= 5){
		str1 = str.substring(MAXNUM - temp,MAXNUM);
		System.out.println(" MAXNUM " + str1);
		if(pipei(str1)){//��ʵ���ƥ�䣬���ƥ��ɹ�����ǰ�ƶ� temp ���ַ� 
			System.out.println(" - - - - - " +  MAXNUM);
			MAXNUM = MAXNUM - temp ;//ʣ���ַ�������
			temp = 5 ; //����
			System.out.println("  ƥ�� " + str1);//��ŵ��ش�����
			str1 = "";
			continue ;
		}else{//��ʵ���ƥ�䣬���ƥ�䲻�ɹ���ʹƥ�䳤�ȼ�һ 
			if(temp != 1){
				temp--;
				System.out.println("temp"+temp);
			}else if(temp == 1){//���ֵ�����
				System.out.println("***********");
				System.out.println(str.substring(MAXNUM-1,MAXNUM));//��ŵ��ش�����
				MAXNUM = MAXNUM - 1 ;
				temp = 5 ;//����
			}
		}
		
		}
		
		if(MAXNUM < 5 ){
			for(int i = MAXNUM+1 ; i >= 0 ;i-- ){
				System.out.println(str1);
				if(pipei(str1 = str.substring(0,i)) == true){
					return ;						
				}
			}
		}
		
	}
	
	boolean pipei(String str){
		MySQL3 ms = new MySQL3() ;
		ms.connSQL();//��λ
		String Sql = "select * from fenci" ;
		String Sql1 = "select * from yingdaku " ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ResultSet resultSet1 = ms.selectSQL(Sql1);
		ms.layoutStyle2(resultSet,resultSet1,str);
		ms.deconnSQL();
		System.out.println(" ms.string :" + ms.string);
		if(ms.string != null){
			ms.string = null;//�ж����д�
			return true;
		}else{
			return false;
		}
	}

/*
	public static void main(String[] args){
		tici1 t= new tici1() ;
//		t.zhengxiangpipei("�����ǹ�������Ӱ���");
//		t.zhengxiangpipei("����Ļ�����Ư��");
//		t.zhengxiangpipei("����Ļ�����Ư��")
//		t.zhengxiangpipei("��֪��������ô����");
//		t.zhengxiangpipei("�����");
//		t.zhengxiangpipei("�������˵�����");
//		t.zhengxiangpipei("���ز��Ǵ�ɵ��");
	}
*/

} 
