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
import com.zy.utils.JsonUtils;

import com.zy.vo.JsonBean;

@Controller
public class CarController {
	@Autowired
	private ICarService carService;
	
	@RequestMapping(value="/insertCar",method=RequestMethod.POST)
	@ResponseBody
	public JsonBean findGoods(String dataid,String datanum) {
		carService.inserIntoCar(dataid,datanum);
		return JsonUtils.createJsonBean(1, null);	
	
	}
	
	@RequestMapping(value="/findAllCar",method=RequestMethod.GET)
	@ResponseBody
	public JsonBean findAllCar() {
		List<Car> findAllCarsService = carService.findAllCarsService();
		return JsonUtils.createJsonBean(1, findAllCarsService);	
	}
	
	
}
