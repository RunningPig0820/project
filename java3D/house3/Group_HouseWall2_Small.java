import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
//import javax.media.j3d.Transform3D;
//import javax.media.j3d.TransformGroup;
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
public class Group_HouseWall2_Small implements Simple_Group{
	
	public TransformGroup trans = new TransformGroup();

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		
		createEvent();
		Appearance app = createApp();
		
	
	
		String str_wall1 = "E:/java/picture/java3D/qinagsheng2.jpg";


		Point3f[] p3 = new Point3f[4];
		p3[0] = new Point3f(0.3f,0.3f,0.3f);
		p3[1] = new Point3f(0.3f,0.3f,-0.3f);
		p3[2] = new Point3f(0.3f,0.0f,-0.3f);
		p3[3] = new Point3f(0.3f,0.0f,0.3f);
		
		Point3f[] p4 = new Point3f[4];
		p4[0] = new Point3f(-0.3f,0.3f,0.3f);
		p4[1] = new Point3f(-0.3f,0.3f,-0.3f);
		p4[2] = new Point3f(-0.3f,0.0f,-0.3f);
		p4[3] = new Point3f(-0.3f,0.0f,0.3f);

		//图片索引
		float[] index = {
			0.0f,1.0f, 1.0f,1.0f,
			1.0f,0.0f, 0.0f,0.0f 
		};

		Shape3D shape3 = new Shape3D_HouseWall().createShape3D(p3,str_wall1,index);
		Shape3D shape4 = new Shape3D_HouseWall().createShape3D(p4,str_wall1,index);


		TransformGroup g1= new TransformGroup(); 

		g1.addChild(shape3);
		g1.addChild(shape4);


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


	