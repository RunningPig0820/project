import java.io.File;  
import java.io.IOException;

import java.awt.image.BufferedImage;  

import javax.imageio.ImageIO;


//图像处理类
public class Dispose_Map{
	
	//二值化
	public BufferedImage binaryImage(String string1 , String string2){
		
		BufferedImage image = null ;

		try{
			image = ImageIO.read(new File(string1)); //读取图片
		}catch(IOException ex){
			System.out.println(ex);
		}

		int width = image.getWidth();   //获取图片的宽度
		int height = image.getHeight(); //获取图片的高度
		
		//初始定义一个二值化的对象
		BufferedImage binaryimage1 = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
		
		for(int i = 0 ; i < width ; i++){
			for(int j = 0 ; j < height ; j ++){
				int rgb = image.getRGB(i, j);  
				binaryimage1.setRGB(i, j, rgb); 
			}
		}
		
		//写出对象
		try{
			ImageIO.write(binaryimage1,"png",new File(string2));  
		}catch(IOException ex){
			System.out.println(ex);
		}

		return binaryimage1;
	}
	
	//灰度化
	public BufferedImage grayImage(String string1){
		
		BufferedImage image = null;

		try{
			image = ImageIO.read(new File(string1)); //读取图片
		}catch(IOException ex){
			System.out.println(ex);
		}

		int width = image.getWidth();   //获取图片的宽度
		int height = image.getHeight(); //获取图片的高度
		
		//初始定义一个二值化的对象
		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

		for(int i = 0 ; i < width ; i++){
			for(int j = 0 ; j < width ; j ++){
				int rgb = image.getRGB(i, j);  
				grayImage.setRGB(i, j, rgb); 
			}
		}
/*	
		//写出对象
		try{
			ImageIO.write(grayImage,"png",new File(string2)); 
		}catch(IOException ex){
			System.out.println(ex);
		}
*/
		return grayImage;

	}
	
	public static void main(String[] args){
		Dispose_Map map = new Dispose_Map();
		map.binaryImage("nan.png.jpg","nan.png1.jpg");
	}
}	