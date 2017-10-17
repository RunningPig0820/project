import javax.media.j3d.Texture2D;
import javax.media.j3d.ImageComponent2D;

import com.sun.j3d.utils.image.TextureLoader;

//������ͼƬ�����ڴ���,ʵ��ͼ����ģ�͵ķ���

public class Texture{
		
	public Texture2D gettex(String filename){
		//��������
		TextureLoader myLoader = new TextureLoader(filename,null);
		ImageComponent2D myImage = myLoader.getImage();
		
		//��� myImage Ϊ null ,�����������
		if(myImage == null){
			System.err.println("Cannot load texture " + filename + "");
			return null;
		}
	
		// ��������
		Texture2D myTex = (Texture2D)myLoader.getTexture();
	
		return myTex;
	}

}