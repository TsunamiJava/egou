package com.tsunami.egou.service;

import java.util.List;

import com.tsunami.egou.pojo.EImg;
import com.tsunami.egou.pojo.EImgExample;

public interface IImgService {
	 List<EImg> selectByExample(EImgExample example);
}
