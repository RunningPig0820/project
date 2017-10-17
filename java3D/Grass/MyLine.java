import java.applet.Applet;
import java.awt.BorderLayout;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.GraphicsConfiguration;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate ;

public class MyLine extends Applet{
	
	private BranchGroup createSceneGraph(){
		BranchGroup objRoot = new BranchGroup();

		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),100);

		Shape3D shape = new Bezier1();
		
		TransformGroup transformgroup = new TransformGroup();
		transformgroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		transformgroup.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
		transformgroup.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);	

		MouseRotate mouserotate = new MouseRotate();
		mouserotate.setTransformGroup(transformgroup);		
		mouserotate.setSchedulingBounds(bounds);
		transformgroup.addChild(shape);

		objRoot.addChild(transformgroup);
		objRoot.addChild(mouserotate);
		 
	//	objRoot.addChild(shape);
		objRoot.compile();
		return objRoot;

	}

	public MyLine(){
		setLayout(new BorderLayout());
		GraphicsConfiguration config=SimpleUniverse.getPreferredConfiguration();  
		Canvas3D c = new Canvas3D(config); 
		add("Center",c);
		BranchGroup scene  = createSceneGraph();
		SimpleUniverse u = new SimpleUniverse(c);
		u.getViewingPlatform().setNominalViewingTransform();
		u.addBranchGraph(scene);
	}
	public static void main(String[] args){
		new MainFrame(new MyLine(),400,300);
	}
}