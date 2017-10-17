public ArrayList<ciBean> startBack(String atemp){
	int a = 0;
	ciBean ci;
	ArrayList<ciBean> ciBeans = new ArrayList<ciBean>();
	String temp = "0";
	for(int j = 0;j<atemp.length();j++){
		 for(int i=0;i<atemp.length();i++) {
			//System.out.println(temp);
			temp = atemp.substring(i); // 每次从字符串的首部截取一个字，并存到temp中
			ci = jihe(temp);
			if(ci.getd()){
				atemp =atemp.replace(temp, "");
				ciBeans.add(ci);
				i = -1;// i=-1重新查找， 而要先执行循环中的i++
			} 
		 }
		if(null != atemp && !"".equals(atemp))
		atemp = atemp.substring(0,atemp.length()-1);
	}return ciBeans;
}
