import javax.vecmath.Point3d;
import javax.vecmath.Color3f;

import javax.media.j3d.Background;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.BoundingSphere;

public class MySimple3D implements Simple_Scene{
	
	//���ڵ�
	BranchGroup objRoot = new BranchGroup();

	//��������
	@Override
	public BranchGroup create(){
		
		
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

		
		Client client = new Client();

		SetBehavior behavior = new SetBehavior();

		Simple_Group coordinate = new World_Coordinate();
		TransformGroup group = coordinate.createSceneGraph();
		behavior.setTrans(group);
		behavior.setbehavior();
		
		World_Houses houses = new World_Houses();
		houses.setclient(client);
		TransformGroup group1 = houses.createSceneGraph();
		behavior.setTrans(group1);
		behavior.setbehavior();
		
		World_Houses_Great houses_great = new World_Houses_Great();
		houses_great.setclient(client);
		TransformGroup group2 = houses_great.createSceneGraph();
		behavior.setTrans(group2);
		behavior.setbehavior();
		
		objRoot.addChild(group);
		objRoot.addChild(group1);
		objRoot.addChild(group2);
		objRoot.compile();
		
		return objRoot;
	}
	
	

}