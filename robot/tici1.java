import java.sql.*;

public class tici1{
	int MAXNUM ;//���ƥ������ ѡȡ�ʿ���ĳ���
	String str1 ;//��¼�ַ���
	void zhengxiangpipei(String str){
		int temp  = 5 ; //��¼���ٵĳ���
		int temp1 = 0 ; 
		MAXNUM = str.length();//��¼�ַ�������

//��ӡ˳��һ������		
		while(MAXNUM >= -1){
//		System.out.println("str1��"+str1);
		str1 = str.substring(MAXNUM - temp,MAXNUM);
//			System.out.println("str:" +str1);
			if(pipei(str1)){//��ʵ���ƥ�䣬���ƥ��ɹ�����ǰ�ƶ� temp ���ַ�
				MAXNUM = MAXNUM - temp ;//ʣ���ַ�������
				temp = 5 ; //����
				System.out.println(str1);
				str1 = "";
				continue ;
			}else{//��ʵ���ƥ�䣬���ƥ�䲻�ɹ���ʹƥ�䳤�ȼ�һ
				if(temp != 0){
					temp--;
				}else if(temp == 0){//���ֵ�����
					System.out.println(str.substring(MAXNUM-1,MAXNUM));//��ŵ��ش�����
					pipei(str1);
					MAXNUM = MAXNUM - 1 ;
					temp = 5 ;//����
				}
			}
			
		}
//��ӡ˳��һ��˳��
/*
		while(MAXNUM < 5 && MAXNUM > -1){
			str1 = str.substring(temp1,MAXNUM);
			System.out.println("***" + str1);
			if(pipei(str1)){
				System.out.println(str1);
				return ;
			}else{
				if(temp1 != MAXNUM + 1){					
					temp1 ++ ;
					System.out.println(temp1);
					System.out.println(str1.substring(temp1-1,temp1));//��ŵ��ش�����
					pipei(str1);
				}else if(temp1 == MAXNUM + 1){
					return ;
				}
			}
		}
*/	}
	
	boolean pipei(String str){
//		System.out.println("ƥ�����ִ��");
		MySQL3 ms = new MySQL3() ;
		ms.connSQL();//��λ
		String Sql = "select * from fenci" ;
		String Sql1 = "select * from yingdaku" ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ResultSet resultSet1 = ms.selectSQL(Sql1);
		ms.layoutStyle2(resultSet,resultSet1,str);
		ms.deconnSQL();

		if(ms.getCOUNT() == 0){
			jiqiren2.t1.append(ms.getCOUNT() + "\n\t"+"�ܲ��ܻ�һ����һ�������" + "\n");
		}
		

		if(ms.string != null){
			return true;
		}else{
			return false;
		}
	}

/*
	public static void main(String[] args){
		tici1 t= new tici1() ;
//		t.zhengxiangpipei("����Ļ�����Ư��");
//		t.zhengxiangpipei("����Ļ�����Ư��")
//		t.zhengxiangpipei("�����ǹ�������Ӱ���");
//		t.zhengxiangpipei("��֪��������ô����");
//		t.zhengxiangpipei("�����");
//		t.zhengxiangpipei("�������˵�����");
	}
*/

} 

