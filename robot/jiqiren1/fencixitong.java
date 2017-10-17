/*
目的是判断中文，与之后的 排列算法一起使用
*/
import java.util.*;
import java.util.regex.*;
import java.io.* ;

public class fencixitong{

	private int j=0;	
	private StringBuilder g=new StringBuilder();//储存除去非汉字的字符串
	public  String gg = "" ;
	static int stri = 0 ;//判断相同答案回答次数
	static String[] str = {"1","2","3"};	

	public fencixitong(String str){
		fenci(str);
	}
		
	public void fenci(String string){
		
			
		str[stri%3] = string;
		stri ++;
		System.out.println("\nstri:"+stri+" str[0]:"+str[0]+" str[1]:"+str[1]+" str[2]:"+str[2]);
		if(str[0].equals(str[1]) && str[0].equals(str[2])){
			System.out.println("能不能换一个问题");
			gg = str[(stri-1)%3];
			try{
				jiqiren2.t1.append("   \n\t"+"你能不能换一句讲讲 ：");//把字符串打印到JTextArea
				FileReader reader = new FileReader("E:/chongfu.txt");
				new mangda().mangda1(gg,reader);
			}catch(IOException e){
				System.out.println("File read error : " + e);
			}catch(Exception e){
				System.out.println(e);
			}

		}else{				
			char[] c=string.toCharArray();//把字符串变成字符数组，把字符串分割了
			for(int i=0;i<c.length;i++){
				String len = Integer.toBinaryString(c[i]);//把字符转换为二进制数
				if(len.length()>8){//判断中文字符
					j++;//判断中文的个数         
					g.append(c[i]);//逐步  拼接						
					while(i == c.length-1){	
						gg= new String(g); //StringButter与String转化	
						i++;//跳出循环
						System.out.println("分词过程中的gg值 ："+gg);
					}			
				}
			}

		}

	}
	
/*	
	public static void main(String[] args){
		fencixitong ff =new fencixitong("你哦啊afsasads你看lk按时发生的");
		System.out.println(ff.gg);
	}
*/
}
		