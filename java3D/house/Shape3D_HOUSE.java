import javax.media.j3d.Shape3D;
import javax.media.j3d.TriangleArray;
import javax.media.j3d.Appearance;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Material;

import javax.vecmath.Color3f;

//屋顶
public class Shape3D_HOUSE implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();

	//创建转化节点
	@Override
	public Shape3D createShape3D(){
		
		int vertexCount = 18;
		
		//屋顶
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

	
	//创建外观设置
	public Appearance createApp(){
		Appearance app = new Appearance();
		
		Material material= new Material();
		// 为物体添加材质
		//material.setDiffuseColor(new Color3f(1.0f,1.0f,0.0f));
		
		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);
		
		app.setPolygonAttributes(polygonattributes);


		// 设置辐射光效果
		app.setMaterial(material);

		return app;

	}
}