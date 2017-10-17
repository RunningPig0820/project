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
	static String string ; //�ʿ�ƥ�䣨tici)�ʹ�ƥ�䣨pailei��
	static int COUNT = 0 ;//�ж���δ֪�� 
	
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
			System.out.println("�������ݿ�ʱ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ����");
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
					System.out.println("MySQL������ : " + rs.getString("wenti"));
					System.out.println("MySQL�Ĵ� : " + rs.getString("daan"));
					strs[ii] = rs.getString("daan") ;
					ii++  ;
					setCOUNT();
					string = "true" ;//���Ƿ�ƥ�䣨pailie��
					System.out.println(getCOUNT());
				}
			}

			if( ii != 0){
				System.out.println(ii);
				jiqiren2.t1.append("   "+str + " :" + "\n\t"+strs[Math.abs(random.nextInt())%ii]+"\n");
				System.out.println("ii + "+ii);
			}
			
		}catch(SQLException e) {
			System.out.println("��ʾʱ���ݿ����");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("��ʾ����");
			e.printStackTrace();
		}
	}

	void layoutStyle2(ResultSet rs ,ResultSet rs1 ,String str){
		try {
			while(rs.next()){
				if(rs.getString("ciyu").equals(str)){
					System.out.println("MySQL������ : " + rs.getString("ciyu"));
					string = "true";//�ʿ�ƥ�䣨tici��
					layoutStyle1(rs1,str);
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

}
