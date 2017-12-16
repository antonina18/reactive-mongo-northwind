package sowa.domain.places.territories;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class TerritoryHandler {

    private final TerritoryQueryService queryService;

    public TerritoryHandler(TerritoryQueryService queryService) {
        this.queryService = queryService;
    }

    public Mono<ServerResponse> handleGetTerritory(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return queryService.findByID(Integer.valueOf(request.pathVariable("id")))
                .flatMap(territory -> ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(fromObject(territory)))
                .switchIfEmpty(notFound);

    }

    public Mono<ServerResponse> handleGetAllTerritories(ServerRequest serverRequest) {
        Flux<Territory> people = queryService.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Territory.class);
    }

}

//    public Mono<ServerResponse> getBook(ServerRequest request) {
//        return repository.getBook(request.pathVariable("id"))
//                .then(book -> ServerResponse.ok()
//                        .contentType(APPLICATION_JSON)
//                        .body(fromObject(book)))
//                .otherwiseIfEmpty(ServerResponse.notFound().build());
//    }
