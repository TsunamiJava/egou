package com.tsunami.egou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsunami.egou.mapper.EFeatureMapper;
import com.tsunami.egou.pojo.EFeature;
import com.tsunami.egou.pojo.EFeatureExample;
import com.tsunami.egou.service.IFeatureService;

@Service("featureService")
public class FeatureServiceImpl implements IFeatureService {

	@Resource
	private EFeatureMapper featureMapper;
	
	@Override
	public List<EFeature> selectByExample(EFeatureExample example) {
		return featureMapper.selectByExample(example);
	}

}
