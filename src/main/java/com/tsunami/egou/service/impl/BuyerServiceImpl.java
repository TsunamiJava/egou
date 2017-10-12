package com.tsunami.egou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsunami.egou.mapper.EBuyerMapper;
import com.tsunami.egou.pojo.EBuyer;
import com.tsunami.egou.pojo.EBuyerExample;
import com.tsunami.egou.service.IBuyerService;

@Service("buyerService")
public class BuyerServiceImpl implements IBuyerService {

	@Resource
	private EBuyerMapper buyerMapper;
	@Override
	public List<EBuyer> selectByExample(EBuyerExample example) {
		return buyerMapper.selectByExample(example);
	}

}
