import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Shape3D;
import javax.media.j3d.FontExtrusion;
import javax.media.j3d.Font3D;
import javax.media.j3d.Text3D;
import javax.media.j3d.BoundingSphere;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;

import javax.vecmath.Vector3f;

import java.awt.Font;


/*
 * 房子
*/
public class Group_Font implements Simple_Group{
	
	public TransformGroup trans = new TransformGroup();
	Shape3D shape = new Shape3D();
	
	String string;
	Vector3f vector ;

	public Group_Font(String string,Vector3f vector){
		this.string = string;
		this.vector = vector;
	}

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){	

		Font3D font = new Font3D(new Font("SansSerif",Font.PLAIN,1),new FontExtrusion());
		Text3D text = new Text3D(font,string);		

		//关联点集到几何体
		shape.setGeometry(text);
		shape.setAppearance(createApp());


		Transform3D t = new Transform3D();
		t.setTranslation(vector);
		trans.setTransform(t);
		trans.addChild(shape);

		return trans;
	}	
	

	//设置自身事件
	@Override
	public void createEvent(){
	}

	//创建外观设置
	public Appearance createApp(){
		Appearance app= new Appearance();
		
		Material m= new Material();
		m.setDiffuseColor(new Color3f(1.0f,1.0f,0.0f));
		app.setMaterial(m);	

		return app;
	}

}


	