import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Texture2D;

import com.sun.j3d.utils.geometry.Cylinder;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;

import javax.media.j3d.BoundingSphere;
import javax.vecmath.Point3d;

/*
 * 房子
*/
public class Group_Coordinate implements Simple_Group{
	
	public TransformGroup trans = new TransformGroup();
	

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){	
		
		createEvent();

		Simple_Shape3D shape = new Shape3D_Coordinate();
		Simple_Shape3D shape1 = new Shape3D_Coordinate1();				
		Simple_Group shape2 = new Group_Font("X",new Vector3f(4.0f,0.0f,0.0f));		
		Simple_Group shape3 = new Group_Font("Y",new Vector3f(0.0f,4.0f,0.0f));
		Simple_Group shape4 = new Group_Font("Z",new Vector3f(0.0f,0.0f,4.0f));
		
		trans.addChild(shape.createShape3D());
		trans.addChild(shape1.createShape3D());		
		trans.addChild(shape2.createSceneGraph());			
		trans.addChild(shape3.createSceneGraph());	
		trans.addChild(shape4.createSceneGraph());

		return trans;
	}	
	

	//设置自身事件
	@Override
	public void createEvent(){
		trans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		trans.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
		trans.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);	

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
		return null;
	}

}


	