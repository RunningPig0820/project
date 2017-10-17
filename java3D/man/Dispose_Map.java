import java.io.File;  
import java.io.IOException;

import java.awt.image.BufferedImage;  

import javax.imageio.ImageIO;


//ͼ������
public class Dispose_Map{
	
	//��ֵ��
	public BufferedImage binaryImage(String string1 , String string2){
		
		BufferedImage image = null ;

		try{
			image = ImageIO.read(new File(string1)); //��ȡͼƬ
		}catch(IOException ex){
			System.out.println(ex);
		}

		int width = image.getWidth();   //��ȡͼƬ�Ŀ��
		int height = image.getHeight(); //��ȡͼƬ�ĸ߶�
		
		//��ʼ����һ����ֵ���Ķ���
		BufferedImage binaryimage1 = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
		
		for(int i = 0 ; i < width ; i++){
			for(int j = 0 ; j < height ; j ++){
				int rgb = image.getRGB(i, j);  
				binaryimage1.setRGB(i, j, rgb); 
			}
		}
		
		//д������
		try{
			ImageIO.write(binaryimage1,"png",new File(string2));  
		}catch(IOException ex){
			System.out.println(ex);
		}

		return binaryimage1;
	}
	
	//�ҶȻ�
	public BufferedImage grayImage(String string1){
		
		BufferedImage image = null;

		try{
			image = ImageIO.read(new File(string1)); //��ȡͼƬ
		}catch(IOException ex){
			System.out.println(ex);
		}

		int width = image.getWidth();   //��ȡͼƬ�Ŀ��
		int height = image.getHeight(); //��ȡͼƬ�ĸ߶�
		
		//��ʼ����һ����ֵ���Ķ���
		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

		for(int i = 0 ; i < width ; i++){
			for(int j = 0 ; j < width ; j ++){
				int rgb = image.getRGB(i, j);  
				grayImage.setRGB(i, j, rgb); 
			}
		}
/*	
		//д������
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