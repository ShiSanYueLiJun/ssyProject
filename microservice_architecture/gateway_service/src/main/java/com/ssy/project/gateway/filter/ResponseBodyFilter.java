package com.ssy.project.gateway.filter;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * @author LiJun
 * @date 2022-01-11 15:59
 */
@Log4j2
@Component
public class ResponseBodyFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().toString();
        ServerHttpResponse originalResponse = exchange.getResponse();
        System.out.println(originalResponse.isCommitted());
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();

        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {

                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    return super.writeWith(fluxBody.buffer().map(dataBuffer -> {
                        DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                        DataBuffer join = dataBufferFactory.join(dataBuffer);
                        byte[] content = new byte[join.readableByteCount()];
                        join.read(content);
                        //释放掉内存
                        DataBufferUtils.release(join);
                        String resp = new String(content, StandardCharsets.UTF_8);

                        List<String> strings = exchange.getResponse().getHeaders().get(HttpHeaders.CONTENT_ENCODING);
                        if (!CollectionUtils.isEmpty(strings) && strings.contains("gzip")) {
                            GZIPInputStream gzipInputStream = null;
                            try {
                                gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(content), content.length);
                                StringWriter writer = new StringWriter();
                                IOUtils.copy(gzipInputStream, writer, "UTF-8");
                                resp = writer.toString();

                            } catch (IOException e) {
                                log.error("====Gzip IO error", e);
                            } finally {
                                if (gzipInputStream != null) {
                                    try {
                                        gzipInputStream.close();
                                    } catch (IOException e) {
                                        log.error("===Gzip IO close error", e);
                                    }
                                }
                            }
                        } else {
                            resp = new String(content, StandardCharsets.UTF_8);
                        }
//                        JSONObject jsonObject = JSON.parseObject(resp);
//                        jsonObject.put("authorize", "ssy");
//                        log.info("bodyString: {}", jsonObject.toJSONString());//打印请求响应值
                        return bufferFactory.wrap(content);
                    }));
                }
                return super.writeWith(body);
            }
        };
        return chain.filter(exchange.mutate().response(decoratedResponse).build());
    }


    @Override
    public int getOrder() {
        return -200;
    }
}
