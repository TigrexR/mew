package com.tigrex.mew.entity.po.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    private static final long serialVersionUID = 1;
    private Integer id;
    private String code;
    private String name;
    private Integer age;
    private String gender;
    private String password;
}
