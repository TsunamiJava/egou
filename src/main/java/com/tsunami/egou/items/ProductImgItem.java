package com.tsunami.egou.items;

import java.util.ArrayList;
import java.util.List;

import com.tsunami.egou.pojo.EImg;
import com.tsunami.egou.pojo.EProduct;

/**
 * 
 * @author CodingTest
 *	封装商品和商品图片
 */
public class ProductImgItem {
	private EProduct product;
	private List<EImg> imgs = new ArrayList<EImg>();
	private EImg mainImg;
	
	public EProduct getProduct() {
		return product;
	}
	public void setProduct(EProduct product) {
		this.product = product;
	}
	public List<EImg> getImgs() {
		return imgs;
	}
	public void setImgs(List<EImg> imgs) {
		this.imgs = imgs;
	}
	public EImg getMainImg() {
		return mainImg;
	}
	public void setMainImg(EImg mainImg) {
		this.mainImg = mainImg;
	}
	
}
