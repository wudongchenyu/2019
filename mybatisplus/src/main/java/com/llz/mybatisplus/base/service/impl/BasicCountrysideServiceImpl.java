package com.llz.mybatisplus.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llz.mybatisplus.base.entity.BasicCountryside;
import com.llz.mybatisplus.base.mapper.BasicCountrysideMapper;
import com.llz.mybatisplus.base.service.IBasicCountrysideService;
import com.llz.mybatisplus.base.utils.IdUtils;
import com.mysql.cj.util.StringUtils;

@Service
public class BasicCountrysideServiceImpl extends ServiceImpl<BasicCountrysideMapper, BasicCountryside> implements IBasicCountrysideService{

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
	public boolean regist(String postcode, String countrysideName, String countrysideNumber, String countrysideType, String districtId) {
		//查询同一省份下有没有相同名称城市
		QueryWrapper<BasicCountryside> queryWrapper = new QueryWrapper<BasicCountryside>();
		queryWrapper.eq("district_id", districtId);
		queryWrapper.eq("countryside_name", countrysideName);
		queryWrapper.last("LIMIT 1");
		BasicCountryside one = getOne(queryWrapper);
		if (null != one) {
			return true;
		}
		
		//新增城市
		BasicCountryside countryside = new BasicCountryside();
		countryside.setPostcode(postcode);
		countryside.setCountrysideName(countrysideName);
		countryside.setCountrysideNumber(countrysideNumber);
		countryside.setCountrysideType(countrysideType);
		countryside.setId(IdUtils.getUUID());
		countryside.setDistrictId(districtId);
		return save(countryside);
	}

	@Override
	public boolean update(String id, String postcode, String countrysideName, String countrysideNumber, String countrysideType,
			String districtId) {
		BasicCountryside one = getById(id);
		if (null == one) {
			return false;
		}
		one.setPostcode(postcode);
		one.setCountrysideName(countrysideName);
		one.setCountrysideNumber(countrysideNumber);
		one.setCountrysideType(countrysideType);
		one.setDistrictId(districtId);
		return updateById(one);
	}

	@Override
	public IPage<BasicCountryside> page(Integer currentPage, Integer pageSize, String postcode, String countrysideName,
			String countrysideNumber, String countrysideType, String districtId) {
		QueryWrapper<BasicCountryside> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(postcode), "postcode", postcode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideName), "countryside_name", countrysideName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideNumber), "countryside_number", countrysideNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideType), "countryside_type", countrysideType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtId), "district_id", districtId);
		Page<BasicCountryside> page = new Page<>(currentPage, pageSize);
		return this.baseMapper.selectPage(page, queryWrapper);
	}

	@Override
	public List<BasicCountryside> list(String postcode, String countrysideName, String countrysideNumber, String countrysideType,
			String districtId) {
		QueryWrapper<BasicCountryside> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(postcode), "postcode", postcode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideName), "countryside_name", countrysideName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideNumber), "countryside_number", countrysideNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideType), "countryside_type", countrysideType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(districtId), "district_id", districtId);
		return this.baseMapper.selectList(queryWrapper);
	}
	
}
