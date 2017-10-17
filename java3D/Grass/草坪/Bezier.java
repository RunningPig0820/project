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
		
public class Bezier extends Shape3D{
			
	//�������ֳ� m ��
	int m;
					
	//�������λ������
	float[] vert ;
				
	float[] color;

	//����
	int[] index ;
	
	public void setparameter(int m,float[] vert,int[] index){
		this.m = m;
		this.vert = vert;
		this.index = index ;
	}
		
	public void createBezier(){
		
		IndexedQuadArray quadlearray = new IndexedQuadArray(m,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2,2*m-4);
		// ����ֱ�߶������������
		quadlearray.setCoordinates(0,vert);
		// ����ֱ�߶������������
		quadlearray.setCoordinateIndices(0,index);

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