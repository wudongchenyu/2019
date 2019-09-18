package com.llz.mybatisplus.base.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llz.mybatisplus.base.entity.BasicCity;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
@Mapper
public interface BasicCityMapper extends BaseMapper<BasicCity>{

	
	void save(BasicCity city);
	
}
