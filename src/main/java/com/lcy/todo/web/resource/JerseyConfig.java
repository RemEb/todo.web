package com.lcy.todo.web.resource;

import com.lcy.todo.web.service.AuthCodeService;
import com.lcy.todo.web.service.impl.AuthCodeServiceImpl;
import com.lcy.todo.web.service.impl.EmailServiceImpl;
import com.lcy.todo.web.service.impl.EmailTask;
import com.lcy.todo.web.service.impl.UserServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author Lcy
 * @date 2019/1/23 22:12
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(UserServiceImpl.class);
        register(AuthCodeServiceImpl.class);
        register(EmailServiceImpl.class);
        register(EmailTask.class);
    }
}
