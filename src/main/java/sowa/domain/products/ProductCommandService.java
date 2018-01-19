package sowa.domain.products;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductCommandService {

    private final ProductRepository repository;

    public ProductCommandService(ProductRepository repository) {
        this.repository = repository;
    }

    protected Flux<Product> insertAll(Flux<Product> product) {
        return repository.insert(product);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    public Flux<Product> insert(Mono<Product> product) {
        return repository.insert(product);
    }

    public Mono<Product> save(Mono<Product> product) {
        return repository.save(product.block());
    }
}
