package sowa.domain.products;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

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

    public Mono<ServerResponse> handlePostAll(ServerRequest request) {
        Flux<Product> products = request.bodyToFlux(Product.class);
        return ServerResponse.ok().body(commandService.insertAll(products), Product.class);
    }

    public Mono<ServerResponse> findGetAllBySupplierCountry(ServerRequest request) {
        Flux<Product> products = queryService
                .findAllBySupplierCountry(request
                        .queryParam("search")
                        .orElseThrow(IllegalArgumentException::new));
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(products, Product.class);
    }


}
