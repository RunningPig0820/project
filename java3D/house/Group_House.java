import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
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
public class Group_House implements Simple_Group{
	
	public TransformGroup trans = new TransformGroup();

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		
		createEvent();
		Appearance app = createApp();
		
		String str_wall1 = "E:/java/picture/java3D/wall.jpg";
		String str_wall2 = "E:/java/picture/java3D/ground.jpg";
			
		//右面墙
		Point3f[] p1 = new Point3f[4];
		p1[0] = new Point3f(0.6f,-0.3f, 0.5f);
		p1[1] = new Point3f(0.6f,-0.3f,-0.5f);
		p1[2] = new Point3f(0.6f, 0.3f,-0.5f);
		p1[3] = new Point3f(0.6f, 0.3f, 0.5f);
		
		//左面墙
		Point3f[] p2 = new Point3f[4];
		p2[0] = new Point3f(-0.6f,-0.3f, 0.5f);
		p2[1] = new Point3f(-0.6f,-0.3f,-0.5f);
		p2[2] = new Point3f(-0.6f, 0.3f,-0.5f);
		p2[3] = new Point3f(-0.6f, 0.3f, 0.5f);
		
		//后面
		Point3f[] p3 = new Point3f[4];
		p3[1] = new Point3f( 0.6f,-0.3f,-0.5f);
		p3[2] = new Point3f( 0.6f, 0.3f,-0.5f);
		p3[3] = new Point3f(-0.6f, 0.3f,-0.5f);
		p3[0] = new Point3f(-0.6f,-0.3f,-0.5f);
		
		
		//地面
		Point3f[] p4 = new Point3f[4];
		p4[1] = new Point3f( 0.6f,-0.3f,0.5f);
		p4[2] = new Point3f( 0.6f,-0.3f,-0.5f);
		p4[3] = new Point3f(-0.6f,-0.3f,-0.5f);
		p4[0] = new Point3f(-0.6f,-0.3f,0.5f);

		//上面
		Point3f[] p5 = new Point3f[4];
		p5[1] = new Point3f( 0.6f,0.3f,0.5f);
		p5[2] = new Point3f( 0.6f, 0.3f,-0.5f);
		p5[3] = new Point3f(-0.6f, 0.3f,-0.5f);
		p5[0] = new Point3f(-0.6f,0.3f,0.5f);
		

		Shape3D shape1 = new Shape3D_HouseWall().createShape3D(p1,str_wall1);
		Shape3D shape2 = new Shape3D_HouseWall().createShape3D(p2,str_wall1);
		Shape3D shape3 = new Shape3D_HouseWall().createShape3D(p3,str_wall1);
		Shape3D shape4 = new Shape3D_HouseWall().createShape3D(p4,str_wall2);
		Shape3D shape5 = new Shape3D_HouseWall().createShape3D(p5,str_wall2);
		Shape3D shape6 = new Shape3D_HouseRoof().createShape3D();

		TransformGroup g1= new TransformGroup(); 
		g1.addChild(shape1);
		g1.addChild(shape2);
		g1.addChild(shape3);
		g1.addChild(shape4);
		g1.addChild(shape5);
		g1.addChild(shape6);

		trans.addChild(g1);
		
		return trans ;
	}	
	
	
	//设置自身事件
	@Override
	public void createEvent(){

		trans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		trans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		MouseRotate behavior = new MouseRotate();
		behavior.setTransformGroup(trans);
		trans.addChild(behavior);	
		behavior.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
		
		MouseZoom behavior2 = new MouseZoom();
		behavior2.setTransformGroup(trans);
		trans.addChild(behavior2);
		behavior2.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));

		MouseTranslate behavior3 = new MouseTranslate();	
		behavior3.setTransformGroup(trans);
		trans.addChild(behavior3);	
		behavior3.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
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


	