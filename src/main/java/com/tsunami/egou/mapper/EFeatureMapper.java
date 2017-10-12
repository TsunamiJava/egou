package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EFeature;
import com.tsunami.egou.pojo.EFeatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EFeatureMapper {
    long countByExample(EFeatureExample example);

    int deleteByExample(EFeatureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EFeature record);

    int insertSelective(EFeature record);

    List<EFeature> selectByExample(EFeatureExample example);

    EFeature selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EFeature record, @Param("example") EFeatureExample example);

    int updateByExample(@Param("record") EFeature record, @Param("example") EFeatureExample example);

    int updateByPrimaryKeySelective(EFeature record);

    int updateByPrimaryKey(EFeature record);
}