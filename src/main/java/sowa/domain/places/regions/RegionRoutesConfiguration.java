package sowa.domain.places.regions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
class RegionRoutesConfiguration {

    @Bean
    public RouterFunction<?> regionRouterFunction(RegionHandler handler) {
        return nest(path("/regions"),
                route(
                        GET("")
                                .and(accept(APPLICATION_JSON))
                                .and(queryParam("description", s -> !s.isEmpty())),
                        handler::handleGetRegionByDescription)
                .andRoute(
                        GET("")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGetAllRegions));
    }

}
