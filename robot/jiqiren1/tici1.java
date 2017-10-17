import java.sql.*;
import java.util.LinkedList;
import java.io.* ;
import java.util.Random;

public class tici1{
	int MAXNUM ;//最大匹配字数 选取词库最长的长度
	String str1 ;//记录字符串
	void zhengxiangpipei(String str){
	int temp  = 5 ; //记录减少的长度	
	MAXNUM = str.length();//记录字符串长度 

	while(MAXNUM >= 5){
		str1 = str.substring(MAXNUM - temp,MAXNUM);
		System.out.println(" MAXNUM " + str1);
		if(pipei(str1)){//与词典相匹配，如果匹配成功，向前移动 temp 个字符 
			System.out.println(" - - - - - " +  MAXNUM);
			MAXNUM = MAXNUM - temp ;//剩余字符串长度
			temp = 5 ; //重置
			System.out.println("  匹配 " + str1);//需放到回答条里
			str1 = "";
			continue ;
		}else{//与词典相匹配，如果匹配不成功，使匹配长度减一 
			if(temp != 1){
				temp--;
				System.out.println("temp"+temp);
			}else if(temp == 1){//出现单个词
				System.out.println("***********");
				System.out.println(str.substring(MAXNUM-1,MAXNUM));//需放到回答条里
				MAXNUM = MAXNUM - 1 ;
				temp = 5 ;//重置
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
		ms.connSQL();//座位
		String Sql = "select * from fenci" ;
		String Sql1 = "select * from yingdaku " ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ResultSet resultSet1 = ms.selectSQL(Sql1);
		ms.layoutStyle2(resultSet,resultSet1,str);
		ms.deconnSQL();
		System.out.println(" ms.string :" + ms.string);
		if(ms.string != null){
			ms.string = null;//判断是有答案
			return true;
		}else{
			return false;
		}
	}

/*
	public static void main(String[] args){
		tici1 t= new tici1() ;
//		t.zhengxiangpipei("我们是共产主义接班人");
//		t.zhengxiangpipei("今天的花儿真漂亮");
//		t.zhengxiangpipei("今天的花儿真漂亮")
//		t.zhengxiangpipei("你知道厕所怎么走吗");
//		t.zhengxiangpipei("你好吗");
//		t.zhengxiangpipei("凡发生了到阿达");
//		t.zhengxiangpipei("王守昌是大傻逼");
	}
*/

} 
