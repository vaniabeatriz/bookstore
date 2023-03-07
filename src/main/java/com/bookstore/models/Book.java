package com.bookstore.models;

public class Book {
	private int id;
	private String title;
	private String author;
	private float price;
	private String summary;
	private String isbn;
	
	public Book(int id, String title, String author, float price, String summary, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.summary = summary;
		this.isbn = isbn;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", summary="
				+ summary + ", isbn=" + isbn + "]";
	}
	
	
	
}
