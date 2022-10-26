package com.tigrex.mew.service.impl;

import com.tigrex.mew.entity.bo.UserBO;
import com.tigrex.mew.entity.query.UserQuery;
import com.tigrex.mew.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Override
    public UserBO getUser(UserQuery userQuery) {
        return new UserBO().setId(1).setCode("george").setName("乔治").setAge(13).setGender("man");
    }
}
