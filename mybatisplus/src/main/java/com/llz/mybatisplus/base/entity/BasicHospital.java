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
public class BasicHospital implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String cityId;

    private String classification;

    private LocalDateTime createTime;

    private String creater;

    private String districtId;

    private String hospitalName;

    private String hospitalNumber;

    private String level;

    private String ownership;

    private String provinceId;

    private LocalDateTime updateTime;

    private String updater;


}
