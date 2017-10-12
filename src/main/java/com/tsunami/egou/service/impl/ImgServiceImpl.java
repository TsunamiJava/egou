package com.tsunami.egou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsunami.egou.mapper.EImgMapper;
import com.tsunami.egou.pojo.EImg;
import com.tsunami.egou.pojo.EImgExample;
import com.tsunami.egou.service.IImgService;

@Service("imgService")
public class ImgServiceImpl implements IImgService {
	@Resource
	private EImgMapper imgMapper;

	@Override
	public List<EImg> selectByExample(EImgExample example) {
		return imgMapper.selectByExample(example);
	}

}
