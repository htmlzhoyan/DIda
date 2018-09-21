package com.zy.dao;

import java.util.List;


import com.zy.entity.OrderBook;

public interface IOrderBook {
	
	public List<OrderBook> findAllOrder(String username);
	public void insertIntoOrder(OrderBook orderBook);
	
}
