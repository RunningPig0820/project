//字符变成字符串在网上找了半天，竟然在jdk第一页。。。。
//这里用的是把字符用StringBuilder的append方法在把它改到String，好麻烦

//问题：是问题中必须要有汉字

//寻找关键字也，长度为2

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class 例子 extends JFrame{
	private JTextField text1;
	private JTextArea t1;//可以输入多行的文本框
	private JLabel lbl1,lbl2;

	public 例子(){
		super("文本框的文本区域测试程序");//引用父类，给文本框一个标题
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		lbl1=new JLabel("你想要问些什么呢？");
		c.add(lbl1);

		text1=new JTextField(25);
		c.add(text1);

		text1.addActionListener(new handler());//监听回车键
		String s="你好，我是吼吼机器人\n";

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
		String len="";//判断复杂问题长度
		//int j=0; 不能用全局变量不然当 判断的话会一直变大 
		int n=0;  //这里需要一个全局变量负者记录预备数组的位置;
		int nn=0;//需要一个全局变量记录问题次序的位置
		int jk=1; //为了保证预备数组有3次不可以取0，目的保证jk=0时
		String bb[]={"你也好","我不好","你开心就好","你想干嘛"};//回答你好（应答区域）
		String cc[]={"我是吼吼机器人","朋友家的孩子","你猜猜","吼吼"};//回答你是谁（应答区域）
		String dd[]={"你又是谁？","那你是谁","你先说","恩？"};//回答你是谁？（应答区域）
		String f[]={"你好","你是谁","你是谁？"};//问题区

		StringBuilder g=new StringBuilder();//为了帮助加到预备数组
		String[] m=new String[100];//为了解决复杂问题的预备数组    目的：不断存放复杂问题和诱导问题为了匹配出关键字
		
		
		String h[]={"原谅吼吼我的无知，请大侠简化问题 （*?.?*）",
			"脑袋要爆了,请向我脑袋要少装点信息（*‘_’*）",
			"对于小学水平的我，主人忍心问出怎么难的文体吗？\\(*-_-*)/"};//（盲答器）
		String k[]={"简化再简化 d====(- 。-*)b",
				"愿君是慎言 o(-.-)d",
				"要简约美,不懂吼吼的话吗 (~~ - .-)~~"};//（盲答器）
		


		public void actionPerformed(ActionEvent e){	
				int j=0;
				s=text1.getText();		
			{//应答括号
				
			
				{//判断汉字字符输入多少 括号(目的第一次减少汉字，提取关键字)
					if(s.length()>10)//对程序没多大用可以删掉.......

						System.out.println("该字符串大于10");//对机器人程序没多大用可以删掉
						char[] c=s.toCharArray();//把字符串变成字符数组，把字符串分割了

					for(int i=0;i<c.length;i++){
						len=Integer.toBinaryString(c[i]);//只是二进制数
						System.out.println(len);//对机器人程序没多大用可以删掉
						if(len.length()>8){//判断中文字符
							j++;//判断中文字符数
							g.append(c[i]);//逐步  拼接		
							System.out.println("拼接  "+g);//对机器人程序没多大用可以删掉
							while(i == c.length-1){
								String gg= new String(g); //StringButter与String转化	
								m[n]=gg;
								System.out.println("n改变前"+n);//对机器人程序没多大用可以删掉, 测试是否存入复杂问题的预备数组
								System.out.println("预备数组  "+m[n]);//对机器人程序没多大用可以删掉, 测试是否存入复杂问题的预备数组
								n=n+1;
								System.out.println("n改变后"+n);
								i++;//让循环只做一次（注：这样会多运行一次加号 这里正好是最大值 所以没事）
								g=new StringBuilder();// 需要把g初始化（不知道这样可不可以，是不是指向了新的地方）
							}
						}

					

//盲答器
				if(j>10){
						t1.append("问题字数太多了，亲："+"\n\t"+h[random.nextInt(k.length)]+"\n");					
				}else if(j>5 && j<10){				
						t1.append("字太多了，亲："+"\n\t"+k[random.nextInt(k.length)]+"\n");
				}	

				}
				
					if(jk%3==0){//关键字部分

						char[] arr1=m[n-1].toCharArray();//把第三次提问拆开先存入在加的
							System.out.println("测试 最后问题长度："+ arr1.length);//测试
						char[] arr2=m[n-2].toCharArray();//把第二次提问拆开
						char[] arr3=m[n-3].toCharArray();//把第一次提问拆开

						int[] text=new int[arr1.length];//提取关键字数组
						
						{//排列关键字位子，创建了text数组

							for(int	ii=0 ; ii<arr1.length ; ii++){//判断各个字符出现次数	
								for(int Jj=0 ; Jj<arr2.length ; Jj++ ){
									if(arr1[ii] == arr2[Jj]){
										text[ii]+=1;
										System.out.println("测试"+arr1[ii]+"  位置第"+ii+"个，出现:"+text[ii]);
									}
								}
								for(int k=0 ; k<arr3.length ; k++ ){
									if(arr1[ii] == arr3[k]){
										text[ii]+=1;
										System.out.println("测试"+arr1[ii]+"  位置第"+ii+"个，出现:"+text[ii]);
									}
								}
							}

						}//排列关键字位子，创建了text数组


						{//提取关键字


							int d=0;//关键字位置
							int Ee=text[1];//记录最后问题每个数的次数，目的提取关键字位置
							int ff=1;//关键字长度

							for( int Ii=1;Ii<arr1.length; Ii++){//判断关键字位置
								if(Ee < text[Ii]){
									Ee=text[Ii];
									d=Ii;
								}
							}
							System.out.println("关键字开头位置"+d);//测试关键字开头位置，对机器人程序没多大用可以删掉
						
							if(text[d]==text[d+1]){
								System.out.println("有没有进入判断");//测试有没有进入判断
								ff+=1;
								d+=1;
							}
							System.out.println("关键字长度："+ff);//测试关键字长度位置，对机器人程序没多大用可以删掉
							System.out.println("关键字开头位置："+d);//测试关键字结尾位置，对机器人程序没多大用可以删掉

							String str=m[n-1].substring(d+1-ff,d+1);//截取开头没有结尾
							System.out.println("关键字"+str);
							

						}//提取关键
/**少了把字提取出来**/

					}    //关键字部分

						System.out.println("共有中文字符："+j);//对机器人程序没多大用可以删掉....
						System.out.println("中文  "+s);//对机器人程序没多大用可以删掉....

				}//判断汉字字符输入输入多少   括号（目的第一次减少汉字，提取关键字）
					

				String[] arr=s.split("，");//中文的逗号,用于回答多个"，"隔开的问题
				for(int i=0 ; i<arr.length ; i++){
				if(arr[i].equals(f[0]))
					t1.append(arr[i]+"\n\t"+bb[random.nextInt(bb.length)]+"\n");//append（把字符串打印到JTextArea）
				else if(arr[i].equals(f[1]))
					t1.append(arr[i]+"\n\t"+cc[random.nextInt(bb.length)]+"\n");
				else if(arr[i].equals(f[2]))
					t1.append(arr[i]+"\n\t"+dd[random.nextInt(bb.length)]+"\n");
				else
					t1.append(arr[i]+"\n\t我什么都不知道（'#.#）!\n");
					jk+=1;//当问题没法回答时，会运行该程序，故可以用来记录次序
				}

			}//应答括号
		}
	}	
}