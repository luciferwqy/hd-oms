package com.hd.oms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hd.oms.model.po.UmsAdmin;
import com.hd.oms.model.po.UmsPermission;

public interface UmsAdminMapper {
	int deleteByPrimaryKey(String id);

	int insert(UmsAdmin record);

	int insertSelective(UmsAdmin record);

	UmsAdmin selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(UmsAdmin record);

	int updateByPrimaryKey(UmsAdmin record);

	/**
	 * 
	 * @Title: selectByBange 
	 * @Description: 根据工号查询后台用户
	 * @param bange
	 * @return List<UmsAdmin> 
	 */
	List<UmsAdmin> selectByBange(String bange);
	
	/**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") String adminId);
}