package com.tsunami.egou.mapper;

import com.tsunami.egou.pojo.EBrand;
import com.tsunami.egou.pojo.EBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EBrandMapper {
    long countByExample(EBrandExample example);

    int deleteByExample(EBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EBrand record);

    int insertSelective(EBrand record);

    List<EBrand> selectByExampleWithBLOBs(EBrandExample example);

    List<EBrand> selectByExample(EBrandExample example);

    EBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EBrand record, @Param("example") EBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") EBrand record, @Param("example") EBrandExample example);

    int updateByExample(@Param("record") EBrand record, @Param("example") EBrandExample example);

    int updateByPrimaryKeySelective(EBrand record);

    int updateByPrimaryKeyWithBLOBs(EBrand record);

    int updateByPrimaryKey(EBrand record);
}