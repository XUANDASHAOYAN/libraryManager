/*�������������ݿ��������������jdbc�������������ݿ����ӡ�ִ��sql��ѯ�Լ�������䡢�ر� ���ݿ�����
 * */

package db;
import java.sql.*;
public class BaseDao {
	protected static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	protected static String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=tsgl";
	protected static String dbUser = "sa";
	protected static String dbPwd = "gao42134";
	private static Connection conn = null;
	//���ӵ����ݿ�
	private BaseDao() {
		try {
			if(conn == null) {
				Class.forName(Driver);
			    conn = DriverManager.getConnection(url, dbUser, dbPwd);
			}
			else
				return;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//ִ�����ݿ��ѯ������ִ�гɹ����ؽ����
	public static ResultSet executeQuery(String sql) {
		try {
			if(conn==null)
				new BaseDao();
			Statement st = conn.createStatement();
			return st.executeQuery(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//ִ�����ݿ���²�����δִ�гɹ�����-1
	public static int executeUpdate(String sql) {
		try {
			if(conn==null) 
				new BaseDao();
			Statement st = conn.createStatement();
			return st.executeUpdate(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	//�ر�����
	public static void close() {
		try {
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			conn = null;
		}
	}
}
