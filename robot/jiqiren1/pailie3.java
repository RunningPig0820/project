//*���пհ�
import java.util.*;
import java.sql.*;
import java.io.* ;
import java.util.Random;

public class pailie3{
		
      //Ҫ������ϵ�Ԫ�ظ���
      private static int MAX_INDEX   ;
      //��ǰ��������Ҫ�������ֵ�����λ��
      private static int finishIndex ;
      //�Ѿ���ɵ����е�����
      private static int finishCount ;
      //��¼����Ԫ�ص�����
      private char[] Char;
      //��ǰ���������
      private LinkedList<Character> savedChar;
	  
	  String[] str1  = new String[30];	  
	  String str = "";
	  String sss = null ; //��ƥ�䣨pailei3����ֻ�ڱ�������
	  String SS ;
	  int str1i =0 ;
	  
	  public pailie3(char[] Char1){
		  MAX_INDEX = Char1.length;
		  finishIndex = 0;
		  finishCount = 0;
		  Char = new char[MAX_INDEX];
		  System.out.println("MAX_INDEX : " + MAX_INDEX);
		  savedChar = new LinkedList<Character>();
		  for(int i=0; i<MAX_INDEX ; i++){
				 Char[i] = Char1[i];
				 System.out.println("Char[i] : " + Char[i]);
		  }
		  System.out.println("����ʹ����������㷨");
       }
					
       public void dopailie2(String str){
	//	  public void dopailie2(){
		  saveChar(Char);
		  System.out.println("һ�� " + finishCount + "����ϣ�");
		  if(sss == null){//�ٴη�һ��
				String jj = null ;//�ж� dopailie2 ���Ƿ�ƥ�䲻����
				for(int i = str.length() ; i > 0 ;i-- ){
					System.out.println(str);
					if(pipei(SS = str.substring(0,i)) == true){
						jj = "true";
						return ;							
					}
				}	
				if(jj != "true"){
					try{
						FileReader reader = new FileReader("E:/buhuiyingda.txt");
						new mangda().mangda1("",reader);
					}catch(IOException e){
						System.out.println("File read error : " + e);
					}catch(Exception e){
						System.out.println(e);
					}
				}			
											
		  }else{
			sss = null;
		  }

       }
		
       //���������ϣ����������Ļ
       private void saveChar(char[] Char){
		  //ѭ�������������ĵݹ��������
		  for(int i=0; i<MAX_INDEX-finishIndex; i++){

				 //���ѡ�е�Ԫ�ص�����
				 savedChar.addLast(Char[i]);					 									

				 //��¼�Ѿ�ѡȡ��Ԫ��
				 char numBuf = Char[i];

				 //��¼����ɵ������������
				 if(finishIndex == (MAX_INDEX-1)){
						finishCount ++ ; 
				 }

				 //��������ݹ���һ��Ҫ�õ�����
				 char nextChar[] = new char[MAX_INDEX - (finishIndex+1)];
				 int m = 0;

				 //����δѡ�õ�����
				 for(int n=0; n<MAX_INDEX-finishIndex; n++){
						if(Char[n] == numBuf){
							   continue;
						}
						else{
							   nextChar[m] = Char[n];
							   m++;
						}
				 }
				 //�Ƿ�����ݹ�
				 if((MAX_INDEX - (finishIndex+1)) != 0){
						//�ݹ����������1
						finishIndex++;
						saveChar(nextChar);
				 }else{
				//�����һ�ֵݹ����ɵ��������
					System.out.println(savedChar);
					
					for(int ii = 0 ; ii < savedChar.size() ; ii ++){
						str = str + savedChar.get(ii);
					}
					if(pipei(str)==true){
						System.out.println("+++++++++");
						sss = "true";
						return ;//�ҵ�һ���𰸾��˳�
					}
				}

              }

              try{
                     //�ж��Ƿ��ǵݹ�����һ��
                     if(finishIndex == (MAX_INDEX-1)){
                            //�Ƴ�������ϵ����һλԪ��
                            savedChar.removeLast();
                            //�Ƴ�������ϵ����һλԪ��
                            savedChar.removeLast();
							str = "";
                     }else{
                            //�Ƴ�������ϵ����һλԪ��
                            savedChar.removeLast();
                     }
              }
              catch(Exception e){}
              finally{
                     //�ص���һ�㣬�ݹ����Ҫ��1
                     finishIndex--;
              }
       }


	   	boolean pipei(String str){
			MySQL3 ms = new MySQL3() ;
			ms.connSQL();//��λ
			String Sql = "select * from yingdaku";
			ResultSet resultSet = ms.selectSQL(Sql);
			ms.layoutStyle1(resultSet,str);	
			ms.deconnSQL();		
		if(ms.string != null){//����ƥ�䣨MySQL��������
			System.out.println("++++ true +++++");
			ms.string = null ;
			return true;
		}else{
			System.out.println("++++ false +++++");
			return false;
		}

	}
/*
	   public static void main(String[] args){
		    char[] ch = {'��','��','��'};
		    pailie3 p = new pailie3(ch);
			p.dopailie2();
	   }
*/
}
