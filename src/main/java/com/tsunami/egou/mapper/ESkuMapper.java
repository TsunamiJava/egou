package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.ESku;
import com.tsunami.egou.pojo.ESkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ESkuMapper {
    long countByExample(ESkuExample example);

    int deleteByExample(ESkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ESku record);

    int insertSelective(ESku record);

    List<ESku> selectByExample(ESkuExample example);

    ESku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ESku record, @Param("example") ESkuExample example);

    int updateByExample(@Param("record") ESku record, @Param("example") ESkuExample example);

    int updateByPrimaryKeySelective(ESku record);

    int updateByPrimaryKey(ESku record);
}