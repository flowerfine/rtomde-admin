package cn.rtomde.admin.service.security.impl;

import cn.rtomde.admin.common.request.PageParam;
import cn.rtomde.admin.common.response.PageResponse;
import cn.rtomde.admin.dao.entity.security.SysUser;
import cn.rtomde.admin.dao.mapper.security.SysUserMapper;
import cn.rtomde.admin.service.security.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Mono<PageResponse<SysUser>> list(PageParam param) {
        Page<SysUser> page = new Page<>(param.getPageNum(), param.getPageSize());
        Flux<SysUser> sysUsers = Flux.fromIterable(sysUserMapper.selectPaged(page));
        Mono<Long> count = Mono.fromSupplier(() -> sysUserMapper.count());
        return sysUsers.collectList()
                .zipWith(count)
                .map(tuple -> convert(tuple.getT1(), tuple.getT2(), param));
    }

    private PageResponse<SysUser> convert(List<SysUser> sysUsers, Long count, PageParam param) {
        PageResponse response = new PageResponse();
        response.setDetails(sysUsers);
        response.setTotalRecord(count);
        response.setPageNum(param.getPageNum());
        response.setPageSize(param.getPageSize());
        return response;
    }

    @Override
    public Mono<SysUser> get(Long userId) {
        return Mono.justOrEmpty(sysUserMapper.selectByPrimaryKey(userId));
    }

    @Override
    public Mono<Boolean> add(SysUser user) {
        Mono<Object> delete = Mono.empty().doFirst(() -> sysUserMapper.deleteByUsername(user.getUsername()));
        return delete.then(Mono.fromSupplier(() -> sysUserMapper.insertSelective(user))
                .map(insert -> insert == 1));
    }

    @Override
    public Mono<Boolean> update(SysUser user) {
        return Mono.fromSupplier(() -> sysUserMapper.updateByPrimaryKeySelective(user))
                .map(update -> update == 1);
    }

    @Override
    public Mono<Boolean> delete(Long userId) {
        return Mono.fromSupplier(() -> sysUserMapper.deleteLogistically(userId))
                .map(delete -> delete == 1);
    }
}
