package com.xiyou.BCS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiyou.BCS.dao.UserDAO;
import com.xiyou.BCS.model.User;
import com.xiyou.BCS.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public int insertUser(User user) {
		return userDAO.insertUser(user);
	}

}
