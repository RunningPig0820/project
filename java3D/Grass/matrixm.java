public class matrixm{		
	
	public float[][] calculate(float[][] a , float[][] b){
		
		//列数
		int num_a = a.length;
		//行数
		int num_b = b[0].length;
		
		float[][] flo = new float[num_a][num_b]; 
			
		for(int i = 0 ; i < num_a ; i++){
			for(int j = 0 ; j < num_b ; j++){
				flo[i][j] = 0.0f ;
				for(int k = 0 ; k < num_b ; k++){
					flo[i][j] = a[i][k]*b[k][j] + flo[i][j];
				}
			}
		}
		
		return flo;
	}	

}