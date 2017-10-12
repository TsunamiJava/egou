package com.tsunami.egou.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.tsunami.egou.pojo.EBuyer;
import com.tsunami.egou.pojo.EBuyerExample;
import com.tsunami.egou.pojo.EBuyerExample.Criteria;
import com.tsunami.egou.service.IBuyerService;
import com.tsunami.egou.utils.CookieUtils;
import com.tsunami.egou.utils.Md5Utils;

@Controller
public class BuyerController {
	@Resource
	private IBuyerService buyerService;
	@Resource
	private ImageCaptchaService captchaService;
	
	private Gson gson = new Gson();

	/**
	 * 跳转到用户登录页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "front_page/buyer/login";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("/shopping/login")
	public String login(EBuyer buyer,String captcha,HttpServletRequest request,HttpServletResponse response,Model model){
		if(!StringUtils.isBlank(captcha)){
			//判断验证码是否正确
			if(captchaService.validateResponseForID(request.getSession().getId(), captcha)){
				//判断用户输入的帐号和密码(md5)是否正确
				//如果帐号和密码都正确，登录成功，将用户信息写入cookie中，根据用户操作的情况跳转到不同的页面
				//帐号和密码不正确，登录失败，提示用户登录失败的原因，跳转到登录页面，让用户继续登录
				//登录成功之后，要跳转到哪里？ 根据用户操作的情况跳转到不同的页面
				if(buyer!=null){
					EBuyerExample example = new EBuyerExample();
					Criteria cri = example.createCriteria();
					cri.andUsernameEqualTo(buyer.getUsername());
					cri.andPasswordEqualTo(Md5Utils.getMD5Pwd(buyer.getPassword()));
					List<EBuyer> buyers = buyerService.selectByExample(example);
					//登录成功
					if(buyers!=null && buyers.size()>0){
						EBuyer ebuyer = buyers.get(0);
						//将用户信息写入cookie中，根据用户操作的情况跳转到不同的页面
						String buyerJson = gson.toJson(ebuyer);
						CookieUtils.setCookie(request, response, CookieUtils.BUYER_TOKEN, buyerJson, -1, "utf-8");
						request.getSession().setAttribute("buyer", buyer);
						String returnUrl = (String) request.getSession().getAttribute("returnUrl");
						if(returnUrl!=null){
							// 假设returnUrl等于 /buyer/closeBuy
							// buyer/closeBuy
							return "redirect:"+returnUrl;
						}else{
							return "redirect:/showIndex";
						}
					}else{
						model.addAttribute("error", "用户名或者密码有误");
						
					}
				}
			}else{
				model.addAttribute("error", "验证码有误");
			}
			
		}else{
			model.addAttribute("error", "验证码不能为空");
		}
		
		return "front_page/buyer/login";
	}
}
