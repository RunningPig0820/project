import java.util.ArrayList;  
import java.util.List;  
  
  
public class Segmentation1 { 
	
    private List<String> dictionary = new ArrayList<String>();//以链表存储词典  
    private String request = "北京大学生前来应聘"; 
      
    public void setDictionary() {//词典  
        dictionary.add("北京");  
        dictionary.add("北京大学");  
        dictionary.add("大学");  
        dictionary.add("大学生");  
        dictionary.add("生前");  
        dictionary.add("前来");  
        dictionary.add("应聘");  
    }  
      
    public String leftMax() {  
        String response = "";  
        String s = "";  
		for(int i=0; i<request.length(); i++) {  		  
            s += request.charAt(i);  
            if(isIn(s, dictionary) && aheadCount(s, dictionary)==1) {  
                response += (s + "\n");  
                s = "";  
            } else if(aheadCount(s, dictionary) > 0) {  
                  
            } else {  
                response += (s + "\n");  
                s = "";  
            }  
        }  
        return response;  
    }  
      
    private boolean isIn(String s, List<String> list) {  //是否与词典相匹配
        for(int i=0; i<list.size(); i++) {  
            if(s.equals(list.get(i)))
				return true;  
        }  
        return false;  
    }  
      
    private int aheadCount(String s, List<String> list) {  //
        int count = 0;  
        for(int i=0; i<list.size(); i++) {  
            if((s.length()<=list.get(i).length()) && 
				(s.equals(list.get(i).substring(0, s.length()))))
				count ++ ;  
        }  
        return count;  
    }  
      
    public static void main(String[] args) {  
        Segmentation1 seg = new Segmentation1();  
        seg.setDictionary();  
        String response1 = seg.leftMax();  
        System.out.println(response1);  
    }  
}  
