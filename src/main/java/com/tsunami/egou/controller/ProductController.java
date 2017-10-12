package com.tsunami.egou.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsunami.egou.items.Pagination;
import com.tsunami.egou.pojo.EBrand;
import com.tsunami.egou.pojo.EBrandExample;
import com.tsunami.egou.pojo.EColor;
import com.tsunami.egou.pojo.EFeature;
import com.tsunami.egou.pojo.EFeatureExample;
import com.tsunami.egou.pojo.EProductExample;
import com.tsunami.egou.pojo.EProductExample.Criteria;
import com.tsunami.egou.pojo.EProductWithBLOBs;
import com.tsunami.egou.pojo.ESku;
import com.tsunami.egou.pojo.ESkuExample;
import com.tsunami.egou.pojo.EType;
import com.tsunami.egou.pojo.ETypeExample;
import com.tsunami.egou.service.IBrandService;
import com.tsunami.egou.service.IColorService;
import com.tsunami.egou.service.IFeatureService;
import com.tsunami.egou.service.IProductService;
import com.tsunami.egou.service.ISkuService;
import com.tsunami.egou.service.ITypeService;

@Controller
public class ProductController {
	@Resource
	private IProductService productService;
	@Resource
	private IBrandService brandService;
	@Resource
	private ITypeService typeService;
	@Resource
	private IFeatureService featureService;
	@Resource
	private ISkuService skuService;
	@Resource
	private IColorService colorService;

	/**
	 * 显示首页信息： pageNum：查询第几页数据
	 * 
	 * @return
	 */
	@RequestMapping("/showIndex")
	public String showIndex(Model model, Integer pageNum,HttpSession session) {
		// 加载所有品牌信息
		List<EBrand> brands = brandService.selectByExample(new EBrandExample());
		model.addAttribute("brands", brands);
		// 加载所类型信息
		List<EType> types = typeService.selectByExample(new ETypeExample());
		model.addAttribute("types", types);

		// 加载所类型信息
		List<EFeature> features = featureService.selectByExample(new EFeatureExample());
		model.addAttribute("features", features);

		// 分页查询
		if (pageNum == null) {
			pageNum = 1;
		}
		//map封装了用户之前点击的查询条件
		Map<String,Integer> map = (Map<String,Integer>)session.getAttribute("productQueryMap");
		if(map==null){
			map = new HashMap<String,Integer>();
		}
		
		EProductExample	example = new EProductExample();
		Criteria cri = example.createCriteria();
		
		if(map.containsKey("brandId")){
			cri.andBrandIdEqualTo(map.get("brandId"));
		}
		if(map.containsKey("typeId")){
			cri.andTypeIdEqualTo(map.get("typeId"));
		}
		
		Pagination page = productService.selectByPage(example, pageNum);
		model.addAttribute("page", page);

		return "front_page/product/product";
	}

	/**
	 * 
	 * @param model
	 * @param brandId,商品品牌id
	 * @param typeId，商品类型id
	 * @param featureId,商品材质id
	 * @return
	 */
	@RequestMapping("/searchProducts")
	public String searchProducts(Model model, Integer brandId, Integer typeId, Integer featureId, HttpSession session) {
		// 用户筛选时，要判断用户之前是否要点击其它条件，如果有，就把本次的条件追加到之前的条件中
		// 用户点击查询条件时，把查询条件封装成Map map对象，再将map对象设置到session中
		Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("productQueryMap");
		if (map == null) {
			map = new HashMap<String,Integer>();
		}
		
		if (brandId != null) {
			if(brandId==-1){
				map.remove("brandId");
			}else{
				map.put("brandId", brandId);
			}
			
		}
		if (typeId != null) {
			if(typeId==-1){
				map.remove("typeId");
			}else{
				map.put("typeId", typeId);
			}
			
		}
		// if(featureId!=null){
		//
		// }
		
		session.setAttribute("productQueryMap", map);
//		Pagination page = productService.selectByPage(example, 1);
//		model.addAttribute("page", page);
		
		return "redirect:/showIndex";
	}
	
	
	/**
	 * 显示商品详情
	 * @return
	 */
	@RequestMapping("/showProductDetail")
	public String showProductDetail(Model model,Integer productId){
		/*
		 * 1.根据productId查询对应的商品对象
		 * 2.根据productId查询相关的库存记录，默认显示第一条库存记录
		 * 3.根据商品的颜色id查询颜色名字
		 */
		if(productId!=null){
			//根据productId查询对应的商品对象
			EProductWithBLOBs eproduct = productService.selectByPrimaryKey(productId);
			model.addAttribute("eproduct", eproduct);
			//根据productId查询相关的库存记录，默认显示第一条库存记录
			ESkuExample skuExample = new ESkuExample();
			com.tsunami.egou.pojo.ESkuExample.Criteria cri = skuExample.createCriteria();
			cri.andProductIdEqualTo(productId);
			List<ESku> skus = skuService.selectByExample(skuExample);
			if(skus!=null && skus.size()>0){
				ESku sku = skus.get(0);
				model.addAttribute("sku", sku);
				
			}
			
			//根据商品的颜色id查询颜色名字
			Set<Integer> colorIds = new HashSet<Integer>();
			for(ESku s:skus){
				colorIds.add(s.getColorId());
			}
			
			List<EColor> colors = new ArrayList<EColor>();
			for(Integer colorId:colorIds){
				EColor color = colorService.selectByPrimaryKey(colorId);
				colors.add(color);
			}
			
			model.addAttribute("colors", colors);
			
		}
		
		
		return "front_page/product/productDetail";
	}
}
