package cn.rtomde.admin.dao.mapper.security;

import cn.rtomde.admin.dao.entity.security.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByPrimaryKey(Long id);

    int insertSelective(SysUser record);

    int updateByPrimaryKeySelective(SysUser record);

    int deleteByPrimaryKey(Long id);
}