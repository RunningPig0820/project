//��Ҫ��һ���ִ�ϵͳ
//һ�����������һ���� n��������ϣ����str��ֵ�����ʮ�ֺ�ʱ�䣬������str���������
/*
	��������㷨������һ������ n �����Ľ������ʱ��n!�������,�������еĵ�һ������
	n�п��ܣ��ڶ��������� n-1 �ֿ��ܡ����� �ܹ�����Ͼ��� n �������������

	�㷨д�� �� ģ����������㷨�����еĵ�һ������ԭ�����е�n����һ�����ڶ������ǳ�ȥ
	���źõĵ�һ���������е�n-1����һ����Ҳ����˵�����е�m������ʱ����ǳ�ȥ�źõ�
	m-1 ������ n-��m-1������һ��������ÿ�����ж����ظ���ͬ�Ĳ��裺�ų�ԭ�ȵ����й���
	���������г�����δ���оͿ����ǵݹ��㷨���ݹ��㷨��ʹ�ù����л��¼���е�ֵ����ڴ�
	ʹ�ù��󣬵��������Ҫ��¼���й����в�������ֵ����μ�¼�ѳ�ȥ����������Ҫ����һ��
	��������¼ԭ��Ԫ�ص����飬��ǰ���������ʹ�õ���һ���������档��μ�¼��������ɵģ�
	������λ�õ���Ԫ�ظ���ʱ��һ���������
	
	�Լ�д���ֵ����⣺
		�����Ǵ����ϵ�һ�δ��룬���Լ�д��ʱ������������⣺

		1.������������¼��ǰ��������ϣ�����̫�����ж�������ֵ�ͱ�ú��ң�д�������Լ�
		Ҳ��֪��ֵ���������
		2.�޷��ܺöԵݹ�����һ���ж�
		3.�Է��������������壬û�кܸߵı�ʶ��


	
*/


import java.util.*;

public class pailie2{
		
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
	  
	  public pailie2(char[] Char1){
              MAX_INDEX = Char1.length;
              finishIndex = 0;
              finishCount = 0;
              Char = new char[MAX_INDEX];
              savedChar = new LinkedList<Character>();
              for(int i=0; i<MAX_INDEX; i++){
                     Char[i] = Char1[i];
              }
       }

       public void dopailie2(){
              saveChar(Char);
              System.out.println("һ�� " + finishCount + "����ϣ�");
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
/*
	public static void main(String[] args){
		char[] ch  = ("12345").toCharArray();
		pailie2 p = new pailie2(ch);
		p.dopailie2();
	}
*/
} 