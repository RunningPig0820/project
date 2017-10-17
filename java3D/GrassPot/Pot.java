import javax.media.j3d.Shape3D;
import javax.media.j3d.IndexedTriangleArray;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Appearance;

public class Pot extends Shape3D{
	
	int m = 9 ;

	//小圆的半径
	double outer_radius;	

	//大圆的半径
	double inner_radius;
		
	double[] vertex = new double[6*m] ;
	
	int[] index = new int[3*m];
	
	float[] color = { 0.0f,1.0f,0.0f};

	//grass_width 用来限制圆的半径
	public Pot(float grass_width){
		
		outer_radius = grass_width/3;
		inner_radius = grass_width/10;
		
		float a = grass_width/7; 
		float b = grass_width/8;

		for(int i = 0 ; i < m*2 ; i ++){
			
			if(i%2==1){
				vertex[i*3]	    = Math.cos(Math.PI/9*i) * outer_radius + (float)(Math.random()*b-b/2);
				vertex[i*3+1]	= Math.sin(Math.PI/9*i) * outer_radius + (float)(Math.random()*b-b/2);
				vertex[i*3+2]	= 0.0f;
			}else{
				vertex[i*3]	= Math.cos(Math.PI/9*i) * inner_radius + (float)(Math.random()*b-b/2);
				vertex[i*3+1]	= Math.sin(Math.PI/9*i) * inner_radius + (float)(Math.random()*b-b/2);
				vertex[i*3+2]	= 0.0f;			
			}
		}
		
		//设置索引
		for(int i = 0 ; i < m ; i++ ){
			index[i*3+0] = i*2	 ;
			index[i*3+1] = i*2+1 ;
			index[i*3+2] = i*2+2 ;
			
			System.out.println((i*2)+"      "+(i*2+1)+"          "+(i*2+2) );

		}

		index[3*m-1] = 0 ;

		IndexedTriangleArray trianglearray = new IndexedTriangleArray(m*2,IndexedTriangleArray.COORDINATES|IndexedTriangleArray.COLOR_3,m*3);
		// 设置直线对象的坐标数组
		trianglearray.setCoordinates(0,vertex);
	//	// 设置直线对象的坐标索引
		trianglearray.setCoordinateIndices(0,index);
		// 设置颜色		
		trianglearray.setColors(0,color);

		PolygonAttributes polygonattributes = new PolygonAttributes();
		polygonattributes.setCullFace(PolygonAttributes.CULL_NONE);			
		
		//创建几何外观属性的对象		
		Appearance app = new Appearance(); 
		//设置纹理
		app.setPolygonAttributes(polygonattributes);
		
		//关联点集到几何体
		this.setGeometry(trianglearray);
		//添加几何体到场景中
		this.setAppearance(app);

	}

}