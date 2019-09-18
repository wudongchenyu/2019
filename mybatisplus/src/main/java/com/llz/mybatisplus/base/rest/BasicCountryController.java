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
import com.llz.mybatisplus.base.dto.BasicCountryDto;
import com.llz.mybatisplus.base.entity.BasicCountry;
import com.llz.mybatisplus.base.result.HttpResult;
import com.llz.mybatisplus.base.result.HttpResultUtil;
import com.llz.mybatisplus.base.service.IBasicCountryService;

import io.swagger.annotations.Api;

@Api(tags = "国家管理")
@RestController
@RequestMapping("/base/basic/country")
public class BasicCountryController {

	private @Autowired IBasicCountryService basicCountryService;

	/**
	 * 删除
	 * 
	 * @author wudon 2019年9月4日上午11:28:26
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public HttpResult<Boolean> delete(@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicCountryService.removeById(id));
	}

	/**
	 * 新增
	 * 
	 * @author wudon 2019年9月4日上午11:28:43
	 * @param postcode
	 * @param countryName
	 * @param countryNumber
	 * @param countryType
	 * @param cityId
	 * @return
	 */
	@PostMapping("/regist")
	public HttpResult<Boolean> regist(@RequestParam(value = "countryName") String countryName,
			@RequestParam(value = "countryNumber", required = false) String countryNumber,
			@RequestParam(value = "countryType", required = false) String countryType,
			@RequestParam(value = "abbreviation", required = false) String abbreviation,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "remake", required = false) String remake,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "phoneCode", required = false) String phoneCode) {
		return HttpResultUtil.result(basicCountryService.regist(countryName, countryNumber, countryType, abbreviation,
				areaCode, remake, location, phoneCode));
	}

	/**
	 * 修改
	 * 
	 * @author wudon 2019年9月4日上午11:28:52
	 * @param id
	 * @param postcode
	 * @param countryName
	 * @param countryNumber
	 * @param countryType
	 * @param cityId
	 * @return
	 */
	@PostMapping("/update")
	public HttpResult<Boolean> update(@RequestParam(value = "id") String id,
			@RequestParam(value = "countryName", required = false) String countryName,
			@RequestParam(value = "countryNumber", required = false) String countryNumber,
			@RequestParam(value = "countryType", required = false) String countryType,
			@RequestParam(value = "abbreviation", required = false) String abbreviation,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "remake", required = false) String remake,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "phoneCode", required = false) String phoneCode) {
		return HttpResultUtil.result(basicCountryService.update(id, countryName, countryNumber, countryType,
				abbreviation, areaCode, remake, location, phoneCode));
	}

	/**
	 * 详情
	 * 
	 * @author wudon 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	public HttpResult<BasicCountry> detail(@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicCountryService.getById(id));
	}

	/**
	 * 详情
	 * 
	 * @author wudon 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/page")
	public HttpResult<IPage<BasicCountry>> page(
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "countryName", required = false) String countryName,
			@RequestParam(value = "countryNumber", required = false) String countryNumber,
			@RequestParam(value = "countryType", required = false) String countryType,
			@RequestParam(value = "abbreviation", required = false) String abbreviation,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "remake", required = false) String remake,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "phoneCode", required = false) String phoneCode) {
		return HttpResultUtil.result(basicCountryService.page(currentPage, pageSize, countryName, countryNumber,
				countryType, abbreviation, areaCode, remake, location, phoneCode));
	}

	/**
	 * 详情
	 * 
	 * @author wudon 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/list")
	public HttpResult<List<BasicCountry>> list(
			@RequestParam(value = "countryName", required = false) String countryName,
			@RequestParam(value = "countryNumber", required = false) String countryNumber,
			@RequestParam(value = "countryType", required = false) String countryType,
			@RequestParam(value = "abbreviation", required = false) String abbreviation,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "remake", required = false) String remake,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "phoneCode", required = false) String phoneCode) {
		return HttpResultUtil.result(basicCountryService.list(countryName, countryNumber, countryType, abbreviation,
				areaCode, remake, location, phoneCode));
	}
	
	@PostMapping("/validator")
	public boolean validator(@RequestParam(value = "countryName", required = false) String countryName){
		return basicCountryService.validator(countryName);
	}
	
	@GetMapping("/select")
	public HttpResult<List<BasicCountryDto>> listSelect() {
		return HttpResultUtil.result(basicCountryService.listSelect());
	}

}
