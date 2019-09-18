package com.llz.mybatisplus.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llz.mybatisplus.base.entity.BasicDistrict;
import com.llz.mybatisplus.base.mapper.BasicDistrictMapper;
import com.llz.mybatisplus.base.service.IBasicDistrictService;
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
public class BasicDistrictServiceImpl extends ServiceImpl<BasicDistrictMapper, BasicDistrict> implements IBasicDistrictService {

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
	public boolean regist(String postcode, String districtName, String districtNumber, String districtType, String cityId) {
		//查询同一省份下有没有相同名称城市
		QueryWrapper<BasicDistrict> queryWrapper = new QueryWrapper<BasicDistrict>();
		queryWrapper.eq("city_id", cityId);
		queryWrapper.eq("district_name", districtName);
		queryWrapper.last("LIMIT 1");
		BasicDistrict one = getOne(queryWrapper);
		if (null != one) {
			return true;
		}
		
		//新增城市
		BasicDistrict district = new BasicDistrict();
		district.setPostcode(postcode);
		district.setDistrictName(districtName);
		district.setDistrictNumber(districtNumber);
		district.setDistrictType(districtType);
		district.setId(IdUtils.getUUID());
		district.setCityId(cityId);
		return save(district);
	}

	@Override
	public boolean update(String id, String postcode, String districtName, String districtNumber, String districtType,
			String cityId) {
		BasicDistrict one = getById(id);
		if (null == one) {
			return false;
		}
		one.setPostcode(postcode);
		one.setDistrictName(districtName);
		one.setDistrictNumber(districtNumber);
		one.setDistrictType(districtType);
		one.setCityId(cityId);
		return updateById(one);
	}

	@Override
	public IPage<BasicDistrict> page(Integer currentPage, Integer pageSize, String postcode, String districtName,
			String districtNumber, String districtType, String cityId) {
		QueryWrapper<BasicDistrict> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(postcode), "postcode", postcode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtName), "district_name", districtName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtNumber), "district_number", districtNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtType), "district_type", districtType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityId), "city_id", cityId);
		Page<BasicDistrict> page = new Page<>(currentPage, pageSize);
		return this.baseMapper.selectPage(page, queryWrapper);
	}

	@Override
	public List<BasicDistrict> list(String postcode, String districtName, String districtNumber, String districtType,
			String cityId) {
		QueryWrapper<BasicDistrict> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(postcode), "postcode", postcode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtName), "district_name", districtName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtNumber), "district_number", districtNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtType), "district_type", districtType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(cityId), "city_id", cityId);
		return this.baseMapper.selectList(queryWrapper);
	}
	
}
