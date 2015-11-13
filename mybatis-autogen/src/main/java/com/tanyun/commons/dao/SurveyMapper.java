package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Survey;
import com.tanyun.commons.domain.SurveyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyMapper {
    int countByExample(SurveyExample example);

    int deleteByExample(SurveyExample example);

    int deleteByPrimaryKey(Long surveyId);

    int insert(Survey record);

    int insertSelective(Survey record);

    List<Survey> selectByExample(SurveyExample example);

    Survey selectByPrimaryKey(Long surveyId);

    int updateByExampleSelective(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByExample(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByPrimaryKeySelective(Survey record);

    int updateByPrimaryKey(Survey record);
}