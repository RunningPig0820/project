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

//ǽ(����)
public class Shape3D_HouseWall implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();
	
	//����ת���ڵ�
	@Override
	public Shape3D createShape3D(){
		return shape;
	}

	//����ת���ڵ�	
	public Shape3D createShape3D(Point3f[] p,String pic){
					
		Vector3f normal = new Vector3f(0.0f,0.0f,1.0f);

		QuadArray quadlearray = new QuadArray(4,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2);

		quadlearray.setCoordinates(0,p);
		quadlearray.setNormal(0,normal);
		quadlearray.setNormal(1,normal);
		quadlearray.setNormal(2,normal);
		quadlearray.setNormal(3,normal);
		
		//���ö�����������������Ķ�Ӧ��ϵ
		TexCoord2f texCoords = new TexCoord2f(0.0f,1.0f);
		quadlearray.setTextureCoordinate(0,3,texCoords);
		texCoords = new TexCoord2f(0.0f,0.0f);
		quadlearray.setTextureCoordinate(0,0,texCoords);
		texCoords = new TexCoord2f(1.0f,0.0f);
		quadlearray.setTextureCoordinate(0,1,texCoords);
		texCoords = new TexCoord2f(1.0f,1.0f);
		quadlearray.setTextureCoordinate(0,2,texCoords);
		
		//��������
		TextureLoader loader = new TextureLoader(pic,null);
		//��ȡ����ͼ��
		ImageComponent2D image = loader.getImage();
		//��������ͼ��
		Texture2D texture = new Texture2D(Texture.BASE_LEVEL,Texture.RGBA,image.getWidth(),image.getHeight());
		texture.setImage(0,image);
		//��ͨ����ӳ��
		texture.setEnable(true);
		//���ø�����������߼���
		texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
		texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
		
		//�������������
		Appearance app = createApp();		
		app.setTexture(texture);	

		shape.setGeometry(quadlearray);
		shape.setAppearance(app);
		
		return shape;
	}

	//�����������
	public Appearance createApp(){		
		
		Appearance app = new Appearance();
		
		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);
		app.setPolygonAttributes(polygonattributes);
		
		return app;
		
	}
}

