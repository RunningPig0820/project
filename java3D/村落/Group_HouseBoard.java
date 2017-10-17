import javax.media.j3d.Appearance;
import javax.media.j3d.Texture2D;

import com.sun.j3d.utils.geometry.Box;

import javax.vecmath.Vector3f;

import java.io.Serializable;

/*
 * ���Ӱ���
*/
public class Group_HouseBoard implements Simple_Group,Serializable{
	
	public TransformGroup group = new TransformGroup();
	public Transform3D t1 = new Transform3D();	
	public Box box;
	public Vector3f vec  ;
	
	public int	  rot	 ;
	public double degree ;

	public void setBoard(float xdim ,float ydim ,float zdim,float x,float y,float z,Appearance app){
		box  =  new Box(xdim,ydim,zdim,Box.GENERATE_TEXTURE_COORDS,app);
		vec  =  new Vector3f(x,y,z);
	}
	

	//����ת���ڵ�
	@Override
	public TransformGroup createSceneGraph(){
		// ���ɻ�����Բ׶��
		TransformGroup group = new TransformGroup();
		t1.setTranslation(vec);

		group.setTransform(t1);	
		group.addChild(box);

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
