import javax.media.j3d.TransformGroup;

import javax.media.j3d.Appearance;
import javax.media.j3d.Texture2D;
import javax.media.j3d.Transform3D;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;

import com.sun.j3d.utils.geometry.Sphere;

import javax.vecmath.Vector3f;

import java.io.Serializable;

/*
 * 房子柱子
*/
public class Group_Body implements Simple_Group,Serializable{
	
	public TransformGroup group = new TransformGroup();
	public Vector3f vec  ;
	public Sphere sphere ;
	public Box box		 ;
	
	float a ;
	float b ;
	float c ;

	/*
	 *  @parn a:关节半径 b:肩长 c:体长  1.腿 2.手臂
	 *  @parn x:位置X y:位置Y z:位置Z app:外观属性
	*/
	public void setBody(float a,float b,float c,Appearance app){	
		sphere = new Sphere(a);
		box  =  new Box(b,c,a,Box.GENERATE_TEXTURE_COORDS,app);
		
		vec  = new Vector3f(0.0f,-b-c/2,0.0f);

	}

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		// 生成基本的圆锥体		
		TransformGroup group1 = new TransformGroup();
		Transform3D t1 = new Transform3D();	
		t1.setTranslation(vec);
		group1.setTransform(t1);
		group1.addChild(box);		
		
		group.addChild(sphere);
		group.addChild(group1);

		return group ;
	}	
	
	
	//设置自身事件
	@Override
	public void createEvent(){
	}

	//创建外观设置
	@Override
	public Appearance createApp(){
		Appearance app = new Appearance();
		return app;
	}

}


	