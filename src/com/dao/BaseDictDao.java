package com.dao;
import java.util.List;
import com.po.BaseDict;

public interface BaseDictDao {
	// �����������ѯ�����ֵ�
    public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
