package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Quesoption;
import com.tanyun.commons.domain.QuesoptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuesoptionMapper {
    int countByExample(QuesoptionExample example);

    int deleteByExample(QuesoptionExample example);

    int deleteByPrimaryKey(Long quesoptionId);

    int insert(Quesoption record);

    int insertSelective(Quesoption record);

    List<Quesoption> selectByExample(QuesoptionExample example);

    Quesoption selectByPrimaryKey(Long quesoptionId);

    int updateByExampleSelective(@Param("record") Quesoption record, @Param("example") QuesoptionExample example);

    int updateByExample(@Param("record") Quesoption record, @Param("example") QuesoptionExample example);

    int updateByPrimaryKeySelective(Quesoption record);

    int updateByPrimaryKey(Quesoption record);
}