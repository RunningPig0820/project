import java.awt.event.*;
public class main3{
	public static void main(String args[]){	
		jiqiren app=new jiqiren();
		app.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);}
			});	
		}
}