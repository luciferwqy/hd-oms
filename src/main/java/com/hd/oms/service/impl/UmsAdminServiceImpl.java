package com.hd.oms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hd.oms.component.JwtTokenUtil;
import com.hd.oms.dao.UmsAdminMapper;
import com.hd.oms.dao.UmsRoleMapper;
import com.hd.oms.model.dto.UmsAdminParam;
import com.hd.oms.model.po.UmsAdmin;
import com.hd.oms.model.po.UmsAdminPermissionRelation;
import com.hd.oms.model.po.UmsPermission;
import com.hd.oms.model.po.UmsRole;
import com.hd.oms.service.UmsAdminService;

/**
 * 
 * @ClassName: UmsAdminServiceImpl
 * @Description: 后台用户service
 * @author wqy
 * @date 2019年8月21日
 *
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Value("${jwt.tokenHead}")
	private String tokenHead;
	@Autowired
	private UmsAdminMapper adminMapper;
	@Autowired
	private UmsRoleMapper roleMapper;

	@Override
	public UmsAdmin register(UmsAdminParam umsAdminParam) {
		return null;
	}

	@Override
	public String login(String bange, String password) {
		String token = null;
		// 密码需要客户端加密后传递
		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(bange);
			if (!passwordEncoder.matches(password, userDetails.getPassword())) {
				throw new BadCredentialsException("密码不正确");
			}
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			token = jwtTokenUtil.generateLimitTimeToken(userDetails);
			// insertLoginLog(bange);
		} catch (AuthenticationException e) {
			LOGGER.warn("登录异常:{}", e.getMessage());
		}
		return token;
	}

	@Override
	public String refreshToken(String oldToken) {
		String token = oldToken.substring(tokenHead.length());
		return jwtTokenUtil.refreshToken(token);
	}

	@Override
	public int update(UmsAdmin admin) {
		// 密码已经加密处理，需要单独修改
		admin.setPassword(null);
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public int delete(String id) {
		return adminMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 将+-权限关系转化为对象
	 */
	private List<UmsAdminPermissionRelation> convert(String adminId, Integer type, List<String> permissionIdList) {
		List<UmsAdminPermissionRelation> relationList = permissionIdList.stream().map(permissionId -> {
			UmsAdminPermissionRelation relation = new UmsAdminPermissionRelation();
			relation.setAdminId(adminId);
			relation.setType(type);
			relation.setPermissionId(permissionId);
			return relation;
		}).collect(Collectors.toList());
		return relationList;
	}

	@Override
	public UmsAdmin getAdminByBange(String bange) {
		List<UmsAdmin> adminList = adminMapper.selectByBange(bange);
		if (adminList != null && adminList.size() > 0) {
			return adminList.get(0);
		}
		return null;
	}

	@Override
	public List<UmsAdmin> list(String name, Integer pageSize, Integer pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRole(String adminId, List<String> roleIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UmsRole> getRoleList(String adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePermission(String adminId, List<String> permissionIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UmsPermission> getPermissionList(String adminId) {
		return adminMapper.getPermissionList(adminId);
	}

	    
	@Override
	public List<String> listAdminRoles(String adminId) {
		return roleMapper.listAdminRoles(adminId);
	}

}
