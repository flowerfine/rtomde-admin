package cn.rtomde.admin.service.security.impl;

import cn.rtomde.admin.dao.entity.security.SysUser;
import cn.rtomde.admin.dao.mapper.security.SysUserMapper;
import cn.rtomde.admin.service.security.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser get(Long userId) {
        log.info("查询用户: {}", userId);
        return sysUserMapper.selectByPrimaryKey(userId);
    }
}