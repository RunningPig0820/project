import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;
import javax.media.j3d.LineArray;
import javax.media.j3d.LineAttributes;

import javax.vecmath.Color3f;

//�ݶ�
public class Shape3D_Coordinate implements Simple_Shape3D{
	
	Shape3D shape = new Shape3D();
	
	//һ����Ҫ�� n ��
	int n =  50;

	//ֱ�ߵĶ������� n�� ��2n����  ��6n��float  ��Ҫ������
	float vert[] = new float[n*12+12];


	//����ת���ڵ�
	@Override
	public Shape3D createShape3D(){
				
		for(int i = 0 ; i <= n ; i++){
			vert[i*6+0] = (float)n/2;
			vert[i*6+1] = 0.0f;
			vert[i*6+2] = (float)n/2-i;

			vert[i*6+3] = (float)-n/2;
			vert[i*6+4] = 0.0f;
			vert[i*6+5] = (float)n/2-i;
		};		
		
		for(int i = 0 ; i <= n ; i++){
			vert[i*6+6+n*6+0] = (float)n/2-i;
			vert[i*6+6+n*6+1] =  0.0f;
			vert[i*6+6+n*6+2] = (float)n/2;

			vert[i*6+6+n*6+3] = (float)n/2-i;
			vert[i*6+6+n*6+4] = 0.0f;
			vert[i*6+6+n*6+5] = (float)-n/2;
		};

		
		// ����ֱ���������
		LineArray line = new LineArray(n*12+12,LineArray.COORDINATES|LineArray.COLOR_3);		
		// ����ֱ�߶������������
		line.setCoordinates(0,vert);
		

		// ����ֱ�����Զ���
		LineAttributes linea = new LineAttributes();
		// �����߿�
		linea.setLineWidth(1.0f);
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