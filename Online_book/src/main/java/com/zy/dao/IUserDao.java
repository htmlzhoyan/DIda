package com.zy.dao;

import com.zy.entity.User;

public interface IUserDao {
	public User findAllUser(String name);
	public void registerUser(User user);
}
