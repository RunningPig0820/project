import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class MySQL3{
	private Connection conn = null;
	PreparedStatement statement = null;
	static String string ; //词库匹配（tici)和答案匹配（pailei）
	static int COUNT = 0 ;//判断是未知答案 
	
	void setCOUNT(){
		COUNT = COUNT + 1 ;
	}

	public int getCOUNT(){
		return this.COUNT;	
	}

	//connect to MySQL
	void connSQL() {
		String url = "jdbc:mysql://localhost:3306/jiqiren?characterEncoding=gbk";
		String username = "root";
		String password = "123"; // 加载驱动程序以连接数据库 
		try { 
			Class.forName("com.mysql.jdbc.Driver" ); 
			conn = DriverManager.getConnection( url,username, password ); 
			}
		//捕获加载驱动程序异常
		 catch ( ClassNotFoundException cnfex ) {
			 System.err.println(
			 "装载 JDBC/ODBC 驱动程序失败。" );
			 cnfex.printStackTrace(); 
		 } 
		 //捕获连接数据库异常
		 catch ( SQLException sqlex ) {
			 System.err.println("无法连接数据库");
			 sqlex.printStackTrace(); 
		 }
	}

	// disconnect to MySQL
	void deconnSQL() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("关闭数据库问题 ：");
			e.printStackTrace();
		}
	}		
	
	ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	boolean insertSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("插入数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("插入时出错：");
			e.printStackTrace();
		}
		return false;
	}

	// show data in ju_users
	void layoutStyle1(ResultSet rs , String str){
		try{
			Random random=new Random();
			String[] strs  = new String[20];	
			int ii = 0 ;
			
			while(rs.next()){
				if(rs.getString("wenti").equals(str)){
					System.out.println("MySQL的问题 : " + rs.getString("wenti"));
					System.out.println("MySQL的答案 : " + rs.getString("daan"));
					strs[ii] = rs.getString("daan") ;
					ii++  ;
					setCOUNT();
					string = "true" ;//答案是否匹配（pailie）
					System.out.println(getCOUNT());
				}
			}

			if( ii != 0){
				System.out.println(ii);
				jiqiren2.t1.append("   "+str + " :" + "\n\t"+strs[Math.abs(random.nextInt())%ii]+"\n");
				System.out.println("ii + "+ii);
			}
			
		}catch(SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
	}

	void layoutStyle2(ResultSet rs ,ResultSet rs1 ,String str){
		try {
			while(rs.next()){
				if(rs.getString("ciyu").equals(str)){
					System.out.println("MySQL的问题 : " + rs.getString("ciyu"));
					string = "true";//词库匹配（tici）
					layoutStyle1(rs1,str);
				}										
			}			
		}catch(SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
	}

}
