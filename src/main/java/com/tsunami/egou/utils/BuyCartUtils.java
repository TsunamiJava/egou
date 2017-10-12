package com.tsunami.egou.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tsunami.egou.items.BuyCart;

public class BuyCartUtils {
	/**
	 * 从cookie获取购物车对象
	 * @param req
	 * @param buycartCookieName
	 * @return
	 */
	public static BuyCart getBuyFromCookie(HttpServletRequest req,String buycartCookieName) {
		Gson gson = new Gson();
		// 从客户端获取到的购物车json数据，
		String buycartCookieValue = CookieUtils.getCookieValue(req, buycartCookieName,"utf-8");
		// 声明
		BuyCart buyCart = null;
		// 判断Cookie是否有购物车 ，如果有了 就使用此购物车；如果没有 创建购物车
		if (null == buycartCookieValue) {
			// 购物车
			buyCart = new BuyCart();
		} else {
			buyCart = gson.fromJson(buycartCookieValue, BuyCart.class);
		}
		return buyCart;
	}
	
	//将购物车对象写入cookie中
	public static void setBuyCartToCookie(HttpServletRequest request,HttpServletResponse response,String buycartCookieName,BuyCart buyCart) {
		Gson gson = new Gson();
		String buyCartJson = gson.toJson(buyCart);
		CookieUtils.setCookie(request, response, buycartCookieName, buyCartJson,-1,"utf-8");
	}
}
