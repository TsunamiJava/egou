package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.pojo.ESku;
import com.tsunami.egou.pojo.ESkuExample;

public interface ISkuService {

	List<ESku> selectByExample(ESkuExample example);

    ESku selectByPrimaryKey(Integer id);
}
