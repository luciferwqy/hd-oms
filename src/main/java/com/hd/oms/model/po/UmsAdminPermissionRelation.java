package com.hd.oms.model.po;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UmsAdminPermissionRelation implements Serializable {
    private String id;

    private String adminId;

    private String permissionId;

    private Integer type;

    private static final long serialVersionUID = 1L;
}