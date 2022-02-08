package cn.rtomde.admin.dao.mapper.security;

import cn.rtomde.admin.dao.entity.security.SysRole;
import cn.rtomde.admin.dao.entity.security.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface SysRoleMapper extends BaseMapper<SysRole> {

    SysRole selectByPrimaryKey(Long id);

    Page<SysRole> selectPaged(Page<SysUser> page);

    int insertSelective(SysRole record);

    int updateByPrimaryKeySelective(SysRole record);

    int deleteByPrimaryKey(Long id);
}