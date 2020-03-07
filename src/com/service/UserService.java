package com.service;

import com.po.User;

public interface UserService {
	public User findUser(String usercode,String password);
	public int register(User user);
	public Integer findByCode(User user);
}
