package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EBuyer;
import com.tsunami.egou.pojo.EBuyerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EBuyerMapper {
    long countByExample(EBuyerExample example);

    int deleteByExample(EBuyerExample example);

    int deleteByPrimaryKey(String username);

    int insert(EBuyer record);

    int insertSelective(EBuyer record);

    List<EBuyer> selectByExample(EBuyerExample example);

    EBuyer selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") EBuyer record, @Param("example") EBuyerExample example);

    int updateByExample(@Param("record") EBuyer record, @Param("example") EBuyerExample example);

    int updateByPrimaryKeySelective(EBuyer record);

    int updateByPrimaryKey(EBuyer record);
}