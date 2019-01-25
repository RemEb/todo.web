package com.lcy.todo.web.service.impl;

import com.lcy.todo.web.dao.BmAuthCodeMapper;
import com.lcy.todo.web.dao.BmUserMapper;
import com.lcy.todo.web.dataobject.BmAuthCode;
import com.lcy.todo.web.service.AuthCodeService;
import com.lcy.todo.web.service.UserService;
import com.lcy.todo.web.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Date;

/**
 * @author Lcy
 * @date 2019/1/23 22:12
 */
@Component
@Path("code")
public class AuthCodeServiceImpl implements AuthCodeService {
    @Autowired
    BmAuthCodeMapper bmAuthCodeMapper;

    @Autowired
    UserService userService;

    @Autowired
    BmUserMapper bmUserMapper;

    private BmAuthCode bmAuthCode = new BmAuthCode();

    /**
     * 生成验证码
     *
     * @param email
     * @return
     */
    @Override
    public String generate(String email) {
        //用此部分代码来保证不重复存取一个用户的激活码
        //后期也可用来更新该用户的激活码
        String userId = bmUserMapper.selectByEmailKey(email).getId();
        if (bmAuthCodeMapper.selectByUserIdKey(userId) != null){
            return bmAuthCodeMapper.selectByUserIdKey(userId).getId();
        }
        //通过while循环保证激活码是唯一的
        String code = IDUtil.getId().substring(0,6);
        while (bmAuthCodeMapper.selectByPrimaryKey(code) != null){
            code = IDUtil.getId().substring(0,6);
        }

        bmAuthCode.setId(code);
        bmAuthCode.setUserId(userId);
        bmAuthCode.setGmtCreated(new Date());
        bmAuthCode.setGmtModified(new Date());
        bmAuthCodeMapper.insert(bmAuthCode);

        return code;
    }

    /**
     * 验证 激活码
     *
     * @param code
     */
    @Override
    @POST
    @Path("/verify")
    public void activate(@QueryParam("code") String code) {
        BmAuthCode bmAuthCode = bmAuthCodeMapper.selectByPrimaryKey(code);
        if (bmAuthCode == null){
            return;
        }
        userService.activate(bmAuthCode.getUserId());
    }

}
