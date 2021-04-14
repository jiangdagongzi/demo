package com.tao.jiang.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class User {
    @Id
    @JsonIgnore
    private String id;

    private String userName;

    @JsonIgnore
    private Integer auth;

    @JsonIgnore
    private String password;

    private Date createTime;

    @JsonIgnore
    private Date lastLogin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", auth=" + auth +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", lastLogin=" + lastLogin +
                '}';
    }

    public enum Role {
        NORMAL(
                Privilege.LOGIN,
                Privilege.LOGOUT),

        ADMIN(
                NORMAL,
                Privilege.MODIFY_INFO
                );

        Role(Privilege... privileges) {
            this.privileges = privileges;
        }


        public Privilege[] getPrivileges() {
            return privileges;
        }

        private Privilege[] privileges;

        Role(Role role, Privilege... privileges) {
            this.privileges = new Privilege[role.getPrivileges().length + privileges.length];
            System.arraycopy(role.getPrivileges(),0,this.privileges, 0, role.getPrivileges().length);
            System.arraycopy(privileges, 0, this.privileges, role.getPrivileges().length,  privileges.length);
        }
        public boolean hasPrivilege(Privilege privilege){
            return !(privilege == null || ArrayUtils.isEmpty(this.privileges))&& ArrayUtils.contains(this.privileges, privilege);
        }
    }

    public enum Privilege {
        LOGIN,
        LOGOUT,
        MODIFY_INFO
    }

}