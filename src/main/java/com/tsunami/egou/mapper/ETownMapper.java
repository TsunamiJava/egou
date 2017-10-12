package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.ETown;
import com.tsunami.egou.pojo.ETownExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ETownMapper {
    long countByExample(ETownExample example);

    int deleteByExample(ETownExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ETown record);

    int insertSelective(ETown record);

    List<ETown> selectByExample(ETownExample example);

    ETown selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ETown record, @Param("example") ETownExample example);

    int updateByExample(@Param("record") ETown record, @Param("example") ETownExample example);

    int updateByPrimaryKeySelective(ETown record);

    int updateByPrimaryKey(ETown record);
}