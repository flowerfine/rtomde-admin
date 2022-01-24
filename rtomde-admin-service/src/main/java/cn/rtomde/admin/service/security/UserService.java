package cn.rtomde.admin.service.security;

import cn.rtomde.admin.common.request.PageParam;
import cn.rtomde.admin.common.response.PageResponse;
import cn.rtomde.admin.dao.entity.security.SysUser;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<PageResponse<SysUser>> list(PageParam param);

    Mono<SysUser> get(Long userId);

    Mono<Boolean> add(SysUser user);

    Mono<Boolean> update(SysUser user);

    Mono<Boolean> delete(Long userId);
}
