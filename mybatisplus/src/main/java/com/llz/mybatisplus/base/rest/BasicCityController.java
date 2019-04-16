package com.llz.mybatisplus.base.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llz.mybatisplus.base.service.IBasicCityService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
@RestController
@RequestMapping("/base/basic/city")
public class BasicCityController {
	
	private @Autowired IBasicCityService basicCityService;
	
	@DeleteMapping("/delete")
	public boolean delete(@RequestParam(value = "id") String id) {
		return basicCityService.removeById(id);
	}

}

