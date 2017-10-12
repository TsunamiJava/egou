package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EOrder;
import com.tsunami.egou.pojo.EOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EOrderMapper {
    long countByExample(EOrderExample example);

    int deleteByExample(EOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EOrder record);

    int insertSelective(EOrder record);

    List<EOrder> selectByExample(EOrderExample example);

    EOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EOrder record, @Param("example") EOrderExample example);

    int updateByExample(@Param("record") EOrder record, @Param("example") EOrderExample example);

    int updateByPrimaryKeySelective(EOrder record);

    int updateByPrimaryKey(EOrder record);
}