package com.dao;
import org.apache.ibatis.annotations.Param;
import com.po.User;

public interface UserDao {
	/**
	 * ͨ���˺ź������ѯ�û�
	 */
	public User findUser(@Param("usercode") String usercode,
						@Param("password") String password);
	/**
	 * ����ͨ���û�id���û������������ע��Ĺ���
	 */
	public int register(User user);
	/**
	 * ��֤Ҫע����û��Ƿ�������ݿ���
	 */
	public Integer findByCode(User user);
	
}