package com.mycompany.model;
import java.util.Date;

public class Book {

    
	private int id;
	private String title;
	private String author;
	private String description;
	private int price;
	private int isbn;	
	private Date createDate = new Date();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", bookTitle=" + title + ", authorName=" + author + ", bookDescription=" + description + ", bookPrice=" + price + ", isbn=" + isbn + ", createDate=" + createDate + '}';
    }

}
