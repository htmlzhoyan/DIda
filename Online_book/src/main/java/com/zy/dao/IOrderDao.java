package com.zy.dao;

import java.util.List;

import com.zy.entity.Books;
import com.zy.entity.Order;

public interface IOrderDao {
	public List<Order> findAllOrder();
	public void insertInto(Order order);
}
