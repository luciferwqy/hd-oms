package com.hd.oms.model.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @ClassName: UmsAdminParam
 * @Description: 用户登陆参数
 * @author wqy
 * @date 2019年8月20日
 *
 */
@Getter
@Setter
@ToString
public class UmsAdminLoginParam {
	@ApiModelProperty(value = "用户名", required = true)
	@NotEmpty(message = "用户名不能为空")
	private String bange;
	@ApiModelProperty(value = "密码", required = true)
	@NotEmpty(message = "密码不能为空")
	private String password;
}
