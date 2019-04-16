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
public class BasicPhysician implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private LocalDateTime createTime;

    private String creater;

    private String departmentId;

    private String doctorTitle;

    private String hospitalId;

    private String identityCard;

    private String medicalLicence;

    private String mobile;

    private String name;

    private String physicianNumber;

    private String sex;

    private String telePhone;

    private LocalDateTime updateTime;

    private String updater;


}
