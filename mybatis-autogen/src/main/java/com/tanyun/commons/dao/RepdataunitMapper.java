package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Repdataunit;
import com.tanyun.commons.domain.RepdataunitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepdataunitMapper {
    int countByExample(RepdataunitExample example);

    int deleteByExample(RepdataunitExample example);

    int deleteByPrimaryKey(Long reportdataunitId);

    int insert(Repdataunit record);

    int insertSelective(Repdataunit record);

    List<Repdataunit> selectByExample(RepdataunitExample example);

    Repdataunit selectByPrimaryKey(Long reportdataunitId);

    int updateByExampleSelective(@Param("record") Repdataunit record, @Param("example") RepdataunitExample example);

    int updateByExample(@Param("record") Repdataunit record, @Param("example") RepdataunitExample example);

    int updateByPrimaryKeySelective(Repdataunit record);

    int updateByPrimaryKey(Repdataunit record);
}