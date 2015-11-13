package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Thirdusermap;
import com.tanyun.commons.domain.ThirdusermapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdusermapMapper {
    int countByExample(ThirdusermapExample example);

    int deleteByExample(ThirdusermapExample example);

    int deleteByPrimaryKey(Long thirdusermapId);

    int insert(Thirdusermap record);

    int insertSelective(Thirdusermap record);

    List<Thirdusermap> selectByExample(ThirdusermapExample example);

    Thirdusermap selectByPrimaryKey(Long thirdusermapId);

    int updateByExampleSelective(@Param("record") Thirdusermap record, @Param("example") ThirdusermapExample example);

    int updateByExample(@Param("record") Thirdusermap record, @Param("example") ThirdusermapExample example);

    int updateByPrimaryKeySelective(Thirdusermap record);

    int updateByPrimaryKey(Thirdusermap record);
}