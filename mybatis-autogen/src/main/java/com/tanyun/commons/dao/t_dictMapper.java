package com.tanyun.commons.dao;

import com.tanyun.commons.domain.t_dict;
import com.tanyun.commons.domain.t_dictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_dictMapper {
    int countByExample(t_dictExample example);

    int deleteByExample(t_dictExample example);

    int deleteByPrimaryKey(Long dictId);

    int insert(t_dict record);

    int insertSelective(t_dict record);

    List<t_dict> selectByExample(t_dictExample example);

    t_dict selectByPrimaryKey(Long dictId);

    int updateByExampleSelective(@Param("record") t_dict record, @Param("example") t_dictExample example);

    int updateByExample(@Param("record") t_dict record, @Param("example") t_dictExample example);

    int updateByPrimaryKeySelective(t_dict record);

    int updateByPrimaryKey(t_dict record);
}