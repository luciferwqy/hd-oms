package com.hd.oms.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.oms.common.CommonPage;
import com.hd.oms.common.CommonResult;
import com.hd.oms.model.dto.UmsAdminLoginParam;
import com.hd.oms.model.dto.UmsAdminParam;
import com.hd.oms.model.po.UmsAdmin;
import com.hd.oms.model.po.UmsPermission;
import com.hd.oms.model.po.UmsRole;
import com.hd.oms.service.UmsAdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 后台用户管理 Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
public class UmsAdminController {
	@Autowired
	private UmsAdminService adminService;
	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@ApiOperation(value = "用户注册")
	@RequestMapping(value = "/auth/register", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<UmsAdmin> register(@RequestBody UmsAdminParam umsAdminParam) {
		UmsAdmin umsAdmin = adminService.register(umsAdminParam);
		if (umsAdmin == null) {
			CommonResult.failed();
		}
		return CommonResult.success(umsAdmin);
	}

	@ApiOperation(value = "登录以后返回token")
	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<Map<String, String>> login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
		String token = adminService.login(umsAdminLoginParam.getBange(), umsAdminLoginParam.getPassword());
		if (token == null) {
			return CommonResult.validateFailed("用户名或密码错误");
		}
		Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
	}

	@ApiOperation(value = "刷新token")
	@RequestMapping(value = "/admin/token/refresh", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<Map<String, String>> refreshToken(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		String refreshToken = adminService.refreshToken(token);
		if (refreshToken == null) {
			return CommonResult.failed();
		}
		Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
	}

	@ApiOperation(value = "获取当前登录用户信息")
	@RequestMapping(value = "/admin/info", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<Map<String, Object>> getAdminInfo(Principal principal) {
		String bange = principal.getName();
		UmsAdmin umsAdmin = adminService.getAdminByBange(bange);
		List<String> roles = adminService.listAdminRoles(umsAdmin.getId());
		Map<String, Object> data = new HashMap<>();
		data.put("username", umsAdmin.getUsername());
		data.put("roles", roles);
		data.put("icon", umsAdmin.getIcon());
		return CommonResult.success(data);
	}
	
	@ApiOperation(value = "登出功能")
    @RequestMapping(value = "/admin/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> logout() {
        return CommonResult.success(null);
    }

	@ApiOperation("根据用户名或姓名分页获取用户列表")
	@RequestMapping(value = "/admin/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<CommonPage<UmsAdmin>> list(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		List<UmsAdmin> adminList = adminService.list(name, pageSize, pageNum);
		return CommonResult.success(CommonPage.restPage(adminList));
	}

	@ApiOperation("修改指定用户信息")
	@RequestMapping(value = "/admin/update", method = RequestMethod.PUT)
	@ResponseBody
	public CommonResult<Integer> update(@RequestBody UmsAdmin admin) {
		int count = adminService.update(admin);
		if (count > 0) {
			return CommonResult.success(count);
		}
		return CommonResult.failed();
	}

	@ApiOperation("删除指定用户信息")
	@RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public CommonResult<Integer> delete(@PathVariable String id) {
		int count = adminService.delete(id);
		if (count > 0) {
			return CommonResult.success(count);
		}
		return CommonResult.failed();
	}

	@ApiOperation("给用户分配角色")
	@RequestMapping(value = "/admin/role/update/{adminId}", method = RequestMethod.PUT)
	@ResponseBody
	public CommonResult<Integer> updateRole(@PathVariable String adminId, @RequestParam("roleIds") List<String> roleIds) {
		int count = adminService.updateRole(adminId, roleIds);
		if (count >= 0) {
			return CommonResult.success(count);
		}
		return CommonResult.failed();
	}

	@ApiOperation("获取指定用户的角色")
	@RequestMapping(value = "/admin/role/{adminId}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<UmsRole>> getRoleList(@PathVariable String adminId) {
		List<UmsRole> roleList = adminService.getRoleList(adminId);
		return CommonResult.success(roleList);
	}

	@ApiOperation("给用户分配+-权限")
	@RequestMapping(value = "/admin/permission/update", method = RequestMethod.PUT)
	@ResponseBody
	public CommonResult<Integer> updatePermission(@RequestParam String adminId,
			@RequestParam("permissionIds") List<String> permissionIds) {
		int count = adminService.updatePermission(adminId, permissionIds);
		if (count > 0) {
			return CommonResult.success(count);
		}
		return CommonResult.failed();
	}

	@ApiOperation("获取用户所有权限（包括+-权限）") 
	@RequestMapping(value = "/admin/permission/{adminId}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable String adminId) {
		List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
		return CommonResult.success(permissionList);
	}
}
