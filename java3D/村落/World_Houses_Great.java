import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.Link;
import javax.vecmath.Vector3f;
import javax.media.j3d.SharedGroup;
//大规模的重复构建
//每个TransformGroup只有一个SharedGroup对象


public class World_Houses_Great implements Simple_Group{
	
	Client client;
	SharedGroup sharedgroup;
	TransformGroup trans = new TransformGroup();

	public World_Houses_Great(){}
	
	public World_Houses_Great(Client client){
		this.client = client;
	}
	
	public void setclient(Client client){
		this.client = client;		
	}
	
	//创建转化节点
	public TransformGroup createSceneGraph(){
		client.send("2");
		Bean bean11 = client.getBean(1);
		System.out.println("bean11" + bean11);		

		//房子
		Simple_Group house11 = bean11.getSimple_Group();
		TransformGroup group1 = house11.createSceneGraph();
		
		sharedgroup = new SharedGroup();
		sharedgroup.addChild(group1);
		
		gethouses();

		return trans;

	}	
	
	//设置自身事件
	public void createEvent(){}
	
	//创建外观设置
	public Appearance createApp(){
		return null;
	}

	public void gethouses(){
			
		Transform3D t1 = new Transform3D();
		
		for(int i = 0 ; i < 9; i++){
			for(int j = 0 ; j < 9 ; j++){
				t1.setTranslation(new Vector3f(0f+2*i,0.0f,-12.0f+j*3));
				TransformGroup transform1 = new TransformGroup();
				transform1.setTransform(t1);
				transform1.setTransform(t1);
				transform1.addChild(new Link(sharedgroup));
				trans.addChild(transform1);	
			}	
		}

	}

}