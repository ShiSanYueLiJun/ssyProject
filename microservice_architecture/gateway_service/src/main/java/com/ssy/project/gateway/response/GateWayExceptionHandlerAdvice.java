package com.ssy.project.gateway.response;

import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.ssy.project.common.PageResultUtil;
import com.ssy.project.common.ResultCodeEnum;
import com.ssy.project.common.ResultModel;
import io.netty.channel.ConnectTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.security.SignatureException;

/**
 * @author LiJun
 * @date 2022-01-11 11:08
 */
@Slf4j
@Component
public class GateWayExceptionHandlerAdvice {


    /**
     * 统一 异常
     *
     * @param throwable
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResultModel handle(Throwable throwable) {
        String msg = null;
        if (throwable instanceof SignatureException) {
            return signHandle((SignatureException) throwable);
        } else if (throwable instanceof NotFoundException) {
            return notFoundHandle((NotFoundException) throwable);
        } else if (throwable instanceof ResponseStatusException) {
            return handle((ResponseStatusException) throwable);
        } else if (throwable instanceof ConnectTimeoutException) {
            return timeoutHandle((ConnectTimeoutException) throwable);
        } else  if (throwable instanceof FlowException) {
            msg = "接口被限流了";
        } else if (throwable instanceof DegradeException) {
            msg = "降级了";
        } else if (throwable instanceof ParamFlowException) {
            msg = "热点参数限流";
        } else if (throwable instanceof SystemBlockException) {
            msg = "系统规则（负载/...不满足要求）";
        } else if (throwable instanceof AuthorityException) {
            msg = "授权规则不通过";
        } else {
            return PageResultUtil.fail(ResultCodeEnum.UNKNOWN,"系统异常");
        }
        return PageResultUtil.fail(ResultCodeEnum.UNKNOWN,msg);
    }

    /**
     * 401 校验 异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {SignatureException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultModel signHandle(SignatureException ex) {
        log.error("SignatureException:{}", ex.getMessage());
        return PageResultUtil.fail(ResultCodeEnum.VERIFY_EXCEPTION,"检验异常:"+ex.getMessage());
    }

    /**
     * 404 服务未找到 异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultModel notFoundHandle(NotFoundException ex) {
        log.error("not found exception:{}", ex.getMessage());
        return PageResultUtil.fail(ResultCodeEnum.NOT_FOUND_EXCEPTION,"系统异常"+ex.getMessage());
    }

    /**
     * 500   其他服务 异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {ResponseStatusException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultModel handle(ResponseStatusException ex) {
        log.error("ResponseStatusException:{}", ex.getMessage());
        return PageResultUtil.fail(ResultCodeEnum.UNKNOWN,"系统异常"+ex.getMessage());
    }

    /**
     * 502 错误网关 异常
     *
     * @param ex
     * @return
     */
//    @ExceptionHandler(value = {GateWayException.class})
//    @ResponseStatus(HttpStatus.BAD_GATEWAY)
//    public ResultModel badGatewayHandle(GateWayException ex) {
//        log.error("badGateway exception:{}", ex.getMessage());
//        return PageResultUtil.fail(ResultCodeEnum.UNKNOWN,"系统异常"+ex.getMessage());
//    }


    /**
     * 504 网关超时 异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {ConnectTimeoutException.class})
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    public ResultModel timeoutHandle(ConnectTimeoutException ex) {
        log.error("connect timeout exception:{}", ex.getMessage());
        return PageResultUtil.fail(ResultCodeEnum.TIMEOUT_EXCEPTION,"系统异常"+ex.getMessage());
    }


    @ExceptionHandler(value = {ArithmeticException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultModel arithmeticException(ArithmeticException ex) {
        log.error("connect timeout exception:{}", ex.getMessage());
        return PageResultUtil.fail(ResultCodeEnum.FAIL,"算数异常"+ex.getMessage());
    }

}
