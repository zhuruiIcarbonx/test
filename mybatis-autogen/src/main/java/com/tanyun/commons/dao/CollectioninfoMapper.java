package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Collectioninfo;
import com.tanyun.commons.domain.CollectioninfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectioninfoMapper {
    int countByExample(CollectioninfoExample example);

    int deleteByExample(CollectioninfoExample example);

    int deleteByPrimaryKey(Long collectioninfoId);

    int insert(Collectioninfo record);

    int insertSelective(Collectioninfo record);

    List<Collectioninfo> selectByExample(CollectioninfoExample example);

    Collectioninfo selectByPrimaryKey(Long collectioninfoId);

    int updateByExampleSelective(@Param("record") Collectioninfo record, @Param("example") CollectioninfoExample example);

    int updateByExample(@Param("record") Collectioninfo record, @Param("example") CollectioninfoExample example);

    int updateByPrimaryKeySelective(Collectioninfo record);

    int updateByPrimaryKey(Collectioninfo record);
}