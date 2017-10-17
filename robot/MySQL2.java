import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL2{
	private Connection conn = null;
	PreparedStatement statement = null;
	String string ; //�ж��Ƿ��д����

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

	// show data in ju_users
	void layoutStyle2(ResultSet rs , String str){
		try {
			while(rs.next()){
				if(rs.getString("ciyu").equals(str)){
					System.out.println("MySQL������ : " + rs.getString("ciyu"));
					string = str;
				}										
			}			
		}catch(SQLException e) {
			System.out.println("��ʾʱ���ݿ����");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("��ʾ����");
			e.printStackTrace();
		}
	}

/*
	public static void main(String[] args){ 

		MySQL2 ms = new MySQL2() ;
		ms.connSQL();//��λ
		String Sql = "select * from fenci WHERE ciyu = '��'" ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ms.layoutStyle2(resultSet,Sql);	
		ms.deconnSQL();

		MySQL2 ms = new MySQL2() ;
		ms.connSQL();//��λ
		String Sql = "select * from fenci" ;
		ResultSet resultSet = ms.selectSQL(Sql);
		ms.layoutStyle2(resultSet," ");
		ms.deconnSQL();
	}
*/

}
