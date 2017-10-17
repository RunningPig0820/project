//Bezier函数

//函数 u 在[0,1] ; B > 0

public class Function_Bezier {
			
	//n次Bernstein函数  变量u 顶点 flo1 
	//返回 变量u时  y=flo_be[0]值和z=flo_be[1]值  
	public float[] bezier(int n , float u , float[][] flo){
		
		//列数
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
	
	//Bernstein的基函数
	// 第i个  n次Bernstein函数  u是[0,1]之间的数字
	public float bernstein(int n ,int i ,  float u){
		return 1.0f*factorial(n)/factorial(i)/factorial(n-i)*continous(u,i)*continous((1-u),(n-i));
	}
	
	//次方
	public float continous(float con,int time){
		
		float cont = 1.0f ;

		for(int i = 0 ; i < time ; i++){
			cont = cont * con ;
		}

		return cont;
	}

	//阶乘
	public int factorial(int num){
		int fac = 1 ;
		
		for(int i = 1 ; i <= num ; i++){
			fac = fac * i ;
		}
		
		return fac;
	}
	
}