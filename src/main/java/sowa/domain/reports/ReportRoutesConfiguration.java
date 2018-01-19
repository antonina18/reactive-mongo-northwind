package sowa.domain.reports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
class ReportRoutesConfiguration {

    @Bean
    public RouterFunction<?> reportRouterFunction(ReportHandler handler) {
        return nest(path("/report"),
                route(
                        GET("")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGetReport)
               );
    }

}
