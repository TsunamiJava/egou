package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EEmployee;
import com.tsunami.egou.pojo.EEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EEmployeeMapper {
    long countByExample(EEmployeeExample example);

    int deleteByExample(EEmployeeExample example);

    int deleteByPrimaryKey(String username);

    int insert(EEmployee record);

    int insertSelective(EEmployee record);

    List<EEmployee> selectByExample(EEmployeeExample example);

    EEmployee selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") EEmployee record, @Param("example") EEmployeeExample example);

    int updateByExample(@Param("record") EEmployee record, @Param("example") EEmployeeExample example);

    int updateByPrimaryKeySelective(EEmployee record);

    int updateByPrimaryKey(EEmployee record);
}