package com.lcy.todo.web.service.impl;

import com.lcy.todo.web.service.AuthCodeService;
import org.springframework.stereotype.Component;

/**
 * @author Lcy
 * @date 2019/1/23 22:12
 */
@Component
public class AuthCodeServiceImpl implements AuthCodeService {
    @Override
    public String generate(String email) {
        return null;
    }

    @Override
    public void activate(String code) {

    }
}
