package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EProduct;
import com.tsunami.egou.pojo.EProductExample;
import com.tsunami.egou.pojo.EProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EProductMapper {
    long countByExample(EProductExample example);

    int deleteByExample(EProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EProductWithBLOBs record);

    int insertSelective(EProductWithBLOBs record);

    List<EProductWithBLOBs> selectByExampleWithBLOBs(EProductExample example);

    List<EProduct> selectByExample(EProductExample example);

    EProductWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EProductWithBLOBs record, @Param("example") EProductExample example);

    int updateByExampleWithBLOBs(@Param("record") EProductWithBLOBs record, @Param("example") EProductExample example);

    int updateByExample(@Param("record") EProduct record, @Param("example") EProductExample example);

    int updateByPrimaryKeySelective(EProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EProductWithBLOBs record);

    int updateByPrimaryKey(EProduct record);
}