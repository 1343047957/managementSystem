package com.service;

import java.util.List;

import com.po.BaseDict;
/**
 * �����ֵ�Service�ӿ�
 */
public interface BaseDictService {
	//�����������ѯ�����ֵ�
	public List<BaseDict> findBaseDictByTypeCode(String typecode);
}
