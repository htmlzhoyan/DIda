package com.zy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.IUserDao;
import com.zy.entity.User;
import com.zy.service.IUserService;
@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	@Override
	public User findUserbyName(String name) {
		// TODO Auto-generated method stub
		User findAllUser = userDao.findAllUser(name);
		return findAllUser;
	}
	@Override
	public void register(User user) {
		userDao.registerUser(user);;	
	}

}
