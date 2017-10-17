import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class fenci2{
		
	   //char[] ch=str.toCharArray();//str 为缩减过的关键字	
	   static char[] ch  = ("123").toCharArray();//测试			

       //要排列组合的元素个数
       private static int MAX_INDEX   = ch.length ;
       //当前排列中需要填入数字的索引位置
       private static int finishIndex = 0;
       //已经完成的排列的数量
       private static int finishCount = 0;
       //记录排列元素的数组
       private char[] Char;
       //当前的排列组合
       private LinkedList<Character> savedChar= new LinkedList<Character>();;				
       			
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
                            finishCount++;
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
                     }
                     else{
                            //输出这一轮递归生成的数字组合
                            System.out.println(savedChar);
							finishIndex = 0 ;
                     }
              }
              try{
                     //判断是否是递归的最后一层
                     if(finishIndex == (MAX_INDEX-1)){
                            //移除排列组合的最后一位元素
                            savedChar.removeLast();
                            //移除排列组合的最后一位元素
                            savedChar.removeLast();
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

} 