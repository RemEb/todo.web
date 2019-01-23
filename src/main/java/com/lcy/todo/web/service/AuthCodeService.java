package com.lcy.todo.web.service;

/**
 * @author Lcy
 * @date 2019/1/23 22:07
 */
public interface AuthCodeService {
    String generate(String email);

    void activate(String code);
}
