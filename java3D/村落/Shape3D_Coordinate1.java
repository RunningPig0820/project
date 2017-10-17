import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;
import javax.media.j3d.LineArray;
import javax.media.j3d.LineAttributes;

import javax.vecmath.Color3f;

//屋顶
public class Shape3D_Coordinate1 implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();
	
	// 轴
	float vertXYZ[] = {
		 // X 轴
		-4.0f,0.0f,0.0f,
		 4.0f,0.0f,0.0f,
		 //箭头		 
		 4.0f,0.0f,0.0f,
		 3.5f,0.5f,0.0f,
		 4.0f,0.0f,0.0f,
		 3.5f,-0.5f,0.0f,
		
		
		// Y 轴
		0.0f,-4.0f,0.0f,
		0.0f,4.0f,0.0f,
		//箭头
		0.0f,4.0f,0.0f,
		0.5f,3.5f,0.0f,
		0.0f,4.0f,0.0f,
		-0.5f,3.0f,0.0f,

		// Z 轴
		0.0f,0.0f,-4.0f,
		0.0f,0.0f,4.0f,
		//箭头
		0.0f,0.0f,4.0f,
		0.5f,0.0f,3.5f,
		0.0f,0.0f,4.0f,
		-0.5f,0.0f,3.5f,

	};
				

	//颜色
	float color[]={
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
	};

	//创建转化节点
	@Override
	public Shape3D createShape3D(){

		// 创建坐标向量
		LineArray line = new LineArray(18,LineArray.COORDINATES|LineArray.COLOR_3);		
		// 设置直线对象的坐标数组
		line.setCoordinates(0,vertXYZ);
		// 设置颜色
		line.setColors(0,color); 

		// 创建直线属性对象
		LineAttributes linea = new LineAttributes();
		// 设置线宽
		linea.setLineWidth(2.0f);
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