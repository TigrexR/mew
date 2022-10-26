package com.tigrex.mew.entity.dto.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Message<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private T data;
    private Date date;
}
