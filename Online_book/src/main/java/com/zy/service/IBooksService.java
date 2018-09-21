package com.zy.service;

import java.util.List;

import com.zy.entity.Books;
import com.zy.entity.OrderBook;

public interface IBooksService {
	public List<Books> findBook();
	public List<OrderBook> findOder(String username);
}
