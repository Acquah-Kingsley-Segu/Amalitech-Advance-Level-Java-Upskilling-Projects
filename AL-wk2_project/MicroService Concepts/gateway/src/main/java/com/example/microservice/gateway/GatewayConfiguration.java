package com.example.microservice.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.*;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.*;

@Configuration
public class GatewayConfiguration {
    @Value("${user-service}")
    String userService;

    @Bean
    public RouterFunction<ServerResponse> gatewayRoutesDefinition() {
        return route(userService).GET("/users", http(userService)).build()
                .and(
                        route(userService).GET("/user", http(userService)).build());
    }
}
