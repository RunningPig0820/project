import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Texture2D;

import com.sun.j3d.utils.geometry.Cylinder;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;

import java.io.Serializable;

/*
 * ����
*/
public class Group_House implements Simple_Group,Serializable{
	
	private static final long serialVersionUID=798156025080407863l;

	public TransformGroup trans = new TransformGroup();
	
	//����
	Group_HousePillar pillar = new Group_HousePillar();
	//����
	Group_HouseBoard  board  = new Group_HouseBoard();

	//����ת���ڵ�
	@Override
	public TransformGroup createSceneGraph(){
		//�¼�
		createEvent();
		
		//��������
		Texture tex = new Texture();
		Texture2D tex2D = tex.gettex("E:/java/picture/java3D1/zhuzi.jpg");		
		//�����������
		Appearance app = createApp();
		app.setTexture(tex2D);
		
		//�������� (ӭ��)
		Texture tex1_1 = new Texture();
		Texture2D tex2D1_1 = tex1_1.gettex("E:/java/picture/java3D1/mutou2.jpg");		
		//�����������
		Appearance app1_1 = createApp();
		app1_1.setTexture(tex2D1_1);
		
		//����������⣩
		Texture tex1_2 = new Texture();
		Texture2D tex2D1_2 = tex1_2.gettex("E:/java/picture/java3D1/mutou3.jpg");		
		//�����������
		Appearance app1_2 = createApp();
		app1_2.setTexture(tex2D1_2);

		//�����������⣩
		Texture tex1_3 = new Texture();
		Texture2D tex2D1_3 = tex1_3.gettex("E:/java/picture/java3D1/mutou1.jpg");		
		//�����������
		Appearance app1_3 = createApp();
		app1_3.setTexture(tex2D1_3);

		//�뾶�ı�׼��λ   
		float pw = 0.1f/5;  
		//�ߵı�׼��λ	 
		float ph = 1.2f/5; 
		//���ӵı�׼��λ  
		float pa = 0.4f/5;
		//���ı�׼��λ  
		float pd = 0.6f/5; 

		
		//�ڸ�����
		pillar.setpillar(pw,ph,-8*pd,ph/2,2*pd,app);
		TransformGroup group1_1 = pillar.createSceneGraph();
		
		pillar.setpillar(pw,ph,-8*pd,ph/2,pd,app);
		TransformGroup group1_2 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph,-8*pd,ph/2,-1*pd,app);
		TransformGroup group1_3 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph,-8*pd,ph/2,-2*pd,app);
		TransformGroup group1_4 = pillar.createSceneGraph();
	

		//�ڸ�����
		pillar.setpillar(pw,ph+pa,-7*pd,(ph+pa)/2,2*pd,app);
		TransformGroup group1_5 = pillar.createSceneGraph();
		
		pillar.setpillar(pw,ph+pa,-7*pd,(ph+pa)/2,pd,app);
		TransformGroup group1_6 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa,-7*pd,(ph+pa)/2,-1*pd,app);
		TransformGroup group1_7 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa,-7*pd,(ph+pa)/2,-2*pd,app);
		TransformGroup group1_8 = pillar.createSceneGraph();

		//�ڸ�����
		pillar.setpillar(pw,pa+pa/2,-6*pd,ph+pa-pw/2,2*pd,app);
		TransformGroup group1_9 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,pa+pa/2,-6*pd,ph+pa,pd,app);
		TransformGroup group1_9_1 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,pa+pa/2,-6*pd,ph+pa,-1*pd,app);
		TransformGroup group1_9_2 = pillar.createSceneGraph();	

		pillar.setpillar(pw,pa+pa/2,-6*pd,ph+pa-pw/2,-2*pd,app);
		TransformGroup group1_10 = pillar.createSceneGraph();

