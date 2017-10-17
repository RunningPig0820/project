import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;

/*
 * 房子
*/
public class Group_HouseRoof_Small implements Simple_Group{
	
	public TransformGroup trans = new TransformGroup();

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		
		createEvent();
		Appearance app = createApp();
	
	
		String str_roof = "E:/java/picture/java3D/Roof.jpg";
		String str_roof1 = "E:/java/picture/java3D/fangyan.jpg";
			
/*****屋顶******/
		
		//图片索引
		float[] index = {
				0.0f,1.0f,
				1.0f,1.0f,
				1.0f,0.0f,
				0.0f,0.0f 
		};
		
		Point3f[] p1 = new Point3f[4];
		p1[0] = new Point3f(-0.3f,0.25f,-0.3f);
		p1[1] = new Point3f(-0.025f,0.5f,-0.3f);
		p1[2] = new Point3f(-0.025f,0.5f,0.3f);
		p1[3] = new Point3f(-0.3f,0.25f,0.3f);

		Point3f[] p2 = new Point3f[4];
		p2[0] = new Point3f(0.025f,0.5f,-0.3f);
		p2[1] = new Point3f(0.3f,0.25f,-0.3f);
		p2[2] = new Point3f(0.3f,0.25f,0.3f);
		p2[3] = new Point3f(0.025f,0.5f,0.3f);
		

		Point3f[] p5 = new Point3f[4];
		p5[0] = new Point3f(-0.025f,0.5f,-0.3f);
		p5[1] = new Point3f( 0.025f,0.5f,-0.3f);
		p5[2] = new Point3f( 0.025f,0.5f,0.3f);
		p5[3] = new Point3f(-0.025f,0.5f,0.3f);
			


		Shape3D shape1 = new Shape3D_HouseWall().createShape3D(p1,str_roof,index);
		Shape3D shape2 = new Shape3D_HouseWall().createShape3D(p2,str_roof,index);
		Shape3D shape5 = new Shape3D_HouseWall().createShape3D(p5,str_roof1,index);
		

		TransformGroup g1= new TransformGroup(); 
		g1.addChild(shape1);
		g1.addChild(shape2);
		g1.addChild(shape5);

		trans.addChild(g1);
		
		return trans ;
	}	
	
	
	//设置自身事件
	@Override
	public void createEvent(){
	}

	//创建外观设置
	public Appearance createApp(){
		Appearance app = new Appearance();
		
		Material material= new Material();
		// 为物体添加材质
		material.setDiffuseColor(new Color3f(1.0f,1.0f,0.0f));
		// 设置辐射光效果
		app.setMaterial(material);

		return app;

	}

}


	