package sowa.domain.orders.customers;


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
public class CustomerHandler {

    private final CustomerQueryService queryService;
    private final CustomerCommandService commandService;

    public CustomerHandler(CustomerQueryService queryService, CustomerCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    public Mono<ServerResponse> handleGet(ServerRequest request) {
        Mono<ServerResponse> notFound = notFound().build();

        return queryService.findByID(request.pathVariable("id"))
                .flatMap(data -> {
                    System.out.println(data.toString());
                    return ok()
                            .contentType(APPLICATION_JSON)
                            .body(fromObject(data));
                })
                .switchIfEmpty(notFound);

    }

    public Mono<ServerResponse> handleGetAll(ServerRequest request) {
        Flux<Customer> data = queryService.findAll();
        return ok().contentType(APPLICATION_JSON).body(data, Customer.class);
    }

    public Mono<ServerResponse> handlePost(ServerRequest request) {
        Mono<Customer> customer = request.bodyToMono(Customer.class);
        return ok().body(commandService.insert(customer), Customer.class);
    }

    public Mono<ServerResponse> handleDelete(ServerRequest request) {
        commandService.delete(request.pathVariable("id"));
        return ok().build();

    }

    public Mono<ServerResponse> handlePut(ServerRequest request) {
        Mono<Customer> customer = request.bodyToMono(Customer.class);
        return customer
                .flatMap(commandService::saveOrUpdate)
                .flatMap(updated -> ok().body(Mono.just(updated), Customer.class))
                .switchIfEmpty(notFound().build());
    }
}
