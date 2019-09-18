package com.llz.mybatisplus.base.dto;

import jdk.jfr.Description;
import lombok.Data;

@Data
public class BasicCountryDto {
	
	private String id;

	@Description(value = "国家编号")
    private String areaCode;
	
    @Description(value = "全称")
    private String countryName;

}
