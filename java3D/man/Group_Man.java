import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;

import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Switch;
	
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
	
/*	
 * 房子
*/	
public class Group_Man implements Simple_Group{
	
	public TransformGroup trans = new TransformGroup();
	public Switch switchgroup = new Switch();
	
	float a = 0.5f ; //标准头
	float b = 0.2f ; //标准小臂宽,
	float c = 0.6f; //标准小臂长
	
	float p_arm     = c*4/3	;			//大臂长
	float p_H_body  = c+p_arm;			//体长
	float p_W_body	= a*5/2;			//体宽
	
	float p_leg_joint = b*3/2		;		//腿臂关节
	float p_leg		  = p_arm*0.8f	;		//大腿长
	float p_Sleg	  = p_leg*0.8f	;		//小腿长
	
	
	int i = 0;

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		


		createEvent();		
				
		//身体
		Group_Body body = new Group_Body();
		body.setBody(a,p_W_body,p_H_body,null);
		TransformGroup group1_1 = body.createSceneGraph();
		
		//左臂
		Group_Joint joint_arm_left = new Group_Joint();
		joint_arm_left.setJoint(b,p_arm,2,null);
		TransformGroup group2_1 = joint_arm_left.createSceneGraph();
		
		Transform3D t_arm_left = new Transform3D();	
		t_arm_left.setTranslation(new Vector3f(-p_W_body-b,-a-b,0.0f));
		group2_1.setTransform(t_arm_left);		
		
		//左小臂
		Group_Joint joint_sarm_left = new Group_Joint();
		joint_sarm_left.setJoint(b,c,1,null);
		TransformGroup group2_2 = joint_sarm_left.createSceneGraph();
		
		Transform3D t_sarm_left = new Transform3D();	
		t_sarm_left.setTranslation(new Vector3f(-b*2,-p_arm*2,0.0f));
		group2_2.setTransform(t_sarm_left);
		
		group2_1.addChild(group2_2);
				
		//右臂
		Group_Joint joint_arm_right = new Group_Joint();
		joint_arm_right.setJoint(b,p_arm,3,null);
		TransformGroup group3_1 = joint_arm_right.createSceneGraph();
		
		Transform3D t1_arm_right = new Transform3D();	
		t1_arm_right.setTranslation(new Vector3f(p_W_body+b,-a-b,0.0f));
		group3_1.setTransform(t1_arm_right);		
		
		//右小臂
		Group_Joint joint_sarm_right = new Group_Joint();
		joint_sarm_right.setJoint(b,c,1,null);
		TransformGroup group3_2 = joint_sarm_right.createSceneGraph();
		
		Transform3D t_sarm_right = new Transform3D();	
		t_sarm_right.setTranslation(new Vector3f(b*2,-p_arm*2,0.0f));
		group3_2.setTransform(t_sarm_right);
		
		group3_1.addChild(group3_2);
		

		//右腿
		Group_Joint joint_leg_right = new Group_Joint();
		joint_leg_right.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_1 = joint_leg_right.createSceneGraph();
		
