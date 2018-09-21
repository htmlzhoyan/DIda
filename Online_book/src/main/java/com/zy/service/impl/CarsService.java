package com.zy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zy.dao.ICarDao;
import com.zy.entity.Car;
import com.zy.service.ICarService;

@Service
public class CarsService implements ICarService {
	@Autowired
	private ICarDao cardao;
	@Override
	public void inserIntoCar(String dataid,String datanum) {
		// TODO Auto-generated method stub
		List<Car> list = new ArrayList<>();
		String[] ids = dataid.split(",");
		String[] inum = datanum.split(",");
		
		for (int i = 0; i < ids.length; i++) {
			Car car = new Car();
			car.setBid(Integer.valueOf(ids[i]));
			car.setNum(Integer.valueOf(inum[i]));
			list.add(car);
		}
		
		cardao.insertCar(list);
		
	}
	@Override
	public List<Car> findAllCarsService() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String username = (String) request.getSession(false).getAttribute("user");
		return cardao.findAllCars(username);
	}

}
