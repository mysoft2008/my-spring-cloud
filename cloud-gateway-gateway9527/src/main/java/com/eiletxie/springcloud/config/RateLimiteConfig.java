package com.eiletxie.springcloud.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @Author EiletXie
 * @Since 2020/3/12 15:01
 */
@Configuration
public class RateLimiteConfig {

    @Bean
    public KeyResolver hostAddressKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }

//    /**
//     * 根据请求IP限流
//     * @return
//     */
//    @Bean
//    public KeyResolver ipKeyResolver() {
//        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
//    }
//
//    /**
//     * 根据请求参数中的userId进行限流
//     * 请求地址写法：http://localhost:8801/rate/123?userId=lisi
//     * @return
//     */
//    @Bean
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("userId")));
//    }
}
