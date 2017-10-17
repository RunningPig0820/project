public class Test{
    public static void main(String[] args) {
	long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
	System.out.println("开始 "+startMili);
	// 执行一段代码,求一百万次随机值
	for(int i=0;i<1000000;i++){
	    Math.random();
	}
	long endMili=System.currentTimeMillis();
	System.out.println("结束 s"+endMili);
	System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
    }
}