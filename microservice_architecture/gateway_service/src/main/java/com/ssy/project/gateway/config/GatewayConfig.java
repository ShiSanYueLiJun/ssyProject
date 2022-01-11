//package com.ssy.project.gateway.config;
//
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
//import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
//import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//
///**
// * @author LiJun
// * @date 2022-01-11 09:19
// */
//@Configuration
//public class GatewayConfig {
//
//    @PostConstruct
//    public void init()
//    {
//        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
//            @Override
//            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable ex) {
//
//                // 自定义异常处理
//                HashMap<String, String> map = new HashMap<>();
//                String msg = null;
//                if (ex instanceof FlowException) {
//                    msg = "接口被限流了";
//                } else if (ex instanceof DegradeException) {
//                    msg = "降级了";
//                } else if (ex instanceof ParamFlowException) {
//                    msg = "热点参数限流";
//                } else if (ex instanceof SystemBlockException) {
//                    msg = "系统规则（负载/...不满足要求）";
//                } else if (ex instanceof AuthorityException) {
//                    msg = "授权规则不通过";
//                }
//                map.put("code", "10099");
//                map.put("message", msg);
////                map.put("message", "服务器忙，请稍后再试！");
//
//                return ServerResponse.status(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(BodyInserters.fromValue(map));
//            }
//        };
//
//        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
//    }
//}
