import javax.media.j3d.Shape3D;
import javax.media.j3d.IndexedTriangleArray;
import javax.media.j3d.Appearance;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.Texture2D;
import javax.media.j3d.Texture;
import javax.media.j3d.GeometryArray;

import javax.vecmath.Color3f;
import javax.vecmath.TexCoord2f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.ImageComponent2D;

//ǽ(����)
public class Shape3D_Car implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();
	zuobiao zb = new zuobiao();

	int vertexesCount ;
	int indexCount  ;
	
	float[] vert ;
	int[] index ;
	
	TexCoord2f tex[];
	
	float[] color = {0.0f,1.0f,0.0f};

	public Shape3D_Car(){
		
		vert  = zb.getvert() ;
		index = zb.getindex() ;
		tex   = zb.gettex();

		vertexesCount = vert.length/3;
		indexCount	  = vert.length-6;
	}

	//����ת���ڵ�
	@Override
	public Shape3D createShape3D(){
		
		// ����ֱ���������
		IndexedTriangleArray line = new IndexedTriangleArray(vertexesCount,IndexedTriangleArray.COORDINATES|IndexedTriangleArray.COLOR_3|IndexedTriangleArray.TEXTURE_COORDINATE_2,indexCount);
		// ����ֱ�߶������������
		line.setCoordinates(0,vert);		
		// ����ָ������λ�õ����ꡣ
		line.setCoordinateIndices(0,index);			
		
		line.setColors(0,color);

		// ������ͼ�������������
		line.setTextureCoordinates(0,0,tex);
		// ������ͼ����λ�õ����ꡣ
		line.setTextureCoordinateIndices(0,0,index);

/*		
		for(int i = 0 ; i < vert.length-6; i++){
			line.setTextureCoordinate(0,i,tex[i]);
		}
*/

		// ����ֱ�����Զ���		
		PolygonAttributes linea = new PolygonAttributes();
		linea.setCullFace(PolygonAttributes.CULL_NONE);

		//��������������ԵĶ���		
		Appearance app = createApp(); 
		//������۵ĵ�����
		app.setPolygonAttributes(linea);				
		
		//�����㼯��������
		shape.setGeometry(line);
		//��Ӽ����嵽������
		shape.setAppearance(app);
		
		return shape;
	}


	//�����������
	public Appearance createApp(){		
		
		Appearance app = new Appearance();
		
	    TextureLoader texLoader = new TextureLoader("E:/java/1.jpg", null);
		app.setTexture(texLoader.getTexture());

		PolygonAttributes pa = new PolygonAttributes();
		pa.setCullFace(PolygonAttributes.CULL_NONE);
		pa.setPolygonMode(PolygonAttributes.POLYGON_FILL);
		app.setPolygonAttributes(pa);

		return app;
		
	}

}