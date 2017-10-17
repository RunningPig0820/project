import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import java.awt.Choice;
import java.awt.GridLayout;

public class DesJPanel extends JPanel{

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();

	ButtonGroup group = new ButtonGroup();// ������ѡ��ť��
	JRadioButton radioButton1 = new JRadioButton("��ˮ");// ������ѡ��ť
	JRadioButton radioButton2 = new JRadioButton("����");// ������ѡ��ť
	JRadioButton radioButton3 = new JRadioButton("����");// ������ѡ��ť

	JLabel label2_1 = new JLabel("���");
	JLabel label2_2 = new JLabel("�������");
	JLabel label2_3 = new JLabel("������");
	
	JTextPane text2_1 = new JTextPane();
	JTextPane text2_2 = new JTextPane();
	JTextPane text2_3 = new JTextPane();
	
	JLabel label3_1 = new JLabel("��ǰ������");
	JLabel label3_2 = new JLabel("ռ���ڴ�");
	JLabel label3_3 = new JLabel("��������");
	
	JTextPane text3_1 = new JTextPane();
	JTextPane text3_2 = new JTextPane();
	JTextPane text3_3 = new JTextPane();
	
	JLabel label4_1 = new JLabel("����");
	Choice choice = new Choice();

	public DesJPanel(){
		setLayout(new GridLayout(4,1));
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		panel4.setLayout(null);

		build1();
		build2();
		build3();
		build4();
	}
	
	//��Ȼ����
	public void build1(){				
		panel1.setBorder(BorderFactory.createTitledBorder("����"));

		radioButton1.setBounds(10,50,150,50);
		radioButton2.setBounds(10,100,150,50);
		radioButton3.setBounds(10,150,150,50);

		group.add(radioButton1);// ��radioButton1���ӵ���ѡ��ť����
		group.add(radioButton2);// ��radioButton2���ӵ���ѡ��ť����
		group.add(radioButton3);// ��radioButton3���ӵ���ѡ��ť����		
		
		panel1.add(radioButton1);
		panel1.add(radioButton2);
		panel1.add(radioButton3);
		add(panel1);
	}

	//������Ϣ
	public void build2(){
		panel2.setBorder(BorderFactory.createTitledBorder("����"));
		text2_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		text2_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		text2_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		label2_1.setBounds(10,50,100,30);
		label2_2.setBounds(10,100,100,30);
		label2_3.setBounds(10,150,100,30);
		
		text2_1.setBounds(110,50,100,30);
		text2_2.setBounds(110,100,100,30);
		text2_3.setBounds(110,150,100,30);
		
	
		panel2.add(label2_1);
		panel2.add(label2_2);
		panel2.add(label2_3);
		panel2.add(text2_1);
		panel2.add(text2_2);
		panel2.add(text2_3);	
		add(panel2);
	}
	
	//������Ϣ
	public void build3(){
		panel3.setBorder(BorderFactory.createTitledBorder("����"));
		text3_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		text3_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		text3_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		label3_1.setBounds(10,50,100,30);
		label3_2.setBounds(10,100,100,30);
		label3_3.setBounds(10,150,100,30);
		
		text3_1.setBounds(110,50,100,30);
		text3_2.setBounds(110,100,100,30);
		text3_3.setBounds(110,150,100,30);
		

		panel3.add(label3_1);
		panel3.add(label3_2);
		panel3.add(label3_3);
		panel3.add(text3_1);
		panel3.add(text3_2);
		panel3.add(text3_3);				
		add(panel3);
	}

	//ʱ������
	public void build4(){
		panel4.setBorder(BorderFactory.createTitledBorder("����"));

		choice.add("��");
		choice.add("��");
		choice.add("Ԫ");
		choice.add("��");
		choice.add("��");
		
		label4_1.setBounds(10,20,100,30);
		choice.setBounds(120,20,100,30);
	
		panel4.add(label4_1);
		panel4.add(choice);
		add(panel4);	
	}
	
}