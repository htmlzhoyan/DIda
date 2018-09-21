package com.zy.service;

import com.zy.entity.User;

public interface IUserService {
	public User findUserbyName(String name);
	public void register(User user);
}
