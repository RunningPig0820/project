//*会有空白
import java.util.*;
import java.sql.*;
import java.io.* ;
import java.util.Random;

public class pailie3{
		
      //要排列组合的元素个数
      private static int MAX_INDEX   ;
      //当前排列中需要填入数字的索引位置
      private static int finishIndex ;
      //已经完成的排列的数量
      private static int finishCount ;
      //记录排列元素的数组
      private char[] Char;
      //当前的排列组合
      private LinkedList<Character> savedChar;
	  
	  String[] str1  = new String[30];	  
	  String str = "";
	  String sss = null ; //答案匹配（pailei3），只在本类中有
	  String SS ;
	  int str1i =0 ;
	  
	  public pailie3(char[] Char1){
		  MAX_INDEX = Char1.length;
		  finishIndex = 0;
		  finishCount = 0;
		  Char = new char[MAX_INDEX];
		  System.out.println("MAX_INDEX : " + MAX_INDEX);
		  savedChar = new LinkedList<Character>();
		  for(int i=0; i<MAX_INDEX ; i++){
				 Char[i] = Char1[i];
				 System.out.println("Char[i] : " + Char[i]);
		  }
		  System.out.println("正在使用排列组合算法");
       }
					
       public void dopailie2(String str){
	//	  public void dopailie2(){
		  saveChar(Char);
		  System.out.println("一共 " + finishCount + "种组合！");
		  if(sss == null){//再次分一次
				String jj = null ;//判断 dopailie2 中是否匹配不到答案
				for(int i = str.length() ; i > 0 ;i-- ){
					System.out.println(str);
					if(pipei(SS = str.substring(0,i)) == true){
						jj = "true";
						return ;							
					}
				}	
				if(jj != "true"){
					try{
						FileReader reader = new FileReader("E:/buhuiyingda.txt");
						new mangda().mangda1("",reader);
					}catch(IOException e){
						System.out.println("File read error : " + e);
					}catch(Exception e){
						System.out.println(e);
					}
				}			
											
		  }else{
			sss = null;
		  }

       }
		
       //完成排列组合，并输出到屏幕
       private void saveChar(char[] Char){
		  //循环数量由所处的递归层数决定
		  for(int i=0; i<MAX_INDEX-finishIndex; i++){

				 //添加选中的元素到链表
				 savedChar.addLast(Char[i]);					 									

				 //记录已经选取的元素
				 char numBuf = Char[i];

				 //记录以完成的排列组合数量
				 if(finishIndex == (MAX_INDEX-1)){
						finishCount ++ ; 
				 }

				 //创建传入递归下一层要用的数组
				 char nextChar[] = new char[MAX_INDEX - (finishIndex+1)];
				 int m = 0;

				 //拷贝未选用的数字
				 for(int n=0; n<MAX_INDEX-finishIndex; n++){
						if(Char[n] == numBuf){
							   continue;
						}
						else{
							   nextChar[m] = Char[n];
							   m++;
						}
				 }
				 //是否继续递归
				 if((MAX_INDEX - (finishIndex+1)) != 0){
						//递归层数计数加1
						finishIndex++;
						saveChar(nextChar);
				 }else{
				//输出这一轮递归生成的数字组合
					System.out.println(savedChar);
					
					for(int ii = 0 ; ii < savedChar.size() ; ii ++){
						str = str + savedChar.get(ii);
					}
					if(pipei(str)==true){
						System.out.println("+++++++++");
						sss = "true";
						return ;//找到一个答案就退出
					}
				}

              }

              try{
                     //判断是否是递归的最后一层
                     if(finishIndex == (MAX_INDEX-1)){
                            //移除排列组合的最后一位元素
                            savedChar.removeLast();
                            //移除排列组合的最后一位元素
                            savedChar.removeLast();
							str = "";
                     }else{
                            //移除排列组合的最后一位元素
                            savedChar.removeLast();
                     }
              }
              catch(Exception e){}
              finally{
                     //回到上一层，递归层数要减1
                     finishIndex--;
              }
       }


	   	boolean pipei(String str){
			MySQL3 ms = new MySQL3() ;
			ms.connSQL();//座位
			String Sql = "select * from yingdaku";
			ResultSet resultSet = ms.selectSQL(Sql);
			ms.layoutStyle1(resultSet,str);	
			ms.deconnSQL();		
		if(ms.string != null){//问题匹配（MySQL中声明）
			System.out.println("++++ true +++++");
			ms.string = null ;
			return true;
		}else{
			System.out.println("++++ false +++++");
			return false;
		}

	}
/*
	   public static void main(String[] args){
		    char[] ch = {'我','们','是'};
		    pailie3 p = new pailie3(ch);
			p.dopailie2();
	   }
*/
}
