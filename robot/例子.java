//�ַ�����ַ������������˰��죬��Ȼ��jdk��һҳ��������
//�����õ��ǰ��ַ���StringBuilder��append�����ڰ����ĵ�String�����鷳

//���⣺�������б���Ҫ�к���

//Ѱ�ҹؼ���Ҳ������Ϊ2

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class ���� extends JFrame{
	private JTextField text1;
	private JTextArea t1;//����������е��ı���
	private JLabel lbl1,lbl2;

	public ����(){
		super("�ı�����ı�������Գ���");//���ø��࣬���ı���һ������
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		lbl1=new JLabel("����Ҫ��Щʲô�أ�");
		c.add(lbl1);

		text1=new JTextField(25);
		c.add(text1);

		text1.addActionListener(new handler());//�����س���
		String s="��ã����Ǻ�������\n";

		t1=new JTextArea(s,11,25);
		c.add(t1);

		setSize(350,300);
		show();
	}

	public static void main(String args[]){
		jiqiren1 app=new jiqiren1();
		app.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);}
		});
	}


	public class handler implements ActionListener{
		Random random=new Random();
		String s="";
		String len="";//�жϸ������ⳤ��
		//int j=0; ������ȫ�ֱ�����Ȼ�� �жϵĻ���һֱ��� 
		int n=0;  //������Ҫһ��ȫ�ֱ������߼�¼Ԥ�������λ��;
		int nn=0;//��Ҫһ��ȫ�ֱ�����¼��������λ��
		int jk=1; //Ϊ�˱�֤Ԥ��������3�β�����ȡ0��Ŀ�ı�֤jk=0ʱ
		String bb[]={"��Ҳ��","�Ҳ���","�㿪�ľͺ�","�������"};//�ش���ã�Ӧ������
		String cc[]={"���Ǻ�������","���Ѽҵĺ���","��²�","���"};//�ش�����˭��Ӧ������
		String dd[]={"������˭��","������˭","����˵","����"};//�ش�����˭����Ӧ������
		String f[]={"���","����˭","����˭��"};//������

		StringBuilder g=new StringBuilder();//Ϊ�˰����ӵ�Ԥ������
		String[] m=new String[100];//Ϊ�˽�����������Ԥ������    Ŀ�ģ����ϴ�Ÿ���������յ�����Ϊ��ƥ����ؼ���
		
		
		String h[]={"ԭ�º���ҵ���֪������������� ��*?.?*��",
			"�Դ�Ҫ����,�������Դ�Ҫ��װ����Ϣ��*��_��*��",
			"����Сѧˮƽ���ң����������ʳ���ô�ѵ�������\\(*-_-*)/"};//��ä������
		String k[]={"���ټ� d====(- ��-*)b",
				"Ը�������� o(-.-)d",
				"Ҫ��Լ��,�������Ļ��� (~~ - .-)~~"};//��ä������
		


		public void actionPerformed(ActionEvent e){	
				int j=0;
				s=text1.getText();		
			{//Ӧ������
				
			
				{//�жϺ����ַ�������� ����(Ŀ�ĵ�һ�μ��ٺ��֣���ȡ�ؼ���)
					if(s.length()>10)//�Գ���û����ÿ���ɾ��.......

						System.out.println("���ַ�������10");//�Ի����˳���û����ÿ���ɾ��
						char[] c=s.toCharArray();//���ַ�������ַ����飬���ַ����ָ���

					for(int i=0;i<c.length;i++){
						len=Integer.toBinaryString(c[i]);//ֻ�Ƕ�������
						System.out.println(len);//�Ի����˳���û����ÿ���ɾ��
						if(len.length()>8){//�ж������ַ�
							j++;//�ж������ַ���
							g.append(c[i]);//��  ƴ��		
							System.out.println("ƴ��  "+g);//�Ի����˳���û����ÿ���ɾ��
							while(i == c.length-1){
								String gg= new String(g); //StringButter��Stringת��	
								m[n]=gg;
								System.out.println("n�ı�ǰ"+n);//�Ի����˳���û����ÿ���ɾ��, �����Ƿ���븴�������Ԥ������
								System.out.println("Ԥ������  "+m[n]);//�Ի����˳���û����ÿ���ɾ��, �����Ƿ���븴�������Ԥ������
								n=n+1;
								System.out.println("n�ı��"+n);
								i++;//��ѭ��ֻ��һ�Σ�ע�������������һ�μӺ� �������������ֵ ����û�£�
								g=new StringBuilder();// ��Ҫ��g��ʼ������֪�������ɲ����ԣ��ǲ���ָ�����µĵط���
							}
						}

					

//ä����
				if(j>10){
						t1.append("��������̫���ˣ��ף�"+"\n\t"+h[random.nextInt(k.length)]+"\n");					
				}else if(j>5 && j<10){				
						t1.append("��̫���ˣ��ף�"+"\n\t"+k[random.nextInt(k.length)]+"\n");
				}	

				}
				
					if(jk%3==0){//�ؼ��ֲ���

						char[] arr1=m[n-1].toCharArray();//�ѵ��������ʲ��ȴ����ڼӵ�
							System.out.println("���� ������ⳤ�ȣ�"+ arr1.length);//����
						char[] arr2=m[n-2].toCharArray();//�ѵڶ������ʲ�
						char[] arr3=m[n-3].toCharArray();//�ѵ�һ�����ʲ�

						int[] text=new int[arr1.length];//��ȡ�ؼ�������
						
						{//���йؼ���λ�ӣ�������text����

							for(int	ii=0 ; ii<arr1.length ; ii++){//�жϸ����ַ����ִ���	
								for(int Jj=0 ; Jj<arr2.length ; Jj++ ){
									if(arr1[ii] == arr2[Jj]){
										text[ii]+=1;
										System.out.println("����"+arr1[ii]+"  λ�õ�"+ii+"��������:"+text[ii]);
									}
								}
								for(int k=0 ; k<arr3.length ; k++ ){
									if(arr1[ii] == arr3[k]){
										text[ii]+=1;
										System.out.println("����"+arr1[ii]+"  λ�õ�"+ii+"��������:"+text[ii]);
									}
								}
							}

						}//���йؼ���λ�ӣ�������text����


						{//��ȡ�ؼ���


							int d=0;//�ؼ���λ��
							int Ee=text[1];//��¼�������ÿ�����Ĵ�����Ŀ����ȡ�ؼ���λ��
							int ff=1;//�ؼ��ֳ���

							for( int Ii=1;Ii<arr1.length; Ii++){//�жϹؼ���λ��
								if(Ee < text[Ii]){
									Ee=text[Ii];
									d=Ii;
								}
							}
							System.out.println("�ؼ��ֿ�ͷλ��"+d);//���Թؼ��ֿ�ͷλ�ã��Ի����˳���û����ÿ���ɾ��
						
							if(text[d]==text[d+1]){
								System.out.println("��û�н����ж�");//������û�н����ж�
								ff+=1;
								d+=1;
							}
							System.out.println("�ؼ��ֳ��ȣ�"+ff);//���Թؼ��ֳ���λ�ã��Ի����˳���û����ÿ���ɾ��
							System.out.println("�ؼ��ֿ�ͷλ�ã�"+d);//���Թؼ��ֽ�βλ�ã��Ի����˳���û����ÿ���ɾ��

							String str=m[n-1].substring(d+1-ff,d+1);//��ȡ��ͷû�н�β
							System.out.println("�ؼ���"+str);
							

						}//��ȡ�ؼ�
/**���˰�����ȡ����**/

					}    //�ؼ��ֲ���

						System.out.println("���������ַ���"+j);//�Ի����˳���û����ÿ���ɾ��....
						System.out.println("����  "+s);//�Ի����˳���û����ÿ���ɾ��....

				}//�жϺ����ַ������������   ���ţ�Ŀ�ĵ�һ�μ��ٺ��֣���ȡ�ؼ��֣�
					

				String[] arr=s.split("��");//���ĵĶ���,���ڻش���"��"����������
				for(int i=0 ; i<arr.length ; i++){
				if(arr[i].equals(f[0]))
					t1.append(arr[i]+"\n\t"+bb[random.nextInt(bb.length)]+"\n");//append�����ַ�����ӡ��JTextArea��
				else if(arr[i].equals(f[1]))
					t1.append(arr[i]+"\n\t"+cc[random.nextInt(bb.length)]+"\n");
				else if(arr[i].equals(f[2]))
					t1.append(arr[i]+"\n\t"+dd[random.nextInt(bb.length)]+"\n");
				else
					t1.append(arr[i]+"\n\t��ʲô����֪����'#.#��!\n");
					jk+=1;//������û���ش�ʱ�������иó��򣬹ʿ���������¼����
				}

			}//Ӧ������
		}
	}	
}