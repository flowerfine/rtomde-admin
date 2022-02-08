package cn.rtomde.admin.service.security;

import cn.rtomde.admin.common.request.PageParam;
import cn.rtomde.admin.common.response.PageResponse;
import cn.rtomde.admin.dao.entity.security.SysRole;
import reactor.core.publisher.Mono;

public interface RoleService {

    Mono<PageResponse<SysRole>> list(PageParam param);

    Mono<SysRole> get(Long roleId);

    Mono<Boolean> add(SysRole role);

    Mono<Boolean> update(SysRole role);

    Mono<Boolean> delete(Long roleId);
}
