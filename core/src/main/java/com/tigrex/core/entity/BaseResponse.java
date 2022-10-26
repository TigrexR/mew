package com.tigrex.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public BaseResponse<T> success(String msg, T data, String version) {
        return new BaseResponse<>(0, msg, data, version);
    }

    public BaseResponse<T> fail(String msg, T data, String version) {
        return new BaseResponse<>(1, msg, data, version);
    }

    private Integer code;
    private String msg;
    private T data;
    private String version;
}
