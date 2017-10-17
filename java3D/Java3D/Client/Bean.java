import java.io.Serializable;


public class Bean implements Serializable{
	
	private static final long serialVersionUID=7981560250804078637l; 
			
	private Simple_Group group ;
	
	public void setSimple_Group(Simple_Group group){
		this.group = group;
	}
	
	public Simple_Group getSimple_Group(){
		return group;
	}

} 