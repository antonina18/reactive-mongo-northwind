package sowa.domain.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
class ProductRoutesConfiguration {

    @Bean
    public RouterFunction<ServerResponse> productRouterFunction(ProductHandler handler) {
        return nest(path("/products"),
                route(
                        GET("")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGetAll)
                 .andRoute(
                        POST("")
                                .and(contentType(APPLICATION_JSON)),
                        handler::handlePost)
                .andRoute(
                        GET("/search")
                                .and(accept(APPLICATION_JSON))
                                .and(queryParam("supplierCountry", e -> !e.isEmpty())),
                        handler::findGetAllBySupplierCountry)
                .andRoute(
                        GET("/{id}")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGet)
                .andRoute(
                        PUT("/{id}")
                                 .and(contentType(APPLICATION_JSON)),
                         handler::handlePut)
                 .andRoute(
                         DELETE("/{id}")
                                  .and(contentType(APPLICATION_JSON)),
                         handler::handleDelete)
               );
    }

}
