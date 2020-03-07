package com.dao;
import org.apache.ibatis.annotations.Param;
import com.po.User;

public interface UserDao {
	/**
	 * 通过账号和密码查询用户
	 */
	public User findUser(@Param("usercode") String usercode,
						@Param("password") String password);
	/**
	 * 增加通过用户id，用户名和密码进行注册的功能
	 */
	public int register(User user);
	/**
	 * 验证要注册的用户是否存在数据库中
	 */
	public Integer findByCode(User user);
	
}