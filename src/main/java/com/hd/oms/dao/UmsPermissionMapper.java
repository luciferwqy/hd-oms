package com.hd.oms.dao;

import com.hd.oms.model.po.UmsPermission;

public interface UmsPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(UmsPermission record);

    int insertSelective(UmsPermission record);

    UmsPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UmsPermission record);

    int updateByPrimaryKey(UmsPermission record);
}