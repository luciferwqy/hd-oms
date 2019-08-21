package com.hd.oms.model.po;

import java.io.Serializable;

/**
 * 
 * @ClassName: UmsAdmin
 * @Description: 后台用户类
 * @author wqy
 * @date 2019年8月21日
 *
 */
public class UmsAdmin implements Serializable {
	private String id;

	private String username;

	private String bange;

	private String password;

	private String nickName;

	private String userType;

	private String email;

	private String createTime;

	private String loginTime;

	private String status;

	private String modifier;

	private String modifieTime;

	private String orgId;

	private String icon;

	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBange() {
		return bange;
	}

	public void setBange(String bange) {
		this.bange = bange;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifieTime() {
		return modifieTime;
	}

	public void setModifieTime(String modifieTime) {
		this.modifieTime = modifieTime;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", username=").append(username);
		sb.append(", bange=").append(bange);
		sb.append(", password=").append(password);
		sb.append(", nickName=").append(nickName);
		sb.append(", userType=").append(userType);
		sb.append(", email=").append(email);
		sb.append(", createTime=").append(createTime);
		sb.append(", loginTime=").append(loginTime);
		sb.append(", status=").append(status);
		sb.append(", modifier=").append(modifier);
		sb.append(", modifieTime=").append(modifieTime);
		sb.append(", orgId=").append(orgId);
		sb.append(", icon=").append(icon);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}