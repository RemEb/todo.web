package com.lcy.todo.web.service;

/**
 * @author Lcy
 * @date 2019/1/23 22:09
 */
public interface EmailService {
    void send(String to,String subject,String text);
}
