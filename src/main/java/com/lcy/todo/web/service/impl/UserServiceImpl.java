package com.lcy.todo.web.service.impl;

import com.lcy.todo.web.model.Result;
import com.lcy.todo.web.model.User;
import com.lcy.todo.web.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @author Lcy
 * @date 2019/1/23 22:11
 */
@Component
public class UserServiceImpl implements UserService {
    @Override
    public Result register(User user) {
        return null;
    }

    @Override
    public boolean activate(String userId) {
        return false;
    }

    /**
     * 给密码加密
     *
     * @param pwd
     * @param slat
     * @return
     */
    public static String m5Password(String pwd,String slat) {
        String md5Hex = DigestUtils.md5Hex(pwd+slat).toUpperCase();
        return md5Hex;
    }
}
