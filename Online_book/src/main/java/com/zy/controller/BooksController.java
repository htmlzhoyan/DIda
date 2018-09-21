package com.zy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.zy.entity.Books;
import com.zy.entity.OrderBook;
import com.zy.service.IBooksService;
import com.zy.utils.JsonUtils;
import com.zy.vo.JsonBean;

@Controller
public class BooksController {
	@Autowired
	private IBooksService booksService;
	
	@RequestMapping(value="/findGoods",method=RequestMethod.GET)
	@ResponseBody
	public JsonBean findGoods() {
		List<Books> findBook = booksService.findBook();
		
		return JsonUtils.createJsonBean(1, findBook);	
		
	}
	
	@RequestMapping("/queryGradeGoods")
	@ResponseBody
	public JsonBean getSlideMenu(){
		return JsonUtils.createJsonBean(1, null);	
	}
	
	@RequestMapping(value="/findOrder",method=RequestMethod.GET)
	@ResponseBody
	public JsonBean findOrder(){
		List<OrderBook> findBook = booksService.findOder("zy");
		return JsonUtils.createJsonBean(1, findBook);	
	}
	
	
	
}
