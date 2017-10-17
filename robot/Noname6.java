public class mandabiao{
	try{
		int i = 0 ;
		FileReader reader = new FileReader("E://1.txt");
		BufferedReader br = new BufferedReader(reader);         
		String   strs ;
		String[] str  = new String[100];
		while((strs = br.readLine()) != null){									
			str[i] = strs ;
			i++ ;
		} 
		reader.close();			
		Random random=new Random();
		System.out.println(str[Math.abs(random.nextInt())%i]);

	}catch(IOException e){
		System.out.println("File read error : " + e);
	}catch(Exception e){
		System.out.println(e);
	}
}
