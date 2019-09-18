package com.llz.mybatisplus.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llz.mybatisplus.base.entity.BasicCity;
import com.llz.mybatisplus.base.mapper.BasicCityMapper;
import com.llz.mybatisplus.base.service.IBasicCityService;
import com.llz.mybatisplus.base.utils.IdUtils;
import com.mysql.cj.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
@Service
public class BasicCityServiceImpl extends ServiceImpl<BasicCityMapper, BasicCity> implements IBasicCityService {
	
	@Transactional
	@Override
	public boolean removeById(Serializable id) {
		int deleteById = this.baseMapper.deleteById(id);
		if (deleteById>0) {
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean regist(String areaCode, String cityName, String cityNumber, String cityType, String provinceId) {
		//查询同一省份下有没有相同名称城市
		QueryWrapper<BasicCity> queryWrapper = new QueryWrapper<BasicCity>();
		queryWrapper.eq("province_id", provinceId);
		queryWrapper.eq("city_name", cityName);
		queryWrapper.last("LIMIT 1");
		BasicCity one = getOne(queryWrapper);
		if (null != one) {
			return true;
		}
		
		//新增城市
		BasicCity city = new BasicCity();
		city.setAreaCode(areaCode);
		city.setCityName(cityName);
		city.setCityNumber(cityNumber);
		city.setCityType(cityType);
		city.setId(IdUtils.getUUID());
		city.setProvinceId(provinceId);
		return save(city);
	}

	@Override
	public boolean update(String id, String areaCode, String cityName, String cityNumber, String cityType,
			String provinceId) {
		BasicCity one = getById(id);
		if (null == one) {
			return false;
		}
		one.setAreaCode(areaCode);
		one.setCityName(cityName);
		one.setCityNumber(cityNumber);
		one.setCityType(cityType);
		one.setProvinceId(provinceId);
		return updateById(one);
	}

	@Override
	public IPage<BasicCity> page(Integer currentPage, Integer pageSize, String areaCode, String cityName,
			String cityNumber, String cityType, String provinceId) {
		QueryWrapper<BasicCity> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(areaCode), "area_code", areaCode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityName), "city_name", cityName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityNumber), "city_number", cityNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityType), "city_type", cityType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceId), "province_id", provinceId);
		Page<BasicCity> page = new Page<>(currentPage, pageSize);
		return this.baseMapper.selectPage(page, queryWrapper);
	}

	@Override
	public List<BasicCity> list(String areaCode, String cityName, String cityNumber, String cityType,
			String provinceId) {
		QueryWrapper<BasicCity> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(areaCode), "area_code", areaCode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityName), "city_name", cityName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityNumber), "city_number", cityNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityType), "city_type", cityType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceId), "province_id", provinceId);
		return this.baseMapper.selectList(queryWrapper);
	}

}
