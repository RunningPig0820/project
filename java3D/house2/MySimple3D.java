import javax.vecmath.Point3d;
import javax.vecmath.Color3f;

import javax.media.j3d.Background;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.TransformGroup;


public class MySimple3D implements Simple_Scene{
	
	//��������
	@Override
	public BranchGroup create(){
		//���ڵ�
		BranchGroup objRoot = new BranchGroup();
		
		//�������緶Χ
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),100);
		
		//����ɫ
		Color3f bgColor = new Color3f(1.0f,1.0f,1.0f);
		Background bg = new Background(bgColor);
		bg.setApplicationBounds(bounds);
		objRoot.addChild(bg);
/*		
		//�ƹ�
		Color3f directionalColor= new Color3f(1.0f,1.0f,1.0f);
		Vector3f vec = new Vector3f(0.0f,0.0f,-1.0f);
		DirectionalLight directionalLight = new DirectionalLight(directionalColor,vec);
		directionalLight.setInfluencingBounds(bounds);
		objRoot.addChild(directionalLight);
*/		

		//����
		Simple_Group house = new Group_House();
		TransformGroup group = house.createSceneGraph();
		

		objRoot.addChild(group);
		objRoot.compile();
		
		return objRoot;
	}
	

}