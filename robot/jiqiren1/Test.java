public class Test{
    public static void main(String[] args) {
	long startMili=System.currentTimeMillis();// ��ǰʱ���Ӧ�ĺ�����
	System.out.println("��ʼ "+startMili);
	// ִ��һ�δ���,��һ��������ֵ
	for(int i=0;i<1000000;i++){
	    Math.random();
	}
	long endMili=System.currentTimeMillis();
	System.out.println("���� s"+endMili);
	System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
    }
}