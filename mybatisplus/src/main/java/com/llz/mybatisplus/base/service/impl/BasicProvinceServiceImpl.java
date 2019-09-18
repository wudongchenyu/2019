package com.llz.mybatisplus.base.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llz.mybatisplus.base.entity.BasicProvince;
import com.llz.mybatisplus.base.mapper.BasicProvinceMapper;
import com.llz.mybatisplus.base.service.IBasicProvinceService;
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
public class BasicProvinceServiceImpl extends ServiceImpl<BasicProvinceMapper, BasicProvince> implements IBasicProvinceService {

	@Transactional
	@Override
	public boolean regist(String provinceName, String provinceNumber, String provinceType, String countryId) {
		QueryWrapper<BasicProvince> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceName), "province_name", provinceName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryId), "country_id", countryId);
		queryWrapper.last("LIMIT 1");
		BasicProvince one = getOne(queryWrapper);
		if (one != null) {
			return true;
		}
		one = new BasicProvince();
		one.setId(IdUtils.getUUID());
		one.setProvinceName(provinceName);
		one.setProvinceNumber(provinceNumber);
		one.setProvinceType(provinceType);
		one.setCountryId(countryId);
		return save(one);
	}

	@Transactional
	@Override
	public boolean update(String id, String provinceName, String provinceNumber, String provinceType, String countryId) {
		BasicProvince province = getById(id);
		if (null == province) {
			return false;
		}
		province.setProvinceName(provinceName);
		province.setProvinceNumber(provinceNumber);
		province.setProvinceType(provinceType);
		province.setCountryId(countryId);
		return updateById(province);
	}

	@Override
	public IPage<BasicProvince> page(Integer currentPage, Integer pageSize, String provinceName, String provinceNumber,
			String provinceType, String countryId) {
		QueryWrapper<BasicProvince> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceName), "province_name", provinceName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceNumber), "province_number", provinceNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceType), "province_type", provinceType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryId), "country_id", countryId);
		Page<BasicProvince> page = new Page<>(currentPage, pageSize);
		return this.baseMapper.selectPage(page, queryWrapper);
	}

	@Override
	public List<BasicProvince> list(String provinceName, String provinceNumber, String provinceType, String countryId) {
		QueryWrapper<BasicProvince> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceName), "province_name", provinceName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceNumber), "province_number", provinceNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(provinceType), "province_type", provinceType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countryId), "country_id", countryId);
		return this.baseMapper.selectList(queryWrapper);
	}

}
