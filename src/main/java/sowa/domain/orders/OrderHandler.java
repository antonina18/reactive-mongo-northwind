package sowa.domain.orders;


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
public class OrderHandler {

    private final OrderQueryService queryService;
    private final OrderCommandService commandService;

    public OrderHandler(OrderQueryService queryService, OrderCommandService commandService) {
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
        Flux<Order> data = queryService.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(data, Order.class);
    }

    public Mono<ServerResponse> findAllByShipName(ServerRequest request) {
        Flux<Order> data = queryService
                .findAllByShipName(request
                        .queryParam("shipName")
                        .orElseThrow(IllegalArgumentException::new));
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(data, Order.class);
    }

    public Mono<ServerResponse> handlePost(ServerRequest request) {
        Mono<Order> order = request.bodyToMono(Order.class);
        return ServerResponse.ok().body(commandService.insert(order), Order.class);
    }

    public Mono<ServerResponse> handleDelete(ServerRequest request) {
        commandService.delete(request.pathVariable("id"));
        return ServerResponse.ok().build();

    }

    public Mono<ServerResponse> handlePut(ServerRequest request) {
        Mono<Order> order = request.bodyToMono(Order.class);
        return order
                .flatMap(commandService::saveOrUpdate)
                .flatMap(updated -> ok().body(Mono.just(updated), Order.class))
                .switchIfEmpty(notFound().build());
    }
}
