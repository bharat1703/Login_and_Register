package com.prasad.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.Dao.UserDao;
import com.prasad.Model.User;
import com.prasad.Service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User loginUser(User user) {
	System.out.println("hi aim from service"+user);
	User loginUser=userDao.loginUser(user);
		return loginUser;
	}

}
