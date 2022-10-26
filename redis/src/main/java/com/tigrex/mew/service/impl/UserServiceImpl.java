package com.tigrex.mew.service.impl;

import com.tigrex.core.utils.JacksonUtils;

import com.tigrex.mew.entity.bo.UserBO;
import com.tigrex.mew.entity.po.redis.User;
import com.tigrex.mew.entity.query.UserQuery;
import com.tigrex.mew.manager.redis.UserRedis;
import com.tigrex.mew.mapper.UserMapper;
import com.tigrex.mew.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRedis userTemplate;

    @Override
    public UserBO getUser(UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userTemplate.selectByKey(userQuery.getCode()), UserBO.class);
    }

    @Override
    public Boolean save(UserQuery userQuery) {
        userTemplate.insert(userQuery.getCode(), JacksonUtils.getJackson().convertValue(userQuery, User.class));
        return true;
    }
}
