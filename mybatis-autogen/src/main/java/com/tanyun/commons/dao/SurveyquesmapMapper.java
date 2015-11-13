package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Surveyquesmap;
import com.tanyun.commons.domain.SurveyquesmapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyquesmapMapper {
    int countByExample(SurveyquesmapExample example);

    int deleteByExample(SurveyquesmapExample example);

    int deleteByPrimaryKey(Long surveyquesmapId);

    int insert(Surveyquesmap record);

    int insertSelective(Surveyquesmap record);

    List<Surveyquesmap> selectByExample(SurveyquesmapExample example);

    Surveyquesmap selectByPrimaryKey(Long surveyquesmapId);

    int updateByExampleSelective(@Param("record") Surveyquesmap record, @Param("example") SurveyquesmapExample example);

    int updateByExample(@Param("record") Surveyquesmap record, @Param("example") SurveyquesmapExample example);

    int updateByPrimaryKeySelective(Surveyquesmap record);

    int updateByPrimaryKey(Surveyquesmap record);
}