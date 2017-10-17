import java.awt.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Integer;
import java.util.ArrayList;
import java.lang.Float;

public class Demo extends JFrame {
	
	private NewPanel p = new NewPanel();
	private String string = "E:/java/1.jpg";
	private ImageIcon icon = new ImageIcon(string);
	
	private int count = 0;
	private int a	  =	0;
	private int b	  = 0;
	private int c	  = 0;
	private int d	  = 0;
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
//	private ArrayList<Float> list_float = new ArrayList<Float>();
	
	public int width  = icon.getIconWidth();
	public int height = icon.getIconHeight();

	public Demo() {

		
		
		this.getContentPane().add(p); // 将面板添加到JFrame上
		this.setSize(width, height); // 初始窗口的大小
		this.setLocationRelativeTo(null); // 设置窗口居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		System.out.println("0.5f,0.5f,");

		p.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				 
				 count++;
					
				 System.out.println(((float)e.getX()/width)+"f,"+((float)(height-e.getY())/height)+"f,");
				 	
				 list.add(e.getX());
				 list.add(e.getY());			
				 
//				 list_float.add((float)e.getX()/width);
//				 list_float.add((float)e.getY()/height);

			}
		});

	}

	class NewPanel extends JPanel {
		
		public NewPanel() {}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int x = 0, y = 0;
			//g.drawImage(icon.getImage(),0,0,width,height,this);// 图片会自动缩放			
			g.drawImage(icon.getImage(),0,0,this);
		}

		@Override
		public void paint(Graphics g){
			
			super.paint(g);
			
			if(list.size() > 3){
				for(int i = 0 ; i < list.size()-2 ;i=i+2){
					g.setColor(Color.red);
					g.drawLine(list.get(i),list.get(i+1),list.get(i+2),list.get(i+3));
					//g.drawImage(icon.getImage(),0,0,this);//图片不会自动缩放
				}
			}

			updateUI();

		}

	}

	public static void main(String[] args) {
		new Demo();
	}

}