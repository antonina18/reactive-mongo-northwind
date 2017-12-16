package sowa.domain.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
class ProductRoutesConfiguration {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(ProductHandler handler) {
        return nest(path("/products"),
                route(
                        GET("/{id}")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGet)
                .andRoute(
                        GET("")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGetAll)
                .andRoute(
                        POST("")
                                .and(contentType(APPLICATION_JSON)),
                        handler::handlePostAll)
                .andRoute(
                        GET("/by-supplier-country")
                                .and(accept(APPLICATION_JSON))
                                .and(queryParam("search", e -> !e.isEmpty())),
                        handler::findGetAllBySupplierCountry));
    }

}