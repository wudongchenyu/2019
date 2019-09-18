package com.llz.mybatisplus.base.entity;

import java.io.Serializable;

import jdk.jfr.Description;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 村
 * @author wudon
 * 2019年9月4日下午2:06:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BasicVillage implements Serializable{

	/**
	 * @author wudon
	 * 2019年9月4日下午2:08:31
	 */
	private static final long serialVersionUID = 1882822250586444469L;

	private String id;

	@Description(value = "区域编码")
    private String areaCode;
    
	@Description(value = "邮编")
    private String postcode;

	@Description(value = "全称")
    private String villageName;

	@Description(value = "编号")
    private String villageNumber;

	@Description(value = "类型")
    private String villageType;

	@Description(value = "所属乡镇")
    private String countrysideId;
    
	@Description(value = "备注")
    private String remake;
	
}
