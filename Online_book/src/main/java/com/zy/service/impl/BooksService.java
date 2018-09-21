package com.zy.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zy.dao.IBooksDao;
import com.zy.dao.IOrderBook;
import com.zy.entity.Books;
import com.zy.entity.OrderBook;
import com.zy.service.IBooksService;
@Service
public class BooksService implements IBooksService {
	@Autowired
	private IBooksDao booksDao;
	@Autowired
	private IOrderBook orderBook;
	@Override
	public List<Books> findBook() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<Books> books = null;
		String username = (String) request.getSession(false).getAttribute("user");
		books = booksDao.findAllBooks(username);
		return books;
	}

	@Override
	public List<OrderBook> findOder(String username) {
		// TODO Auto-generated method stub
		return orderBook.findAllOrder(username);
	}

}
