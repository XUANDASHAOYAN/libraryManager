package db;
/*对读者信息进行数据库操作*/
import entity.Reader;
import java.sql.*;
import java.util.*;

public class ReaderDao {
	//根据读者编号,获得单个读者实体
	public static Reader selectReader(String id) {
		String sql = "select * from Reader where id = '"+id+"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		Reader reader = null;
		try {
			if(rs.next()) {
			reader = new Reader();
			reader.setId(rs.getString("id"));
			reader.setName(rs.getString("name"));
			reader.setType(rs.getString("type"));
			reader.setSex(rs.getString("sex"));
			reader.setMax_num(rs.getInt("max_num"));
			reader.setDays_num(rs.getInt("days_num"));
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return reader;
	}
	//根据读者编号，获得读者列表
	public static List<Reader> selectReaderList(String sql) {
		List<Reader> list = new ArrayList<Reader>();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while(rs.next()) {
				Reader reader = new Reader();
				reader.setId(rs.getString("id"));
				reader.setName(rs.getString("name"));
				reader.setType(rs.getString("type"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getInt("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
				list.add(reader);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}
