import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.Texture2D;

import com.sun.j3d.utils.geometry.Cylinder;

import javax.vecmath.Vector3f;


/*
 * 房子柱子
*/
public class Group_HousePillar implements Simple_Group{
	
	public TransformGroup group = new TransformGroup();
	public Transform3D t1 = new Transform3D();	
	public Cylinder cone ;
	public Vector3f vec  ;
	
	int	  rot	 ;
	double degree ;

	public void setpillar(float width ,float height ,float x,float y,float z,Appearance app){
		cone =  new Cylinder(width,height,Cylinder.GENERATE_TEXTURE_COORDS|Cylinder.GENERATE_NORMALS,app);
		vec  = new Vector3f(x,y,z);
	}
	

	public void setpillar(int rot,double degree,float width ,float height ,float x,float y,float z,Appearance app){
		
		if(rot == 1){
			t1.rotZ(Math.PI/2); //绕y轴旋转90度
		}else if(rot == 2){
			t1.rotX(Math.PI/2); //绕x轴旋转90度
		}

		cone =  new Cylinder(width,height,Cylinder.GENERATE_TEXTURE_COORDS|Cylinder.GENERATE_NORMALS,app);
		vec  = new Vector3f(x,y,z);
	}

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		// 生成基本的圆锥体
		TransformGroup group = new TransformGroup();		
		t1.setTranslation(vec);			
		group.setTransform(t1);				
		group.addChild(cone);
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


	