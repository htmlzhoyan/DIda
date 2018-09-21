package com.zy.dao;

import java.util.List;

import com.zy.entity.Car;

public interface ICarDao {
	public void insertCar(List<Car> list);
	public List<Car> findAllCars(String username);
	public Car findCarsById(Integer id);
}
