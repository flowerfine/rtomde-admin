package cn.rtomde.admin.dao.entity.security;

import cn.rtomde.admin.dao.entity.BaseEntityExt;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    /**
     * 密码过期时间
     */
    private Date passwordExpireTime;

    /**
     * 用户过期时间
     */
    private Date userExpireTime;

    /**
     * 启用标识。0:未启用, 1:已启用
     * mybatis 会自动将 tinyint 类型转换为 boolean 类型
     */
    private boolean enabled;
}