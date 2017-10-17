//需要有一个盲答库（.txt文件）
//需要有一个吵架库（表来存储） 未建

/*
	盲答器目的是为了分类 ：筛选提问者的类型和使用哪种算法

	如果提问者 以盲答器规则来缩短字数定义为   ： 正常人类型   使用排列组合算法
	如果提问者 没有按照 盲答器来所断字数定义为 ：捣乱人类型  	使用关键字算法

	使用的是文件形式来储存盲答库
*/

import java.util.LinkedList;
import java.io.* ;
import java.util.Random;

public class yingdaqi{
	 
	static LinkedList<String> list = new LinkedList<String>();//使用链来存储提问者问题
	static int finishCount = -1 ;  // 记录问题长度大于10的数量
	static int Count = -1; //用来记录提问次数 				
	
//		筛选提问者的类型和使用哪种算法			
/*
		需要判断提问三次提问长度：
		1.如果三次提问长度都在 10个字以上    把他归为捣蛋人类型，使用关键字算法/吵架库
		2.如果三次提问中有提问字数在五个字内 把他归为正常人类型，使用排列组合算法/应答库
	
		使用 Count finishCount 这俩个变量进行判断
*/		

	public yingdaqi(String string){
	    Count ++ ;//用来记录提问次数
		
		if(string.length() > 10){
			System.out.println("回答字数超过10！！！");
			finishCount ++ ;
			list.add(string);
			try{
				jiqiren2.t1.append("   "+string+"\n\t"+"你能不能说短一点啊，你不说我说了啊 ：");//把字符串打印到JTextArea
				FileReader reader = new FileReader("E:/34.txt");
				new mangda().mangda1(string,reader);
			}catch(IOException e){
				System.out.println("File read error : " + e);
			}catch(Exception e){
				System.out.println(e);
			}
		}else if(string.length() > 4 && string.length() <= 10 ){
			System.out.println("回答字数在5-10之间");
			tici1 t= new tici1() ;
			t.zhengxiangpipei(string);
		}else if(string.length() <= 4){
			System.out.println("回答字数在4以内");
			char[] ch  = string.toCharArray();
			pailie3 p = new pailie3(ch);
			p.dopailie2(string);
		}

		System.out.println("Count     :   "+ Count + "            finishCount  : "+ finishCount + "\t");

		if(finishCount != Count){
			System.out.println("三次问题长度不都大于10");
			list.clear();//清空链表重新记录下一次问题字数大于10 的问题
			finishCount = -1 ;//重新记录
			Count       = -1 ;//重新记录
		}else if(finishCount == 2){//两者都记录了3次，捣蛋人类型，使用关键字算法/吵架库
			//关键字算法
			System.out.println("需要使用关键字算法");
			new guanjianzi(list);
		}
	}
/*
	public void mangda(String string){

//		盲答
		try{
			Random random=new Random();
			int i = 0 ;//记录文本行
			FileReader reader = new FileReader("E:/34.txt");//盲答表文件的位子
			BufferedReader br = new BufferedReader(reader);         
			String   strs ;
			String[] str  = new String[210];			
			while((strs = br.readLine()) != null){									
				str[i] = strs ;
				i++ ;
			} 
			reader.close();						
			System.out.println("盲答的答案*： "+str[Math.abs(random.nextInt())%i]+"\n");
			jiqiren2.t1.append("   "+string+"\n\t"+"你能不能说短一点啊，你不说我说了啊 ：");//把字符串打印到JTextArea
			jiqiren2.t1.append("\n\t"+str[Math.abs(random.nextInt())%i]+"\n");
				
		}catch(IOException e){
			System.out.println("File read error : " + e);
		}catch(Exception e){
			System.out.println(e);
		}	
	}		
*/	
}	
