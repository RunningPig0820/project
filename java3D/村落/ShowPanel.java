import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.Viewer;
import javax.vecmath.Vector3d;
import javax.media.j3d.Transform3D;
import com.sun.j3d.utils.universe.ViewingPlatform;

public class ShowPanel{
	
	Canvas3D c ;

	public Canvas3D returnCanvas(){
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();  
		c = new Canvas3D(config); 

		long starttime=System.currentTimeMillis();
		Simple_Scene simple = new MySimple3D();
		BranchGroup scene = simple.create();
		long endtime=System.currentTimeMillis();
		System.out.println(endtime-starttime);

		Viewer viewer = new Viewer(c);
		Vector3d viewpoint = new Vector3d(0.0,0.0,15.0);   
		//初始观察点位置
		Transform3D t = new Transform3D();
		t.set(viewpoint);
		ViewingPlatform v = new ViewingPlatform();
		v.getViewPlatformTransform().setTransform(t);
		
		SimpleUniverse u = new SimpleUniverse(v,viewer);
		
		u.addBranchGraph(scene);

		
		return c;

	} 
}