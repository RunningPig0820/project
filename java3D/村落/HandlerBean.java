
//各种事件参数

public class HandlerBean{
	
	//构建选择
	private String con_string;
		
	//位置X
	private String pointX;

	//位置Y
	private String pointY;
	
	//位置Z
	private String pointZ;

	//构建选择
	public void setConstruction(String con_string){
		this.con_string = con_string;
	}
	
	//位置X设置
	public void setPointX(String pointX){
		this.pointX = pointX;
	}
	
	//位置Y设置
	public void setPointY(String pointY){
		this.pointY = pointY;
	}

	//位置Z设置
	public void setPointZ(String pointZ){
		this.pointZ = pointZ;
	}

	//获取构建
	public String getConstruction(){
		return con_string;
	}

	//返回 X
	public float getpointX(){
		return  Float.valueOf(pointX);
	}
	
	//返回 Y
	public float getpointY(){
		return Float.valueOf(pointY);
	}

	//放回 Z
	public float getpointZ(){
		return Float.valueOf(pointZ);
	}
}	