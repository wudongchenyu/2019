package com.llz.mybatisplus.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llz.mybatisplus.base.dto.BasicCountryDto;
import com.llz.mybatisplus.base.entity.BasicCountry;
import com.llz.mybatisplus.base.mapper.BasicCountryMapper;
import com.llz.mybatisplus.base.service.IBasicCountryService;
import com.llz.mybatisplus.base.utils.IdUtils;
import com.mysql.cj.util.StringUtils;

@Service
public class BasicCountryServiceImpl extends ServiceImpl<BasicCountryMapper, BasicCountry>
		implements IBasicCountryService {

	@Transactional
	@Override
	public boolean removeById(Serializable id) {
		int deleteById = this.baseMapper.deleteById(id);
		if (deleteById > 0) {
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean regist(String countryName, String countryNumber, String countryType, String abbreviation,
			String areaCode, String remake, String location, String phoneCode) {
		QueryWrapper<BasicCountry> queryWrapper = new QueryWrapper<BasicCountry>();
		queryWrapper.eq("country_name", countryName);
		queryWrapper.last("LIMIT 1");
		BasicCountry one = getOne(queryWrapper);
		if (null != one) {
			return true;
		}

		BasicCountry country = new BasicCountry();
		country.setCountryName(countryName);
		country.setCountryNumber(countryNumber);
		country.setCountryType(countryType);
		country.setAbbreviation(abbreviation);
		country.setAreaCode(areaCode);
		country.setRemake(remake);
		country.setLocation(location);
		country.setId(IdUtils.getUUID());
		country.setPhoneCode(phoneCode);
		return save(country);
	}

	@Override
	public boolean update(String id, String countryName, String countryNumber, String countryType, String abbreviation,
			String areaCode, String remake, String location, String phoneCode) {
		BasicCountry one = getById(id);
		if (null == one) {
			return false;
		}
		one.setCountryName(countryName);
		one.setCountryNumber(countryNumber);
		one.setCountryType(countryType);
		one.setAbbreviation(abbreviation);
		one.setAreaCode(areaCode);
		one.setRemake(remake);
		one.setLocation(location);
		one.setPhoneCode(phoneCode);
		return updateById(one);
	}

	@Override
	public IPage<BasicCountry> page(Integer currentPage, Integer pageSize, String countryName, String countryNumber,
			String countryType, String abbreviation, String areaCode, String remake, String location, String phoneCode) {
		QueryWrapper<BasicCountry> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryName), "country_name", countryName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryNumber), "country_number", countryNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryType), "country_type", countryType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(abbreviation), "abbreviation", abbreviation);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(areaCode), "area_code", areaCode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(remake), "remake", remake);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(location), "location", location);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(phoneCode), "phone_code", phoneCode);
		queryWrapper.orderByAsc("abbreviation");
		Page<BasicCountry> page = new Page<>(currentPage, pageSize);
		IPage<BasicCountry> selectPage = this.baseMapper.selectPage(page, queryWrapper);
		return selectPage;
	}

	@Override
	public List<BasicCountry> list(String countryName, String countryNumber, String countryType, String abbreviation,
			String areaCode, String remake, String location, String phoneCode) {
		QueryWrapper<BasicCountry> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryName), "country_name", countryName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryNumber), "country_number", countryNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryType), "country_type", countryType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(abbreviation), "abbreviation", abbreviation);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(areaCode), "area_code", areaCode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(remake), "remake", remake);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(location), "location", location);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(phoneCode), "phone_code", phoneCode);
		queryWrapper.orderByAsc("abbreviation");
		return this.baseMapper.selectList(queryWrapper);
	}

	@Override
	public boolean validator(String countryName) {
		QueryWrapper<BasicCountry> queryWrapper = new QueryWrapper<BasicCountry>();
		queryWrapper.eq("country_name", countryName);
		queryWrapper.last("LIMIT 1");
		BasicCountry one = getOne(queryWrapper);
		if (null == one) {
			return true;
		}
		return false;
	}

	@Override
	public List<BasicCountryDto> listSelect() {
		return this.baseMapper.listSelect();
	}

}
