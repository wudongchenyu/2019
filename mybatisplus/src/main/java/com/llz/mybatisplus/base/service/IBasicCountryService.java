package com.llz.mybatisplus.base.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.llz.mybatisplus.base.dto.BasicCountryDto;
import com.llz.mybatisplus.base.entity.BasicCountry;

public interface IBasicCountryService extends IService<BasicCountry> {

	boolean regist(String countryName, String countryNumber, String countryType, String abbreviation, String areaCode,
			String remake, String location, String phoneCode);

	boolean update(String id, String countryName, String countryNumber, String countryType, String abbreviation,
			String areaCode, String remake, String location, String phoneCode);

	IPage<BasicCountry> page(Integer currentPage, Integer pageSize, String countryName, String countryNumber,
			String countryType, String abbreviation, String areaCode, String remake, String location, String phoneCode);

	List<BasicCountry> list(String countryName, String countryNumber, String countryType, String abbreviation,
			String areaCode, String remake, String location, String phoneCode);

	boolean validator(String countryName);

	List<BasicCountryDto> listSelect();

}
