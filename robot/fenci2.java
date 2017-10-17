//需要有一个分词系统
//一个词语的穷尽组成一共有 n！次种组合，如果str的值过大会十分耗时间，尽量让str在五个以内
/*
	排列组合算法：当把一个含有 n 个数的进行组合时有n!次种组合,即在排列的第一个数有
	n中可能，第二个数就有 n-1 种可能··· 总共的组合就是 n 个数进行求积。

	算法写法 ： 模仿排列组合算法，排列的第一个数即原来所有的n其中一个，第二个数是除去
	已排好的第一个数后所有的n-1其中一个，也就是说当排列第m个数的时候就是除去排好的
	m-1 个数后 n-（m-1）其中一个。这里每次排列多是重复相同的步骤：排除原先的排列过的
	数据在排列出所有未排列就可以是递归算法，递归算法在使用过称中会记录所有得值造成内存
	使用过大，当这里就是要记录所有过程中产生的数值。如何记录已除去的数，就需要引用一个
	数组来记录原来元素的数组，当前的排列组合使用的是一个链来储存。如何记录排列已完成的，
	当索引位置等于元素个数时，一次排列完成
	
	自己写出现的问题：
		下面是从网上的一段代码，我自己写的时候有下面的问题：

		1.是用数组来记录当前的排列组合，数组太多了有对组数赋值就变得很乱，写到后面自己
		也不知道值赋到了那里。
		2.无法很好对递归的最后一层判断
		3.对方法变量命名不清，没有很高的辨识度


	
*/


import java.util.*;

public class pailie2{
		
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
	  
	  public pailie2(char[] Char1){
              MAX_INDEX = Char1.length;
              finishIndex = 0;
              finishCount = 0;
              Char = new char[MAX_INDEX];
              savedChar = new LinkedList<Character>();
              for(int i=0; i<MAX_INDEX; i++){
                     Char[i] = Char1[i];
              }
       }

       public void dopailie2(){
              saveChar(Char);
              System.out.println("一共 " + finishCount + "种组合！");
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
/*
	public static void main(String[] args){
		char[] ch  = ("12345").toCharArray();
		pailie2 p = new pailie2(ch);
		p.dopailie2();
	}
*/
} 