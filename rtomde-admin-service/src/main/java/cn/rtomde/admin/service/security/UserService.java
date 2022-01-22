package cn.rtomde.admin.service.security;

import cn.rtomde.admin.dao.entity.security.SysUser;

public interface UserService {

    SysUser get(Long userId);
}
