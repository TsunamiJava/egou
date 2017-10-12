package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EImg;
import com.tsunami.egou.pojo.EImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EImgMapper {
    long countByExample(EImgExample example);

    int deleteByExample(EImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EImg record);

    int insertSelective(EImg record);

    List<EImg> selectByExample(EImgExample example);

    EImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EImg record, @Param("example") EImgExample example);

    int updateByExample(@Param("record") EImg record, @Param("example") EImgExample example);

    int updateByPrimaryKeySelective(EImg record);

    int updateByPrimaryKey(EImg record);
}