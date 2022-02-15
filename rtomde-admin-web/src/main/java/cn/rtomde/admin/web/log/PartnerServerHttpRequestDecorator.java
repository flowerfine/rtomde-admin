package cn.rtomde.admin.web.log;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

import java.util.Optional;
import java.util.stream.Collectors;

import static reactor.core.scheduler.Schedulers.single;

@Log4j2
public class PartnerServerHttpRequestDecorator extends ServerHttpRequestDecorator {

    private Flux<DataBuffer> body;

    public PartnerServerHttpRequestDecorator(ServerHttpRequest delegate) {
        super(delegate);
        final String path = delegate.getURI().getPath();
        final String query = delegate.getURI().getQuery();
        final String method = Optional.ofNullable(delegate.getMethod()).orElse(HttpMethod.GET).name();
        final String headers = delegate.getHeaders().entrySet()
                .stream()
                .map(entry -> "            " + entry.getKey() + ": " + String.join(";", entry.getValue()))
                .collect(Collectors.joining("\n"));
        final MediaType contentType = delegate.getHeaders().getContentType();
        if (log.isDebugEnabled()) {
            log.debug("登陆用户:[{}] {} {} headers: \n{}",
                    "unknown", method, path + (StringUtils.isEmpty(query) ? "" : "?" + query), headers);
        } else if (log.isInfoEnabled()) {
            log.info("登陆用户:[{}] {} {}",
                    "unknown", method, path + (StringUtils.isEmpty(query) ? "" : "?" + query));
        }
        body = super.getBody().publishOn(single()).map(dataBuffer -> LogUtils.loggingRequest(log, dataBuffer));
    }

    @Override
    public Flux<DataBuffer> getBody() {
        return body;
    }
}
