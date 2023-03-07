package com.bookstore.daos;

public interface OrderDAO {
	
	public void findAllOrdersByUserId(int userId);
	public void createOrder();


}
