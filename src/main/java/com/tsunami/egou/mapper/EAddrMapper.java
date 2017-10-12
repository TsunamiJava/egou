package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EAddr;
import com.tsunami.egou.pojo.EAddrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EAddrMapper {
    long countByExample(EAddrExample example);

    int deleteByExample(EAddrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EAddr record);

    int insertSelective(EAddr record);

    List<EAddr> selectByExample(EAddrExample example);

    EAddr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EAddr record, @Param("example") EAddrExample example);

    int updateByExample(@Param("record") EAddr record, @Param("example") EAddrExample example);

    int updateByPrimaryKeySelective(EAddr record);

    int updateByPrimaryKey(EAddr record);
}