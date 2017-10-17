import javax.media.j3d.QuadArray;
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

import java.io.Serializable;

//墙(构建)
public class Shape3D_HouseWall_Great implements Simple_Shape3D,Serializable{
	
	Shape3D shape = new Shape3D();
			
	//创建转化节点
	@Override
	public Shape3D createShape3D(){
		return shape;
	}

	//创建转化节点	
	public Shape3D createShape3D(Point3f[] p,Texture2D texture,float[] index){
					
		Vector3f normal = new Vector3f(0.0f,0.0f,1.0f);

		QuadArray quadlearray = new QuadArray(4,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2|QuadArray.COORDINATES|QuadArray.COLOR_3);
/*		
		float colors[] = {
			0.0f, 0.0f, 1.0f,
			0.0f, 0.0f, 1.0f,
			0.0f, 0.0f, 1.0f,
			0.0f, 0.0f, 1.0f			 
		};
		quadlearray.setColors(0,colors);
*/

		quadlearray.setCoordinates(0,p);
		


		quadlearray.setCoordinates(0,p);
		quadlearray.setNormal(0,normal);
		quadlearray.setNormal(1,normal);
		quadlearray.setNormal(2,normal);
		quadlearray.setNormal(3,normal);
		
		//设置顶点坐标与纹理坐标的对应关系
		TexCoord2f texCoords = new TexCoord2f(index[0],index[1]);
		quadlearray.setTextureCoordinate(0,0,texCoords);
		texCoords = new TexCoord2f(index[2],index[3]);
		quadlearray.setTextureCoordinate(0,1,texCoords);
		texCoords = new TexCoord2f(index[4],index[5]);
		quadlearray.setTextureCoordinate(0,2,texCoords);
		texCoords = new TexCoord2f(index[6],index[7]);
		quadlearray.setTextureCoordinate(0,3,texCoords);
		
		//定义纹理及其外观
		Appearance app = createApp();
		app.setTexture(texture);	

		shape.setGeometry(quadlearray);
		shape.setAppearance(app);
		
		return shape;
	}

	//创建外观设置
	public Appearance createApp(){		
		
		Appearance app = new Appearance();
		
		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);
		app.setPolygonAttributes(polygonattributes);
		
		return app;
		
	}
}

