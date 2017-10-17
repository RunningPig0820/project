//需要有一个分词系统
//一个词语的穷尽组成一共有 n！次种组合，如果str的值过大会十分耗时间,尽量让str在五个以内


public class fenci1{
	
	//char[] ch;
	//ch[]=str.toCharArray();//str 为缩减过的关键字
	
	char[] ch  = ("123").toCharArray();//测试
	
	char[] ch1 = new char[ch.length+1] ; //存储递归算法中取出的值	
	char[] ch2 ;//递归的新字符数组

	int ch1i  = 1 ;//记录ch1[]储存了多少 


	void f(char Char){

		String s = "";
		int m = 0 ; //记录ch2
		for(int i = 0 ; i < ch.length ; i ++){
			s = s +ch[i]+ " " ;
			add(ch[i]);			
			for(int i = 0 ; i < ch.length ; i ++){
				if(ch2[m] == ch1[ch1i-1]){
					continue;
                }else{
                    ch2[m] =ch1[ch1i-1];
				}                            
			}
			f(ch2);
		}
		
	}

	void add(char CHAR){
		ch1[ch1i] = CHAR;
		ch1i ++ ;
	}

}