package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.pojo.EType;
import com.tsunami.egou.pojo.ETypeExample;

public interface ITypeService {
	List<EType> selectByExample(ETypeExample example);
}
