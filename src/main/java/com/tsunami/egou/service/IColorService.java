package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.pojo.EColor;
import com.tsunami.egou.pojo.EColorExample;

public interface IColorService {
	List<EColor> selectByExample(EColorExample example);

    EColor selectByPrimaryKey(Integer id);
}
