package com.hd.oms.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hd.oms.model.dto.UmsAdminParam;
import com.hd.oms.model.po.UmsAdmin;
import com.hd.oms.model.po.UmsPermission;
import com.hd.oms.model.po.UmsRole;

/**
 * 后台管理员Service
 * Created by macro on 2018/4/26.
 */
public interface UmsAdminService {
    /**
     * 根据用户工号获取后台管理员
     */
    UmsAdmin getAdminByBange(String bange);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param bange 工号
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<UmsAdmin> list(String name, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(UmsAdmin admin);

    /**
     * 删除指定用户
     */
    int delete(String id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(String adminId, List<String> roleIds);

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(String adminId);

    /**
     * 修改用户的+-权限
     */
    @Transactional
    int updatePermission(String adminId, List<String> permissionIds);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(String adminId);

    /**
     * 
        * @Title: listAdminRoles
        * @Description: 根据用户ID获取角色名
        * @param id
        * @return List<String>    返回类型
        * @throws
     */
	List<String> listAdminRoles(String id);
}
