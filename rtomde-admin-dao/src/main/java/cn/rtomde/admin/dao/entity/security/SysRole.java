package cn.rtomde.admin.dao.entity.security;

import cn.rtomde.admin.dao.entity.BaseEntityExt;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色表
 */
@Getter
@Setter
public class SysRole extends BaseEntityExt {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String code;

    /**
     * 组织id
     */
    private Long organizationId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String desc;

    /**
     * 角色类型: 0:超级管理员, 1:系统管理员, 2:普通角色
     */
    private Byte type;
}