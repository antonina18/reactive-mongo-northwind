package sowa.domain.products;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class SupplierHandler {

    private final SupplierQueryService queryService;
    private final SupplierCommandService commandService;

    public SupplierHandler(SupplierQueryService queryService, SupplierCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    public Mono<ServerResponse> handleGet(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return queryService.findByID(request.pathVariable("id"))
                .flatMap(territory -> ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(fromObject(territory)))
                .switchIfEmpty(notFound);

    }

    public Mono<ServerResponse> handlePost(ServerRequest request) {
        Mono<Supplier> supplier = request.bodyToMono(Supplier.class);
        return ServerResponse.ok().body(commandService.insert(supplier), Supplier.class);
    }

    public Mono<ServerResponse> handleGetAll(ServerRequest request) {
        Flux<Supplier> data = queryService.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(data, Supplier.class);
    }

    public Mono<ServerResponse> findAllByCity(ServerRequest request) {
        Flux<Supplier> data = queryService
                .findAllByCity(request
                        .queryParam("city")
                        .orElseThrow(IllegalArgumentException::new));
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(data, Supplier.class);
    }

    public Mono<ServerResponse> handleDelete(ServerRequest request) {
        commandService.delete(request.pathVariable("id"));
        return ServerResponse.ok().build();

    }

    public Mono<ServerResponse> handlePut(ServerRequest request) {
        Mono<Supplier> supplier = request.bodyToMono(Supplier.class);
        return supplier
                .flatMap(commandService::saveOrUpdate)
                .flatMap(updated -> ok().body((Mono.just(updated)), Supplier.class))
                .switchIfEmpty(notFound().build());
    }
}
