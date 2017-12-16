package sowa.domain.products;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class ProductQueryService {

    private final ProductRepository repository;

    public ProductQueryService(ProductRepository repository) {
        this.repository = repository;
    }

    protected Mono<Product> findByID(String id) {
        return repository.findById(id);
    }

    protected Flux<Product> findAll() {
        return repository.findAll();
    }

    protected Flux<Product> findAllBySupplierCountry(String search) {
        return repository.findAllBySupplierCountry(search);
    }
}
