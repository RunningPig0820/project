
public class Grass {
	
	Function_Bezier fun = new Function_Bezier();
		
	// n �� Bezier ����
	public int n = 11;
		
	//�������ֳ� m ��
	public int m = 64;
		
	//���ÿ�ȵı���
	public int reduce = 1;
		
	//���� u �� [0,1] �ֳɵȷ��߶γ���
	public float division = 1.0f/m;
					
	//�������λ������
	public float[] vert = new float[3*m];
	
	//����
	int[] index = new int[2*m-4];

	public int height = (int)(Math.random()*(10)+1);
	
	public int curve1 = (int)(Math.random()*(4)-2) ;
	public int curve2 = (int)(Math.random()*(4)-2) ;
	public int curve3 = (int)(Math.random()*(4)-2) ;
	public int curve4 = (int)(Math.random()*(4)-2) ;
	public int curve5 = (int)(Math.random()*(4)-2) ;
	public int curve6 = (int)(Math.random()*(4)-2) ;
	
	public float cu1 = (float)(Math.random()*0.2) ;
	public float cu2 = (float)(Math.random()*0.2+0.2) ;
	public float cu3 = (float)(Math.random()*0.2+0.4) ;
	public float cu4 = (float)(Math.random()*0.2+0.6) ;
	public float cu5 = (float)(Math.random()*0.2+0.8) ;

	public float pointx = (float)Math.random() ;	
	public float pointy = (float)Math.random() ;
	public float pointz = (float)Math.random() ;
	

	// n �� Bezier ���� �����λ��
	float[][] P = {
		{ 0.0f, 0.0f/height , 0.0f+0.05f*curve1},
		{ 0.0f, 0.2f/height , cu1+0.05f*curve2},
		{ 0.0f, 0.4f/height , cu2+0.05f*curve3},
		{ 0.0f, 0.6f/height , cu3+0.05f*curve4},
		{ 0.0f, 0.8f/height , cu4+0.05f*curve5},
		{ 0.0f, 1.0f/height , cu5+0.05f*curve6},
		
		{ 0.0f, 1.0f/height , cu5+0.05f*curve4},
		{ 0.0f, 0.8f/height , cu4+0.05f*curve5},
		{ 0.0f, 0.6f/height , cu3+0.05f*curve6},
		{ 0.0f, 0.4f/height , cu2+0.05f*curve3},
		{ 0.0f, 0.2f/height , cu1+0.05f*curve2},
		{ 0.0f, 0.0f/height , 0.0f+0.05f*curve1},		
	};		
		
	
	public void setGrass(){		
		for(int i=0 ; i<m ; i++){
			float a[] = fun.bezier(n,division*i,P);
			vert[3*i+0] = division*i /10+pointx;
			vert[3*i+1] = a[0]+pointy ;
			vert[3*i+2] = a[1]+pointz ;
		}
		
		//��������
		for(int i = 0 ; i <= m/2-2 ; i++ ){
			index[i*4+0] = i	;
			index[i*4+1] = i+1	;
			index[i*4+2] = m-i-2;
			index[i*4+3] = m-i-1;
		}
		
	}	


	public int rem(){
		return m;
	}
		
	public float[] revert(){
		return vert;
	}


	public int[] reindex(){
		return index;
	}

		
}		