/*对图书信息进行数据库操作*/
package db;
import entity.Book;
import java.sql.*;
import db.BaseDao;
import java.util.*;

public class BookDao {
	//根据图书编号，获得图书实体book
	public static Book selectBook(String id) {
		String sql = "select *  from book where id = '"+id+"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		Book book = null;
		try {
			if(rs.next()) {
				book = new Book();
				book.setID(rs.getString("id"));
				book.setName(rs.getString("name"));
				book.setType(rs.getString("type"));
			    book.setAuthor(rs.getString("author"));
			    book.setTranslator(rs.getString("translator"));
			    book.setPublisher(rs.getString("publisher"));
			    book.setPublish_time(rs.getDate("publish_time"));
			    book.setStock(rs.getInt("stock"));
			    book.setPrice(rs.getDouble("price"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return book;
	}
	//根据图书编号，获得图书列表
	public static List<Book> selectBookList(String sql) {
		List<Book> list = new ArrayList<Book>();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while(rs.next()) {
				Book book = new Book();
				book.setID(rs.getString("id"));
			    book.setName(rs.getString("name"));
			    book.setType(rs.getString("type"));
		        book.setAuthor(rs.getString("author"));
		        book.setTranslator(rs.getString("translator"));
		        book.setPublisher(rs.getString("publisher"));
		        book.setPublish_time(rs.getDate("publish_time"));
		        book.setStock(rs.getInt("stock"));
		        book.setPrice(rs.getDouble("price"));
		        list.add(book);
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}
