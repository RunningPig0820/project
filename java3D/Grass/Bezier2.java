import javax.media.j3d.Shape3D;
import javax.media.j3d.QuadArray;
import javax.media.j3d.IndexedQuadArray;
import javax.media.j3d.Appearance;
import javax.media.j3d.Texture;
import javax.media.j3d.Texture2D;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.PolygonAttributes;
		
import javax.vecmath.TexCoord2f;
		
import com.sun.j3d.utils.image.TextureLoader;
		
public class Bezier2 extends Shape3D{
		
	// n �� Bezier ����
	int n = 11;
	
	//�������ֳ� m ��
	int m = 64;
		
	//���ÿ�ȵı���
	int reduce = 1;
		
	//���� u �� [0,1] �ֳɵȷ��߶γ���
	float division = 1.0f/m;
					
	//�������λ������
	float[] vert = new float[3*m];

		
	// n �� Bezier ���� �����λ��
	float[][] P = {
		{ 0.0f, 0.0f , 0.0f},
		{ 0.0f, 0.2f , 0.0f},
		{ 0.0f, 0.4f , 0.0f},
		{ 0.0f, 0.6f , 0.0f},
		{ 0.0f, 0.8f , 0.0f},
		{ 0.0f, 1.0f , 0.0f},
		
		{ 0.0f, 1.0f , 0.0f},
		{ 0.0f, 0.8f,  0.0f},
		{ 0.0f, 0.6f , 0.0f},
		{ 0.0f, 0.4f , 0.0f},
		{ 0.0f, 0.2f , 0.0f},
		{ 0.0f, 0.0f , 0.0f},		
	};	
	


	//����
	int[] index = new int[2*m-4];
		
	Function_Bezier fun = new Function_Bezier();
		
	public Bezier2(){
		
		for(int i=0 ; i<m ; i++){
			float a[] = fun.bezier(n,division*i,P);
			vert[3*i+0] = division*i ;
			vert[3*i+1] = a[0] ;
			vert[3*i+2] = a[1] ;
		}
		
		//��������
		for(int i = 0 ; i <= m/2-2 ; i++ ){
			index[i*4+0] = i	;
			index[i*4+1] = i+1	;
			index[i*4+2] = m-i-2;
			index[i*4+3] = m-i-1;
		}
		
		IndexedQuadArray quadlearray = new IndexedQuadArray(m,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2,2*m-4);
		// ����ֱ�߶������������
		quadlearray.setCoordinates(0,vert);
		// ����ֱ�߶������������
		quadlearray.setCoordinateIndices(0,index);
		// ������ɫ


		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);			
		
		//��������������ԵĶ���		
		Appearance app = new Appearance(); 
		//��������
		app.setPolygonAttributes(polygonattributes);
		
		//�����㼯��������
		this.setGeometry(quadlearray);
		//��Ӽ����嵽������
		this.setAppearance(app);
		
	}	
		
}		