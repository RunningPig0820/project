import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL{
	private Connection conn = null;
	PreparedStatement statement = null;

	// connect to MySQL
	void connSQL() {
		String url = "jdbc:mysql://localhost:3306/jiqiren?characterEncoding=UTF-8";
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

	// execute selection language
	ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			String chaxun  = "SELECT * FROM yingdaku WHERE wenti = ?";
			statement = conn.prepareStatement(chaxun);
			statement.setString(1,sql);
			rs = statement.executeQuery(chaxun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// execute insertion language
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
	//execute delete language
	boolean deleteSQL(String sql) {
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
	//execute update language
	boolean updateSQL(String sql) {
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
	void layoutStyle2(ResultSet rs){
		try {
			while(rs.next()) {
				System.out.println("MySQL : " + rs.getInt("wenti"));
				System.out.println("MySQL : " + rs.getInt("daan"));
			//	jiqiren.t1.append(rs.getInt("wenti")+"\n\t"+rs.getInt("daan")+"\n");
			}
		} catch (SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		MySQL ms = new MySQL() ;
		ms.connSQL();//座位
		ResultSet resultSet = ms.selectSQL("好");
		ms.layoutStyle2(resultSet);	
		ms.deconnSQL();
	}
}
