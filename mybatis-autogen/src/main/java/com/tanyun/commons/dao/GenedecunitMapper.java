package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Genedecunit;
import com.tanyun.commons.domain.GenedecunitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GenedecunitMapper {
    int countByExample(GenedecunitExample example);

    int deleteByExample(GenedecunitExample example);

    int deleteByPrimaryKey(Long genedecunitId);

    int insert(Genedecunit record);

    int insertSelective(Genedecunit record);

    List<Genedecunit> selectByExample(GenedecunitExample example);

    Genedecunit selectByPrimaryKey(Long genedecunitId);

    int updateByExampleSelective(@Param("record") Genedecunit record, @Param("example") GenedecunitExample example);

    int updateByExample(@Param("record") Genedecunit record, @Param("example") GenedecunitExample example);

    int updateByPrimaryKeySelective(Genedecunit record);

    int updateByPrimaryKey(Genedecunit record);
}