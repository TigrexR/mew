package com.tigrex.mew.controller.hessian;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mew.api.hessian.UserHessian;
import com.tigrex.mew.entity.dto.UserDTO;
import com.tigrex.mew.entity.query.UserQuery;
import com.tigrex.mew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linus
 */
@Component(value = "userHessian")
public class UserController implements UserHessian {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO getUser(UserQuery query) {
        return JacksonUtils.getJackson().convertValue(userService.getUser(query), UserDTO.class);
    }
}
