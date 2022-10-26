package com.tigrex.mew.service;

import com.tigrex.mew.entity.bo.UserBO;
import com.tigrex.mew.entity.query.UserQuery;

/**
 * @author linus
 */
public interface UserService {

    /**
     * get user
     * @param userQuery
     * @return userBO
     */
    UserBO getUser(UserQuery userQuery);
}