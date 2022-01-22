package cn.rtomde.admin.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
@Tag(name = "user-api", description = "用户管理 API")
public class UserController {

    @GetMapping("/{userId}")
    @Operation(summary = "获取用户信息", description = "根据用户 id 查询用户")
    public Mono<String> get(@PathVariable("userId") Long userId) {
        return Mono.just(userId.toString());
    }
}