		Transform3D t_leg_right = new Transform3D();	
		t_leg_right.setTranslation(new Vector3f(p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group4_1.setTransform(t_leg_right);
		
		//右小腿
		Group_Joint joint_sleg_right = new Group_Joint();
		joint_sleg_right.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_2 = joint_sleg_right.createSceneGraph();
		
		Transform3D t_sleg_right = new Transform3D();	
		t_sleg_right.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group4_2.setTransform(t_sleg_right);
		
		group4_1.addChild(group4_2);


		//左腿
		Group_Joint joint_leg_left = new Group_Joint();
		joint_leg_left.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_1 = joint_leg_left.createSceneGraph();
		
		Transform3D t_leg_left = new Transform3D();	
		t_leg_left.setTranslation(new Vector3f(-p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group5_1.setTransform(t_leg_left);
		
		//左小腿
		Group_Joint joint_sleg_left = new Group_Joint();
		joint_sleg_left.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_2 = joint_sleg_left.createSceneGraph();
		
		Transform3D t_sleg_left = new Transform3D();	
		t_sleg_left.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group5_2.setTransform(t_sleg_left);
		
		group5_1.addChild(group5_2);
			
	
		
		//动作1
		//左臂
		Group_Joint joint_arm_left_1 = new Group_Joint();
		joint_arm_left_1.setJoint(b,p_arm,2,null);
		TransformGroup group2_1_1 = joint_arm_left_1.createSceneGraph();
		
		Transform3D t_arm_left_1 = new Transform3D();
		t_arm_left_1.rotX(Math.PI/9);
		t_arm_left_1.setTranslation(new Vector3f(-p_W_body-b,-a-b,0.0f));
		group2_1_1.setTransform(t_arm_left_1);		
		
		//左小臂
		Group_Joint joint_sarm_left_1 = new Group_Joint();
		joint_sarm_left_1.setJoint(b,c,1,null);
		TransformGroup group2_2_1 = joint_sarm_left_1.createSceneGraph();
		
		Transform3D t_sarm_left_1 = new Transform3D();
		t_sarm_left_1.rotX(-Math.PI/9);
		t_sarm_left_1.setTranslation(new Vector3f(-b*2,-p_arm*2,0.0f));
		group2_2_1.setTransform(t_sarm_left_1);
		
		group2_1_1.addChild(group2_2_1);

					
		//右臂
		Group_Joint joint_arm_right_1 = new Group_Joint();
		joint_arm_right_1.setJoint(b,p_arm,3,null);
		TransformGroup group3_1_1 = joint_arm_right_1.createSceneGraph();
		
		Transform3D t1_arm_right_1 = new Transform3D();
		t1_arm_right_1.rotX(-Math.PI/9);
		t1_arm_right_1.setTranslation(new Vector3f(p_W_body+b,-a-b,0.0f));
		group3_1_1.setTransform(t1_arm_right_1);		
		
		//右小臂
		Group_Joint joint_sarm_right_1 = new Group_Joint();
		joint_sarm_right_1.setJoint(b,c,1,null);
		TransformGroup group3_2_1 = joint_sarm_right_1.createSceneGraph();
		
		Transform3D t_sarm_right_1 = new Transform3D();	
		t_sarm_right_1.setTranslation(new Vector3f(b*2,-p_arm*2,0.0f));
		group3_2_1.setTransform(t_sarm_right_1);
		
		group3_1_1.addChild(group3_2_1);
	
		//右腿
		Group_Joint joint_leg_right_1 = new Group_Joint();
		joint_leg_right_1.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_1_1 = joint_leg_right_1.createSceneGraph();
		
		Transform3D t_leg_right_1 = new Transform3D();
		t_leg_right_1.rotX(Math.PI/9);
		t_leg_right_1.setTranslation(new Vector3f(p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group4_1_1.setTransform(t_leg_right_1);
		
		//右小腿
		Group_Joint joint_sleg_right_1 = new Group_Joint();
		joint_sleg_right_1.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_2_1 = joint_sleg_right_1.createSceneGraph();
		
		Transform3D t_sleg_right_1 = new Transform3D();
		t_sleg_right_1.rotX(Math.PI/9);
		t_sleg_right_1.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group4_2_1.setTransform(t_sleg_right_1);
		
		group4_1_1.addChild(group4_2_1);


		//左腿
		Group_Joint joint_leg_left_1 = new Group_Joint();
		joint_leg_left_1.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_1_1 = joint_leg_left_1.createSceneGraph();
		
		Transform3D t_leg_left_1 = new Transform3D();
		t_leg_left_1.rotX(-Math.PI/9);
		t_leg_left_1.setTranslation(new Vector3f(-p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group5_1_1.setTransform(t_leg_left_1);
		
		//左小腿
		Group_Joint joint_sleg_left_1 = new Group_Joint();
		joint_sleg_left_1.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_2_1 = joint_sleg_left_1.createSceneGraph();
		
		Transform3D t_sleg_left_1 = new Transform3D();
		t_sleg_left_1.rotX(Math.PI/9);
		t_sleg_left_1.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group5_2_1.setTransform(t_sleg_left_1);
		
		group5_1_1.addChild(group5_2_1);

		
		//动作2
		//左臂
		Group_Joint joint_arm_left_2 = new Group_Joint();
		joint_arm_left_2.setJoint(b,p_arm,2,null);
		TransformGroup group2_1_2 = joint_arm_left_2.createSceneGraph();
		
		Transform3D t_arm_left_2 = new Transform3D();
		t_arm_left_2.rotX(Math.PI/6);
		t_arm_left_2.setTranslation(new Vector3f(-p_W_body-b,-a-b,0.0f));
		group2_1_2.setTransform(t_arm_left_2);		
		
		//左小臂
		Group_Joint joint_sarm_left_2 = new Group_Joint();
		joint_sarm_left_2.setJoint(b,c,1,null);
		TransformGroup group2_2_2 = joint_sarm_left_2.createSceneGraph();
		
		Transform3D t_sarm_left_2 = new Transform3D();
		t_sarm_left_2.setTranslation(new Vector3f(-b*2,-p_arm*2,0.0f));
		group2_2_2.setTransform(t_sarm_left_2);
		
		group2_1_2.addChild(group2_2_2);

					
		//右臂
		Group_Joint joint_arm_right_2 = new Group_Joint();
		joint_arm_right_2.setJoint(b,p_arm,3,null);
		TransformGroup group3_1_2 = joint_arm_right_2.createSceneGraph();
		
		Transform3D t1_arm_right_2 = new Transform3D();
		t1_arm_right_2.rotX(-Math.PI/6);
		t1_arm_right_2.setTranslation(new Vector3f(p_W_body+b,-a-b,0.0f));
		group3_1_2.setTransform(t1_arm_right_2);		
		
		//右小臂
		Group_Joint joint_sarm_right_2 = new Group_Joint();
		joint_sarm_right_2.setJoint(b,c,1,null);
		TransformGroup group3_2_2 = joint_sarm_right_2.createSceneGraph();
		
		Transform3D t_sarm_right_2 = new Transform3D();
		t_sarm_right_2.rotX(-Math.PI/9);
		t_sarm_right_2.setTranslation(new Vector3f(b*2,-p_arm*2,0.0f));
		group3_2_2.setTransform(t_sarm_right_2);
		
		group3_1_2.addChild(group3_2_2);
	
		//右腿
		Group_Joint joint_leg_right_2 = new Group_Joint();
		joint_leg_right_2.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_1_2 = joint_leg_right_2.createSceneGraph();
		
		Transform3D t_leg_right_2 = new Transform3D();
		t_leg_right_2.rotX(Math.PI/6);
		t_leg_right_2.setTranslation(new Vector3f(p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group4_1_2.setTransform(t_leg_right_2);
		
		//右小腿
		Group_Joint joint_sleg_right_2 = new Group_Joint();
		joint_sleg_right_2.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_2_2 = joint_sleg_right_2.createSceneGraph();
		
		Transform3D t_sleg_right_2 = new Transform3D();
		t_sleg_right_2.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group4_2_2.setTransform(t_sleg_right_2);
		
		group4_1_2.addChild(group4_2_2);


		//左腿
		Group_Joint joint_leg_left_2 = new Group_Joint();
		joint_leg_left_2.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_1_2 = joint_leg_left_2.createSceneGraph();
		
		Transform3D t_leg_left_2 = new Transform3D();
		t_leg_left_2.rotX(-Math.PI/6);
		t_leg_left_2.setTranslation(new Vector3f(-p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group5_1_2.setTransform(t_leg_left_2);
		
		//左小腿
		Group_Joint joint_sleg_left_2 = new Group_Joint();
		joint_sleg_left_2.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_2_2 = joint_sleg_left_2.createSceneGraph();
		
		Transform3D t_sleg_left_2 = new Transform3D();
		t_sleg_left_2.rotX(Math.PI/6);
		t_sleg_left_2.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group5_2_2.setTransform(t_sleg_left_2);
		
		group5_1_2.addChild(group5_2_2);

		
		//动作3
		//左臂
		Group_Joint joint_arm_left_3 = new Group_Joint();
		joint_arm_left_3.setJoint(b,p_arm,2,null);
		TransformGroup group2_1_3 = joint_arm_left_3.createSceneGraph();		
		Transform3D t_arm_left_3 = new Transform3D();
		t_arm_left_3.rotX(-Math.PI/9);			
		t_arm_left_3.setTranslation(new Vector3f(-p_W_body-b,-a-b,0.0f));
		group2_1_3.setTransform(t_arm_left_3);		
		
		//左小臂
		Group_Joint joint_sarm_left_3 = new Group_Joint();
		joint_sarm_left_3.setJoint(b,c,1,null);
		TransformGroup group2_2_3 = joint_sarm_left_3.createSceneGraph();		
		Transform3D t_sarm_left_3 = new Transform3D();		
		t_sarm_left_3.setTranslation(new Vector3f(-b*2,-p_arm*2,0.0f));
		group2_2_3.setTransform(t_sarm_left_3);		
		
		group2_1_3.addChild(group2_2_3);

					
		//右臂
		Group_Joint joint_arm_right_3 = new Group_Joint();
		joint_arm_right_3.setJoint(b,p_arm,3,null);
		TransformGroup group3_1_3 = joint_arm_right_3.createSceneGraph();
		Transform3D t1_arm_right_3 = new Transform3D();
		t1_arm_right_3.rotX(Math.PI/9);				
		t1_arm_right_3.setTranslation(new Vector3f(p_W_body+b,-a-b,0.0f));
		group3_1_3.setTransform(t1_arm_right_3);		
		
		//右小臂
		Group_Joint joint_sarm_right_3 = new Group_Joint();
		joint_sarm_right_3.setJoint(b,c,1,null);
		TransformGroup group3_2_3 = joint_sarm_right_3.createSceneGraph();	
		Transform3D t_sarm_right_3 = new Transform3D();	
		t_sarm_right_3.rotX(-Math.PI/9);
		t_sarm_right_3.setTranslation(new Vector3f(b*2,-p_arm*2,0.0f));
		group3_2_3.setTransform(t_sarm_right_3);		
		group3_1_3.addChild(group3_2_3);
	
		//右腿
		Group_Joint joint_leg_right_3 = new Group_Joint();
		joint_leg_right_3.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_1_3 = joint_leg_right_3.createSceneGraph();		
		Transform3D t_leg_right_3 = new Transform3D();
		t_leg_right_3.rotX(-Math.PI/9);		
		t_leg_right_3.setTranslation(new Vector3f(p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group4_1_3.setTransform(t_leg_right_3);
		
		//右小腿
		Group_Joint joint_sleg_right_3 = new Group_Joint();
		joint_sleg_right_3.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_2_3 = joint_sleg_right_3.createSceneGraph();		
		Transform3D t_sleg_right_3 = new Transform3D();
		t_sleg_right_3.rotX(Math.PI/9);
		t_sleg_right_3.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group4_2_3.setTransform(t_sleg_right_3);		
		group4_1_3.addChild(group4_2_3);


		//左腿
		Group_Joint joint_leg_left_3 = new Group_Joint();
		joint_leg_left_3.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_1_3 = joint_leg_left_3.createSceneGraph();		
		Transform3D t_leg_left_3 = new Transform3D();	
		t_leg_left_3.rotX(Math.PI/9);		
		t_leg_left_3.setTranslation(new Vector3f(-p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group5_1_3.setTransform(t_leg_left_3);
		
		//左小腿
		Group_Joint joint_sleg_left_3 = new Group_Joint();
		joint_sleg_left_3.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_2_3 = joint_sleg_left_3.createSceneGraph();		
		Transform3D t_sleg_left_3 = new Transform3D();
		t_sleg_left_3.rotX(Math.PI/9);		
		t_sleg_left_3.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group5_2_3.setTransform(t_sleg_left_3);
		
		group5_1_3.addChild(group5_2_3);


		//动作4
		//左臂
		Group_Joint joint_arm_left_4 = new Group_Joint();
		joint_arm_left_4.setJoint(b,p_arm,2,null);
		TransformGroup group2_1_4 = joint_arm_left_4.createSceneGraph();		
		Transform3D t_arm_left_4 = new Transform3D();		
		t_arm_left_4.rotX(-Math.PI/6);
		t_arm_left_4.setTranslation(new Vector3f(-p_W_body-b,-a-b,0.0f));
		group2_1_4.setTransform(t_arm_left_4);		
		
		//左小臂
		Group_Joint joint_sarm_left_4 = new Group_Joint();
		joint_sarm_left_4.setJoint(b,c,1,null);
		TransformGroup group2_2_4 = joint_sarm_left_4.createSceneGraph();		
		Transform3D t_sarm_left_4 = new Transform3D();
		t_sarm_left_4.rotX(-Math.PI/9);
		t_sarm_left_4.setTranslation(new Vector3f(-b*2,-p_arm*2,0.0f));
		group2_2_4.setTransform(t_sarm_left_4);		
		group2_1_4.addChild(group2_2_4);

					
		//右臂
		Group_Joint joint_arm_right_4 = new Group_Joint();
		joint_arm_right_4.setJoint(b,p_arm,3,null);
		TransformGroup group3_1_4 = joint_arm_right_4.createSceneGraph();		
		Transform3D t1_arm_right_4 = new Transform3D();
		t1_arm_right_4.rotX(Math.PI/6);
		t1_arm_right_4.setTranslation(new Vector3f(p_W_body+b,-a-b,0.0f));
		group3_1_4.setTransform(t1_arm_right_4);		
		
		//右小臂
		Group_Joint joint_sarm_right_4 = new Group_Joint();
		joint_sarm_right_4.setJoint(b,c,1,null);
		TransformGroup group3_2_4 = joint_sarm_right_4.createSceneGraph();		
		Transform3D t_sarm_right_4 = new Transform3D();
		t_sarm_right_4.setTranslation(new Vector3f(b*2,-p_arm*2,0.0f));
		group3_2_4.setTransform(t_sarm_right_4);		
		group3_1_4.addChild(group3_2_4);
	
		//右腿
		Group_Joint joint_leg_right_4 = new Group_Joint();
		joint_leg_right_4.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_1_4 = joint_leg_right_4.createSceneGraph();		
		Transform3D t_leg_right_4 = new Transform3D();
		t_leg_right_4.rotX(-Math.PI/6);		
		t_leg_right_4.setTranslation(new Vector3f(p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group4_1_4.setTransform(t_leg_right_4);
		
		//右小腿
		Group_Joint joint_sleg_right_4 = new Group_Joint();
		joint_sleg_right_4.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group4_2_4 = joint_sleg_right_4.createSceneGraph();		
		Transform3D t_sleg_right_4 = new Transform3D();
		t_sleg_right_4.rotX(Math.PI/6);		
		t_sleg_right_4.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));	
		group4_2_4.setTransform(t_sleg_right_4);
		
		group4_1_4.addChild(group4_2_4);


		//左腿
		Group_Joint joint_leg_left_4 = new Group_Joint();
		joint_leg_left_4.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_1_4 = joint_leg_left_4.createSceneGraph();
		
		Transform3D t_leg_left_4 = new Transform3D();
		t_leg_left_4.rotX(Math.PI/6);
		t_leg_left_4.setTranslation(new Vector3f(-p_W_body/2,-p_H_body*2-p_leg_joint*3,0.0f));
		group5_1_4.setTransform(t_leg_left_4);
		
		//左小腿
		Group_Joint joint_sleg_left_4 = new Group_Joint();
		joint_sleg_left_4.setJoint(p_leg_joint,p_leg,1,null);
		TransformGroup group5_2_4 = joint_sleg_left_4.createSceneGraph();		
		Transform3D t_sleg_left_4 = new Transform3D();
		t_sleg_left_4.setTranslation(new Vector3f(0.0f,-p_leg*2-p_leg_joint*2,0.0f));
		group5_2_4.setTransform(t_sleg_left_4);
		
		group5_1_4.addChild(group5_2_4);

		trans.addChild(group1_1);
/*
		trans.addChild(group2_1);		
		trans.addChild(group3_1);
		trans.addChild(group4_1);
		trans.addChild(group5_1);

		trans.addChild(group2_1_1);
		trans.addChild(group3_1_1);
		trans.addChild(group4_1_1);
		trans.addChild(group5_1_1);

		trans.addChild(group2_1_2);
		trans.addChild(group3_1_2);
		trans.addChild(group4_1_2);
		trans.addChild(group5_1_2);

		trans.addChild(group2_1_3);
		trans.addChild(group3_1_3);
		trans.addChild(group4_1_3);
		trans.addChild(group5_1_3);

		trans.addChild(group2_1_4);
		trans.addChild(group3_1_4);
		trans.addChild(group4_1_4);
		trans.addChild(group5_1_4);
*/

		
		TransformGroup trans1 = new TransformGroup();
		TransformGroup trans2 = new TransformGroup();
		TransformGroup trans3 = new TransformGroup();
		TransformGroup trans4 = new TransformGroup();
		TransformGroup trans5 = new TransformGroup();

		trans1.addChild(group2_1);
		trans1.addChild(group3_1);
		trans1.addChild(group4_1);
		trans1.addChild(group5_1);


		trans2.addChild(group2_1_1);
		trans2.addChild(group3_1_1);
		trans2.addChild(group4_1_1);
		trans2.addChild(group5_1_1);

		trans3.addChild(group2_1_2);
		trans3.addChild(group3_1_2);
		trans3.addChild(group4_1_2);
		trans3.addChild(group5_1_2);

		trans4.addChild(group2_1_3);
		trans4.addChild(group3_1_3);
		trans4.addChild(group4_1_3);
		trans4.addChild(group5_1_3);

		trans5.addChild(group2_1_4);
		trans5.addChild(group3_1_4);
		trans5.addChild(group4_1_4);
		trans5.addChild(group5_1_4);
		
		switchgroup.addChild(trans1);
		switchgroup.addChild(trans2);
		switchgroup.addChild(trans3);
		switchgroup.addChild(trans4);
		switchgroup.addChild(trans5);

		
		switchgroup.setCapability(Switch.ALLOW_SWITCH_WRITE); 
	
		timer(switchgroup);

		trans.addChild(switchgroup); 
		

		return trans ;	
	}	
	
	
	//设置自身事件
	@Override
	public void createEvent(){
	
		trans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		trans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
	
		MouseRotate behavior = new MouseRotate();
		behavior.setTransformGroup(trans);
		trans.addChild(behavior);	
		behavior.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
		
		MouseZoom behavior2 = new MouseZoom();
		behavior2.setTransformGroup(trans);
		trans.addChild(behavior2);
		behavior2.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
	
		MouseTranslate behavior3 = new MouseTranslate();	
		behavior3.setTransformGroup(trans);
		trans.addChild(behavior3);	
		behavior3.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),100));
	}
	
	//创建外观设置
	public Appearance createApp(){
		return null;
	}

	public void timer(Switch s){
		
		Timer timer1 = new Timer();
		
		timer1.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				i ++ ;
				if(i%8 == 0){
					s.setWhichChild(0);
				}else if(i%8 == 1){
					s.setWhichChild(1);
				}else if(i%8 == 2){
					s.setWhichChild(2);
				}else if(i%8 == 3){
					s.setWhichChild(1);
				}else if(i%8 == 4){
					s.setWhichChild(0);
				}else if(i%8 == 5){
					s.setWhichChild(3);
				}else if(i%8 == 6){
					s.setWhichChild(4);
				}else if(i%8 == 7){
					s.setWhichChild(3);
				}
			}
		},100,200);

	}
	
}	
	