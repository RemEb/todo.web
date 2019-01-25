package com.lcy.todo.web.service.impl;

import com.lcy.todo.web.dao.BmUserMapper;
import com.lcy.todo.web.dataobject.BmUser;
import com.lcy.todo.web.model.Result;
import com.lcy.todo.web.model.User;
import com.lcy.todo.web.model.UserStatus;
import com.lcy.todo.web.service.AuthCodeService;
import com.lcy.todo.web.service.EmailService;
import com.lcy.todo.web.service.UserService;
import com.lcy.todo.web.util.IDUtil;
import com.sun.mail.imap.protocol.ID;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;


/**
 * @author Lcy
 * @date 2019/1/23 22:11
 */
@Component
@Path("user")
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private AuthCodeService authCodeService;

    @Autowired
    BmUserMapper bmUserMapper;

    private static final Logger log = LoggerFactory.getLogger(EmailTask.class);

    private BmUser bmUser = new BmUser();

    /**
     * 用户注册 生成验证码 发送邮件
     *
     * @param user
     * @return
     */
    @Override
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Result register(User user) {
        Result result = new Result();
        if (user.getEmail() == null || user.getEmail().equals("")) {
            result.setErrorMessage("邮箱未输入");
            result.setSuccess(false);
            result.setData(user);
            result.setErrorCode("1");
            return result;
        }
        if (user.getPwd() == null || user.getPwd().equals("")) {
            result.setSuccess(false);
            result.setErrorCode("2");
            result.setData(user);
            result.setErrorMessage("密码未输入");
            return result;
        }
        if (bmUserMapper.selectByEmailKey(user.getEmail()) != null) {
            result.setSuccess(false);
            result.setErrorCode("3");
            result.setData(user);
            result.setErrorMessage("邮箱已存在");
            return result;
        }
        result.setSuccess(true);
        result.setData(user);

        user.setUserId(IDUtil.getId());
        user.setStatus(UserStatus.DISABLED);

        bmUser.setId(user.getUserId());
        bmUser.setEmail(user.getEmail());
        bmUser.setStatus(String.valueOf(user.getStatus()));
        bmUser.setSalt(user.getSalt());
        bmUser.setRegTime(user.getRegTime());
        bmUser.setGmtModified(new Date());
        bmUser.setGmtCreated(new Date());
        bmUser.setPwd(m5Password(user.getPwd(), user.getSalt()));
        bmUser.setGender(String.valueOf(user.getGender()));
        bmUser.setBirthday(user.getBirthday());
        bmUserMapper.insert(bmUser);

        return result;
    }

    /**
     * 激活账号
     *
     * @param userId
     * @return
     */
    @Override
    public boolean activate(String userId) {
        boolean isActivate = false;
        BmUser user = bmUserMapper.selectByPrimaryKey(userId);
        if (user == null){
            return isActivate;
        }
        user.setStatus("ENABLED");
        bmUserMapper.updateByPrimaryKey(user);
        isActivate = true;
        log.info(userId+":激活成功！");
        return isActivate;
    }

    /**
     * 给密码加密
     *
     * @param pwd
     * @param slat
     * @return
     */
    public static String m5Password(String pwd, String slat) {
        String md5Hex = DigestUtils.md5Hex(pwd + slat).toUpperCase();
        return md5Hex;
    }
}
