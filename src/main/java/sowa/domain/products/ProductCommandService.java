package sowa.domain.products;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductCommandService {

    private final ProductRepository repository;

    public ProductCommandService(ProductRepository repository) {
        this.repository = repository;
    }

    protected Flux<Product> insertAll(Flux<Product> product) {
        return repository.insert(product);
    }

}
