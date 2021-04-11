package com.tao.jiang.demo.repository;

import com.tao.jiang.demo.entity.SuccessKill;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessKillRepository {

    /**
     *
     * @param seckKillId
     * @param userPhone
     * @return
     */
    int insertSuccessKill(long seckKillId, long userPhone);

    /**
     *
     * @param seckKillId
     * @return
     */
    SuccessKill queryByIdWithSeckill(long seckKillId);
}
