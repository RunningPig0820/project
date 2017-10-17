import javax.media.j3d.Texture2D;
import javax.media.j3d.ImageComponent2D;

import com.sun.j3d.utils.image.TextureLoader;

//将纹理图片放入内存中,实现图象与模型的分离

public class Texture{
		
	public Texture2D gettex(String filename){
		//导入纹理
		TextureLoader myLoader = new TextureLoader(filename,null);
		ImageComponent2D myImage = myLoader.getImage();
		
		//如果 myImage 为 null ,导入纹理出错
		if(myImage == null){
			System.err.println("Cannot load texture " + filename + "");
			return null;
		}
	
		// 创建纹理
		Texture2D myTex = (Texture2D)myLoader.getTexture();
	
		return myTex;
	}

}