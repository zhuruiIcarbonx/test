package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Productrepdatamap;
import com.tanyun.commons.domain.ProductrepdatamapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductrepdatamapMapper {
    int countByExample(ProductrepdatamapExample example);

    int deleteByExample(ProductrepdatamapExample example);

    int deleteByPrimaryKey(Long productrepdatamapId);

    int insert(Productrepdatamap record);

    int insertSelective(Productrepdatamap record);

    List<Productrepdatamap> selectByExample(ProductrepdatamapExample example);

    Productrepdatamap selectByPrimaryKey(Long productrepdatamapId);

    int updateByExampleSelective(@Param("record") Productrepdatamap record, @Param("example") ProductrepdatamapExample example);

    int updateByExample(@Param("record") Productrepdatamap record, @Param("example") ProductrepdatamapExample example);

    int updateByPrimaryKeySelective(Productrepdatamap record);

    int updateByPrimaryKey(Productrepdatamap record);
}