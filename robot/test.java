import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test{
	private Connection conn = null;
	PreparedStatement statement = null;

	// connect to MySQL
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
	void deconnSQL(){
		try{
			if (conn != null)
				conn.close();
		}catch (Exception e) {
			System.out.println("关闭数据库问题 ：");
			e.printStackTrace();
		}
	}

	// execute selection language
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

	// show data in ju_users
	boolean layoutStyle2(ResultSet rs , String str){
		try {
			while(rs.next()){
				if(rs.getString("ciyu").equals(str)){
					System.out.println("MySQL的问题 : " + rs.getString("ciyu"));
					deconnSQL();
					System.out.println("关闭数据库问题 ：1");
					return true;
				}	
			}
		}catch(SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
		deconnSQL();
		System.out.println("关闭数据库问题 ：2");
		return false;
	}

/*
	public static void main(String[] args){
		MySQL1 ms = new MySQL1() ;
		ms.connSQL();//座位
		String Sql = "select * from fenci"   ;
	//	String Sql = "select * from fenci WHERE ciyu = '好'" ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ms.layoutStyle2(resultSet,"我们是共产主义接班人");	
		ms.deconnSQL();
	}
*/
 
}
