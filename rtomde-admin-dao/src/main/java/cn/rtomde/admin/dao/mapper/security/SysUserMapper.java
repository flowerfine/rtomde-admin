package cn.rtomde.admin.dao.mapper.security;

import cn.rtomde.admin.dao.entity.security.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByPrimaryKey(Long id);

    List<SysUser> selectPaged(Page<SysUser> page);

    long count();

    int insertSelective(SysUser record);

    int updateByPrimaryKeySelective(SysUser record);

    int deleteByUsername(@Param("username") String username);

    int deleteLogistically(Long id);
}