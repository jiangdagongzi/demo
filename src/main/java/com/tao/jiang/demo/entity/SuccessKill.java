package com.tao.jiang.demo.entity;

import java.util.Date;

public class SuccessKill extends SuccessKillKey {
    private Integer state;

    private Date createTime;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}