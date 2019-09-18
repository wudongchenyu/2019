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
import com.llz.mybatisplus.base.entity.BasicProvince;
import com.llz.mybatisplus.base.result.HttpResult;
import com.llz.mybatisplus.base.result.HttpResultUtil;
import com.llz.mybatisplus.base.service.IBasicProvinceService;

import io.swagger.annotations.Api;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
@Api(tags = "省份管理")
@RestController
@RequestMapping("/base/basic/province")
public class BasicProvinceController {
	
	private @Autowired IBasicProvinceService basicProvinceService;
	
	/**
	 * 删除
	 * @author wudon
	 * 2019年9月4日下午1:15:18
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public HttpResult<Boolean> delete(@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicProvinceService.removeById(id));
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
	public HttpResult<Boolean> regist(
			@RequestParam(value = "provinceName", required = false) String provinceName,
			@RequestParam(value = "provinceNumber", required = false) String provinceNumber,
			@RequestParam(value = "provinceType", required = false) String provinceType,
			@RequestParam(value = "countryId", required = false) String countryId) {
		return HttpResultUtil.result(basicProvinceService.regist(provinceName, provinceNumber, provinceType, countryId));
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
	 * @return 
	 */
	@PostMapping("/update")
	public HttpResult<Boolean> update(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "provinceName", required = false) String provinceName,
			@RequestParam(value = "provinceNumber", required = false) String provinceNumber,
			@RequestParam(value = "provinceType", required = false) String provinceType,
			@RequestParam(value = "countryId", required = false) String countryId) {
		return HttpResultUtil.result(basicProvinceService.update(id, provinceName, provinceNumber, provinceType, countryId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	public HttpResult<BasicProvince> detail(
			@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicProvinceService.getById(id));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/page")
	public HttpResult<IPage<BasicProvince>> page(
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "provinceName", required = false) String provinceName,
			@RequestParam(value = "provinceNumber", required = false) String provinceNumber,
			@RequestParam(value = "provinceType", required = false) String provinceType,
			@RequestParam(value = "countryId", required = false) String countryId) {
		return HttpResultUtil.result(basicProvinceService.page(currentPage, pageSize, provinceName, provinceNumber, provinceType, countryId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/list")
	public HttpResult<List<BasicProvince>> list(
			@RequestParam(value = "provinceName", required = false) String provinceName,
			@RequestParam(value = "provinceNumber", required = false) String provinceNumber,
			@RequestParam(value = "provinceType", required = false) String provinceType,
			@RequestParam(value = "countryId", required = false) String countryId) {
		return HttpResultUtil.result(basicProvinceService.list(provinceName, provinceNumber, provinceType, countryId));
	}


}

