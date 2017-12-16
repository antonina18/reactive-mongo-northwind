package sowa.domain.places.territories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
@EnableWebFlux
class TerritoryRoutesConfiguration {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(TerritoryHandler handler) {
        return nest(path("/territories"),
                route(
                        GET("/{id}")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGetTerritory)
                .andRoute(
                        GET("")
                                .and(accept(APPLICATION_JSON)),
                        handler::handleGetAllTerritories));
    }

}
