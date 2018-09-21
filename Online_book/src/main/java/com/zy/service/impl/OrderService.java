package com.zy.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zy.dao.IBooksDao;
import com.zy.dao.ICarDao;
import com.zy.dao.IOrderBook;
import com.zy.dao.IOrderDao;
import com.zy.entity.Books;
import com.zy.entity.Car;
import com.zy.entity.Order;
import com.zy.entity.OrderBook;
import com.zy.service.IOrderService;
import com.zy.utils.StringUtils;
@Service
public class OrderService implements IOrderService{
	@Autowired
	private IOrderBook orderBook;
	
	@Autowired
	private IOrderDao orderDao;
	
	@Autowired
	private ICarDao cardao;
	
	@Autowired
	private IBooksDao booksDao;
	
	@Override
	public void addOrderService(String datid) {
		
		String[] ids = datid.split(",");
		for (String id : ids) {
			Integer idNum = Integer.valueOf(id);
			Order order = new Order();
			OrderBook orderBookAll = new OrderBook();
			
			
			Integer orderCode = Integer.valueOf(String.valueOf(new Date().getTime()));
			
			order.setOid(orderCode);
			HttpSession session= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			String username =  (String) session.getAttribute("user");
			order.setUsername(username);
			orderDao.insertInto(order);
			
			Car car = cardao.findCarsById(idNum);
			Books books = booksDao.findBooksByName(car.getBid());
			orderBookAll.setOid(orderCode);
			orderBookAll.setCount(car.getNum());
			orderBookAll.setBid(car.getBid());
			orderBookAll.setCreatedate(String.valueOf(new Date().getTime()));
			orderBookAll.setPrice(books.getbPrice());
			orderBookAll.setState(0);
			
			 
			String totalPrice = String.valueOf((Double.valueOf(books.getbPrice()))*(Integer.valueOf(car.getNum()))); 
			
			orderBookAll.setTotal_price(totalPrice);
			orderBook.insertIntoOrder(orderBookAll);
		}
		
		
		
	}

}
