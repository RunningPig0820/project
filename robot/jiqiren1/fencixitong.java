/*
Ŀ�����ж����ģ���֮��� �����㷨һ��ʹ��
*/
import java.util.*;
import java.util.regex.*;
import java.io.* ;

public class fencixitong{

	private int j=0;	
	private StringBuilder g=new StringBuilder();//�����ȥ�Ǻ��ֵ��ַ���
	public  String gg = "" ;
	static int stri = 0 ;//�ж���ͬ�𰸻ش����
	static String[] str = {"1","2","3"};	

	public fencixitong(String str){
		fenci(str);
	}
		
	public void fenci(String string){
		
			
		str[stri%3] = string;
		stri ++;
		System.out.println("\nstri:"+stri+" str[0]:"+str[0]+" str[1]:"+str[1]+" str[2]:"+str[2]);
		if(str[0].equals(str[1]) && str[0].equals(str[2])){
			System.out.println("�ܲ��ܻ�һ������");
			gg = str[(stri-1)%3];
			try{
				jiqiren2.t1.append("   \n\t"+"���ܲ��ܻ�һ�佲�� ��");//���ַ�����ӡ��JTextArea
				FileReader reader = new FileReader("E:/chongfu.txt");
				new mangda().mangda1(gg,reader);
			}catch(IOException e){
				System.out.println("File read error : " + e);
			}catch(Exception e){
				System.out.println(e);
			}

		}else{				
			char[] c=string.toCharArray();//���ַ�������ַ����飬���ַ����ָ���
			for(int i=0;i<c.length;i++){
				String len = Integer.toBinaryString(c[i]);//���ַ�ת��Ϊ��������
				if(len.length()>8){//�ж������ַ�
					j++;//�ж����ĵĸ���         
					g.append(c[i]);//��  ƴ��						
					while(i == c.length-1){	
						gg= new String(g); //StringButter��Stringת��	
						i++;//����ѭ��
						System.out.println("�ִʹ����е�ggֵ ��"+gg);
					}			
				}
			}

		}

	}
	
/*	
	public static void main(String[] args){
		fencixitong ff =new fencixitong("��Ŷ��afsasads�㿴lk��ʱ������");
		System.out.println(ff.gg);
	}
*/
}
		