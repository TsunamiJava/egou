package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EDetail;
import com.tsunami.egou.pojo.EDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EDetailMapper {
    long countByExample(EDetailExample example);

    int deleteByExample(EDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EDetail record);

    int insertSelective(EDetail record);

    List<EDetail> selectByExample(EDetailExample example);

    EDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EDetail record, @Param("example") EDetailExample example);

    int updateByExample(@Param("record") EDetail record, @Param("example") EDetailExample example);

    int updateByPrimaryKeySelective(EDetail record);

    int updateByPrimaryKey(EDetail record);
}