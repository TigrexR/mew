package com.tigrex.mew.controller;

import com.tigrex.core.entity.BaseResponse;
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

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public BaseResponse<UserVO> get(@RequestBody() UserQuery userQuery) {
        return new BaseResponse<UserVO>().success("OK", JacksonUtils.getJackson().convertValue(userService.getUser(userQuery), UserVO.class), "1.0.0");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BaseResponse<Boolean> save(@RequestBody() UserQuery userQuery) {
        return new BaseResponse<Boolean>().success("OK", userService.save(userQuery), "1.0.0");
    }
}
