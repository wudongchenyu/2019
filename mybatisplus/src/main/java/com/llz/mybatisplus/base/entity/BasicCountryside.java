package com.llz.mybatisplus.base.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 乡
 * @author wudon
 * 2019年9月4日下午2:07:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BasicCountryside implements Serializable{

	/**
	 * @author wudon
	 * 2019年9月4日下午2:08:27
	 */
	private static final long serialVersionUID = -354704197160398426L;

	private String id;

    private String areaCode;
    
    private String postcode;

    private String countrysideName;

    private String countrysideNumber;

    private String countrysideType;

    private String districtId;
    
    private String remake;
	
}
