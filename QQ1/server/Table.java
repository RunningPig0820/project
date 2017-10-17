package server;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;


public class Table extends JPanel{
	
	private String tableHeads[] = {"QQ", "ip", "main_port", "sys_port"};
	
	private String tableContent[][] = { 
		{ "efg", "hij", "klm", "nop" },
		{ "tuv", "wxy", "zab", "cde" },
		{ "ijk", "lmn", "opq", "rst" }
	};

	
	public Table(){
		
		setLayout(new GridLayout(1,6));
		
		JTable table = new JTable(tableContent,tableHeads); 

		JScrollPane jspCenter = new JScrollPane(table);

		add(jspCenter);
	}
}