package model;

import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable{
	private String id;
	private String name;
	private float price;
	private Category category;
	private Publisher publisher;
	private Author author;
	
	public Book() {
		
	}
	public Book(String id, String name, float price, Category category, Publisher publisher, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.publisher = publisher;
		this.author = author;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
