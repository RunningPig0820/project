import javax.media.j3d.Appearance;
/*
 *  小世界
 */
public interface Simple_Group{
	//创建转化节点
	public TransformGroup createSceneGraph();	
	//设置自身事件
	public void createEvent();
	//创建外观设置
	public Appearance createApp();
}