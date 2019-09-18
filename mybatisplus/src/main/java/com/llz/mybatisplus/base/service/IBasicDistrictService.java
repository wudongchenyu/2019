package com.llz.mybatisplus.base.service;

import com.llz.mybatisplus.base.entity.BasicDistrict;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
public interface IBasicDistrictService extends IService<BasicDistrict> {

	boolean regist(String areaCode, String districtName, String districtNumber, String districtType, String provinceId);

	boolean update(String id, String areaCode, String districtName, String districtNumber, String districtType, String provinceId);

	IPage<BasicDistrict> page(Integer currentPage, Integer pageSize, String postcode, String districtName, String districtNumber,
			String districtType, String provinceId);

	List<BasicDistrict> list(String postcode, String districtName, String districtNumber, String districtType, String provinceId);

}
