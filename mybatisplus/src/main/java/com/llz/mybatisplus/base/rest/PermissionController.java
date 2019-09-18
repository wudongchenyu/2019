package com.llz.mybatisplus.base.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llz.mybatisplus.base.dto.PermissionTree;
import com.llz.mybatisplus.base.result.HttpResult;

@RestController
public class PermissionController {
	
	/**
	 * 权限
	 * @return
	 */
	@PostMapping("/permission/allTreeList")
	public HttpResult<List<PermissionTree>> allTreeList() {
		HttpResult<List<PermissionTree>> result = new HttpResult<List<PermissionTree>>();
		PermissionTree permissionTree0 = new PermissionTree();
		permissionTree0.setId("0");
		permissionTree0.setCode("0");
		permissionTree0.setOrder(0);
		permissionTree0.setText("区域规划");
		permissionTree0.setHref("0");
		PermissionTree permissionTree = new PermissionTree();
		permissionTree.setId("1");
		permissionTree.setCode("1");
		permissionTree.setOrder(1);
		permissionTree.setText("国家管理");
		permissionTree.setHref("country");
		PermissionTree permissionTree1 = new PermissionTree();
		permissionTree1.setId("2");
		permissionTree1.setCode("2");
		permissionTree1.setOrder(2);
		permissionTree1.setText("省市管理");
		permissionTree1.setHref("province");
		PermissionTree permissionTree2 = new PermissionTree();
		permissionTree2.setId("3");
		permissionTree2.setCode("3");
		permissionTree2.setOrder(3);
		permissionTree2.setText("城市管理");
		permissionTree2.setHref("city");
		
		PermissionTree permissionTree3 = new PermissionTree();
		permissionTree3.setId("4");
		permissionTree3.setCode("4");
		permissionTree3.setOrder(4);
		permissionTree3.setText("区县管理");
		permissionTree3.setHref("district");
		
		PermissionTree permissionTree4 = new PermissionTree();
		permissionTree4.setId("5");
		permissionTree4.setCode("5");
		permissionTree4.setOrder(5);
		permissionTree4.setText("乡镇管理");
		permissionTree4.setHref("countryside");
		
		PermissionTree permissionTree5 = new PermissionTree();
		permissionTree5.setId("6");
		permissionTree5.setCode("6");
		permissionTree5.setOrder(6);
		permissionTree5.setText("村庄管理");
		permissionTree5.setHref("village");
		
		PermissionTree permissionTree6 = new PermissionTree();
		permissionTree6.setId("7");
		permissionTree6.setCode("7");
		permissionTree6.setOrder(7);
		permissionTree6.setText("系统管理");
		permissionTree6.setHref("7");
		
		PermissionTree permissionTree7 = new PermissionTree();
		permissionTree7.setId("8");
		permissionTree7.setCode("8");
		permissionTree7.setOrder(8);
		permissionTree7.setText("用户管理");
		permissionTree7.setHref("user");
		
		PermissionTree permissionTree8 = new PermissionTree();
		permissionTree8.setId("9");
		permissionTree8.setCode("9");
		permissionTree8.setOrder(9);
		permissionTree8.setText("角色管理");
		permissionTree8.setHref("role");
		
		PermissionTree permissionTree9 = new PermissionTree();
		permissionTree9.setId("10");
		permissionTree9.setCode("10");
		permissionTree9.setOrder(10);
		permissionTree9.setText("菜单管理");
		permissionTree9.setHref("menus");
		permissionTree0.setNodes(List.of(permissionTree, permissionTree1, permissionTree2, permissionTree3, permissionTree4, permissionTree5));
		permissionTree6.setNodes(List.of(permissionTree7, permissionTree8, permissionTree9));
		result.data(List.of(permissionTree0,permissionTree6));
		return result;
	}

}
