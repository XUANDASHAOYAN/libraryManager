/*完成最基本的数据库操作，包括加载jdbc驱动、建立数据库连接、执行sql查询以及操作语句、关闭 数据库连接
 * */

package db;
import java.sql.*;
public class BaseDao {
	protected static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	protected static String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=tsgl";
	protected static String dbUser = "sa";
	protected static String dbPwd = "gao42134";
	private static Connection conn = null;
	//连接到数据库
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
	//执行数据库查询操作，执行成功返回结果集
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
	//执行数据库更新操作，未执行成功返回-1
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
	//关闭连接
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
