import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class fenci2{
		
	   //char[] ch=str.toCharArray();//str Ϊ�������Ĺؼ���	
	   static char[] ch  = ("123").toCharArray();//����			

       //Ҫ������ϵ�Ԫ�ظ���
       private static int MAX_INDEX   = ch.length ;
       //��ǰ��������Ҫ�������ֵ�����λ��
       private static int finishIndex = 0;
       //�Ѿ���ɵ����е�����
       private static int finishCount = 0;
       //��¼����Ԫ�ص�����
       private char[] Char;
       //��ǰ���������
       private LinkedList<Character> savedChar= new LinkedList<Character>();;				
       			
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
                            finishCount++;
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
                     }
                     else{
                            //�����һ�ֵݹ����ɵ��������
                            System.out.println(savedChar);
							finishIndex = 0 ;
                     }
              }
              try{
                     //�ж��Ƿ��ǵݹ�����һ��
                     if(finishIndex == (MAX_INDEX-1)){
                            //�Ƴ�������ϵ����һλԪ��
                            savedChar.removeLast();
                            //�Ƴ�������ϵ����һλԪ��
                            savedChar.removeLast();
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

} 