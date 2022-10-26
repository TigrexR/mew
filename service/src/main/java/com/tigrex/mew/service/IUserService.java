package com.tigrex.mew.service;

import com.tigrex.mew.entity.bo.UserBO;
import com.tigrex.mew.entity.dto.UserDTO;
import com.tigrex.mew.entity.query.UserQuery;
import org.springframework.retry.annotation.Retryable;

/**
 * @author linus
 */
public interface IUserService {

    /**
     * get user
     * @param userQuery
     * @return userBO
     */
    UserBO getUser(UserQuery userQuery);
}