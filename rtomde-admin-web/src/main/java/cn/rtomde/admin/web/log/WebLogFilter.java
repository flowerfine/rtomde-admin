package cn.rtomde.admin.web.log;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class WebLogFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        final String path = request.getURI().getPath();
        final MediaType contentType = request.getHeaders().getContentType();
        if (LogUtils.logMediaType(contentType) && LogUtils.logPath(path)) {
            return chain.filter(new PayloadServerWebExchangeDecorator(exchange));
        }
        return chain.filter(exchange);
    }
}
