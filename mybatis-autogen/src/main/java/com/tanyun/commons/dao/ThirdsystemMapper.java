package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Thirdsystem;
import com.tanyun.commons.domain.ThirdsystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdsystemMapper {
    int countByExample(ThirdsystemExample example);

    int deleteByExample(ThirdsystemExample example);

    int deleteByPrimaryKey(Long thId);

    int insert(Thirdsystem record);

    int insertSelective(Thirdsystem record);

    List<Thirdsystem> selectByExample(ThirdsystemExample example);

    Thirdsystem selectByPrimaryKey(Long thId);

    int updateByExampleSelective(@Param("record") Thirdsystem record, @Param("example") ThirdsystemExample example);

    int updateByExample(@Param("record") Thirdsystem record, @Param("example") ThirdsystemExample example);

    int updateByPrimaryKeySelective(Thirdsystem record);

    int updateByPrimaryKey(Thirdsystem record);
}