import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;
/*
 *  小世界的构建
 */
public interface Simple_Shape3D{
	//创建转化节点
	public Shape3D createShape3D();		
	//外观可在小世界统一设置
	public Appearance createApp();
}