/***********/		
		//�ڸ�����
		pillar.setpillar(pw,ph+pa*2,-5*pd,(ph+pa*2)/2,2*pd,app);
		TransformGroup group1_11 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,ph/3,-5*pd,ph+pa*2-ph/6,pd,app);
		TransformGroup group1_11_1 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,ph/3,-5*pd,ph+pa*2-ph/6,-1*pd,app);
		TransformGroup group1_11_2 = pillar.createSceneGraph();	

		pillar.setpillar(pw,ph+pa*2,-5*pd,(ph+pa*2)/2,-2*pd,app);
		TransformGroup group1_12 = pillar.createSceneGraph();


/*************************/		
		//�ڸ�����
		pillar.setpillar(pw,ph/1.2f,-4*pd,ph+5*ph/12,2*pd,app);
		TransformGroup group1_13 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,pa+pa/2,-4*pd,ph+5*ph/12+ph/4-pw,pd,app);
		TransformGroup group1_13_1 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,pa+pa/2,-4*pd,ph+5*ph/12+ph/4-pw,-1*pd,app);
		TransformGroup group1_13_2 = pillar.createSceneGraph();	

		pillar.setpillar(pw,ph/1.2f,-4*pd,ph+5*ph/12,-2*pd,app);
		TransformGroup group1_14 = pillar.createSceneGraph();
		

		//�ڸ�����
		pillar.setpillar(pw,ph+pa*2,-3*pd,(ph+pa*2)/2,2*pd,app);
		TransformGroup group1_15 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,ph+pa*2,-3*pd,(ph+pa*2)/2,1*pd,app);
		TransformGroup group1_15_1 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,ph+pa*2,-3*pd,(ph+pa*2)/2,-1*pd,app);
		TransformGroup group1_15_2 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa*2,-3*pd,(ph+pa*2)/2,-2*pd,app);
		TransformGroup group1_16 = pillar.createSceneGraph();


		//�ڸ�һ��
		pillar.setpillar(pw,ph+pa,-1*pd,(ph+pa)/2,2*pd,app);
		TransformGroup group1_17 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,ph+pa,-1*pd,(ph+pa)/2,1*pd,app);
		TransformGroup group1_17_1 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(pw,ph+pa,-1*pd,(ph+pa)/2,-1*pd,app);
		TransformGroup group1_17_2 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa,-1*pd,(ph+pa)/2,-2*pd,app);
		TransformGroup group1_18 = pillar.createSceneGraph();
		

		//�ھ����� Ϊ y = 0


		//������
		pillar.setpillar(pw,ph, 3*pd,ph/2,2*pd,app);
		TransformGroup group1_19 = pillar.createSceneGraph();
		
		pillar.setpillar(pw,ph, 3*pd,ph/2,pd,app);
		TransformGroup group1_20 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph, 3*pd,ph/2,-1*pd,app);
		TransformGroup group1_21 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph, 3*pd,ph/2,-2*pd,app);
		TransformGroup group1_22 = pillar.createSceneGraph();


		//������
		pillar.setpillar(pw,ph+pa, 4*pd,(ph+pa)/2,2*pd,app);
		TransformGroup group1_23 = pillar.createSceneGraph();
		
		pillar.setpillar(pw,ph+pa, 4*pd,(ph+pa)/2,pd,app);
		TransformGroup group1_24 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa, 4*pd,(ph+pa)/2,-1*pd,app);
		TransformGroup group1_25 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa, 4*pd,(ph+pa)/2,-2*pd,app);
		TransformGroup group1_26 = pillar.createSceneGraph();


		//������
		pillar.setpillar(pw,ph+pa*2, 5*pd,(ph+pa*2)/2,2*pd,app);
		TransformGroup group1_27 = pillar.createSceneGraph();
		
		pillar.setpillar(pw,ph+pa*2, 5*pd,(ph+pa*2)/2,pd,app);
		TransformGroup group1_28 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa*2, 5*pd,(ph+pa*2)/2,-1*pd,app);
		TransformGroup group1_29 = pillar.createSceneGraph();

		pillar.setpillar(pw,ph+pa*2, 5*pd,(ph+pa*2)/2,-2*pd,app);
		TransformGroup group1_30 = pillar.createSceneGraph();
		
				
		//�ڸ�����
		board.setBoard(pw/2,pw/2,pd/2,-8*pd,ph-pw/2,2*pd-pd/2,app1_1);
		TransformGroup group2_1 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd,-8*pd,ph-pw/2,pd-pd,app1_1);
		TransformGroup group2_2 = board.createSceneGraph();

		board.setBoard(pw/2,pw/2,pd/2,-8*pd,ph-pw/2,-1*pd-pd/2,app1_1);
		TransformGroup group2_3 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd/2,-8*pd,ph-3*pw,2*pd-pd/2,app1_1);
		TransformGroup group2_4 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd,-8*pd,ph-3*pw,pd-pd,app1_1);
		TransformGroup group2_5 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd/2,-8*pd,ph-3*pw,-1*pd-pd/2,app1_1);
		TransformGroup group2_6 = board.createSceneGraph();


		//����
		//�ڸ�����
		board.setBoard(pw/2,pw/2,pd/2,-7*pd,ph-pw/2+pa,2*pd-pd/2,app1_1);
		TransformGroup group2_7 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd,-7*pd,ph-pw/2+pa,pd-pd,app1_1);
		TransformGroup group2_8 = board.createSceneGraph();

		board.setBoard(pw/2,pw/2,pd/2,-7*pd,ph-pw/2+pa,-1*pd-pd/2,app1_1);
		TransformGroup group2_9 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd/2,-7*pd,ph-3*pw+pa,2*pd-pd/2,app1_1);
		TransformGroup group2_10 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd,-7*pd,ph-3*pw+pa,pd-pd,app1_1);
		TransformGroup group2_11 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd/2,-7*pd,ph-3*pw+pa,-1*pd-pd/2,app1_1);
		TransformGroup group2_12 = board.createSceneGraph();
		

		//�ڸ�����
		board.setBoard(pw/2,pw/2,pd/2,-4*pd,(ph+pa*2)+pw+pw/2,2*pd-pd/2,app1_1);
		TransformGroup group2_13 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd,-4*pd,(ph+pa*2)+pw+pw/2,pd-pd,app1_1);
		TransformGroup group2_14 = board.createSceneGraph();

		board.setBoard(pw/2,pw/2,pd/2,-4*pd,(ph+pa*2)+pw+pw/2,-1*pd-pd/2,app1_1);
		TransformGroup group2_15 = board.createSceneGraph();


		//�ڸ�����
		board.setBoard(pw/2,pw/2,pd/2,-3*pd,(ph+pa*2)-pw/2,2*pd-pd/2,app1_1);
		TransformGroup group2_16 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd/2,-3*pd,(ph+pa)+pw,2*pd-pd/2,app1_1);
		TransformGroup group2_16_1 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw,pd/2,-3*pd,(ph+pa)-3*pw/2,2*pd-pd/2,app1_1);
		TransformGroup group2_16_2 = board.createSceneGraph();

		board.setBoard(pw/2,pw/2,pd,-3*pd,(ph+pa*2)-pw/2,pd-pd,app1_1);
		TransformGroup group2_17 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd,-3*pd,(ph+pa)+pw,pd-pd,app1_1);
		TransformGroup group2_17_1 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd,-3*pd,(ph+pa)-3*pw/2,pd-pd,app1_1);
		TransformGroup group2_17_2 = board.createSceneGraph();

		board.setBoard(pw/2,pw/2,pd/2,-3*pd,(ph+pa*2)-pw/2,-1*pd-pd/2,app1_1);
		TransformGroup group2_18 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd/2,-3*pd,ph,-1*pd-pd/2,app1_1);
		TransformGroup group2_18_1 = board.createSceneGraph();

		board.setBoard(pw/2,pw,pd/2,-3*pd,(ph+pa)-3*pw/2,-1*pd-pd/2,app1_1);
		TransformGroup group2_18_2 = board.createSceneGraph();


		//������
		board.setBoard(pw/2,pw/2,pd/2,4*pd,ph+pa-pw/2,2*pd-pd/2,app1_1);
		TransformGroup group2_19 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd,4*pd,ph+pa-pw/2,pd-pd,app1_1);
		TransformGroup group2_20 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd/2,4*pd,ph+pa-pw/2,-1*pd-pd/2,app1_1);
		TransformGroup group2_21 = board.createSceneGraph();
		
		
		//������
		board.setBoard(pw/2,pw/2,pd/2,5*pd,ph+pa*2-pw/2,2*pd-pd/2,app1_1);
		TransformGroup group2_22 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd,5*pd,ph+pa*2-pw/2,pd-pd,app1_1);
		TransformGroup group2_23 = board.createSceneGraph();
		
		board.setBoard(pw/2,pw/2,pd/2,5*pd,ph+pa*2-pw/2,-1*pd-pd/2,app1_1);
		TransformGroup group2_24 = board.createSceneGraph();

		
		//ľͷ����
		//�ڸ�����
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-8*pd,ph+pw/2,0,app);
		TransformGroup group3_1 = pillar.createSceneGraph();		

		//�ڸ�����
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-7*pd,ph+pa+pw/2,0,app);
		TransformGroup group3_2 = pillar.createSceneGraph();	
	
		//�ڸ�����
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-6*pd,ph+pa+pw/2+pa/2,0,app);
		TransformGroup group3_3 = pillar.createSceneGraph();	
		
		//�ڸ�����
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-5*pd,ph+pa*2+pw/2,0,app);
		TransformGroup group3_4 = pillar.createSceneGraph();	
		
		//�ڸ�����
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-4*pd,(ph+pa*2)+pw+pw/2,0,app);
		TransformGroup group3_5 = pillar.createSceneGraph();	

		//©��
		pillar.setpillar(2,Math.PI/2,pw/2,pd*4+pw,-4*pd,(ph+pa)+pw*3,0,app);
		TransformGroup group3_5_1 = pillar.createSceneGraph();

		//�ڸ�����
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-3*pd,(ph+pa*2)+pw/2,0,app);
		TransformGroup group3_6 = pillar.createSceneGraph();
		
		//©��
		pillar.setpillar(2,Math.PI/2,pw/2,pd*4+pw,-3*pd,(ph+pa)+pw*2,0,app);
		TransformGroup group3_6_1 = pillar.createSceneGraph();
		
		//�ڸ�����
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-2*pd,ph+pa+pw/2+pa/2,0,app);
		TransformGroup group3_7 = pillar.createSceneGraph();

		//�ڸ�һ��
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,-1*pd,(ph+pa*1)+pw/2,0,app);
		TransformGroup group3_8 = pillar.createSceneGraph();
		
		//������
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,3*pd,(ph)+pw/2,0,app);
		TransformGroup group3_9 = pillar.createSceneGraph();

		//������
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,4*pd,(ph+pa)+pw/2,0,app);
		TransformGroup group3_10 = pillar.createSceneGraph();
		
		//������
		pillar.setpillar(2,Math.PI/2,pw,pd*4+pw*2,5*pd,ph+pa*2+pw/2,0,app);
		TransformGroup group3_11 = pillar.createSceneGraph();
		

		//ľͷƽ��
		//�ڸ�һ����
		pillar.setpillar(1,Math.PI/2,pw,pd*5+pw,1.5f*pd,ph+pa-pw/2,-2*pd,app);
		TransformGroup group4_1 = pillar.createSceneGraph();
		
		pillar.setpillar(1,Math.PI/2,pw,pd*5+pw,1.5f*pd,ph+pa-pw/2, 2*pd,app);
		TransformGroup group4_2 = pillar.createSceneGraph();
		
		//ľͷƽ��
		//�ڸ��˵�������
		board.setBoard(pd/2-pw,pw/2,pw,-7.5f*pd,ph,-2*pd,app1_2);
		TransformGroup group5_1 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,-7.5f*pd,ph-pw*2,-2*pd,app1_2);
		TransformGroup group5_2 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,-7.5f*pd,ph,2*pd,app1_2);
		TransformGroup group5_3 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,-7.5f*pd,ph-pw*2,2*pd,app1_2);
		TransformGroup group5_4 = board.createSceneGraph();	
		
		//�ڸ��˵�������
		board.setBoard(pd-pw,pw/2,pw,-6*pd,ph,-2*pd,app1_2);
		TransformGroup group5_5 = board.createSceneGraph();
		
		board.setBoard(pd-pw,pw/2,pw,-6*pd,ph-pw*2,-2*pd,app1_2);
		TransformGroup group5_6 = board.createSceneGraph();
		
		board.setBoard(pd-pw,pw/2,pw,-6*pd,ph,2*pd,app1_2);
		TransformGroup group5_7 = board.createSceneGraph();
		
		board.setBoard(pd-pw,pw/2,pw,-6*pd,ph-pw*2,2*pd,app1_2);
		TransformGroup group5_8 = board.createSceneGraph();	
		
		//�ڸ�����������
		board.setBoard(pd-pw,pw/2,pw,-4*pd,ph,-2*pd,app1_2);
		TransformGroup group5_9 = board.createSceneGraph();
		
		board.setBoard(pd-pw,pw/2,pw,-4*pd,ph-pw*2,-2*pd,app1_2);
		TransformGroup group5_10 = board.createSceneGraph();
	
		board.setBoard(pd-pw,pw/2,pw,-4*pd,ph,2*pd,app1_2);
		TransformGroup group5_11 = board.createSceneGraph();
		
		board.setBoard(pd-pw,pw/2,pw,-4*pd,ph-pw*2,2*pd,app1_2);
		TransformGroup group5_12 = board.createSceneGraph();	
		
		//�ڸ��ĵ�������
		board.setBoard(pd-pw,pw/2,pw,-2*pd,ph,-2*pd,app1_2);
		TransformGroup group5_13 = board.createSceneGraph();
		
		board.setBoard(pd-pw,pw/2,pw,-2*pd,ph-pw*2,-2*pd,app1_2);
		TransformGroup group5_14 = board.createSceneGraph();
	
		board.setBoard(pd-pw,pw/2,pw,-2*pd,ph,2*pd,app1_2);
		TransformGroup group5_15 = board.createSceneGraph();
		
		board.setBoard(pd-pw,pw/2,pw,-2*pd,ph-pw*2,2*pd,app1_2);
		TransformGroup group5_16 = board.createSceneGraph();	
		
		//�ڸ��ߵ�������
		board.setBoard(pd*2-pw,pw/2,pw,-5*pd,ph+pw*2,pd,app1_2);
		TransformGroup group5_17 = board.createSceneGraph();
		
		board.setBoard(pd*2-pw,pw/2,pw,-5*pd,ph+pw*2,-1*pd,app1_2);
		TransformGroup group5_18 = board.createSceneGraph();
		
		//���ߵ�������
		board.setBoard(pd/2-pw,pw/2,pw,-6.5f*pd,ph+pw*4,pd,app1_2);
		TransformGroup group5_19 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,-6.5f*pd,ph+pw*4,-1*pd,app1_2);
		TransformGroup group5_20 = board.createSceneGraph();


		//������������
		board.setBoard(3*pd/2-pw,pw/2,pw,-4.5f*pd,ph+pw*4,pd,app1_2);
		TransformGroup group5_21 = board.createSceneGraph();
		
		board.setBoard(3*pd/2-pw,pw/2,pw,-4.5f*pd,ph+pw*4,-1*pd,app1_2);
		TransformGroup group5_22 = board.createSceneGraph();
		
		//���嵽����
		board.setBoard(pd/2-pw,pw/2,pw,-4.5f*pd,ph+pw*4+pa/2,2*pd,app1_2);
		TransformGroup group5_23 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,-4.5f*pd,ph+pw*4+pa/2,-2*pd,app1_2);
		TransformGroup group5_24 = board.createSceneGraph();
		
		//���ĵ�����
		board.setBoard(pd/2-pw,pw/2,pw,-3.5f*pd,ph+pw*4+pa/2,2*pd,app1_2);
		TransformGroup group5_25 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,-3.5f*pd,ph+pw*4+pa/2,-2*pd,app1_2);
		TransformGroup group5_26 = board.createSceneGraph();


		//��������һ��
		board.setBoard(pd/2-pw,pw/2,pw,-2*pd,ph+pw*4,2*pd,app1_2);
		TransformGroup group5_27 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,-2*pd,ph+pw*4,-2*pd,app1_2);
		TransformGroup group5_28 = board.createSceneGraph();

		

		//��һ������
		board.setBoard(2.5f*pd-pw,pw/2,pw,1.5f*pd,ph+pw*2,2*pd,app1_2);
		TransformGroup group5_29 = board.createSceneGraph();
		
		board.setBoard(2.5f*pd-pw,pw/2,pw,1.5f*pd,ph+pw*2,-2*pd,app1_2);
		TransformGroup group5_30 = board.createSceneGraph();
		
		//��һ������
		board.setBoard(2*pd-pw,pw/2,pw,pd,ph-pa/2,2*pd,app1_2);
		TransformGroup group5_31 = board.createSceneGraph();
		
		board.setBoard(2*pd-pw,pw/2,pw,pd,ph-pa,2*pd,app1_2);
		TransformGroup group5_32 = board.createSceneGraph();
	
		board.setBoard(2f*pd-pw,pw/2,pw,pd,ph-pa/2,-2*pd,app1_2);		
		TransformGroup group5_33 = board.createSceneGraph();
		
		board.setBoard(2f*pd-pw,pw/2,pw,pd,ph-pa,-2*pd,app1_2);
		TransformGroup group5_34 = board.createSceneGraph();
		
		//��������
		board.setBoard(pd/2-pw,pw/2,pw,3.5f*pd,ph-pa,2*pd,app1_2);		
		TransformGroup group5_35 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,3.5f*pd,ph-pa,-2*pd,app1_2);
		TransformGroup group5_36 = board.createSceneGraph();
		
		board.setBoard(pd/3-pw,pw/2,pw,3.5f*pd,ph,2*pd,app1_2);		
		TransformGroup group5_35_1 = board.createSceneGraph();
		
		board.setBoard(pd/3-pw,pw/2,pw,3.5f*pd,ph,-2*pd,app1_2);
		TransformGroup group5_36_1 = board.createSceneGraph();

		//���ŵ�����
		board.setBoard(pd/2-pw,pw/2,pw,4.5f*pd,ph-pa/2,2*pd,app1_2);		
		TransformGroup group5_37 = board.createSceneGraph();

		board.setBoard(pd/2-pw,pw/2,pw,4.5f*pd,ph-pa/2,-2*pd,app1_2);		
		TransformGroup group5_38 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,4.5f*pd,ph-pa,2*pd,app1_2);
		TransformGroup group5_39 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,4.5f*pd,ph-pa,-2*pd,app1_2);
		TransformGroup group5_40 = board.createSceneGraph();

		board.setBoard(pd/2-pw,pw/2,pw,4.5f*pd,ph+pw*2,2*pd,app1_2);
		TransformGroup group5_41 = board.createSceneGraph();
		
		board.setBoard(pd/2-pw,pw/2,pw,4.5f*pd,ph+pw*2,-2*pd,app1_2);
		TransformGroup group5_42 = board.createSceneGraph();

		// ��ӵ�������
		trans.addChild(group1_1);
		trans.addChild(group1_2);
		trans.addChild(group1_3);
		trans.addChild(group1_4);	
		trans.addChild(group1_5);
		trans.addChild(group1_6);
		trans.addChild(group1_7);
		trans.addChild(group1_8);		
		trans.addChild(group1_9);
		trans.addChild(group1_9_1);
		trans.addChild(group1_9_2);
		trans.addChild(group1_10);		
		trans.addChild(group1_11);
		trans.addChild(group1_11_1);
		trans.addChild(group1_11_2);
		trans.addChild(group1_12);		
		trans.addChild(group1_13);
		trans.addChild(group1_13_1);
		trans.addChild(group1_13_2);
		trans.addChild(group1_14);	
		trans.addChild(group1_15);
		trans.addChild(group1_15_1);
		trans.addChild(group1_15_2);
		trans.addChild(group1_16);		
		trans.addChild(group1_17);
		trans.addChild(group1_17_1);
		trans.addChild(group1_17_2);
		trans.addChild(group1_18);
		trans.addChild(group1_19);
		trans.addChild(group1_20);
		trans.addChild(group1_21);
		trans.addChild(group1_22);		
		trans.addChild(group1_23);
		trans.addChild(group1_24);
		trans.addChild(group1_25);
		trans.addChild(group1_26);
		trans.addChild(group1_27);
		trans.addChild(group1_28);
		trans.addChild(group1_29);
		trans.addChild(group1_30);
		

		trans.addChild(group2_1);
		trans.addChild(group2_2);
		trans.addChild(group2_3);
		trans.addChild(group2_4);
		trans.addChild(group2_5);
		trans.addChild(group2_6);		
		trans.addChild(group2_7);
		trans.addChild(group2_8);
		trans.addChild(group2_9);
		trans.addChild(group2_10);
		trans.addChild(group2_11);
		trans.addChild(group2_12);		
		trans.addChild(group2_13);
		trans.addChild(group2_14);
		trans.addChild(group2_15);
		trans.addChild(group2_16);
		trans.addChild(group2_16_1);
		trans.addChild(group2_16_2);
		trans.addChild(group2_17);
		trans.addChild(group2_17_1);
		trans.addChild(group2_17_2);
		trans.addChild(group2_18);
		trans.addChild(group2_18_1);
		trans.addChild(group2_18_2);		
		trans.addChild(group2_19);
		trans.addChild(group2_20);
		trans.addChild(group2_21);
		trans.addChild(group2_22);
		trans.addChild(group2_23);
		trans.addChild(group2_24);
		
		trans.addChild(group3_1);
		trans.addChild(group3_2);
		trans.addChild(group3_3);
		trans.addChild(group3_4);
		trans.addChild(group3_5);
		trans.addChild(group3_5_1);
		trans.addChild(group3_6);
		trans.addChild(group3_6_1);
		trans.addChild(group3_7);
		trans.addChild(group3_8);
		trans.addChild(group3_9);
		trans.addChild(group3_10);
		trans.addChild(group3_11);
		
		trans.addChild(group4_1);
		trans.addChild(group4_2);
		
		trans.addChild(group5_1);
		trans.addChild(group5_2);
		trans.addChild(group5_3);
		trans.addChild(group5_4);
		trans.addChild(group5_5);
		trans.addChild(group5_6);
		trans.addChild(group5_7);
		trans.addChild(group5_8);
		trans.addChild(group5_9);
		trans.addChild(group5_10);
		trans.addChild(group5_11);
		trans.addChild(group5_12);		
		trans.addChild(group5_13);
		trans.addChild(group5_14);
		trans.addChild(group5_15);
		trans.addChild(group5_16);	
		trans.addChild(group5_17);
		trans.addChild(group5_18);		
		trans.addChild(group5_19);
		trans.addChild(group5_20);		
		trans.addChild(group5_21);
		trans.addChild(group5_22);
		trans.addChild(group5_23);
		trans.addChild(group5_24);
		trans.addChild(group5_25);
		trans.addChild(group5_26);
		trans.addChild(group5_27);
		trans.addChild(group5_28);
		trans.addChild(group5_29);
		trans.addChild(group5_30);
		trans.addChild(group5_31);
		trans.addChild(group5_32);
		trans.addChild(group5_33);
		trans.addChild(group5_34);
		trans.addChild(group5_35);
		trans.addChild(group5_35_1);
		trans.addChild(group5_36);
		trans.addChild(group5_36_1);
		trans.addChild(group5_37);
		trans.addChild(group5_38);
		trans.addChild(group5_39);
		trans.addChild(group5_40);		
		trans.addChild(group5_41);
		trans.addChild(group5_42);

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


	