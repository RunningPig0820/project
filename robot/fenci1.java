//��Ҫ��һ���ִ�ϵͳ
//һ�����������һ���� n��������ϣ����str��ֵ�����ʮ�ֺ�ʱ��,������str���������


public class fenci1{
	
	//char[] ch;
	//ch[]=str.toCharArray();//str Ϊ�������Ĺؼ���
	
	char[] ch  = ("123").toCharArray();//����
	
	char[] ch1 = new char[ch.length+1] ; //�洢�ݹ��㷨��ȡ����ֵ	
	char[] ch2 ;//�ݹ�����ַ�����

	int ch1i  = 1 ;//��¼ch1[]�����˶��� 


	void f(char Char){

		String s = "";
		int m = 0 ; //��¼ch2
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