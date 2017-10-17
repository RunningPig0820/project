import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.BoundingSphere;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3d;

/*
 * 小凳子
*/
public class Group_Stool implements Simple_Group{
	
	public TransformGroup trans = new TransformGroup();

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		
		createEvent();
		Appearance app = createApp();

		TransformGroup g1= new TransformGroup();
		g1.addChild(new Box(0.4f,0.3f,0.05f,app));
		
		Transform3D t = new Transform3D();
		t.setTranslation(new Vector3f(-0.3f,0.2f,-0.3f));		
		TransformGroup g2= new TransformGroup(t);
		g2.addChild(new Box(0.04f,0.04f,0.3f,app));
		
		t= new Transform3D();
		t.setTranslation(new Vector3f(-0.3f,-0.2f,-0.3f));		
		TransformGroup g3= new TransformGroup(t);
		g3.addChild(new Box(0.04f,0.04f,0.3f,app));
		
		t= new Transform3D();
		t.setTranslation(new Vector3f(0.3f,0.2f,-0.3f));		
		TransformGroup g4= new TransformGroup(t); 
		g4.addChild(new Box(0.04f,0.04f,0.3f,app));
		
		t= new Transform3D();
		t.setTranslation(new Vector3f(0.3f,-0.2f,-0.3f));
		
		TransformGroup g5= new TransformGroup(t);
		g5.addChild(new Box(0.04f,0.04f,0.3f,app));
		
		t= new Transform3D();
		t.setTranslation(new Vector3f(-0.3f,0.0f,-0.3f));		
		TransformGroup g6= new TransformGroup(t);
		g6.addChild(new Box(0.03f,0.2f,0.03f,app));
		
		t= new Transform3D();
		t.setTranslation(new Vector3f(0.3f,0.0f,-0.3f));
		TransformGroup g7= new TransformGroup(t);
		g7.addChild(new Box(0.03f,0.2f,0.03f,app));
		
		t= new Transform3D();
		t.setTranslation(new Vector3f(0.0f,0.2f,-0.2f));		
		TransformGroup g8 = new TransformGroup(t);
		g8.addChild(new Box(0.3f,0.03f,0.03f,app));
		
		t = new Transform3D();
		t.setTranslation(new Vector3f(0.0f,-0.2f,-0.2f));		
		TransformGroup g9= new TransformGroup(t);
		g9.addChild(new Box(0.3f,0.03f,0.03f,app));
		
		trans.addChild(g1);
		trans.addChild(g2);
		trans.addChild(g3);
		trans.addChild(g4);
		trans.addChild(g5);
		trans.addChild(g6);
		trans.addChild(g7);
		trans.addChild(g8);
		trans.addChild(g9);
	
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


	