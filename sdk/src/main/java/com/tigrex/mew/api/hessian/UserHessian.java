package com.tigrex.mew.api.hessian;

import com.tigrex.mew.entity.dto.UserDTO;
import com.tigrex.mew.entity.query.UserQuery;

/**
 * @author linus
 */
public interface UserHessian {

    /**
     * get user
     * @param query query
     * @return user
     */
    UserDTO getUser(UserQuery query);
}
