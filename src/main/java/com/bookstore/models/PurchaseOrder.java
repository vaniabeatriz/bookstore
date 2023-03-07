package com.bookstore.models;

public class PurchaseOrder {
	private int id;
	private float total_amount;
	private User user;
	
	public PurchaseOrder(int id, float total_amount, User user) {
		super();
		this.id = id;
		this.total_amount = total_amount;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", total_amount=" + total_amount + ", user=" + user + "]";
	}
}
