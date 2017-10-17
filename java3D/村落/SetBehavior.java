import javax.media.j3d.TransformGroup;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import javax.media.j3d.Behavior;
import javax.media.j3d.BoundingSphere;
import javax.vecmath.Point3d;

//�����¼�
public class SetBehavior{		
	
	public TransformGroup trans ;
	
	public SetBehavior(){}

	public SetBehavior(TransformGroup trans){
		this.trans = trans;
	}
	
	public void setTrans(TransformGroup trans){
		this.trans = trans;
	}

	public void setbehavior(){
		trans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		trans.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
		trans.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);	

		//��ת
		MouseRotate behavior = new MouseRotate();
		behavior.setTransformGroup(trans);
		trans.addChild(behavior);	
		behavior.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
		
		//�Ŵ���С
		MouseZoom behavior2 = new MouseZoom();
		behavior2.setTransformGroup(trans);
		trans.addChild(behavior2);
		behavior2.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
		
		//ƽ��
		MouseTranslate behavior3 = new MouseTranslate();	
		behavior3.setTransformGroup(trans);
		trans.addChild(behavior3);	
		behavior3.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
	}

	public void setbehavior(Behavior behavior){
		
	}

}
