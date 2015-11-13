package com.tanyun.commons.dao;

import com.tanyun.commons.domain.SurveyDomain;
import com.tanyun.commons.domain.SurveyDomainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyDomainMapper {
    int countByExample(SurveyDomainExample example);

    int deleteByExample(SurveyDomainExample example);

    int deleteByPrimaryKey(Long domainId);

    int insert(SurveyDomain record);

    int insertSelective(SurveyDomain record);

    List<SurveyDomain> selectByExample(SurveyDomainExample example);

    SurveyDomain selectByPrimaryKey(Long domainId);

    int updateByExampleSelective(@Param("record") SurveyDomain record, @Param("example") SurveyDomainExample example);

    int updateByExample(@Param("record") SurveyDomain record, @Param("example") SurveyDomainExample example);

    int updateByPrimaryKeySelective(SurveyDomain record);

    int updateByPrimaryKey(SurveyDomain record);
}