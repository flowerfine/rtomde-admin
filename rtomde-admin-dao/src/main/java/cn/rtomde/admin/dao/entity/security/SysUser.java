package cn.rtomde.admin.dao.entity.security;

import cn.rtomde.admin.dao.entity.BaseEntityExt;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户表
 */
@Getter
@Setter
public class SysUser extends BaseEntityExt {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 描述
     */
    private String desc;
}