import javax.media.j3d.Appearance;
/*
 *  С����
 */
public interface Simple_Group{
	//����ת���ڵ�
	public TransformGroup createSceneGraph();	
	//���������¼�
	public void createEvent();
	//�����������
	public Appearance createApp();
}