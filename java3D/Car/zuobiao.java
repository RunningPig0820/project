
import javax.vecmath.TexCoord2f;

public class zuobiao{

	
	float[] ve = {
0.5f,0.5f,
0.19377163f,0.4409091f,
0.17993079f,0.72727275f,
0.42906573f,0.85f,
0.6747405f,0.8363636f,
0.73702425f,0.6136364f,
0.71280277f,0.4909091f,
0.37716264f,0.3f,
0.17993079f,0.4090909f,
0.19377163f,0.44545454f,

	};

	float[] vert;
	private TexCoord2f tex[];

	int[] index;

	public zuobiao(){
			
		vert  = new float[ve.length+ve.length/2];
		tex   = new TexCoord2f[ve.length/2];
		
		index = new int[vert.length-6];

		for(int i = 0 ; i < vert.length/3-2 ; i++){
		
			index[i*3]   = 0;
			index[i*3+1] = i+1;
			index[i*3+2] = i+2;
		}

		
		for(int i = 0 ; i < ve.length/2 ; i++){
			
			vert[i*3+0] = ve[i*2];
			vert[i*3+1] = ve[i*2+1];
			vert[i*3+2] = 0.0f;

			tex[i]  = new TexCoord2f(ve[i*2],ve[i*2+1]);
			
		}

	}
	
	
	public int[] getindex(){
		return index;
	}
	
	public float[] getvert(){
		return vert;
	}
	
	public TexCoord2f[] gettex(){
		return tex;
	}

	public static void main(String[] args){
		zuobiao z = new zuobiao();
	}


}
