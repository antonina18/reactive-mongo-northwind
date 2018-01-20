package sowa.domain.orders.shipper;


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
public class ShipperHandler {

    private final ShipperQueryService queryService;
    private final ShipperCommandService commandService;

    public ShipperHandler(ShipperQueryService queryService, ShipperCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    public Mono<ServerResponse> handleGet(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return queryService.findByID(request.pathVariable("id"))
                .flatMap(data -> {
                    System.out.println(data.toString());
                    return ServerResponse.ok()
                            .contentType(APPLICATION_JSON)
                            .body(fromObject(data));
                })
                .switchIfEmpty(notFound);

    }

    public Mono<ServerResponse> handleGetAll(ServerRequest request) {
        Flux<Shipper> data = queryService.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(data, Shipper.class);
    }

    public Mono<ServerResponse> handlePost(ServerRequest request) {
        Mono<Shipper> shipper = request.bodyToMono(Shipper.class);
        return ServerResponse.ok().body(commandService.insert(shipper), Shipper.class);
    }

    public Mono<ServerResponse> handleDelete(ServerRequest request) {
        commandService.delete(request.pathVariable("id"));
        return ServerResponse.ok().build();

    }

    public Mono<ServerResponse> handlePut(ServerRequest request) {
        Mono<Shipper> shipper = request.bodyToMono(Shipper.class);
        return shipper
                .flatMap(commandService::saveOrUpdate)
                .flatMap(updated -> ok().body(Mono.just(updated), Shipper.class))
                .switchIfEmpty(notFound().build());
    }
}
