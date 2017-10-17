import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditPanel extends JPanel{
	
	HandlerBean bean = new HandlerBean();

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	
	JLabel label1_1 = new JLabel("温度");
	JLabel label1_2 = new JLabel("湿度");
	JLabel label1_3 = new JLabel("光强");

	JTextField textpanel1_1 = new JTextField();
	JTextField textpanel1_2 = new JTextField();
	JTextField textpanel1_3 = new JTextField();	
	
	ButtonGroup group2 = new ButtonGroup();// 创建单选按钮组
	JRadioButton radioButton2_1 = new JRadioButton("房子1");// 创建单选按钮
	JRadioButton radioButton2_2 = new JRadioButton("房子2");// 创建单选按钮
	JRadioButton radioButton2_3 = new JRadioButton("草");// 创建单选按钮
	JRadioButton radioButton2_4 = new JRadioButton("天井");// 创建单选按钮	
	

	//创建
	JButton button3_1 = new JButton("创建");// 创建单选按钮组

	JLabel label4_1 = new JLabel("X轴");
	JLabel label4_2 = new JLabel("Y轴");
	JLabel label4_3 = new JLabel("Z轴");	
	
	JTextField textpanel4_11 = new JTextField();
	JTextField textpanel4_21 = new JTextField();
	JTextField textpanel4_31 = new JTextField();

	public EditPanel(){
		setLayout(new GridLayout(4,1));
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		panel4.setLayout(null);
		
		build2();
		build4();
		build1();	
		build3();


	}

	public void build1(){
		panel1.setBorder(BorderFactory.createTitledBorder("参数"));
		textpanel1_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textpanel1_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textpanel1_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		label1_1.setBounds(20,20,100,30);
		label1_2.setBounds(20,50,110,30);
		label1_3.setBounds(20,80,110,30);
		
		textpanel1_1.setBounds(120,20,110,30);
		textpanel1_2.setBounds(120,50,110,30);
		textpanel1_3.setBounds(120,80,110,30);
		
		panel1.add(label1_1);
		panel1.add(label1_2);
		panel1.add(label1_3);
		panel1.add(textpanel1_1);
		panel1.add(textpanel1_2);
		panel1.add(textpanel1_3);
		add(panel1);
	}
	
	public void build2(){
		panel2.setBorder(BorderFactory.createTitledBorder("构建"));	
		
		HandlerListener_2 radioButtonListener = new HandlerListener_2(bean);
		
		radioButton2_1.addActionListener(radioButtonListener);
		radioButton2_2.addActionListener(radioButtonListener);
		radioButton2_3.addActionListener(radioButtonListener);
		radioButton2_4.addActionListener(radioButtonListener);

		group2.add(radioButton2_1);
		group2.add(radioButton2_2);
		group2.add(radioButton2_3);
		group2.add(radioButton2_4);

		radioButton2_1.setBounds(20,20,100,30);
		radioButton2_2.setBounds(20,50,110,30);
		radioButton2_3.setBounds(20,80,110,30);
		radioButton2_4.setBounds(20,110,110,30);		

		panel2.add(radioButton2_1);
		panel2.add(radioButton2_2);
		panel2.add(radioButton2_3);
		panel2.add(radioButton2_4);

		add(panel2);
	}

	public void build3(){
		panel3.setBorder(BorderFactory.createTitledBorder("创建"));
		
		HandlerListener_3 ButtonListener= new HandlerListener_3(bean);
		button3_1.addActionListener(ButtonListener);

		button3_1.setBounds(20,20,100,30);

		panel3.add(button3_1);

		add(panel3);
	}
	
	public void build4(){
		panel4.setBorder(BorderFactory.createTitledBorder("位置"));
		
		textpanel4_11.addFocusListener(new HandlerListener_4(bean,"X"));
		textpanel4_21.addFocusListener(new HandlerListener_4(bean,"Y"));
		textpanel4_31.addFocusListener(new HandlerListener_4(bean,"Z"));

		label4_1.setBounds(20,20,80,30);
		textpanel4_11.setBounds(20,50,80,30);

		label4_2.setBounds(20,90,80,30);
		textpanel4_21.setBounds(20,120,80,30);

		label4_3.setBounds(20,160,80,30);
		textpanel4_31.setBounds(20,190,80,30);

		
		panel4.add(label4_1);
		panel4.add(label4_2);
		panel4.add(label4_3);
		panel4.add(textpanel4_11);
		panel4.add(textpanel4_21);
		panel4.add(textpanel4_31);


		add(panel4);
	}

}