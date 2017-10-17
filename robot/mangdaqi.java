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

public class mangdaqi{
	 
	LinkedList<String> list = new LinkedList<String>();//使用链来存储提问者问题
	int finishCount = 0 ;  // 用来记录提问次数	，链的索引
					
	public mangdaqi(String string){
		if(string.length() > 10){
			 list.add(string);
			 mangda(string);
		}
	}

	public void mangda(String string){

//		盲答
		try{
			Random random=new Random();
			int i = 0 ;
			FileReader reader = new FileReader("E://1.txt");//盲答表文件的位子
			BufferedReader br = new BufferedReader(reader);         
			String   strs ;
			String[] str  = new String[100];			
			while((strs = br.readLine()) != null){									
				str[i] = strs ;
				i++ ;
			} 
			reader.close();			
			
			System.out.println("盲答的答案： "+str[Math.abs(random.nextInt())%i]);
			jiqiren.t1.append(string+"\n\t"+str[Math.abs(random.nextInt())%i]+"\n");//把字符串打印到JTextArea

		}catch(IOException e){
			System.out.println("File read error : " + e);
		}catch(Exception e){
			System.out.println(e);
		}	

//		筛选提问者的类型和使用哪种算法			
/*
		需要判断提问三次提问长度：
		1.如果三次提问长度多在 10个字以上    把他归为捣蛋人类型，使用关键字算法   和 应答库
		2.如果三次提问中有提问字数在五个字内 把他归为正常人类型，使用排列组合算法 和 吵架库		
	
*/		



			list.add(string);
			finishCount ++  ;
	}											
								
}	
