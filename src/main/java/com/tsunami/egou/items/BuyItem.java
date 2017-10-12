package com.tsunami.egou.items;

import com.tsunami.egou.pojo.EImg;
import com.tsunami.egou.pojo.EProduct;
import com.tsunami.egou.pojo.ESku;

/**
 * 购物项
 * @author CodingTest
 *
 */
public class BuyItem {

	//库存对象
	private ESku sku;
	//产品对象
	private EProduct product;
	//产品对应的主图片对象
	private EImg img;
	//购物项购买的产品数量
	private int amount =1;
	public ESku getSku() {
		return sku;
	}
	public void setSku(ESku sku) {
		this.sku = sku;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public EProduct getProduct() {
		return product;
	}
	public void setProduct(EProduct product) {
		this.product = product;
	}
	
	
	public EImg getImg() {
		return img;
	}
	public void setImg(EImg img) {
		this.img = img;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		BuyItem other = (BuyItem) obj;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.getId().equals(other.sku.getId()))
			return false;
		return true;
	}
	
	
	
}

