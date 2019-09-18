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
public class BasicProvince implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Description(value = "全称")
    private String provinceName;

    @Description(value = "编号")
    private String provinceNumber;

    @Description(value = "类型")
    private String provinceType;
    
    @Description(value = "所属国家")
    private String countryId;
    
    @Description(value = "简称")
    private String abbreviation;
    
    @Description(value = "备注")
    private String remake;


}
