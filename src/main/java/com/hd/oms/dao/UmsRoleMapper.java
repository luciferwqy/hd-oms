package com.hd.oms.dao;

import java.util.List;

import com.hd.oms.model.po.UmsRole;

public interface UmsRoleMapper {
	int deleteByPrimaryKey(String id);

	int insert(UmsRole record);

	int insertSelective(UmsRole record);

	UmsRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(UmsRole record);

	int updateByPrimaryKey(UmsRole record);

	/**
	 * 
	 * @Title: listAdminRoles 
	 * @Description: 根据用户ID获取角色名 
	 * @param adminId 
	 * @return List<String> 返回类型
	 * @throws
	 */
	List<String> listAdminRoles(String adminId);
}