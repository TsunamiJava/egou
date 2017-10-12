package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EProvince;
import com.tsunami.egou.pojo.EProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EProvinceMapper {
    long countByExample(EProvinceExample example);

    int deleteByExample(EProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EProvince record);

    int insertSelective(EProvince record);

    List<EProvince> selectByExample(EProvinceExample example);

    EProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EProvince record, @Param("example") EProvinceExample example);

    int updateByExample(@Param("record") EProvince record, @Param("example") EProvinceExample example);

    int updateByPrimaryKeySelective(EProvince record);

    int updateByPrimaryKey(EProvince record);
}