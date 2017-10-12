package com.tsunami.egou.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsunami.egou.mapper.EProductMapper;
import com.tsunami.egou.pojo.EProduct;
import com.tsunami.egou.pojo.EProductExample;

@Controller
public class AdminProductController {
	@Resource
	private EProductMapper productMapper;

	@RequestMapping("/product/list")
	@ResponseBody
	public List<EProduct> getProducts(){
		EProductExample example = new EProductExample();
		List<EProduct> products = productMapper.selectByExample(example );
		//product最终会转json数据
		//json = [{"id":..,"no":..."name":..,...},...]
		return products;
	}
}