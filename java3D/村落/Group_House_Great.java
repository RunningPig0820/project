import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.QuadArray;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;


import java.io.Serializable;


/*
 * 房子
*/
public class Group_House_Great implements Simple_Group,Serializable{
	
	public TransformGroup trans = new TransformGroup();

	//创建转化节点
	@Override
	public TransformGroup createSceneGraph(){
		
		createEvent();
		Appearance app = createApp();
		
		//墙		
		Group_HouseWall_Great Wall1 = new Group_HouseWall_Great();
		TransformGroup group1 = Wall1.createSceneGraph();
		
		Group_HouseWall_Great Wall2 = new Group_HouseWall_Great();
		TransformGroup group2 = Wall2.createSceneGraph();

		Group_HouseWall_Great Wall3 = new Group_HouseWall_Great();
		TransformGroup group3 = Wall3.createSceneGraph();

		Group_HouseWall_Great Wall4 = new Group_HouseWall_Great();
		TransformGroup group4 = Wall4.createSceneGraph();

		Group_HouseWall_Great Wall5 = new Group_HouseWall_Great();
		TransformGroup group5 = Wall5.createSceneGraph();

		Group_HouseWall_Great Wall6 = new Group_HouseWall_Great();
		TransformGroup group6 = Wall6.createSceneGraph();
		
		Group_HouseWall_Great Wall7 = new Group_HouseWall_Great();
		TransformGroup group7 = Wall7.createSceneGraph();

		Group_HouseWall_Great Wall8 = new Group_HouseWall_Great();
		TransformGroup group8 = Wall8.createSceneGraph();

		Transform3D t1 = new Transform3D();
		t1.setTranslation(new Vector3f(0.4f,0.0f,-0.3f));
		group1.setTransform(t1);
		
		Transform3D t2 = new Transform3D();
		t2.setTranslation(new Vector3f(-0.4f,0.0f,-0.3f));
		group2.setTransform(t2);

		Transform3D t3 = new Transform3D();
		t3.setTranslation(new Vector3f(0.4f,0.0f,0.3f));
		group3.setTransform(t3);

		Transform3D t4 = new Transform3D();
		t4.setTranslation(new Vector3f(-0.4f,0.0f,0.3f));
		group4.setTransform(t4);


		Transform3D t5 = new Transform3D();	
		//绕y轴旋转180度
		t5.rotY(Math.PI);
		t5.setTranslation(new Vector3f(0.4f,0.0f,-0.3f));
		group5.setTransform(t5);

		Transform3D t6 = new Transform3D();
		//绕y轴旋转180度
		t6.rotY(Math.PI);
		t6.setTranslation(new Vector3f(-0.4f,0.0f,-0.3f));
		group6.setTransform(t6);

		Transform3D t7 = new Transform3D();
		//绕y轴旋转180度
		t7.rotY(Math.PI);
		t7.setTranslation(new Vector3f(0.4f,0.0f,0.3f));
		group7.setTransform(t7);

		Transform3D t8 = new Transform3D();
		//绕y轴旋转180度
		t8.rotY(Math.PI);
		t8.setTranslation(new Vector3f(-0.4f,0.0f,0.3f));
		group8.setTransform(t8);
		

		Group_HouseRoof_Great Roof1 = new Group_HouseRoof_Great();
		TransformGroup group9 = Roof1.createSceneGraph();
		
		Group_HouseWall2_Great Wall21 = new Group_HouseWall2_Great();
		TransformGroup group10 = Wall21.createSceneGraph();

		trans.addChild(group1);
		trans.addChild(group2);
		trans.addChild(group3);
		trans.addChild(group4);
		
		trans.addChild(group5);
		trans.addChild(group6);
		trans.addChild(group7);
		trans.addChild(group8);
		
		trans.addChild(group9);
		
		trans.addChild(group10);


		return trans ;
	}	
	
	
	//设置自身事件
	@Override
	public void createEvent(){
	}

	//创建外观设置
	public Appearance createApp(){
		Appearance app = new Appearance();
		
		Material material= new Material();
		// 为物体添加材质
		material.setDiffuseColor(new Color3f(1.0f,1.0f,0.0f));
		// 设置辐射光效果
		app.setMaterial(material);

		return app;

	}

}


	