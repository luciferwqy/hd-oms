package com.hd.oms.model.po;

import java.io.Serializable;

/**
 * 
 * @ClassName: UmsPermission
 * @Description: 权限类
 * @author wqy
 * @date 2019年8月21日
 *
 */
public class UmsPermission implements Serializable {
	private String id;

	private String pid;

	private String name;

	private String description;

	private String value;

	private String uri;

	private String icon;

	private String type;

	private String status;

	private String createTime;

	private Integer sort;

	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", pid=").append(pid);
		sb.append(", name=").append(name);
		sb.append(", description=").append(description);
		sb.append(", value=").append(value);
		sb.append(", uri=").append(uri);
		sb.append(", icon=").append(icon);
		sb.append(", type=").append(type);
		sb.append(", status=").append(status);
		sb.append(", createTime=").append(createTime);
		sb.append(", sort=").append(sort);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}