package com.lcy.todo.web.service.impl;

import com.lcy.todo.web.dao.BmUserMapper;
import com.lcy.todo.web.dataobject.BmUser;
import com.lcy.todo.web.service.AuthCodeService;
import com.lcy.todo.web.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Lcy
 * @date 2019/1/24 16:32
 */
@Component
public class EmailTask {
    private static final Logger log = LoggerFactory.getLogger(EmailTask.class);

   @Autowired
    BmUserMapper bmUserMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AuthCodeService authCodeService;


    @Scheduled(fixedRate = 10000)
    public void emailSend() {
        List<BmUser> users = bmUserMapper.selectAll();
        for (BmUser user : users){
            if (user.getStatus().equals("DISABLED")){
                emailService.send(user.getEmail(),"ActivateCode",authCodeService.generate(user.getEmail()));
                log.info(user.getEmail()+":邮件发送成功!");
            }
        }



    }
}
