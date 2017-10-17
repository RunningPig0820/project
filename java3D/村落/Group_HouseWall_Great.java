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

import javax.media.j3d.Texture2D;
import java.io.Serializable;

/*
 * ����
*/
public class Group_HouseWall_Great implements Simple_Group,Serializable{
	
	public TransformGroup trans = new TransformGroup();

	//����ת���ڵ�
	@Override
	public TransformGroup createSceneGraph(){
		
		createEvent();
		Appearance app = createApp();
		
		Texture2D str_wall1 = new Texture().gettex("E:/java/picture/java3D/qiangsheng.jpg");
		Texture2D str_wall2 = new Texture().gettex("E:/java/picture/java3D/qiangtou.jpg");

			
/****ǽ****/

		
		Point3f[] p1 = new Point3f[4];
		p1[0] = new Point3f(-0.3f,0.2f,0.0f);
		p1[1] = new Point3f(0.0f,0.2f,0.0f);
		p1[2] = new Point3f(0.0f,0.0f,0.0f);
		p1[3] = new Point3f(-0.3f,0.0f,0.0f);

	
		//ͼƬ����
		float[] index1 = {
				0.0f,0.4f, 0.6f,0.4f,
				0.6f,0.0f, 0.0f,0.0f 
		};

		Point3f[] p2 = new Point3f[4];
		p2[0] = new Point3f(-0.3f,0.27f,0.0f);
		p2[1] = new Point3f(-0.2f,0.27f,0.0f);
		p2[2] = new Point3f(-0.2f,0.2f,0.0f);
		p2[3] = new Point3f(-0.3f,0.2f,0.0f);
		
		//ͼƬ����
		float[] index2 = {
				0.0f,0.6f, 
				0.2f,0.6f,
				0.2f,0.4f,
				0.0f,0.4f 
		};

		Point3f[] p3 = new Point3f[4];
		p3[0] = new Point3f(-0.3f,0.3f,0.0f);
		p3[1] = new Point3f(-0.2f,0.3f,0.0f);
		p3[2] = new Point3f(-0.2f,0.27f,0.0f);
		p3[3] = new Point3f(-0.3f,0.27f,0.0f);
		
		//ͼƬ����
		float[] index3 = {
				0.0f,1.0f,
				1.0f,1.0f,
				1.0f,0.0f,
				0.0f,0.0f 
		};

		Point3f[] p4 = new Point3f[4];
		p4[0] = new Point3f(-0.2f,0.37f,0.0f);
		p4[1] = new Point3f(-0.1f,0.37f,0.0f);
		p4[2] = new Point3f(-0.1f,0.25f,0.0f);
		p4[3] = new Point3f(-0.2f,0.25f,0.0f);
		
		//ͼƬ����
		float[] index4 = {
				0.2f,0.8f,
				0.4f,0.8f,
				0.4f,0.5f,
				0.2f,0.5f 
		};

		Point3f[] p5 = new Point3f[4];
		p5[0] = new Point3f(-0.2f,0.40f,0.0f);
		p5[1] = new Point3f(-0.1f,0.40f,0.0f);
		p5[2] = new Point3f(-0.1f,0.37f,0.0f);
		p5[3] = new Point3f(-0.2f,0.37f,0.0f);
			
		//ͼƬ����
		float[] index5 = {
				0.0f,1.0f,
				1.0f,1.0f,
				1.0f,0.0f,
				0.0f,0.0f 
		};

		Point3f[] p6 = new Point3f[4];
		p6[0] = new Point3f(-0.1f,0.47f,0.0f);
		p6[1] = new Point3f(0.0f,0.47f,0.0f);
		p6[2] = new Point3f(0.0f,0.2f,0.0f);
		p6[3] = new Point3f(-0.1f,0.2f,0.0f);
		
		//ͼƬ����
		float[] index6 = {
				0.4f,1.0f,
				0.6f,1.0f,
				0.6f,0.4f, 
				0.4f,0.4f 
		};
				
		Point3f[] p7 = new Point3f[4];
		p7[0] = new Point3f(-0.1f,0.5f,0.0f);
		p7[1] = new Point3f(0.0f,0.5f,0.0f);
		p7[2] = new Point3f(0.0f,0.47f,0.0f);
		p7[3] = new Point3f(-0.1f,0.47f,0.0f);	

		
		//ͼƬ����
		float[] index7 = {
				0.0f,1.0f,
				1.0f,1.0f,
				1.0f,0.0f,
				0.0f,0.0f 
		};
		

		Shape3D shape1 = new Shape3D_HouseWall_Great().createShape3D(p1,str_wall1,index1);
		Shape3D shape2 = new Shape3D_HouseWall_Great().createShape3D(p2,str_wall1,index2);
		Shape3D shape3 = new Shape3D_HouseWall_Great().createShape3D(p3,str_wall2,index3);
		Shape3D shape4 = new Shape3D_HouseWall_Great().createShape3D(p4,str_wall1,index4);
		Shape3D shape5 = new Shape3D_HouseWall_Great().createShape3D(p5,str_wall2,index5);
		Shape3D shape6 = new Shape3D_HouseWall_Great().createShape3D(p6,str_wall1,index6);
		Shape3D shape7 = new Shape3D_HouseWall_Great().createShape3D(p7,str_wall2,index7);


		TransformGroup g1= new TransformGroup(); 
		g1.addChild(shape1);
		g1.addChild(shape2);
		g1.addChild(shape3);
		g1.addChild(shape4);
		g1.addChild(shape5);
		g1.addChild(shape6);
		g1.addChild(shape7);

		trans.addChild(g1);
		
		return trans ;
	}	
	
	
	//���������¼�
	@Override
	public void createEvent(){
	}

	//�����������
	public Appearance createApp(){
		Appearance app = new Appearance();
		
		Material material= new Material();
		// Ϊ������Ӳ���
		material.setDiffuseColor(new Color3f(1.0f,1.0f,0.0f));
		// ���÷����Ч��
		app.setMaterial(material);

		return app;

	}

}


	