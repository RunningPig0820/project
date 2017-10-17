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

//墙(构建)
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

	//创建转化节点
	@Override
	public Shape3D createShape3D(){
		
		// 创建直线数组对象
		IndexedTriangleArray line = new IndexedTriangleArray(vertexesCount,IndexedTriangleArray.COORDINATES|IndexedTriangleArray.COLOR_3|IndexedTriangleArray.TEXTURE_COORDINATE_2,indexCount);
		// 设置直线对象的坐标数组
		line.setCoordinates(0,vert);		
		// 设置指定索引位置的坐标。
		line.setCoordinateIndices(0,index);			
		
		line.setColors(0,color);

		// 设置贴图对象的坐标数组
		line.setTextureCoordinates(0,0,tex);
		// 设置贴图索引位置的坐标。
		line.setTextureCoordinateIndices(0,0,index);

/*		
		for(int i = 0 ; i < vert.length-6; i++){
			line.setTextureCoordinate(0,i,tex[i]);
		}
*/

		// 创建直线属性对象		
		PolygonAttributes linea = new PolygonAttributes();
		linea.setCullFace(PolygonAttributes.CULL_NONE);

		//创建几何外观属性的对象		
		Appearance app = createApp(); 
		//设置外观的点属性
		app.setPolygonAttributes(linea);				
		
		//关联点集到几何体
		shape.setGeometry(line);
		//添加几何体到场景中
		shape.setAppearance(app);
		
		return shape;
	}


	//创建外观设置
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