package com.zy.service;

import java.util.List;

import com.zy.entity.Car;

public interface ICarService {
	public void inserIntoCar(String dataid,String datanum);
	public List<Car> findAllCarsService();
	
}
