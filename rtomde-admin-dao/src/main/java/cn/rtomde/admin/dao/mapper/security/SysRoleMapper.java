package cn.rtomde.admin.dao.mapper.security;

import cn.rtomde.admin.dao.entity.security.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysRoleMapper extends BaseMapper<SysRole> {

    SysRole selectByPrimaryKey(Long id);

    int insertSelective(SysRole record);

    int updateByPrimaryKeySelective(SysRole record);

    int deleteByPrimaryKey(Long id);
}