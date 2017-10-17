import javax.media.j3d.Shape3D;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Appearance;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.Texture2D;
import javax.media.j3d.Texture;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.ImageComponent2D;

import javax.vecmath.Color3f;
import javax.vecmath.TexCoord2f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.image.TextureLoader;

//屋顶(构建)
public class Shape3D_HouseRoof implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();

	//创建转化节点
	@Override
	public Shape3D createShape3D(){
		
		// 形状由几个点构成
		int vertexCount = 4 ;
		
		// 有几个面形成
		int vertexFace = 2	;
		
		int i = 0 ;
		int j = 0 ;

		//屋顶
		float P[][][] = {
			{
				{ -0.6f,0.3f,-0.5f } ,
				{  0.0f,0.6f,-0.5f } ,
				{  0.0f,0.6f, 0.5f } ,				
				{ -0.6f,0.3f, 0.5f } , 
				
				
			},

			{	
				{  0.0f,0.6f,-0.5f } ,								
				{  0.6f,0.3f,-0.5f } ,
				{  0.6f,0.3f, 0.5f } , 
				{  0.0f,0.6f, 0.5f } ,
				
			}
	    };
		
	//	QuadArray Quadsurface = new QuadArray((vertexCount-1)*(vertexFace-1)*4,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2);
		QuadArray Quadsurface = new QuadArray((vertexCount)*(vertexFace),GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2);
	
		//以定点数累加的方法设置定点的序号
		int c = 0 ;
		
		for(i = 0 ; i < vertexFace ; i ++){
	
	//		for(j = 0 ; j < vertexCount -1 ; j++){
				//设置一个平面上的4个点
	/*		
				Point3f A = new Point3f(P[i][j][0],P[i][j][1],P[i][j][2]);
				
				Point3f B = new Point3f(P[i][j+1][0],P[i][j+1][1],P[i][j+1][2]);
				
				Point3f C = new Point3f(P[i+1][j][0],P[i+1][j][1],P[i+1][j][2]);
				
				Point3f D = new Point3f(P[i+1][j+1][0],P[i+1][j+1][1],P[i+1][j+1][2]);
	*/		
	
				Point3f A = new Point3f(P[i][j][0],P[i][j][1],P[i][j][2]);
				
				Point3f B = new Point3f(P[i][j+1][0],P[i][j+1][1],P[i][j+1][2]);
				
				Point3f C = new Point3f(P[i][j+2][0],P[i][j+2][1],P[i][j+2][2]);
				
				Point3f D = new Point3f(P[i][j+3][0],P[i][j+3][1],P[i][j+3][2]);

				//计算由4个点形成的平面的法向量
				Vector3f a = new Vector3f(A.x-B.x,A.y-B.y,A.z-B.z);
				Vector3f b = new Vector3f(C.x-B.x,C.y-B.y,C.z-B.z);
				Vector3f n0 = new Vector3f();
				n0.cross(b,a);
				n0.normalize();

				//设置点的序号
				Quadsurface.setCoordinate(c,A);
				Quadsurface.setCoordinate(c+1,B);
				Quadsurface.setCoordinate(c+2,C);
				Quadsurface.setCoordinate(c+3,D);
				
				//设置点的序号所对应的法向量
				Quadsurface.setNormal(c,n0);
				Quadsurface.setNormal(c+1,n0);
				Quadsurface.setNormal(c+2,n0);
				Quadsurface.setNormal(c+3,n0);
/*
				//设置点的纹理坐标
				TexCoord2f texCoords = new TexCoord2f(i*1.0f/vertexFace,1.0f-j*1.0f/vertexFace);
				Quadsurface.setTextureCoordinate(0,c,texCoords);
				texCoords = new TexCoord2f((i+1)*1.0f/vertexFace,1.0f-j*1.0f/vertexFace);
				Quadsurface.setTextureCoordinate(0,c+1,texCoords);
				texCoords = new TexCoord2f((i+1)*1.0f/vertexFace,1.0f-(j+1)*1.0f/vertexFace);
				Quadsurface.setTextureCoordinate(0,c+2,texCoords);
				texCoords = new TexCoord2f(i*1.0f/vertexFace,1.0f-(j+1)*1.0f/vertexFace);
				Quadsurface.setTextureCoordinate(0,c+3,texCoords);
				

				System.out.println( i*1.0f/vertexFace    + "  " + (1.0f-j*1.0f/vertexFace));
				System.out.println((i+1)*1.0f/vertexFace + "  " + (1.0f-j*1.0f/vertexFace));
				System.out.println((i+1)*1.0f/vertexFace + "  " + (1.0f-(j+1)*1.0f/vertexFace));
				System.out.println( i*1.0f/vertexFace    + "  " + (1.0f-(j+1)*1.0f/vertexFace));
	
	*/			
				//设置顶点坐标与纹理坐标的对应关系
				TexCoord2f texCoords = new TexCoord2f(0.0f,1.0f);
				Quadsurface.setTextureCoordinate(0,c,texCoords);
				texCoords = new TexCoord2f(1.0f,1.0f);
				Quadsurface.setTextureCoordinate(0,c+1,texCoords);
				texCoords = new TexCoord2f(1.0f,0.0f);
				Quadsurface.setTextureCoordinate(0,c+2,texCoords);
				texCoords = new TexCoord2f(0.0f,0.0f);
				Quadsurface.setTextureCoordinate(0,c+3,texCoords);
		

				c = c + 4;
	//		}
		}


		Appearance app = createApp();

		shape.setGeometry(Quadsurface);
		shape.setAppearance(app);
		
		return shape;

	}


	
	//创建外观设置
	public Appearance createApp(){
		
		Appearance app = new Appearance();
		
		//导入纹理
		TextureLoader loader = new TextureLoader("E:/java/picture/java3D/wapian1.jpg",2,null);
		ImageComponent2D image = loader.getImage();
		
		// 创建纹理
		Texture2D texture = new Texture2D(Texture.BASE_LEVEL,Texture.RGBA,image.getWidth(),image.getHeight());
		texture.setImage(0,image);
		texture.setEnable(true);
		
		//设置纹理的放大与缩小过滤
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		app.setTexture(texture);

		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setBackFaceNormalFlip(true);
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);
	
		app.setPolygonAttributes(polygonattributes);
		app.setCapability(Appearance.ALLOW_TEXGEN_WRITE);

		return app;

	}

}
