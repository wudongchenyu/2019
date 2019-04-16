package com.llz.mybatisplus.base.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BasicUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private LocalDateTime createTime;

    private String creater;

    private String email;

    private String mobile;

    private String password;

    private String roleId;

    private LocalDateTime updateTime;

    private String updater;

    private String userName;

    private String userNumber;


}
