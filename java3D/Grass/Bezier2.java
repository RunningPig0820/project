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
		
public class Bezier2 extends Shape3D{
		
	// n 次 Bezier 曲线
	int n = 11;
	
	//将函数分成 m 分
	int m = 64;
		
	//设置宽度的倍速
	int reduce = 1;
		
	//参数 u 再 [0,1] 分成等分线段长度
	float division = 1.0f/m;
					
	//各个点的位置坐标
	float[] vert = new float[3*m];

		
	// n 次 Bezier 曲线 顶点的位置
	float[][] P = {
		{ 0.0f, 0.0f , 0.0f},
		{ 0.0f, 0.2f , 0.0f},
		{ 0.0f, 0.4f , 0.0f},
		{ 0.0f, 0.6f , 0.0f},
		{ 0.0f, 0.8f , 0.0f},
		{ 0.0f, 1.0f , 0.0f},
		
		{ 0.0f, 1.0f , 0.0f},
		{ 0.0f, 0.8f,  0.0f},
		{ 0.0f, 0.6f , 0.0f},
		{ 0.0f, 0.4f , 0.0f},
		{ 0.0f, 0.2f , 0.0f},
		{ 0.0f, 0.0f , 0.0f},		
	};	
	


	//索引
	int[] index = new int[2*m-4];
		
	Function_Bezier fun = new Function_Bezier();
		
	public Bezier2(){
		
		for(int i=0 ; i<m ; i++){
			float a[] = fun.bezier(n,division*i,P);
			vert[3*i+0] = division*i ;
			vert[3*i+1] = a[0] ;
			vert[3*i+2] = a[1] ;
		}
		
		//设置索引
		for(int i = 0 ; i <= m/2-2 ; i++ ){
			index[i*4+0] = i	;
			index[i*4+1] = i+1	;
			index[i*4+2] = m-i-2;
			index[i*4+3] = m-i-1;
		}
		
		IndexedQuadArray quadlearray = new IndexedQuadArray(m,GeometryArray.COORDINATES|GeometryArray.NORMALS|GeometryArray.TEXTURE_COORDINATE_2,2*m-4);
		// 设置直线对象的坐标数组
		quadlearray.setCoordinates(0,vert);
		// 设置直线对象的坐标索引
		quadlearray.setCoordinateIndices(0,index);
		// 设置颜色


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