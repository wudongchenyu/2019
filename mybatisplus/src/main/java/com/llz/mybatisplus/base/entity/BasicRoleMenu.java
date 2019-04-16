package com.llz.mybatisplus.base.entity;

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
public class BasicRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String roleId;

    private String userId;


}
