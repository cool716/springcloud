package com.wistron.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springCloud
 * @description:
 * @author: Cool
 * @create: 2021-01-13 10:38
 **/
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator consumerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_wistron",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return  routes.build();
    }
}
