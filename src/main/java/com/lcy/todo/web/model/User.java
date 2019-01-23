package com.lcy.todo.web.model;

/**
 * @author Lcy
 * @date 2019/1/23 21:22
 */
public class User extends LoginUser {
    /**
     * 密码
     */
    private String pwd;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 激活状态
     */
    private UserStatus status;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
