import java.sql.*;

public class tici{
	
	int MAXNUM ;//���ƥ������ ѡȡ�ʿ���ĳ���
	int NUM ;//��¼����
	String str1 ;//��¼�ַ���

	void zhengxiangpipei(String str){	
		char[] ch = str.toCharArray();
		MAXNUM = ch.length;//��¼�ַ������� 
		NUM = MAXNUM ;//��ʼ�� NUM			
		for(int i = MAXNUM -1; i >= 0 ; i--){//�Է��������һ�η������
			str1 = str1 + ch[i] ;//ƴ���ַ�������ʵ���бȽ�
			NUM -- ;//��¼����
			if(pipei(str1) == true){//����ʵ�ƥ��
				System.out.println(str1);
				String str1 ;//��ʼ��
				i = NUM;//���¸�ֵ i �Ա��� str ��ʵ�Ϊƥ�䵽ʱ�������·��ص� i ��
			}else if(pipei(str1) == false){
				System.out.println(ch[i]);//�������
				NUM -- ;//��������һ��
				i = NUM;//������
			}
		}				
	} 

	boolean pipei(String str){
/*
		MySQL2 ms = new MySQL2() ;
		ms.connSQL();//��λ
		String Sql = "select * from fenci WHERE ciyu = " + str;
		ResultSet resultSet = ms.selectSQL(Sql);
		ms.layoutStyle2(resultSet,Sql);	
		ms.deconnSQL();
		return ms.layoutStyle2(resultSet,Sql);	
*/
		test ms = new test() ;
		ms.connSQL();//��λ
		String Sql = "select * from fenci" ;
	//	String Sql = "select * from fenci WHERE ciyu = '��'" ;
		ResultSet resultSet = ms.selectSQL(Sql);		
	//	ms.deconnSQL();
		return ms.layoutStyle2(resultSet,Sql);	
	}
	

	private int aheadCount(String s){  //
        int count = 0;  
        for(int i=0; i<list.size(); i++){  
            if((s.length()<=list.get(i).length()) && 
				(s.equals(list.get(i).substring(0, s.length()))))
				count ++ ;  
        }  
        return count;  
    }  
     
     
	public  static void main(String[] args){
		tici ti = new tici();
	//  ti.zhengxiangpipei("�����ǹ�������Ӱ���");	
		ti.zhengxiangpipei("�����ǹ�������Ӱ���");	
		//System.out.println(ti.pipei("��"));
	}
	
}