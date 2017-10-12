package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.pojo.EBrand;
import com.tsunami.egou.pojo.EBrandExample;

public interface IBrandService {
	
	List<EBrand> selectByExample(EBrandExample example);
	
}
