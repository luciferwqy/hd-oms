package com.hd.oms.model.dto;

import java.util.List;

import com.hd.oms.model.po.UmsPermission;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName: UmsPermissionNode
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wqy
 * @date 2019年8月20日
 *
 */
public class UmsPermissionNode extends UmsPermission {
    
	    /**
	    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = 1L;
	@Getter
    @Setter
    private List<UmsPermissionNode> children;
}
