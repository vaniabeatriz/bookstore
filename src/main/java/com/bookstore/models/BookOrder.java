package com.bookstore.models;

public class BookOrder {
	private int id;
	private Book book;
	private PurchaseOrder purchaseOrder;
	private float amount;
	
	public BookOrder(int id, Book book, PurchaseOrder purchaseOrder, float amount) {
		super();
		this.id = id;
		this.book = book;
		this.purchaseOrder = purchaseOrder;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BookOrder [id=" + id + ", book=" + book + ", purchaseOrder=" + purchaseOrder + ", amount=" + amount
				+ "]";
	}
}
