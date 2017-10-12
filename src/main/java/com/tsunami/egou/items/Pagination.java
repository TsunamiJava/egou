package com.tsunami.egou.items;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tsunami.egou.pojo.EProduct;

/**
 * 封装分页商品信息
 * @author CodingTest
 *
 */
public class Pagination {

	private List<ProductImgItem> items;
	private PageInfo<EProduct> pageInfo;
	public List<ProductImgItem> getItems() {
		return items;
	}
	public void setItems(List<ProductImgItem> items) {
		this.items = items;
	}
	public PageInfo<EProduct> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo<EProduct> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}
