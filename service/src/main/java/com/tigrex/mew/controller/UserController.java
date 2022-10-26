package com.tigrex.mew.controller;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mew.entity.query.UserQuery;
import com.tigrex.mew.entity.vo.UserVO;
import com.tigrex.mew.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author linus
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public UserVO getUser(@RequestBody() UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userService.getUser(userQuery), UserVO.class);
    }
}
