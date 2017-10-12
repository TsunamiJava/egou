package com.tsunami.egou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsunami.egou.mapper.ETypeMapper;
import com.tsunami.egou.pojo.EType;
import com.tsunami.egou.pojo.ETypeExample;
import com.tsunami.egou.service.ITypeService;

@Service("typeService")
public class TypeServiceImpl implements ITypeService {

	@Resource
	private ETypeMapper typeMapper;
	
	@Override
	public List<EType> selectByExample(ETypeExample example) {
		return typeMapper.selectByExample(example);
	}

}
