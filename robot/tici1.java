import java.sql.*;

public class tici1{
	int MAXNUM ;//最大匹配字数 选取词库最长的长度
	String str1 ;//记录字符串
	void zhengxiangpipei(String str){
		int temp  = 5 ; //记录减少的长度
		int temp1 = 0 ; 
		MAXNUM = str.length();//记录字符串长度

//打印顺序不一样逆向		
		while(MAXNUM >= -1){
//		System.out.println("str1："+str1);
		str1 = str.substring(MAXNUM - temp,MAXNUM);
//			System.out.println("str:" +str1);
			if(pipei(str1)){//与词典相匹配，如果匹配成功，向前移动 temp 个字符
				MAXNUM = MAXNUM - temp ;//剩余字符串长度
				temp = 5 ; //重置
				System.out.println(str1);
				str1 = "";
				continue ;
			}else{//与词典相匹配，如果匹配不成功，使匹配长度减一
				if(temp != 0){
					temp--;
				}else if(temp == 0){//出现单个词
					System.out.println(str.substring(MAXNUM-1,MAXNUM));//需放到回答条里
					pipei(str1);
					MAXNUM = MAXNUM - 1 ;
					temp = 5 ;//重置
				}
			}
			
		}
//打印顺序不一样顺向
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
					System.out.println(str1.substring(temp1-1,temp1));//需放到回答条里
					pipei(str1);
				}else if(temp1 == MAXNUM + 1){
					return ;
				}
			}
		}
*/	}
	
	boolean pipei(String str){
//		System.out.println("匹配语句执行");
		MySQL3 ms = new MySQL3() ;
		ms.connSQL();//座位
		String Sql = "select * from fenci" ;
		String Sql1 = "select * from yingdaku" ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ResultSet resultSet1 = ms.selectSQL(Sql1);
		ms.layoutStyle2(resultSet,resultSet1,str);
		ms.deconnSQL();

		if(ms.getCOUNT() == 0){
			jiqiren2.t1.append(ms.getCOUNT() + "\n\t"+"能不能换一个简单一点的问题" + "\n");
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
//		t.zhengxiangpipei("今天的花儿真漂亮");
//		t.zhengxiangpipei("今天的花儿真漂亮")
//		t.zhengxiangpipei("我们是共产主义接班人");
//		t.zhengxiangpipei("你知道厕所怎么走吗");
//		t.zhengxiangpipei("你好吗");
//		t.zhengxiangpipei("凡发生了到阿达");
	}
*/

} 

