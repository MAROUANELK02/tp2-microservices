package com.marouaneLK.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc,
															DiscoveryLocatorProperties rdp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, rdp);
	}

	//@Bean
	RouteLocator routeLocator1(RouteLocatorBuilder builder) {
		return builder.routes()
				.route((r) -> r.path("/users/**")
						.filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8081"))
				.route((r) -> r.path("/inventory/**")
						.filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8082/"))
				.build();
	}

	//@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route((r) -> r.path("/users/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://CUSTOMER-SERVICE"))
				.route((r) -> r.path("/inventory/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://INVENTORY-SERVICE"))
				.build();
	}
}
