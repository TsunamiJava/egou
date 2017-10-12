package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EType;
import com.tsunami.egou.pojo.ETypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ETypeMapper {
    long countByExample(ETypeExample example);

    int deleteByExample(ETypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EType record);

    int insertSelective(EType record);

    List<EType> selectByExample(ETypeExample example);

    EType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EType record, @Param("example") ETypeExample example);

    int updateByExample(@Param("record") EType record, @Param("example") ETypeExample example);

    int updateByPrimaryKeySelective(EType record);

    int updateByPrimaryKey(EType record);
}