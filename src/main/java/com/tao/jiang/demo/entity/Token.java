package com.tao.jiang.demo.entity;


import org.springframework.data.annotation.Id;

public class Token {
    @Id
    private String id;

    private String token;

    private String ownerId;

    private String ownerName;

    private String createTime;

//    public static Token createOneToken(){
//
//    }

}
