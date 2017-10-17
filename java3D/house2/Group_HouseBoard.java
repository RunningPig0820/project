import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.Texture2D;

import com.sun.j3d.utils.geometry.Box;

import javax.vecmath.Vector3f;


/*
 * 房子板子
*/
public class Group_HouseBoard implements Simple_Group{
	
	public TransformGroup group = new TransformGroup();
	public Transform3D t1 = new Transform3D();	
	public Box box;
	public Vector3f vec  ;
	
	public double degree ;

	public void setBoard(float xdim ,float ydim ,float zdim,float x,float y,float z,Appearance app){
		box  =  new Box(xdim,ydim,zdim,Box.GENERATE_TEXTURE_COORDS,app);
		vec  =  new Vector3f(x,y,z);
	}
	
	public void setBoard(double degree ,float xdim ,float ydim ,float zdim,float x,float y,float z,Appearance app){
		t1.rotZ(degree); //绕y轴旋转90度
		box  =  new Box(xdim,ydim,zdim,Box.GENERATE_TEXTURE_COORDS,app);
		vec  =  new Vector3f(x,y,z);
	}

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		// 生成基本的圆锥体
		TransformGroup group = new TransformGroup();
		t1.setTranslation(vec);

		group.setTransform(t1);	
		group.addChild(box);

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
