package cn.rtomde.admin.service.security;

import cn.rtomde.admin.dao.entity.security.SysUser;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<SysUser> get(Long userId);
}
