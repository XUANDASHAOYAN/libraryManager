package db;
/*�Զ�����Ϣ�������ݿ����*/
import entity.Reader;
import java.sql.*;
import java.util.*;

public class ReaderDao {
	//���ݶ��߱��,��õ�������ʵ��
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
	//���ݶ��߱�ţ���ö����б�
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
