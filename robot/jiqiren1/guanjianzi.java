import java.util.LinkedList;
import java.sql.*;
import java.util.*;
import java.io.* ;


public class guanjianzi{
		
	public guanjianzi(LinkedList<String> list){
		System.out.println("正在使用关键字算法");
		guanjianzisuanfa(list);
	}

	public void guanjianzisuanfa(LinkedList<String> list){
		list.add("防止使用substring是出错");//给链多赋一个值，防止使用substring是出错
		String[] my = list.toArray(new String[0]);
		
		System.out.println("  my.length的长度     " + my.length);
		for (int i = 0; i < my.length; i++) {  
			System.out.println(my[i]);  
		}  

		char[] arr1=my[2].toCharArray();//把第三次提问拆开先存入在加的
		char[] arr2=my[1].toCharArray();//把第二次提问拆开
		char[] arr3=my[0].toCharArray();//把第一次提问拆开
		int[] text=new int[arr1.length];//提取关键字数组
		int d=0;//关键字位置
		int Ee=text[1];//记录最后问题每个数的次数，目的提取关键字位置
		int ff=1;//关键字长度
		
		for(int	ii=0 ; ii<arr1.length ; ii++){//判断各个字符出现次数	
			for(int Jj=0 ; Jj<arr2.length ; Jj++ ){
				if(arr1[ii] == arr2[Jj]){
					text[ii]+=1;
					System.out.println("测试"+arr1[ii]+"  位置第"+ii+"个，出现:"+text[ii]);
				}
			}
			for(int k=0 ; k<arr3.length ; k++ ){
				if(arr1[ii] == arr3[k]){
					text[ii]+=1;
					System.out.println("测试"+arr1[ii]+"  位置第"+ii+"个，出现:"+text[ii]);
				}
			}
		}
		
		for( int Ii=1;Ii<arr1.length; Ii++){//判断关键字位置
			if(Ee < text[Ii]){
				Ee=text[Ii];
				d=Ii;
			}
		}
		System.out.println("关键字开头位置"+d);//测试关键字开头位置，对机器人程序没多大用可以删掉
		
		for( int Ii=1;Ii<arr1.length; Ii++){
			if(text[d]==text[d+1]){
				System.out.println("有没有进入判断");//测试有没有进入判断
				ff+=1;//关键字长度
				d+=1;//关键字开头位置
			}
		}
		System.out.println("           关键字长度：       "+ff);//测试关键字长度位置，对机器人程序没多大用可以删掉
		System.out.println("    关键字开头位置          ："+d);//测试关键字结尾位置，对机器人程序没多大用可以删掉
		
		String str = my[2].substring(d+1-ff,d+1);//截取开头没有结尾
		System.out.println("         关键字                "+str);
//需要应答使用吵架库
		
		MySQL3 ms = new MySQL3() ;
		ms.connSQL();//座位
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