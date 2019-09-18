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
import com.llz.mybatisplus.base.entity.BasicCountryside;
import com.llz.mybatisplus.base.result.HttpResult;
import com.llz.mybatisplus.base.result.HttpResultUtil;
import com.llz.mybatisplus.base.service.IBasicCountrysideService;

import io.swagger.annotations.Api;

@Api(tags = "乡镇管理")
@RestController
@RequestMapping("/base/basic/countryside")
public class BasicCountrysideController {

private @Autowired IBasicCountrysideService basicCountrysideService;
	
	/**
	 * 删除
	 * @author wudon
	 * 2019年9月4日上午11:28:26
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public HttpResult<Boolean> delete(@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicCountrysideService.removeById(id));
	}
	
	/**
	 * 新增
	 * @author wudon
	 * 2019年9月4日上午11:28:43
	 * @param postcode
	 * @param countrysideName
	 * @param countrysideNumber
	 * @param countrysideType
	 * @param districtId
	 * @return
	 */
	@PostMapping("/regist")
	public HttpResult<Boolean> regist(@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "countrysideName") String countrysideName,
			@RequestParam(value = "countrysideNumber", required = false) String countrysideNumber,
			@RequestParam(value = "countrysideType", required = false) String countrysideType,
			@RequestParam(value = "districtId", required = false) String districtId) {
		return HttpResultUtil.result(basicCountrysideService.regist(postcode, countrysideName, countrysideNumber, countrysideType, districtId));
	}
	
	/**
	 * 修改
	 * @author wudon
	 * 2019年9月4日上午11:28:52
	 * @param id
	 * @param postcode
	 * @param countrysideName
	 * @param countrysideNumber
	 * @param countrysideType
	 * @param districtId
	 * @return 
	 */
	@PostMapping("/update")
	public HttpResult<Boolean> update(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "countrysideName", required = false) String countrysideName,
			@RequestParam(value = "countrysideNumber", required = false) String countrysideNumber,
			@RequestParam(value = "countrysideType", required = false) String countrysideType,
			@RequestParam(value = "districtId", required = false) String districtId) {
		return HttpResultUtil.result(basicCountrysideService.update(id, postcode, countrysideName, countrysideNumber, countrysideType, districtId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	public HttpResult<BasicCountryside> detail(
			@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicCountrysideService.getById(id));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/page")
	public HttpResult<IPage<BasicCountryside>> page(
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "countrysideName", required = false) String countrysideName,
			@RequestParam(value = "countrysideNumber", required = false) String countrysideNumber,
			@RequestParam(value = "countrysideType", required = false) String countrysideType,
			@RequestParam(value = "districtId", required = false) String districtId) {
		return HttpResultUtil.result(basicCountrysideService.page(currentPage, pageSize, postcode, countrysideName, countrysideNumber, countrysideType, districtId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/list")
	public HttpResult<List<BasicCountryside>> list(
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "countrysideName", required = false) String countrysideName,
			@RequestParam(value = "countrysideNumber", required = false) String countrysideNumber,
			@RequestParam(value = "countrysideType", required = false) String countrysideType,
			@RequestParam(value = "districtId", required = false) String districtId) {
		return HttpResultUtil.result(basicCountrysideService.list(postcode, countrysideName, countrysideNumber, countrysideType, districtId));
	}
	
}
