package com.llz.mybatisplus.base.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llz.mybatisplus.base.entity.BasicCity;
import com.llz.mybatisplus.base.result.HttpResult;
import com.llz.mybatisplus.base.result.HttpResultUtil;
import com.llz.mybatisplus.base.service.IBasicCityService;

import io.swagger.annotations.Api;

/**
 *
 * @author llz
 * @since 2019-04-16
 */
@Api(tags = "城市管理")
@RestController
@RequestMapping("/base/basic/city")
public class BasicCityController {
	
	private @Autowired IBasicCityService basicCityService;
	
	/**
	 * 删除
	 * @author wudon
	 * 2019年9月4日上午11:28:26
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public HttpResult<Boolean> delete(@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicCityService.removeById(id));
	}
	
	/**
	 * 新增
	 * @author wudon
	 * 2019年9月4日上午11:28:43
	 * @param areaCode
	 * @param cityName
	 * @param cityNumber
	 * @param cityType
	 * @param provinceId
	 * @return
	 */
	@PostMapping("/regist")
	public HttpResult<Boolean> regist(@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "cityName") String cityName,
			@RequestParam(value = "cityNumber", required = false) String cityNumber,
			@RequestParam(value = "cityType", required = false) String cityType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicCityService.regist(areaCode, cityName, cityNumber, cityType, provinceId));
	}
	
	/**
	 * 修改
	 * @author wudon
	 * 2019年9月4日上午11:28:52
	 * @param id
	 * @param areaCode
	 * @param cityName
	 * @param cityNumber
	 * @param cityType
	 * @param provinceId
	 */
	@PostMapping("/update")
	public void update(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "cityName", required = false) String cityName,
			@RequestParam(value = "cityNumber", required = false) String cityNumber,
			@RequestParam(value = "cityType", required = false) String cityType,
			@RequestParam(value = "provinceId") String provinceId) {
		basicCityService.update(id, areaCode, cityName, cityNumber, cityType, provinceId);
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	public HttpResult<BasicCity> detail(
			@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicCityService.getById(id));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/page")
	public HttpResult<IPage<BasicCity>> page(
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "cityName", required = false) String cityName,
			@RequestParam(value = "cityNumber", required = false) String cityNumber,
			@RequestParam(value = "cityType", required = false) String cityType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicCityService.page(currentPage, pageSize, areaCode, cityName, cityNumber, cityType, provinceId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/list")
	public HttpResult<List<BasicCity>> list(
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "cityName", required = false) String cityName,
			@RequestParam(value = "cityNumber", required = false) String cityNumber,
			@RequestParam(value = "cityType", required = false) String cityType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicCityService.list(areaCode, cityName, cityNumber, cityType, provinceId));
	}

}

