package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Processinfo;
import com.tanyun.commons.domain.ProcessinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessinfoMapper {
    int countByExample(ProcessinfoExample example);

    int deleteByExample(ProcessinfoExample example);

    int deleteByPrimaryKey(Long processinfoId);

    int insert(Processinfo record);

    int insertSelective(Processinfo record);

    List<Processinfo> selectByExample(ProcessinfoExample example);

    Processinfo selectByPrimaryKey(Long processinfoId);

    int updateByExampleSelective(@Param("record") Processinfo record, @Param("example") ProcessinfoExample example);

    int updateByExample(@Param("record") Processinfo record, @Param("example") ProcessinfoExample example);

    int updateByPrimaryKeySelective(Processinfo record);

    int updateByPrimaryKey(Processinfo record);
}