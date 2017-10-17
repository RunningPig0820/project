//package Java3D;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.applet.MainFrame;


public class Main_Frame extends Applet {

	public Main_Frame(){
		
		setLayout(new BorderLayout());
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();  
		Canvas3D c = new Canvas3D(config); 
		add("Center",c);
	
		long starttime=System.currentTimeMillis();
		Simple_Scene simple = new MySimple3D();
		BranchGroup scene = simple.create();
		long endtime=System.currentTimeMillis();
		System.out.println(endtime-starttime);
		
		SimpleUniverse u = new SimpleUniverse(c);
		u.getViewingPlatform().setNominalViewingTransform();
		u.addBranchGraph(scene);
	} 

	public static void main(String[] args){ 
		new MainFrame(new Main_Frame(),400,300);
	}
}