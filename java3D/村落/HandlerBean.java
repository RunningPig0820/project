
//�����¼�����

public class HandlerBean{
	
	//����ѡ��
	private String con_string;
		
	//λ��X
	private String pointX;

	//λ��Y
	private String pointY;
	
	//λ��Z
	private String pointZ;

	//����ѡ��
	public void setConstruction(String con_string){
		this.con_string = con_string;
	}
	
	//λ��X����
	public void setPointX(String pointX){
		this.pointX = pointX;
	}
	
	//λ��Y����
	public void setPointY(String pointY){
		this.pointY = pointY;
	}

	//λ��Z����
	public void setPointZ(String pointZ){
		this.pointZ = pointZ;
	}

	//��ȡ����
	public String getConstruction(){
		return con_string;
	}

	//���� X
	public float getpointX(){
		return  Float.valueOf(pointX);
	}
	
	//���� Y
	public float getpointY(){
		return Float.valueOf(pointY);
	}

	//�Ż� Z
	public float getpointZ(){
		return Float.valueOf(pointZ);
	}
}	