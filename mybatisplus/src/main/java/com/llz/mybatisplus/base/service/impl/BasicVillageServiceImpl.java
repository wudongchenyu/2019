package com.llz.mybatisplus.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llz.mybatisplus.base.entity.BasicVillage;
import com.llz.mybatisplus.base.mapper.BasicVillageMapper;
import com.llz.mybatisplus.base.service.IBasicVillageService;
import com.llz.mybatisplus.base.utils.IdUtils;
import com.mysql.cj.util.StringUtils;

@Service
public class BasicVillageServiceImpl extends ServiceImpl<BasicVillageMapper, BasicVillage> implements IBasicVillageService{

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
	public boolean regist(String postcode, String villageName, String villageNumber, String villageType, String countrysideId) {
		//查询同一省份下有没有相同名称城市
		QueryWrapper<BasicVillage> queryWrapper = new QueryWrapper<BasicVillage>();
		queryWrapper.eq("countryside_id", countrysideId);
		queryWrapper.eq("village_name", villageName);
		queryWrapper.last("LIMIT 1");
		BasicVillage one = getOne(queryWrapper);
		if (null != one) {
			return true;
		}
		
		//新增城市
		BasicVillage village = new BasicVillage();
		village.setPostcode(postcode);
		village.setVillageName(villageName);
		village.setVillageNumber(villageNumber);
		village.setVillageType(villageType);
		village.setId(IdUtils.getUUID());
		village.setCountrysideId(countrysideId);
		return save(village);
	}

	@Override
	public boolean update(String id, String postcode, String villageName, String villageNumber, String villageType,
			String countrysideId) {
		BasicVillage one = getById(id);
		if (null == one) {
			return false;
		}
		one.setPostcode(postcode);
		one.setVillageName(villageName);
		one.setVillageNumber(villageNumber);
		one.setVillageType(villageType);
		one.setCountrysideId(countrysideId);
		return updateById(one);
	}

	@Override
	public IPage<BasicVillage> page(Integer currentPage, Integer pageSize, String postcode, String villageName,
			String villageNumber, String villageType, String countrysideId) {
		QueryWrapper<BasicVillage> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(postcode), "postcode", postcode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(villageName), "village_name", villageName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(villageNumber), "village_number", villageNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(villageType), "village_type", villageType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideId), "countryside_id", countrysideId);
		Page<BasicVillage> page = new Page<>(currentPage, pageSize);
		return this.baseMapper.selectPage(page, queryWrapper);
	}

	@Override
	public List<BasicVillage> list(String postcode, String villageName, String villageNumber, String villageType,
			String countrysideId) {
		QueryWrapper<BasicVillage> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(postcode), "postcode", postcode);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(villageName), "village_name", villageName);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(villageNumber), "village_number", villageNumber);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(villageType), "village_type", villageType);
		queryWrapper.eq(!StringUtils.isEmptyOrWhitespaceOnly(countrysideId), "countryside_id", countrysideId);
		return this.baseMapper.selectList(queryWrapper);
	}
	
}
