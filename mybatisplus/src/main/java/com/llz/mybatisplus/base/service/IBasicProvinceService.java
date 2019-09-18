package com.llz.mybatisplus.base.service;

import com.llz.mybatisplus.base.entity.BasicProvince;

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
public interface IBasicProvinceService extends IService<BasicProvince> {

	boolean regist(String provinceName, String provinceNumber, String provinceType, String countryId);

	boolean update(String id, String provinceName, String provinceNumber, String provinceType, String countryId);

	IPage<BasicProvince> page(Integer currentPage, Integer pageSize, String provinceName, String provinceNumber, String provinceType, String countryId);

	List<BasicProvince> list(String provinceName, String provinceNumber, String provinceType, String countryId);

}
