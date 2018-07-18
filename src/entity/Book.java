package entity;
import java.sql.*;
//Book类
public class Book {
	private String id; //图书编号
	private String name; //图书名称
	private String type; //类型
	private String author;//作者
	private String translator;//译者
	private String publisher;//出版社
	private Date publish_time;//出版日期
    private int stock;//库存数量
    private double price;//图书价钱
    
    public void setID(String id) {
    	this.id = id;
    }
    public String getID() {
    	return id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return name;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    public String getType() {
    	return type;
    }
    
    public void setAuthor(String author) {
    	this.author = author;
    }
    public String getAuthor() {
    	return author;
    }
    
    public void setTranslator(String translator) {
    	this.translator = translator;
    }
    public String getTranslator() {
    	return translator;
    }
    
    public void setPublisher(String publisher) {
    	this.publisher = publisher;
    }
    public String getPublisher() {
    	return publisher;
    }
    
    public void setPublish_time(Date publish_time) {
    	this.publish_time = publish_time;
    }
    public Date getPublish_time() {
    	return publish_time;
    }
    
    public void setStock(int stock) {
    	this.stock = stock;
    }
    public int getStock() {
    	return stock;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
    public double getPrice() {
    	return price;
    }
}
