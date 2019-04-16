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
public class BasicDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private LocalDateTime createTime;

    private String creater;

    private String departmentName;

    private String departmentNumber;

    private String hospitalId;

    private String parentId;

    private LocalDateTime updateTime;

    private String updater;


}
