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
 * ��������
*/
public class Group_Joint implements Simple_Group,Serializable{
	
	public TransformGroup group = new TransformGroup();
	public Vector3f vec  ;
	public Sphere sphere ;
	public Box box		 ;
	
	float a ;
	float b ;
	int c ;

	/*
	 *  @parn a:�ؽڰ뾶/�ۿ� b:�ȳ� c:����  1.�� 2.�ֱ�
	 *  @parn x:λ��X y:λ��Y z:λ��Z app:�������
	*/
	public void setJoint(float a,float b,int c,Appearance app){
		
		sphere = new Sphere(a);
		box  =  new Box(a,b,a,Box.GENERATE_TEXTURE_COORDS,app);

		if(c == 1){			
			vec  = new Vector3f(0.0f,-a-b,0.0f);
		}else if(c == 2){
			vec  = new Vector3f(-a*2,a-b,0.0f);
		}else if(c == 3){
			vec  = new Vector3f(a*2,a-b,0.0f);
		}

	}

	//����ת���ڵ�
	@Override
	public TransformGroup createSceneGraph(){
		// ���ɻ�����Բ׶��		
		TransformGroup group1 = new TransformGroup();
		Transform3D t1 = new Transform3D();	
		t1.setTranslation(vec);
		group1.setTransform(t1);
		group1.addChild(box);		
		
		group.addChild(sphere);
		group.addChild(group1);

		return group ;
	}	
	
	
	//���������¼�
	@Override
	public void createEvent(){
	}

	//�����������
	@Override
	public Appearance createApp(){
		Appearance app = new Appearance();
		return app;
	}

}


	