package com.tsunami.egou.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsunami.egou.items.Pagination;
import com.tsunami.egou.items.ProductImgItem;
import com.tsunami.egou.mapper.EImgMapper;
import com.tsunami.egou.mapper.EProductMapper;
import com.tsunami.egou.pojo.EImg;
import com.tsunami.egou.pojo.EImgExample;
import com.tsunami.egou.pojo.EImgExample.Criteria;
import com.tsunami.egou.pojo.EProduct;
import com.tsunami.egou.pojo.EProductExample;
import com.tsunami.egou.pojo.EProductWithBLOBs;
import com.tsunami.egou.service.IProductService;

@Service("productService")
//productServiceImpl
public class ProductServiceImpl implements IProductService {

	@Resource
	private EProductMapper productMapper;
	
	@Resource
	private EImgMapper imgMapper;
	
	@Override
	public List<ProductImgItem> selectByExample(EProductExample example) {
//		return productMapper.selectByExample(example);
		List<ProductImgItem> items = new ArrayList<ProductImgItem>();
		List<EProduct> products = productMapper.selectByExample(example);
		for(EProduct product:products){
			ProductImgItem item = new ProductImgItem();
			item.setProduct(product);
			//根据product_id查询对应的图片
			EImgExample imgExample = new EImgExample();
			//增加查询条件
			Criteria cri = imgExample.createCriteria();
			cri.andProductIdEqualTo(product.getId());
			List<EImg> imgs = imgMapper.selectByExample(imgExample);
			item.setImgs(imgs);
			for(EImg img:imgs){
				if(img.getIsDef()){
					item.setMainImg(img);
					break;
				}
			}
			items.add(item);
		}
		return items;
	}

	@Override
	public Pagination selectByPage(EProductExample example, Integer pageNum) {
		Pagination page = new Pagination();
		
		List<ProductImgItem> items = new ArrayList<ProductImgItem>();
		PageHelper.startPage(pageNum, 8);
		List<EProduct> products = productMapper.selectByExample(example);
		PageInfo<EProduct> pageInfo = new PageInfo<EProduct>(products);
		page.setPageInfo(pageInfo);
		for(EProduct product:products){
			ProductImgItem item = new ProductImgItem();
			item.setProduct(product);
			//根据product_id查询对应的图片
			EImgExample imgExample = new EImgExample();
			//增加查询条件
			Criteria cri = imgExample.createCriteria();
			cri.andProductIdEqualTo(product.getId());
			List<EImg> imgs = imgMapper.selectByExample(imgExample);
			item.setImgs(imgs);
			for(EImg img:imgs){
				if(img.getIsDef()){
					item.setMainImg(img);
					break;
				}
			}
			items.add(item);
		}
		page.setItems(items);
		return page;
	}

	@Override
	public EProductWithBLOBs selectByPrimaryKey(Integer id) {
		return productMapper.selectByPrimaryKey(id);
	}

}
