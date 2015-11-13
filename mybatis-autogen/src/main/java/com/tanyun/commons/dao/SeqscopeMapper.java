package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Seqscope;
import com.tanyun.commons.domain.SeqscopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeqscopeMapper {
    int countByExample(SeqscopeExample example);

    int deleteByExample(SeqscopeExample example);

    int deleteByPrimaryKey(Long seqscopeId);

    int insert(Seqscope record);

    int insertSelective(Seqscope record);

    List<Seqscope> selectByExampleWithBLOBs(SeqscopeExample example);

    List<Seqscope> selectByExample(SeqscopeExample example);

    Seqscope selectByPrimaryKey(Long seqscopeId);

    int updateByExampleSelective(@Param("record") Seqscope record, @Param("example") SeqscopeExample example);

    int updateByExampleWithBLOBs(@Param("record") Seqscope record, @Param("example") SeqscopeExample example);

    int updateByExample(@Param("record") Seqscope record, @Param("example") SeqscopeExample example);

    int updateByPrimaryKeySelective(Seqscope record);

    int updateByPrimaryKeyWithBLOBs(Seqscope record);

    int updateByPrimaryKey(Seqscope record);
}