package com.tanyun.commons.dao;

import com.tanyun.commons.domain.Colseqgenedecmap;
import com.tanyun.commons.domain.ColseqgenedecmapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColseqgenedecmapMapper {
    int countByExample(ColseqgenedecmapExample example);

    int deleteByExample(ColseqgenedecmapExample example);

    int deleteByPrimaryKey(Long colseqgenedecmapId);

    int insert(Colseqgenedecmap record);

    int insertSelective(Colseqgenedecmap record);

    List<Colseqgenedecmap> selectByExample(ColseqgenedecmapExample example);

    Colseqgenedecmap selectByPrimaryKey(Long colseqgenedecmapId);

    int updateByExampleSelective(@Param("record") Colseqgenedecmap record, @Param("example") ColseqgenedecmapExample example);

    int updateByExample(@Param("record") Colseqgenedecmap record, @Param("example") ColseqgenedecmapExample example);

    int updateByPrimaryKeySelective(Colseqgenedecmap record);

    int updateByPrimaryKey(Colseqgenedecmap record);
}