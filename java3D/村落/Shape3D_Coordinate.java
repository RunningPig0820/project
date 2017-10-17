import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;
import javax.media.j3d.LineArray;
import javax.media.j3d.LineAttributes;

import javax.vecmath.Color3f;

//屋顶
public class Shape3D_Coordinate implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();
	
	//一根轴要画 n 根
	int n =  50;

	//直线的定点坐标 n根 有2n个点  有6n个float  共要画两根
	float vert[] = new float[n*12+12];


	//创建转化节点
	@Override
	public Shape3D createShape3D(){
				
		for(int i = 0 ; i <= n ; i++){
			vert[i*6+0] = (float)n/2;
			vert[i*6+1] = 0.0f;
			vert[i*6+2] = (float)n/2-i;

			vert[i*6+3] = (float)-n/2;
			vert[i*6+4] = 0.0f;
			vert[i*6+5] = (float)n/2-i;
		};		
		
		for(int i = 0 ; i <= n ; i++){
			vert[i*6+6+n*6+0] = (float)n/2-i;
			vert[i*6+6+n*6+1] =  0.0f;
			vert[i*6+6+n*6+2] = (float)n/2;

			vert[i*6+6+n*6+3] = (float)n/2-i;
			vert[i*6+6+n*6+4] = 0.0f;
			vert[i*6+6+n*6+5] = (float)-n/2;
		};

		
		// 创建直线数组对象
		LineArray line = new LineArray(n*12+12,LineArray.COORDINATES|LineArray.COLOR_3);		
		// 设置直线对象的坐标数组
		line.setCoordinates(0,vert);
		

		// 创建直线属性对象
		LineAttributes linea = new LineAttributes();
		// 设置线宽
		linea.setLineWidth(1.0f);
		// 设置直线的渲染效果
		linea.setLineAntialiasingEnable(true);

		//创建几何外观属性的对象
		Appearance app = new Appearance();
		//设置外观的点属性
		app.setLineAttributes(linea);


		//关联点集到几何体
		shape.setGeometry(line);

		//添加几何体到场景中
		shape.setAppearance(app);

		return shape;
	}

	
	//创建外观设置
	public Appearance createApp(){
		return null;
	}
}