package sowa.domain.products;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class SupplierQueryService {

    private final SupplierRepository repository;

    public SupplierQueryService(SupplierRepository repository) {
        this.repository = repository;
    }

    protected Mono<Supplier> findByID(String id) {
        return repository.findById(id);
    }

    protected Flux<Supplier> findAll() {
        return repository.findAll();
    }

}
