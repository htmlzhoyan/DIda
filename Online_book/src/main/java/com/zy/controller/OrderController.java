package com.zy.controller;

import java.util.ArrayList;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.zy.entity.Car;

import com.zy.service.ICarService;
import com.zy.service.IOrderService;
import com.zy.utils.JsonUtils;

import com.zy.vo.JsonBean;

@Controller
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value="/addOrder",method=RequestMethod.POST)
	@ResponseBody
	public JsonBean findGoods(String datid) {
		orderService.addOrderService(datid);
		return JsonUtils.createJsonBean(1, null);	
	
	}

	
	
}
