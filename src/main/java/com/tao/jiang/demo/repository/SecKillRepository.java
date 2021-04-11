package com.tao.jiang.demo.repository;

import com.tao.jiang.demo.entity.Seckill;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SecKillRepository {

    /**
     * 减库存
     * @param seckKillId
     * @param killTime
     * @return
     */
    int reduceNum(long seckKillId, Date killTime);

    /**
     *
     * @return
     */
    Seckill queryById(long seckKillId);

    /**
     *
     * @return
     */
    List<Seckill> queryAll();
}
