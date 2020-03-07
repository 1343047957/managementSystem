package com.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerDao;
import com.itheima.common.utils.Page;
import com.po.Customer;
import com.service.CustomerService;
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	@Override	
	public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource,
			String custIndustry, String custLevel) {
		//�����ͻ�����
		Customer customer = new Customer();
		
		//�жϿͻ�����
		if(StringUtils.isNoneBlank(custName)){
			customer.setCust_name(custName);
		}
		
		//�жϿͻ���Ϣ��Դ
		if(StringUtils.isNotBlank(custSource)){
			customer.setCust_source(custSource);
		}
		
		//�жϿͻ�������ҵ
		if(StringUtils.isNotBlank(custIndustry)){
			customer.setCust_industry(custIndustry);
		}
		
		//�жϿͻ�����
		if(StringUtils.isNotBlank(custLevel)){
			customer.setCust_level(custLevel);
		}
		//��ǰҳ
		customer.setStart((page-1)*rows);
		
		//ÿҳ��
		customer.setRows(rows);
		
		//��ѯ�ͻ��б�
		List<Customer> customers = customerDao.selectCustomerList(customer);
		
		//��ѯ�ͻ��б��ܼ�¼��
		Integer count = customerDao.selectCustomerListCount(customer);
		
		//����Page���ض���
		Page<Customer> result = new Page<>();
		result.setPage(page);
		result.setRows(customers);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	/**
	 * �����ͻ�
	 */
	@Override
	public int createCustomer(Customer customer) {
	    return customerDao.createCustomer(customer);
	}
	/**
	 * ͨ��id��ѯ�ͻ�
	 */
	@Override
	public Customer getCustomerById(Integer id) {	
	    Customer customer = customerDao.getCustomerById(id);
	    return customer;		
	}
	/**
	 * ���¿ͻ�
	 */
	@Override
	public int updateCustomer(Customer customer) {
	    return customerDao.updateCustomer(customer);
	}
	/**
	 * ɾ���ͻ�
	 */
	@Override
	public int deleteCustomer(Integer id) {
	    return customerDao.deleteCustomer(id);	
	}
}