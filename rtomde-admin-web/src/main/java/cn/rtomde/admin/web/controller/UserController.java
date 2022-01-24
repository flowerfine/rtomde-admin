package cn.rtomde.admin.web.controller;

import cn.rtomde.admin.common.request.PageParam;
import cn.rtomde.admin.common.response.PageResponse;
import cn.rtomde.admin.dao.entity.security.SysUser;
import cn.rtomde.admin.service.security.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
@Tag(name = "用户管理 API", description = "user-api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "分页获取用户信息", description = "分页查询用户信息")
    public Mono<PageResponse<SysUser>> list(PageParam param) {
        return userService.list(param);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "获取用户信息", description = "根据用户 id 查询用户信息")
    public Mono<SysUser> get(@Parameter(description = "用户 id") @PathVariable("userId") Long userId) {
        return userService.get(userId);
    }

    @PutMapping
    @Operation(summary = "添加用户", description = "创建一个新的用户")
    public Mono<Boolean> add(@RequestBody SysUser user) {
        return userService.add(user);
    }

    @PostMapping("/{userId}")
    @Operation(summary = "更新用户", description = "根据用户 id 更新用户信息")
    public Mono<Boolean> update(@Parameter(description = "用户 id") @PathVariable("userId") long userId,
                                @Parameter(description = "用户信息") @RequestBody SysUser user) {
        user.setId(userId);
        return userService.update(user);
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "删除用户", description = "根据用户 id 删除用户")
    public Mono<Boolean> delete(@Parameter(description = "用户 id") @PathVariable("userId") long userId) {
        return userService.delete(userId);
    }

}
