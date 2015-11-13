package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Genereportmap;
import com.tanyun.commons.domain.GenereportmapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GenereportmapMapper {
    int countByExample(GenereportmapExample example);

    int deleteByExample(GenereportmapExample example);

    int deleteByPrimaryKey(Long genereportmapId);

    int insert(Genereportmap record);

    int insertSelective(Genereportmap record);

    List<Genereportmap> selectByExample(GenereportmapExample example);

    Genereportmap selectByPrimaryKey(Long genereportmapId);

    int updateByExampleSelective(@Param("record") Genereportmap record, @Param("example") GenereportmapExample example);

    int updateByExample(@Param("record") Genereportmap record, @Param("example") GenereportmapExample example);

    int updateByPrimaryKeySelective(Genereportmap record);

    int updateByPrimaryKey(Genereportmap record);
}