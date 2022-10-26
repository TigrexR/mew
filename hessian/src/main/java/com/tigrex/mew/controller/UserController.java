package com.tigrex.mew.controller;

import com.tigrex.core.entity.BaseResponse;
import com.tigrex.mew.api.hessian.UserHessian;
import com.tigrex.mew.entity.dto.UserDTO;
import com.tigrex.mew.entity.query.UserQuery;
import com.tigrex.mew.utils.HessianUtils;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

/**
 * @author linus
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @SneakyThrows
    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    public BaseResponse<UserDTO> getUser(@RequestBody() UserQuery query) {
        // 服务器暴露出的地址
        String url = "http://127.0.0.1:9001/userHessian.do";

        // 客户端接口，需与服务端对象一样
        UserHessian userHessian = HessianUtils.getHessianClientBean(UserHessian.class, url);
        UserDTO user = userHessian.getUser(query);
        return new BaseResponse<UserDTO>().success("OK", user, "1.0.0");
    }
}
