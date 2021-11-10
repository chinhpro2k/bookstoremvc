package model;

public class Publisher {
	private String id;
	private String name;
	private String desc;
	private String type;
	private String location;
	
	public Publisher(String id) {
		this.id = id;
	}
	
	public Publisher(String id, String name, String desc, String type, String location) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.type = type;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
