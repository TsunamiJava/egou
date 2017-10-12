package com.tsunami.egou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsunami.egou.mapper.EBrandMapper;
import com.tsunami.egou.pojo.EBrand;
import com.tsunami.egou.pojo.EBrandExample;
import com.tsunami.egou.service.IBrandService;

@Service("brandService")
public class BrandServiceImpl implements IBrandService {
	
	@Resource
	private EBrandMapper brandMapper;
	
	@Override
	public List<EBrand> selectByExample(EBrandExample example) {
		return brandMapper.selectByExample(example);
	}


}
