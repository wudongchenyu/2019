package com.llz.mybatisplus.base.service;

import com.llz.mybatisplus.base.entity.BasicCity;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
public interface IBasicCityService extends IService<BasicCity> {

	boolean regist(String areaCode, String cityName, String cityNumber, String cityType, String provinceId);

	boolean update(String id, String areaCode, String cityName, String cityNumber, String cityType, String provinceId);

	IPage<BasicCity> page(Integer currentPage, Integer pageSize, String areaCode, String cityName, String cityNumber,
			String cityType, String provinceId);

	List<BasicCity> list(String areaCode, String cityName, String cityNumber, String cityType, String provinceId);

}
