package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.po.User;
import com.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	//ͨ���˺ź������ѯ�û�
	@Override
	public User findUser(String usercode, String password) {
		User user = this.userDao.findUser(usercode, password);
		return user;
	}

	@Override
	public int register(User user) {
		return userDao.register(user);
	}

	@Override
	public Integer findByCode(User user) {
		System.out.println("com.service.impl.UserServiceImpl.findByCode---------1-----------");
		return userDao.findByCode(user);
	}

}
