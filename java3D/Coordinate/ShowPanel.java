import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.applet.MainFrame;

public class ShowPanel{
	
	Canvas3D c ;

	public Canvas3D returnCanvas(){
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();  
		c = new Canvas3D(config); 

		Simple_Scene simple = new MySimple3D();
		BranchGroup scene = simple.create();
		
		SimpleUniverse u = new SimpleUniverse(c);
		u.getViewingPlatform().setNominalViewingTransform();
		u.addBranchGraph(scene);
		
		return c;

	} 
}