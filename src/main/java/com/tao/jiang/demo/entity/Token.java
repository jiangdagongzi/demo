package com.tao.jiang.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Alias("Token")
public class Token {
    @Id
    private String id;

    private String token;

    @JsonIgnore
    private String ownerId;

    private String ownerName;

//    @JsonFormat(pattern = "yyyy-MM--dd HH:mm:ss")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
