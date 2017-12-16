package sowa.domain.places.regions;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class RegionHandler {

    private final RegionQueryService queryService;

    public RegionHandler(RegionQueryService queryService) {
        this.queryService = queryService;
    }

    public Mono<ServerResponse> handleGetRegionByDescription(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return queryService.findByDescription(request.pathVariable("description"))
                .flatMap(territory -> ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(fromObject(territory)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> handleGetAllRegions(ServerRequest serverRequest) {
        Flux<Region> people = queryService.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Region.class);
    }

}
