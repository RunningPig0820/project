import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;
import javax.media.j3d.LineArray;
import javax.media.j3d.LineAttributes;

import javax.vecmath.Color3f;

//�ݶ�
public class Shape3D_Coordinate1 implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();
	
	// ��
	float vertXYZ[] = {
		 // X ��
		-4.0f,0.0f,0.0f,
		 4.0f,0.0f,0.0f,
		 //��ͷ		 
		 4.0f,0.0f,0.0f,
		 3.5f,0.5f,0.0f,
		 4.0f,0.0f,0.0f,
		 3.5f,-0.5f,0.0f,
		
		
		// Y ��
		0.0f,-4.0f,0.0f,
		0.0f,4.0f,0.0f,
		//��ͷ
		0.0f,4.0f,0.0f,
		0.5f,3.5f,0.0f,
		0.0f,4.0f,0.0f,
		-0.5f,3.0f,0.0f,

		// Z ��
		0.0f,0.0f,-4.0f,
		0.0f,0.0f,4.0f,
		//��ͷ
		0.0f,0.0f,4.0f,
		0.5f,0.0f,3.5f,
		0.0f,0.0f,4.0f,
		-0.5f,0.0f,3.5f,

	};
				

	//��ɫ
	float color[]={
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
		1.0f,0.0f,0.0f,
	};

	//����ת���ڵ�
	@Override
	public Shape3D createShape3D(){

		// ������������
		LineArray line = new LineArray(18,LineArray.COORDINATES|LineArray.COLOR_3);		
		// ����ֱ�߶������������
		line.setCoordinates(0,vertXYZ);
		// ������ɫ
		line.setColors(0,color); 

		// ����ֱ�����Զ���
		LineAttributes linea = new LineAttributes();
		// �����߿�
		linea.setLineWidth(2.0f);
		// ����ֱ�ߵ���ȾЧ��
		linea.setLineAntialiasingEnable(true);

		//��������������ԵĶ���
		Appearance app = new Appearance();
		//������۵ĵ�����
		app.setLineAttributes(linea);


		//�����㼯��������
		shape.setGeometry(line);

		//��Ӽ����嵽������
		shape.setAppearance(app);

		return shape;
	}

	
	//�����������
	public Appearance createApp(){
		return null;
	}
}