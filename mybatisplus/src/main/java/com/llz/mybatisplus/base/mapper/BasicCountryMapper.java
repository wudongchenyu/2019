package com.llz.mybatisplus.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llz.mybatisplus.base.dto.BasicCountryDto;
import com.llz.mybatisplus.base.entity.BasicCountry;

@Mapper
public interface BasicCountryMapper extends BaseMapper<BasicCountry>{

	@Select(value = { "SELECT id,country_name,area_code FROM basic_country" })
	@Results(value = {
			@Result(column = "id", property = "id"),
			@Result(column = "country_name", property = "countryName"),
			@Result(column = "area_code", property = "areaCode"),
	})
	List<BasicCountryDto> listSelect();

}
