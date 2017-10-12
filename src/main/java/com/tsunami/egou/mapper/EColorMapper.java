package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EColor;
import com.tsunami.egou.pojo.EColorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EColorMapper {
    long countByExample(EColorExample example);

    int deleteByExample(EColorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EColor record);

    int insertSelective(EColor record);

    List<EColor> selectByExample(EColorExample example);

    EColor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EColor record, @Param("example") EColorExample example);

    int updateByExample(@Param("record") EColor record, @Param("example") EColorExample example);

    int updateByPrimaryKeySelective(EColor record);

    int updateByPrimaryKey(EColor record);
}