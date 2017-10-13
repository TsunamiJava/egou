package com.tsunami.egou.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsunami.egou.items.BuyCart;
import com.tsunami.egou.items.BuyItem;
import com.tsunami.egou.pojo.EImg;
import com.tsunami.egou.pojo.EProduct;
import com.tsunami.egou.pojo.ESku;
import com.tsunami.egou.service.IImgService;
import com.tsunami.egou.service.IProductService;
import com.tsunami.egou.service.ISkuService;
import com.tsunami.egou.utils.BuyCartUtils;
import com.tsunami.egou.utils.CookieUtils;

/**
 * 
 * @author CodingTest
 * 购物车操作
 */
@Controller
public class CartController {
	@Resource
	private ISkuService skuService;
	@Resource
	private IProductService productService;
	@Resource
	private IImgService imgService;
	// 工具类，将javabean转成json字符串，将json字符串转成javabean对象

	/**
	 * 增加商品到购物车对象
	 * 
	 * @return
	 */
	@RequestMapping("/cart/addProductToCart")
	public String addProductToCart(HttpServletRequest request, HttpServletResponse response, Integer skuId,
			Double skuPrice, Double deliveFee, Integer productId, String productName, String imgUrl, Integer amount,Integer skuUpperLimit) {
		BuyCart buyCart = BuyCartUtils.getBuyFromCookie(request, CookieUtils.BUYCART_COOKIE);

		// 创建购物项
		BuyItem item = new BuyItem();
		
		ESku sku = new ESku();
		sku.setId(skuId);
		sku.setSkuPrice(skuPrice);
		sku.setDeliveFee(deliveFee);
		sku.setSkuUpperLimit(skuUpperLimit);

		EProduct product = new EProduct();
		product.setId(productId);
		product.setName(productName);
		
		EImg img = new EImg();
		img.setUrl(imgUrl);
		
		item.setSku(sku);
		item.setProduct(product);
		item.setImg(img);
		item.setAmount(amount);
		// 将购物项加到购物车中
		buyCart.addItem(item);

		// 将购物车写到cookie中
		BuyCartUtils.setBuyCartToCookie(request, response, CookieUtils.BUYCART_COOKIE, buyCart);

		return "redirect:/cart/showCart";
	}

	/**
	 * 显示购物车信息
	 * 
	 * @return
	 */
	@RequestMapping("/cart/showCart")
	public String showCart(HttpServletRequest request, Model model) {
		BuyCart buyCart = BuyCartUtils.getBuyFromCookie(request, CookieUtils.BUYCART_COOKIE);
		model.addAttribute("buyCart", buyCart);

		return "front_page/product/cart";
	}

	/**
	 * 删除商品
	 * 
	 * @return
	 */
	@RequestMapping("/cart/deleteItem")
	public String deleteItemFromCart(HttpServletRequest request, HttpServletResponse response, Integer skuId,
			Model model) {
		BuyCart buyCart = BuyCartUtils.getBuyFromCookie(request, CookieUtils.BUYCART_COOKIE);
		BuyItem item = new BuyItem();
		ESku sku = new ESku();
		sku.setId(skuId);
		item.setSku(sku);
		buyCart.deleteItem(item);

		BuyCartUtils.setBuyCartToCookie(request, response, CookieUtils.BUYCART_COOKIE, buyCart);
		model.addAttribute("buyCart", buyCart);

		return "front_page/product/cart";
	}

	/**
	 * 清空购物车
	 * 
	 * @return
	 */
	@RequestMapping("/cart/clear")
	public String clearCart(HttpServletRequest request, HttpServletResponse response, Model model) {
		BuyCart buyCart = BuyCartUtils.getBuyFromCookie(request, CookieUtils.BUYCART_COOKIE);
		buyCart.clearCart();
		BuyCartUtils.setBuyCartToCookie(request, response, CookieUtils.BUYCART_COOKIE, buyCart);
		model.addAttribute("buyCart", buyCart);

		return "front_page/product/cart";
	}
	
	@RequestMapping("/buyer/closeBuy")
	public String closeBuy(){
		//有待完善
		return "front_page/product/productOrder";
	}
}
