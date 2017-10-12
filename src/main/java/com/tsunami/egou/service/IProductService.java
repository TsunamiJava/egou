package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.items.Pagination;
import com.tsunami.egou.items.ProductImgItem;
import com.tsunami.egou.pojo.EProductExample;
import com.tsunami.egou.pojo.EProductWithBLOBs;

public interface IProductService {
 List<ProductImgItem> selectByExample(EProductExample example);
	 
	 /**
	  * 分页查询方法
	  * @param example，封装查询条件
	  * @return
	  */
	 Pagination selectByPage(EProductExample example,Integer pageNum);

	 /**
	  * 根据主键查询商品信息
	  * @param id
	  * @return
	  */
	 EProductWithBLOBs selectByPrimaryKey(Integer id);
}
