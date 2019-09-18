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
import com.llz.mybatisplus.base.entity.BasicDistrict;
import com.llz.mybatisplus.base.result.HttpResult;
import com.llz.mybatisplus.base.result.HttpResultUtil;
import com.llz.mybatisplus.base.service.IBasicDistrictService;

import io.swagger.annotations.Api;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
@Api(tags = "区域管理")
@RestController
@RequestMapping("/base/basic/district")
public class BasicDistrictController {

	private @Autowired IBasicDistrictService basicDistrictService;
	
	/**
	 * 删除
	 * @author wudon
	 * 2019年9月4日上午11:28:26
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public HttpResult<Boolean> delete(@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicDistrictService.removeById(id));
	}
	
	/**
	 * 新增
	 * @author wudon
	 * 2019年9月4日上午11:28:43
	 * @param postcode
	 * @param districtName
	 * @param districtNumber
	 * @param districtType
	 * @param provinceId
	 * @return
	 */
	@PostMapping("/regist")
	public HttpResult<Boolean> regist(@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "districtName") String districtName,
			@RequestParam(value = "districtNumber", required = false) String districtNumber,
			@RequestParam(value = "districtType", required = false) String districtType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicDistrictService.regist(postcode, districtName, districtNumber, districtType, provinceId));
	}
	
	/**
	 * 修改
	 * @author wudon
	 * 2019年9月4日上午11:28:52
	 * @param id
	 * @param postcode
	 * @param districtName
	 * @param districtNumber
	 * @param districtType
	 * @param provinceId
	 * @return 
	 */
	@PostMapping("/update")
	public HttpResult<Boolean> update(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "districtName", required = false) String districtName,
			@RequestParam(value = "districtNumber", required = false) String districtNumber,
			@RequestParam(value = "districtType", required = false) String districtType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicDistrictService.update(id, postcode, districtName, districtNumber, districtType, provinceId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	public HttpResult<BasicDistrict> detail(
			@RequestParam(value = "id") String id) {
		return HttpResultUtil.result(basicDistrictService.getById(id));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/page")
	public HttpResult<IPage<BasicDistrict>> page(
			@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "districtName", required = false) String districtName,
			@RequestParam(value = "districtNumber", required = false) String districtNumber,
			@RequestParam(value = "districtType", required = false) String districtType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicDistrictService.page(currentPage, pageSize, postcode, districtName, districtNumber, districtType, provinceId));
	}
	
	/**
	 * 详情
	 * @author wudon
	 * 2019年9月4日上午11:29:05
	 * @param id
	 * @return
	 */
	@GetMapping("/list")
	public HttpResult<List<BasicDistrict>> list(
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "districtName", required = false) String districtName,
			@RequestParam(value = "districtNumber", required = false) String districtNumber,
			@RequestParam(value = "districtType", required = false) String districtType,
			@RequestParam(value = "provinceId", required = false) String provinceId) {
		return HttpResultUtil.result(basicDistrictService.list(postcode, districtName, districtNumber, districtType, provinceId));
	}
	
}

