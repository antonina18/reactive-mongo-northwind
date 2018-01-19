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
public class ProductHandler {

    private final ProductQueryService queryService;
    private final ProductCommandService commandService;

    public ProductHandler(ProductQueryService queryService, ProductCommandService commandService) {
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

    public Mono<ServerResponse> handleGetAll(ServerRequest request) {
        Flux<Product> products = queryService.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(products, Product.class);
    }

    public Mono<ServerResponse> handlePost(ServerRequest request) {
        Mono<Product> product = request.bodyToMono(Product.class);
//        order.subscribe(o -> System.out.println(o.toString()));
        return ServerResponse.ok().body(commandService.insert(product), Product.class);
    }

    public Mono<ServerResponse> handlePostAll(ServerRequest request) {
        Flux<Product> products = request.bodyToFlux(Product.class);
        return ServerResponse.ok().body(commandService.insertAll(products), Product.class);
    }

    public Mono<ServerResponse> findGetAllBySupplierCountry(ServerRequest request) {
        Flux<Product> products = queryService
                .findAllBySupplierCountry(request
                        .queryParam("supplierCountry")
                        .orElseThrow(IllegalArgumentException::new));
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(products, Product.class);
    }

    public Mono<ServerResponse> handleDelete(ServerRequest request) {
        commandService.delete(request.pathVariable("id"));
        return ServerResponse.ok().build();

    }

    public Mono<ServerResponse> handlePut(ServerRequest request) {
        final Mono<Product> product = queryService.findByID(request.pathVariable("id"));

        return product
                .flatMap(c -> ok().body(commandService.save(product), Product.class))
                .switchIfEmpty(notFound().build());
    }
}
