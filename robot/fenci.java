//需要有一个分词系统
//一个词语的穷尽组成一共有 n！次种组合，如果str的值过大会十分耗时间，尽量让str在五个以内

public class fenci{

public void main(String[] args){

	char[] ch;//起始的字符数组	
	ch=("12").toCharArray();
	f(ch);

}

	
	String f(char[] Char){
		
		String strb = "";
		char[] Char1 = Char;//为了保存每次递归完新的字符数组
		
		for(int ii = 0 ; ii<= ch.length ; ii++ ){
			strb = strb + ch[ii]+" " ;
			ch[ii] = '#';  //以'#' 表示该字符被删除
			Char1.length -- ; //创建完成新数组长度减少一个
			
			//创建新的字符数组
			for(int i = 0 ; i <= ch.length ; i++ ){					
				int j = 0 ;			
				if(Char[i] != '#'){
					Char1[j] = ch[i];
				} 

				f(Char1);
				System.out.println(strb);
			}		
		}			
 }	
		
}
