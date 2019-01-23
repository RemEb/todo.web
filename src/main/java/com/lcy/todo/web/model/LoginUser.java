package com.lcy.todo.web.model;

import java.util.Date;

/**
 * @author Lcy
 * @date 2019/1/23 21:57
 */
public class LoginUser {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 登陆时间
     */
    private Date regTime;
    /**
     * 性别
     */
    private Gender gender;
    /**
     * 生日
     */
    private Date birthday;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
