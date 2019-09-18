package com.llz.mybatisplus.base.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.llz.mybatisplus.base.entity.BasicVillage;

public interface IBasicVillageService extends IService<BasicVillage>{

	boolean regist(String areaCode, String cityName, String cityNumber, String cityType, String provinceId);

	boolean update(String id, String areaCode, String cityName, String cityNumber, String cityType, String provinceId);

	IPage<BasicVillage> page(Integer currentPage, Integer pageSize, String postcode, String villageName, String villageNumber,
			String villageType, String provinceId);

	List<BasicVillage> list(String postcode, String villageName, String villageNumber, String villageType, String provinceId);

	
}
