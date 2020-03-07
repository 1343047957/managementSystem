package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BaseDictDao;
import com.po.BaseDict;
import com.service.BaseDictService;
/**
 * �����ֵ�Service�ӿ�ʵ����
 */
@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	//�����������ѯ�����ֵ�
	@Override
	public List<BaseDict> findBaseDictByTypeCode(String typecode) {
		return baseDictDao.selectBaseDictByTypeCode(typecode);
	}

}
