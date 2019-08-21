package com.hd.oms.model.po;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UmsAdminRoleRelation implements Serializable {
    private String id;

    private String adminId;

    private String roleId;

    private static final long serialVersionUID = 1L;
}