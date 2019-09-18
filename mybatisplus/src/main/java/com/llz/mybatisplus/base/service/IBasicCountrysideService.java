package com.llz.mybatisplus.base.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.llz.mybatisplus.base.entity.BasicCountryside;

public interface IBasicCountrysideService extends IService<BasicCountryside>{

	boolean regist(String areaCode, String countrysideName, String countrysideNumber, String countrysideType, String districtId);

	boolean update(String id, String areaCode, String countrysideName, String countrysideNumber, String countrysideType, String districtId);

	IPage<BasicCountryside> page(Integer currentPage, Integer pageSize, String postcode, String countrysideName, String countrysideNumber,
			String countrysideType, String provinceId);

	List<BasicCountryside> list(String postcode, String countrysideName, String countrysideNumber, String countrysideType, String districtId);

	
}
