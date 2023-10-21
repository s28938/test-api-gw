package pl.pbak.demo.testapigw.configuration

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RoutesConfig {

    @Bean
    fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? {
        return builder.routes()
                .route { p: PredicateSpec ->
                    p
                            .path("/v1/test/uuid")
                            .filters { f: GatewayFilterSpec -> f.addRequestHeader("custom-header", "test-value") }
                            .uri("http://test-app:8080")
                }
                .route { p: PredicateSpec ->
                    p
                            .path("/v1/test/uuid-error")
                            .filters { f: GatewayFilterSpec -> f.addRequestHeader("custom-header", "test-value") }
                            .uri("http://test-app:8080")
                }
                .route { p: PredicateSpec ->
                    p
                            .path("/v1/test/date-time")
                            .filters { f: GatewayFilterSpec -> f.addRequestHeader("custom-header", "test-value") }
                            .uri("http://test-app:8080")
                }
                .build()
    }
}