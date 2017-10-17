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
	void deconnSQL(){
		try{
			if (conn != null)
				conn.close();
		}catch (Exception e) {
			System.out.println("�ر����ݿ����� ��");
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
					System.out.println("MySQL������ : " + rs.getString("ciyu"));
					deconnSQL();
					System.out.println("�ر����ݿ����� ��1");
					return true;
				}	
			}
		}catch(SQLException e) {
			System.out.println("��ʾʱ���ݿ����");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("��ʾ����");
			e.printStackTrace();
		}
		deconnSQL();
		System.out.println("�ر����ݿ����� ��2");
		return false;
	}

/*
	public static void main(String[] args){
		MySQL1 ms = new MySQL1() ;
		ms.connSQL();//��λ
		String Sql = "select * from fenci"   ;
	//	String Sql = "select * from fenci WHERE ciyu = '��'" ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ms.layoutStyle2(resultSet,"�����ǹ�������Ӱ���");	
		ms.deconnSQL();
	}
*/
 
}
