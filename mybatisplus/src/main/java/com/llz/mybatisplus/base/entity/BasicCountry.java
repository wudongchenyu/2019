package com.llz.mybatisplus.base.entity;

import java.io.Serializable;

import jdk.jfr.Description;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 县
 * @author wudon
 * 2019年9月4日下午2:07:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BasicCountry implements Serializable{

	/**
	 * @author wudon
	 * 2019年9月4日下午2:08:23
	 */
	private static final long serialVersionUID = 6372193274329349792L;

	private String id;

	@Description(value = "国家编号")
    private String areaCode;
	
	@Description(value = "电话编码")
    private String phoneCode;
    
    @Description(value = "全称")
    private String countryName;

    @Description(value = "国家编号")
    private String countryNumber;

    @Description(value = "类型")
    private String countryType;
    
    @Description(value = "简称")
    private String abbreviation;
    
    @Description(value = "位置")
    private String location;
    
    @Description(value = "备注")
    private String remake;
	
}
