public ArrayList<ciBean> startBack(String atemp){
	int a = 0;
	ciBean ci;
	ArrayList<ciBean> ciBeans = new ArrayList<ciBean>();
	String temp = "0";
	for(int j = 0;j<atemp.length();j++){
		 for(int i=0;i<atemp.length();i++) {
			//System.out.println(temp);
			temp = atemp.substring(i); // ÿ�δ��ַ������ײ���ȡһ���֣����浽temp��
			ci = jihe(temp);
			if(ci.getd()){
				atemp =atemp.replace(temp, "");
				ciBeans.add(ci);
				i = -1;// i=-1���²��ң� ��Ҫ��ִ��ѭ���е�i++
			} 
		 }
		if(null != atemp && !"".equals(atemp))
		atemp = atemp.substring(0,atemp.length()-1);
	}return ciBeans;
}
