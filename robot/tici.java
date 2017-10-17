import java.sql.*;

public class tici{
	
	int MAXNUM ;//最大匹配字数 选取词库最长的长度
	int NUM ;//记录次数
	String str1 ;//记录字符串

	void zhengxiangpipei(String str){	
		char[] ch = str.toCharArray();
		MAXNUM = ch.length;//记录字符串长度 
		NUM = MAXNUM ;//初始化 NUM			
		for(int i = MAXNUM -1; i >= 0 ; i--){//对符数组进行一次反向遍历
			str1 = str1 + ch[i] ;//拼接字符，以与词典进行比较
			NUM -- ;//记录次数
			if(pipei(str1) == true){//当与词典匹配
				System.out.println(str1);
				String str1 ;//初始化
				i = NUM;//重新赋值 i 以便在 str 与词典为匹配到时可以重新返回到 i 处
			}else if(pipei(str1) == false){
				System.out.println(ch[i]);//输出单个
				NUM -- ;//次数减少一个
				i = NUM;//重新做
			}
		}				
	} 

	boolean pipei(String str){
/*
		MySQL2 ms = new MySQL2() ;
		ms.connSQL();//座位
		String Sql = "select * from fenci WHERE ciyu = " + str;
		ResultSet resultSet = ms.selectSQL(Sql);
		ms.layoutStyle2(resultSet,Sql);	
		ms.deconnSQL();
		return ms.layoutStyle2(resultSet,Sql);	
*/
		test ms = new test() ;
		ms.connSQL();//座位
		String Sql = "select * from fenci" ;
	//	String Sql = "select * from fenci WHERE ciyu = '好'" ;
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
	//  ti.zhengxiangpipei("我们是共产主义接班人");	
		ti.zhengxiangpipei("我们是共产主义接班人");	
		//System.out.println(ti.pipei("好"));
	}
	
}