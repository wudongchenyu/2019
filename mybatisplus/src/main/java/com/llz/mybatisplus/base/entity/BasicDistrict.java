package com.llz.mybatisplus.base.entity;

import java.io.Serializable;

import jdk.jfr.Description;
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
public class BasicDistrict implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Description(value = "所属城市")
    private String cityId;

    @Description(value = "全称")
    private String districtName;

    @Description(value = "编号")
    private String districtNumber;

    @Description(value = "类型")
    private String districtType;
    
    @Description(value = "简称")
    private String abbreviation;

    @Description(value = "邮编")
    private String postcode;


}
