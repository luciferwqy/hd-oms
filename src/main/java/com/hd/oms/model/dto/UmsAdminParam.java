package com.hd.oms.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @ClassName: UmsAdminParam
 * @Description: 用户注册参数(NC用户同步)
 * @author wqy
 * @date 2019年8月21日
 *
 */
@Getter
@Setter
@ToString
public class UmsAdminParam {
	@ApiModelProperty(value = "用户名", required = true)
	@NotEmpty(message = "工号不能为空")
	private String bange;
	@ApiModelProperty(value = "密码", required = true)
	@NotEmpty(message = "密码不能为空")
	private String password;
	@ApiModelProperty(value = "用户头像")
	private String icon;
	@ApiModelProperty(value = "邮箱")
	@Email(message = "邮箱格式不合法")
	private String email;
	@ApiModelProperty(value = "用户昵称")
	private String nickName;
	@ApiModelProperty(value = "用户姓名")
	private String userName;
}
