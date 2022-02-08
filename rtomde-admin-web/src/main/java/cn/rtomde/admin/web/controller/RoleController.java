package cn.rtomde.admin.web.controller;

import cn.rtomde.admin.common.request.PageParam;
import cn.rtomde.admin.common.response.PageResponse;
import cn.rtomde.admin.dao.entity.security.SysRole;
import cn.rtomde.admin.service.security.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("role")
@Tag(name = "角色管理 API", description = "role-api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    @Operation(summary = "分页获取角色信息", description = "分页查询角色信息")
    public Mono<PageResponse<SysRole>> list(PageParam param) {
        return roleService.list(param);
    }

    @GetMapping("/{roleId}")
    @Operation(summary = "获取角色信息", description = "根据角色 id 查询角色信息")
    public Mono<SysRole> get(@Parameter(description = "角色 id") @PathVariable("roleId") Long roleId) {
        return roleService.get(roleId);
    }

    @PutMapping
    @Operation(summary = "添加角色", description = "创建一个新的角色")
    public Mono<Boolean> add(@RequestBody SysRole role) {
        return roleService.add(role);
    }

    @PostMapping("/{roleId}")
    @Operation(summary = "更新角色", description = "根据角色 id 更新用户信息")
    public Mono<Boolean> update(@Parameter(description = "角色 id") @PathVariable("roleId") long roleId,
                                @Parameter(description = "角色信息") @RequestBody SysRole role) {
        role.setId(roleId);
        return roleService.update(role);
    }

    @DeleteMapping("/{roleId}")
    @Operation(summary = "删除角色", description = "根据角色 id 删除角色")
    public Mono<Boolean> delete(@Parameter(description = "角色 id") @PathVariable("roleId") long roleId) {
        return roleService.delete(roleId);
    }
}
