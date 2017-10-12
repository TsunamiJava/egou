package com.tsunami.egou.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.tsunami.egou.service.IBuyerService;
import com.tsunami.egou.utils.CookieUtils;

public class LoginInterceptor implements HandlerInterceptor {

	@Resource
	private IBuyerService buyerService;
	
	private Gson gson = new Gson();

	/**
	 * 控制器目标方法调用之前执行
	 * @RequestMapping("/buyer/closeBuy")
		public String closeBuy(){
			//有待完善
			return "front_page/product/productOrder";
		}
		
		返回值：
		true：拦截器让用户请求通过，用户可以直接调用到控制器的目标方法
		false：用户请求没通过，不能调用到控制器的目标方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//判断用户是否登录，如果有登录，则直接执行目标方法，否则，跳转到登录界面
		//判断用户是否登录思路：用户登录成功，将用户的信息保存到cookie中，用户下次访问时，带着用户信息的cookie传到服务器，
		//登录拦截器就需要获得此cookie信息，拿着cookie信息到数据库进行匹配
		
		//从cookie中获得用户信息,用户信息是buyer对象对应的json数据
		String buyerInfoJson = CookieUtils.getCookieValue(request, CookieUtils.BUYER_TOKEN,"utf-8");
		boolean isLogin = false;
		if(buyerInfoJson!=null){
			//验证该用户信息是否是有效信息
			/*EBuyer buyer = gson.fromJson(buyerInfoJson, EBuyer.class);
			EBuyerExample example = new EBuyerExample();
			Criteria cri = example.createCriteria();
			cri.andUsernameEqualTo(buyer.getUsername());
			cri.andPasswordEqualTo(buyer.getPassword());
			List<EBuyer> buyers = buyerService.selectByExample(example);
			if(buyers!=null && buyers.size()>0){
				isLogin = true;
			}*/
			
			isLogin = true;
		}
		
		if(!isLogin){
			//未登录状态
			//获得用户要访问的路径，将用户要访问的路径追加到 /toLogin后面,比如说：用户要访问/buyer/closeBuy这个路径，
			//将该路径追加到/toLogin后面，结果是 /toLogin?returnUrl=/buyer/closeBuy
			//浏览器访问登录页面的路径是 /toLogin?returnUrl=/buyer/closeBuy
			String uri = request.getRequestURI();
			if(uri!=null){
				request.getSession().setAttribute("returnUrl", uri);
			}
			response.sendRedirect("/toLogin");
			return false;
		}else{
			//已登录
			return true;
		}
	}
	/**
	 * 控制器目标方法调用之后页面绘制之前执行
	 * @RequestMapping("/buyer/closeBuy")
		public String closeBuy(){
			//有待完善
			return "front_page/product/productOrder";
		}
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 控制器目标方法对应的页面绘制完毕之后执行
	 * @RequestMapping("/buyer/closeBuy")
		public String closeBuy(){
			//有待完善
			return "front_page/product/productOrder";
		}
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		

	}

}
