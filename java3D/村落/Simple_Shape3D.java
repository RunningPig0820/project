import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;
/*
 *  С����Ĺ���
 */
public interface Simple_Shape3D{
	//����ת���ڵ�
	public Shape3D createShape3D();		
	//��ۿ���С����ͳһ����
	public Appearance createApp();
}