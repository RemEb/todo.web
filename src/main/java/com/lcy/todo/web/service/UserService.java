package com.lcy.todo.web.service;

import com.lcy.todo.web.model.Result;
import com.lcy.todo.web.model.User;

/**
 * @author Lcy
 * @date 2019/1/23 21:21
 */
public interface UserService {

    Result register(User user);

    boolean activate(String userId);

}
