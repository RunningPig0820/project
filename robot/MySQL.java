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
		String password = "123"; // ���������������������ݿ� 
		try { 
			Class.forName("com.mysql.jdbc.Driver" ); 
			conn = DriverManager.getConnection( url,username, password ); 
			}
		//����������������쳣
		 catch ( ClassNotFoundException cnfex ) {
			 System.err.println(
			 "װ�� JDBC/ODBC ��������ʧ�ܡ�" );
			 cnfex.printStackTrace(); 
		 } 
		 //�����������ݿ��쳣
		 catch ( SQLException sqlex ) {
			 System.err.println("�޷��������ݿ�");
			 sqlex.printStackTrace(); 
		 }
	}

	// disconnect to MySQL
	void deconnSQL() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("�ر����ݿ����� ��");
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
			System.out.println("�������ݿ�ʱ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ����");
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
			System.out.println("�������ݿ�ʱ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ����");
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
			System.out.println("�������ݿ�ʱ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ����");
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
			System.out.println("��ʾʱ���ݿ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��ʾ����");
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		MySQL ms = new MySQL() ;
		ms.connSQL();//��λ
		ResultSet resultSet = ms.selectSQL("��");
		ms.layoutStyle2(resultSet);	
		ms.deconnSQL();
	}
}
