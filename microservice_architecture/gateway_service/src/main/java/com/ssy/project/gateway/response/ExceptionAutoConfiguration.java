package com.ssy.project.gateway.response;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

/**
 * @author LiJun
 * @date 2022-01-11 11:10
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
@ConditionalOnClass(WebFluxConfigurer.class)
@AutoConfigureBefore(WebFluxAutoConfiguration.class)
@EnableConfigurationProperties({ServerProperties.class, ResourceProperties.class})
public class ExceptionAutoConfiguration {

    private ServerProperties serverProperties;

    private ApplicationContext applicationContext;

    private ResourceProperties resourceProperties;

    private List<ViewResolver> viewResolvers;

    private ServerCodecConfigurer serverCodecConfigurer;

    public ExceptionAutoConfiguration(ServerProperties serverProperties,
                                      ResourceProperties resourceProperties,
                                      ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                      ServerCodecConfigurer serverCodecConfigurer,
                                      ApplicationContext applicationContext) {
        this.serverProperties = serverProperties;
        this.applicationContext = applicationContext;
        this.resourceProperties = resourceProperties;
        this.viewResolvers = viewResolversProvider
                .getIfAvailable(() -> Collections.emptyList());
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)  // 要比 ErrorWebFluxAutoConfiguration 小，表示其优先调用
    public ErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes) {
        // 注入自己的 CustomErrorWebExceptionHandler 处理类
        DefaultErrorWebExceptionHandler exceptionHandler = new CustomErrorWebExceptionHandler(
                errorAttributes, this.resourceProperties,
                this.serverProperties.getError(), this.applicationContext);
        exceptionHandler.setViewResolvers(this.viewResolvers);
        exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }
}
