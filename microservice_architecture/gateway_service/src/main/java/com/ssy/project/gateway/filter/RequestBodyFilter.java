package com.ssy.project.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;

/**
 * @author LiJun
 * @date 2022-01-11 16:45
 */
@Log4j2
@Component
public class RequestBodyFilter implements GlobalFilter, Ordered {



    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String method = request.getMethodValue();
        String contentType = request.getHeaders().getFirst("Content-Type");
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        StringBuilder query = new StringBuilder();
        //获取请求uri的请求参数（GET请求参数通过拼接key=value形式进行传参）
        String originalQuery = request.getURI().getRawQuery();
        if ("POST".equals(method)) {
            return DataBufferUtils.join(exchange.getRequest().getBody())
                    .flatMap(dataBuffer -> {
                        byte[] bytes = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(bytes);
                        try {
                            String bodyString = new String(bytes, "utf-8");
                            log.info("修改前"+bodyString);//打印请求参数
                            JSONObject jsonObject = JSON.parseObject(bodyString);
                            jsonObject.put("ssyCode",123);
                            bytes= jsonObject.toString().getBytes();
                            String bodyStringNew = new String(bytes, "utf-8");
                            log.info("修改后"+bodyStringNew);//打印请求参数
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        //释放内存
                        DataBufferUtils.release(dataBuffer);
                        byte[] finalBytes = bytes;
                        Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
                            DataBuffer buffer = exchange.getResponse().bufferFactory()
                                    .wrap(finalBytes);
                            return Mono.just(buffer);
                        });

                        ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(
                                exchange.getRequest()) {
                            @Override
                            public Flux<DataBuffer> getBody() {
                                return cachedFlux;
                            }
                        };
                        return chain.filter(exchange.mutate().request(mutatedRequest)
                                .build());
                    });
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -99;
    }

}
