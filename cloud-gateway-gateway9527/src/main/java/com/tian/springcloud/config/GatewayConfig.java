package com.tian.springcloud.config;

import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author tian
 * @date 2020/8/2
 */
@Configuration
public class GatewayConfig {
    ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, 8, 3, 10, 20, 0, 0, ZoneId.systemDefault());
    AsyncPredicate<ServerWebExchange> predicate;
    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("payment_routh_baidu", r -> r
                .path("/payment/get/**").and()
                .after(zonedDateTime)
                .uri("lb://CLOUD-PAYMENT-SERVICE"));

        routes.route("payment_routh_springcloud",r->r
                .path("/payment/lb/**").and()
                .cookie("username", "tian").and()
                .header("header", "tian").and()
                .method("GET").and()
                .query("username","\\d+")
                .uri("lb://CLOUD-PAYMENT-SERVICE"));


        return routes.build();
    }
}
