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
			
	//将函数分成 m 分
	int m;
					
	//各个点的位置坐标
	float[] vert ;
				
	float[] color;

	//索引
	int[] index ;
	
	public void setparameter(int m,float[] vert,int[] index){
		this.m = m;
		this.vert = vert;
		this.index = index ;
	}
		
	public void createBezier(){
		
		IndexedQuadArray quadlearray = new IndexedQuadArray(m,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2,2*m-4);
		// 设置直线对象的坐标数组
		quadlearray.setCoordinates(0,vert);
		// 设置直线对象的坐标索引
		quadlearray.setCoordinateIndices(0,index);

		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);			
		
		//创建几何外观属性的对象		
		Appearance app = new Appearance(); 
		//设置纹理
		app.setPolygonAttributes(polygonattributes);
		
		//关联点集到几何体
		this.setGeometry(quadlearray);
		//添加几何体到场景中
		this.setAppearance(app);
		
	}	
		
}		