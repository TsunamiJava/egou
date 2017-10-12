package com.tsunami.egou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsunami.egou.mapper.EColorMapper;
import com.tsunami.egou.pojo.EColor;
import com.tsunami.egou.pojo.EColorExample;
import com.tsunami.egou.service.IColorService;

@Service("colorService")
public class ColorServiceImpl implements IColorService {

	@Resource
	private EColorMapper colorMapper;
	
	@Override
	public List<EColor> selectByExample(EColorExample example) {
		return colorMapper.selectByExample(example);
	}

	@Override
	public EColor selectByPrimaryKey(Integer id) {
		return colorMapper.selectByPrimaryKey(id);
	}

}
