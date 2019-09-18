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
import com.llz.mybatisplus.base.entity.BasicVillage;
import com.llz.mybatisplus.base.result.HttpResult;
import com.llz.mybatisplus.base.result.HttpResultUtil;
import com.llz.mybatisplus.base.service.IBasicVillageService;

import io.swagger.annotations.Api;

@Api(tags = "村庄管理")
@RestController
@RequestMapping("/base/basic/village")
public class BasicVillageController {
	
	private @Autowired IBasicVillageService basicVillageService;
	
	/**
	 * 删除
	 * @author wudon
	 * 2019年9月4日上午11:28:26
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public HttpResult<Boolean> delete(@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicVillageService.removeById(id));
	}
	
	/**
	 * 新增
	 * @author wudon
	 * 2019年9月4日上午11:28:43
	 * @param postcode
	 * @param villageName
	 * @param villageNumber
	 * @param villageType
	 * @param provinceId
	 * @return
	 */
	@PostMapping("/regist")
	public HttpResult<Boolean> regist(@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "villageName") String villageName,
			@RequestParam(value = "villageNumber", required = false) String villageNumber,
			@RequestParam(value = "villageType", required = false) String villageType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicVillageService.regist(postcode, villageName, villageNumber, villageType, provinceId));
	}
	
	/**
	 * 修改
	 * @author wudon
	 * 2019年9月4日上午11:28:52
	 * @param id
	 * @param postcode
	 * @param villageName
	 * @param villageNumber
	 * @param villageType
	 * @param provinceId
	 * @return 
	 */
	@PostMapping("/update")
	public HttpResult<Boolean> update(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "villageName", required = false) String villageName,
			@RequestParam(value = "villageNumber", required = false) String villageNumber,
			@RequestParam(value = "villageType", required = false) String villageType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicVillageService.update(id, postcode, villageName, villageNumber, villageType, provinceId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	public HttpResult<BasicVillage> detail(
			@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicVillageService.getById(id));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/page")
	public HttpResult<IPage<BasicVillage>> page(
			@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "villageName", required = false) String villageName,
			@RequestParam(value = "villageNumber", required = false) String villageNumber,
			@RequestParam(value = "villageType", required = false) String villageType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicVillageService.page(currentPage, pageSize, postcode, villageName, villageNumber, villageType, provinceId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/list")
	public HttpResult<List<BasicVillage>> list(
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "villageName", required = false) String villageName,
			@RequestParam(value = "villageNumber", required = false) String villageNumber,
			@RequestParam(value = "villageType", required = false) String villageType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicVillageService.list(postcode, villageName, villageNumber, villageType, provinceId));
	}

}
