import java.applet.Applet;
import java.awt.BorderLayout;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.GraphicsConfiguration;

public class MySimple3D implements Simple_Scene{
	
	//创建世界
	@Override
	public BranchGroup create(){
		//根节点
		BranchGroup objRoot = new BranchGroup();
		
		//虚拟世界范围
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),100);
		
		//背景色
		Color3f bgColor = new Color3f(0.0f,0.0f,0.0f);
		Background bg = new Background(bgColor);
		bg.setApplicationBounds(bounds);
		objRoot.addChild(bg);
		
		//灯光
		Color3f directionalColor= new Color3f(1.0f,1.0f,1.0f);
		Vector3f vec = new Vector3f(0.0f,0.0f,-1.0f);
		DirectionalLight directionalLight = new DirectionalLight(directionalColor,vec);
		directionalLight.setInfluencingBounds(bounds);
		objRoot.addChild(directionalLight);
		
	
		//房子
		Simple_Group man = new Group_Man();
		TransformGroup group = man.createSceneGraph();
		
		objRoot.addChild(group);
		objRoot.compile();
		
		return objRoot;
	}
	

}