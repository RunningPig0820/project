//��Ҫ��һ���ִ�ϵͳ
//һ�����������һ���� n��������ϣ����str��ֵ�����ʮ�ֺ�ʱ�䣬������str���������

public class fenci{

public void main(String[] args){

	char[] ch;//��ʼ���ַ�����	
	ch=("12").toCharArray();
	f(ch);

}

	
	String f(char[] Char){
		
		String strb = "";
		char[] Char1 = Char;//Ϊ�˱���ÿ�εݹ����µ��ַ�����
		
		for(int ii = 0 ; ii<= ch.length ; ii++ ){
			strb = strb + ch[ii]+" " ;
			ch[ii] = '#';  //��'#' ��ʾ���ַ���ɾ��
			Char1.length -- ; //������������鳤�ȼ���һ��
			
			//�����µ��ַ�����
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
