
import java.util.LinkedList;
import java.io.* ;
import java.util.Random;


public class mangda{

		public void mangda1(String string,FileReader reader){
//		ä��
		try{
			Random random=new Random();
			int i = 0 ;//��¼�ı���
	//		FileReader reader = new FileReader("E:/34.txt");//ä����ļ���λ��
			BufferedReader br = new BufferedReader(reader);         
			String   strs ;
			String[] str  = new String[210];			
			while((strs = br.readLine()) != null){									
				str[i] = strs ;
				i++ ;
			} 
			reader.close();						
			System.out.println("ä��Ĵ�*�� "+str[Math.abs(random.nextInt())%i]+"\n");
//			jiqiren2.t1.append("   "+string+"\n\t"+"���ܲ���˵��һ�㰡���㲻˵��˵�˰� ��");//���ַ�����ӡ��JTextArea
			jiqiren2.t1.append("\n\t"+str[Math.abs(random.nextInt())%i]+"\n");
				
		}catch(IOException e){
			System.out.println("File read error : " + e);
		}catch(Exception e){
			System.out.println(e);
		}	
	}
	
}