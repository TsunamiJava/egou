package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.pojo.EBuyer;
import com.tsunami.egou.pojo.EBuyerExample;

public interface IBuyerService {
	List<EBuyer> selectByExample(EBuyerExample example);
}
