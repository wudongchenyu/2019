package com.llz.mybatisplus.base.service.impl;

import com.llz.mybatisplus.base.entity.BasicCity;
import com.llz.mybatisplus.base.mapper.BasicCityMapper;
import com.llz.mybatisplus.base.service.IBasicCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	private @Autowired BasicCityMapper basicCityMapper;
	
	@Override
	public boolean removeById(Serializable id) {
		int deleteById = basicCityMapper.deleteById(id);
		if (deleteById>0) {
			return true;
		}
		return false;
	}

}
