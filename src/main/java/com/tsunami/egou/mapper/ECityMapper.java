package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.ECity;
import com.tsunami.egou.pojo.ECityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ECityMapper {
    long countByExample(ECityExample example);

    int deleteByExample(ECityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ECity record);

    int insertSelective(ECity record);

    List<ECity> selectByExample(ECityExample example);

    ECity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ECity record, @Param("example") ECityExample example);

    int updateByExample(@Param("record") ECity record, @Param("example") ECityExample example);

    int updateByPrimaryKeySelective(ECity record);

    int updateByPrimaryKey(ECity record);
}