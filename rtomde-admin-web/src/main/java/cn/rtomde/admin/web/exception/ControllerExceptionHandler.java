package cn.rtomde.admin.web.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Log4j2
@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(HandlerMethod method, Exception e, ServerHttpRequest request, ServerHttpResponse response) {
        final String path = request.getURI().getPath();
        final String query = request.getURI().getQuery();
        final String httpMethod = Optional.ofNullable(request.getMethod()).orElse(HttpMethod.GET).name();
        log.error("登陆用户:[{}] {} {}",
                "unknown", httpMethod, path + (StringUtils.isEmpty(query) ? "" : "?" + query), e);

        Map<String, Object> result = new HashMap<>();
        result.put("status", "error");
        result.put("exception", e.getMessage());
        result.put("request", httpMethod + " " + path + (StringUtils.isEmpty(query) ? "" : "?" + query));
        return result;
    }
}
