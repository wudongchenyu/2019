package com.llz.mybatisplus.base.dto;

import java.util.List;

import jdk.jfr.Description;
import lombok.Data;

@Data
public class PermissionTree {
	
	@Description(value = "ID")
	private String id;
	
	@Description(value = "节点上的文本")
	private String text;
	
	@Description(value = "结合全局enableLinks选项为列表树节点指定URL")
	private String href;
	
	@Description(value = "编号")
	private String code;
	
	@Description(value = "父级编号")
	private String parentCode;
	
	@Description(value = "排序")
	private int order;
	
	private List<PermissionTree> nodes;

}
