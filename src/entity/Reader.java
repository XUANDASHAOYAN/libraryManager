package entity;

public class Reader {
	private String id;
	private String name;
	private String type;
	private String sex;
	private int max_num;
	private int days_num;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
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
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	
	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}
	public int getMax_num() {
		return max_num;
	}
	
	public void setDays_num(int days_num) {
		this.days_num = days_num;
	}
	public int getDays_num() {
		return days_num;
	}
}
