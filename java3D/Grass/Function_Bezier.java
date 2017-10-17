//Bezier����

//���� u ��[0,1] ; B > 0

public class Function_Bezier {
			
	//n��Bernstein����  ����u ���� flo1 
	//���� ����uʱ  y=flo_be[0]ֵ��z=flo_be[1]ֵ  
	public float[] bezier(int n , float u , float[][] flo){
		
		//����
		int num_a = flo.length;		

		float[] flo_be = new float[2];
		
		flo_be[0] = 0.0f;
		flo_be[1] = 0.0f;
		
		for(int i = 0 ; i < num_a ; i++){
			flo_be[0]   = flo_be[0] + bernstein(n,i,u)*flo[i][1];						
			flo_be[1]   = flo_be[1] + bernstein(n,i,u)*flo[i][2];
		}	
				
		return flo_be;

	}	
	
	//Bernstein�Ļ�����
	// ��i��  n��Bernstein����  u��[0,1]֮�������
	public float bernstein(int n ,int i ,  float u){
		return 1.0f*factorial(n)/factorial(i)/factorial(n-i)*continous(u,i)*continous((1-u),(n-i));
	}
	
	//�η�
	public float continous(float con,int time){
		
		float cont = 1.0f ;

		for(int i = 0 ; i < time ; i++){
			cont = cont * con ;
		}

		return cont;
	}

	//�׳�
	public int factorial(int num){
		int fac = 1 ;
		
		for(int i = 1 ; i <= num ; i++){
			fac = fac * i ;
		}
		
		return fac;
	}
	
}