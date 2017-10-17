
import java.util.LinkedList;
import java.io.* ;
import java.util.Random;


public class mangda{

		public void mangda1(String string,FileReader reader){
//		盲答
		try{
			Random random=new Random();
			int i = 0 ;//记录文本行
	//		FileReader reader = new FileReader("E:/34.txt");//盲答表文件的位子
			BufferedReader br = new BufferedReader(reader);         
			String   strs ;
			String[] str  = new String[210];			
			while((strs = br.readLine()) != null){									
				str[i] = strs ;
				i++ ;
			} 
			reader.close();						
			System.out.println("盲答的答案*： "+str[Math.abs(random.nextInt())%i]+"\n");
//			jiqiren2.t1.append("   "+string+"\n\t"+"你能不能说短一点啊，你不说我说了啊 ：");//把字符串打印到JTextArea
			jiqiren2.t1.append("\n\t"+str[Math.abs(random.nextInt())%i]+"\n");
				
		}catch(IOException e){
			System.out.println("File read error : " + e);
		}catch(Exception e){
			System.out.println(e);
		}	
	}
	
}