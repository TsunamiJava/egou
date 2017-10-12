package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.pojo.EFeature;
import com.tsunami.egou.pojo.EFeatureExample;

public interface IFeatureService {
	List<EFeature> selectByExample(EFeatureExample example);
}
