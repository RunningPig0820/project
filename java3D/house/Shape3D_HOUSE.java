import javax.media.j3d.Shape3D;
import javax.media.j3d.TriangleArray;
import javax.media.j3d.Appearance;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Material;

import javax.vecmath.Color3f;

//�ݶ�
public class Shape3D_HOUSE implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();

	//����ת���ڵ�
	@Override
	public Shape3D createShape3D(){
		
		int vertexCount = 18;
		
		//�ݶ�
		float vertexes[] = {
			
			 0.4f, 0.6f, -0.35f ,  0.4f, 0.6f, 0.35f  , 1.5f, 0.0f, -0.35f ,
			 1.5f, 0.0f, -0.35f ,  1.5f, 0.0f, 0.35f  , 0.4f, 0.6f,  0.35f ,
			 
			 0.4f, 0.6f, -0.35f ,  0.4f, 0.6f, 0.35f  , -0.5f, 0.0f, -0.35f ,
			 -0.5f, 0.0f, -0.35f , -0.5f, 0.0f, 0.35f ,  0.4f, 0.6f, 0.35f ,

		};
		
		float colors[] = {
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f,
			1.0f,1.0f,0.0f, 1.0f,1.0f,0.0f
		};
		
		TriangleArray trianglearray = new TriangleArray(vertexCount,TriangleArray.COORDINATES|TriangleArray.COLOR_3);
		trianglearray.setCoordinates(0,vertexes);
		trianglearray.setColors(0,colors);

		Appearance app = createApp();

		shape.setGeometry(trianglearray);
		shape.setAppearance(app);

		return shape;
	}

	
	//�����������
	public Appearance createApp(){
		Appearance app = new Appearance();
		
		Material material= new Material();
		// Ϊ������Ӳ���
		//material.setDiffuseColor(new Color3f(1.0f,1.0f,0.0f));
		
		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);
		
		app.setPolygonAttributes(polygonattributes);


		// ���÷����Ч��
		app.setMaterial(material);

		return app;

	}
}