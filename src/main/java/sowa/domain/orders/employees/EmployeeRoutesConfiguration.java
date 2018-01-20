package sowa.domain.orders.employees;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
class EmployeeRoutesConfiguration {

    @Bean
    public RouterFunction<ServerResponse> employeeRouterFunction(EmployeeHandler handler) {
        return nest(path("/employees"),
                route(
                        GET("")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGetAll)
                .andRoute(
                        GET("/{id}")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGet)
                .andRoute(
                        POST("")
                                .and(contentType(APPLICATION_JSON)),
                        handler::handlePost)
                .andRoute(
                         PUT("")
                                 .and(contentType(APPLICATION_JSON)),
                         handler::handlePut)
                .andRoute(
                        DELETE("/{id}")
                                .and(contentType(APPLICATION_JSON)),
                        handler::handleDelete)
               );
    }

}
