package com.tsunami.egou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsunami.egou.mapper.ESkuMapper;
import com.tsunami.egou.pojo.ESku;
import com.tsunami.egou.pojo.ESkuExample;
import com.tsunami.egou.service.ISkuService;

@Service("skuService")
public class SkuServiceImpl implements ISkuService {

	@Resource
	private ESkuMapper skuMapper;
	
	@Override
	public List<ESku> selectByExample(ESkuExample example) {
		return skuMapper.selectByExample(example);
	}

	@Override
	public ESku selectByPrimaryKey(Integer id) {
		return skuMapper.selectByPrimaryKey(id);
	}

}
