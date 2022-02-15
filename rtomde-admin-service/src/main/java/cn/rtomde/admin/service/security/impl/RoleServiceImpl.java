package cn.rtomde.admin.service.security.impl;

import cn.rtomde.admin.common.request.PageParam;
import cn.rtomde.admin.common.response.PageResponse;
import cn.rtomde.admin.dao.entity.security.SysRole;
import cn.rtomde.admin.dao.mapper.security.SysRoleMapper;
import cn.rtomde.admin.service.security.RoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Mono<PageResponse<SysRole>> list(PageParam param) {
        Page<SysRole> page = new Page<>(param.getPageNum(), param.getPageSize());
        return Mono.fromSupplier(() -> sysRoleMapper.selectPaged(page))
                .map(this::convert);
    }

    private PageResponse<SysRole> convert(Page<SysRole> page) {
        PageResponse response = new PageResponse();
        response.setDetails(page.getRecords());
        response.setTotalRecord(page.getTotal());
        response.setPageNum(page.getCurrent());
        response.setPageSize(page.getSize());
        return response;
    }


    @Override
    public Mono<SysRole> get(Long roleId) {
        return Mono.justOrEmpty(sysRoleMapper.selectByPrimaryKey(roleId));
    }

    @Override
    public Mono<Boolean> add(SysRole role) {
        return Mono.fromSupplier(() -> sysRoleMapper.insertSelective(role))
                .map(insert -> insert == 1);
    }

    @Override
    public Mono<Boolean> update(SysRole role) {
        return Mono.fromSupplier(() -> sysRoleMapper.updateByPrimaryKeySelective(role))
                .map(update -> update == 1);
    }

    @Override
    public Mono<Boolean> delete(Long roleId) {
        return Mono.fromSupplier(() -> sysRoleMapper.deleteLogistically(roleId))
                .map(delete -> delete == 1);
    }
}
