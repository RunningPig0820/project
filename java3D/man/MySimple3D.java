import java.applet.Applet;
import java.awt.BorderLayout;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.GraphicsConfiguration;

public class MySimple3D implements Simple_Scene{
	
	//��������
	@Override
	public BranchGroup create(){
		//���ڵ�
		BranchGroup objRoot = new BranchGroup();
		
		//�������緶Χ
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),100);
		
		//����ɫ
		Color3f bgColor = new Color3f(0.0f,0.0f,0.0f);
		Background bg = new Background(bgColor);
		bg.setApplicationBounds(bounds);
		objRoot.addChild(bg);
		
		//�ƹ�
		Color3f directionalColor= new Color3f(1.0f,1.0f,1.0f);
		Vector3f vec = new Vector3f(0.0f,0.0f,-1.0f);
		DirectionalLight directionalLight = new DirectionalLight(directionalColor,vec);
		directionalLight.setInfluencingBounds(bounds);
		objRoot.addChild(directionalLight);
		
	
		//����
		Simple_Group man = new Group_Man();
		TransformGroup group = man.createSceneGraph();
		
		objRoot.addChild(group);
		objRoot.compile();
		
		return objRoot;
	}
	

}