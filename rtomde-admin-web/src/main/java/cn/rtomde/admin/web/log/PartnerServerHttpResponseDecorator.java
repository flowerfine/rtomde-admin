package cn.rtomde.admin.web.log;

import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.scheduler.Schedulers.single;

@Log4j2
public class PartnerServerHttpResponseDecorator extends ServerHttpResponseDecorator {

    public PartnerServerHttpResponseDecorator(ServerHttpResponse delegate) {
        super(delegate);
    }

    @Override
    public Mono<Void> writeAndFlushWith(Publisher<? extends Publisher<? extends DataBuffer>> body) {
        return super.writeAndFlushWith(body);
    }

    @Override
    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
        if (body instanceof Mono) {
            final Mono<DataBuffer> monoBody = (Mono<DataBuffer>) body;
            return super.writeWith(monoBody.publishOn(single()).map(dataBuffer -> LogUtils.loggingResponse(log, dataBuffer)));
        } else if (body instanceof Flux) {
            final Flux<DataBuffer> monoBody = (Flux<DataBuffer>) body;
            return super.writeWith(monoBody.publishOn(single()).map(dataBuffer -> LogUtils.loggingResponse(log, dataBuffer)));
        }

        return super.writeWith(body);
    }

}