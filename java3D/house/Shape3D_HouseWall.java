import javax.media.j3d.Shape3D;
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

//墙(构建)
public class Shape3D_HouseWall implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();
	
	//创建转化节点
	@Override
	public Shape3D createShape3D(){
		return shape;
	}

	//创建转化节点	
	public Shape3D createShape3D(Point3f[] p,String pic){
					
		Vector3f normal = new Vector3f(0.0f,0.0f,1.0f);

		QuadArray quadlearray = new QuadArray(4,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2);

		quadlearray.setCoordinates(0,p);
		quadlearray.setNormal(0,normal);
		quadlearray.setNormal(1,normal);
		quadlearray.setNormal(2,normal);
		quadlearray.setNormal(3,normal);
		
		//设置顶点坐标与纹理坐标的对应关系
		TexCoord2f texCoords = new TexCoord2f(0.0f,1.0f);
		quadlearray.setTextureCoordinate(0,3,texCoords);
		texCoords = new TexCoord2f(0.0f,0.0f);
		quadlearray.setTextureCoordinate(0,0,texCoords);
		texCoords = new TexCoord2f(1.0f,0.0f);
		quadlearray.setTextureCoordinate(0,1,texCoords);
		texCoords = new TexCoord2f(1.0f,1.0f);
		quadlearray.setTextureCoordinate(0,2,texCoords);
		
		//导入纹理
		TextureLoader loader = new TextureLoader(pic,null);
		//获取纹理图像
		ImageComponent2D image = loader.getImage();
		//设置纹理图像
		Texture2D texture = new Texture2D(Texture.BASE_LEVEL,Texture.RGBA,image.getWidth(),image.getHeight());
		texture.setImage(0,image);
		//开通纹理映射
		texture.setEnable(true);
		//设置该纹理对象的最高级别
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		
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

