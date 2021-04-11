package com.tao.jiang.demo.mapper;

import com.tao.jiang.demo.entity.SuccessKill;
import com.tao.jiang.demo.entity.SuccessKillExample;
import com.tao.jiang.demo.entity.SuccessKillKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuccessKillMapper {
    int countByExample(SuccessKillExample example);

    int deleteByExample(SuccessKillExample example);

    int deleteByPrimaryKey(SuccessKillKey key);

    int insert(SuccessKill record);

    int insertSelective(SuccessKill record);

    List<SuccessKill> selectByExample(SuccessKillExample example);

    SuccessKill selectByPrimaryKey(SuccessKillKey key);

    int updateByExampleSelective(@Param("record") SuccessKill record, @Param("example") SuccessKillExample example);

    int updateByExample(@Param("record") SuccessKill record, @Param("example") SuccessKillExample example);

    int updateByPrimaryKeySelective(SuccessKill record);

    int updateByPrimaryKey(SuccessKill record);
}