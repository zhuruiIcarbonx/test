package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Collectionseqinfo;
import com.tanyun.commons.domain.CollectionseqinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionseqinfoMapper {
    int countByExample(CollectionseqinfoExample example);

    int deleteByExample(CollectionseqinfoExample example);

    int deleteByPrimaryKey(Long collectionseqinfoId);

    int insert(Collectionseqinfo record);

    int insertSelective(Collectionseqinfo record);

    List<Collectionseqinfo> selectByExample(CollectionseqinfoExample example);

    Collectionseqinfo selectByPrimaryKey(Long collectionseqinfoId);

    int updateByExampleSelective(@Param("record") Collectionseqinfo record, @Param("example") CollectionseqinfoExample example);

    int updateByExample(@Param("record") Collectionseqinfo record, @Param("example") CollectionseqinfoExample example);

    int updateByPrimaryKeySelective(Collectionseqinfo record);

    int updateByPrimaryKey(Collectionseqinfo record);
}