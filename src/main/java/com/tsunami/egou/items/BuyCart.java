package com.tsunami.egou.items;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * @author CodingTest
 *
 */
public class BuyCart {
	//购物项  集合
	List<BuyItem> items = new ArrayList<BuyItem>();
	//继续购物   最后一款
	private Integer productId;
	
	//增加产品到购物车
	public void addItem(BuyItem item){
		//判断是否重复
		//items:item1,item2,item3
		//flag result = item1.equals(item)
		//flag result = item2.equals(item)
		if(items.contains(item)){
			for(BuyItem it : items){
				if(it.equals(item)){
					// 5
					// 2  2
					int result = it.getAmount() + item.getAmount();
					//
					if(it.getSku().getSkuUpperLimit() >= result){
						it.setAmount(result);
					}else{
						it.setAmount(it.getSku().getSkuUpperLimit());
					}
				}
			}
			
		}else{
			
			items.add(item);
		}
	}
	//删除一个
	public void deleteItem(BuyItem item){
		items.remove(item);
	}
	//小计
	//商品数量
	public int getProductAmount(){
		int result = 0;
		for(BuyItem item : items){
			result += item.getAmount();
		}
		return result;
	}
	//商品金额
	public Double getProductPrice(){
		Double result = 0.00;
		for(BuyItem item : items){
			result += item.getSku().getSkuPrice()*item.getAmount();
		}
		return result;
	}
	//运费
	public Double getFee(){
		Double result = 0.00;
		if(getProductPrice() <= 39){
				result = 10.00;
		}
		return result;
	}
	
	//清空购物车
	public void clearCart(){
		items.clear();
	}
	//应付金额
	public Double getTotalPrice(){
		return getFee() + getProductPrice();
	}

	public List<BuyItem> getItems() {
		return items;
	}

	public void setItems(List<BuyItem> items) {
		this.items = items;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
